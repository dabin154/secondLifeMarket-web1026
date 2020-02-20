package com.secondLifeMarket.general.admin.util.framework;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JavaEmailUtil {
	
	private static final Log logger = LogFactory.getLog(JavaEmailUtil.class);

	/**
	 * 
	 * 
	 * @param mailHost：指定邮件的传输协议，smtp
	 * @param to ：目标邮箱
	 * @param from：发送邮箱
	 * @param userId：用户名
	 * @param password：密码
	 * @param subject：邮件主题
	 * @param content：邮件内容
	 * @return
	 */
    public String send(String mailHost, String to, String from, String userId, String password,
                       String subject, String content) {

        // 第一步：创建Session
        Properties props = new Properties();
        //指定邮件的传输协议，smtp(Simple Mail Transfer Protocol 简单的邮件传输协议)
        props.put("mail.transport.protocol", "smtp");
        //指定邮件服务器
        props.put("mail.host", mailHost);
        //指定邮件的发送人(您用来发送邮件的服务器，比如您的163\sina等邮箱)
        props.put("mail.from", from);
        props.setProperty("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(props);

        // 开启调试模式
//        session.setDebug(true);
        try {
            // 第二步：获取邮件发送对象
            Transport transport = session.getTransport();
            // 连接邮件服务器，链接您的163、sina邮箱，用户名（不带@163.com，登录邮箱的邮箱账号，不是邮箱地址）、密码
            transport.connect(userId, password);

            // 第三步：创建邮件消息体
            MimeMessage message = new MimeMessage(session);
            String nick = "";
            try {
                nick = javax.mail.internet.MimeUtility.encodeText("仁聚汇通");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            message.setFrom(new InternetAddress(nick + " <" + from + ">"));
            //邮件的主题
            message.setSubject(subject);
            //邮件的内容
            message.setContent(content, "text/html;charset=utf-8");
            //邮件发送时间
            message.setSentDate(new Date());

            // 第四步：发送邮件
            //第一个参数：邮件的消息体
            //第二个参数：邮件的接收人，多个接收人用逗号隔开（test1@163.com,test2@sina.com）
            transport.sendMessage(message, InternetAddress.parse(to));
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    /** 
     * 随机生成 num位数字字符数组 
     * @param num 
     * @return 
     */  
    public char[] generateRandomArray(int num) {  
        String chars = "0123456789";  
        char[] rands = new char[num];  
        for (int i = 0; i < num; i++) {  
            int rand = (int) (Math.random() * 10);  
            rands[i] = chars.charAt(rand);  
        }  
        logger.info(rands);
        return rands;  
    }  

}
