package com.example.dj.webig.dao;

/**
 * 描述：url存放地址
 * <p/>
 * Created by dj on 2016/10/25 0025.
 */
public class UrlMethod {

    private static String BASE_URL = "http://192.168.57.84:8099/meav-api-webapp";

    public static String GET_TEMPLATE_BY_PAGE = BASE_URL + "/template/gettemplatesbypage";

    public static String GET_TEMPLATE_DETAIL = BASE_URL + "/template/gettemplatedetail?id=";

    public static String SUBMITREQ = BASE_URL + "/production/submitreq";

}
