package com.learnings.base;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.TestNGCucumberRunner;

public class BaseClass extends ObjectsInitializer{
	protected TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		loadProperties(System.getProperty("user.dir")+"/src/main/resources/Properties");
	}
	
	  @BeforeClass(alwaysRun = true)
	    public void setUpClass() {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }
	
	@Parameters({"browserName","version","platform"})
	@BeforeMethod
	public void beforeMethod(@Optional String browserName,@Optional String  version,@Optional String platform) throws MalformedURLException {
		if(version==null) {
			loadValues("Chrome", version, platform);
		}else {
			loadValues("Chrome", version, platform);
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		getDriver().quit();
	}

	@DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }
	
	
	  @AfterClass(alwaysRun = true)
	    public void tearDownClass() {
	    testNGCucumberRunner.finish();
	    }

	
	@AfterSuite
	public void afterSuite() {
		
	}
}
