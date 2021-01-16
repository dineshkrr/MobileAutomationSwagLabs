package com.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reusable.components.TestDataReader;
import com.reusable.components.WebElementBaseClass;

import io.qameta.allure.Step;

public class PDP extends WebElementBaseClass {

	TestDataReader testData;
	WebDriver driver;

	public static String productTitle = "XPATH://*[@text='Sauce Labs Fleece Jacket']";
	public static String addToCart = "XPATH://*[@text='ADD TO CART']";

	// Contructor to create object for TestData Reader and get WebDriver
	public PDP(WebDriver driver) {
		testData = new TestDataReader();
		this.driver = driver;
	}

	/*
	 * Add the product to cart
	 */
	@Step("Add the product to cart")
	public void addItemToCart() {
		String strProductTitle = getElement(driver, productTitle, 15).getText();
		String strPrice = scrollAndSearchElement(driver, productTitle, 10, Direction.UP, 5).getText();
		scrollAndSearchElement(driver, productTitle, 10, Direction.UP, 5).click();
		Assert.assertTrue(getElement(driver, addToCart, 10).isDisplayed(),
				"Add to Cart button should be displayed");	
		getElement(driver, addToCart, 10).click();

		}
}
