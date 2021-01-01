package com.learnings.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learnings.base.BaseClass;

public class MainScreenPage extends BaseClass{
	
	public MainScreenPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath="//a[contains(.,'Fake Landing Page')]")
	public WebElement fakeLandingPage;
	
	@FindBy(xpath="//a[contains(.,'Fake Pricing Page')]")
public	WebElement fakePricingPage;
	
	@FindBy(xpath="//a[contains(.,'Big page with many elements')]")
public	WebElement complicatesPage;
	
	@FindBy(xpath="//a[contains(.,'Login automation')]")
public 	WebElement loginPage;
	
}
	

