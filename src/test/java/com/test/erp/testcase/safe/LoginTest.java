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

public class LoginTest extends UITest {
	ERPLoginPage erpLogin;
	
	@BeforeTest
	public void beforeTest() {
		Tools.deleteDirectory("pic");
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

	public void login(String userName, String password, String errMsg) {
		erpLogin = new ERPLoginPage(driver);
		erpLogin.login(userName, password, errMsg);
	}	

	@Test
	public void loginSuccess() {
		login("shenhua1", "1");
	}

	@Test
	public void loginFail1() {
		//用户名不存在
		login("shenhua25", "1", "用户名或密码错误！");
	}

	@Test
	public void loginFail2() {
		//密码错误
		login("shenhua1", "xxoo", "用户名或密码错误！");
	}
	
	@AfterTest
	public void afterTest() {
//		 Tools.killChrome();

	}

	@AfterSuite
	public void afterSuite() {

	}
}
