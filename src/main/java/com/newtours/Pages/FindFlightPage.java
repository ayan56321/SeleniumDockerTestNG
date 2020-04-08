package com.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	private WebDriver driver;
	private WebDriverWait wait ;
	
	@FindBy(name="reserveFlights")
	private WebElement reserveFlightsBtn ;
	
	@FindBy(name="buyFlights")
	private WebElement buyFlightsBtn;
	
	public FindFlightPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void submitFindFlightspage(){
		this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlightsBtn));
		this.reserveFlightsBtn.click();
	}
	
	public void gotoFlightConfirmationPage(){
		this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFlightsBtn));
		this.buyFlightsBtn.click();
	}
	
}
