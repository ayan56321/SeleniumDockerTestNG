package com.newtours.Tests;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tests.BaseTest;

import com.newtours.Pages.FindFlightPage;
import com.newtours.Pages.FlightConfirmationPage;
import com.newtours.Pages.FlightDetailsPage;
import com.newtours.Pages.RegistrationConfirmation;
import com.newtours.Pages.RegistrationPage;

public class BookFlightTest extends BaseTest{
	
	
	private String noOfPassengers;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void setUpParameters(String noOfPassengers,String expectedPrice ){
		this.expectedPrice=expectedPrice;
		this.noOfPassengers=noOfPassengers;
	}
	
	@Test
	public void registrationPageTest(){
		RegistrationPage registrationPage = new RegistrationPage(driver);
		
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium","docker");
		registrationPage.enterUserCredentials("selenium","docker");
		registrationPage.submit();
		
	}
	
	@Test (dependsOnMethods="registrationPageTest")
	public void registrationConfirmationPage(){
		RegistrationConfirmation regConf = new RegistrationConfirmation(driver);		
		regConf.gotoFlightDetailsPage();
	}
	
	@Test(dependsOnMethods="registrationConfirmationPage")
	public void flightDetailsPage(){
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.selectPassengers(noOfPassengers);
		//flightDetailsPage.selectPassengers("2");
		flightDetailsPage.findFlightsPage();
	}
	
	@Test(dependsOnMethods="flightDetailsPage")
	public void findFlightpage(){
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFindFlightspage();
		findFlightPage.gotoFlightConfirmationPage();
	}

	@Test(dependsOnMethods="findFlightpage")
	public void flightConfirmationPage(){
		FlightConfirmationPage flightCnf = new FlightConfirmationPage(driver);
		String actualPrice = flightCnf.printConfirmation();
		Assert.assertEquals(expectedPrice, actualPrice);
		flightCnf.SignOff();
	}
		
}
