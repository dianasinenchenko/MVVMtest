package com.devitis.mvvmtest.data.di;

import android.content.Context;

import com.devitis.mvvmtest.MainActivity;
import com.devitis.mvvmtest.data.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 21.06.2019.
 * <p>
 * like main module
 * use context and repo
 * <p>
 * where you will inject dependencies
 */

@Module
public class ApplicationModule {

    // get data from context , like new constructor, like init
    @Provides
    Context provideContext(MainActivity mainActivity) {

        return mainActivity.getApplicationContext();
    }

    // get data from repo
    @Singleton
    @Provides
    Repository provideRepository() {

        return new Repository();
    }

}
