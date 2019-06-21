package com.devitis.mvvmtest.interactor;

import com.devitis.mvvmtest.data.repository.Repository;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Diana on 21.06.2019.
 *
 *
 */

public class LoadDataInteractorImpl implements ILoadDataInteractor {

    //init repo
    private final Repository repositoryData;


    // create constructor and use inject annotation (not sure)
    @Inject
    public LoadDataInteractorImpl(Repository repositoryData) {
        this.repositoryData = repositoryData;
    }

    /**
     * get data from repo
     * @return
     */
    @Override
    public Single<String> loadData() {
        return repositoryData.getDataFromRepository();
    }
}
