package KhemlallAutomation.MavenJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;
		
	public static AppiumDriverLocalService startServer() {
		boolean serverflag = checkIfServerIsRunning(4723);
        if(!serverflag)
        {      	
        	service = AppiumDriverLocalService.buildDefaultService();
			service.start();
        }
		return service;      
	}
	
	

	public void stopServer() {
	    service.stop();
	}
	
	
	
	
	public void startServerCommandPrompt() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
	        Thread.sleep(10000);
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public void stopServerCommandPrompt() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("taskkill /F /IM node.exe");
	        runtime.exec("taskkill /F /IM cmd.exe");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e){
			isServerRunning=true;
			
		}finally {
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startemulator.bat");
	    Thread.sleep(6000);
	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException 
	{
		
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
		
		if(device.contains("Nexus")) {
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");//new step
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
	}

}
