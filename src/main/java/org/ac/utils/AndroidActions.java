package org.ac.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidActions extends AppiumUtils{
	
	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver)
	{
		//super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

		public void ScrollAndClick(String key)
		{
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +	".scrollIntoView(new UiSelector().textContains(\""+key+"\"))"));
		}

		public void ScrollAndClick1(int i)
		{
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +	".scrollIntoView(new UiSelector().textContains(\""+i+"\"))"));
		}
		
		
		public void OnOffWiFi() throws InterruptedException 
		{
			driver.startActivity(new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
			driver.findElement(By.id("android:id/checkbox")).click();
			driver.startActivity(new Activity("com.apnacomplex", "com.apnacomplex.loginrevamp.SplashActivity"));
			Thread.sleep(2000);
		}
		
		public void ScrollToMoreOption()
		{
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
					".scrollIntoView(new UiSelector().resourceIdMatches(\".*com.apnacomplex:id/more_option*\"))"));
		}
		
		
		public void recheckFeature(String key)
		{
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true))" +
					".scrollIntoView(new UiSelector().resourceIdMatches(\".*com.apnacomplex:id/posted_time*\").textContains(\""+key+"\"))"));
		}
		
		

}
