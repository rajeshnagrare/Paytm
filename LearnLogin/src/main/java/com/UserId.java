package com;

import java.util.Scanner;

public class UserId {
	private String userId;
	String mobileNumberRegex = "^\\d{10}$";
	String emailIdRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean validateMobileNumber(String userId) {
		if (userId.matches(mobileNumberRegex) && userId.length() == 10) {
			return true;
		} else
			return false;
	}

	public boolean validateEmailAddress(String userId) {
		if (userId.matches(emailIdRegex)) {
			return true;
		} else
			return false;
	}

	public boolean isUserIdBlank(String userId) {
		if (userId.isEmpty()) {
			return true;
		} else
			return false;
	}

	public void validateUserId(String userId) {
		if (isUserIdBlank(userId)) {
			System.out.println("User Id is required!");
		} else if (validateMobileNumber(userId) || validateEmailAddress(userId)) {
			System.out.println("Valid User Id");
		} else
			System.out.println("Invalid User Id");
	}

	public boolean validateUserIdBoolean(String userId) {
		if (validateMobileNumber(userId) || validateEmailAddress(userId)) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		System.out.println("Enter 0 to Log Out");
		UserId user = new UserId();
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter User Id: ");
		String userId = reader.nextLine();
		user.setUserId(userId);
		user.validateUserId(user.getUserId());
		reader.close();
	}

}
