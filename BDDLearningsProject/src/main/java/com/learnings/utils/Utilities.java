package com.learnings.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnings.base.BaseClass;

import io.cucumber.plugin.event.TestStepFinished;

public class Utilities extends BaseClass{
	public String getScreenshot(TestStepFinished event) throws IOException {
		TakesScreenshot tsc=(TakesScreenshot)getDriver();
		File src=tsc.getScreenshotAs(OutputType.FILE);
		File destination =new File(System.getProperty("user.dir")+"//test-output//Screenshots//"+ event.getTestCase().getName());
		
		FileUtils.copyFile(src, destination);
		FileInputStream is=new FileInputStream(destination);
		byte [] io =IOUtils.toByteArray(is);
		String screenshot=java.util.Base64.getEncoder().encodeToString(io);
		return screenshot;
	}
	
	public void wait_Element_Clickable(WebElement ele,int seconds) {
		WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void wait_Element_Visbile(WebElement ele,int seconds) {
		WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void wait_Element_Visible_List(List<WebElement> ele,int seconds) {
		WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public void switchToNewTab(boolean tabName) {
	ArrayList<String>tabs=new ArrayList<String>(getDriver().getWindowHandles());
	if(tabName==true) {
	getDriver().switchTo().window(tabs.get(1));
	}else if(tabName==false) {
		getDriver().switchTo().window(tabs.get(0));
	}
}
}
