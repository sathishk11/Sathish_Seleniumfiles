package mobiletesting1;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class hybridtest extends capability {
	AndroidDriver<AndroidElement> driver;
	AndroidDriver<AndroidElement> driver1;
	@Test(priority = 0)
	public void test1() throws MalformedURLException, InterruptedException {
		driver1 = cap();                                // cap is method name in capability class
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_1")).click();
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_2")).click();
		driver1.findElement(MobileBy.AccessibilityId("plus")).click();
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_4")).click();
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_6")).click();
		Thread.sleep(1000);
		driver1.findElement(MobileBy.AccessibilityId("equals")).click();
		driver1.findElement(MobileBy.AccessibilityId("clear")).click();
		driver1.navigate().back();
	}
	@Test(priority = 1)
	public void test2() throws MalformedURLException, InterruptedException {
		driver = generalstore();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();     // click to view country
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
//		driver.findElementByAndroidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(text(\"India\"))").click();
		                                                 // scroll down to view where located in India and click India
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("santra");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();     // for clicking female
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();     // click submit button
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");
		                                                 // scroll down to view where located in product
		Thread.sleep(1000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
		Thread.sleep(1000);                              // it will click the add to cart where it take from first option in that page
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();     //click cart
		Thread.sleep(1000);
		String price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		System.out.println("price-1:"+price1);           //it will print the product price for first product
		price1 = price1.substring(1);                   // it will split and mention the string index 1 (here index 0 = $, index 1 = price)
		Double dprice1 = Double.parseDouble(price1);    //it will make the dprice1 String into double
		System.out.println(dprice1);
		String price2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		System.out.println("Price-2:"+price2);                      //it will print the product price for first product
		price2 = price2.substring(1);                   // it will split and mention the string index 1 (here index 0 = $, index 1 = price)
		Double dprice2 = Double.parseDouble(price2);    // it will make the dprice1 String into double
		System.out.println(dprice2);
		String Totalprice = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println("Totalprice:"+Totalprice);
		Totalprice = Totalprice.substring(2);
		Double dTotal = Double.parseDouble(Totalprice);
		System.out.println("dTotal:"+dTotal);
		Double addedtotal = dprice1 + dprice2;
		System.out.println("addedtotal:"+addedtotal);
		Assert.assertEquals(dTotal, addedtotal);
		if (dTotal.equals(addedtotal)) {
			System.out.println("Assertion pass");
		}
		else {
			System.out.println("Assertion fail");
		}
		driver.pressKey(new KeyEvent(AndroidKey.HOME));  //it will taken to the home screen
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));   //if it give two times, it will switch to another apps  
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}

}
