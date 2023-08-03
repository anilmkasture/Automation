///**
// * 
// */
//package com.cliantha.pageobjects;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.cliantha.Actiondriver.Action;
//import com.cliantha.base.BaseCliantha;
//
///**
// * @author Octalsoft-86
// *
// */
//public class SiteManagementPage extends BaseCliantha {
//Action action= new Action();
//	
//	@FindBy(xpath = "//a[normalize-space()='Site Management']") 
//	private WebElement sitmanagement;
//	
//	@FindBy(xpath = "//select[@id='P348_PROJECT']")
//	private WebElement selectproject;
//	
//	@FindBy(id="//a[contains(@title,\"A. Ramkrishnam Naidu (King George Hospital)'\")]")
//	private WebElement sitenumber1;
//	
//	@FindBy(name="//span[normalize-space()='Action Items']")
//	private WebElement actionitems;
//	@FindBy(xpath = "//body[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/section[2]/div[2]/table[1]/tbody[1]/tr[1]/td[6]/center[1]")
//	private WebElement apdateresultion;
//	
//	public SiteManagementPage() {
//		PageFactory.initElements(getDriver(), this);
//	}
//	
//	public LoginPage validateUpdateresolution() throws Throwable {
//		action.fluentWait(getDriver(), sitmanagement, 10);
//		action.click(getDriver(), sitmanagement);
//		action.click(getDriver(), selectproject);
//		action.selectByIndex(sitmanagement, 0)
//		return new LoginPage();
//	}
//	
//	public boolean validateLogo() throws Throwable {
//		return action.isDisplayed(getDriver(), myStoreLogo);
//	}
//	
//	public String getMyStoreTitle() {
//		String myStoreTitel=getDriver().getTitle();
//		return myStoreTitel;
//	}
//	
//	public SearchResultPage searchProduct(String productName) throws Throwable {
//		action.type(searchProductBox, productName);
//		action.scrollByVisibilityOfElement(getDriver(), searchButton);
//		action.click(getDriver(), searchButton);
//		Thread.sleep(3000);
//		return new SearchResultPage();
//	}
//	
//	
//
//}
