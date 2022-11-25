package org.ac.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;  

public abstract class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
	//adb shell dumpsys window | grep -E 'mCurrentFocus'
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port)
	{
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		//service.start();
		return service;
	}
	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	}
	
	//System.getProperty("user.dir")+"//src//test//java//org//ac//testData//Data.json"),StandardCharsets.UTF_8);
	//convert JSON file Content to JSON string
	public List <HashMap<String, String >> getJsonData(String jsonFilePath) throws IOException 
	{
	String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);;
	
	ObjectMapper mapper = new ObjectMapper();
	List <HashMap<String, String >> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String >>>() {});
	return data;
	}

	public String getScreenShotPath(String testCasename, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCasename+".png";
		FileUtils.copyFile(source, new File (destinationFile));
		return destinationFile;
	}

	public String dateTime()
	{
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	return (dateFormat.format(cal.getTime()));
	
	}
	
	
	
	/**************DATA PROVIDERS**************/
	
	@DataProvider
	public Object[][] LoginDetails() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ac//testData//LoginDetails.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}    };
	}	
	
	@DataProvider
	public Object[][] NBDetails() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ac//testData//NBDetails.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}   };
	}	
	
	@DataProvider
	public Object[][] NoticeDetails() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ac//testData//NoticeDetails.json");
		return new Object[][] {{data.get(0)} };
	}	
	
		
}
