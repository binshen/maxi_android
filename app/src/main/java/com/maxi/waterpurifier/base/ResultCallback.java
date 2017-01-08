package com.maxi.waterpurifier.base;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by bin.shen on 2017/1/8.
 */
public abstract class ResultCallback<T> extends Callback<Result<T>> {
    @Override
    public Result<T> parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();

        Gson gson = new Gson();
        Type objectType = type(Result.class, getClazz());
        return gson.fromJson(string, objectType);
    }

    /**
     * 获取T代表的class类型
     * @return
     */
    public Class<T> getClazz() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) t;
        Class<T> c = (Class<T>) p.getActualTypeArguments()[0];
        return c;
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
