/**
 * 
 */
package com.cliantha.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cliantha.Actiondriver.Action;
import com.cliantha.base.BaseCliantha;

/**
 * @author Octalsoft-86
 *
 */
public class ReportsPage extends BaseCliantha {
	Action action = new Action();
	@FindBy(xpath = "(//a[normalize-space()='Reports'])[1]")
	private WebElement report;
	@FindBy(xpath = "//a[normalize-space()='Deleted Protocol Deviation Report']")
	private WebElement deletedpdreport;
	@FindBy(id = "R137191713462432482_actions_button")
	private WebElement actiondeletedpdreport;
	@FindBy(xpath = "(//button[normalize-space()='Download'])[1]")
	private WebElement download;
	@FindBy(xpath = "//img[@title='CSV']")
	private WebElement downloadCSV;
	public ReportsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void listofDeletedProtocolDeviation() throws InterruptedException {
		action.click(getDriver(), report);
		action.click(getDriver(), deletedpdreport);
		
		
	}
;
	public void downloadDeletedProtocolDeviationReport() throws InterruptedException {
		
		action.click(getDriver(), report);
		action.click(getDriver(), deletedpdreport);
		action.mouseOverElement(getDriver(), actiondeletedpdreport);
		action.click(getDriver(), actiondeletedpdreport);
		Thread.sleep(2000);
		action.click(getDriver(), download);
		action.switchToFrameByIndex(getDriver(), 0);
		action.click(getDriver(), downloadCSV);
		Thread.sleep(2000);
	}
}
