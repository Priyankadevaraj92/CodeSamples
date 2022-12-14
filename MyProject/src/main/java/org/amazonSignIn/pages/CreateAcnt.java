package org.amazonSignIn.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAcnt {
	
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
	driver.get("https://www.amazon.com/");
	
	WebElement hellobtn = driver.findElement(By.id("nav-link-accountList"));
	Actions builder = new Actions(driver);
	builder.moveToElement(hellobtn);
	driver.findElement(By.linkText("Start here.")).click();
	
	//Create Account
	driver.findElement(By.id("ap_customer_name")).sendKeys("priya");
	driver.findElement(By.id("ap_email")).sendKeys("priyankadvrj@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Passw0rd");
	driver.findElement(By.name("passwordCheck")).sendKeys("Passw0rd");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.name("code")).sendKeys("529954");
	
	
	
	
	
	
		
		
		
	}
	
	

}
