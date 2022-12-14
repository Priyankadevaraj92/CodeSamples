package org.amazonSignIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterEmail extends Startup{

	public EnterEmail (RemoteWebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(id="ap_email")
   WebElement email;
   
   @FindBy(id="a-form-label")
   WebElement emailtxt;
   
   @FindBy(className="a-button-input")
   WebElement contBtn;

	public PasswordPage enteremailAndContinue(String emailNo) {
		new EnterEmail(driver);
		InputFieldEmail(emailNo);
		continueBtn();
		PasswordPage pp = new PasswordPage(driver);
        return pp; 
	}

	public void Emailtext() {
		//System.out.println(driver.findElement(By.className("a-form-label")).getText());
		System.out.println(emailtxt.getText());

	}

	public void InputFieldEmail(String emailNo) {
		email.sendKeys(emailNo);
		//driver.findElement(By.id("ap_email")).sendKeys(emailNo);
	}

	public boolean continueBtn() {	
	//	WebElement contBtn = driver.findElement(By.className("a-button-input"));
		boolean displayed = contBtn.isDisplayed();
		System.out.println(contBtn.getText());
		contBtn.click();
		return displayed;
	}




}
