package com.learnings.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learnings.base.BaseClass;

public class FakePricingPage extends BaseClass{
	
	public FakePricingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="(//div[@class='et_pb_text_inner'])[1]/h1")
public	WebElement pricingHeaderText;
}
