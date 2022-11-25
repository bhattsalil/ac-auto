package org.ac.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IosActions extends AppiumUtils{
	IOSDriver driver;
	public IosActions(IOSDriver driver)
	{
		//super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void ScrollAndClick(String key)
	{
		WebElement ele  = driver.findElement(AppiumBy.accessibilityId(key));
		Map<String,Object> params = new HashMap<>();
		params.put("direction" ,"down");
		params.put("element" , ((RemoteWebElement)ele).getId());
		driver.executeScript("mobile:scroll", params);
		ele.click();
	}
	public void ScrollToMoreOption()
	{
		WebElement ele  = driver.findElement(AppiumBy.accessibilityId("notice_moreBtn"));
		Map<String,Object> params = new HashMap<>();
		params.put("direction" ,"down");
		params.put("element" , ((RemoteWebElement)ele).getId());
		driver.executeScript("mobile:scroll", params);
	
	}
	
	
	
	
	
	
	
//	public void LongPress()
//	{
//		WebElement ele = tbEmail();
//		Map <String, Object> params = new HashMap<>();
//		params.put("element", ((RemoteWebElement)ele).getId());
//		params.put("duration",5);
//	}
	

}
