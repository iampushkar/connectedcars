package com.mercedes.connectedcars.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mercedes.connectedcars.model.User;
import com.mercedes.connectedcars.util.CsvUtils;
import com.mercedes.connectedcars.util.XmlUtils;
import com.mercedes.connectedcars.validator.UserValidator;

@RestController
public class ConnectedCarsController {

	private UserValidator userValidator = new UserValidator();

	@GetMapping("/ReadCSV")
	public List<User> readCsv() {
		return CsvUtils.readDataLineFromCsv();
	}

	@GetMapping("/ReadXML")
	public List<User> readXml() {
		return XmlUtils.readFromXml();
	}

	@PutMapping("/Update")
	public Boolean update() {
		return true;
	}

	@PostMapping("/Store")
	public String store(@RequestHeader(name = "filetype", required = true) String fileType, @RequestBody User user) {

		User validUser = userValidator.validateUser(user);
		System.out.println(validUser.toString());

		if (validUser != null && validUser.getId() > 0) {
			if (fileType.equals("CSV")) {
				CsvUtils.writeDataInCsv(validUser);
			} else if (fileType.equals("XML")) {
				XmlUtils.writeDataInXml(validUser);
			}
		} else {
			return "User is not Valid";
		}

		return "Saved Successfully";
	}

}
