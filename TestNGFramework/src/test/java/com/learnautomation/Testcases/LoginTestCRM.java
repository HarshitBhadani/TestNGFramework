package com.learnautomation.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.Pages.LoginPage;
import com.learnautomation.Utilities.BaseClass;

public class LoginTestCRM extends BaseClass{
	
	LoginPage lpage;
	
	@Test
	public void Login() {
		test = extent.createTest("Login to HomePage").assignAuthor("Harshit").assignDevice("Windows");
		lpage = PageFactory.initElements(driver, LoginPage.class);
		test.info("Login to HomePage");
		lpage.LoginToCRM(exceldp.getStringData("Login", 0, 0), exceldp.getStringData("Login", 0, 1));
		test.pass("Able to Login To app");
		
	}

}
