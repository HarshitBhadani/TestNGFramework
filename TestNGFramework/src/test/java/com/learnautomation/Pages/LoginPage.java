package com.learnautomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "email") WebElement username;
	@FindBy(id = "passwd") WebElement password;
	@FindBy(id = "SubmitLogin") WebElement loginButton;
	//Commit 4
	public void LoginToCRM(String uname,String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
	}
}
