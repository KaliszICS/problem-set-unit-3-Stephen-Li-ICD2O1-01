/*
File: Practice Problem Set Unit 3
Author: Stephen Li
Date Created: Mar 27, 2026
Date Last Modified: Mar 27, 2026
*/

public class ProblemSet {

	public static void main(String args[]) {
	/*
	   String result1 = isValidEmail("test@email.com"); //Valid
	   String result2 = isValidEmail("john.doe@example"); //Invalid
	   String result3 = isValidEmail("example@email.com."); //Invalid
	   String result4 = isValidEmail("@example.com"); //Invalid
	   String result5 = isValidEmail("test@email.Domainafterfinaldotismorethan6letters"); //Invalid
	   String result6 = isValidEmail("Localbeforeatsymbolismorethan64letterswhichshouldbeinvalidmorespamwapahdiiafhawowhafowhod@gmail.com"); //Invalid
	   String result7 = isValidEmail("test@multiple@gmail.com"); //Invalid
	*/
	   String result8 = isValidEmail("user+tag@mail.example.co.uk"); //Validjohn_doe@sub.domain.com
	   String result9 = isValidEmail("john_doe@sub.domain.com"); //Valid
	/*
	   System.out.println(result1);
	   System.out.println(result2);
	   System.out.println(result3);
	   System.out.println(result4);
	   System.out.println(result5);
	   System.out.println(result6);
	   System.out.println(result7);
	*/
	   System.out.println(result8);
	   System.out.println(result9);
	}
	
	public static String isValidEmail(String email1) {
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
		//if (email1Local.contains(".")) {
		//	return 
		//}
		if (email1Domain.substring(email1Domain.lastIndexOf(".") + 1).length() > 1 && email1Domain.substring(email1Domain.lastIndexOf(".") + 1).length() < 7) { //The length of the domain after the final dot must be 2-6 characters
            return "Valid";
        }
		return "Invalid: Invalid domain extension length";
	}
}