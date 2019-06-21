package com.devitis.mvvmtest.interactor;

import io.reactivex.Single;

/**
 * Created by Diana on 21.06.2019.
 * <p>
 * provide some data between repo and vm
 */

public interface ILoadDataInteractor {

    Single<String> loadData();
}
