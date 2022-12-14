package amazonSearch;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pdtsrch2 extends Startup {

	public Pdtsrch2 (RemoteWebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
	WebElement sr;
	
		
	public void srch(String sam) throws IOException {
		 driver.switchTo().newWindow(WindowType.TAB);
		 driver.get(url);
		// WebElement sr = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));//parent::div"));
		 sr.sendKeys(sam,Keys.ENTER);
		 File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(screenshotAs, new File ("./snaps/img2.png"));
		
	}
	
}
