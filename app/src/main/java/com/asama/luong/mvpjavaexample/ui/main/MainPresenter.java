package com.asama.luong.mvpjavaexample.ui.main;

import com.androidnetworking.error.ANError;
import com.asama.luong.mvpjavaexample.data.DataManager;
import com.asama.luong.mvpjavaexample.data.db.model.Question;
import com.asama.luong.mvpjavaexample.data.network.model.LogoutResponse;
import com.asama.luong.mvpjavaexample.ui.base.BasePresenter;
import com.asama.luong.mvpjavaexample.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager mDataManager,
                         CompositeDisposable compositeDisposable,
                         SchedulerProvider mSchedulerProvider) {
        super(mDataManager, compositeDisposable, mSchedulerProvider);
    }

    @Override
    public void onDrawerOptionAboutClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showAboutFragment();
    }

    @Override
    public void onDrawerOptionLogoutClick() {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doLogoutApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LogoutResponse>() {
                    @Override
                    public void accept(LogoutResponse logoutResponse) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getDataManager().setUserAsLoggedOut();
                        getMvpView().hideLoading();
                        getMvpView().openLoginActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

    @Override
    public void onDrawerRateUsClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showRateUsDialog();
    }

    @Override
    public void onDrawerMyFeedClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().openMyFeedActivity();
    }

    @Override
    public void onViewInitialized() {
        getCompositeDisposable().add(getDataManager()
        .getAllQuestions()
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(new Consumer<List<Question>>() {
            @Override
            public void accept(List<Question> questionList) throws Exception {
                if (!isViewAttached()) {
                    return;
                }

                if (questionList != null) {
                    getMvpView().refreshQuestionnaire(questionList);
                }
            }
        }));
    }

    @Override
    public void onCardExhausted() {
        getCompositeDisposable().add(getDataManager()
        .getAllQuestions()
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(new Consumer<List<Question>>() {
            @Override
            public void accept(List<Question> questionList) throws Exception {
                if (!isViewAttached()) {
                    return;
                }

                if (questionList != null) {
                    getMvpView().reloadQuestionnaire(questionList);
                }
            }
        }));
    }

    @Override
    public void onNavMenuCreated() {
        if (!isViewAttached()) {
            return;
        }
        getMvpView().updateAppVersion();

        final String currentUserName = getDataManager().getCurrentUserName();
        if (currentUserName != null && !currentUserName.isEmpty()) {
            getMvpView().updateUserName(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (currentUserEmail != null && !currentUserEmail.isEmpty()) {
            getMvpView().updateUserEmail(currentUserEmail);
        }

        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (profilePicUrl != null && !profilePicUrl.isEmpty()) {
            getMvpView().updateUserProfilePic(profilePicUrl);
        }
    }

}
