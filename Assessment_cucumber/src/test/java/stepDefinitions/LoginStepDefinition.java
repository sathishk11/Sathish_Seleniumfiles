package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginStepDefinition {

	WebDriver driver;

	@Given("User is on the login page of the Web Tours Application")
	public void user_is_on_the_login_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:1080/webtours");
		driver.manage().window().maximize();
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() throws Throwable {
		WebElement framesetElement = driver.findElement(By.tagName("frameset"));
		driver.switchTo().frame(1);
		WebElement framesetElement2 = driver.findElement(By.tagName("frameset"));
		driver.switchTo().frame(0); Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin"); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin"); Thread.sleep(2000);
	}

	@When("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() throws Throwable {
		WebElement framesetElement3 = driver.findElement(By.tagName("frameset"));
		driver.switchTo().frame(1);
		WebElement framesetElement4 = driver.findElement(By.tagName("frameset"));
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("action"); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("late"); Thread.sleep(2000);
	}

	@And("Clicks on Login button")
	public void clicks_on_login_button() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@Then("User should be redirected to the home page of the application")
	public void user_should_be_redirected_to_home_page() throws Throwable {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Web Tours";
		assert actualTitle.equals(expectedTitle);
		System.out.println("The actual page title is : "+actualTitle);
		driver.quit();
	}

	@Then("User should see an error message on the page")
	public void user_should_see_error_message() throws Throwable {

		driver.switchTo().defaultContent();
		WebElement framesetElement5 = driver.findElement(By.tagName("frameset"));
		driver.switchTo().frame(1);
		WebElement framesetElement6 = driver.findElement(By.tagName("frameset"));
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		String actualErrorMessage = driver.findElement(By.xpath("//font[@color='red']")).getText();
		String expectedErrorMessage = "Web Tours Error - Incorrect Password";
		assert actualErrorMessage.equals(expectedErrorMessage);
		System.out.println("The actual ErrorMessage is : "+actualErrorMessage);
		driver.quit();
	}
}
