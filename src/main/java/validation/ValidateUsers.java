package validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Users;

public class ValidateUsers {

	private void checkUsername(String username, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(username);

		if (m.matches()) {
			if (errorMap.get("username") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Username cannot be empty");
				errorMap.put("username", errorList);
			} else {
				List<String> errorList = errorMap.get("username");
				errorList.add("Username cannot be empty");
				errorMap.put("username", errorList);
			}
		}

		p = Pattern.compile("^.{3,}$");
		m = p.matcher(username);

		if (!m.matches()) {
			if (errorMap.get("username") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Username length must be minium 3 characters");
				errorMap.put("username", errorList);
			} else {
				List<String> errorList = errorMap.get("username");
				errorList.add("Username length must be minium 3 characters");

				errorMap.put("username", errorList);
			}
		}
	}

	private void checkPassword(String password, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(password);

		if (m.matches()) {
			if (errorMap.get("password") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Password cannot be empty");
				errorMap.put("password", errorList);
			} else {
				List<String> errorList = errorMap.get("password");
				errorList.add("Password cannot be empty");
				errorMap.put("password", errorList);
			}
		}

		p = Pattern.compile("^.{6,}$");
		m = p.matcher(password);

		if (!m.matches()) {
			if (errorMap.get("password") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Password length must be minium 6 characters ");
				errorMap.put("password", errorList);
			} else {
				List<String> errorList = errorMap.get("password");
				errorList.add("Password length must be minium 6 characters");

				errorMap.put("password", errorList);
			}
		}
	}

	private void checkEmail(String email, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(email);

		if (m.matches()) {
			if (errorMap.get("email") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Email cannot be empty");
				errorMap.put("email", errorList);
			} else {
				List<String> errorList = errorMap.get("email");
				errorList.add("Email cannot be empty");
				errorMap.put("email", errorList);
			}
		}

		p = Pattern.compile("^.{3,}$");
		m = p.matcher(email);

		if (!m.matches()) {
			if (errorMap.get("email") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Email length must be minium 3 characters");
				errorMap.put("email", errorList);
			} else {
				List<String> errorList = errorMap.get("email");
				errorList.add("Email length must be minium 3 characters");

				errorMap.put("email", errorList);
			}
		}
	}

	private void checkPhone(String phoneNo, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher m = p.matcher(phoneNo);

		if (!m.matches()) {
			if (errorMap.get("phoneNo") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("PhoneNo cannot be empty");
				errorMap.put("phoneNo", errorList);
			} else {
				List<String> errorList = errorMap.get("phoneNo");
				errorList.add("PhoneNo cannot be empty");
				errorMap.put("phoneNo", errorList);
			}
		}
	}
	
	private void checkAddress(String address, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(address);

		if (m.matches()) {
			if (errorMap.get("address") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Address cannot be empty");
				errorMap.put("address", errorList);
			} else {
				List<String> errorList = errorMap.get("address");
				errorList.add("Address cannot be empty");
				errorMap.put("address", errorList);
			}
		}

		p = Pattern.compile("^.{3,}$");
		m = p.matcher(address);

		if (!m.matches()) {
			if (errorMap.get("address") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Addrsss length must be minium 3 characters");
				errorMap.put("address", errorList);
			} else {
				List<String> errorList = errorMap.get("address");
				errorList.add("Address length must be minium 3 characters");

				errorMap.put("address", errorList);
			}
		}
	}


	public Map<String, List<String>> validateUsers(Users u) {
		Map<String, List<String>> errorMap = new HashMap<String, List<String>>();

		checkUsername(u.getUsername(), errorMap);
		checkPassword(u.getPassword(), errorMap);
		checkEmail(u.getEmail(), errorMap);
		checkPhone(u.getPhoneNo(), errorMap);
		checkAddress(u.getAddress(), errorMap);

		return errorMap;
	}

}