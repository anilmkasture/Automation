/**
 * 
 */
package com.cliantha.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author Octalsoft-86
 *
 */
public class ExtentManager {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/Test-Output/ExtentReport/"+"CTMS Cliantha Report.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		//htmlReporter.config().setDocumentTitle("Automation Test Report");
		//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		//htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "octalsoft86");
		extent.setSystemInfo("ProjectName", "CTMS Cliantha");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("PREPARED BY", "Anil Kasture,Quality Analyst");
		extent.setSystemInfo("REVIEWED BY", "Arun Janardhanan,Project Manager");
		extent.setSystemInfo("REVIEWED BY", "Krunal Bhatt,Delivery Manager");
		extent.setSystemInfo("REVIEWED BY", "Nafisa Kathiwala,QA Manager");
		extent.setSystemInfo("APPROVED BY", "Hiren Thakkar,Managing Director");
		
	}
	public static void endReport() {
		extent.flush();
	}

}
