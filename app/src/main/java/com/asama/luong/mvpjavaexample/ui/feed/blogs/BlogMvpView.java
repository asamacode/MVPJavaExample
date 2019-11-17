package com.asama.luong.mvpjavaexample.ui.feed.blogs;

import com.asama.luong.mvpjavaexample.data.network.model.BlogResponse;
import com.asama.luong.mvpjavaexample.ui.base.MvpView;

import java.util.List;

public interface BlogMvpView extends MvpView {

    void updateBlog(List<BlogResponse.Blog> blogList);
}
