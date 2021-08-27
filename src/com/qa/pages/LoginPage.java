package com.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;
	
	//Locator for Login page
	By Username = By.id("usernameOrEmail");
	By ContinueBtn = By.xpath("//button[text()='Continue']");
	By Password = By.id("password");
	By MyProfileIcon = By.xpath("//img[@alt='My Profile']");
	By MyHomeIcon = By.xpath("//img[@alt='My Home']");
	By LoginBtn = By.xpath("//button[text()='Log In']");
	
	
	//Constructor will be automatically called once the object of the class is created
	public LoginPage(WebDriver driver) {
			this.driver=driver;
		}
		
	
		
		//Method to  login to the application
		public void login(String username,String password) throws Exception {
			
		driver.findElement(Username).sendKeys(username);
		driver.findElement(ContinueBtn).click();			
		driver.findElement(Password).sendKeys(password);
		driver.findElement(LoginBtn).click();
		pageload();
		
		}
		
		//Method to verify home page is dispalyed after succesful login
		public void verifyHomePage()
		{
			
			Assert.assertTrue("Home page is not displayed", driver.findElement(MyProfileIcon).isDisplayed());
		}
	
		//Method to  wait for the page to get load
		public void pageload()
		{
			new WebDriverWait(driver, 50).until(
				      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		}
}
