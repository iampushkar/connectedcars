package com.mercedes.connectedcars.validator;

import com.mercedes.connectedcars.model.User;

public class UserValidator {

	/**
	 * This method is used to validate the user fields
	 * 
	 * @param user
	 * @return
	 */
	public User validateUser(User user) {
		User userObj = new User();
		boolean isIdValid = validateId(user.getId());
		boolean isNameValid = validateName(user.getName());
		boolean isDobValid = validateDob(user.getDob());
		boolean isSalaryValid = validateSalary(user.getSalary());
		boolean isAgeValid = validateAge(user.getAge());

		if (isIdValid && isNameValid && isDobValid && isSalaryValid && isAgeValid) {
			userObj.setId(user.getId());
			userObj.setName(user.getName());
			userObj.setDob(user.getDob());
			userObj.setSalary(user.getSalary());
			userObj.setAge(user.getAge());
		}
		return userObj;
	}

	/**
	 * @param age
	 * @return
	 */
	private boolean validateAge(int age) {
		if (age > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param salary
	 * @return
	 */
	private boolean validateSalary(double salary) {
		if (salary > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param dob
	 * @return
	 */
	private boolean validateDob(String dob) {
		if (dob != null && !dob.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @param id
	 * @return
	 */
	private boolean validateId(int id) {
		if (id > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param name
	 * @return
	 */
	private Boolean validateName(String name) {
		if (name != null && !name.isEmpty()) {
			return true;
		}
		return false;
	}

}
