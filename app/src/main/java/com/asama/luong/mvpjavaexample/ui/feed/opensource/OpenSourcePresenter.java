package com.asama.luong.mvpjavaexample.ui.feed.opensource;

import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.ui.base.BasePresenter;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class OpenSourcePresenter<V extends OpenSourceMvpView> extends BasePresenter<V>
        implements OpenSourceMvpPresenter<V> {

    @Inject
    public OpenSourcePresenter(DataManager mDataManager,
                               CompositeDisposable compositeDisposable,
                               SchedulerProvider mSchedulerProvider) {
        super(mDataManager, compositeDisposable, mSchedulerProvider);
    }

    @Override
    public void onViewPrepared() {
        // dung o day
    }
}
