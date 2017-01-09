package com.maxi.waterpurifier.base;

import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by bin.shen on 02/01/2017.
 */

public abstract class ResultCallback<T> extends Callback<Result<T>> {

    @Override
    public Result parseNetworkResponse(Response response, int id) throws IOException {
        return Result.fromJson(response.body().string(), getClazz());
    }

    public Class<T> getClazz() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) t;
        return (Class<T>) p.getActualTypeArguments()[0];
    }
}

