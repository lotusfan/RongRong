package com.rongrong;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongrong.model.UserTb;

/**
 * Created by zhangfan on 15/8/18.
 */
public class JsonTest {
    public static void main(String[] args) {


        UserTb userTb = new UserTb();
        userTb.setId(2);
        userTb.setCurrentPage(3);
        String str = JSON.toJSONString(userTb);
        System.out.println(str);

        UserTb user = JSON.toJavaObject(JSONObject.parseObject(str), UserTb.class);

        System.out.println(user);
        System.out.println(user.getCurrentPage());

    }
}
