package Demoqapage;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Formspage {
	WebDriver wd;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://demoqa.com/forms");
		Thread.sleep(3000);	
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	  public void Practiceforms() throws InterruptedException, AWTException{
		Robot rc = new Robot();
		JavascriptExecutor js = (JavascriptExecutor)wd;
		  js.executeScript("window.scrollBy(0,200)");
		  wd.findElement(By.xpath("//*[@class='accordion']/div[2]/div/ul/li[1]")).click();
		  Thread.sleep(1000);  js.executeScript("window.scrollBy(0,200)"); Thread.sleep(1000);
		  wd.findElement(By.id("firstName")).sendKeys("sathish"); Thread.sleep(1000);
		  wd.findElement(By.id("lastName")).sendKeys("kumar"); Thread.sleep(1000);
		  wd.findElement(By.id("userEmail")).sendKeys("sathish@gmail.com"); Thread.sleep(2000); Actions act = new Actions(wd);
		  WebElement z1 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/form/div[3]/div[2]/div[1]/input")); 
		  act.moveToElement(z1).click().build().perform();  Thread.sleep(2000);
		  wd.findElement(By.id("userNumber")).sendKeys("8071553712"); Thread.sleep(1000);
		  wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/form/div[5]/div[2]/div[1]/div/input")).click(); Thread.sleep(2000);
		  wd.findElement(By.xpath("//*[@class='react-datepicker']/div[2]/div[1]/div[2]/div[2]/select/option[93]")).click(); Thread.sleep(1000);
		  wd.findElement(By.xpath("//*[@class='react-datepicker']/div[2]/div[1]/div[2]/div[1]/select/option[8]")).click(); Thread.sleep(1000);
		  wd.findElement(By.xpath("//*[@class='react-datepicker']/div[2]/div[2]/div[4]/div[1]")).click(); Thread.sleep(2000);
		  rc.keyPress(MenuKeyEvent.VK_DOWN); Thread.sleep(2000);
		  //wd.findElement(By.xpath("//*[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("TESTING"); Thread.sleep(2000);
		  new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[3]/input"))).click(); Thread.sleep(2000);
		  wd.findElement(By.id("uploadPicture")).sendKeys("Users//Admin//Desktop//already responded.png/");
		  wd.findElement(By.id("currentAddress")).sendKeys("coimbatore"); Thread.sleep(1000);
		  wd.findElement(By.xpath("//*[@id='stateCity-wrapper']/div[2]/div/div/div[2]/div")).click();
		  rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER); Thread.sleep(2000);
		  wd.findElement(By.xpath("//*[@id='stateCity-wrapper']/div[3]/div/div/div[2]/div")).click();
		  rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER); Thread.sleep(2000);
		  wd.findElement(By.id("submit")).click(); Thread.sleep(4000);
	  }
	@AfterTest
	  public void afterTest() {
		  wd.close();
	  }
}