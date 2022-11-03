package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static 	ThreadLocal<WebDriver> tDriver=new ThreadLocal<>();
	
	// This method will initialize the thread local driver on the basis on given browser
	public WebDriver init_driver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tDriver.set(new ChromeDriver());
			
		}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tDriver.set(new FirefoxDriver());
				
			}
		else
		{
			System.out.println("Please pass the correct browser  "+ browser	);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		 return getDriver();
			
		
		
	}
	
	public static synchronized WebDriver getDriver() {
		
		return tDriver.get();
	}

}
