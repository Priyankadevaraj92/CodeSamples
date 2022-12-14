package org.amazonSignIn.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Startup{
	protected RemoteWebDriver driver= null;
	WebDriverWait wait = null;
	String url = "https://www.amazon.com";
	String key= "webdriver.chrome.driver";
	String value=  "./drivers/chromedriver.exe";
	
	@BeforeTest
	public void startApp() {
		System.setProperty(key,value);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	} 

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

}
