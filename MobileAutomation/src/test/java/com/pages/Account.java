package com.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reusable.components.TestDataReader;
import com.reusable.components.WebElementBaseClass;

import io.qameta.allure.Step;

public class Account extends WebElementBaseClass {

	TestDataReader testData;
	WebDriver driver;

	// Contructor to create object for TestData Reader
	public Account(WebDriver driver) {
		testData = new TestDataReader();
		this.driver = driver;
	}

	// Locators used in this page
	public static String emailIDTxt = "XPATH://*[@text='Username']";
	public static String passwordTxt = "XPATH://*[@text='Password']";
	public static String signInBtn = "XPATH://*[@text='LOGIN']";

	/*
	 * SignIn an account with given user type.
	 */
	@Step("SignIn an account with given user type")
	public void loginAccount(String userType) {
		String[] userDetails = testData.userDataReader(userType);
		String email = userDetails[0];
		String password = userDetails[1];
		getElement(driver, emailIDTxt, 10).sendKeys(email);
		getElement(driver, passwordTxt, 10).sendKeys(password);
		getElement(driver, signInBtn, 10).click();
	}

}
