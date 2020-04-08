package com.newtours.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstNametextBox;
	
	@FindBy(name="lastName")
	private WebElement lastNametextBox;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPasswordtxt;
	
	@FindBy(name="register")
	private WebElement submitBtn;
	
	public RegistrationPage(WebDriver driver){
		this.driver = driver ;
		this.wait = new WebDriverWait(driver,30 );
		PageFactory.initElements(driver, this);
	}
	
	public void goTo(){
		this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNametextBox));
		
	}
	
	public void enterUserDetails(String firstName, String lastname){
		this.firstNametextBox.sendKeys(firstName);
		this.lastNametextBox.sendKeys(lastname);
	}
	
	public void enterUserCredentials(String username, String password){
		this.userName.sendKeys(username);
		this.password.sendKeys(password);
		this.confirmPasswordtxt.sendKeys(password);
	}
	
	public void submit(){
		this.submitBtn.click();
		//this.confirmPasswordtxt.click();
	}
	
	
}
