package com.test.first_maven.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.first_maven.base.UITest;
import com.test.first_maven.base.helper.MySqlConnect;
import com.test.first_maven.base.helper.Tools;
import com.test.first_maven.base.selenium.NewWebDriverEventListener;
import com.test.first_maven.base.selenium.WebAction;
import com.test.first_maven.page.OALoginPage;
import com.test.first_maven.page.UserMgr;
import com.test.first_maven.page.flow.FlowCenter;
import com.test.first_maven.page.flow.MyToDo;
import com.test.first_maven.page.hr.ApplicantsMgr;

public class ImitateUserTest extends UITest {
		OALoginPage oaLogin;

		String jobNumber1 = "";
		String jobNumber2 = "";
		String jobNumber3 = "";
		String jobNumber4 = "";
		String jobNumber5 = "";		
		
		@BeforeTest
		public void beforeTest() {
//			Tools.killChrome();
			Tools.deleteDirectory("pic");
			System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver.exe");
			
//			String sql = "SELECT job_number FROM sys_user WHERE userid IN (SELECT ASSIGNEE_ FROM act_ru_task WHERE proc_inst_id_ IN (SELECT actinstid FROM bpm_pro_run_his WHERE STATUS = 1 AND PROCESSNAME IN ('入职确认')))";
//	        MySqlConnect db = new MySqlConnect();
//	        ResultSet result = db.query(sql);
//	        ArrayList<String> list = db.getResultSet(result);
////	        System.out.println(list.size());
////	        list.remove("J171927");
////	        list.remove("00020180");
//	        System.out.println(list.size());
	        
	        jobNumber1 = "J031511";
	        jobNumber2 = "Q049912";
	        jobNumber3 = "J020022";
	        jobNumber4 = "J161403";
	        jobNumber5 = "00024805";
//	        jobNumber5 = list.get(list.size()-5);
		}

		public void login(String userName) {
			driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
			String url = "http://172.16.55.137/J2bpm/login.jsp";
			WebAction.get(driver, url, "//*[@name='username']");
			driver.manage().window().maximize();
			oaLogin = new OALoginPage(driver);
			oaLogin.login(userName, "jtlhrpsd");
		}

		@Test
		public void pass1() {
			WebDriver driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
			String url = "http://172.16.55.137/J2bpm/login.jsp";
			WebAction.get(driver, url, "//*[@name='username']");
			driver.manage().window().maximize();
			OALoginPage oaLogin = new OALoginPage(driver);
			oaLogin.login("admin", "jtlhrpsd");
			UserMgr uMgr = new UserMgr(driver);
			uMgr.enterUserMgr();
			String paras = "{\"jobNumber\":\""+jobNumber1+"\"}";
			uMgr.imitateUser(paras);
			MyToDo myToDo = new MyToDo(driver);
			String flowName = "入职确认";
			String paras1 = "{\"firstDay\":\"2017-02-01\"," 
					+ "\"place\":\"苏州园区\"," 
					+ "\"contractType\":\"劳动合同\","
					+ "\"contractType2\":\"固定期限\"," 
					+ "\"contractUnit\":\"金螳螂\"," 
					+ "\"years\":\"3\"}";
			myToDo.enterMyToDo();
//			myToDo.commitAll(flowName);
//			myToDo.commitAll(flowName, paras1);
			myToDo.commitAll();
		}

		@Test
		public void pass2() {
			WebDriver driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
			String url = "http://172.16.55.137/J2bpm/login.jsp";
			WebAction.get(driver, url, "//*[@name='username']");
			driver.manage().window().maximize();
			OALoginPage oaLogin = new OALoginPage(driver);
			oaLogin.login("admin", "jtlhrpsd");
			UserMgr uMgr = new UserMgr(driver);
			uMgr.enterUserMgr();
			String paras = "{\"jobNumber\":\""+jobNumber2+"\"}";
			uMgr.imitateUser(paras);
			MyToDo myToDo = new MyToDo(driver);
			String flowName = "入职确认";
			String paras1 = "{\"firstDay\":\"2017-02-01\"," 
					+ "\"place\":\"苏州园区\"," 
					+ "\"contractType\":\"劳动合同\","
					+ "\"contractType2\":\"固定期限\"," 
					+ "\"contractUnit\":\"金螳螂\"," 
					+ "\"years\":\"3\"}";
			myToDo.enterMyToDo();
//			myToDo.commitAll(flowName);
//			myToDo.commitAll(flowName, paras1);
			myToDo.commitAll();
		}
		@Test
		public void pass3() {
			WebDriver driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
			String url = "http://172.16.55.137/J2bpm/login.jsp";
			WebAction.get(driver, url, "//*[@name='username']");
			driver.manage().window().maximize();
			OALoginPage oaLogin = new OALoginPage(driver);
			oaLogin.login("admin", "jtlhrpsd");
			UserMgr uMgr = new UserMgr(driver);
			uMgr.enterUserMgr();
			String paras = "{\"jobNumber\":\""+jobNumber3+"\"}";
			uMgr.imitateUser(paras);
			MyToDo myToDo = new MyToDo(driver);
			String flowName = "入职确认";
			String paras1 = "{\"firstDay\":\"2017-02-01\"," 
					+ "\"place\":\"苏州园区\"," 
					+ "\"contractType\":\"劳动合同\","
					+ "\"contractType2\":\"固定期限\"," 
					+ "\"contractUnit\":\"金螳螂\"," 
					+ "\"years\":\"3\"}";
			myToDo.enterMyToDo();
//			myToDo.commitAll(flowName);
//			myToDo.commitAll(flowName, paras1);
			myToDo.commitAll();
		}
		@Test
		public void pass4() {
			WebDriver driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
			String url = "http://172.16.55.137/J2bpm/login.jsp";
			WebAction.get(driver, url, "//*[@name='username']");
			driver.manage().window().maximize();
			OALoginPage oaLogin = new OALoginPage(driver);
			oaLogin.login("admin", "jtlhrpsd");
			UserMgr uMgr = new UserMgr(driver);
			uMgr.enterUserMgr();
			String paras = "{\"jobNumber\":\""+jobNumber4+"\"}";
			uMgr.imitateUser(paras);
			MyToDo myToDo = new MyToDo(driver);
			String flowName = "入职确认";
			String paras1 = "{\"firstDay\":\"2017-02-01\"," 
					+ "\"place\":\"苏州园区\"," 
					+ "\"contractType\":\"劳动合同\","
					+ "\"contractType2\":\"固定期限\"," 
					+ "\"contractUnit\":\"金螳螂\"," 
					+ "\"years\":\"3\"}";
			myToDo.enterMyToDo();
//			myToDo.commitAll(flowName);
//			myToDo.commitAll(flowName, paras1);
			myToDo.commitAll();
		}
		@Test
		public void pass5() {
			WebDriver driver = new EventFiringWebDriver(new ChromeDriver()).register(new NewWebDriverEventListener());
			String url = "http://172.16.55.137/J2bpm/login.jsp";
			WebAction.get(driver, url, "//*[@name='username']");
			driver.manage().window().maximize();
			OALoginPage oaLogin = new OALoginPage(driver);
			oaLogin.login("admin", "jtlhrpsd");
			UserMgr uMgr = new UserMgr(driver);
			uMgr.enterUserMgr();
			String paras = "{\"jobNumber\":\""+jobNumber5+"\"}";
			uMgr.imitateUser(paras);
			MyToDo myToDo = new MyToDo(driver);
			String flowName = "入职确认";
			String paras1 = "{\"firstDay\":\"2017-02-01\"," 
					+ "\"place\":\"苏州园区\"," 
					+ "\"contractType\":\"劳动合同\","
					+ "\"contractType2\":\"固定期限\"," 
					+ "\"contractUnit\":\"金螳螂\"," 
					+ "\"years\":\"3\"}";
			myToDo.enterMyToDo();
//			myToDo.commitAll(flowName);
//			myToDo.commitAll(flowName, paras1);
			myToDo.commitAll();
		}

}
