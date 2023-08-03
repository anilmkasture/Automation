/**
 * 
 */
package com.cliantha.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cliantha.base.BaseCliantha;
import com.cliantha.dataprovider.DataProviders;
import com.cliantha.pageobjects.LoginPage;
import com.cliantha.pageobjects.ProjectSetupPage;
import com.cliantha.pageobjects.ReportsPage;
import com.cliantha.utility.Log;

/**
 * @author Octalsoft-86
 *
 */
public class ReportsPageTest extends BaseCliantha{
	
	private LoginPage loginPage;
	private ReportsPage reportsPage;
	
	@Parameters("browser")
	@BeforeMethod  (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser); 
		Thread.sleep(3000);
	}
	
	@AfterMethod  (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = {"Smoke"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void listofDeletedProtocolDeviationReportTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("Protocol Deviation Reports Test");
		Log.startTestCase("TC02-Step1");
		//Log.info("Login as PM, Enter Valid User Name and Password");
	    //loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage=new LoginPage();
		reportsPage=new ReportsPage();
		loginPage.login(uname,pswd);
		Log.info("The system should provide list of Deleted Protocol Deviation Report");
		reportsPage.listofDeletedProtocolDeviation();
		Log.info("The system provides list of Deleted Protocol Deviation Report");
//	    Log.info("The system should open Home page.");
//	    Assert.assertEquals(actualTitle, expectedTitle);
//	    Log.info("Login is Successful,The system opens Home page.");
	    //Log.endTestCase("Reports Test");
	}
	@Test(groups = {"Sanity"},priority=1,dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void downloadDeletedProtocolDeviationReportTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("TC02-Step2");
		//Log.info("Login as PM, Enter Valid User Name and Password");
	    //loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage=new LoginPage();
		reportsPage=new ReportsPage();
		loginPage.login(uname,pswd);
		Log.info("The system should provide provision to Download Deleted Protocol Deviation Report");
		reportsPage.downloadDeletedProtocolDeviationReport();
		Log.info("The system provides provision to Download Deleted Protocol Deviation Report");
	   
//	    Log.info("The system should open Home page.");
//	    Assert.assertEquals(actualTitle, expectedTitle);
//	    Log.info("Login is Successful,The system opens Home page.");
	    Log.endTestCase("Protocol Deviation Reports Test");
	}

}


