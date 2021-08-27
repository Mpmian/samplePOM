package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class MyProfilePage {
WebDriver driver;
	
	//Locator for MyProfile page
	By MyProfileIcon = By.xpath("//img[@alt='My Profile']");
	By MyProfileHeader = By.xpath("//h1[contains(@class,'header__title')]");
	By FirstName = By.id("first_name");
	By LastName = By.id("last_name");
	By SubmitBtn = By.xpath("//button[@type='submit']");
	By LogoutBtn = By.xpath("//button[text()='Log out']");
	By LogInBtn = By.xpath("//a[text()='Log In']");
	By Profiledisplayname = By.xpath("//input[@id='display_name']");
	
	
	//Constructor will be automatically called once the object of the class is created
	public MyProfilePage(WebDriver driver) {
	this.driver=driver;
	}
	
	
	//Method to  verify the my profile page title header
	public void verifyMyProfileHeader(String expectedTitle) throws Exception 
	{
	
	driver.get("https://wordpress.com/me");
	pageload();
	String getheadertext = driver.findElement(MyProfileHeader).getText().trim();
	Assert.assertEquals("My profile Header title is displayed as ",expectedTitle, getheadertext);
				
	}
	
    
	//Method to  verify my profile page elements
	public void verifyMyProfilePage() throws Exception
	{
		
		
		driver.get("https://wordpress.com/me");
		pageload();
		Assert.assertTrue("My profile first name field is not displayed",driver.findElement(FirstName).isDisplayed());
		Assert.assertTrue("My profile last name field is not displayed",driver.findElement(LastName).isDisplayed());
		Assert.assertTrue("My profile save profile details button is not displayed",driver.findElement(SubmitBtn).isDisplayed());
		Assert.assertTrue("My profile log out  button is not displayed",driver.findElement(LogoutBtn).isDisplayed());
        
	}
	
    //Method to verify the save profile details is enabled/disabled
	public void verifySaveProfileDetailsBtnState()
	{
		
	driver.get("https://wordpress.com/me");
	pageload();
	 boolean actual = driver.findElement(SubmitBtn).isEnabled();
	 if(actual==true)
	 {
		 Assert.assertTrue("Save Profile details button is not enabled",actual);
	 }
	 else
	 {
		 Assert.assertTrue("Save Profile details button is disabled",actual);
	 }
	 
	}
	
	//Method to  verify profile displayed name
	public void verifyProfileName(String expectedname)
	{
		driver.get("https://wordpress.com/me");
		pageload();
		String actualname = driver.findElement(Profiledisplayname).getAttribute("value");
		Assert.assertEquals("Profile display name is not same as expected",actualname.toLowerCase(),expectedname.toLowerCase());
		
	}
	
	//Method to  verify logout functionality
	public void verifyLogoutFunctionality()
	{
		driver.get("https://wordpress.com/me");
		pageload();
		driver.findElement(LogoutBtn).click();
		pageload();
		Assert.assertTrue("Logout is not done",driver.findElement(LogInBtn).isDisplayed());
	}
	
	//Method to  wait for the page to get load
	public void pageload()
	{
		new WebDriverWait(driver, 50).until(
			      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
}
