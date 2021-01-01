package com.learnings.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learnings.base.BaseClass;

public class FakeLandingPage extends BaseClass {
	
	public FakeLandingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[contains(.,'View Courses')]")
	public WebElement viewCoursesButton;
}


	

