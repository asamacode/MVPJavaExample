package com.asama.luong.mvpjavaexample.ui.feed.blogs;

import com.asama.luong.mvpjavaexample.ui.base.MvpPresenter;

public interface BlogMvpPresenter<V extends BlogMvpView> extends MvpPresenter<V> {

    void onViewPrepared();
}
