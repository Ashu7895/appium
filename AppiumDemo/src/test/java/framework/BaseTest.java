package framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import myreports.ExtentManager;

public class BaseTest extends TestListener implements ITestListener{
	
	static AppiumDriver<MobileElement> driver;
	static ExtentReports myExtent;
	static ExtentTest myTest;
	
	@SuppressWarnings("deprecation")
	//@Parameters({"deviceId","deviceName","portNumber"})
	@BeforeTest
	public void TestSetUp() throws InterruptedException
	{
//		System.out.println("Device Id      " + deviceId);
//		System.out.println("Device Name    " + deviceName);
//		System.out.println("Port Number    " + portNumber);
//		<parameter name="deviceId" value="emulator-5554"></parameter>
//		  <parameter name="deviceName" value="Google Pixe 2Xl" ></parameter>
//		  <parameter name="portNumber" value="4723"></parameter>

			
		try {
		System.out.print("hi am in base test class");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixe 2Xl");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\akumsrivasta\\Desktop\\Roche\\FH-QA\\fh.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,caps);
		myExtent = ExtentManager.GetExtent();
		
	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }

	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
		myExtent.flush();
		
	}

}
