package com.devitis.mvvmtest.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.devitis.mvvmtest.viewmodel.Status.ERROR;
import static com.devitis.mvvmtest.viewmodel.Status.LOADING;
import static com.devitis.mvvmtest.viewmodel.Status.SUCCESS;


/**
 * Created by Diana on 21.06.2019.
 * <p>
 * holder provided to the ui
 * <p>
 * have two variable
 */

public class Response {

    public final Status status;

    @Nullable
    public final String data;

    @Nullable
    public final Throwable throwable;


    public Response(Status status, @Nullable String data, @Nullable Throwable throwable) {
        this.status = status;
        this.data = data;
        this.throwable = throwable;
    }

    public static Response loading() {

        return new Response(LOADING, null, null);
    }

    public static Response success(@NonNull String data) {

        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable throwable) {

        return new Response(ERROR, null, throwable);
    }

}
