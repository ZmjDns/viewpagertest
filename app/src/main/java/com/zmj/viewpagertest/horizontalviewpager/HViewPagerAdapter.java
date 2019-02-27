package com.zmj.viewpagertest.horizontalviewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.zmj.viewpagertest.fragment.EmptyFragment;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/2/26
 * Description :
 */
public class HViewPagerAdapter extends FragmentStatePagerAdapter {
    
    private final String TAG = this.getClass().getSimpleName();

    private String[] mTiles;

    public HViewPagerAdapter(FragmentManager fm,String[] mTiles) {
        super(fm);
        this.mTiles = mTiles;
    }

    @Override
    public Fragment getItem(int position) {
        EmptyFragment fragment = EmptyFragment.getEmptyFragment(mTiles[position]);
        Log.d(TAG, "getItem: 当前位置position：" + position);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTiles == null ? 0 : mTiles.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem: 当前位置position：" + position);
        return super.instantiateItem(container, position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTiles == null ? "null" : mTiles[position];
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public void setTitles(String[] titles){
        mTiles = titles;
        notifyDataSetChanged();
    }
}
