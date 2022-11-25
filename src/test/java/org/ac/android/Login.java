package org.ac.android;
import org.testng.annotations.Test;
import java.util.HashMap;
import org.ac.pageObject.android.AccountPage;
import org.ac.pageObject.android.HomePage;
import org.ac.testUtils.AcAndroidBase;

public class Login extends AcAndroidBase
{
	@Test (dataProvider = "LoginDetails")
	//TEST SCENARIO : Check user able to login with valid email id and password and check it is navigating to home screen
	//TEST SCENARIO : Check user able to login with valid phone number and password and check it is navigating to home screen
	//TEST SCENARIO : Check Visitor notification pop up is appearing when user login to enable the "Display over other app's" setting
	public void Android_Login_Tc1_Valid_Login_With_MailAndPhone(HashMap<String, String> input) throws InterruptedException
	{
		//Login With  Mail
		login.checkbox();
		login.setfieldEmail(input.get("email"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		HomePage home = login.login();
		AccountPage account = home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);
		//Login With Phone
		login.loginWithPhone();
		login.setfieldphone(input.get("phone"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		login.login();
		home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);
	}

	@Test (dataProvider = "NoticeDetails")
	//TEST SCENARIO : Check User able to change the password after login
	public void Android_Login_Tc10_ChangePassword(HashMap<String, String> input) throws InterruptedException
	{ 
		login.checkbox();
		login.setfieldEmail(input.get("email"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		HomePage home = login.login();
		AccountPage account = home.tabAccount();
		account.changePassword();
		account.setCurrentPassword(input.get("pass"));
		account.setNewPassword(input.get("pass"));
		account.setConfirmNewPassword(input.get("pass"));
		account.savePassword();
		account.logout();
		account.yes();
		Thread.sleep(2000);
		login.setfieldEmail(input.get("email"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);
	}

	@Test (enabled = false)
	//TEST SCENARIO : Click on Login button when net is OFF 
	// EXPLICIT CASE : User have to turn-off inter-net or put Phone in Flight mode before implementing this case 
	public void Android_Login_Tc8_LoginWithNoInternet() throws InterruptedException
	{ 
		login.noInternet();	
	}
	
}

/***********************************************************************************************************************************************	
***********************************************************************************************************************************************/	
	
	
//	@BeforeMethod
//	public void setActivity()
//	{
//		login.setActivity();
//	}

	
	/*
	@Test
	public void Login_Tc000() throws InterruptedException
	{ 
		OnOffWiFi();
		login.setfieldEmail(Constants.emailAdmin);
		login.submit();
		String snackBar = driver.findElement(By.id("com.apnacomplex:id/snackbar_text")).getText();
		Assert.assertEquals(snackBar, "No Internet Connection");
		System.out.println(snackBar);
		OnOffWiFi();

	}*/


