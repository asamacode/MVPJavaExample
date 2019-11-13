package com.asama.luong.mvpjavaexample.ui.splash;

import com.asama.luong.mvpjavaexample.di.PerActivity;
import com.asama.luong.mvpjavaexample.ui.base.MvpPresenter;

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
}
