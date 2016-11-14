package com.example.dj.webig;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 *描述：自定义一个Application用于创建一个全局的请求队列
 *
 * Created by dj on 2016/10/26 0026.
 */
public class MyApplication extends Application{

    private static RequestQueue queues;

    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getQueues() {
        return queues;
    }

}
