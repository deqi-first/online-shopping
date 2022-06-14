package com.itqf.utils;


import com.itqf.entity.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;


//注册成功验证邮件发送
public class EmailUtils {
    public static void sendEmail(User user) {
        //qq账户
        String myAccount = "3504164084@qq.com";
        //授权码
        String myAuthorizationCode = "zamtebxoejvmchjh";
        //发件人邮箱的smtp服务器地址。也可以写smtp.163.com
        String smtpHost = "smtp.qq.com";
        //
        Properties properties = new Properties();
        //“smtp.qq.com"可以改比如改成smtp.163.com
        properties.setProperty("mail.host",smtpHost);
        //mail.transport.protocol邮件传输协议,这里是smtp传输协议
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.port","587");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.debug","true");
        //设置key和value
        Session session = Session.getDefaultInstance(properties);
        Transport ts = null;
        try {
            //获取到传输的对象 发送邮件
            ts = session.getTransport();
            //pxxebkqkejiqcjei
            //发送邮件之前，校验账号和密码(这个密码不是qq号的密码，而是授权码）
            ts.connect(properties.getProperty("mail.host"),myAccount,myAuthorizationCode);//两个参数，一个账号，一个密码

            //邮件
            MimeMessage message = createMsg(session,myAccount,user);
            //发送邮件
            ts.sendMessage(message,message.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ts!=null){
                try {
                    ts.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static MimeMessage createMsg(Session session,String myAccount,User user){
        //构建一封邮件
        MimeMessage message = new MimeMessage(session);
        //发件人
        try {
            message.setFrom(new InternetAddress(myAccount));
            //收件人
            //Message.RecipientType.TO表示收件人
            //Message.RecipientType.CC抄送//A发邮件给B，但希望领导C也看见，就抄送给C
            //Message.RecipientType.BCC暗送
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getUemail()));
            //把文件抄送给xxx@qq.com
//            message.setRecipient(Message.RecipientType.CC,new InternetAddress("xxx@qq.com"));
            //主题
            message.setSubject("myshop商城账号激活邮件");
            //设置正文(给个编码格式)
            String ip = Inet4Address.getLocalHost().getHostAddress();
            String url = "http://"+ip+":8080/qfshop_war_exploded/user?method=active&c="+user.getUcode();
            message.setContent(user.getUname()+",您好<br>欢迎注册myshop商城！请点击连接进行激活：<a href='"+url+"'>"+url+"</a>","text/html;charset=utf-8");
            //保存邮件
            message.saveChanges();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message;
    }

}
