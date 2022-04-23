package com.itqf.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

//生成邮箱验证 激活码 使用随机数
public class RandomUtils {
    //当前时间+随机数
    public static String createActive() {
        //toHexString()转换成的16进制使用parseUnsignedInt()转回10进制
        /*
         * random.nextInt(900)
         *该方法的作用是生成一个随机的int值，
         * 该值介于[0,900)的区间，也就是0到900之间的随机int值，包含0而不包含900。
         * */

        return getTime() + Integer.toHexString(new Random().nextInt(900) + 100);
    }

    public static String getTime() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
    }

    //生成订单编号
    public static String createOrderId() {
        return getTime();
    }
}
