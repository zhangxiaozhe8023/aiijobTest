

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class maillTest
{
    public static void sendemaill()
         {
        // 收件人电子邮箱
        String to = "jianhua.gao@funinhr.com";

        // 发件人电子邮箱
        String from = "980778026@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("980778026@qq.com", "uppexnffuezubchg");
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("爱招聘【个人端】异常");

            // 设置消息体
            message.setText("网址异常请查收");

            // 发送消息
            Transport.send(message);
            System.out.println("邮件发送成功--大哲哥");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}