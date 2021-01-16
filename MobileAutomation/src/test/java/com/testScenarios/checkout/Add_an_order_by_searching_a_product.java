package com.testScenarios.checkout;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.Account;
import com.pages.PDP;
import com.reusable.components.DriverBaseClass;

import io.qameta.allure.Feature;

public class Add_an_order_by_searching_a_product extends DriverBaseClass{

	// TestData used for this test
	String userType = "LoggedInUser";
	

	@Test(testName = "Search for a given product and Add to cart")
	@Feature("Checkout")
	public void testMethod() {
		//Get WebDriver from BaseClass
		WebDriver driver = getDriver();

		// Create object that are being used in this test scenario
		Account account = new Account(driver);
		PDP pdp = new PDP(driver);

		// Login with emailID
		account.loginAccount(userType);
		// Select a product from search result
		pdp.addItemToCart();
		
	}
}
