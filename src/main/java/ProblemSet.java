/*
File: Practice Problem Set Unit 3
Author: Stephen Li
Date Created: Mar 27, 2026
Date Last Modified: Mar 27, 2026
*/

import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input email(s): ");
		String emails = input.nextLine().trim();
		String email1 = "";
		String email2 = "";

		int commaLocation = emails.indexOf(",");
		if (commaLocation == -1) {
			email1 = emails;
		}
		else {
			email1 = emails.substring(0, commaLocation).trim();
			email2 = emails.substring(commaLocation + 1).trim();
		}

		System.out.println(isValidEmail1(email1));
		System.out.println(isValidEmail2(email2));
	}
	
	public static String isValidEmail1(String email1) {
		if (!email1.contains("@")) {
	        return "Invalid: Missing @";
	    }
		int checkAt1 = email1.indexOf("@");
		int checkAt2 = email1.lastIndexOf("@");
		if (checkAt1 != checkAt2) {
			return "Invalid: Multiple @";
		}

		String email1Local = email1.substring(0, email1.indexOf("@"));
		String email1Domain = email1.substring(email1.indexOf("@") + 1);
		
        if (email1.indexOf(".") == 0 || email1.lastIndexOf(".") == email1.length() - 1) {
            return "Invalid: Starts or ends with dot";
        }
        if (email1.contains(" ")) {
            return "Invalid: Contains spaces";
        }
        if (email1Local.length() < 1) {
			return "Invalid: Local part too short";
		}
		if (email1Local.length() > 64) { 
            return "Invalid: Local part too long";
        }
		if (!email1Domain.contains(".")) {
			return "Invalid: No dot in domain";
		}
		if (email1Domain.contains("+") || email1Domain.contains("_")) {
			return "Invalid: Contains + or _ in domain";
		}
		if (email1Local.contains(".")) {
			email1 = email1.substring(0, email1.indexOf(".")) + email1.substring(email1.indexOf(".") + 1);
			return "Valid (Gmail normalized) | Local: " + email1Local + " | Domain: "  + email1Domain;
		}
		if (email1Domain.substring(email1Domain.lastIndexOf(".") + 1).length() > 1 && email1Domain.substring(email1Domain.lastIndexOf(".") + 1).length() < 7) { //The length of the domain after the final dot must be 2-6 characters
            return "Valid | Local: " + email1Local + " | Domain: " + email1Domain;
        }
		return "Invalid: Invalid domain extension length";
	}

		public static String isValidEmail2(String email2) {
		if (!email2.contains("@")) {
	        return "Invalid: Missing @";
	    }
		int checkAt1 = email2.indexOf("@");
		int checkAt2 = email2.lastIndexOf("@");
		if (checkAt1 != checkAt2) {
			return "Invalid: Multiple @";
		}

		String email2Local = email2.substring(0, email2.indexOf("@"));
		String email2Domain = email2.substring(email2.indexOf("@") + 1);
		
        if (email2.indexOf(".") == 0 || email2.lastIndexOf(".") == email2.length() - 1) {
            return "Invalid: Starts or ends with dot";
        }
        if (email2.contains(" ")) {
            return "Invalid: Contains spaces";
        }
        if (email2Local.length() < 1) {
			return "Invalid: Local part too short";
		}
		if (email2Local.length() > 64) { 
            return "Invalid: Local part too long";
        }
		if (!email2Domain.contains(".")) {
			return "Invalid: No dot in domain";
		}
		if (email2Domain.contains("+") || email2Domain.contains("_")) {
			return "Invalid: Contains + or _ in domain";
		}
		if (email2Local.contains(".")) {
			email2 = email2.substring(0, email2.indexOf(".")) + email2.substring(email2.indexOf(".") + 1);
			return "Valid (Gmail normalized) | Local: " + email2Local + " | Domain: " + email2Domain;
		}
		if (email2Domain.substring(email2Domain.lastIndexOf(".") + 1).length() > 1 && email2Domain.substring(email2Domain.lastIndexOf(".") + 1).length() < 7) { //The length of the domain after the final dot must be 2-6 characters
            return "Valid | Local: " + email2Local + " | Domain: " + email2Domain;
        }
		return "Invalid: Invalid domain extension length";
	}
}