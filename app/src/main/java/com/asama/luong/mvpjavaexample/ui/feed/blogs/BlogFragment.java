package com.asama.luong.mvpjavaexample.ui.feed.blogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.asama.luong.mvpjavaexample.R;
import com.asama.luong.mvpjavaexample.data.network.model.BlogResponse;
import com.asama.luong.mvpjavaexample.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogFragment extends BaseFragment implements BlogMvpView {

    private static final String TAG = "BlogFragment";

    @Inject
    BlogMvpPresenter<BlogMvpView> mPresenter;
    
    public static BlogFragment newInstance() {
        BlogFragment fragment = new BlogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void updateBlog(List<BlogResponse.Blog> blogList) {

    }
}
