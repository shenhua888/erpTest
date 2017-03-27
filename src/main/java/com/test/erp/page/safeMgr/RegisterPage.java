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

public class RegisterPage {
	
	@FindBy(xpath = "//button/span[text()='新增']")
	@CacheLookup
	private WebElement addBtn;	

	@FindBy(xpath = "//button/span[text()='删除']")
	@CacheLookup
	private WebElement delBtn;	
	
	@FindBy(xpath = "//button/span[text()='高级搜索']")
	@CacheLookup
	private WebElement advSearch;	
	
	private WebDriver driver;
	
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe_')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
		WebAction.waitAttribute(driver, "//*[@id='topbar-dropmenu']", "style", "display: none;");
	}
	//新增安全隐患
	public void add(String paras) {
		WebAction.clickWithExpect(driver, addBtn, "iframe$undefined");
		Tools.wait(2);
		AddHiddenDanger addDanger = new AddHiddenDanger(driver);
		addDanger.add(paras);
		
	}
	
}
