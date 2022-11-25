package org.ac.pageObject.ios;

import org.ac.utils.IosActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CommunityPageIos extends IosActions{
	
	
	IOSDriver driver;

	public CommunityPageIos(IOSDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = 'Create Notice']")
	private WebElement createNotice;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeTextView")
	private WebElement noticeSubject;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeTextView")
	private WebElement noticeDescription;
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'Done' ")
	private WebElement done;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
	private WebElement addAttachment;
	
	
	@iOSXCUITFindBy(accessibility = "Documents")
	private WebElement attachDocument;
	
	@iOSXCUITFindBy(accessibility = "Camera")
	private WebElement attachCamera;
	
	@iOSXCUITFindBy(accessibility = "Gallery")
	private WebElement attachGallery;
	
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement attachCancel;
	
	@iOSXCUITFindBy(accessibility = "Notice Settings")
	private WebElement noticeSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeButton")
	private WebElement noticeExpDD;
	
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeStaticText[`label == \"1 Day\"`][2]")
	private WebElement expD1;

	@iOSXCUITFindBy(iOSNsPredicate ="label == '1 Week' ")
	private WebElement expD7;

	@iOSXCUITFindBy(iOSNsPredicate ="label == '15 Days' ")
	private WebElement expD15;

	@iOSXCUITFindBy(iOSNsPredicate ="label == '1 Month' ")
	private WebElement expD30;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name = 'Done']")
	private WebElement noticeDone;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Share'`]")
	private WebElement postNotice;
	
	
/***********************************************************************************	
***********************************************************************************/	



	public void createNotice()
	{
		createNotice.click();
	}
	
	
	public void setFieldNoticeSubject(String noticeSub)
	{
		noticeSubject.sendKeys(noticeSub);
	}

	public void setFieldNoticeDescription(String noticeDesc)
	{
		noticeDescription.sendKeys(noticeDesc);
	}
	
	public void done()
	{
		done.click();
	}
	public void addAttachment()
	{
		addAttachment.click();

	}

	public void attachment(String attach)
	{
		if (attach.contains("document"))
		{
			attachDocument.click();
		}
		else if (attach.contains("camera"))
		{
			attachCamera.click();
		}
		else if (attach.contains("gallery"))
		{
			attachGallery.click();
		}
	}
	
	public void accessGallery()
	{
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"Photo, 17 October, 6:11 PM\"`][2]")).click();
		
	}
	
	public void noticeSettings()
	{
		noticeSettings.click();

	}
	
	public void noticeExpDD()
	{
		noticeExpDD.click();

	}
	
	public void noticeExpiry(String expiry)
	{
		if (expiry.contains("D1"))
		{
			expD1.click();
		}
		else if (expiry.contains("D7"))
		{
			expD7.click();
		}
		else if (expiry.contains("D15"))
		{
			expD15.click();
		}
		else if (expiry.contains("D30"))
		{
			expD30.click();
		}
	}
	
	public void noticeDone()
	{
		noticeDone.click();
		noticeDone.click();

	}
	public void postNotice()
	{
		postNotice.click();

	}
}