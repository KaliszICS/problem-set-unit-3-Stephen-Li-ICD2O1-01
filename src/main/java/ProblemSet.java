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
		String emails = input.nextLine().trim().toLowerCase();
		
		if (emails.contains(",")) {
			//Split the emails
			String email1 = emails.substring(0, emails.indexOf(",")).trim();
			String email2 = emails.substring(emails.indexOf(",") + 1).trim();
			//Validate the emails
			String rule1 = isValidEmail(email1);
			String rule2 = isValidEmail(email2);
			//Print results
			System.out.println(result(rule1, email1));
			System.out.println(result(rule2, email2));
		}
		else {
			String rule = isValidEmail(emails);
			System.out.println(result(rule, emails));
		}
	}
	
	public static String isValidEmail(String email) {
		if (!email.contains("@")) { //Contains @ check
	        return "Invalid: Missing @";
	    }
		if (email.indexOf("@") != email.lastIndexOf("@")) { //1 @ check
			return "Invalid: Multiple @";
		}
		if (email.indexOf(".") == 0 || email.lastIndexOf(".") == email.length() - 1) { //Starts/Ends with dot check
            return "Invalid: Starts or ends with dot";
        }

		String emailLocal = email.substring(0, email.indexOf("@")); //create local and domain
		String emailDomain = email.substring(email.indexOf("@") + 1);
		
		if (emailLocal.contains(".")) { //Normalize local with excption C
			emailLocal = emailLocal.replace(".", "");
		}
        if (email.contains(" ")) { //Contains spaces checks
            return "Invalid: Contains spaces";
        }
        if (emailLocal.length() < 1) { //Local too short check
			return "Invalid: Local part too short";
		}
		if (emailLocal.length() > 64) { //Local too long check
            return "Invalid: Local part too long";
        }
		if (!emailDomain.contains(".")) { //Domain contains dot checm
			return "Invalid: No dot in domain";
		}
		String emailDomainExtension = emailDomain.substring(emailDomain.lastIndexOf(".") + 1);
		if (emailDomainExtension.length() < 2 || emailDomainExtension.length() > 6) { //Domain extension between 2 - 6 characters
            return "Invalid: Invalid domain extension length";
        }
		return isValidB(email, emailDomain); //If passes checks above then it checks for exception B
	}

	public static String isValidB(String email, String emailDomain) {
		if (email.startsWith("+") || email.endsWith("+")) { //Starts/ends with + check
			return "Invalid: Starts or ends with +";
		}
		if (email.startsWith("_") || email.endsWith("_")) { //Starts/ends with _ check
			return "Invalid: Starts or ends with _";
		}
		if (emailDomain.contains("+") || emailDomain.contains("_")) { //Domain contains + or _ check
			return "Invalid: Domain contains + or _";
		}
		return "Valid"; //If passes all exception B checks then its valid
	}

	public static String result(String rule, String email) {
		//Valid
		if (rule.equals("Valid")) {
			String emailLocal = email.substring(0, email.indexOf("@"));
			String emailDomain = email.substring(email.indexOf("@") + 1);

			if (emailLocal.contains(".")) { //Check if email was normalized
				return email + ": Valid (Gmail Normalized) | Local: " + emailLocal + " | Domain: " + emailDomain;
			}
			return email + ": Valid | Local: " + emailLocal + " | Domain: " + emailDomain;
		}
		//Invalid
		return email + ": Invalid: " + rule;
	}
}