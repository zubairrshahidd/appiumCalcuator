package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CalculatorExtentReport {
	
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 
	@BeforeSuite
	public void reportSetup() {
		
		   htmlReporter = new ExtentHtmlReporter("output-calculator-html-report.html");
	        // create ExtentReports and attach reporter(s)
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	}
	
	
	@AfterSuite
public void reportTearDown() {
		extent.flush();
		
	}

}
