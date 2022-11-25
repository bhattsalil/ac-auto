package org.ac.pageObject.ios;

import java.util.HashMap;
import java.util.Map;

import org.ac.utils.IosActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPageIos extends IosActions{
	
	
	IOSDriver driver;

	public LoginPageIos(IOSDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	private WebElement fieldEmail;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'Continue'`]")
	private WebElement btnContinue;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private WebElement fieldPassword;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Login'`]")
	private WebElement btnLogin;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue with Phone'`]")
	private WebElement btnLoginWithPhone;
	
	@iOSXCUITFindBy(iOSNsPredicate = "value == 'Enter Phone Number'")
	private WebElement setFieldPhone;
	
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement btnKbDone;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Sign Up'`][1]")
	private WebElement signUp;
	
	@iOSXCUITFindBy(iOSNsPredicate ="label == 'BackButton' ")
	private WebElement backDelete;
	
	@iOSXCUITFindBy(accessibility ="delete")
	private WebElement backKbDelete;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`label == 'Airplane Mode'`]")
	private WebElement toggleAirplaneMode;
	
	@iOSXCUITFindBy(accessibility ="Retry")
	private WebElement noNetRetry;
	
	@iOSXCUITFindBy(accessibility ="OK")
	private WebElement noSimAlert;
	
	
/***********************************************************************************	
***********************************************************************************/		
	
	
	
//	public void setActivity()
//	{
//		
//
//	}
	public void setFieldEmail(String email)
	{
		fieldEmail.sendKeys(email);
	}
	public void submit()
	{
		btnContinue.click();
	}
	public void setFieldPassword(String password)
	{
		fieldPassword.sendKeys(password);
		driver.hideKeyboard();
	}
	
	public HomePageIos login()
	{
		btnLogin.click();
		return new HomePageIos(driver);	
	}

	public  void loginWithPhone()
	{
		btnLoginWithPhone.click();

	}
	public  void setFieldPhone(String Phone)
	{
		setFieldPhone.click();
		setFieldPhone.sendKeys(Phone);
		btnKbDone.click();
	}
	
	public  void signUp()
	{
		String signup = signUp.getText();
		Assert.assertEquals(signup, "Sign Up");
		backDelete.click();
	}
	
	public  void backKbDelete() throws InterruptedException
	{
		backKbDelete.click();
		WebElement ele = backKbDelete;
		Map <String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration",5);
		driver.executeScript("mobile:touchAndHold", params);
		Thread.sleep(2000);
	}
	
	public void airplaneMode() throws InterruptedException
	{
		driver.activateApp("com.apple.Preferences");
		toggleAirplaneMode.click();
		Thread.sleep(2000);
	}
	
	public void openApnaComplex() throws InterruptedException
	{
		driver.activateApp("com.apnacomplex.member");
		Thread.sleep(2000);
	}
	public void noSimAlert() 
	{
		noSimAlert.click();
	}
	public void noNetRetry() throws InterruptedException
	{
		String alert = noNetRetry.getAttribute("name");
		Assert.assertEquals(alert , "Retry");
		Thread.sleep(2000);
		
	}
	public void noNetRetryAgian() throws InterruptedException
	{
		noNetRetry.click();	
		
	}
	public void setActivity()
	{
		driver.activateApp("com.apnacomplex.member");
		
	}
}
