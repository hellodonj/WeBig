package com.example.dj.webig.dao;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

/**
 * 描述：创建一个网络请求的方法，将MyHttpListener抽象类对象应用在这个方法中去，
 * 以后每次网络请求就调用这个方法
 * <p>
 * Created by dj on 2016/10/27 0027.
 */
public class VolleyRequest {


    public static void startRequest(final Context mContext, RequestQueue queue, String url,
                                    final MyHttpListener listener) {
        StringRequest request = new StringRequest(UrlMethod.GET_TEMPLATE_BY_PAGE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //请求成功的时候使用重写的StringRequestOk方法
                        listener.onComplete();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                listener.onError(mContext);
            }
        });
        queue.add(request);
    }

}
