package KhemlallAutomation.MavenJava;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.homePage;
import pageObjects.preferences;


public class ApiDemoTest extends base {
	
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	// TODO Auto-generated method stub
	   public void tests() throws IOException, InterruptedException{
		//service.start();
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosdebug");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.TextView[@text='preferences']").click();
			homePage hp = new homePage(driver);
			
		     hp.Preferences.click();
		     preferences p=new preferences(driver);
		     p.dependencies.click();
		     driver.findElementById("android:id/checkbox").click();
		     driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		     //driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		     driver.findElementsByClassName("android.widget.Button").get(1).click();
		     service.stop();


	}
}
