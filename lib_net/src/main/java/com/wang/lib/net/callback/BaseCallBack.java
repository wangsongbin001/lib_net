package com.wang.lib.net.callback;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public abstract class BaseCallBack<T> extends Callback<String> {

    @Override
    public void onBefore(Request request, int id) {
        super.onBefore(request, id);
    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws Exception {
        return response.body().string();
    }

    @Override
    public void onError(Call call, Response response, Exception e, int id) {
        if (response == null || TextUtils.isEmpty(response.body().toString())) {
            onResponse(-1, false, id, null, "");
        } else {
            //todo 解析出错误信息，并返回
            String body = "";
            try {
                body = response.body().string();
            } catch (Exception e2) {
            }
            onResponse(response.code(), false, id, null, body);
        }
    }

    @Override
    public void onResponse(String response, int id) {
        //todo 解析并返回
        try {
            JSONObject jsonObject = new JSONObject(response);
            int resCode = jsonObject.optInt("code", -1);
            String data = jsonObject.optString("data");
            Log.i("wang_", "data:" + data);

            Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            T bean = null;
            boolean isParseSuccess;
            try {
                if (entityClass == String.class) {
                    bean = (T) response;
                } else {
                    bean = GsonUtil.get().fromJson(data, entityClass);
                }
                isParseSuccess = true;
            } catch (Exception e) {
                isParseSuccess = false;
            }
            onResponse(resCode, isParseSuccess, id, bean, response);
        } catch (JSONException e) {
            e.printStackTrace();
            onResponse(-1, false, id, null, response);
        }
    }

    /**
     * @param resCode
     * @param isParseSuccess
     * @param id
     * @param t
     * @param body
     */
    public abstract void onResponse(int resCode, boolean isParseSuccess, int id, T t, String body);
}
