package org.ac.ios;
import org.testng.annotations.Test;
import java.util.HashMap;
import org.ac.pageObject.ios.AccountPageIos;
import org.ac.pageObject.ios.HomePageIos;
import org.ac.testUtils.AciOSBase;

public class IOSLogin extends AciOSBase
{
	//
	@Test (dataProvider = "LoginDetails" )
	//TEST SCENARIO : Check user able to login with valid email id and password and check it is navigating to home screen
	//TEST SCENARIO : Check user able to login with valid phone number and password and check it is navigating to home screen
	// Integrated TC_9 //Add the member from web and login in to app
	//
	public void IOS_Login_Tc1_Valid_Login_With_MailAndPhone(HashMap<String, String> input) throws InterruptedException
	{
		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		AccountPageIos accountios = homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);
		//Login With Phone
		loginios.loginWithPhone();
		loginios.setFieldPhone(input.get("phone"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		loginios.login();
		accountios = homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);
	}

	@Test (dataProvider = "NoticeDetails" ,enabled = false )
	//TEST SCENARIO : Check User able to change the password after login
	public void IOSLogin_Tc10_ChangePassword(HashMap<String, String> input) throws InterruptedException
	{
		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		AccountPageIos accountios = homeios.tabAccount();
		accountios.changePassword();
		accountios.setCurrentPassword(input.get("pass"));
		accountios.setNewPassword(input.get("pass"));
		accountios.setConfirmNewPassword(input.get("pass"));
		accountios.savePassword();
		homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);
		//Re-login 
		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		loginios.login();
		homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);
	}

	@Test(dataProvider = "NoticeDetails")
	//TEST SCENARIO : Check the delete functionality.
	public void IOS_Login_Tc11_DeleteUser(HashMap<String, String> input) throws InterruptedException
	{
		loginios.setFieldEmail(input.get("emailDelete"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		AccountPageIos accountios = homeios.tabAccount();
		accountios.delAccount();
		accountios.delete();
		//Re-login 
		loginios.setFieldEmail(input.get("emailDelete"));
		loginios.submit();
		loginios.signUp();
		loginios.backKbDelete();
	}

	@Test (dataProvider = "NoticeDetails")
	//TEST SCENARIO : Click on Login button when net is OFF
	//Explicit case where user have to turn off net  but for IOS it is handling automatically
	public void IOS_Login_Tc8_LoginWithNoInternet(HashMap<String, String> input) throws InterruptedException
	{
		loginios.airplaneMode();
		loginios.openApnaComplex();
		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.noNetRetry();
		loginios.airplaneMode();
		loginios.noSimAlert();
		loginios.openApnaComplex();
		loginios.noNetRetryAgian();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		AccountPageIos accountios = homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);
	}


//	@BeforeMethod
//	public void setActivity()
//	{
//		loginios.setActivity();
//	}


}

/***********************************************************************************************************************************************	
 ***********************************************************************************************************************************************/




