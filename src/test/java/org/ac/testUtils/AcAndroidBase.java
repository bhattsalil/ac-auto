package org.ac.testUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.ac.pageObject.android.LoginPage;
import org.ac.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AcAndroidBase extends AppiumUtils
{
	
	public AndroidDriver driver;
	public LoginPage login;
	public AppiumDriverLocalService service;
	
	@BeforeClass (alwaysRun = true)
	public void configurAppium() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//ac//resources//data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		UiAutomator2Options capabilities = new UiAutomator2Options();
		capabilities.setCapability("deviceName", "AYBMH6PVFY55RS75");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.apnacomplex");
		capabilities.setCapability("appActivity", "com.apnacomplex.loginrevamp.SplashActivity");
		driver = new AndroidDriver(service.getUrl(), capabilities);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new LoginPage(driver);
		
	}

	@AfterClass (alwaysRun = true)
	public void TearDown() 
	{
		driver.quit();
		//service.stop();
	}

}
