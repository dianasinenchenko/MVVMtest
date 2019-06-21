package com.devitis.mvvmtest.ui.main;

import com.devitis.mvvmtest.interactor.ILoadDataInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Diana on 21.06.2019.
 */

public class LoadAnotherDataInteractorImpl implements ILoadDataInteractor {

    private final AnotherRepository anotherRepository;

    @Inject
    public LoadAnotherDataInteractorImpl(AnotherRepository anotherRepository) {
        this.anotherRepository = anotherRepository;
    }

    @Override
    public Single<String> loadData() {
        return anotherRepository.getAnotherDataFromRepository();
    }
}
