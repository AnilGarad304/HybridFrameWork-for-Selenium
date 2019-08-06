package com.crm.qa.pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{

	
//Objects Repository for Home Page
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactlink;
	
	@FindBy(xpath="//span[text()='Anil Garad']")
	WebElement Logged_User;
	
	//<span class="user-display">Anil Garad</span>
	//@FindBy(xpath="//span[text()='Log In']")
	/*//div[contains(@class, 'ui fluid large blue submit button') and text()='Login']
	  div class="ui fluid large blue submit button">Login</div>*/
	  
	//@FindBy(xpath="//div[contains(@class, 'ui fluid large blue submit button') and text()='Login']")
	//WebElement signinbtn;*/
	public HomePage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
//Action 
	public String verifytheTitleofHomePage()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException
	{
		contactlink.click();
		return new ContactsPage();
	}
	
	public boolean verifyloggedUser()
	{
		return Logged_User.isDisplayed();
	}
	
}
