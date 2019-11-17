package com.asama.luong.mvpjavaexample.ui.main.rating;

import com.asama.luong.mvpjavaexample.ui.base.DialogMvpView;

public interface RatingDialogMvpView extends DialogMvpView {

    void openPlayStoreForRating();

    void showPlayStoreRatingView();

    void showRatingMessageView();

    void hideSubmitButton();

    void disableRatingStars();

    void dismissDialog();
}
