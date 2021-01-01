package com.learnings.stepdefinitions;

import org.testng.Assert;

import com.learnings.base.BaseClass;
import com.learnings.pageelements.FakeLandingPage;
import com.learnings.pageelements.FakePricingPage;
import com.learnings.pageelements.MainScreenPage;
import com.learnings.utils.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Feature1StepDefs extends BaseClass {
	MainScreenPage mainScreenPage;
	FakeLandingPage fakeLandingPage;
	FakePricingPage fakePricingpage;
	Utilities utilities=new Utilities();

		
		@Given("I am main screen")
		public void i_am_main_screen() {
	    Assert.assertEquals(getDriver().getCurrentUrl(),prop.get("baseURL"));
		    
		}

		@Given("click on fakeLandingPage")
		public void click_on_fake_landing_page() {
		mainScreenPage=new MainScreenPage();
		utilities.wait_Element_Clickable(mainScreenPage.fakeLandingPage,20);
		mainScreenPage.fakeLandingPage.click();
		    
		}

		@Then("validate if user is on fakeLandingPage")
		public void validate_if_user_is_on_fake_landing_page() {
		    
			fakeLandingPage=new FakeLandingPage();
			utilities.wait_Element_Clickable(fakeLandingPage.viewCoursesButton,20);
			Assert.assertTrue(fakeLandingPage.viewCoursesButton.isDisplayed());
		}

		@Given("click on fakePricingPage")
		public void click_on_fake_pricing_page() {
			mainScreenPage=new MainScreenPage();
			utilities.wait_Element_Clickable(mainScreenPage.fakePricingPage,20);
			mainScreenPage.fakePricingPage.click();
		    
		}

		@Then("validate if user is on fakePricingPage")
		public void validate_if_user_is_on_fake_pricing_page() {
		    fakePricingpage=new FakePricingPage();
		    utilities.wait_Element_Clickable(fakePricingpage.pricingHeaderText, 20);
		    Assert.assertTrue(fakePricingpage.pricingHeaderText.isDisplayed());
		    
		}
}
