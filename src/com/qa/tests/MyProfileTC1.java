package com.qa.tests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.LoginPage;
import com.qa.pages.MyProfilePage;

public class MyProfileTC1 {
	
	WebDriver driver;
	
	@Before
	public void getBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void verifyLoginToApplication() throws Exception {
	
	//Login to the application and verify home page
	LoginPage login = new LoginPage(driver);				
	login.login("sampleuserauto1", "SampAuto1");	
	
	//Verify Home page
	login.verifyHomePage();
	
	
	}
	
	@Test
	public void verifyMyProfilePageHeader() throws Exception {
	
	//Login to the application and verify home page		
	LoginPage login = new LoginPage(driver);				
	login.login("sampleuserauto1", "SampAuto1");
	
	//Verify Home page
	login.verifyHomePage();
	
	//Verify My Profile Page
	MyProfilePage mp = new MyProfilePage(driver);		
	mp.verifyMyProfileHeader("My Profile");
	
	}
	
	@Test
	public void verifyMyProfilePageElements() throws Exception {
	
	//Login to the application and verify home page		
	LoginPage login = new LoginPage(driver);				
	login.login("sampleuserauto1", "SampAuto1");
	
	//Verify Home page
	login.verifyHomePage();
	
	//Verify My Profile Page
	MyProfilePage mp = new MyProfilePage(driver);		
	mp.verifyMyProfilePage();
	
	}
	
	@Test
	public void verifyMyProfileLogout() throws Exception {
	
	//Login to the application and verify home page		
	LoginPage login = new LoginPage(driver);				
	login.login("sampleuserauto1", "SampAuto1");
	
	//Verify Home page
	login.verifyHomePage();
	
	//Verify My Profile Page
	MyProfilePage mp = new MyProfilePage(driver);		
	mp.verifyLogoutFunctionality();
	
	}
	
	
	//Negative testing for verifying save details btn at initial stage
	@Test
	public void verifyMyProfileSaveDetailsFunctionality() throws Exception {
	
	//Login to the application and verify home page		
	LoginPage login = new LoginPage(driver);				
	login.login("sampleuserauto1", "SampAuto1");
	
	//Verify Home page
	login.verifyHomePage();
	
	//Verify My Profile Page
	MyProfilePage mp = new MyProfilePage(driver);		
	mp.verifySaveProfileDetailsBtnState();
	
	}
	
	@Test
	public void verifyMyProfileDisplayname() throws Exception {
	
	//Login to the application and verify home page		
	LoginPage login = new LoginPage(driver);				
	login.login("sampleuserauto1", "SampAuto1");
	
	//Verify Home page
	login.verifyHomePage();
	
	//Verify My Profile Page
	MyProfilePage mp = new MyProfilePage(driver);		
	mp.verifyProfileName("Sampleuserauto1");
	
	}
	
	

	@After
	public void closeBrowser()
	{
		driver.quit();
	}
}
