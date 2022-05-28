package KhemlallAutomation.MavenJava;
import org.testng.annotations.Test;

public class RestApiTest {

	@Test(groups="smoke")
	public void PostJira()
	{
		System.out.println("i am executing api jira");
	}
	
	@Test(groups="regression")
	public void DeleteTwitter()
	{
		System.out.println("i am executing api twittwer");
	}


}
