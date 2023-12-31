package com.cliantha.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.cliantha.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCliantha {

	public static Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	//loadConfig method is to load the configuration
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resorces\\Config\\confi.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp(String browserName) {
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			//driver=new ChromeDriver(options);
			
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			//WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless");
			
			driver.set(new FirefoxDriver(options));
		} else if (browserName.equalsIgnoreCase("Edge")) {
			//WebDriverManager.edgedriver().setup();
			
			EdgeOptions options=new EdgeOptions();
			options.addArguments("headless");
			
			driver.set(new EdgeDriver(options));
		}
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
		(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite (groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
