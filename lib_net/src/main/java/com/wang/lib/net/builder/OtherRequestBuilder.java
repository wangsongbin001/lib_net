package com.wang.lib.net.builder;

//import com.zhy.http.okhttp.OkHttpUtils;
//import com.zhy.http.okhttp.request.OtherRequest;
//import com.zhy.http.okhttp.request.RequestCall;

import com.wang.lib.net.OkHttpUtils;
import com.wang.lib.net.request.OtherRequest;
import com.wang.lib.net.request.RequestCall;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * DELETE、PUT、PATCH等其他方法
 */
public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder>
{
    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequestBuilder(String method)
    {
        this.method = method;
    }

    @Override
    public RequestCall build()
    {
        //添加全局参数
        Map<String, String> addParams = OkHttpUtils.getInstance().getGlobalParams().addParams();
        if (params != null) {
            addParams.putAll(params);
        }
        return new OtherRequest(requestBody, content, method, url, tag, addParams, headers, id).build();
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody)
    {
        this.requestBody = requestBody;
        return this;
    }

    public OtherRequestBuilder requestBody(String content)
    {
        this.content = content;
        return this;
    }


}
