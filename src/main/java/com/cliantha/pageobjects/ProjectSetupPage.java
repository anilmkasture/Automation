/**
 * 
 */
package com.cliantha.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cliantha.Actiondriver.Action;
import com.cliantha.base.BaseCliantha;

/**
 * @author Octalsoft-86
 *
 */
public class ProjectSetupPage extends BaseCliantha {
	Action action = new Action();
//	 private String projectname="trial";
//	 private String projectnumber="AZ201801 (C2A01194)";

	@FindBy(xpath = "//a[normalize-space()='Project Setup']")
	private WebElement projectsetup;

	@FindBy(xpath = "//input[@id='P685_STUDY_ID_1']")
	private WebElement projectsearch;

	@FindBy(xpath = "//span[normalize-space()='Go']")
	private WebElement projsearchGoBtn;
	@FindBy(xpath = "(//img)[11]")
	private WebElement selectanyproject;
	@FindBy(xpath = "//span[normalize-space()='Study Team']")
	private WebElement StudyTeam;
	@FindBy(xpath = "//span[contains(text(),'Add New Member')]")
	private WebElement AddNewMember;
	@FindBy(xpath = "(//select[@id='P922_CONTACT_ID'])[1]")
	private WebElement Nameselect;

	@FindBy(xpath = "//span[normalize-space()='Reset']")
	private WebElement ResetBu;

	public ProjectSetupPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void projectsearchfieldshouldbeavailable() throws Throwable {
		action.click(getDriver(), projectsetup);
	}

	public void searchByProjectName(String projectname) throws Throwable {
		action.click(getDriver(), projectsetup);
		action.type(projectsearch, projectname);
		action.click(getDriver(), projsearchGoBtn);
		// return action.isDisplayed(getDriver(), projectsearch);
	}

	public void searchByProjectNumber(String projectnumber) throws Throwable {
		action.click(getDriver(), projectsetup);
		action.type(projectsearch, projectnumber);
		action.click(getDriver(), projsearchGoBtn);
	}

	public void reset(String projectnumber) throws Throwable {
		action.click(getDriver(), projectsetup);
		action.type(projectsearch, projectnumber);
		action.click(getDriver(), projsearchGoBtn);
		action.click(getDriver(), ResetBu);

	}
//	public void displaylistofvalueofnamewithoutTitleprefix() throws Throwable {
//		action.click(getDriver(), projectsetup);
//		Thread.sleep(2000);
//		action.click(getDriver(), selectanyproject);
//		action.click(getDriver(), StudyTeam);
//		action.click(getDriver(), AddNewMember);
//		action.click(getDriver(), Nameselect);
//		Thread.sleep(4000);
//		
//	}

//	public boolean validateOrderHistory() throws Throwable {
//		return action.isDisplayed(getDriver(), orderHistory);
//	}
//	
//	public String getCurrURL() throws Throwable {
//		String homePageURL=action.getCurrentURL(getDriver());
//		return homePageURL;
//	}

}
