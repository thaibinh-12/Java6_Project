package com.shopme.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}
	
	public void sendThankYouEmail(String to, String orderDetails) {
		String subject = "Cảm ơn bạn đã đặt hàng của chúng tôi!";
		String body = "Cảm ơn bạn đã đặt hàng với chúng tôi. Dưới đây là thông tin đơn hàng của bạn: "+orderDetails;
		sendEmail(to, subject, body);
	}
}
