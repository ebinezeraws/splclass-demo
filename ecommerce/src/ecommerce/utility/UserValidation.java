package ecommerce.utility;

import java.util.HashMap;
import java.util.Map;

import ecommerce.dto.User;

public class UserValidation {

	public Map<String,String> validate(User user) {

		Map<String, String> errorMessages = new HashMap<String, String>();

		if (user.getUsername().isEmpty()) {
			errorMessages.put("usernameError", "Enter Username");
		}

		if (user.getEmail().isEmpty()) {
			errorMessages.put("emailError", "Enter Email");
		}

		if (user.getMobile().isEmpty()) {
			errorMessages.put("mobileError", "Enter Mobile Number");
		} else if (user.getMobile().length() != 10) {
			errorMessages.put("mobileError", "Enter valid mobile number");
		}

		if (user.getPassword().isEmpty()) {
			errorMessages.put("passwordError", "Enter Password");
		}

		if (user.getConfirmPassword().isEmpty()) {
			errorMessages.put("confirmPasswordError", "Enter Confirm Password");
		} else if (!user.getPassword().equals(user.getConfirmPassword())) {
			errorMessages.put("cofirmPasswordError", "Password and Confirm Password should be same");
		}
		
		return errorMessages;
	}

}
