package org.ac.pageObject.android;

import org.ac.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountPage extends AndroidActions{
	AndroidDriver driver;

	public AccountPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

//	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc='Account']/android.widget.ImageView")
//	private WebElement accountTab;
	
	@AndroidFindBy(id ="com.apnacomplex:id/logout_main")
	private WebElement btnLogout;
	
	@AndroidFindBy(id ="android:id/button1")
	private WebElement btnYes;
	
	@AndroidFindBy(id ="android:id/button2")
	private WebElement btnNo;
	
	@AndroidFindBy(id ="com.apnacomplex:id/change_pass_main")
	private WebElement btnChangePassword;
	
	@AndroidFindBy(id ="com.apnacomplex:id/edit_current_pass")
	private WebElement fieldCurrentPassword;
	
	@AndroidFindBy(id ="com.apnacomplex:id/edit_new_pass")
	private WebElement fieldNewPassword;
	
	@AndroidFindBy(id ="com.apnacomplex:id/edit_c_new_pass")
	private WebElement fieldConfirmNewPassword;
	
	@AndroidFindBy(id ="com.apnacomplex:id/card_save_pass")
	private WebElement btnSavePassword;
/**********************************************************************************	
***********************************************************************************/	
	
//	public void tabAccount()
//	{
//		accountTab.click();
//	}
	public void logout()
	{
		ScrollAndClick("Logout");
		btnLogout.click();
	}
	public void yes()
	{
		btnYes.click();
	}

	public void changePassword()
	{
		btnChangePassword.click();
	}
	
	public void setCurrentPassword(String CurrentPass)
	{
		fieldCurrentPassword.sendKeys(CurrentPass);
	}
	public void setNewPassword(String NewPassword)
	{
		fieldNewPassword.sendKeys(NewPassword);
	}
	public void setConfirmNewPassword(String ConfirmNewPassword)
	{
		fieldConfirmNewPassword.sendKeys(ConfirmNewPassword);
	}
	public void savePassword()
	{
		btnSavePassword.click();
	}

}
