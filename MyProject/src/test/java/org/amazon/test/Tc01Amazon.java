package org.amazon.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.amazonSignIn.pages.EnterEmail;
import org.amazonSignIn.pages.PasswordPage;
import org.amazonSignIn.pages.SignInBtn;
import org.amazonSignIn.pages.Startup;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.auto.common.Visibility;

import amazonSearch.Pdtsrch2;
import amazonSearch.PrductSearch;
import utils.DataUtils;

public class Tc01Amazon extends Startup {

	//String emailorNo ="8609895686";
	//String password ="Passw0rd";
	String app= "Apple";
	String sam= "samsung";


	//@Parameters({"emailorNo","password"}) 
	@Test (dataProvider = "data",
			dataProviderClass = DataUtils.class)   
	public void signin(String email, String pass) {


		SignInBtn sb= new SignInBtn(driver);
		boolean hellobtn2 = sb.Hellobtn();
		assertEquals(hellobtn2, true);
		EnterEmail ss = sb.signInBtnClick();

		PasswordPage page = ss.enteremailAndContinue(email);
		boolean continueBtn = ss.continueBtn();
		assertEquals(true, continueBtn);
		page.passwordAndClickSignIn(pass);

		//		SignInBtn sb= new SignInBtn(driver);
		//		boolean hellobtn2 = sb.Hellobtn();
		//		assertEquals(hellobtn2, true);
		//		sb.hellosignIn();
		//
		//		boolean ss = sb.signinbtn();
		//		assertTrue(ss);
		//
		//
		//		EnterEmail em= new EnterEmail(driver);
		//		em.enteremailAndContinue(email);
		//		boolean continueBtn = em.continueBtn();
		//		assertEquals(true, continueBtn);
		//
		//		PasswordPage pp= new PasswordPage(driver);
		//		pp.passwordAndClickSignIn(pass);


	}

	@Test(dependsOnMethods = {"signin"}, priority=1, groups= {"search"})
	public void search() throws IOException {
		PrductSearch pd= new PrductSearch(driver);
		pd.pdtSearch(app);

	}

	@Test(priority=2, groups= {"search"})
	public void srch2() throws IOException {
		Pdtsrch2 pd2= new Pdtsrch2(driver);
		pd2.srch(sam);  
	}




}

