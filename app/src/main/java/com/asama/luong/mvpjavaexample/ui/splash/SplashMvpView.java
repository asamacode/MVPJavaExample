package com.asama.luong.mvpjavaexample.ui.splash;

import com.asama.luong.mvpjavaexample.ui.base.MvpView;

public interface SplashMvpView extends MvpView {

    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
