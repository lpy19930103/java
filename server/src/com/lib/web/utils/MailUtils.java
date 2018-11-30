package com.lib.web.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {

    public static void sendMail(String to, String code) {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.163.com");
        properties.setProperty("mail.smtp.auth", "true");
        Session instance = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("18519121233@163.com", "");
            }
        });

        Message message = new MimeMessage(instance);
        try {
            message.setFrom(new InternetAddress("18519121233@163.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("这个个验证邮件请激活");

            String url = "http://localhost:8080/store/UserServlet?method=active&code=" + code;
            message.setContent("<h1>来自lpy的测试注册激活邮件，点击链接激活</h1><h3><a herf = '" + url + "'>" +
                    url + "</a></h3>", "text/html;charset=UTF-8");
            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
