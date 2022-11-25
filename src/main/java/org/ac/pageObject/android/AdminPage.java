package org.ac.pageObject.android;

import java.time.Duration;
import org.ac.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminPage extends AndroidActions{
	AndroidDriver driver;

	public AdminPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(id ="com.apnacomplex:id/txt_notice_count")
	private WebElement noticeCount;

	@AndroidFindBy(id ="com.apnacomplex:id/notice_main")
	private WebElement eleNotice;

	@AndroidFindBy(id ="com.apnacomplex:id/pendingNoticeChip")
	private WebElement approvalPending;

	@AndroidFindBy(id ="com.apnacomplex:id/approvedNoticeChip")
	private WebElement approvedNotice;

	@AndroidFindBy(xpath ="//android.widget.LinearLayout[@resource-id = 'com.apnacomplex:id/name_layout']")
	private WebElement pendingCount;

	@AndroidFindBy(xpath ="//android.widget.LinearLayout[@resource-id = 'com.apnacomplex:id/name_layout']")
	private WebElement approvedCount;

	@AndroidFindBy(id ="com.apnacomplex:id/back_button")
	private WebElement btnBack;

	@AndroidFindBy(id ="com.apnacomplex:id/img_back")
	private WebElement btnbackadmin;

	@AndroidFindBy(id ="com.apnacomplex:id/approve_notice")
	private WebElement approve;

	@AndroidFindBy(id ="com.apnacomplex:id/selected_access")
	private WebElement setAudiance;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Only Tenants of this Complex']")
	private WebElement tenants;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Only Committee Members of this Complex']")
	private WebElement committeeMembers;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Only Residents']")
	private WebElement residents;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Only Owners of this Complex']")
	private WebElement owners;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Only Members of this Complex']")
	private WebElement members;

	@AndroidFindBy(id ="com.apnacomplex:id/expiry_layout")
	private WebElement selectCalander;

	@AndroidFindBy(id ="android:id/button1")
	private WebElement calanderOk;

	@AndroidFindBy(id ="android:id/button2")
	private WebElement calanderCancel;

	@AndroidFindBy(id ="com.apnacomplex:id/flash_notice_switch")
	private WebElement flash;

	@AndroidFindBy(id ="com.apnacomplex:id/special_notice_switch")
	private WebElement specialNotice;

	@AndroidFindBy(id ="com.apnacomplex:id/copy_maintenance_staff_switch")
	private WebElement copyToMaintenanceStaff;

	@AndroidFindBy(id ="com.apnacomplex:id/submit")
	private WebElement approveNotice;
	
	@AndroidFindBy(id ="com.apnacomplex:id/reject_notice")
	private WebElement declineNotice;

	@AndroidFindBy(id ="com.apnacomplex:id/reason_edittxt")
	private WebElement declineNoticecomment;

	@AndroidFindBy(id ="com.apnacomplex:id/action_text")
	private WebElement rejectNotice;
	
	@AndroidFindBy(id ="com.apnacomplex:id/close_button")
	private WebElement closeNotice;
	
	@AndroidFindBy(id ="com.apnacomplex:id/more_option")
	private WebElement moreOption;
	
	@AndroidFindBy(id ="com.apnacomplex:id/checkBox")
	private WebElement deleteNotice;
	
	@AndroidFindBy(id ="com.apnacomplex:id/btn_enable")
	private WebElement deleteNoticeY;
	
	@AndroidFindBy(id ="com.apnacomplex:id/btn_close")
	private WebElement deleteNoticeN;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Edit Access Label']")
	private WebElement noticeEditAccess;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text = 'Delete']")
	private WebElement noticeDelete;
	
	
	//Calander

	@AndroidFindBy(accessibility = "Next month")
	private WebElement calSelectNextMonth;
	
	@AndroidFindBy(accessibility ="25 November 2022")
	private WebElement calSelectDate;
	
	
	@AndroidFindBy(id ="android:id/date_picker_header_date")
	private WebElement calDateHeader;
	
	@AndroidFindBy(id ="android:id/date_picker_header_year")
	private WebElement calYearHeader;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text = \"2022\"]")
	private WebElement calSelectYear;
	
	


	/**********************************************************************************	
	 ***********************************************************************************/	


	public void noticeCountAndClick()
	{
		System.out.println(noticeCount.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		eleNotice.click();	
	}
	public void pendingNotice()
	{
		Boolean Approval_pending = approvalPending.isEnabled();
		Boolean Approved_notice = approvedNotice.isEnabled();
		Assert.assertTrue(Approval_pending);
		Assert.assertTrue(Approved_notice);
		approvalPending.click();
		int pending_Count = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id = 'com.apnacomplex:id/name_layout']")).size();
		if (pending_Count > 0)
		{

			System.out.println("Notice Board has" + " " +  pending_Count  + " " +  "Approval pending" );
		}
		else 
		{
			System.out.println( pending_Count  + " " +  "Approval pending" );
		}
	}
	public void approvedNotice()
	{
		approvedNotice.click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		int ApprovedNotice = driver.findElements(By.xpath("//*[@type = 'XCUIElementTypeCell']")).size();
		System.out.println("There are" + " " + ApprovedNotice + " " + " Approved notices visible  on screen As of now ");
	}
	public HomePage back()
	{
		btnBack.click();
		btnbackadmin.click();
		return new HomePage(driver);

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

	public void approveNotice() throws InterruptedException
	{
		approveNotice.click();
		Thread.sleep(3000);
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
	
	public void recheckNotice(String txt)
	{
		recheckFeature(txt);
	}
}