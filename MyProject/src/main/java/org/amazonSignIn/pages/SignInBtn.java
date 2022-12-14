package org.amazonSignIn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInBtn extends Startup {

	public SignInBtn (RemoteWebDriver driver) {
		this.driver= driver;
	}

	public boolean Hellobtn() {
		boolean displayed = driver.findElement(By.id("nav-link-accountList")).isDisplayed();
		return displayed ;
	}

	public void hellosignIn() {
		//System.out.println(driver.getTitle());
		WebElement HelloSignin = driver.findElement(By.id("nav-link-accountList"));
		Actions builder= new Actions(driver);
		builder.moveToElement(HelloSignin);
		//HelloSignin.click();
	}

	public boolean signinbtn() {
		WebElement ss = driver.findElement(By.linkText("Sign in"));
		boolean displayed = ss.isDisplayed();
		String signin = ss.getText();
		System.out.println(signin);
		ss.click();
		return displayed;
	}

//		public boolean signinText() {
//		 WebElement signinbtn = driver.findElement(By.linkText("Sign in"));
//		 String signin = signinbtn.getText();
//		 System.out.println(signin);
//		 return signinbtn.isDisplayed();
//		}


	public EnterEmail signInBtnClick() {
		//SignIn sn = new SignIn();
		//       sn.hellosignIn();
		//       sn.signinbtn();
		new SignInBtn(driver);
		hellosignIn();
		signinbtn();
		EnterEmail em= new EnterEmail(driver);
        return em;
	}









}


