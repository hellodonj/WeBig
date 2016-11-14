package com.example.dj.webig.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dj.webig.R;

/**
 * 描述:个人中心模块Fragment
 *
 * Created by dj on 2016/10/21 0021.
 */
public class PeopleFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragme_people,container,false);
        return view;
    }
}
