package com.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BrowserFactory;
import com.base.CommonActions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "@ExtentReport/rerun.txt", glue = { "com.stepdefinations", }, plugin = { "pretty",
		"html:target/cucumber-reports/cucumber-pretty",
//				 "html:target/cucumber-reports/cucumber-pretty.html",
		"rerun:ExtentReport/rerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class FailedTestRunner<CucumberFeatureWrapper> {

	private TestNGCucumberRunner testNGCucumberRunner;
	private BrowserFactory browserFactory;

	@BeforeClass
	public void beforeClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		browserFactory = new BrowserFactory();
	}

	@BeforeMethod
	public void setup() {
		browserFactory.openBrowser();
	}

	@Test(dataProvider = "scenarios", description = "Scenario Name: ")
	public void runScenario(PickleWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
	}

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterMethod
	public void tearDown() {
		browserFactory.closeBrowser();
	}

	@AfterClass
	public void afterClass() {
		testNGCucumberRunner.finish();
		CommonActions.copyRerunReport();
		CommonActions.renameTheExtentReportHtml();
	}
}