package KhemlallAutomation.MavenJava;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.File;
import java.io.IOException;

import pageObjects.CheckoutPage;
import pageObjects.FormPage;

import utility.Utilities;
	
public class Ecommerce4Test extends base{
	

@Test
	public void TotalValidation() throws IOException, InterruptedException {
	//service.start();
	service = startServer();
	AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     FormPage _formpage = new FormPage(driver);

	    // driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	     _formpage.nameField.sendKeys("Hello");
	     driver.hideKeyboard();

	     //driver.findElement(By.xpath("//*[@text='Female']")).click();
	     _formpage.femaleOption.click();

	  //   driver.findElement(By.id("android:id/text1")).click();

	     _formpage.text1.click();
	     Utilities utl = new Utilities(driver);
	     utl.scrolltotext("Argentina");
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	     
	     
	     
	     //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

	     //driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	     _formpage.countryselection.click();

	     //driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     _formpage.LetsShopBtn.click();
	     

	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	    
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	Thread.sleep(4000);

	int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

	double sum=0;
    CheckoutPage checkout = new CheckoutPage(driver);

	for(int i=0;i<count;i++)

	{

	//String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
    String amount1 = checkout.productlist.get(i).getText();
	double amount=getAmount(amount1);

	sum=sum+amount;//280.97+116.97

	}

	System.out.println(sum+"sum of products");



	String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();



	total= total.substring(1);

	double totalValue=Double.parseDouble(total);

	System.out.println(totalValue+"Total value of products");

	Assert.assertEquals(sum, totalValue); 
     service.stop();


	}

@SuppressWarnings("deprecation")
@BeforeTest
public void killAllNodes() throws IOException, InterruptedException
{
//taskkill /F /IM node.exe
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Thread.sleep(3000);
	
}
	public static double getAmount(String value)

	{

	value= value.substring(1);

	double amount2value=Double.parseDouble(value);

	return amount2value;

	}

}




	
	


