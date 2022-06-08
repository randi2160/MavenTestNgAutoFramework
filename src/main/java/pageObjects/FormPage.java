package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	public FormPage(AndroidDriver<AndroidElement> driver)
	{
		//initialize all the elements with driver and it will concatinate
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	// driver.findElement(By.xpath("//*[@text='Female']"))
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	public WebElement text1;
	
    //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	//driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement countryselection;
	
	//	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop\"")
	public WebElement LetsShopBtn;
	
	
	
	//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public WebElement addtocart;
	

  // driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
 
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement appbarbtncart;
	
	public WebElement getNameFiled()
	{
		return nameField;
	}

}
