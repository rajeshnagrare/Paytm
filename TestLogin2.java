package test;

import java.util.Scanner;

import com.OTP;
import com.Password;
import com.UserId;

public class TestLogin2 {

	public static final String VALID_USER_ID = "9021416454";
	public static final String VALID_PASSWORD = "P@ssword1";

	public static void main(String[] args) {
		UserId userId = new UserId();
		OTP otp = new OTP();
		Password password = new Password();

		boolean loginSuccess = false;

		String strUserId = null;
		String strOtp = null;
		String strSystemOtp = null;
		String strPassword = null;
		String strUserResponseForOtp = "y";
		String strUserResponseForUserId = "y";
		String strUserResponseForPassword = "y";

		System.out.println("Hi");
		Scanner reader = new Scanner(System.in);
		while (loginSuccess == false) {
			System.out.println("Enter User Id :");
			strUserId = reader.nextLine();
			// userId.setUserId(strUserId);
			if (strUserId.equals(VALID_USER_ID)) {
				System.out.println("Enter Password :");
				strPassword = reader.nextLine();
				// password.setPassword(strPassword);
				if (strPassword.equals(VALID_PASSWORD)) {
					while (strUserResponseForOtp.equalsIgnoreCase("y")) {
						strSystemOtp = otp.generateOTPNew();
						System.out.println("Your OTP for user " + strUserId + " is :" + strSystemOtp);
						System.out.println("We have sent you OTP. Please enter to validate :");
						strOtp = reader.nextLine();
						otp.setOtp(strOtp);
						if (strSystemOtp.equals(otp.getOtp())) {
							loginSuccess = true;
							System.out.println("Login Successful. Welcome!!!");
							break;
						} else {
							System.out.println("OTP is incorrect. Do you want to try again? (y/n)");
							strUserResponseForOtp = reader.nextLine();
							if (strUserResponseForOtp.equalsIgnoreCase("n")) {
								loginSuccess = false;
								System.out.println("Application is closing. Bye bye");
							}
						}
					} // while

				} // if
			} // if
			else
				System.out.println("Invalid Credentials");
		} // while

	}// main

}// class
