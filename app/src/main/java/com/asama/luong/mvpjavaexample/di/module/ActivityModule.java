package com.asama.luong.mvpjavaexample.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.asama.luong.mvpjavaexample.di.ActivityContext;
import com.asama.luong.mvpjavaexample.di.PerActivity;
import com.asama.luong.mvpjavaexample.ui.about.AboutMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.about.AboutMvpView;
import com.asama.luong.mvpjavaexample.ui.about.AboutPresenter;
import com.asama.luong.mvpjavaexample.ui.login.LoginMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.login.LoginMvpView;
import com.asama.luong.mvpjavaexample.ui.login.LoginPresenter;
import com.asama.luong.mvpjavaexample.ui.main.MainMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.main.MainMvpView;
import com.asama.luong.mvpjavaexample.ui.main.MainPresenter;
import com.asama.luong.mvpjavaexample.ui.splash.SplashMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.splash.SplashMvpView;
import com.asama.luong.mvpjavaexample.ui.splash.SplashPresenter;
import com.asama.luong.mvpjavaexample.utils.rx.AppSchedulerProvider;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter
    ) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }
}
