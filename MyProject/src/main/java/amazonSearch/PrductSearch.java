package amazonSearch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrductSearch extends Startup {
	
	public PrductSearch (RemoteWebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
	WebElement sr;
	
	
	public  void pdtSearch(String app) throws IOException  {
   // WebElement sr = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));//parent::div"));
    sr.sendKeys(app,Keys.ENTER);
    File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
   	FileHandler.copy(screenshotAs, new File ("./snaps/img1.png"));
	//FileUtils.copyFile(screenshotAs,new File("./snaps/img.png"));
		
	}

}
