package com.asama.luong.mvpjavaexample.ui.feed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FeedPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public FeedPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        this.mTabCount = count;
    }
}
