package org.ac.pageObject.android;

import org.ac.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidActions{
	AndroidDriver driver;

	public HomePage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc='Account']/android.widget.FrameLayout/android.widget.ImageView")
	private WebElement accountTab;
	
	@AndroidFindBy(id ="com.apnacomplex:id/admin_tab")
	private WebElement adminTab;
	
	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc='Community']/android.widget.FrameLayout/android.widget.ImageView")
	private WebElement tabCommunity;
	
	
	
/***********************************************************************************	
***********************************************************************************/	
	
	public AccountPage tabAccount()
	{
		accountTab.click();
		return new AccountPage(driver);
	}
	
	
	public AdminPage tabAdmin() throws InterruptedException
	{
		adminTab.click();
		Thread.sleep(2000);
		return new AdminPage(driver);
		
	}
	
	public CommunityPage tabCommunity() throws InterruptedException
	{
		tabCommunity.click();
		Thread.sleep(2000);
		return new CommunityPage(driver);
		
	}

}