package com.example.demo.model;

import java.time.LocalDateTime;

public class ScheduleNotificationRequest {

	private LocalDateTime time;
	private String message;
	private String mobileNum;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	@Override
	public String toString() {
		return "ScheduleNotificationRequest [time=" + time + ", message=" + message + ", mobileNum=" + mobileNum + "]";
	}

}
