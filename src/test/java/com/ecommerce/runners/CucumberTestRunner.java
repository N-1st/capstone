package com.ecommerce.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.ecommerce.stepDefinations",
		//    plugin = {"pretty", "html:target/cucumber-reports"}
		//    plugin = {"pretty", "json:target/cucumber-reports"}
		//    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"}
		plugin = {"pretty","html:target/HTMLReports.html",
				
				
				"json:target/json-report.json",
				"junit:target/junit_report.xml",
//				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}, 
		monochrome = true 
		)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{

}
