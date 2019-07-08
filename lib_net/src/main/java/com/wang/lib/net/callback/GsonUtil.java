package com.wang.lib.net.callback;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    static Gson gson;

    public static Gson get(){
        if(gson == null) {
//            gson = new GsonBuilder()
//                    .excludeFieldsWithoutExposeAnnotation()
//                    .create();
            gson = new Gson();
        }
        return gson;
    }
}
