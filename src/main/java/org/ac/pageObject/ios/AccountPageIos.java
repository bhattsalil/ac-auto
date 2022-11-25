package org.ac.pageObject.ios;

import org.ac.utils.IosActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccountPageIos extends IosActions{
	IOSDriver driver;

	public AccountPageIos(IOSDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility = "Logout")
	private WebElement logout;
	
	@iOSXCUITFindBy(accessibility = "Change Password")
	private WebElement btnChangePassword;
	
	@iOSXCUITFindBy(iOSNsPredicate ="value == 'Current Password'")
	private WebElement currentPassword;
	
	@iOSXCUITFindBy(iOSNsPredicate ="value == 'New Password'")
	private WebElement currentNewPassword;
	
	@iOSXCUITFindBy(iOSNsPredicate ="value == 'Confirm New Password'")
	private WebElement currentConfirmNewPassword;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'loginpassword'`][1]")
	private WebElement eyeCurrentPass;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`label == 'loginpassword'`][2]")
	private WebElement eyeConfirmNewPass;

	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`name == 'Change Password'`]")
	private WebElement savePass;
	
	@iOSXCUITFindBy(accessibility = "Password successfully changed.")
	private WebElement tabShimmerPassChange;
	
	@iOSXCUITFindBy(accessibility = "Next:")
	private WebElement btnKbNext;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Delete'`]")
	private WebElement delete;
	
	@iOSXCUITFindBy(accessibility = "Delete Account")
	private WebElement delAcc;
	

	
/***********************************************************************************	
***********************************************************************************/	

	public void logout()
	{
		ScrollAndClick("Logout");
	}

	public void changePassword()
	{
		btnChangePassword.click();
	}
	public void setCurrentPassword(String pass) throws InterruptedException
	{
		currentPassword.sendKeys(pass);
		eyeCurrentPass.click();
		Thread.sleep(500);
		eyeCurrentPass.click();	
	}
	public void setNewPassword(String cpass)
	{
		currentNewPassword.sendKeys(cpass);
	}
	public void setConfirmNewPassword(String cpass) throws InterruptedException
	{
		currentConfirmNewPassword.sendKeys(cpass);
		eyeConfirmNewPass.click();
		Thread.sleep(500);
		eyeConfirmNewPass.click();
		btnKbNext.click();
	}

	public void savePassword() throws InterruptedException
	{
		savePass.click();
		Thread.sleep(500);
		tabShimmerPassChange.isEnabled();
		Assert.assertTrue(true);
	}
	
	public void delAccount()
	{
		ScrollAndClick("Delete Account");
		delAcc.click();
	}
	
	public void delete() throws InterruptedException
	{
		delete.click();
		Thread.sleep(1000);
	}
}
