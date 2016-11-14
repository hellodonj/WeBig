package com.example.dj.webig.dao;

import com.example.dj.webig.model.response.TemplateDetailResponse;

import java.util.List;

/**
 *描述：返回数据result下面的变量
 *
 * Created by dj on 2016/10/26 0026.
 */
public class ResultDataObj {

    //模板详情的result
    public TemplateDetailResponse templateDetail;

    //带分页的查询视频模板数据
    public long hasNextPage;
    public List<TemplateDetailResponse> templateDTOs;

}
