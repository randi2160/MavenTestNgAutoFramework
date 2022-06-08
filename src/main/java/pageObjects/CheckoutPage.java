package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {
	public CheckoutPage(AndroidDriver<AndroidElement> driver)
	{
		//initialize all the elements with driver and it will concatinate
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public List<WebElement> productlist;
	
	//String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalamount;

	public List<WebElement> GetProductlist()
	{
	 return productlist;
	}

}
