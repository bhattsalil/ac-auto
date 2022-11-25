package org.ac.pageObject.ios;

import org.ac.utils.IosActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePageIos extends IosActions{
	
	
	IOSDriver driver;

	public HomePageIos(IOSDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Account'`]")
	private WebElement accountTab;
	
	@iOSXCUITFindBy(accessibility = "AdminIcon")
	private WebElement adminTab;
	
	@iOSXCUITFindBy(accessibility = "Community")
	private WebElement tabCommunity;
	
/***********************************************************************************	
***********************************************************************************/	


	public AccountPageIos tabAccount()
	{
		accountTab.click();
		return new AccountPageIos(driver);
	}
	
	public AdminPageIos tabAdmin() throws InterruptedException
	{
		adminTab.click();
		Thread.sleep(2000);
		return new AdminPageIos(driver);
	}
	
	public CommunityPageIos tabCommunity() throws InterruptedException
	{
		tabCommunity.click();
		Thread.sleep(2000);
		return new CommunityPageIos(driver);
		
	}
}
