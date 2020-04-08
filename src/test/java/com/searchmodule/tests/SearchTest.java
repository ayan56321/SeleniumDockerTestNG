package com.searchmodule.tests;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import tests.BaseTest;

import com.SearchModule.pages.SearchPage;

public class SearchTest extends BaseTest {
	
	@Test
	@Parameters({"keyword"})
	public void search(String keyword){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.gotoVideos();
		//searchPage.getResult();
		Assert.assertTrue(searchPage.getResult() > 0);
	}
}
