package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setUpDriver() throws MalformedURLException{
		// BROWSER => chrome/firefox
		// HUB_HOST => local / 10.0.1.1 / hostname
		
		String host = "localhost";
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		
		if (System.getProperty("BROWSER")!= null && 
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
			dc = DesiredCapabilities.firefox();
		}
		
		if (System.getProperty("HUB_HOST")!= null){
			host = System.getProperty("host");
		}
		
		String hostURL = "http://" +host + ":4444/wd/hub";
		this.driver= new RemoteWebDriver(new URL(hostURL), dc);
		
		/*// Set Path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\"+"chromedriver.exe");
		this.driver= new ChromeDriver();*/
	}
	
	@AfterTest
	public void tearDown(){
		this.driver.quit();
	}
	
}
