package com.test.erp.page.safeMgr;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.erp.base.helper.JSONObject2;
import com.test.erp.base.helper.Tools;
import com.test.erp.base.selenium.WebAction;

public class AddHarzardPage {
	
	@FindBy(id = "projectID")
	@CacheLookup
	private WebElement projectBtn;
	
	@FindBy(xpath = "//*[@id='v-app']//span[text()='选择 …']/..")
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
		List<WebElement> eles = driver.findElements(By.xpath("//*[@id='v-app']//*[@name='punishType']"));
		for(WebElement ele : eles) {
			ele.click();
		}
		if(null != json.getJSONArray("pictures")) {
			JSONArray jsonA=json.getJSONArray("pictures"); 
		    for(int i=0;i<jsonA.length();i++){  
		    	picBtn.click();
				Tools.wait(1);
				Tools.selectFile((String)jsonA.get(i));  
				Tools.wait(1);
		    }			
		}
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
