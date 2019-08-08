package com.zt.seatcommon.utils;

public class Constant {
    //用户信息在redis中的保存时间（秒）
    public static final long userInfoInRedisTime = 60*60*24*7;

    //密码盐
    public static final String passwordSalt = "!@o.oump#$ump%ump@pump***p^_^&*(a.a)";

    //短信验证码在redis中存储的时间（秒）
    public static final long msgCodeInRedisTime = 60*10;



    //交换机
    public static final String EXCHANGE   = "seat-admin-exchange";
    //路邮件
    public static final String ROUTINGKEY = "seat-admin-routingKey";
    //队列
    public static String QUEUE = "seat-admin-queue-test";
}
