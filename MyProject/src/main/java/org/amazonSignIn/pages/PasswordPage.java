package org.amazonSignIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends Startup {
	

	public PasswordPage (RemoteWebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//div/label[@class='a-form-label'][1]")
	WebElement ps;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(id="signInSubmit")
	WebElement st;
	
	public void passwordAndClickSignIn(String pass) {
		new PasswordPage(driver);
		PassInput(pass);
		signinbtn();
	}
	
	public String passText() {
		return ps.getText();
	}

	public void PassInput(String Password) {
		//driver.findElement(By.name("password")).sendKeys(Password);
		pwd.sendKeys(Password);
	}

	public String signinbtnText() {
		//return driver.findElement(By.id("signInSubmit")).getText();
		return st.getText();
		

	} 
	public void signinbtn() {
		driver.findElement(By.id("signInSubmit")).click();
		
	} 
	public String checkboxText() {
	return driver.findElement(By.xpath("//div/label[@class='a-form-label'][2]")).getText();
	}
	
	public boolean checkbox() {
		return driver.findElement(By.name("rememberMe")).isSelected();
	}
	
	public String forgotpassText() {
		return driver.findElement(By.id("auth-fpp-link-bottom")).getText();
		
	}

	public ForgetPassword forgotpass() {
		driver.findElement(By.id("auth-fpp-link-bottom")).click();
		return new ForgetPassword();
	}

	public EnterEmail change() {
		WebElement changelink = driver.findElement(By.id("ap_change_login_claim"));
		changelink.click();
		return new EnterEmail(driver);
    }

}