package stepDefFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoReg {

	WebDriver driver=null;
	public static String Url="http://demo.automationtesting.in/Register.html";
	public static String home="//h2[text()='Registration']";
	public static String fName="//input[@placeholder='First Name']";
	public static String lName="//input[@placeholder='Last Name']";
	public static String add="//label[text()='Address']/..//textarea";
	public static String email="//input[@ng-model='EmailAdress']";
	public static String phone="//input[@ng-model='Phone']";
	public static String country="//select[@id='countries']";
	public static String pass="//input[@id='firstpassword']";
	public static String rePass="//input[@id='secondpassword']";
	public static String submit="//input[@name='signup']";
	
	@Given("^User wants to configure the browser$")
	public void user_wants_to_configure_the_browser() throws Throwable {
		
		//System.setProperty("WebDriver.chrome.driver", "C:\\Users\\CHERRY\\workspace\\CucumberWithJava\\drivers\\chromedriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	/* This is my First Git Project*/

	@Given("^User provide the specified URL$")
	public void user_provide_the_specified_URL() throws Throwable {
		
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	
	}

	@Given("^Verify User on Registration Page$")
	public void verify_User_on_Registration_Page() throws Throwable {
		
		String value=driver.findElement(By.xpath(home)).getText();
		if(value.equals("Registration"))
		{
			System.out.println("User is on Reg page");
		}
		else
		{
			System.out.println("Ust not available");
		}
	}

	@When("^User Enter all the required inforation$")
	public void user_Enter_all_the_required_inforation() throws Throwable {
		
		driver.findElement(By.xpath(fName)).sendKeys("Raju");
		driver.findElement(By.xpath(lName)).sendKeys("Raj");
		driver.findElement(By.xpath(add)).sendKeys("Chennai");
		driver.findElement(By.xpath(email)).sendKeys("Raju@gmail.com");
		driver.findElement(By.xpath(phone)).sendKeys("9875648574");
		driver.findElement(By.xpath(country)).sendKeys("India");
		driver.findElement(By.xpath(pass)).sendKeys("Raju@123");
		driver.findElement(By.xpath(rePass)).sendKeys("Raju@123");
	}

	@Then("^User clicking the Submitt button$")
	public void user_clicking_the_Submitt_button() throws Throwable {
		driver.findElement(By.xpath(submit)).click();
	}
		 
}
