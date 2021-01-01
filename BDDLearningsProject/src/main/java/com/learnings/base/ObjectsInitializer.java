package com.learnings.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ObjectsInitializer {
	private static ThreadLocal<RemoteWebDriver>driver=new ThreadLocal<RemoteWebDriver>();
	public static Properties prop;
	public MutableCapabilities capabilities;
	public static String versionName=null;
	
	public void loadValues(@Optional String browserName,@Optional String version,@Optional  String platform) throws MalformedURLException {	
	if(version  == null) {
		if(browserName.contains("Chrome")) {
			System.out.println("Check");
			WebDriverManager.chromedriver().driverVersion("87.0").setup();
		
			ChromeOptions chromeOptions=new ChromeOptions();
			if(System.getProperty("os.name").contains("Win")) {
				
				}else {
					chromeOptions.addArguments("--headless");
					
				}
			chromeOptions.addArguments("--nosandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("-disable-browser-side-navigation");
driver.set(new ChromeDriver(chromeOptions));




		}else if(browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().driverVersion("").setup();;
		}else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().driverVersion("").setup();;
		}else if(browserName.contains("IE")) {
			WebDriverManager.iedriver().setup();
		}
	}else {
		capabilities=new MutableCapabilities();
		capabilities.setCapability("username",prop.get(""));
		capabilities.setCapability("accesskey",prop.get(""));
		capabilities.setCapability("browserName",browserName);
		capabilities.setCapability("version",version);
		capabilities.setCapability("platform",platform);
		driver.set(new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"),capabilities));
	}
	driver.get().get(prop.getProperty("baseURL"));
	driver.get().manage().window().maximize();
}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public Properties loadProperties(String location) throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(location);
		prop.load(fis);
		return prop;
	}
	
}
