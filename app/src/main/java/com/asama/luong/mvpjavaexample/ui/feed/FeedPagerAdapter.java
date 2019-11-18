package com.asama.luong.mvpjavaexample.ui.feed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.asama.luong.mvpjavaexample.ui.feed.blogs.BlogFragment;
import com.asama.luong.mvpjavaexample.ui.feed.opensource.OpenSourceFragment;

public class FeedPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public FeedPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return BlogFragment.newInstance();
            case 1:
                return OpenSourceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        this.mTabCount = count;
    }
}
