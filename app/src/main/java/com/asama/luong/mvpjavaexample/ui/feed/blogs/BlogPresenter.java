package com.asama.luong.mvpjavaexample.ui.feed.blogs;

import com.androidnetworking.error.ANError;
import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.data.network.model.BlogResponse;
import com.asama.luong.mvpjavaexample.ui.base.BasePresenter;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class BlogPresenter<V extends BlogMvpView> extends BasePresenter<V> implements BlogMvpPresenter<V> {

    @Inject
    public BlogPresenter(DataManager mDataManager,
                         CompositeDisposable compositeDisposable,
                         SchedulerProvider mSchedulerProvider) {
        super(mDataManager, compositeDisposable, mSchedulerProvider);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
        .getBlogApiCall()
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(new Consumer<BlogResponse>() {
            @Override
            public void accept(BlogResponse blogResponse) throws Exception {
                if (blogResponse != null && blogResponse.getData() != null) {
                    getMvpView().updateBlog(blogResponse.getData());
                }
                getMvpView().hideLoading();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (!isViewAttached()) {
                    return;
                }


                getMvpView().hideLoading();

                // handle the error here
                if (throwable instanceof ANError) {
                    ANError anError = (ANError) throwable;
                    handleApiError(anError);
                }
            }
        }));
    }
}
