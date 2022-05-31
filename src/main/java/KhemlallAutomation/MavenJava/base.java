package KhemlallAutomation.MavenJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		// TODO Auto-generated method stub
		System.getProperty("user.dir");
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\KhemlallAutomation\\MavenJava\\global.properities");
		Properties prop = new Properties();
		prop.load(fls);
	    prop.get(appName);
		
		
		AndroidDriver<AndroidElement> driver;
		DesiredCapabilities cap= new DesiredCapabilities();
		String device=(String) prop.get("device");
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
	}

}
