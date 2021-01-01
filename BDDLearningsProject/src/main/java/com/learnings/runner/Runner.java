package com.learnings.runner;

import org.testng.annotations.Test;

import com.learnings.base.BaseClass;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(features = "src//test//java/com/learnings/features",glue = {"com.learnings.stepdefinitions"},tags="@Learning",plugin = {"com.learnings.utils.TestListener"})
public class Runner extends BaseClass{
	
	@Test(description = "Runs Cucumber Tests", dataProvider = "scenarios")
	 public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	      
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
}