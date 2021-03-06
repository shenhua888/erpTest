package com.test.erp.page.safeMgr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.erp.base.helper.Tools;
import com.test.erp.base.selenium.WebAction;

public class SelectLabourPage {
	
	@FindBy(xpath = "//span[text()='高级搜索']")
	@CacheLookup
	private WebElement advSearchBtn;	

	@FindBy(xpath = "//span[text()='确认']")
	@CacheLookup
	private WebElement confirmBtn;	

	private WebDriver driver;
	
	public SelectLabourPage (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
		WebAction.waitUntilVisible(driver, "//*[@id='v-app']//input[@value='GO!']", 10);
	}
	//新增安全隐患
	public void selectLabour() {
		driver.findElement(By.xpath("//*[@id='v-app']//input[@name='radioButtonItem']/../span")).click();
		confirmBtn.click();
	}
	
}
