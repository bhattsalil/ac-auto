package org.ac.pageObject.android;

import org.ac.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommunityPage extends AndroidActions{

	AndroidDriver driver;

	public CommunityPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(id ="com.apnacomplex:id/create_notice_layout")
	private WebElement createNotice;

	@AndroidFindBy(id ="com.apnacomplex:id/subject_edittext")
	private WebElement noticeSubject;

	@AndroidFindBy(id ="com.apnacomplex:id/notice_desc_edittxt")
	private WebElement noticeDescription;

	@AndroidFindBy(id ="com.apnacomplex:id/settings")
	private WebElement noticeSettings;

	@AndroidFindBy(id ="com.apnacomplex:id/radio_1")
	private WebElement expD1;

	@AndroidFindBy(id ="com.apnacomplex:id/radio_2")
	private WebElement expD7;

	@AndroidFindBy(id ="com.apnacomplex:id/radio_3")
	private WebElement expD15;

	@AndroidFindBy(id ="com.apnacomplex:id/radio_4")
	private WebElement expD30;

	@AndroidFindBy(id ="com.apnacomplex:id/add_attachments")
	private WebElement addAttachment;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Document']")
	private WebElement attachDocument;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Camera']")
	private WebElement attachCamera;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Gallery']")
	private WebElement attachGallery;

	@AndroidFindBy(id ="com.apnacomplex:id/post_notice")
	private WebElement postNotice;


	/**********************************************************************************	
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

	public void noticeSettings()
	{
		noticeSettings.click();

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

	public void postNotice()
	{
		postNotice.click();

	}

}
