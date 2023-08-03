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
import com.cliantha.utility.Log;

/**
 * @author Octalsoft-86
 *
 */
public class LoginPageTest extends BaseCliantha{
	
	private LoginPage loginPage;
	private ProjectSetupPage projectSetupPage;
	
	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser); 
		Thread.sleep(3000);
	}
	
	@AfterMethod  (groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname1, String pswd1) throws Throwable {
		Log.startTestCase("loginTest");
		Log.info("Login as PM, Enter Valid User Name and Password");
	    //loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage=new LoginPage();
		loginPage.login(uname1,pswd1);
	    String actualTitle=loginPage.getCurrTitle(getDriver());
	    Thread.sleep(2000);
	    String expectedTitle="Home";
	    //Log.info("The system should open Home page.");
	    Assert.assertEquals(actualTitle, expectedTitle);
	    Log.info("Login is Successful,The system opens Home page.");
	    Log.endTestCase("loginTest");
	}

}
