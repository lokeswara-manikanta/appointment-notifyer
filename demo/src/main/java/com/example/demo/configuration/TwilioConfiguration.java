package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration {

	@Value("${twilio.trial-number}")
	private String trialNumber;
	
	@Value("${twilio.account-sid}")
	private String accountId;
	
	@Value("${twilio.auth-token}")
	private String token;

	public String getTrialNumber() {
		return trialNumber;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getToken() {
		return token;
	}

}
