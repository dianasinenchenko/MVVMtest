package com.devitis.mvvmtest.data.rx;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Diana on 21.06.2019.
 */

public class SchedulersFacade {

    @Inject
    public SchedulersFacade() {
    }

    /**
     * io thread pool scheduler
     *
     * @return
     */
    public Scheduler io() {

        return Schedulers.io();
    }

    /**
     * main thread scheduler
     *
     * @return
     */
    public Scheduler ui() {

        return AndroidSchedulers.mainThread();
    }
}
