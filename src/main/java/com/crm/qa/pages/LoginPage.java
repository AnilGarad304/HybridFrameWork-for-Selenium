package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Define object repository by PageFactory
	//@FindBy(linkText="https://ui.freecrm.com/")
	//WebElement LinkText;
		
	@FindBy(xpath="//span[text()='Log In']")
	WebElement LinkText;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	/*<div class="Caption">
	  Model saved
	</div>
	  
	//div[contains(@class, 'ui fluid large blue submit button') and text()='Login']
	  div class="ui fluid large blue submit button">Login</div>*/
	  
	@FindBy(xpath="//div[contains(@class, 'ui fluid large blue submit button') and text()='Login']")
	WebElement signinbtn;
	
	@FindBy(linkText="Register")
	WebElement RegisterLink;
	
	//Initialising the page objects
	
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifytheTitleofpage()
	{
		return driver.getTitle();
	}
	
	public void clickOnLogin()
	{
		LinkText.click();
	}
	
	public HomePage login(String Un,String Pwd) throws IOException
	{
		
		email.sendKeys(Un);
		password.sendKeys(Pwd);
		signinbtn.click();
		return new HomePage();
	}
	
}
