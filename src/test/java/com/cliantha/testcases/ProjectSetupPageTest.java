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
public class ProjectSetupPageTest extends BaseCliantha{
	private LoginPage loginPage;
	private ProjectSetupPage projectSetupPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		launchApp(browser); 
		Thread.sleep(3000);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void projectsearchfieldshouldbeavailableTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("TC01-Project Setup Module");
		Log.startTestCase("TC01-Step1");
		loginPage=new LoginPage();
		projectSetupPage= new ProjectSetupPage();
		loginPage.login(uname,pswd);
		Log.info("The system should open the Project Setup page and the project search field should be available.");
		projectSetupPage.projectsearchfieldshouldbeavailable();
		Log.info("The system opens the Project Setup page and the project search field is seen on the page.");
		Thread.sleep(2000);
		
	}
	
	@Test(groups = "Smoke",dataProvider = "anil", dataProviderClass = DataProviders.class)
	public void searchByProjectNameTest(String uname, String pswd, String projectsearch) throws Throwable {
		Log.startTestCase("TC01-Step2");
		loginPage=new LoginPage();
		projectSetupPage= new ProjectSetupPage();
		loginPage.login(uname,pswd);
		Log.info("The system should provide provision of search by Project Name.");
		projectSetupPage.searchByProjectName(projectsearch);
		Log.info("The system provides provision of search by Project Name.");
		Thread.sleep(2000);
		//boolean result=homePage.validateMyWishList();
		//Assert.assertTrue(result);
		//Log.endTestCase("Project Setup Module");
	}
	
	@Test(groups = "Sanity",dataProvider = "anil1", dataProviderClass = DataProviders.class)
	public void searchByProjectNumberTest(String uname, String pswd, String projectname) throws Throwable {
		Log.startTestCase("TC01-Step3");
		loginPage=new LoginPage();
		projectSetupPage= new ProjectSetupPage();
		loginPage.login(uname,pswd);
		Log.info("The system should provide provision of search by Project Number.");
		projectSetupPage.searchByProjectName(projectname);
		Log.info("The system provides provision of search by Project Number.");
		Thread.sleep(2000);
		//Log.endTestCase("Project Setup Module");
	}
	@Test(groups = "Sanity",dataProvider = "anil1", dataProviderClass = DataProviders.class)
	public void resetTest(String uname, String pswd, String projectname) throws Throwable {
		Log.startTestCase("TC01-Step4");
		loginPage=new LoginPage();
		projectSetupPage= new ProjectSetupPage();
		loginPage.login(uname,pswd);
		Log.info("The system should provide provision of reset search.");
		projectSetupPage.reset(projectname);;
		Log.info("The system provides provision of reset search.");
		Thread.sleep(2000);
		Log.endTestCase("TC01-Project Setup Module");
	}
	

}
