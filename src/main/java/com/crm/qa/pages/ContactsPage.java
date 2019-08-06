package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
import com.crm.qa.base.TestBase;
//import com.sun.org.apache.bcel.internal.generic.Select;

public class ContactsPage extends TestBase
{

	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement NewContactBtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//div[@name='hint']//input[@class='search']")
	WebElement countrycode;
	
	@FindBy(xpath="//input[@placeholder='Number']")
	WebElement number;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	public ContactsPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
		
	}
	
//Actions
	public void click_on_new_contact()
	{
		NewContactBtn.click();
	}
	
	public void create_new_contact(String FN,String LN,String comp)
	{
		firstname.sendKeys(FN);
		lastname.sendKeys(LN);
		company.sendKeys(comp);
		//Select drpCountry = new Select(driver.findElement(By.name("country")));
		//drpCountry.selectByVisibleText("ANTARCTICA");
		//Select s=new Select(countrycode);
		//s.selectByVisibleText("india");
		//number.sendKeys(PN);
		saveBtn.click();
	}
}
