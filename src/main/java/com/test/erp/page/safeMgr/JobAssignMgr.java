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

public class JobAssignMgr {
	
	@FindBy(xpath = "//a[contains(@onclick,'工作指派')]")
	@CacheLookup
	private WebElement jobAssignCatlog;	

	@FindBy(xpath = "//a[contains(@onclick,'我的任务')]")
	@CacheLookup
	private WebElement myJobCatlog;		
	
	private WebDriver driver;
	
	public JobAssignMgr (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//进入工作指派目录
	public void enterJobAssignCatlog() {
//		jobAssignCatlog.click();
		Boolean flag = WebAction.clickWithRetry(driver, jobAssignCatlog, "//*[@id='topbar']//span[text()='工作指派']", 10);
		Assert.assertTrue(flag);
		Tools.wait(1);
	}
	//进入我的任务目录
	public void enterMyJobCatlog() {
//		myJobCatlog.click();
		Boolean flag = WebAction.clickWithRetry(driver, myJobCatlog, "//span[text()='我的任务']", 10);
		Assert.assertTrue(flag);
		Tools.wait(1);
	}
	
}
