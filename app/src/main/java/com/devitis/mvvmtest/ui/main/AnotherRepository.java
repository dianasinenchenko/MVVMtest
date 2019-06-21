package com.devitis.mvvmtest.ui.main;


import io.reactivex.Single;

/**
 * Created by Diana on 21.06.2019.
 */

public class AnotherRepository {

    Single<String> getAnotherDataFromRepository() {

        return Single.just("another data");
    }
}
