package com.SearchModule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait ;
	
	@FindBy(id="search_form_input_homepage")
	private WebElement searchtxtBox ;
	
	@FindBy(id="search_button_homepage")
	private WebElement searchBtn ;
	
	@FindBy(linkText="Videos")
	private WebElement videosLink ;
	
	@FindBy(className="tile--vid")
	private List<WebElement> allVideos;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void goTo(){
		this.driver.get("https://duckduckgo.com/");		
	}
	
	public void doSearch(String keyWord){
		this.wait.until(ExpectedConditions.elementToBeClickable(searchtxtBox));
		this.searchtxtBox.sendKeys(keyWord);
		this.searchBtn.click();
	}
	
	public void gotoVideos(){
		this.wait.until(ExpectedConditions.visibilityOf(videosLink));
		this.videosLink.click();
	}
	
	public int getResult(){
		By by=By.className("tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println(this.allVideos.size());
		return this.allVideos.size();
	}

}
