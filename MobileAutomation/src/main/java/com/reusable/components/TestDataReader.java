package com.reusable.components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class TestDataReader {
	static String UserData;
	Object document;
	
	public TestDataReader() {
		try {
			UserData = new String(Files.readAllBytes(Paths.get("Resources/UserDetails.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] userDataReader(String userType) {
		document = Configuration.defaultConfiguration().jsonProvider().parse(UserData);
		String emailID = String.valueOf(JsonPath.read(document, "$.userDetails[?(@.userType=='" + userType + "')].emailID")).replace("[", "").replace("]", "").replace("\"", "");
		String password = String.valueOf(JsonPath.read(document, "$.userDetails[?(@.userType=='" + userType + "')].password")).replace("[", "").replace("]", "").replace("\"", "");
		return new String[] {emailID, password};
	}
}
