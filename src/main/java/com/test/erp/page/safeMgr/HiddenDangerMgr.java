package com.test.erp.page.safeMgr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.erp.base.helper.Tools;
import com.test.erp.base.selenium.WebAction;

public class HiddenDangerMgr {
	
	@FindBy(xpath = "//a[contains(@onclick,'安全隐患登记')]")
	@CacheLookup
	private WebElement registerCatlog;	

	@FindBy(xpath = "//a[contains(@onclick,'安全隐患处罚')]")
	@CacheLookup
	private WebElement punishCatlog;	
	
	@FindBy(xpath = "//a[contains(@onclick,'安全隐患汇报')]")
	@CacheLookup
	private WebElement reportCatlog;	
	
	private WebDriver driver;
	
	public HiddenDangerMgr (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//进入安全隐患登记目录
	public void enterRegisterCatlog() {
//		registerCatlog.click();
		Boolean flag = WebAction.clickWithRetry(driver, registerCatlog, "//span[text()='安全隐患登记']", 10);
		Assert.assertTrue(flag);
		Tools.wait(1);
	}
	//进入安全隐患处罚目录
	public void enterPunishCatlog() {
//		punishCatlog.click();
		Boolean flag = WebAction.clickWithRetry(driver, punishCatlog, "//span[text()='安全隐患处罚']", 10);
		Assert.assertTrue(flag);
		Tools.wait(1);
	}
	//进入安全隐患汇报目录
	public void enterReportCatlog() {
//		reportCatlog.click();
		Boolean flag = WebAction.clickWithRetry(driver, reportCatlog, "//span[text()='安全隐患汇报']", 10);
		Assert.assertTrue(flag);
		Tools.wait(1);
	}
}
