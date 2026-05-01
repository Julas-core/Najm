package com.najm.duaplayer

data class Dua(
    val title: String,
    val section: String,
    val arabic: String,
    val transliteration: String,
    val translation: String,
    val source: String,
    val audioUrl: String? = null
)

object DuaCatalog {
    const val MORNING = "Morning"
    const val EVENING = "Evening"
    const val SLEEP_WAKE = "Sleep & Waking"
    const val HOME_OUTSIDE = "Home & Going Out"
    const val MASJID_WUDU = "Masjid & Wudu"
    const val FOOD_DRINK = "Food & Drink"
    const val TRAVEL = "Travel"
    const val WEATHER = "Weather & Nature"
    const val DAILY = "Daily Etiquette"
    const val HEALTH = "Health & Protection"
    const val QURANIC = "Quranic Duas"
    const val COMPREHENSIVE = "Comprehensive"

    val sections = listOf(
        MORNING,
        EVENING,
        SLEEP_WAKE,
        HOME_OUTSIDE,
        MASJID_WUDU,
        FOOD_DRINK,
        TRAVEL,
        WEATHER,
        DAILY,
        HEALTH,
        QURANIC,
        COMPREHENSIVE
    )

    val duas = listOf(
        Dua(
            title = "Morning reliance",
            section = MORNING,
            arabic = "يَا حَيُّ يَا قَيُّومُ بِرَحْمَتِكَ أَسْتَغِيثُ، أَصْلِحْ لِي شَأْنِي كُلَّهُ، وَلَا تَكِلْنِي إِلَى نَفْسِي طَرْفَةَ عَيْنٍ",
            transliteration = "Yaa Hayyu yaa Qayyoomu, bi rahmatika astagheeth, aslih lee sha'nee kullahu, wa laa takilnee ilaa nafsee tarfata 'ayn.",
            translation = "O Ever-Living, O Sustainer, by Your mercy I seek help. Set right all of my affairs, and do not leave me to myself even for the blink of an eye.",
            source = "Hisn al-Muslim; Al-Hakim 1/545",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/07/hisn-al-muslim-audio-dua-88.mp3"
        ),
        Dua(
            title = "The master prayer for forgiveness",
            section = MORNING,
            arabic = "اللَّهُمَّ أَنْتَ رَبِّي لَا إِلَهَ إِلَّا أَنْتَ، خَلَقْتَنِي وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوءُ بِذَنْبِي، فَاغْفِرْ لِي فَإِنَّهُ لَا يَغْفِرُ الذُّنُوبَ إِلَّا أَنْتَ",
            transliteration = "Allahumma anta rabbee laa ilaaha illaa ant, khalaqtanee wa ana 'abduk, wa ana 'alaa 'ahdika wa wa'dika mastata't, a'oodhu bika min sharri maa sana't, aboo'u laka bini'matika 'alayya, wa aboo'u bidhanbee, faghfir lee fa innahu laa yaghfirudh-dhunooba illaa ant.",
            translation = "O Allah, You are my Lord. There is no god but You. You created me and I am Your servant. I hold to Your covenant as much as I can. I seek refuge in You from the evil I have done. I acknowledge Your favor upon me and I acknowledge my sin, so forgive me, for none forgives sins except You.",
            source = "Sahih al-Bukhari 6306"
        ),
        Dua(
            title = "Nothing can harm with Allah's name",
            section = MORNING,
            arabic = "بِسْمِ اللهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ، وَهُوَ السَّمِيعُ الْعَلِيمُ",
            transliteration = "Bismillaahil-ladhee laa yadurru ma'a ismihi shay'un fil-ardi wa laa fis-samaa', wa huwas-samee'ul-'aleem.",
            translation = "In the name of Allah, with whose name nothing on earth or in heaven can cause harm, and He is the All-Hearing, the All-Knowing.",
            source = "Abu Dawud 5088; At-Tirmidhi 3388"
        ),
        Dua(
            title = "Content with Allah as Lord",
            section = MORNING,
            arabic = "رَضِيتُ بِاللهِ رَبًّا، وَبِالْإِسْلَامِ دِينًا، وَبِمُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ نَبِيًّا",
            transliteration = "Radeetu billaahi rabban, wa bil-Islaami deenan, wa bi Muhammadin sallallaahu 'alayhi wa sallama nabiyyan.",
            translation = "I am pleased with Allah as Lord, with Islam as religion, and with Muhammad, peace and blessings be upon him, as Prophet.",
            source = "Abu Dawud 5072; At-Tirmidhi 3389"
        ),
        Dua(
            title = "Allah is sufficient for me",
            section = MORNING,
            arabic = "حَسْبِيَ اللهُ لَا إِلَهَ إِلَّا هُوَ، عَلَيْهِ تَوَكَّلْتُ، وَهُوَ رَبُّ الْعَرْشِ الْعَظِيمِ",
            transliteration = "Hasbiyallaahu laa ilaaha illaa huwa, 'alayhi tawakkaltu, wa huwa rabbul-'arshil-'adheem.",
            translation = "Allah is sufficient for me. There is no god but Him. In Him I place my trust, and He is the Lord of the mighty Throne.",
            source = "Quran 9:129; morning and evening remembrance"
        ),
        Dua(
            title = "We have entered the morning",
            section = MORNING,
            arabic = "أَصْبَحْنَا وَأَصْبَحَ الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ",
            transliteration = "Asbahnaa wa asbahal-mulku lillaah, walhamdu lillaah, laa ilaaha illallaahu wahdahu laa shareeka lah.",
            translation = "We have entered the morning and all sovereignty belongs to Allah. Praise is for Allah. There is no god but Allah alone, without partner.",
            source = "Sahih Muslim 2723"
        ),
        Dua(
            title = "Morning life and return",
            section = MORNING,
            arabic = "اللَّهُمَّ بِكَ أَصْبَحْنَا، وَبِكَ أَمْسَيْنَا، وَبِكَ نَحْيَا، وَبِكَ نَمُوتُ، وَإِلَيْكَ النُّشُورُ",
            transliteration = "Allahumma bika asbahnaa, wa bika amsaynaa, wa bika nahyaa, wa bika namoot, wa ilaykan-nushoor.",
            translation = "O Allah, by You we enter the morning, by You we enter the evening, by You we live, by You we die, and to You is the resurrection.",
            source = "Abu Dawud 5068; At-Tirmidhi 3391"
        ),
        Dua(
            title = "Evening life and return",
            section = EVENING,
            arabic = "اللَّهُمَّ بِكَ أَمْسَيْنَا، وَبِكَ أَصْبَحْنَا، وَبِكَ نَحْيَا، وَبِكَ نَمُوتُ، وَإِلَيْكَ الْمَصِيرُ",
            transliteration = "Allahumma bika amsaynaa, wa bika asbahnaa, wa bika nahyaa, wa bika namoot, wa ilaykal-maseer.",
            translation = "O Allah, by You we enter the evening, by You we enter the morning, by You we live, by You we die, and to You is the return.",
            source = "Abu Dawud 5068; At-Tirmidhi 3391"
        ),
        Dua(
            title = "We have entered the evening",
            section = EVENING,
            arabic = "أَمْسَيْنَا وَأَمْسَى الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ",
            transliteration = "Amsaynaa wa amsal-mulku lillaah, walhamdu lillaah, laa ilaaha illallaahu wahdahu laa shareeka lah.",
            translation = "We have entered the evening and all sovereignty belongs to Allah. Praise is for Allah. There is no god but Allah alone, without partner.",
            source = "Sahih Muslim 2723"
        ),
        Dua(
            title = "Evening protection from laziness and old age",
            section = EVENING,
            arabic = "رَبِّ أَعُوذُ بِكَ مِنَ الْكَسَلِ وَسُوءِ الْكِبَرِ، رَبِّ أَعُوذُ بِكَ مِنْ عَذَابٍ فِي النَّارِ وَعَذَابٍ فِي الْقَبْرِ",
            transliteration = "Rabbi a'oodhu bika minal-kasali wa soo'il-kibar. Rabbi a'oodhu bika min 'adhaabin fin-naari wa 'adhaabin fil-qabr.",
            translation = "My Lord, I seek refuge in You from laziness and the harms of old age. My Lord, I seek refuge in You from punishment in the Fire and punishment in the grave.",
            source = "Sahih Muslim 2723"
        ),
        Dua(
            title = "Evening refuge in created harm",
            section = EVENING,
            arabic = "أَعُوذُ بِكَلِمَاتِ اللهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ",
            transliteration = "A'oodhu bi kalimaatil-laahit-taammaati min sharri maa khalaq.",
            translation = "I seek protection in the perfect words of Allah from the evil of what He has created.",
            source = "Sahih Muslim 2709; At-Tirmidhi 3898",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/07/seeking-refuge-in-the-perfect-words-of-allaah-authentic-dua-com.mp3"
        ),
        Dua(
            title = "Evening surrender to Allah",
            section = EVENING,
            arabic = "اللَّهُمَّ فَاطِرَ السَّمَاوَاتِ وَالْأَرْضِ، عَالِمَ الْغَيْبِ وَالشَّهَادَةِ، رَبَّ كُلِّ شَيْءٍ وَمَلِيكَهُ، أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا أَنْتَ",
            transliteration = "Allahumma faatiras-samaawaati wal-ard, 'aalimal-ghaybi wash-shahaadah, rabba kulli shay'in wa maleekah, ash-hadu an laa ilaaha illaa ant.",
            translation = "O Allah, Creator of the heavens and earth, Knower of the unseen and seen, Lord and King of all things, I bear witness that there is no god but You.",
            source = "Abu Dawud 5067; At-Tirmidhi 3392"
        ),
        Dua(
            title = "Before sleeping",
            section = SLEEP_WAKE,
            arabic = "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا",
            transliteration = "Bismika Allahumma amootu wa ahyaa.",
            translation = "In Your name, O Allah, I die and I live.",
            source = "Sahih al-Bukhari 6324"
        ),
        Dua(
            title = "After waking up",
            section = SLEEP_WAKE,
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا، وَإِلَيْهِ النُّشُورُ",
            transliteration = "Alhamdu lillaahil-ladhee ahyaanaa ba'da maa amaatanaa, wa ilayhin-nushoor.",
            translation = "Praise is for Allah who gave us life after causing us to die, and to Him is the resurrection.",
            source = "Sahih al-Bukhari 6312"
        ),
        Dua(
            title = "Protection before sleep",
            section = SLEEP_WAKE,
            arabic = "اللَّهُمَّ قِنِي عَذَابَكَ يَوْمَ تَبْعَثُ عِبَادَكَ",
            transliteration = "Allahumma qinee 'adhaabaka yawma tab'athu 'ibaadak.",
            translation = "O Allah, protect me from Your punishment on the Day You resurrect Your servants.",
            source = "Abu Dawud 5045; At-Tirmidhi 3398"
        ),
        Dua(
            title = "When startled at night",
            section = SLEEP_WAKE,
            arabic = "أَعُوذُ بِكَلِمَاتِ اللهِ التَّامَّةِ مِنْ غَضَبِهِ وَعِقَابِهِ، وَشَرِّ عِبَادِهِ، وَمِنْ هَمَزَاتِ الشَّيَاطِينِ وَأَنْ يَحْضُرُونِ",
            transliteration = "A'oodhu bi kalimaatil-laahit-taammati min ghadabihi wa 'iqaabihi, wa sharri 'ibaadihi, wa min hamazaatish-shayaateeni wa an yahduroon.",
            translation = "I seek refuge in the perfect words of Allah from His anger and punishment, from the evil of His servants, and from the promptings and presence of devils.",
            source = "Abu Dawud 3893; At-Tirmidhi 3528"
        ),
        Dua(
            title = "Turning over at night",
            section = SLEEP_WAKE,
            arabic = "لَا إِلَهَ إِلَّا اللهُ الْوَاحِدُ الْقَهَّارُ، رَبُّ السَّمَاوَاتِ وَالْأَرْضِ وَمَا بَيْنَهُمَا الْعَزِيزُ الْغَفَّارُ",
            transliteration = "Laa ilaaha illallaahul-waahidul-qahhaar, rabbus-samaawaati wal-ardi wa maa baynahumal-'azeezul-ghaffaar.",
            translation = "There is no god but Allah, the One, the Subduer, Lord of the heavens and earth and what is between them, the Mighty, the Forgiving.",
            source = "Al-Hakim 1/540; Hisn al-Muslim"
        ),
        Dua(
            title = "Leaving the home",
            section = HOME_OUTSIDE,
            arabic = "بِسْمِ اللهِ، تَوَكَّلْتُ عَلَى اللهِ، وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللهِ",
            transliteration = "Bismillaah, tawakkaltu 'alallaah, wa laa hawla wa laa quwwata illaa billaah.",
            translation = "In the name of Allah, I place my trust in Allah, and there is no power nor strength except through Allah.",
            source = "Abu Dawud 5095; At-Tirmidhi 3426"
        ),
        Dua(
            title = "Protection when leaving home",
            section = HOME_OUTSIDE,
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ أَنْ أَضِلَّ أَوْ أُضَلَّ، أَوْ أَزِلَّ أَوْ أُزَلَّ، أَوْ أَظْلِمَ أَوْ أُظْلَمَ، أَوْ أَجْهَلَ أَوْ يُجْهَلَ عَلَيَّ",
            transliteration = "Allahumma innee a'oodhu bika an adilla aw udall, aw azilla aw uzall, aw azlima aw uzlam, aw ajhala aw yujhala 'alayy.",
            translation = "O Allah, I seek refuge in You from going astray or being led astray, from slipping or being made to slip, from wronging or being wronged, and from acting ignorantly or being treated ignorantly.",
            source = "Abu Dawud 5094; At-Tirmidhi 3427"
        ),
        Dua(
            title = "Entering the home",
            section = HOME_OUTSIDE,
            arabic = "بِسْمِ اللهِ وَلَجْنَا، وَبِسْمِ اللهِ خَرَجْنَا، وَعَلَى رَبِّنَا تَوَكَّلْنَا",
            transliteration = "Bismillaahi walajnaa, wa bismillaahi kharajnaa, wa 'alaa rabbinaa tawakkalnaa.",
            translation = "In the name of Allah we enter, in the name of Allah we leave, and upon our Lord we place our trust.",
            source = "Abu Dawud 5096"
        ),
        Dua(
            title = "Returning from travel",
            section = HOME_OUTSIDE,
            arabic = "آيِبُونَ، تَائِبُونَ، عَابِدُونَ، لِرَبِّنَا حَامِدُونَ",
            transliteration = "Aa'iboona, taa'iboona, 'aabidoona, li rabbinaa haamidoon.",
            translation = "We return, repent, worship, and praise our Lord.",
            source = "Sahih al-Bukhari 1797; Sahih Muslim 1344"
        ),
        Dua(
            title = "Entering the marketplace",
            section = HOME_OUTSIDE,
            arabic = "لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، يُحْيِي وَيُمِيتُ، وَهُوَ حَيٌّ لَا يَمُوتُ، بِيَدِهِ الْخَيْرُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ",
            transliteration = "Laa ilaaha illallaahu wahdahu laa shareeka lah, lahul-mulku wa lahul-hamd, yuhyee wa yumeet, wa huwa hayyun laa yamoot, biyadihil-khayr, wa huwa 'alaa kulli shay'in qadeer.",
            translation = "There is no god but Allah alone without partner. His is the dominion and His is the praise. He gives life and causes death, He is Ever-Living and does not die. In His hand is all good, and He is able to do all things.",
            source = "At-Tirmidhi 3428; Ibn Majah 2235"
        ),
        Dua(
            title = "For your family when returning",
            section = HOME_OUTSIDE,
            arabic = "السَّلَامُ عَلَيْنَا وَعَلَى عِبَادِ اللهِ الصَّالِحِينَ",
            transliteration = "As-salaamu 'alaynaa wa 'alaa 'ibaadillaahis-saaliheen.",
            translation = "Peace be upon us and upon the righteous servants of Allah.",
            source = "Sahih al-Bukhari 6328; general greeting remembrance"
        ),
        Dua(
            title = "Entering the masjid",
            section = MASJID_WUDU,
            arabic = "اللَّهُمَّ افْتَحْ لِي أَبْوَابَ رَحْمَتِكَ",
            transliteration = "Allahummaftah lee abwaaba rahmatik.",
            translation = "O Allah, open for me the doors of Your mercy.",
            source = "Sahih Muslim 713"
        ),
        Dua(
            title = "Leaving the masjid",
            section = MASJID_WUDU,
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ فَضْلِكَ",
            transliteration = "Allahumma innee as'aluka min fadlik.",
            translation = "O Allah, I ask You from Your bounty.",
            source = "Sahih Muslim 713"
        ),
        Dua(
            title = "After wudu",
            section = MASJID_WUDU,
            arabic = "أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُولُهُ",
            transliteration = "Ash-hadu an laa ilaaha illallaahu wahdahu laa shareeka lah, wa ash-hadu anna Muhammadan 'abduhu wa rasooluh.",
            translation = "I bear witness that there is no god but Allah alone, without partner, and I bear witness that Muhammad is His servant and Messenger.",
            source = "Sahih Muslim 234"
        ),
        Dua(
            title = "After wudu for repentance",
            section = MASJID_WUDU,
            arabic = "اللَّهُمَّ اجْعَلْنِي مِنَ التَّوَّابِينَ، وَاجْعَلْنِي مِنَ الْمُتَطَهِّرِينَ",
            transliteration = "Allahummaj'alnee minat-tawwaabeen, waj'alnee minal-mutatahhireen.",
            translation = "O Allah, make me among those who constantly repent and make me among those who purify themselves.",
            source = "At-Tirmidhi 55"
        ),
        Dua(
            title = "After the adhan",
            section = MASJID_WUDU,
            arabic = "اللَّهُمَّ رَبَّ هَذِهِ الدَّعْوَةِ التَّامَّةِ، وَالصَّلَاةِ الْقَائِمَةِ، آتِ مُحَمَّدًا الْوَسِيلَةَ وَالْفَضِيلَةَ، وَابْعَثْهُ مَقَامًا مَحْمُودًا الَّذِي وَعَدْتَهُ",
            transliteration = "Allahumma rabba haadhihid-da'watit-taammah, was-salaatil-qaa'imah, aati Muhammadanil-waseelata wal-fadeelah, wab'athhu maqaaman mahmoodanil-ladhee wa'adtah.",
            translation = "O Allah, Lord of this perfect call and established prayer, grant Muhammad the highest station and virtue, and raise him to the praised station You promised him.",
            source = "Sahih al-Bukhari 614"
        ),
        Dua(
            title = "Going to the masjid",
            section = MASJID_WUDU,
            arabic = "اللَّهُمَّ اجْعَلْ فِي قَلْبِي نُورًا، وَفِي لِسَانِي نُورًا، وَفِي سَمْعِي نُورًا، وَفِي بَصَرِي نُورًا",
            transliteration = "Allahummaj'al fee qalbee nooran, wa fee lisaanee nooran, wa fee sam'ee nooran, wa fee basaree nooran.",
            translation = "O Allah, place light in my heart, light on my tongue, light in my hearing, and light in my sight.",
            source = "Sahih al-Bukhari 6316; Sahih Muslim 763"
        ),
        Dua(
            title = "Before eating",
            section = FOOD_DRINK,
            arabic = "بِسْمِ اللهِ",
            transliteration = "Bismillaah.",
            translation = "In the name of Allah.",
            source = "Abu Dawud 3767; At-Tirmidhi 1858"
        ),
        Dua(
            title = "If you forgot to say Bismillah",
            section = FOOD_DRINK,
            arabic = "بِسْمِ اللهِ أَوَّلَهُ وَآخِرَهُ",
            transliteration = "Bismillaahi awwalahu wa aakhirah.",
            translation = "In the name of Allah at its beginning and its end.",
            source = "Abu Dawud 3767; At-Tirmidhi 1858"
        ),
        Dua(
            title = "After eating",
            section = FOOD_DRINK,
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنِي هَذَا، وَرَزَقَنِيهِ، مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍ",
            transliteration = "Alhamdu lillaahil-ladhee at'amanee haadhaa, wa razaqaneehi, min ghayri hawlin minnee wa laa quwwah.",
            translation = "Praise is for Allah who fed me this and provided it for me without any power or strength from me.",
            source = "Abu Dawud 4023; At-Tirmidhi 3458"
        ),
        Dua(
            title = "For one who gave you food",
            section = FOOD_DRINK,
            arabic = "اللَّهُمَّ أَطْعِمْ مَنْ أَطْعَمَنِي، وَاسْقِ مَنْ سَقَانِي",
            transliteration = "Allahumma at'im man at'amanee, wasqi man saqaanee.",
            translation = "O Allah, feed whoever fed me and give drink to whoever gave me drink.",
            source = "Sahih Muslim 2055"
        ),
        Dua(
            title = "For the host",
            section = FOOD_DRINK,
            arabic = "أَفْطَرَ عِنْدَكُمُ الصَّائِمُونَ، وَأَكَلَ طَعَامَكُمُ الْأَبْرَارُ، وَصَلَّتْ عَلَيْكُمُ الْمَلَائِكَةُ",
            transliteration = "Aftara 'indakumus-saa'imoon, wa akala ta'aamakumul-abraar, wa sallat 'alaykumul-malaa'ikah.",
            translation = "May those who fast break their fast with you, may the righteous eat your food, and may the angels send prayers upon you.",
            source = "Abu Dawud 3854"
        ),
        Dua(
            title = "When drinking milk",
            section = FOOD_DRINK,
            arabic = "اللَّهُمَّ بَارِكْ لَنَا فِيهِ، وَزِدْنَا مِنْهُ",
            transliteration = "Allahumma baarik lanaa feehi, wa zidnaa minh.",
            translation = "O Allah, bless it for us and give us more of it.",
            source = "Abu Dawud 3730; At-Tirmidhi 3455"
        ),
        Dua(
            title = "Mounting a ride",
            section = TRAVEL,
            arabic = "بِسْمِ اللهِ، الْحَمْدُ لِلَّهِ، سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَذَا وَمَا كُنَّا لَهُ مُقْرِنِينَ، وَإِنَّا إِلَى رَبِّنَا لَمُنْقَلِبُونَ",
            transliteration = "Bismillaah, alhamdu lillaah. Subhaanal-ladhee sakhkhara lanaa haadhaa wa maa kunnaa lahu muqrineen, wa innaa ilaa rabbinaa lamunqaliboon.",
            translation = "In the name of Allah. Praise is for Allah. Glory is to the One who subjected this to us, for we could not have controlled it, and surely to our Lord we will return.",
            source = "Quran 43:13-14; Sahih Muslim 1342"
        ),
        Dua(
            title = "Beginning a journey",
            section = TRAVEL,
            arabic = "اللَّهُمَّ إِنَّا نَسْأَلُكَ فِي سَفَرِنَا هَذَا الْبِرَّ وَالتَّقْوَى، وَمِنَ الْعَمَلِ مَا تَرْضَى",
            transliteration = "Allahumma innaa nas'aluka fee safarinaa haadhal-birra wat-taqwaa, wa minal-'amali maa tardaa.",
            translation = "O Allah, we ask You in this journey for righteousness, mindfulness of You, and deeds that please You.",
            source = "Sahih Muslim 1342"
        ),
        Dua(
            title = "Ease the journey",
            section = TRAVEL,
            arabic = "اللَّهُمَّ هَوِّنْ عَلَيْنَا سَفَرَنَا هَذَا، وَاطْوِ عَنَّا بُعْدَهُ",
            transliteration = "Allahumma hawwin 'alaynaa safaranaa haadhaa, watwi 'annaa bu'dah.",
            translation = "O Allah, make this journey easy for us and shorten its distance for us.",
            source = "Sahih Muslim 1342"
        ),
        Dua(
            title = "For someone you leave behind",
            section = TRAVEL,
            arabic = "أَسْتَوْدِعُكُمُ اللهَ الَّذِي لَا تَضِيعُ وَدَائِعُهُ",
            transliteration = "Astawdi'ukumullaahal-ladhee laa tadee'u wadaa'i'uh.",
            translation = "I entrust you to Allah, whose trusts are never lost.",
            source = "Ibn Majah 2825; Ahmad 9230"
        ),
        Dua(
            title = "Entering a town",
            section = TRAVEL,
            arabic = "اللَّهُمَّ رَبَّ السَّمَاوَاتِ السَّبْعِ وَمَا أَظْلَلْنَ، وَرَبَّ الْأَرَضِينَ السَّبْعِ وَمَا أَقْلَلْنَ، أَسْأَلُكَ خَيْرَ هَذِهِ الْقَرْيَةِ",
            transliteration = "Allahumma rabbas-samaawaatis-sab'i wa maa azlaln, wa rabbal-aradeenas-sab'i wa maa aqlaln, as'aluka khayra haadhihil-qaryah.",
            translation = "O Allah, Lord of the seven heavens and what they shade, Lord of the seven earths and what they carry, I ask You for the good of this town.",
            source = "Al-Hakim 2/100; Hisn al-Muslim"
        ),
        Dua(
            title = "When the wind blows",
            section = WEATHER,
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ خَيْرَهَا، وَأَعُوذُ بِكَ مِنْ شَرِّهَا",
            transliteration = "Allahumma innee as'aluka khayrahaa, wa a'oodhu bika min sharrihaa.",
            translation = "O Allah, I ask You for its good and seek refuge in You from its evil.",
            source = "Abu Dawud 5097; Ibn Majah 3727"
        ),
        Dua(
            title = "When rain falls",
            section = WEATHER,
            arabic = "اللَّهُمَّ صَيِّبًا نَافِعًا",
            transliteration = "Allahumma sayyiban naafi'an.",
            translation = "O Allah, make it beneficial rain.",
            source = "Sahih al-Bukhari 1032"
        ),
        Dua(
            title = "After rainfall",
            section = WEATHER,
            arabic = "مُطِرْنَا بِفَضْلِ اللهِ وَرَحْمَتِهِ",
            transliteration = "Mutirnaa bifadlillaahi wa rahmatih.",
            translation = "We have been given rain by Allah's bounty and mercy.",
            source = "Sahih al-Bukhari 846; Sahih Muslim 71"
        ),
        Dua(
            title = "When hearing thunder",
            section = WEATHER,
            arabic = "سُبْحَانَ الَّذِي يُسَبِّحُ الرَّعْدُ بِحَمْدِهِ، وَالْمَلَائِكَةُ مِنْ خِيفَتِهِ",
            transliteration = "Subhaanal-ladhee yusabbihur-ra'du bihamdihi, wal-malaa'ikatu min kheefatih.",
            translation = "Glory is to the One whom thunder glorifies with His praise, and the angels from fear of Him.",
            source = "Al-Muwatta 2/992"
        ),
        Dua(
            title = "Asking for beneficial rain",
            section = WEATHER,
            arabic = "اللَّهُمَّ اسْقِنَا غَيْثًا مُغِيثًا، مَرِيئًا مَرِيعًا، نَافِعًا غَيْرَ ضَارٍّ",
            transliteration = "Allahummasqinaa ghaythan mugheethan, maree'an maree'an, naafi'an ghayra daarr.",
            translation = "O Allah, give us rain that brings relief, is wholesome and fertile, beneficial and not harmful.",
            source = "Abu Dawud 1169"
        ),
        Dua(
            title = "Entering the bathroom",
            section = DAILY,
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْخُبُثِ وَالْخَبَائِثِ",
            transliteration = "Allahumma innee a'oodhu bika minal-khubuthi wal-khabaa'ith.",
            translation = "O Allah, I seek refuge in You from male and female devils.",
            source = "Sahih al-Bukhari 142; Sahih Muslim 375"
        ),
        Dua(
            title = "Leaving the bathroom",
            section = DAILY,
            arabic = "غُفْرَانَكَ",
            transliteration = "Ghufraanak.",
            translation = "I seek Your forgiveness.",
            source = "Abu Dawud 30; At-Tirmidhi 7"
        ),
        Dua(
            title = "Putting on clothes",
            section = DAILY,
            arabic = "الْحَمْدُ لِلَّهِ الَّذِي كَسَانِي هَذَا، وَرَزَقَنِيهِ، مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍ",
            transliteration = "Alhamdu lillaahil-ladhee kasaanee haadhaa, wa razaqaneehi, min ghayri hawlin minnee wa laa quwwah.",
            translation = "Praise is for Allah who clothed me with this and provided it for me without any power or strength from me.",
            source = "Abu Dawud 4023; At-Tirmidhi 3458"
        ),
        Dua(
            title = "Wearing new clothes",
            section = DAILY,
            arabic = "اللَّهُمَّ لَكَ الْحَمْدُ أَنْتَ كَسَوْتَنِيهِ، أَسْأَلُكَ مِنْ خَيْرِهِ وَخَيْرِ مَا صُنِعَ لَهُ، وَأَعُوذُ بِكَ مِنْ شَرِّهِ وَشَرِّ مَا صُنِعَ لَهُ",
            transliteration = "Allahumma lakal-hamdu anta kasawtaneeh, as'aluka min khayrihi wa khayri maa suni'a lah, wa a'oodhu bika min sharrihi wa sharri maa suni'a lah.",
            translation = "O Allah, praise is Yours. You clothed me with it. I ask You for its good and the good for which it was made, and I seek refuge in You from its evil and the evil for which it was made.",
            source = "Abu Dawud 4020; At-Tirmidhi 1767"
        ),
        Dua(
            title = "When sneezing",
            section = DAILY,
            arabic = "الْحَمْدُ لِلَّهِ",
            transliteration = "Alhamdu lillaah.",
            translation = "Praise is for Allah.",
            source = "Sahih al-Bukhari 6224"
        ),
        Dua(
            title = "Reply to one who sneezes",
            section = DAILY,
            arabic = "يَرْحَمُكَ اللهُ",
            transliteration = "Yarhamukallaah.",
            translation = "May Allah have mercy on you.",
            source = "Sahih al-Bukhari 6224"
        ),
        Dua(
            title = "Ruqyah for healing",
            section = HEALTH,
            arabic = "بِسْمِ اللهِ أَرْقِيكَ، مِنْ كُلِّ شَيْءٍ يُؤْذِيكَ، مِنْ شَرِّ كُلِّ نَفْسٍ أَوْ عَيْنِ حَاسِدٍ، اللهُ يَشْفِيكَ، بِسْمِ اللهِ أَرْقِيكَ",
            transliteration = "Bismillaahi arqeek, min kulli shay'in yu'dheek, min sharri kulli nafsin aw 'aynin haasid, Allaahu yashfeek, bismillaahi arqeek.",
            translation = "In the name of Allah, I recite over you from everything that harms you, from the evil of every soul or envious eye. May Allah heal you.",
            source = "Sahih Muslim 2186",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/10/bismillahi-arqeek-min-kulli-shay_in-yu_dheek.mp3"
        ),
        Dua(
            title = "When feeling pain",
            section = HEALTH,
            arabic = "بِسْمِ اللهِ، أَعُوذُ بِاللهِ وَقُدْرَتِهِ مِنْ شَرِّ مَا أَجِدُ وَأُحَاذِرُ",
            transliteration = "Bismillaah. A'oodhu billaahi wa qudratihi min sharri maa ajidu wa uhaadhir.",
            translation = "In the name of Allah. I seek refuge in Allah and His power from the evil of what I feel and fear.",
            source = "Sahih Muslim 2202",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/07/the-duaa-when-a-person-feels-pain-in-their-body-authentic-dua-com.mp3"
        ),
        Dua(
            title = "Protection from harm",
            section = HEALTH,
            arabic = "أَعُوذُ بِكَلِمَاتِ اللهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ",
            transliteration = "A'oodhu bi kalimaatil-laahit-taammaati min sharri maa khalaq.",
            translation = "I seek protection in the perfect words of Allah from the evil of what He has created.",
            source = "Sahih Muslim 2709; At-Tirmidhi 3898",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/07/seeking-refuge-in-the-perfect-words-of-allaah-authentic-dua-com.mp3"
        ),
        Dua(
            title = "Anxiety and grief",
            section = HEALTH,
            arabic = "اللَّهُمَّ إِنِّي عَبْدُكَ، ابْنُ عَبْدِكَ، ابْنُ أَمَتِكَ، نَاصِيَتِي بِيَدِكَ، مَاضٍ فِيَّ حُكْمُكَ، عَدْلٌ فِيَّ قَضَاؤُكَ",
            transliteration = "Allahumma innee 'abduk, ibnu 'abdik, ibnu amatik, naasiyatee biyadik, maadin fiyya hukmuk, 'adlun fiyya qadaa'uk.",
            translation = "O Allah, I am Your servant, son of Your servant and maidservant. My forelock is in Your hand, Your command over me is forever executed, and Your decree over me is just.",
            source = "Ahmad 3712; Hisn al-Muslim"
        ),
        Dua(
            title = "Relief from debt",
            section = HEALTH,
            arabic = "اللَّهُمَّ اكْفِنِي بِحَلَالِكَ عَنْ حَرَامِكَ، وَأَغْنِنِي بِفَضْلِكَ عَمَّنْ سِوَاكَ",
            transliteration = "Allahummakfinee bihalaalika 'an haraamik, wa aghninee bifadlika 'amman siwaak.",
            translation = "O Allah, suffice me with what You have made lawful over what You have forbidden, and enrich me by Your bounty above needing anyone besides You.",
            source = "At-Tirmidhi 3563"
        ),
        Dua(
            title = "When angry",
            section = HEALTH,
            arabic = "أَعُوذُ بِاللهِ مِنَ الشَّيْطَانِ الرَّجِيمِ",
            transliteration = "A'oodhu billaahi minash-shaytaanir-rajeem.",
            translation = "I seek refuge in Allah from Satan, the rejected.",
            source = "Sahih al-Bukhari 3282; Sahih Muslim 2610"
        ),
        Dua(
            title = "After a bad dream",
            section = HEALTH,
            arabic = "أَعُوذُ بِاللهِ مِنَ الشَّيْطَانِ وَمِنْ شَرِّ مَا رَأَيْتُ",
            transliteration = "A'oodhu billaahi minash-shaytaani wa min sharri maa ra'ayt.",
            translation = "I seek refuge in Allah from Satan and from the evil of what I saw.",
            source = "Sahih Muslim 2261"
        ),
        Dua(
            title = "For forgiveness and protection",
            section = QURANIC,
            arabic = "رَبَّنَا إِنَّنَا آمَنَّا فَاغْفِرْ لَنَا ذُنُوبَنَا وَقِنَا عَذَابَ النَّارِ",
            transliteration = "Rabbanaa innanaa aamannaa faghfir lanaa dhunoobanaa wa qinaa 'adhaaban-naar.",
            translation = "Our Lord, we have indeed believed, so forgive us our sins and protect us from the punishment of the Fire.",
            source = "Quran 3:16",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/07/quranic-dua-003016-our-lord-we-have-indeed-believed-so-forgive-us.mp3"
        ),
        Dua(
            title = "Good in this life and the next",
            section = QURANIC,
            arabic = "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً، وَفِي الْآخِرَةِ حَسَنَةً، وَقِنَا عَذَابَ النَّارِ",
            transliteration = "Rabbanaa aatinaa fid-dunyaa hasanah, wa fil-aakhirati hasanah, wa qinaa 'adhaaban-naar.",
            translation = "Our Lord, give us good in this world and good in the Hereafter, and protect us from the punishment of the Fire.",
            source = "Quran 2:201"
        ),
        Dua(
            title = "Do not let our hearts deviate",
            section = QURANIC,
            arabic = "رَبَّنَا لَا تُزِغْ قُلُوبَنَا بَعْدَ إِذْ هَدَيْتَنَا، وَهَبْ لَنَا مِنْ لَدُنْكَ رَحْمَةً، إِنَّكَ أَنْتَ الْوَهَّابُ",
            transliteration = "Rabbanaa laa tuzigh quloobanaa ba'da idh hadaytanaa, wa hab lanaa mil-ladunka rahmah, innaka antal-wahhaab.",
            translation = "Our Lord, do not let our hearts deviate after You have guided us. Grant us mercy from Yourself. You are the Bestower.",
            source = "Quran 3:8"
        ),
        Dua(
            title = "Mercy from our spouses and children",
            section = QURANIC,
            arabic = "رَبَّنَا هَبْ لَنَا مِنْ أَزْوَاجِنَا وَذُرِّيَّاتِنَا قُرَّةَ أَعْيُنٍ، وَاجْعَلْنَا لِلْمُتَّقِينَ إِمَامًا",
            transliteration = "Rabbanaa hab lanaa min azwaajinaa wa dhurriyyaatinaa qurrata a'yun, waj'alnaa lil-muttaqeena imaamaa.",
            translation = "Our Lord, grant us from our spouses and offspring comfort to our eyes, and make us leaders for the mindful.",
            source = "Quran 25:74"
        ),
        Dua(
            title = "Increase me in knowledge",
            section = QURANIC,
            arabic = "رَبِّ زِدْنِي عِلْمًا",
            transliteration = "Rabbi zidnee 'ilmaa.",
            translation = "My Lord, increase me in knowledge.",
            source = "Quran 20:114"
        ),
        Dua(
            title = "Open my chest and ease my task",
            section = QURANIC,
            arabic = "رَبِّ اشْرَحْ لِي صَدْرِي، وَيَسِّرْ لِي أَمْرِي، وَاحْلُلْ عُقْدَةً مِنْ لِسَانِي، يَفْقَهُوا قَوْلِي",
            transliteration = "Rabbishrah lee sadree, wa yassir lee amree, wahlul 'uqdatan min lisaanee, yafqahoo qawlee.",
            translation = "My Lord, expand my chest, ease my task for me, and untie the knot from my tongue so they may understand my speech.",
            source = "Quran 20:25-28"
        ),
        Dua(
            title = "I am in need of Your good",
            section = QURANIC,
            arabic = "رَبِّ إِنِّي لِمَا أَنْزَلْتَ إِلَيَّ مِنْ خَيْرٍ فَقِيرٌ",
            transliteration = "Rabbi innee limaa anzalta ilayya min khayrin faqeer.",
            translation = "My Lord, I am truly in need of whatever good You send down to me.",
            source = "Quran 28:24"
        ),
        Dua(
            title = "Yunus's supplication",
            section = QURANIC,
            arabic = "لَا إِلَهَ إِلَّا أَنْتَ سُبْحَانَكَ، إِنِّي كُنْتُ مِنَ الظَّالِمِينَ",
            transliteration = "Laa ilaaha illaa anta subhaanak, innee kuntu minaz-zaalimeen.",
            translation = "There is no god but You. Glory be to You. I was indeed among the wrongdoers.",
            source = "Quran 21:87"
        ),
        Dua(
            title = "We have wronged ourselves",
            section = QURANIC,
            arabic = "رَبَّنَا ظَلَمْنَا أَنْفُسَنَا، وَإِنْ لَمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا، لَنَكُونَنَّ مِنَ الْخَاسِرِينَ",
            transliteration = "Rabbanaa zalamnaa anfusanaa, wa in lam taghfir lanaa wa tarhamnaa, lanakoonanna minal-khaasireen.",
            translation = "Our Lord, we have wronged ourselves. If You do not forgive us and have mercy on us, we will surely be among the losers.",
            source = "Quran 7:23"
        ),
        Dua(
            title = "Safeguard faith and life",
            section = COMPREHENSIVE,
            arabic = "اللَّهُمَّ أَصْلِحْ لِي دِينِي الَّذِي هُوَ عِصْمَةُ أَمْرِي، وَأَصْلِحْ لِي دُنْيَايَ الَّتِي فِيهَا مَعَاشِي، وَأَصْلِحْ لِي آخِرَتِي الَّتِي فِيهَا مَعَادِي",
            transliteration = "Allahumma aslih lee deenee alladhi huwa 'ismatu amree, wa aslih lee dunyaaya allatee feehaa ma'aashee, wa aslih lee aakhiratee allatee feehaa ma'aadee.",
            translation = "O Allah, set right my religion, which safeguards my affairs; set right my worldly life, wherein is my living; and set right my next life, to which is my return.",
            source = "Sahih Muslim 2720",
            audioUrl = "https://salafiaudio.files.wordpress.com/2015/10/o-allaah-safeguard-my-deen-dunya-and-aakhira.mp3"
        ),
        Dua(
            title = "Beneficial knowledge and provision",
            section = COMPREHENSIVE,
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمًا نَافِعًا، وَرِزْقًا طَيِّبًا، وَعَمَلًا مُتَقَبَّلًا",
            transliteration = "Allahumma innee as'aluka 'ilman naafi'an, wa rizqan tayyiban, wa 'amalan mutaqabbalaa.",
            translation = "O Allah, I ask You for beneficial knowledge, good provision, and accepted deeds.",
            source = "Ibn Majah 925; Ahmad 26602"
        ),
        Dua(
            title = "Help me remember You",
            section = COMPREHENSIVE,
            arabic = "اللَّهُمَّ أَعِنِّي عَلَى ذِكْرِكَ، وَشُكْرِكَ، وَحُسْنِ عِبَادَتِكَ",
            transliteration = "Allahumma a'innee 'alaa dhikrika, wa shukrika, wa husni 'ibaadatik.",
            translation = "O Allah, help me remember You, thank You, and worship You beautifully.",
            source = "Abu Dawud 1522; An-Nasa'i 1303"
        ),
        Dua(
            title = "All good, near and far",
            section = COMPREHENSIVE,
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنَ الْخَيْرِ كُلِّهِ، عَاجِلِهِ وَآجِلِهِ، مَا عَلِمْتُ مِنْهُ وَمَا لَمْ أَعْلَمْ",
            transliteration = "Allahumma innee as'aluka minal-khayri kullihi, 'aajilihi wa aajilih, maa 'alimtu minhu wa maa lam a'lam.",
            translation = "O Allah, I ask You for all good, immediate and delayed, what I know of it and what I do not know.",
            source = "Ibn Majah 3846; Ahmad 24498"
        ),
        Dua(
            title = "Refuge from all evil",
            section = COMPREHENSIVE,
            arabic = "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الشَّرِّ كُلِّهِ، عَاجِلِهِ وَآجِلِهِ، مَا عَلِمْتُ مِنْهُ وَمَا لَمْ أَعْلَمْ",
            transliteration = "Allahumma innee a'oodhu bika minash-sharri kullihi, 'aajilihi wa aajilih, maa 'alimtu minhu wa maa lam a'lam.",
            translation = "O Allah, I seek refuge in You from all evil, immediate and delayed, what I know of it and what I do not know.",
            source = "Ibn Majah 3846; Ahmad 24498"
        ),
        Dua(
            title = "Ask for Paradise and refuge from Fire",
            section = COMPREHENSIVE,
            arabic = "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْجَنَّةَ وَمَا قَرَّبَ إِلَيْهَا مِنْ قَوْلٍ أَوْ عَمَلٍ، وَأَعُوذُ بِكَ مِنَ النَّارِ وَمَا قَرَّبَ إِلَيْهَا مِنْ قَوْلٍ أَوْ عَمَلٍ",
            transliteration = "Allahumma innee as'alukal-jannata wa maa qarraba ilayhaa min qawlin aw 'amal, wa a'oodhu bika minan-naari wa maa qarraba ilayhaa min qawlin aw 'amal.",
            translation = "O Allah, I ask You for Paradise and whatever words or deeds bring one near to it, and I seek refuge in You from the Fire and whatever words or deeds bring one near to it.",
            source = "Ibn Majah 3846; Ahmad 24498"
        )
    )

    fun duasFor(section: String): List<Dua> = duas.filter { it.section == section }
}
