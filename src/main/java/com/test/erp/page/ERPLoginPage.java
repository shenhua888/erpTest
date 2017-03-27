package com.test.erp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.erp.base.selenium.WebAction;

public class ERPLoginPage {
	
	@FindBy(id = "Account")
	@CacheLookup
	private WebElement userName;
	
	@FindBy(id = "Password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath = "//*[@id='login']//button")
	@CacheLookup
	private WebElement loginBtn;	
	
	private WebDriver driver;
	
	public ERPLoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	
	public void login (String uName, String password) {
		userName.clear();
		userName.sendKeys(uName);
		this.password.clear();
		this.password.sendKeys(password);
		loginBtn.click();
		Boolean flag = WebAction.waitUntilVisible(driver, "//*[@id='sidebar-user-name']", 10);
		Assert.assertTrue(flag);	
	}
	
	public void login (String uName, String password, String errMsg) {
		userName.clear();
		userName.sendKeys(uName);
		this.password.clear();
		this.password.sendKeys(password);
		loginBtn.click();
		Boolean flag = WebAction.isEqualsExpcet(driver, "//*[@id='errorMsg']", errMsg);		
		Assert.assertTrue(flag);	
	}
}
