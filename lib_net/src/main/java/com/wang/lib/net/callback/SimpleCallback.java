package com.wang.lib.net.callback;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Response;

/**
 * Created by Vector
 * on 2017/2/14 0014.
 */

public abstract class SimpleCallback<T> extends Callback<T> {
//    private Class<T> mClazz;
//
//    public InnerCallback(Class<T> clazz) {
//        mClazz = clazz;
//    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws IOException {
        String string = response.body().string();
        Log.i("wang_", "string:" + string);
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = GsonUtil.get().fromJson(string, entityClass);
        return bean;
    }
}
