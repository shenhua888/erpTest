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

public class SelectUserPage {
	
	@FindBy(xpath = "//span[text()='高级搜索']")
	@CacheLookup
	private WebElement advSearchBtn;	

	@FindBy(xpath = "//span[text()='确认']")
	@CacheLookup
	private WebElement confirmBtn;	

	private WebDriver driver;
	
	public SelectUserPage (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//新增安全隐患
	public void selectUser(String projectName) {
		WebAction.clickWithExpectSameFrm(driver, advSearchBtn, "//*[@id='topbar-dropmenu']//label[text()='员工姓名：']/../div//input");
		driver.findElement(By.xpath("//*[@id='topbar-dropmenu']//label[text()='员工姓名：']/../div//input")).sendKeys(projectName);
		driver.findElement(By.xpath("//span[text()='查询']")).click();
		Tools.wait(1);
		WebAction.waitAttribute(driver, "//*[@id='v-app']/div[2]/div", "style", "display: none;");
		driver.findElement(By.xpath("//*[@id='v-app']//input[@name='checkbox']/../span")).click();
		confirmBtn.click();
	}
	
}
