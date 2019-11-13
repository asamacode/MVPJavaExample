package com.asama.luong.mvpjavaexample.ui.login;

import com.asama.luong.mvpjavaexample.di.PerActivity;
import com.asama.luong.mvpjavaexample.ui.base.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();
}