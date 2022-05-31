package KhemlallAutomation.MavenJava;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	@Test
	public void BrowserAutomation()
	{
		System.out.println("i am executing seleniumtest BrowserAutomation");
	}
	
	@Test(groups="smoke")
	public void FindElement()
	{
		System.out.println("i am executing seleniumtest findelement");
	}

}
