#!/bin/sh

APP_PATH=$0

while
    APP_HOME=${APP_PATH%"${APP_PATH##*/}"}
    [ -h "$APP_PATH" ]
do
    ls=$(ls -ld "$APP_PATH")
    link=${ls#*' -> '}
    case $link in
        /*) APP_PATH=$link ;;
        *) APP_PATH=$APP_HOME$link ;;
    esac
done

APP_HOME=$(cd "${APP_HOME:-./}" && pwd -P) || exit
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar:$APP_HOME/gradle/wrapper/gradle-wrapper-shared.jar

if [ -n "$JAVA_HOME" ]; then
    JAVA_EXE=$JAVA_HOME/bin/java
else
    JAVA_EXE=java
fi

exec "$JAVA_EXE" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
