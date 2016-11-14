package com.example.dj.webig.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dj.webig.MyApplication;
import com.example.dj.webig.R;
import com.example.dj.webig.dao.UrlMethod;
import com.example.dj.webig.utils.LogUtils;

/**
 * 描述：个人中心模块Fragment
 * <p/>
 * Created by dj on 2016/10/21 0021.
 */

public class HomeFragment extends Fragment {

    //大片制作
    private TextView mProduce;
    //装逼神器
    private TextView mArtifact;

    private ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        volleyGet();
        return view;
    }

    private void volleyGet() {

        StringRequest request = new StringRequest(Request.Method.GET, UrlMethod.GET_TEMPLATE_BY_PAGE + "?pageIndex=1&pageSize=10",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        LogUtils.i("homefragment", s.toString());
                        Toast.makeText(getActivity(), s.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                LogUtils.i("homefragment", volleyError.toString());
            }
        });

        //设置请求的Tag标签，可以在全局请求队列中通过Tag标签进行请求的查找
        request.setTag("testGet");
        //将请求加入全局队列中
        MyApplication.getQueues().add(request);
    }

    @Override
    public void onStop() {
        super.onStop();
        MyApplication.getQueues().cancelAll("testGet");
    }
}
