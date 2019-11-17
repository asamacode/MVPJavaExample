package com.asama.luong.mvpjavaexample.ui.feed.opensource;

import com.asama.luong.mvpjavaexample.data.network.model.OpenSourceResponse;
import com.asama.luong.mvpjavaexample.ui.base.MvpView;

import java.util.List;

public interface OpenSourceMvpView extends MvpView {

    void updateRepo(List<OpenSourceResponse.Repo> repoList);
}
