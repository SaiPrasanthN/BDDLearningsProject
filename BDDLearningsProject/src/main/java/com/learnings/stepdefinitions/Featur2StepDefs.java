package com.learnings.stepdefinitions;

import org.testng.Assert;

import com.learnings.pageelements.ComplicatedPage;
import com.learnings.pageelements.LoginPage;
import com.learnings.pageelements.MainScreenPage;
import com.learnings.utils.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Featur2StepDefs {
	LoginPage loginPage;
	ComplicatedPage complicatedPage;
	MainScreenPage mainScreenPage;
	Utilities utilities=new Utilities();
	@Given("click on loginPage")
	public void click_on_login_page() {
	   mainScreenPage=new MainScreenPage();
	   utilities.wait_Element_Clickable(mainScreenPage.loginPage,20);
	   mainScreenPage.loginPage.click();
	   
	   
	}

	@Then("validate if user is on loginPage")
	public void validate_if_user_is_on_login_page() {
	   loginPage=new LoginPage();
	   utilities.wait_Element_Clickable(loginPage.email, 20);
	  Assert.assertTrue(loginPage.email.isDisplayed());
	   
	}

	@Given("click on complicatedPage")
	public void click_on_complicated_page() {
		 mainScreenPage=new MainScreenPage();
		   utilities.wait_Element_Clickable(mainScreenPage.complicatesPage,20);
		   mainScreenPage.complicatesPage.click();
		   
	   
	}

	@Then("validate if user is on complicatedPage")
	public void validate_if_user_is_on_complicated_page() {
	   complicatedPage=new ComplicatedPage();
	   utilities.wait_Element_Clickable(complicatedPage.sectionOfButtons, 20);
	   Assert.assertTrue(complicatedPage.sectionOfButtons.isDisplayed());
	   
	}


}
