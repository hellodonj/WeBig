package com.example.dj.webig.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * json操作工具类
 *
 * @author peiyu
 */
public final class JSONUtil {

    private static Gson gson=new GsonBuilder().disableHtmlEscaping().create();

    private JSONUtil() {
    }

    /**
     * 从json获取指定key的字符串
     *
     * @param json json字符串
     * @param key  字符串的key
     * @return 指定key的值
     */
    public static Object getStringFromJSONObject(final String json, final String key) {

        return gson.fromJson(json,Map.class).get(key);
    }



    /**
     * 将json字符串，转换成指定java bean
     *
     * @param jsonStr   json串对象
     * @param beanClass 指定的bean
     * @param <T>       任意bean的类型
     * @return 转换后的java bean对象
     */
    public static <T> T toBean(String jsonStr, Class<T> beanClass) {
       return  gson.fromJson(jsonStr, beanClass);
    }




    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * 将传入的json字符串转换成Map
     *
     * @param jsonString 需要处理的json串
     * @return 对应的map
     */
    public static Map<String, Object> toMap(String jsonString) {

       return gson.fromJson(jsonString, Map.class);
    }

    public static <T> T fromJson(String jsonStr, Type type){
       return  gson.fromJson(jsonStr,type);
    }

    public static String toJson(Object src, Type typeOfSrc){
        return gson.toJson(src,typeOfSrc);
    }

    public static <T> List<T> toArray(String json, Class<T> beanClass){
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(json);
        JsonArray jsonArray = null;
        if(el.isJsonArray()){
            jsonArray = el.getAsJsonArray();
        }

        List<T> list =new ArrayList<>();
        Iterator it = jsonArray.iterator();
        while(it.hasNext()){
            JsonElement e = (JsonElement)it.next();
            list.add(gson.fromJson(e, beanClass));
        }

        return list;
    }

}
