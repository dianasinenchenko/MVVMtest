package com.devitis.mvvmtest.data.di;

import com.devitis.mvvmtest.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Diana on 21.06.2019.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        BuildersModule.class
})
public interface IApplicationComponent {

    @Component.Builder
    interface IBuilder {

        @BindsInstance
        IBuilder mainActivity(MainActivity mainActivity);

        IApplicationComponent build();
    }

    void inject(MainActivity mainActivity);
}
