package org.ac.android;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println(result.getName() + "	" +  "Started" );
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getName() + "	" +  "Passed" );
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getName() + "	" +  "FAILED" );	
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(result.getName() + "	" + "Skipped" );		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{	
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{	
	
	}

	@Override
	public void onStart(ITestContext context) 
	{	
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		
	}

}
