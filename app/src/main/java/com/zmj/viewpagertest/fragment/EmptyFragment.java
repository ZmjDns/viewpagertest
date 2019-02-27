package com.zmj.viewpagertest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zmj.viewpagertest.R;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/2/26
 * Description :
 */
public class EmptyFragment extends BaseLazyFragment {

    private final String TAG = this.getClass().getSimpleName();

    private TextView tv_content;
    private String mTitle;

    public static EmptyFragment getEmptyFragment(String title){
        EmptyFragment fragment = new EmptyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TITLE",title);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString("TITLE");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.empty_fragment_layout,container,false);
        tv_content = view.findViewById(R.id.tv_content);

        mIsprepared = true;

        lazyLoad();
        return view;
    }

    @Override
    protected void lazyLoad() {
        if (!mIsprepared || !mIsVisible || mHasLoadedOnce){
            return;
        }
        mHasLoadedOnce = true;
        //UI、业务逻辑
        Log.d(TAG, "lazyLoad: 当前fragment：" + mTitle);
        tv_content.setText(mTitle);
    }

    public String getmTitle(){
        return mTitle;
    }
}
