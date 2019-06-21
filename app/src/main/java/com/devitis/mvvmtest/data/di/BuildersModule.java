package com.devitis.mvvmtest.data.di;

import com.devitis.mvvmtest.ui.main.AnotherActivity;
import com.devitis.mvvmtest.ui.main.AnotherModule;
import com.devitis.mvvmtest.ui.main.AnotherRepository;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Diana on 21.06.2019.
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = AnotherModule.class)
    abstract AnotherActivity bindAnotherActivity();
}
