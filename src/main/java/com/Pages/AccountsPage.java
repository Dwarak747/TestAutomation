package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	// selecting by css selector
	private By AccountSections=By.cssSelector("div#center_column span");
	
	
	public AccountsPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String getAccountsPageTitle() {
		
		
		return driver.getTitle();
	}
	
	public int getAccountSectionCount() {
		
		return driver.findElements(AccountSections).size()	;
	}
	
	public List<String> getAccountSectionList() {
		
		List<String>  accountsList=new ArrayList<String>();
		
		List <WebElement> accounsectionList=driver.findElements(AccountSections);
		
		for (WebElement e:accounsectionList) {
			String text=e.getText();
			accountsList.add(text);
			
			
		}
		return accountsList;
	}

}
