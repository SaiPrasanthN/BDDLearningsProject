package com.learnings.pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learnings.base.BaseClass;

public class LoginPage  extends BaseClass{
	
	public LoginPage() {
			PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath="//input[@id='user[email]']")
public	WebElement email;

}

