package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.TwilioConfiguration;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {
	
    @Autowired
    private TwilioConfiguration twilioConfiguration;

    public void sendSms(String message, String mobileNumber) {
        PhoneNumber to = new PhoneNumber(mobileNumber);
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        
        Twilio.init(twilioConfiguration.getAccountId(), twilioConfiguration.getToken());
        
        System.out.println("to number ;;"+ to);
        System.out.println("from number::"+ from);
        
        Message sms = Message.creator(to, from, message).create();
        System.out.println("sms is :;");
        System.out.println(sms);
        
        System.out.println("SMS sent to " + mobileNumber + " with message " + message);
    }

}