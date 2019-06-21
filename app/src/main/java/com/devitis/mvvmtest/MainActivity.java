package com.devitis.mvvmtest;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devitis.mvvmtest.data.di.DaggerIApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class MainActivity extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {

            Timber.plant(new Timber.DebugTree());
        }

        DaggerIApplicationComponent
                .builder()
                .mainActivity(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
