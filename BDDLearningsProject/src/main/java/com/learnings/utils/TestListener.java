package com.learnings.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestSourceRead;
import io.cucumber.plugin.event.TestStepFinished;

public class TestListener  implements ConcurrentEventListener{

	private ArrayList<String>featureNames=new ArrayList<String>();
	Map<String,Integer>mapValues=new HashMap<String, Integer>();
		
	
	private void readFeatures(TestSourceRead event) {
			String featureSource=event.getUri().toString();
			String featureName=featureSource.split(".*/")[1];
			featureNames.add(featureName);
		}
		
		
		
		
		private void testCaseStarted(TestCaseStarted event) {
			String featureSource=event.getTestCase().getUri().toString();
			String featureName=featureSource.split(".*/")[1];
			for(String s: featureNames) {
				if(featureName.equals(s)) {
				System.out.println(s);
				Set<String>keySet=mapValues.keySet();
				if(!keySet.contains(s)) {
					mapValues.put(s,1);
				}else {
					mapValues.put(s,mapValues.get(s)+1);
				}
				if(mapValues.get(s)==1) {
					System.out.println("Feature currently in progess : " + featureName);
					ExtentTestManager.createFeatures(featureName);
				}else {
					
				}
				ExtentTestManager.createScenarios(event.getTestCase().getName());
				ExtentTestManager.getScenario().assignCategory(event.getTestCase().getTags().toString());
				break;
			}
			}
			
	}
		
	private void testStepFinished(TestStepFinished event) throws IOException, ClassNotFoundException {
		Utilities utilities=new Utilities();
		Result result=event.getResult();
		if(event.getTestStep()instanceof PickleStepTestStep) {
			
		PickleStepTestStep steps=(PickleStepTestStep)event.getTestStep();
		String stepText=steps.getStep().getText();
		String keyword=steps.getStep().getKeyword();
		System.out.println(keyword + " : " + stepText);
		if(result.getStatus().toString()=="FAILED") {
			ExtentTestManager.getScenario().createNode(keyword + ":" + stepText).fail(MediaEntityBuilder.createScreenCaptureFromBase64String(utilities.getScreenshot(event)).build()).fail(result.getError()); 
		}else if(result.getStatus().toString()=="PASSED") {
			ExtentTestManager.getScenario().createNode(new GherkinKeyword(keyword),keyword + ":" + stepText).pass("");
		}else {
			ExtentTestManager.getScenario().createNode(new GherkinKeyword(keyword),keyword + ":" + stepText).skip(result.getError());
		}
			

		}
	}

	private void testCaseFinished(TestCaseFinished event) {
		if(event.getResult().getStatus().toString()=="FAILED") {
			System.out.println(event.getTestCase().getName() + " has failed");
		}else if(event.getResult().getStatus().toString()=="PASSED") {
			System.out.println(event.getTestCase().getName() + " has passed");
		}
	}
		
		private void endTest(io.cucumber.plugin.event.TestRunFinished event) {
			ExtentClass.getInstance().flush();
		}
		
		
		public void setEventPublisher(EventPublisher publisher) {
			publisher.registerHandlerFor(TestSourceRead.class,this::readFeatures);
			publisher.registerHandlerFor(TestCaseStarted.class, this::testCaseStarted);
			publisher.registerHandlerFor(TestStepFinished.class, event -> {
				try {
					testStepFinished(event);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			publisher.registerHandlerFor(TestCaseFinished.class,this::testCaseFinished);
			publisher.registerHandlerFor(io.cucumber.plugin.event.TestRunFinished.class,this::endTest);
		}
}
