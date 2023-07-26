package com.Cyclos_Core_Four_RunnerFile;


import io.cucumber.testng.AbstractTestNGCucumberTests;



@io.cucumber.testng.CucumberOptions(features = "C:\\Users\\rpanyam\\eclipse-workspace\\AccountInformation\\FeatureFiles\\AccountInformation\\AccInfo.feature", 
glue = {"com.Cyclos_Core_Four_StepDefinitions"}, 
//tags= "@testcase5",
dryRun = false, 
monochrome = true,
//plugin="html:TestNGReport/CucumberReports/CucumberReport.html")
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })



public class AccInfoRunner extends AbstractTestNGCucumberTests{

}

