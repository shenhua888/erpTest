package com.test.first_maven.page.safeMgr;

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

import com.test.first_maven.base.helper.JSONObject2;
import com.test.first_maven.base.helper.Tools;
import com.test.first_maven.base.selenium.WebAction;

public class AddHiddenDanger {
	
	@FindBy(xpath = "//*[@id='projectID']/span")
	@CacheLookup
	private WebElement projectBtn;	

	@FindBy(xpath = "//*[@id='labourID']/span")
	@CacheLookup
	private WebElement labourBtn;	
	
	@FindBy(xpath = "//*[@name='dead_line']")
	@CacheLookup
	private WebElement deadLineSel;	

	@FindBy(xpath = "//*[@name='danger_desc']")
	@CacheLookup
	private WebElement dangerDesc;	

	@FindBy(xpath = "//*[@name='rectify_desc']")
	@CacheLookup
	private WebElement rectifyDesc;

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
	
	public AddHiddenDanger (WebDriver driver) {
		this.driver = driver;
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	//新增安全隐患
	public void add(String paras) {
		JSONObject json= new JSONObject2(paras);
		dangerDesc.sendKeys((String)json.get("dangerDesc"));
		rectifyDesc.sendKeys((String)json.get("rectifyDesc"));
		String dangerType = "1";
		switch((String) json.get("dangerType")) {
		case "脚手架":
			dangerType = "1";
			break;
		case "登高作业":
			dangerType = "2";
			break;
		case "临时用电":
			dangerType = "3";
			break;
		case "施工机械":
			dangerType = "4";
			break;
		case "消防":
			dangerType = "5";
			break;
		case "职业健康":
			dangerType = "6";
			break;
		case "文明施工":
			dangerType = "7";
			break;
		case "临边洞口":
			dangerType = "8";
			break;
		case "有毒物质":
			dangerType = "9";
			break;
		case "其他":
			dangerType = "10";
			break;
		default :
			dangerType = "1";
			break;
		}
		 
		driver.findElement(By.xpath("//*[@id='v-app']//input[@name='dangerType' and @value='"+dangerType+"']")).click();
		String punishType = "1";
		switch((String) json.get("punishType")) {
		case "通报批评":
			punishType = "1";
			break;
		case "现金罚款":
			punishType = "2";
			break;
		case "工程合同扣款":
			punishType = "3";
			break;
		default :
			punishType = "1";
			break;
		}
		driver.findElement(By.xpath("//*[@id='v-app']//input[@name='punishType' and @value='"+punishType+"']")).click();
		if(null != json.get("sum")) {
			driver.findElement(By.xpath("//input[@name='punish_extend']")).sendKeys((String)json.get("sum"));
		}
		String deadLine = "1";
		switch((String) json.get("deadLine")) {
		case "一天":
			deadLine = "1";
			break;
		case "两天":
			deadLine = "2";
			break;
		case "三天":
			deadLine = "3";
			break;
		default :
			deadLine = "1";
			break;
		}
		WebAction.selectByValue(deadLineSel, deadLine);
		projectBtn.click();
		Tools.wait(2);
		SelectProjectPage selProject = new SelectProjectPage(driver);
		selProject.selectProject((String)json.get("projectName"));
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
		labourBtn.click();
		Tools.wait(2);
		SelectLabourPage selLabour = new SelectLabourPage(driver);
		selLabour.selectLabour();
		WebAction.enterRecentFrame(driver, "//*[contains(@id,'iframe$undefined')]");
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
