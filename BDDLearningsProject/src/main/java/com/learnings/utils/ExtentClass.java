package com.learnings.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentClass {
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			return createInstance();
		}else {
			return extent;
		}
	}
		
		public static ExtentReports createInstance() {
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//test-output//ExtentReport.html");
		reporter.config().setEncoding("utf-8");
		reporter.config().setDocumentTitle("BDD Learnings");
		reporter.config().setReportName("BDD Learnings");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setJs("document.getElementsByClassName('test-content-detail')[0].style.overflow='auto'");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name","Individual");
		extent.setSystemInfo("Host","Individual");
		extent.setSystemInfo("UserName",System.getProperty("user.name"));
		
		return extent;
		
	}
}
