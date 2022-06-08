package KhemlallAutomation.MavenJava;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import KhemlallAutomation.MavenJava.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pageObjects.homePage;
import pageObjects.preferences;
import utility.Utilities;
public class XpathAndTextAttributesTest  extends base{

	@Test
	public void test() throws IOException, InterruptedException {
		       File appDir = new File("src");
		   
		    File app = new File(appDir, "ApiDemos-debug.apk");

	service = startServer();
	AndroidDriver<AndroidElement> driver = capabilities("ApiDemosdebug");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Text+"\"));");
	 Utilities utl = new Utilities(driver);
     utl.scrolltotext("Preference");
     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Preference\"));");
     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Preference\"));").click();

	//List <WebElement>b=driver.findElements(By.id("android:id/text1"));
	
				
		    

	
}}
