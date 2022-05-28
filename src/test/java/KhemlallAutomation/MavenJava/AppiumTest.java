package KhemlallAutomation.MavenJava;

import org.testng.annotations.Test;

public class AppiumTest {
	
	@Test
	public void NativeAppAndroid()
	{
		System.out.println("i am executing appium native app android");
	}

	@Test(groups="smoke")
	public void IosApp()
	{
		System.out.println("i am executing appium IosApp");
		
	}

	

}
