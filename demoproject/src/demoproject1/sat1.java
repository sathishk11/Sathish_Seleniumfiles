package demoproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sat1 {
		  public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.navigate().to("https://opensource-demo.orangehrmlive.com");
			Thread.sleep(3000);
		  wd.findElement(By.name("username")).sendKeys("Admin");
		wd.findElement(By.name("password")).sendKeys("admin123");
		wd.findElement(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\']")).click();
		Thread.sleep(3000);
	  	  wd.findElement(By.linkText("Admin")).click();
		Thread.sleep(3000);
	 wd.findElement(By.linkText("PIM")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--secondary\']")).click();
		Thread.sleep(3000);
	  wd.findElement(By.xpath("//*[@class=\'oxd-userdropdown-name\']")).click();
	  Thread.sleep(1000);
	  wd.findElement(By.linkText("Logout")).click();
	  Thread.sleep(3000);
	  wd.close();
 }
}

