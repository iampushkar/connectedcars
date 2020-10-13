package com.mercedes.connectedcars.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mercedes.connectedcars.model.User;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvUtils {

	private CsvUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static final String FILEPATH = "src/main/resources/Users.csv";

	public static void writeDataInCsv(User user) {
		File file = new File(FILEPATH);
		try {
			FileWriter outputfile = new FileWriter(file, true);
			CSVWriter writer = new CSVWriter(outputfile);

			String[] userData = { Integer.toString(user.getId()), user.getName(), user.getDob(),
					Double.toString(user.getSalary()), Integer.toString(user.getAge()) };

			writer.writeNext(userData);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<User> readDataLineFromCsv() {
		List<User> userList = new ArrayList<>();
		try {
			FileReader filereader = new FileReader(FILEPATH);
			CSVReader csvReader = new CSVReader(filereader);

			List<String[]> allData = csvReader.readAll();
			Iterator<String[]> it = allData.listIterator();

			while (it.hasNext()) {
				User user = new User();
				String[] userArray = it.next();
				user.setId(Integer.valueOf(userArray[0]));
				user.setName(userArray[1]);
				user.setDob(userArray[2]);
				user.setSalary(Double.valueOf(userArray[3]));
				user.setAge(Integer.valueOf(userArray[4]));
				userList.add(user);

				System.out.println(user.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;

	}

}
