package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ScheduleNotificationRequest;
import com.example.demo.service.SmsService;

@RestController
public class NotificationController {

	private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
	
	@Autowired
	private SmsService smsService;

	@PostMapping("/schedule-notification")
	public String scheduleNotification(@RequestBody ScheduleNotificationRequest request) {
		System.out.println("method called!!");
		long delay = request.getTime().minusSeconds(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).getSecond();
		executorService.schedule(() -> sendNotification(request.getMobileNum(),request.getMessage()), delay, TimeUnit.SECONDS);
		return "Notification scheduled";
	}

	private void sendNotification( String message, String mobileNum) {
		System.out.println("sms sending started!!");
		smsService.sendSms(mobileNum, message);
		
		System.out.println("Sending notification: " + message);
	}
}