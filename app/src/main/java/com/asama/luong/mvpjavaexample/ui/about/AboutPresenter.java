package com.asama.luong.mvpjavaexample.ui.about;

import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.ui.base.BasePresenter;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AboutPresenter<V extends AboutMvpView> extends BasePresenter<V> implements AboutMvpPresenter<V> {

    @Inject
    public AboutPresenter(DataManager mDataManager, CompositeDisposable compositeDisposable, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, compositeDisposable, mSchedulerProvider);
    }
}
