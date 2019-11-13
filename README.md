# 网络封装
1，支持一般的get,post网络请求
2，支持Gson自动解析
3，支持文件的上传，下载以及图片加载
4，上传下载进度监听
5，支持取消取消请求
6，session的保持
7，支持自签名网站https的访问，提供方法设置下证书就行

例如：
        OkHttpUtils.get().addParam("username", "lisi")
                .url("http://www.wangsongbin.top/app/start")
                .id(1001)
                .build()
                .execute(new BaseCallBack<StartModel>() {
                    @Override
                    public void onResponse(int resCode, boolean isParseSuccess, int id, StartModel o, String body) {
                        LogUtil.i(TAG, "resCode:" + resCode + " body:" + body);
                        if (resCode == 0 && isParseSuccess) {
                            LogUtil.i(TAG, "resultBean:" + o.toString());
                        }
                    }
                });

               
# 统一下载器封装
1，实时回调
2，实时状态查询
3，断点续传
4，多线程下载
5，任务队列管理
6，定时（例如：三天前）清理已安装包，缓存文件

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