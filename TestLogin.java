package test;

import java.util.Scanner;

import com.OTP;
import com.Password;
import com.UserId;

public class TestLogin {

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
			while (strUserResponseForUserId.equalsIgnoreCase("y")) {
				System.out.println("Enter User Id :");
				strUserId = reader.nextLine();
				userId.setUserId(strUserId);
				if (userId.validateUserIdBoolean(userId.getUserId())) {
					strUserResponseForUserId = "n";
					while (strUserResponseForPassword.equalsIgnoreCase("y")) {
						System.out.println("Enter Password :");
						strPassword = reader.nextLine();
						password.setPassword(strPassword);
						if (password.validatePasswordWithRegrexBoolean(password.getPassword())) {
							strUserResponseForPassword = "n";
							while (strUserResponseForOtp.equalsIgnoreCase("y")) {
								strSystemOtp = otp.generateOTPNew();
								System.out.println("Your OTP for user " + strUserId + " is :" + strSystemOtp);
								System.out.println("We have sent you OTP. Please enter to validate :");
								strOtp = reader.nextLine();
								otp.setOtp(strOtp);
								if (strSystemOtp.equals(otp.getOtp())) {
									loginSuccess = true;
									System.out.println("Welcome");
									break;
								} // ifOtp
								else {
									System.out.println("OTP is incorrect. Do you want to try again? (y/n)");
									strUserResponseForOtp = reader.nextLine();
									if (strUserResponseForOtp.equalsIgnoreCase("n")) {
										loginSuccess = false;
										System.out.println("Application is closing. Bye bye");
										break;
									} // ifOtpN
								} // ElseOtp
							} // whileOtp
						} // ifPassword
						else {
							System.out.println("Password is incorrect. Do you want to try again? (y/n)");
							strUserResponseForPassword = reader.nextLine();
							if (strUserResponseForPassword.equalsIgnoreCase("n")) {
								loginSuccess = false;
								System.out.println("Application is closing. Bye bye");
								break;
							} // ifPasswordN
						} // ElsePassword
					} // whilePassword
				} // ifUserId
				else {
					System.out.println("UserId is incorrect. Do you want to try again? (y/n)");
					strUserResponseForUserId = reader.nextLine();
					if (strUserResponseForUserId.equalsIgnoreCase("n")) {
						loginSuccess = false;
						System.out.println("Application is closing. Bye bye");
						break;
					} // ifUserIdN
				} // ElseUserId
			} // whileUserId
		} // whileLoginSuccess
	}// main
}// class
