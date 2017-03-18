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

public class JobAssignPage {
	
	@FindBy(xpath = "//button/span[text()='新增']")
	@CacheLookup
	private WebElement addBtn;	

	@FindBy(xpath = "//button/span[text()='删除']")
	@CacheLookup
	private WebElement delBtn;	
	
	@FindBy(xpath = "//button/span[text()='编辑']")
	@CacheLookup
	private WebElement editBtn;
	
	@FindBy(xpath = "//button/span[text()='高级搜索']")
	@CacheLookup
	private WebElement advSearch;	
	
	private WebDriver driver;
	
	public JobAssignPage (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe_')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//新增工作指派
	public void add(String paras) {
		WebAction.clickWithExpect(driver, addBtn, "iframe$undefined");
		Tools.wait(2);
		AddJobAssign addJobAssion = new AddJobAssign(driver);
		addJobAssion.add(paras);
		
	}
	
}
