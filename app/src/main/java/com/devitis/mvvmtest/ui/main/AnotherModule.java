package com.devitis.mvvmtest.ui.main;

import com.devitis.mvvmtest.data.rx.SchedulersFacade;
import com.devitis.mvvmtest.interactor.LoadDataInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 21.06.2019.
 */

@Module
public class AnotherModule {

    @Provides
    AnotherRepository provideAnotherRepository() {

        return new AnotherRepository();
    }


    @Provides
    AnotherViewModelFactory provideAnotherViewModelFactory(LoadDataInteractorImpl loadDataInteractor,
                                                           LoadAnotherDataInteractorImpl loadAnotherDataInteractor,
                                                           SchedulersFacade schedulersFacade) {


        return new AnotherViewModelFactory(loadDataInteractor, loadAnotherDataInteractor, schedulersFacade);
    }

}
