package com;

import java.util.Random;
import java.util.Scanner;

public class OTP {

	private String otp;
	int minimum = 111111;
	int maximum = 888888;
	Random randomGenerator = new Random();

	int randomOtp = randomGenerator.nextInt(999999);

	String otpRegex = "^\\d{6}$";

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String generateOTP() {
		return String.valueOf(randomOtp);
		//return String.format("%06d", randomOtp);
	}

	public String generateOTPNew() {
		int randomOtp = minimum + (int) (Math.random() * maximum);
		
		//int randomOtp=minimum+(int)(Math.random()* 888888);
		return String.valueOf(randomOtp);
		//return String.format("%06d", randomOtp);
	}

	public boolean isNumber(String otp) {
		if (otp.matches(otpRegex)) {
			return true;
		}
		return false;
	}

	public void validateOtp(String otp) {
		if (isNumber(otp) && generateOTP().equals(getOtp())) {
			System.out.println("Valid OTP");
		} else
			System.out.println("Invalid OTP");
	}

	public boolean validateOtpBoolean(String otp) {
		if (generateOTP().equals(getOtp())) {
			return true;
		} else
			return false;
	}

	public static void main(String args[]) {
		OTP otpObj = new OTP();
		// System.out.println(otpObj.isNumber("234123"));

		Scanner reader = new Scanner(System.in);
		for(int i=0; i<=100;i++){
			System.out.println(otpObj.generateOTPNew());
		}
//		System.out.print("Enter OTP: ");
//		String otp = reader.nextLine();
//		otpObj.setOtp(otp);
//		otpObj.validateOtp(otpObj.getOtp());
//		reader.close();

	}
}
