package com.asama.luong.mvpjavaexample.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.asama.luong.mvpjavaexample.data.network.model.BlogResponse;
import com.asama.luong.mvpjavaexample.di.ActivityContext;
import com.asama.luong.mvpjavaexample.di.PerActivity;
import com.asama.luong.mvpjavaexample.ui.about.AboutMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.about.AboutMvpView;
import com.asama.luong.mvpjavaexample.ui.about.AboutPresenter;
import com.asama.luong.mvpjavaexample.ui.feed.FeedMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.feed.FeedMvpView;
import com.asama.luong.mvpjavaexample.ui.feed.FeedPresenter;
import com.asama.luong.mvpjavaexample.ui.feed.blogs.BlogAdapter;
import com.asama.luong.mvpjavaexample.ui.feed.blogs.BlogMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.feed.blogs.BlogMvpView;
import com.asama.luong.mvpjavaexample.ui.feed.blogs.BlogPresenter;
import com.asama.luong.mvpjavaexample.ui.login.LoginMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.login.LoginMvpView;
import com.asama.luong.mvpjavaexample.ui.login.LoginPresenter;
import com.asama.luong.mvpjavaexample.ui.main.MainMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.main.MainMvpView;
import com.asama.luong.mvpjavaexample.ui.main.MainPresenter;
import com.asama.luong.mvpjavaexample.ui.main.rating.RatingDialogMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.main.rating.RatingDialogMvpView;
import com.asama.luong.mvpjavaexample.ui.main.rating.RatingDialogPresenter;
import com.asama.luong.mvpjavaexample.ui.splash.SplashMvpPresenter;
import com.asama.luong.mvpjavaexample.ui.splash.SplashMvpView;
import com.asama.luong.mvpjavaexample.ui.splash.SplashPresenter;
import com.asama.luong.mvpjavaexample.utils.rx.AppSchedulerProvider;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import java.util.ArrayList;

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

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRatingDialogPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter
    ) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter
    ) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogPresenter(
            BlogPresenter<BlogMvpView> presenter
    ) {
        return presenter;
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
