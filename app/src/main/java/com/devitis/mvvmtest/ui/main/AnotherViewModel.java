package com.devitis.mvvmtest.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.devitis.mvvmtest.data.rx.SchedulersFacade;
import com.devitis.mvvmtest.interactor.ILoadDataInteractor;
import com.devitis.mvvmtest.interactor.LoadDataInteractorImpl;
import com.devitis.mvvmtest.viewmodel.Response;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Diana on 21.06.2019.
 */

public class AnotherViewModel extends ViewModel {

    private final LoadDataInteractorImpl loadDataInteractor;

    private final LoadAnotherDataInteractorImpl loadAnotherDataInteractor;

    private final SchedulersFacade schedulersFacade;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final MutableLiveData<Response> responseMutableLiveData = new MutableLiveData<>();


    public AnotherViewModel(LoadDataInteractorImpl loadDataInteractor,
                            LoadAnotherDataInteractorImpl loadAnotherDataInteractor,
                            SchedulersFacade schedulersFacade) {

        this.loadDataInteractor = loadDataInteractor;
        this.loadAnotherDataInteractor = loadAnotherDataInteractor;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }


    /**
     * use interface interactot
     * use data from repo
     * use thread
     *
     * @param loadDataInteractor
     */
    private void load(ILoadDataInteractor loadDataInteractor) {

        compositeDisposable.add(loadDataInteractor.loadData()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> responseMutableLiveData.setValue(Response.loading()))
                .subscribe(
                        data -> responseMutableLiveData.setValue(Response.success(data)),
                        throwable -> responseMutableLiveData.setValue(Response.error(throwable))
                ));
    }


    void setLoadDataInteractor() {

        load(loadDataInteractor);
    }

    void setLoadAnotherDataInteractor() {

        load(loadAnotherDataInteractor);
    }

    MutableLiveData<Response> response() {

        return responseMutableLiveData;
    }
}
