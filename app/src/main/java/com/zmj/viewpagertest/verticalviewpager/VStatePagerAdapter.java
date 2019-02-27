package com.zmj.viewpagertest.verticalviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/2/27
 * Description :用于显示大量viewPager的Adapter
 */
public class VStatePagerAdapter extends FragmentStatePagerAdapter {

    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private List<String> urlList;
    private PicFragment picFragment;

    public VStatePagerAdapter(FragmentManager fm,Context mContext,List<String> urlList) {
        super(fm);
        this.mContext = mContext;
        this.urlList = urlList;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= urlList.size()){
            picFragment = PicFragment.getPicFragment(urlList.get(position % urlList.size()));
        }else {
            picFragment = PicFragment.getPicFragment(urlList.get(position));
        }
        //picFragment.setContext(mContext);

        return picFragment;
    }

    @Override
    public int getCount() {
        return urlList.size();
    }

    @NonNull    //此函数回调用getItem（）
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    public void setUrlList(List<String> urlList){
        this.urlList = urlList;
    }
}
