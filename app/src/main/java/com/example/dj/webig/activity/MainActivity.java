package com.example.dj.webig.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dj.webig.R;
import com.example.dj.webig.fragment.DraftFragment;
import com.example.dj.webig.fragment.HomeFragment;
import com.example.dj.webig.fragment.PeopleFragment;


/**
 * 描述:主Activity
 * <p>
 * Created by dj on 2016/10/21 0021.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    //模板商城布局
    private View mallLayout;
    //草稿箱布局
    private View draftLayout;
    //个人中心布局
    private View peopleLayout;
    //模板商城按钮
    private ImageView mallImage;
    //草稿箱按钮
    private ImageView draftImage;
    //个人中心按钮
    private ImageView peopleImage;

    private HomeFragment homeFragment;

    private DraftFragment draftFragment;

    private PeopleFragment peopleFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化布局View
        initViews();

        //第一次启动选中第0个tab
        getFragment(0);
    }

    private void initViews() {
        mallLayout = findViewById(R.id.mall_layout);
        draftLayout = findViewById(R.id.draft_layout);
        peopleLayout = findViewById(R.id.people_layout);

        mallImage = (ImageView) findViewById(R.id.mall_image);
        draftImage = (ImageView) findViewById(R.id.draft_image);
        peopleImage = (ImageView) findViewById(R.id.people_image);

        mallLayout.setOnClickListener(this);
        draftLayout.setOnClickListener(this);
        peopleLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mall_layout:
                //当点模板商城tab时，选中第0个tab
                getFragment(0);
                break;
            case R.id.draft_layout:
                //当点草稿箱tab时，选中第1个tab
                getFragment(1);
                break;
            case R.id.people_layout:
                //当点个人中心tab时，选中第2个tab
                getFragment(2);
                break;
            default:
                break;

        }
    }

    //region 根据传入的index参数来设置选中的tab页.
    // 每个tab页对应的下标，0表示模板商城，1表示草稿箱，2表示个人中心
    private void getFragment(int i) {

        //用于对Fragment进行管理
        FragmentManager fragmentManager = getFragmentManager();
        //每次选中之前先清除上次的选中状态
        clearSelection();
        //开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();

//        //先隐藏掉所有的Fragment，以防止多个Fragment显示在界面上的情况
//        hideFragments(transaction);
        switch (i) {
            case 0:
                //当点模板商城tab时，改变控件图片的颜色
                mallImage.setImageResource(R.mipmap.frame_mall_select);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                transaction.replace(R.id.fragment_container, homeFragment);
                break;
            case 1:
                //当点草稿箱tab时，改变控件图片的颜色
                draftImage.setImageResource(R.mipmap.frame_draft_select);
                if (draftFragment == null) {
                    draftFragment = new DraftFragment();
                }
                transaction.replace(R.id.fragment_container, draftFragment);
                break;
            case 2:
                //当点个人中心tab时，改变控件图片的颜色
                peopleImage.setImageResource(R.mipmap.frame_people_select);
                if (peopleFragment == null) {
                    peopleFragment = new PeopleFragment();
                }
                transaction.replace(R.id.fragment_container, peopleFragment);
                break;
        }
        //只有提交才有效果
        transaction.commit();
    }
    //endregion

    //清除所有的选中状态
    private void clearSelection() {
        mallImage.setImageResource(R.mipmap.frame_mall_normal);
        draftImage.setImageResource(R.mipmap.frame_draft_normal);
        peopleImage.setImageResource(R.mipmap.frame_people_normal);

    }

    //隐藏所有的Fragment
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (draftFragment != null) {
            transaction.hide(draftFragment);
        }
        if (peopleFragment != null) {
            transaction.hide(peopleFragment);
        }
    }
}
