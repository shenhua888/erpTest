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

import com.test.first_maven.base.UITest;
import com.test.first_maven.base.helper.MySqlConnect;
import com.test.first_maven.base.helper.Tools;
import com.test.first_maven.base.selenium.NewWebDriverEventListener;
import com.test.first_maven.base.selenium.WebAction;
import com.test.first_maven.page.ERPLoginPage;
import com.test.first_maven.page.safeMgr.HiddenDangerMgr;
import com.test.first_maven.page.safeMgr.RegisterPage;

public class HiddenDangerTest extends UITest {
	ERPLoginPage erpLogin;
	HiddenDangerMgr hiddenDanger;
	RegisterPage register;
	
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
		hiddenDanger = new HiddenDangerMgr(driver);
		hiddenDanger.enterRegisterCatlog();
	}


	@Test
	public void add() {
		login("shenhua1", "1");
		enterCatlog();
		register = new RegisterPage(driver);
		String paras = "{\"projectName\":\"天津浙昆大厦酒店室内精装修工程\"," 
				+ "\"dangerType\":\"施工机械\"," 
				+ "\"deadLine\":\"三天\","
				+ "\"dangerDesc\":\"隐患描述\"," 
				+ "\"rectifyDesc\":\"整改措施\"," 
				+ "\"sum\":\"800\"," 
				+ "\"punishType\":\"现金罚款\","
				+ "\"pictures\":[\"F:\\\\picture\\\\lufei.jpg\",\"F:\\\\picture\\\\kk.jpg\"],"
				+ "\"saveType\":\"保存\"}";
		register.add(paras);
	}


	@AfterTest
	public void afterTest() {
//		 Tools.killChrome();

	}

	@AfterSuite
	public void afterSuite() {

	}
}
