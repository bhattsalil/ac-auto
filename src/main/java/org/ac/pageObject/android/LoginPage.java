package org.ac.pageObject.android;

import org.ac.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidActions{

	AndroidDriver driver;

	public LoginPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id ="com.apnacomplex:id/email_edittext1")
	private WebElement fieldEmail;
	
	@AndroidFindBy(id ="com.apnacomplex:id/password_edittext")
	private WebElement fieldPassword;

	@AndroidFindBy(id ="com.apnacomplex:id/actionButton")
	private WebElement btnContinue;

	@AndroidFindBy(xpath ="//android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id ="com.apnacomplex:id/actionButton")
	private WebElement btnLogin;
	
	@AndroidFindBy(id ="com.apnacomplex:id/btn_close")
	private WebElement btnClose;
	
	@AndroidFindBy(id ="com.apnacomplex:id/btn_enable")
	private WebElement btnEnable;
	
	
	@AndroidFindBy(id ="com.apnacomplex:id/continue_with_btn")
	private WebElement btnPhone;
	
	@AndroidFindBy(id ="com.apnacomplex:id/mobile_number_edittext")
	private WebElement fieldPhone;
	
	@AndroidFindBy(id ="com.apnacomplex:id/snackbar_text")
	private WebElement noInternet;
	
	
/**********************************************************************************	
***********************************************************************************/	
	
	public void setfieldEmail(String email)
	{
		fieldEmail.sendKeys(email);
	}
	public void setfieldPassword(String Password)
	{
		fieldPassword.sendKeys(Password);
	}
	public void setfieldphone(String Phone)
	{
		fieldPhone.sendKeys(Phone);
	}
	public void submit()
	{
		btnContinue.click();
	}
	
	public void checkbox()
	{
		boolean checkbox = checkBox.isEnabled();
		Assert.assertEquals(checkbox, true);
	}
	
	public HomePage login() throws InterruptedException
	{
		btnLogin.click();
		Thread.sleep(2000);
		String enable = btnEnable.getText();
		Assert.assertEquals(enable, "Enable");
		btnClose.click();
		return new HomePage(driver);	
	}
	public void loginWithPhone()
	{
		btnPhone.click();
	}
	
	public void noInternet()
	{
		String snackBar = noInternet.getText();
		Assert.assertEquals(snackBar, "No Internet Connection");
		System.out.println(snackBar);
	}
	public void setActivity() 
	{
		Activity activity = new Activity ("com.apnacomplex","com.apnacomplex.loginrevamp.SplashActivity");
		driver.startActivity(activity);
	}

}
