package com.wang.lib.net.builder;

//import com.zhy.http.okhttp.OkHttpUtils;
//import com.zhy.http.okhttp.request.OtherRequest;
//import com.zhy.http.okhttp.request.RequestCall;

import com.wang.lib.net.OkHttpUtils;
import com.wang.lib.net.request.OtherRequest;
import com.wang.lib.net.request.RequestCall;

import java.util.Map;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        //添加全局参数
        Map<String, String> addParams = OkHttpUtils.getInstance().getGlobalParams().addParams();
        if (params != null) {
            addParams.putAll(params);
        }
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, addParams, headers, id).build();
    }
}
