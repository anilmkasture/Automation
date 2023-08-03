/**
 * 
 */
package com.cliantha.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cliantha.Actiondriver.Action;
import com.cliantha.base.BaseCliantha;

/**
 * @author Octalsoft-86
 *
 */
public class LoginPage extends BaseCliantha {
Action action= new Action();
	
	@FindBy(id="P101_USERNAME")
	private WebElement userName;
	
	@FindBy(id="P101_PASSWORD")
	private WebElement password;

	@FindBy(id="P101_LOGIN")
	private WebElement LogInBtn;
	
	@FindBy(xpath="//*[@id=\"apex_layout_2570442910226045996\"]//spna/font")
	private WebElement forgetPassword;
	
		
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void login(String uname, String pasd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pasd);
		action.JSClick(getDriver(), LogInBtn);
		Thread.sleep(2000);
//		projectSetupPage=new ProjectSetupPage();
//		return projectSetupPage;
		
	}
	public String getCurrTitle(WebDriver driver) throws Throwable {
		String homePageTitle=action.getTitle(driver);
		return homePageTitle;
	}

}