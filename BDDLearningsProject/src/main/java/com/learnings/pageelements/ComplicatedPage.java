package com.learnings.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learnings.base.BaseClass;

public class ComplicatedPage extends BaseClass{
	
	public ComplicatedPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//span[@id='Section_of_Buttons']")
public WebElement sectionOfButtons;	
}
