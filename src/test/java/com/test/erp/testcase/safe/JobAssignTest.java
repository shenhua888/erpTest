package com.test.erp.testcase.safe;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.erp.base.UITest;
import com.test.erp.base.helper.MySqlConnect;
import com.test.erp.base.helper.Tools;
import com.test.erp.base.selenium.NewWebDriverEventListener;
import com.test.erp.base.selenium.WebAction;
import com.test.erp.page.ERPLoginPage;
import com.test.erp.page.safeMgr.HiddenDangerMgr;
import com.test.erp.page.safeMgr.JobAssignMgr;
import com.test.erp.page.safeMgr.JobAssignPage;
import com.test.erp.page.safeMgr.RegisterPage;

public class JobAssignTest extends UITest {
	ERPLoginPage erpLogin;
	JobAssignMgr jobAssign;
	JobAssignPage jobAssignPage;
	
	@BeforeTest
	public void beforeTest() {
//		Tools.deleteDirectory("pic");
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver.exe");
		driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
		String url = "http://172.16.0.206:8089/Home/LogOn";
		WebAction.get(driver, url, "//*[@id='Account']");
		driver.manage().window().maximize();
	}

	public void login(String userName, String password) {		
		erpLogin = new ERPLoginPage(driver);
		erpLogin.login(userName, password);
	}

	public void enterCatlog() {		
		jobAssign = new JobAssignMgr(driver);
		jobAssign.enterJobAssignCatlog();
	}


	@Test
	public void add() {
		login("shenhua1", "1");
		enterCatlog();
		jobAssignPage = new JobAssignPage(driver);
		String paras = "{\"subject\":\"工作指派的主题4\"," 
				+ "\"jobDesc\":\"具体任务描述4\"," 
				+ "\"userName\":\"沈华\","
				+ "\"replyTime\":\"2017-03-30\"}";
		jobAssignPage.add(paras);
	}


	@AfterTest
	public void afterTest() {
//		 Tools.killChrome();

	}

	@AfterSuite
	public void afterSuite() {

	}
}
