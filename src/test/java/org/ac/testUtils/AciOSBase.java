package org.ac.testUtils;

import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.ac.pageObject.ios.LoginPageIos;
import org.ac.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AciOSBase extends AppiumUtils
{

	public LoginPageIos loginios;
	public IOSDriver driver;
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
		XCUITestOptions options = new XCUITestOptions();
		options.setPlatformName("iOS");
		options.setDeviceName("SaliliPhone");
		options.setPlatformVersion("16.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		options.setCapability("xcodeOrgId","6Q7P92J7P9");
		options.setCapability("xcodeSigningId","iPhone Developer");
		options.setCapability("udid","00008101-00141D643EC1001E");
		//options.setCapability("updateWDABundleId","io.appiumAC1.WebDriverAgentRunner");

		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Map <String, String> params = new HashMap<String, String>();
		params.put("bundleId", "com.apnacomplex.member");
		driver.executeScript("mobile:launchApp", params );
		loginios = new LoginPageIos(driver);

	}



	@AfterClass (alwaysRun = true)
	public void tearDown()
	{
		driver.terminateApp("com.apnacomplex.member");
		driver.quit();
		service.stop();
	}


}


