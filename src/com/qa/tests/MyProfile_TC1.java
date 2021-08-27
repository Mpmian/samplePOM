package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.LoginPage;

public class MyProfile_TC1 {
	public static void main(String[] args) throws Exception {	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Create login object for login page
		LoginPage login = new LoginPage(driver);		
		
		// Login to the application
		login.login("sampleuserauto1", "SampAuto1");
		
		//Verify Home page is displayed 
		login.verifyHomePage();
	}
}
