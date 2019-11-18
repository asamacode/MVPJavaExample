package com.asama.luong.mvpjavaexample.ui.feed.opensource;

import com.androidnetworking.error.ANError;
import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.data.network.model.OpenSourceResponse;
import com.asama.luong.mvpjavaexample.ui.base.BasePresenter;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

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
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .getOpenSourceApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<OpenSourceResponse>() {
                    @Override
                    public void accept(OpenSourceResponse openSourceResponse) throws Exception {
                        if (openSourceResponse != null && openSourceResponse.getData() != null) {
                            getMvpView().updateRepo(openSourceResponse.getData());
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

                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
