package com.test.first_maven.page.flow;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.first_maven.base.ActionUtils;

public class AllFlowPage {
	@FindBy(xpath = "//a[text()='录用申请']")
	@CacheLookup
	private WebElement hireBtn;
	
	private WebDriver driver;
	private String currentWin;
	
	public AllFlowPage (WebDriver driver) {
		this.driver = driver;
		currentWin = driver.getWindowHandle();
		ActionUtils.enterFrameFromDef(driver, "10000004810043");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	
	public void hire (String dataFile) {
		hireBtn.click();
		ActionUtils.switchToNewWin(driver, currentWin);
		Boolean flag = null;
		flag = ActionUtils.waitUntilVisible(driver, "//*[@id='empUserType']", 10);
		Assert.assertTrue(flag);
		HireEmpPage hireEmp = new HireEmpPage(driver);
		hireEmp.hire(dataFile);
	}
}