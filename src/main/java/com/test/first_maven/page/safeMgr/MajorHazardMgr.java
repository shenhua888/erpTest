package com.test.first_maven.page.safeMgr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.first_maven.base.helper.Tools;
import com.test.first_maven.base.selenium.WebAction;

public class MajorHazardMgr {
	
	@FindBy(xpath = "//a[contains(@onclick,'重大危险源登记')]")
	@CacheLookup
	private WebElement majorHazardCatlog;		
	
	private WebDriver driver;
	
	public MajorHazardMgr (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//进入重大危险源登记目录
	public void enterCatlog() {
		majorHazardCatlog.click();
		Boolean flag = false;
		flag = WebAction.waitUntilVisible(driver, "//*[@id='topbar']//span[text()='重大危险源登记']", 10);
		Assert.assertTrue(flag);
		Tools.wait(1);
	}

	
}
