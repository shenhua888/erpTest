package com.test.first_maven.page.safeMgr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.first_maven.base.helper.Tools;
import com.test.first_maven.base.selenium.WebAction;

public class SelectProjectPage {
	
	@FindBy(xpath = "//span[text()='高级搜索']")
	@CacheLookup
	private WebElement advSearchBtn;	

	@FindBy(xpath = "//span[text()='确认']")
	@CacheLookup
	private WebElement confirmBtn;	

	@FindBy(xpath = "//*[@id='v-app']//input[@value='GO!']")
	@CacheLookup
	private WebElement goBtn;
	
	private WebDriver driver;
	
	public SelectProjectPage (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
		WebAction.waitUntilVisible(driver, "//*[@id='v-app']//input[@value='GO!']", 10);
	}
	//新增安全隐患
	public void selectProject(String projectName) {		
		WebAction.clickWithExpectSameFrm(driver, advSearchBtn, "//*[@id='topbar-dropmenu']//label[text()='项目名称：']/../div//input");
		driver.findElement(By.xpath("//*[@id='topbar-dropmenu']//label[text()='项目名称：']/../div//input")).sendKeys(projectName);
		driver.findElement(By.xpath("//span[text()='查询']")).click();
		WebAction.waitAttribute(driver, "//*[@id='v-app']/div[2]/div", "style", "display: none;");
		driver.findElement(By.xpath("//*[@id='v-app']//input[@name='radioButtonItem']/../span")).click();
		confirmBtn.click();
	}
	
}
