package com.learnings.utils;

import java.util.Map;
import java.util.TreeMap;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;


public class ExtentTestManager {

	static Map<Integer, ExtentTest>featuresMap=new TreeMap<Integer, ExtentTest>();
	static Map<Integer, ExtentTest>scenariosMap=new TreeMap<Integer, ExtentTest>();
	
	
	public synchronized static ExtentTest getFeature() {
		return featuresMap.get((int)Thread.currentThread().getId());
	}
	
	public synchronized static ExtentTest getScenario() {
		return scenariosMap.get((int)Thread.currentThread().getId());
	}
	
	public  synchronized static  ExtentTest createScenarios(String name) {
		ExtentTest test=ExtentTestManager.getFeature().createNode(Scenario.class,name);
		return   scenariosMap.put((int)Thread.currentThread().getId(),test);
		
	}

	
	
	public  synchronized static  ExtentTest createFeatures(String name) {
		ExtentTest test=ExtentClass.getInstance().createTest(Feature.class,name);
		return   featuresMap.put((int)Thread.currentThread().getId(),test);
		
	}

}
