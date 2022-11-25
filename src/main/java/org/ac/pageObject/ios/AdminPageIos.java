package org.ac.pageObject.ios;

import java.time.Duration;

import org.ac.utils.IosActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AdminPageIos extends IosActions{
	
	
	IOSDriver driver;

	public AdminPageIos(IOSDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	//iOSNsPredicate
	//accessibility
	//iOSClassChain
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Notice'`]")
	private WebElement notice;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[10]")
	private WebElement noticeCount;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[1]/XCUIElementTypeOther[2]")
	private WebElement approvalPending;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[2]/XCUIElementTypeOther[2]")
	private WebElement approvedNotice;
	
	@iOSXCUITFindBy(accessibility = "BackButton")
	private WebElement btnBack;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Approve'`][1]")
	private WebElement approve;
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Only' ")
	private WebElement setAudiance;

	@iOSXCUITFindBy(accessibility = "Only Tenants of this Complex")
	private WebElement tenants;
	
	@iOSXCUITFindBy(accessibility = "Only Committee Members of this Complex")
	private WebElement committeeMembers;
	
	@iOSXCUITFindBy(accessibility = "Only Residents")
	private WebElement residents;
	
	@iOSXCUITFindBy(accessibility = "Only Owners of this Complex")
	private WebElement owners;
	
	@iOSXCUITFindBy(accessibility = "Only Members of this Complex")
	private WebElement members;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
	private WebElement selectCalander;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement calanderOk;
	
	@iOSXCUITFindBy(accessibility = "Cancel")
	private WebElement calanderCancel;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeSwitch[`value == '0'`][1]")
	private WebElement flash;

	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeSwitch[`value == '0'`][2]")
	private WebElement specialNotice;

	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeSwitch[`value == '0'`][3]")
	private WebElement copyToMaintenanceStaff;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeStaticText[`label == 'Close'`]")
	private WebElement noticeClose;
	
	@iOSXCUITFindBy(accessibility = "noticeSettingsApproveButton")
	private WebElement approveNotice;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'Decline'`][1]")
	private WebElement declineNotice;

	@iOSXCUITFindBy(xpath ="**/XCUIElementTypeButton[`label == 'Decline'`][1]")
	private WebElement declineNoticecomment;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'Decline'`]")
	private WebElement rejectNotice;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'Close'`]")
	private WebElement closeNotice;

	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'MoreIconGrey'`][1]")
	private WebElement moreOption;
	
	@iOSXCUITFindBy(accessibility = "delete")
	private WebElement deleteNotice;
	
	@iOSXCUITFindBy(accessibility = "delete")
	private WebElement deleteNoticeY;
	
	@iOSXCUITFindBy(accessibility = "CANCEL")
	private WebElement deleteNoticeN;
	
	@iOSXCUITFindBy(accessibility = "Edit Access Level")
	private WebElement noticeEditAccess;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'Update'`]")
	private WebElement btnUpdate;
	
	
/***********************************************************************************	
***********************************************************************************/		
	

	public void noticeCountAndClick()
	{
		//System.out.println(noticeCount.getText());
		notice.click();	
	}
	
	public void pendingNotice()
	{
		Boolean Approval_pending = approvalPending.isEnabled();
		Boolean Approved_notice = approvedNotice.isEnabled();
		Assert.assertTrue(Approval_pending);
		Assert.assertTrue(Approved_notice);
		approvalPending.click();
		int pendingCount = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeTable/XCUIElementTypeCell")).size();
		if (pendingCount == 0)
		{
			System.out.println("Notice Board has" + " " +  pendingCount  + " " +  "Approval pending" );
		}
		else 
		{
			System.out.println( pendingCount + " " + "Approval(s) pending" );
		}
		
	}
	public void approvedNotice()
	{
		approvedNotice.click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		int ApprovedNotice = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id = 'com.apnacomplex:id/name_layout']")).size();
		System.out.println("There are" + " " + ApprovedNotice + " " + " Approved notices visible  on screen As of now ");
	}
	
	public HomePageIos back()
	{
		btnBack.click();
		btnBack.click();
		return new HomePageIos(driver);

	}
	
	public void showmore()
	{
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name= 'Show More'][1]")).click();
	}
	
	
	public void approve()
	{
		approve.click();
	}
	
	public void setAudiance()
	{
		setAudiance.click();
	}
	
	public void selectAudi(String visible)
	{
		if (visible.contains("ten"))
		{
			tenants.click();
		}
		else if (visible.contains("cmem"))
		{
			committeeMembers.click();
		}
		else if (visible.contains("res"))
		{
			residents.click();
		}
		else if (visible.contains("own"))
		{
			owners.click();
		}
		else if (visible.contains("mem"))
		{
			members.click();	
		}
	}
	
	public void selectCalander()
	{
		selectCalander.click();
	}
	
	public void calanderOk()
	{
		calanderOk.click();
	}
	public void calanderCancel()
	{
		calanderCancel.click();
	}

	public void flash()
	{
		flash.click();
	}

	public void specialNotice()
	{
		specialNotice.click();
	}

	public void copyToMaintenanceStaff()
	{
		copyToMaintenanceStaff.click();
	}
	
	public void noticeClose()
	{
		noticeClose.click();
	}
	public void approveNotice()
	{
		approveNotice.click();
	}
	
	public void declineNotice()
	{
		declineNotice.click();
	}
	
	public void setDeclineComment(String declineComment)
	{
		declineNoticecomment.sendKeys(declineComment);
	}
	
	public void rejectNotice(String reject) throws InterruptedException
	{
		if (reject.contains("reject"))
		{
			rejectNotice.click();
			Thread.sleep(3000);
		}
		else
		{
			closeNotice.click();
			Thread.sleep(3000);
		}
	
	}
	
	public void moreOption()
	{
		moreOption.click();
	}
	
	public void deleteNotice() throws InterruptedException
	{
		deleteNotice.click();
		Thread.sleep(3000);
	}
	
	public void delete(String delete) throws InterruptedException
	{
		if (delete.contains("yes"))
		{
			deleteNoticeY.click();
			Thread.sleep(3000);
		}
		else
		{
			deleteNoticeN.click();
			Thread.sleep(3000);
		}
	
	}
	
	public void scrollToMore()
	{
		ScrollToMoreOption();
		moreOption.click();
	}
	public void editAccessLabel()
	{
		noticeEditAccess.click();
	}
	public void update() throws InterruptedException
	{
		btnUpdate.click();
		Thread.sleep(3000);
	}
	
}
