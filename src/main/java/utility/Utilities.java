package utility;

import KhemlallAutomation.MavenJava.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities{
	
	AndroidDriver<AndroidElement> _driver;
	public Utilities(AndroidDriver<AndroidElement> driver) 
	{
		this._driver=driver;
	}
	
	public void scrolltotext(String Text) 
	{
	     _driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Text+"\"));");
		
	}

}
