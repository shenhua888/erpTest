package com.test.first_maven.page.safeMgr;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.first_maven.base.helper.JSONObject2;
import com.test.first_maven.base.helper.Tools;
import com.test.first_maven.base.selenium.WebAction;

public class AddHarzardPage {
	
	@FindBy(id = "projectID")
	@CacheLookup
	private WebElement projectBtn;
	
	@FindBy(xpath = "//span[text()='选择 …']")
	@CacheLookup
	private WebElement picBtn;
	
	@FindBy(xpath = "//span[text()='保存']")
	@CacheLookup
	private WebElement saveBtn;

	@FindBy(xpath = "//span[text()='提交']")
	@CacheLookup
	private WebElement submitBtn;
	
	@FindBy(xpath = "//span[text()='返回']")
	@CacheLookup
	private WebElement returnBtn;	
	
	private WebDriver driver;
	
	public AddHarzardPage (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);	
		WebAction.waitUntilExist(driver, "//*[@id='kvFileinputModal']", 10);
	}
	//新增安全隐患
	public void add(String paras) {
		JSONObject json= new JSONObject2(paras);
		projectBtn.click();
		Tools.wait(2);
		SelectProjectPage selProject = new SelectProjectPage(driver);
		selProject.selectProject((String)json.get("projectName"));
		Tools.wait(1);
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		if(null != json.get("saveType")) {
	    	if(json.get("saveType").equals("保存")) {
	    		saveBtn.click();
	    	} else {
	    		submitBtn.click();
	    	}	    	
	    } else {
	    	submitBtn.click();
	    }	
	}
	
}
