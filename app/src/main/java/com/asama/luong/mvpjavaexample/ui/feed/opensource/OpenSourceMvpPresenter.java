package com.asama.luong.mvpjavaexample.ui.feed.opensource;

import com.asama.luong.mvpjavaexample.ui.base.MvpPresenter;

public interface OpenSourceMvpPresenter<V extends OpenSourceMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
