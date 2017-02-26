package com;

public class Password {

	private String password;
	String regex = "[0-9]*";
	String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

	// String[] arrPassword = new String[password.length()];

	// String[] arrPassword;

	/*
	 * Password policy ^ # start-of-string (?=.*[0-9]) # a digit must occur at
	 * least once (?=.*[a-z]) # a lower case letter must occur at least once
	 * (?=.*[A-Z]) # an upper case letter must occur at least once
	 * (?=.*[@#$%^&+=]) # a special character must occur at least once (?=\S+$)
	 * # no whitespace allowed in the entire string .{8,} # anything, at least
	 * eight places though $ # end-of-string
	 */

	public boolean isNumber(String password) {
		if (password.matches(regex)) {
			return true;
		}
		return false;
	}

	public boolean isValidLength(String passwrod) {
		return (password.length() >= 6 && password.length() <= 12);
	}

	public String[] covertToCharArray(String password) {
		String[] arrPassword = new String[password.length()];
		for (int i = 0; i < password.length(); i++) {
			arrPassword[i] = String.valueOf(password.charAt(i));
		}
		return arrPassword;
	}

	public void display() {
		String[] arrPassword = new String[getPassword().length()];
		this.covertToCharArray(password);
		System.out.println(arrPassword);
	}

	public boolean isPasswordContainNumberSequence(String password) {
		String[] arrPassword = covertToCharArray(password);
		boolean flag = true;
		// g456hspass
		for (int i = 0; i < arrPassword.length+1; i++) {
			if (arrPassword[i].matches(regex) && arrPassword[i + 1].matches(regex)) {
				int num1 = Integer.parseInt(arrPassword[i]);
				int num2 = Integer.parseInt(arrPassword[i + 1]);
				if ((num2 - num1) == 1) {
					flag = true;
					break;
				} else
					flag = false;
			} else {
				flag = false;
			}

		}
		return flag;
	}

	public void validatePassword(String password) {
		if (isPasswordContainNumberSequence(password)) {
			System.out.println("Password should not contain Number Sequence");
		} else
			System.out.println("Password is valid");

	}

	public void validatePasswordWithRegex(String password) {
		if (password.matches(passwordRegex)) {
			System.out.println("Valid");
		} else
			System.out.println("Invalid");
	}

	public boolean validatePasswordWithRegrexBoolean(String password) {
		if (password.matches(passwordRegex) && isPasswordContainNumberSequence(password)) {
			return true;
		} else
			return false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		Password pwd = new Password();

		pwd.setPassword("navNeet125$");
		// pwd.validatePassword(pwd.getPassword());
		pwd.validatePasswordWithRegex(pwd.getPassword());

	}

}
