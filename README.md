# ISC
gradlew clean build bintrayUpload -PbintrayUser=BINTRAY_USERNAME -PbintrayKey=BINTRAY_KEY -PdryRun=false
gradlew clean build bintrayUpload -PbintrayUser=wangsongbin -PbintrayKey=apikey -PdryRun=false;

project build.gradle:
    maven { url 'https://dl.bintray.com/wanglib/maven/' }

module build.gradle:
    compile 'com.wang.lib.net:lib_net:0.0.2'