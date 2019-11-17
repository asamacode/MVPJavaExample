package com.asama.luong.mvpjavaexample.ui.main.rating;

import com.asama.luong.mvpjavaexample.ui.base.MvpPresenter;

public interface RatingDialogMvpPresenter<V extends RatingDialogMvpView> extends MvpPresenter<V> {

    void onRatingSubmitted(float rating, String message);

    void onCancelClicked();

    void onLaterClicked();

    void onPlayStoreRatingClicked();
}
