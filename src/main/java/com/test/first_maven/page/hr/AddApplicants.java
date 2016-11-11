package com.test.first_maven.page.hr;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.test.first_maven.base.ActionUtils;
import com.test.first_maven.base.Tools;

public class AddApplicants {
	
	@FindBy(id = "reName")
	@CacheLookup
	private WebElement applicantName;
	
	@FindBy(xpath = "//*[@name='reSex']")
	@CacheLookup
	private WebElement male;
	
	@FindBy(xpath = "//*[@name='reSex']/../input[2]")
	@CacheLookup
	private WebElement feMale;	
	
	@FindBy(id = "reMobile")
	@CacheLookup
	private WebElement cellphone;
	
	@FindBy(id = "reEmail")
	@CacheLookup
	private WebElement email;
	
	@FindBy(id = "reCardNumber")
	@CacheLookup
	private WebElement reCardNumber; 	
	
	@FindBy(id = "reBirthday")
	@CacheLookup
	private WebElement reBirthday;	
	
	@FindBy(id = "reHeight")
	@CacheLookup
	private WebElement reHeight; 
	
	@FindBy(id = "reNation")
	@CacheLookup
	private WebElement reNation; 
	
	@FindBy(id = "reNativePlace")
	@CacheLookup
	private WebElement reNativePlace; 
	
	@FindBy(id = "rePermanentAddress")
	@CacheLookup
	private WebElement rePermanentAddress; 
	
	@FindBy(id = "reCardAddress")
	@CacheLookup
	private WebElement reCardAddress;	 
	
	@FindBy(id = "reFileAddress")
	@CacheLookup
	private WebElement reFileAddress;	
	
	@FindBy(id = "reOtherPhone")
	@CacheLookup
	private WebElement reOtherPhone; 
	
	@FindBy(id = "reWorkCompany")
	@CacheLookup
	private WebElement reWorkCompany;	
	
	@FindBy(id = "reEduSchool")
	@CacheLookup
	private WebElement reEduSchool; 
	
	@FindBy(id = "reEduMajor")
	@CacheLookup
	private WebElement reEduMajor;
	
	@FindBy(id = "reHopeSalarym")
	@CacheLookup
	private WebElement reHopeSalarym; 
	
	@FindBy(id = "reForwordSalaryy")
	@CacheLookup
	private WebElement reForwordSalaryy;	
	
	@FindBy(id = "reAvailableToDate")
	@CacheLookup
	private WebElement reAvailableToDate;	
	
	@FindBy(id = "reCardType")
	@CacheLookup
	private WebElement reCardType;	
	
	@FindBy(id = "reNationality")
	@CacheLookup
	private WebElement reNationality;	
	
	@FindBy(id = "reMarital")
	@CacheLookup
	private WebElement reMarital;		
	
	@FindBy(id = "reBloodtype")
	@CacheLookup
	private WebElement reBloodtype;	 
	
	@FindBy(id = "rePolity")
	@CacheLookup
	private WebElement rePolity;		
	
	@FindBy(id = "reIsConstructor")
	@CacheLookup
	private WebElement reIsConstructor;	
	
	@FindBy(id = "reEdu")
	@CacheLookup
	private WebElement reEdu;	
	
	@FindBy(xpath = "//*[@id='jobDeptName']/following-sibling::*[1]")
	@CacheLookup
	private WebElement jobDeptName;

	@FindBy(xpath = "//*[@id='jobPositionName']/following-sibling::*[1]")
	@CacheLookup
	private WebElement jobPosition;	
	
	@FindBy(xpath = "//a[text()='上传照片']")
	@CacheLookup
	private WebElement picFile;	
		
	@FindBy(xpath = "//*[@tabid='reResumeEdu']//a[@id='btnAdd']")
	@CacheLookup
	private WebElement eduAddBtn;	

	@FindBy(xpath = "//*[@tabid='reResumeEmergencyContact']//a[@id='btnAdd']")
	@CacheLookup
	private WebElement emgConAddBtn;
	
	@FindBy(xpath = "//*[@tabid='reResumeFamily']//a[@id='btnAdd']")
	@CacheLookup
	private WebElement family;	
	
	@FindBy(xpath = "//*[@tabid='reResumeWork']//a[@id='btnAdd']")
	@CacheLookup
	private WebElement workHistory;	
	
	@FindBy(id = "dataFormSave")
	@CacheLookup
	private WebElement saveBtn;	
	
	@FindBy(xpath = "//*[@id='reResumeJobItem']/tbody/tr[1]/td[2]/a")
	@CacheLookup
	private WebElement firstAppName;	
	
	private WebDriver driver;
	
	public AddApplicants (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
	}
	
	public void addCV(String dataFile) {
		Properties pps = new Properties();
		pps = Tools.readPropertiesFileObj(dataFile);
		jobDeptName.click();		
		ActionUtils.enterRecentFrame(driver, "//*[contains(@id,'ligerwindow')]");	
		ActionUtils.enterFrame(driver, "orgFrame");
		driver.findElement(By.xpath("//*[@value='" + pps.getProperty("jobDeptName") + "']/../input")).click();
		ActionUtils.enterRecentFrame(driver, "//*[contains(@id,'ligerwindow')]");
		driver.findElement(By.xpath("//*[text()='选择']")).click();
		ActionUtils.enterFrameFromDef(driver, "10000004780032");
		jobPosition.click();
		ActionUtils.enterFrameFromDef(driver, "frameDialog_");
		ActionUtils.enterFrame(driver, "dialogFrame");
		driver.findElement(By.xpath("//*[text()='" + pps.getProperty("jobPosition") + "']/../td/input")).click();
		ActionUtils.defaultFrame(driver);
		driver.findElement(By.xpath("//*[text()='确定']")).click();
		ActionUtils.enterFrameFromDef(driver, "10000004780032");
		picFile.click();
		Tools.wait(2);
		ActionUtils.enterRecentFrame(driver, "//*[contains(@id,'ligerwindow')]");
		driver.findElement(By.xpath("//*[@class='pull-left']/input")).click();
		Tools.selectFile(pps.getProperty("picFile"));
		ActionUtils.clickWithWait(driver, "//a[@ng-click='item.upload()']");
		Tools.wait(2);
		ActionUtils.defaultFrame(driver);
		driver.findElement(By.xpath("//div[text()='确定']")).click();
		Tools.wait(1);
		ActionUtils.enterRecentFrame(driver, "//*[contains(@id,'ligerwindow')]");
		driver.findElement(By.id("comCut")).click();
		ActionUtils.clickWithWait(driver, "//a[text()='完成。']");
		ActionUtils.enterFrameFromDef(driver, "10000004780032");
		applicantName.sendKeys(pps.getProperty("applicantName"));
		cellphone.sendKeys(pps.getProperty("cellphone"));
		email.sendKeys(pps.getProperty("email"));
		reCardNumber.sendKeys(pps.getProperty("reCardNumber"));
		reHeight.sendKeys(pps.getProperty("reHeight"));
		reNation.sendKeys(pps.getProperty("reNation"));
		reNativePlace.sendKeys(pps.getProperty("reNativePlace"));
		rePermanentAddress.sendKeys(pps.getProperty("rePermanentAddress"));
		reCardAddress.sendKeys(pps.getProperty("reCardAddress"));
		if (!"".equals(pps.getProperty("reFileAddress"))) {
			reFileAddress.sendKeys(pps.getProperty("reFileAddress"));
		}
		if (!"".equals(pps.getProperty("reOtherPhone"))) {
			reOtherPhone.sendKeys(pps.getProperty("reOtherPhone"));
		}
		if (!"".equals(pps.getProperty("reWorkCompany"))) {
			reWorkCompany.sendKeys(pps.getProperty("reWorkCompany"));
		}
		reEduSchool.sendKeys(pps.getProperty("reEduSchool"));
		reEduMajor.sendKeys(pps.getProperty("reEduMajor"));
		reHopeSalarym.sendKeys(pps.getProperty("reHopeSalarym"));
		reForwordSalaryy.sendKeys(pps.getProperty("reForwordSalaryy"));
		ActionUtils.jsSendKeys(driver, reAvailableToDate, pps.getProperty("reAvailableToDate"));
		if (!"".equals(pps.getProperty("reBirthday"))) {
			ActionUtils.jsSendKeys(driver, reBirthday, pps.getProperty("reBirthday"));
		}
		if (!"".equals(pps.getProperty("gender"))) {
			if (pps.getProperty("gender").equals("男")) {
				male.click();
				Assert.assertTrue(male.isSelected());
			} else {
				feMale.click();
				Assert.assertTrue(feMale.isSelected());
			}			
		}
		ActionUtils.selectByValue(reCardType, pps.getProperty("reCardType"));
		ActionUtils.selectByValue(reMarital, pps.getProperty("reMarital"));
		ActionUtils.selectByValue(reNationality, pps.getProperty("reNationality"));
		ActionUtils.selectByValue(reBloodtype, pps.getProperty("reBloodtype"));
		ActionUtils.selectByValue(rePolity, pps.getProperty("rePolity"));
		ActionUtils.selectByValue(reIsConstructor, pps.getProperty("reIsConstructor"));
		ActionUtils.selectByValue(reEdu, pps.getProperty("reEdu"));
		String eduInfo = pps.getProperty("eduInfo");
		if (!"".equals(eduInfo)) {
			String[] arrayCon = eduInfo.split(";");
			for (String mess : arrayCon) {
				ActionUtils.jsClick(driver, eduAddBtn);
				Tools.wait(1);
				String[] detail = mess.split(",");
				WebElement eduBeginDate = driver.findElement(By.id("eduBeginDate"));
				WebElement eduEndDate = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='eduEndDate']"));
				WebElement eduSchool = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='eduSchool']"));
				WebElement eduEducation = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='eduEducation']"));
				WebElement commit = driver.findElement(By.xpath("//*[text()='确定']"));
				if (!"null".equals(detail[0])) {
					ActionUtils.jsSendKeys(driver, eduBeginDate, detail[0]);
				}
				if (!"null".equals(detail[1])) {
					ActionUtils.jsSendKeys(driver, eduEndDate, detail[1]);
				}
				if (!"null".equals(detail[2])) {
					ActionUtils.jsSendKeys(driver, eduSchool, detail[2]);
				}
				if (!"null".equals(detail[4])) {
					ActionUtils.selectByValue(eduEducation, detail[4]);
				}
				commit.click();
				Tools.wait(1);
			}
		}

		String emergencyContact = pps.getProperty("emergencyContact");
		if (!"".equals(emergencyContact)) {
			String[] arrayCon = emergencyContact.split(";");
			for (String mess : arrayCon) {
				ActionUtils.jsClick(driver, emgConAddBtn);
				Tools.wait(1);
				String[] detail = mess.split(",");
				WebElement contactName = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='contactName']"));
				WebElement contactRelation = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='contactRelation']"));
				WebElement contactPhone = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='contactPhone']"));
				WebElement commit = driver.findElement(By.xpath("//*[text()='确定']"));
				if (!"null".equals(detail[0])) {
					ActionUtils.jsSendKeys(driver, contactName, detail[0]);
				}
				if (!"null".equals(detail[1])) {
					ActionUtils.selectByValue(contactRelation, detail[1]);
				}
				if (!"null".equals(detail[2])) {
					ActionUtils.jsSendKeys(driver, contactPhone, detail[2]);
				}
				commit.click();
				Tools.wait(1);
			}
		}
		
		String familyInfo = pps.getProperty("family");
		if (!"".equals(familyInfo)) {
			String[] arrayCon = familyInfo.split(";");
			for (String mess : arrayCon) {
				ActionUtils.jsClick(driver, family);
				Tools.wait(1);
				String[] detail = mess.split(",");
				WebElement famRelation = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='famRelation']"));
				WebElement famName = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='famName']"));
				WebElement commit = driver.findElement(By.xpath("//*[text()='确定']"));
				if (!"null".equals(detail[0])) {
					ActionUtils.selectByValue(famRelation, detail[0]);
				}
				if (!"null".equals(detail[1])) {
					ActionUtils.jsSendKeys(driver, famName, detail[1]);
				}
				commit.click();
				Tools.wait(1);
			}
		}
				
		String workInfo = pps.getProperty("workHistory");
		if (!"".equals(workInfo)) {
			String[] arrayCon = workInfo.split(";");
			for (String mess : arrayCon) {
				ActionUtils.jsClick(driver, workHistory);
				Tools.wait(1);
				String[] detail = mess.split(",");
				WebElement workBeginDate = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='workBeginDate']"));
				WebElement workEndDate = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='workEndDate']"));
				WebElement workCompany = driver.findElement(By.xpath("//*[@class='l-dialog-cc']//*[@name='workCompany']"));
				WebElement commit = driver.findElement(By.xpath("//*[text()='确定']"));
				if (!"null".equals(detail[0])) {
					ActionUtils.jsSendKeys(driver, workBeginDate, detail[0]);
				}
				if (!"null".equals(detail[1])) {
					ActionUtils.jsSendKeys(driver, workEndDate, detail[1]);
				}
				if (!"null".equals(detail[2])) {
					ActionUtils.jsSendKeys(driver, workCompany, detail[2]);
				}
				commit.click();
				Tools.wait(1);
			}
		}
		saveBtn.click();
		ActionUtils.clickWithWait(driver, "//*[text()='否']");
		Boolean flag = ActionUtils.isAddSuccess(firstAppName, pps.getProperty("applicantName"));
		ActionUtils.defaultFrame(driver);
		Assert.assertTrue(flag);
	}
}