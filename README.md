# lib_net
gradlew clean build bintrayUpload -PbintrayUser=BINTRAY_USERNAME -PbintrayKey=BINTRAY_KEY -PdryRun=false
gradlew clean build bintrayUpload -PbintrayUser=wangsongbin -PbintrayKey=apikey -PdryRun=false;

## 使用：

project build.gradle:

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://dl.bintray.com/wanglib/maven/' }
    }
}


module build.gradle:

dependencies {
    compile 'com.wang.lib.net:lib_net:0.0.2'
}