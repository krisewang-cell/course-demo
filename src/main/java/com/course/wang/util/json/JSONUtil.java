package com.course.wang.util.json;

import com.course.wang.vo.DD;
import com.course.wang.vo.HttpResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Wangjunlei
 * @date 2021/3/10 2:09 下午
 */
public class JSONUtil {

    private static final Gson gson = new Gson();

    /**
     * @param str    json串
     * @param tClass bean类
     * @param <T>    泛型
     * @return bean
     */
    public static <T> T fromJson(String str, Class<T> tClass) {
        return gson.fromJson(str, tClass);
    }

    /**
     * @param str       json串
     * @param typeToken 针对类内含有泛型类获取typetoken
     * @param <T>       泛型
     * @return bean
     */
    public static <T> T fromJson(String str, TypeToken<T> typeToken) {
        return gson.fromJson(str, typeToken.getType());
    }

    /**
     * @param obj bean
     * @return json串
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static void main(String[] args) {
        DD dd = new DD();
        dd.setName("阿萨德");
        dd.setUid(123);
        HttpResult<DD> result = new HttpResult<>();
        result.setData(dd);
        result.setCode(12);
        result.setMessage("asd");
        System.out.println(JSONUtil.toJson(result));
        String json = "{\"code\":12,\"message\":\"asd\",\"data\":{\"name\":\"阿萨德\",\"uid\":123}}";
        HttpResult<DD> ddHttpResult;
        ddHttpResult = JSONUtil.fromJson(json, new TypeToken<HttpResult<DD>>() {});
        System.out.println(ddHttpResult.getData().getName());

        

    }

}
