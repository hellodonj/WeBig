package com.example.dj.webig.dao;

import android.content.Context;
import android.widget.Toast;

/**
 * 描述:首先创建一个抽象类，通过这个抽象类来完成我们volley回调的功能，
 * 其中请求成功的回调每次不尽相同，所以我们将请求成功时的回调方法写
 * 成一个抽象方法在使用的时候进行实现，将不需要重写的方法写成实现的方法。
 * <p>
 * Created by dj on 2016/10/27 0027.
 */
public abstract class MyHttpListener {

    //请求成功的方法
    public abstract void onComplete();
    //请求失败的方法
    public void onError(Context context){

        Toast.makeText(context,"网络错误，请稍后再试！",Toast.LENGTH_SHORT).show();
    }

}
