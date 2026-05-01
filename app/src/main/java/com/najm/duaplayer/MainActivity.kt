package com.najm.duaplayer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.najm.duaplayer.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var audioManager: AudioManager
    private lateinit var duaAdapter: ArrayAdapter<String>

    private var mediaPlayer: MediaPlayer? = null
    private var audioFocusRequest: AudioFocusRequest? = null
    private var visibleDuas: List<Dua> = emptyList()
    private var selectedSectionIndex = -1
    private var selectedIndex = -1
    private var playbackState = PlaybackState.Idle
    private var repeatEnabled = false
    private var playWhenPrepared = false
    private var userIsSeeking = false
    private var noisyReceiverRegistered = false

    private val progressHandler = Handler(Looper.getMainLooper())
    private val progressRunnable = object : Runnable {
        override fun run() {
            updateProgressFromPlayer()
            if (playbackState == PlaybackState.Playing) {
                progressHandler.postDelayed(this, PROGRESS_UPDATE_DELAY_MS)
            }
        }
    }

    private val audioFocusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        when (focusChange) {
            AudioManager.AUDIOFOCUS_LOSS -> {
                pauseAudio()
                abandonAudioFocus()
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> pauseAudio()
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> mediaPlayer?.setVolume(DUCK_VOLUME, DUCK_VOLUME)
            AudioManager.AUDIOFOCUS_GAIN -> mediaPlayer?.setVolume(FULL_VOLUME, FULL_VOLUME)
        }
    }

    private val noisyReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == AudioManager.ACTION_AUDIO_BECOMING_NOISY) {
                pauseAudio()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        setupPickers()
        setupControls()
        registerNoisyReceiver()
        selectSection(0)
    }

    private fun setupPickers() {
        val sectionAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            DuaCatalog.sections
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        duaAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            mutableListOf<String>()
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.sectionPicker.adapter = sectionAdapter
        binding.duaPicker.adapter = duaAdapter

        binding.sectionPicker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != selectedSectionIndex) {
                    selectSection(position, autoPlay = playbackState == PlaybackState.Playing)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        binding.duaPicker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != selectedIndex) {
                    selectDua(position, autoPlay = playbackState == PlaybackState.Playing)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }
    }

    private fun setupControls() {
        binding.btnPlayPause.setOnClickListener {
            when (playbackState) {
                PlaybackState.Playing -> pauseAudio()
                PlaybackState.Loading,
                PlaybackState.NoAudio -> Unit
                PlaybackState.Error -> selectDua(selectedIndex.coerceAtLeast(0))
                else -> playAudio()
            }
        }

        binding.btnRestart.setOnClickListener {
            restartAudio()
        }

        binding.btnPrevious.setOnClickListener {
            if (visibleDuas.isEmpty()) return@setOnClickListener
            val previousIndex = if (selectedIndex <= 0) visibleDuas.lastIndex else selectedIndex - 1
            selectDua(previousIndex, autoPlay = playbackState == PlaybackState.Playing)
        }

        binding.btnNext.setOnClickListener {
            playNextDua()
        }

        binding.btnRepeat.setOnClickListener {
            repeatEnabled = !repeatEnabled
            updateRepeatUI()
        }

        binding.progressSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.currentTime.text = formatDuration(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                userIsSeeking = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                userIsSeeking = false
                mediaPlayer?.seekTo(seekBar?.progress ?: 0)
                updateProgressFromPlayer()
            }
        })
    }

    private fun selectSection(index: Int, autoPlay: Boolean = false) {
        if (index !in DuaCatalog.sections.indices) return

        selectedSectionIndex = index
        visibleDuas = DuaCatalog.duasFor(DuaCatalog.sections[index])

        binding.sectionCount.text = getString(R.string.section_count_format, visibleDuas.size)
        duaAdapter.clear()
        duaAdapter.addAll(visibleDuas.map { it.title })
        duaAdapter.notifyDataSetChanged()

        selectedIndex = -1
        selectDua(0, autoPlay = autoPlay)
    }

    private fun selectDua(index: Int, autoPlay: Boolean = false) {
        if (index !in visibleDuas.indices) return

        stopProgressUpdates()
        releasePlayer()
        playWhenPrepared = autoPlay

        selectedIndex = index
        val dua = visibleDuas[index]

        if (binding.duaPicker.selectedItemPosition != index) {
            binding.duaPicker.setSelection(index)
        }

        binding.duaTitle.text = dua.title
        binding.duaCategory.text = dua.section
        binding.duaArabic.text = dua.arabic
        binding.duaTransliteration.text = dua.transliteration
        binding.duaTranslation.text = dua.translation
        binding.duaSource.text = getString(R.string.source_format, dua.source)
        binding.currentTime.text = getString(R.string.time_zero)
        binding.durationTime.text = getString(R.string.time_zero)
        binding.progressSeekBar.progress = 0
        binding.progressSeekBar.max = 0

        preparePlayer(dua)
    }

    private fun preparePlayer(dua: Dua) {
        val audioUrl = dua.audioUrl
        if (audioUrl.isNullOrBlank()) {
            playWhenPrepared = false
            setPlaybackState(PlaybackState.NoAudio)
            return
        }

        setPlaybackState(PlaybackState.Loading)

        try {
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(audioUrl)
                setOnPreparedListener { player ->
                    binding.progressSeekBar.max = player.duration
                    binding.durationTime.text = formatDuration(player.duration)
                    updateProgressFromPlayer()
                    setPlaybackState(PlaybackState.Ready)

                    if (playWhenPrepared) {
                        playWhenPrepared = false
                        playAudio()
                    }
                }
                setOnCompletionListener {
                    handleCompletion()
                }
                setOnErrorListener { _, _, _ ->
                    stopProgressUpdates()
                    playWhenPrepared = false
                    setPlaybackState(PlaybackState.Error)
                    true
                }
                prepareAsync()
            }
        } catch (exception: Exception) {
            releasePlayer()
            playWhenPrepared = false
            setPlaybackState(PlaybackState.Error)
        }
    }

    private fun playAudio() {
        val player = mediaPlayer ?: return
        if (playbackState == PlaybackState.Loading || !requestAudioFocus()) return

        try {
            if (playbackState == PlaybackState.Completed) {
                player.seekTo(0)
            }
            player.start()
            setPlaybackState(PlaybackState.Playing)
            startProgressUpdates()
        } catch (exception: IllegalStateException) {
            setPlaybackState(PlaybackState.Error)
        }
    }

    private fun pauseAudio() {
        val player = mediaPlayer ?: return
        if (playbackState != PlaybackState.Playing) return

        try {
            player.pause()
            setPlaybackState(PlaybackState.Paused)
            stopProgressUpdates()
            abandonAudioFocus()
        } catch (exception: IllegalStateException) {
            setPlaybackState(PlaybackState.Error)
        }
    }

    private fun restartAudio() {
        val player = mediaPlayer ?: return
        try {
            player.seekTo(0)
            updateProgressFromPlayer()
            if (playbackState != PlaybackState.Playing) {
                playAudio()
            }
        } catch (exception: IllegalStateException) {
            setPlaybackState(PlaybackState.Error)
        }
    }

    private fun playNextDua() {
        if (visibleDuas.isEmpty()) return
        val nextIndex = if (selectedIndex >= visibleDuas.lastIndex) 0 else selectedIndex + 1
        selectDua(nextIndex, autoPlay = playbackState == PlaybackState.Playing)
    }

    private fun handleCompletion() {
        stopProgressUpdates()
        abandonAudioFocus()

        if (repeatEnabled) {
            mediaPlayer?.seekTo(0)
            playAudio()
        } else {
            setPlaybackState(PlaybackState.Completed)
            updateProgressFromPlayer()
        }
    }

    private fun requestAudioFocus(): Boolean {
        val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val focusRequest = audioFocusRequest ?: AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .build()
                )
                .setOnAudioFocusChangeListener(audioFocusChangeListener)
                .build()
                .also { audioFocusRequest = it }

            audioManager.requestAudioFocus(focusRequest)
        } else {
            @Suppress("DEPRECATION")
            audioManager.requestAudioFocus(
                audioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN
            )
        }

        return result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    private fun abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioFocusRequest?.let(audioManager::abandonAudioFocusRequest)
        } else {
            @Suppress("DEPRECATION")
            audioManager.abandonAudioFocus(audioFocusChangeListener)
        }
    }

    private fun registerNoisyReceiver() {
        if (noisyReceiverRegistered) return

        val filter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(noisyReceiver, filter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            @Suppress("DEPRECATION")
            registerReceiver(noisyReceiver, filter)
        }
        noisyReceiverRegistered = true
    }

    private fun unregisterNoisyReceiver() {
        if (!noisyReceiverRegistered) return
        unregisterReceiver(noisyReceiver)
        noisyReceiverRegistered = false
    }

    private fun setPlaybackState(state: PlaybackState) {
        playbackState = state

        val canUseAudio = state != PlaybackState.Loading &&
            state != PlaybackState.Error &&
            state != PlaybackState.NoAudio

        binding.loadingIndicator.visibility = if (state == PlaybackState.Loading) View.VISIBLE else View.GONE
        binding.btnPlayPause.isEnabled = state != PlaybackState.Loading && state != PlaybackState.NoAudio
        binding.btnRestart.isEnabled = canUseAudio
        binding.btnRepeat.isEnabled = canUseAudio
        binding.progressSeekBar.isEnabled = canUseAudio
        binding.btnPlayPause.alpha = if (state == PlaybackState.NoAudio) DISABLED_ALPHA else FULL_ALPHA
        binding.btnRestart.alpha = if (canUseAudio) FULL_ALPHA else DISABLED_ALPHA
        binding.btnRepeat.alpha = if (repeatEnabled && canUseAudio) FULL_ALPHA else DISABLED_ALPHA

        binding.btnPlayPause.setImageResource(
            if (state == PlaybackState.Playing) {
                android.R.drawable.ic_media_pause
            } else {
                android.R.drawable.ic_media_play
            }
        )

        binding.statusText.text = when (state) {
            PlaybackState.Idle -> getString(R.string.playback_idle)
            PlaybackState.Loading -> getString(R.string.playback_loading)
            PlaybackState.Ready -> getString(R.string.playback_ready)
            PlaybackState.Playing -> getString(R.string.playback_playing)
            PlaybackState.Paused -> getString(R.string.playback_paused)
            PlaybackState.Completed -> getString(R.string.playback_finished)
            PlaybackState.Error -> getString(R.string.playback_error)
            PlaybackState.NoAudio -> getString(R.string.playback_no_audio)
        }

        binding.btnPlayPause.contentDescription = when (state) {
            PlaybackState.Playing -> getString(R.string.cd_pause)
            PlaybackState.Error -> getString(R.string.cd_retry)
            PlaybackState.NoAudio -> getString(R.string.cd_audio_unavailable)
            else -> getString(R.string.cd_play)
        }
    }

    private fun updateRepeatUI() {
        val audioAvailable = playbackState != PlaybackState.NoAudio && playbackState != PlaybackState.Error
        binding.btnRepeat.alpha = if (repeatEnabled && audioAvailable) FULL_ALPHA else DISABLED_ALPHA
        binding.btnRepeat.contentDescription = if (repeatEnabled) {
            getString(R.string.cd_repeat_on)
        } else {
            getString(R.string.cd_repeat_off)
        }
    }

    private fun startProgressUpdates() {
        stopProgressUpdates()
        progressHandler.post(progressRunnable)
    }

    private fun stopProgressUpdates() {
        progressHandler.removeCallbacks(progressRunnable)
    }

    private fun updateProgressFromPlayer() {
        val player = mediaPlayer ?: return
        try {
            if (!userIsSeeking) {
                binding.progressSeekBar.progress = player.currentPosition
                binding.currentTime.text = formatDuration(player.currentPosition)
            }
        } catch (exception: IllegalStateException) {
            setPlaybackState(PlaybackState.Error)
        }
    }

    private fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        abandonAudioFocus()
    }

    private fun formatDuration(milliseconds: Int): String {
        val totalSeconds = milliseconds.coerceAtLeast(0) / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format(Locale.US, "%d:%02d", minutes, seconds)
    }

    override fun onPause() {
        super.onPause()
        if (playbackState == PlaybackState.Playing) {
            pauseAudio()
        }
    }

    override fun onDestroy() {
        stopProgressUpdates()
        unregisterNoisyReceiver()
        releasePlayer()
        super.onDestroy()
    }

    private enum class PlaybackState {
        Idle,
        Loading,
        Ready,
        Playing,
        Paused,
        Completed,
        Error,
        NoAudio
    }

    private companion object {
        private const val PROGRESS_UPDATE_DELAY_MS = 500L
        private const val DUCK_VOLUME = 0.25f
        private const val FULL_VOLUME = 1f
        private const val FULL_ALPHA = 1f
        private const val DISABLED_ALPHA = 0.45f
    }
}
