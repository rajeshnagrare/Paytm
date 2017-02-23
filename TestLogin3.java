package test;

import java.util.Scanner;

import com.OTP;
import com.Password;
import com.UserId;

public class TestLogin3 {
	final static int MAX_OTP_RESEND = 3;
	final static int MAX_LOGIN_TRY = 3;

	public static void main(String[] args) {
		UserId userId = new UserId();
		OTP otp = new OTP();
		Password password = new Password();

		boolean loginSuccess = false;

		String strUserId = null;
		String strOtp = null;
		String strSystemOtp = null;
		String strPassword = null;
		String resendOtp = "n";
		int intResendOtpCount = 1;
		int intLoginCount = 1;

		System.out.println("Hi");
		Scanner reader = new Scanner(System.in);

		do {
			System.out.println("Enter User Id :");
			strUserId = reader.nextLine();
			userId.setUserId(strUserId);
			System.out.println("Enter Password :");
			strPassword = reader.nextLine();
			password.setPassword(strPassword);
			if (userId.validateUserIdBoolean(userId.getUserId())
					&& password.validatePasswordWithRegrexBoolean(password.getPassword())) {
				do {
					strSystemOtp = otp.generateOTPNew();
					System.out.println("Your OTP for user " + strUserId + " is :" + strSystemOtp);
					System.out.println("We have sent you OTP. Please enter to validate :");
					strOtp = reader.nextLine();
					otp.setOtp(strOtp);
					if (strSystemOtp.equals(otp.getOtp())) {
						loginSuccess = true;
						System.out.println("Login Success! Welcome");
						break;
					} else {
						System.out.println("Incorrect OTP. Do you want to resend OTP (y/n)");
						resendOtp = reader.nextLine();
						if (resendOtp.equalsIgnoreCase("n")) {
							loginSuccess = false;
						} else if (resendOtp.equalsIgnoreCase("y")) {
							if (intResendOtpCount > MAX_OTP_RESEND) {
								System.out.println("You have entered OTP incorect 3 times. No more OTP is allowed.");
								loginSuccess = true;
								break;
							} else
								intResendOtpCount++;
						}
					}
				} while (resendOtp.equalsIgnoreCase("y"));
			} else {
				System.out.println("Invalid Credentials");
				loginSuccess = false;
				if (intLoginCount > MAX_LOGIN_TRY) {
					System.out.println("Done with 3 attempts.. Account is locked for a day.");
					break;
				} else
					intLoginCount++;
			}
		} while (!loginSuccess);

		if (!loginSuccess) {
			System.out.println("1- Forgot Password");
			System.out.println("2- Forgot User Id");
			String strUserResponse = reader.nextLine();
			switch (strUserResponse) {
			case "1":
				System.out.println("You want to reset your password");
				//logic to reset password
				//First ask for userid
				//validate user id
				//generate OTP
				//validate otp
				//ask to enter new password
				//validate new password
				//display - Password is set successfully. :)
				break;
			case "2":
				System.out.println("You want to retrieve your user id");
				//logic to retrieve user id - if user id is not a mobile number :)
				//need to think how to add date of birth, security question
				break;
			default:
				System.out.println("Wrong option is selected");
				break;

			}

		}
	}
}
