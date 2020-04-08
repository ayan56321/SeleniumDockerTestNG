package com.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmation {
	
	private WebDriver driver;
	private WebDriverWait wait ;
	
	@FindBy(partialLinkText="sign-in")
	private WebElement signInLink;
	
	@FindBy(linkText="Flights")
	private WebElement flightsLink;
	
	public RegistrationConfirmation(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void gotoFlightDetailsPage(){
		this.wait.until(ExpectedConditions.visibilityOf(signInLink));
		this.flightsLink.click();
	}
	

	
	
}
