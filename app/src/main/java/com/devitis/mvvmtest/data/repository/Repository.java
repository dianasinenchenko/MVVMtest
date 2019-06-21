package com.devitis.mvvmtest.data.repository;

import io.reactivex.Single;

/**
 * Created by Diana on 21.06.2019.
 * <p>
 * include one method getData
 * need to save and get some string
 * use Single (if you sure about not null
 * hove only two situation )
 */

public class Repository {

    public Single<String> getDataFromRepository() {

        return Single.just("some data from repo");
    }
}
