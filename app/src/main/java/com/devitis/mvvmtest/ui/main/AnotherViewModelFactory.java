package com.devitis.mvvmtest.ui.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.devitis.mvvmtest.data.rx.SchedulersFacade;
import com.devitis.mvvmtest.interactor.LoadDataInteractorImpl;

/**
 * Created by Diana on 21.06.2019.
 */

public class AnotherViewModelFactory implements ViewModelProvider.Factory {

    private final LoadDataInteractorImpl loadDataInteractor;

    private final LoadAnotherDataInteractorImpl loadAnotherDataInteractor;

    private final SchedulersFacade schedulersFacade;

    AnotherViewModelFactory(LoadDataInteractorImpl loadDataInteractor,
                            LoadAnotherDataInteractorImpl loadAnotherDataInteractor,
                            SchedulersFacade schedulersFacade) {

        this.loadDataInteractor = loadDataInteractor;
        this.loadAnotherDataInteractor = loadAnotherDataInteractor;
        this.schedulersFacade = schedulersFacade;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(AnotherViewModel.class)) {

            return (T) new AnotherViewModel(loadDataInteractor,
                    loadAnotherDataInteractor,
                    schedulersFacade);
        }
        throw new IllegalArgumentException("hz vm class");
    }
}
