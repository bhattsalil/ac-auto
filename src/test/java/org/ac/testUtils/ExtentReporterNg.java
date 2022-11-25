package org.ac.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	static ExtentReports extent;

	public static ExtentReports getReporterObject()
	{
		String path = System.getProperty("user.dir")+ "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("ApnaComplex Automation Results");
		reporter.config().setDocumentTitle("ApnaComplex Reports");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Automation");
		return extent;

	}

}
