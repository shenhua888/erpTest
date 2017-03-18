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

public class AddJobAssign {
	
	@FindBy(id = "txtsubject")
	@CacheLookup
	private WebElement subjectField;	

	@FindBy(xpath = "//*[@id='assignUsers']/span")
	@CacheLookup
	private WebElement assignedBtn;	
	
	@FindBy(id = "reply_time")
	@CacheLookup
	private WebElement replyTimeBtn;	

	@FindBy(xpath = "//th[contains(text(),'指派工作内容')]/following-sibling::*[1]/textarea")
	@CacheLookup
	private WebElement jobDescField;	

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
	
	public AddJobAssign (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//新增安全隐患
	public void add(String paras) {
		JSONObject json= new JSONObject2(paras);
		subjectField.sendKeys((String)json.get("subject"));
		jobDescField.sendKeys((String)json.get("jobDesc"));
		WebAction.jsSendKeys(driver, replyTimeBtn, (String)json.get("replyTime"));
		assignedBtn.click();
		Tools.wait(2);
		SelectUserPage selUser = new SelectUserPage(driver);
		selUser.selectUser((String)json.get("userName"));
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
