package com.wang.lib.net.builder;

import com.wang.lib.net.OkHttpUtils;
import com.wang.lib.net.request.PostStringRequest;
import com.wang.lib.net.request.RequestCall;
//import com.zhy.http.okhttp.OkHttpUtils;
//import com.zhy.http.okhttp.request.PostStringRequest;
//import com.zhy.http.okhttp.request.RequestCall;

import java.util.Map;

import okhttp3.MediaType;

/**
 * Created by zhy on 15/12/14.
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder>
{
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {

        //添加全局参数
        Map<String, String> addParams = OkHttpUtils.getInstance().getGlobalParams().addParams();
        if (params != null) {
            addParams.putAll(params);
        }

        return new PostStringRequest(url, tag, addParams, headers, content, mediaType, id).build();
    }


}
