package com.mercedes.connectedcars.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mercedes.connectedcars.model.User;

public class XmlUtils {

	public static final String FILEPATH = "src/main/resources/user.xml";

	public static void writeDataInXml(User user) {
		try {

		    DocumentBuilder builder = DocumentBuilderFactory.newInstance()
		            .newDocumentBuilder();
		    Document dom = builder.newDocument();

		    Element root = dom.createElement("user");
		    dom.appendChild(root);

			Element id = dom.createElement("id");
			id.setTextContent(Integer.toString(user.getId()));

		    Element name = dom.createElement("name");
			name.setTextContent(user.getName());

			Element dob = dom.createElement("dob");
			dob.setTextContent(user.getDob());

			Element salary = dom.createElement("salary");
			salary.setTextContent(Double.toString(user.getSalary()));

			Element age = dom.createElement("age");
			age.setTextContent(Integer.toString(user.getAge()));

			// add child nodes to root node
			root.appendChild(id);
		    root.appendChild(name);
			root.appendChild(dob);
			root.appendChild(salary);
			root.appendChild(age);

		    // write DOM to XML file
		    Transformer tr = TransformerFactory.newInstance().newTransformer();
		    tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.transform(new DOMSource(dom), new StreamResult(new File(FILEPATH)));

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}

	public static List<User> readFromXml() {
		List<User> list = new ArrayList<User>();

		try {
			User userXml = new User();
			// parse XML file to build DOM
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document dom = builder.parse(new File(FILEPATH));

			// normalize XML structure
			dom.normalizeDocument();

			// get root element
			Element root = dom.getDocumentElement();

			userXml.setId(Integer.parseInt(root.getAttribute("id")));
			userXml.setName(root.getElementsByTagName("name").item(0).getTextContent());
			userXml.setDob(root.getElementsByTagName("dob").item(0).getTextContent());
			userXml.setSalary(Double.parseDouble(root.getElementsByTagName("salary").item(0).getTextContent()));
			userXml.setAge(Integer.parseInt(root.getElementsByTagName("age").item(0).getTextContent()));

			System.out.println(userXml.toString());
			list.add(userXml);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
