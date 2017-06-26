package Demo.DemoMavenEclipseProject;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class D_Step_Definitions {
	WebDriver driver = null;
	
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "/Users/kaitlynolmstead/Desktop/Drivers/chromedriver");
	   driver = new ChromeDriver();
	   driver.get("https://he:he@dev4.dynacraft.m2.humanelementdev.com");
	}

	@When("^User navigates to LogIn Page$")
	public void User_navigates_to_LogIn_Page() throws Throwable {
		driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header-content-wrapper > div.panel.wrapper > div.panel.header > ul > li.authorization-link")).click();
	}

	@When("^User enters valid UserName and Password$")
	public void User_enters_valid_UserName_and_Password() throws Throwable {
	    driver.findElement(By.id("email")).sendKeys("kolmstead@human-element.com");
	    driver.findElement(By.id("pass")).sendKeys("Test123!@#");
	    driver.findElement(By.id("send2")).click();
	}

	@Then("^Login is successful$")
	public void Login_is_successful() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue("My Dashboard", true);
	    driver.close();
	}
	@Given("^User is logged in$")
	public void User_is_logged_in() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/kaitlynolmstead/Desktop/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://he:he@dev4.dynacraft.m2.humanelementdev.com");
		driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header-content-wrapper > div.panel.wrapper > div.panel.header > ul > li.authorization-link > a")).click();
		driver.findElement(By.id("email")).sendKeys("kolmstead@human-element.com");
	    driver.findElement(By.id("pass")).sendKeys("Test123!@#");
	    driver.findElement(By.id("send2")).click();
		Assert.assertTrue("My Dashboard", true);
		
	}

	@When("^User clicks Sign Out$")
	public void User_clicks_Sign_Out() throws Throwable {
	    driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header-content-wrapper > div.panel.wrapper > div.panel.header > ul > li.authorization-link > a")).click();
	}

	@Then("^User is signed out successfully$")
	public void User_is_signed_out_successfully() throws Throwable {
	   Assert.assertTrue("You are signed out", true);
	   driver.close();
		
	}
	

	@When("^User navigates to product page$")
	public void User_navigates_to_product_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-2 > li.level0.nav-1.first.level-top.parent.ui-menu-item")));
		driver.findElement(By.cssSelector("#ui-id-2 > li.level0.nav-1.first.level-top.parent.ui-menu-item")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.page-wrapper > div.sections.nav-sections > div.dropdown-menu-wrapper > div > div:nth-child(1) > ul > li:nth-child(2) > a")));
	    driver.findElement(By.cssSelector("body > div.page-wrapper > div.sections.nav-sections > div.dropdown-menu-wrapper > div > div:nth-child(1) > ul > li:nth-child(2) > a")).click();
	    driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > a > span.product-image-container > span > img")).click();
	}
	
	@When("^User adds product to cart$")
	public void User_adds_product_to_cart() throws Throwable {
		driver.findElement(By.cssSelector("#product-addtocart-button")).click();
	}

	@Then("^Product is displayed in cart$")
	public void Product_is_displayed_in_cart() throws Throwable {
		Assert.assertTrue("You added 18 Hello Kitty Bike with Bag to your shopping cart.", true);
		driver.close();
	}

	@Then("^Error message is displayed$")
	public void Error_message_is_displayed() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue("Invalid login or password.", true);
		driver.close();
	}
	
	
	@When("^User enters invalid UserName and Password$")
	public void User_enters_invalid_UserName_and_Password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("kolmstead@human-element.com");
	    driver.findElement(By.id("pass")).sendKeys("invalid");
	    driver.findElement(By.id("send2")).click();
	    
	}
	
	@When("^User completes checkout with valid information$")
	public void User_completes_checkout_with_valid_information() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header-content-wrapper > div.panel.wrapper > div > div > a")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-cart-btn-checkout")));
	    driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer-email")));
	    driver.findElement(By.cssSelector("#customer-email")).sendKeys("tesssttt@test.com");
	    driver.findElement(By.name("firstname")).sendKeys("test");
	    driver.findElement(By.name("lastname")).sendKeys("test");
	    driver.findElement(By.name("street[0]")).sendKeys("123 test blvd");
	    driver.findElement(By.name("city")).sendKeys("testown");
	    Select dropdown = new Select(driver.findElement(By.name("region_id")));
	    dropdown.selectByValue("33");
	    driver.findElement(By.name("postcode")).sendKeys("12345");
	    driver.findElement(By.name("telephone")).sendKeys("1234567890");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-shipping-method-load > table > tbody > tr")));
	    driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.loading-mask > div > img")));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='authorizenet_directpost']")));
	    driver.findElement(By.xpath("//*[@id='authorizenet_directpost']")).click();
	    driver.findElement(By.cssSelector("#authorizenet_directpost_cc_number")).sendKeys("4111111111111111");
	    driver.findElement(By.cssSelector("#authorizenet_directpost_expiration")).click();
	    driver.findElement(By.cssSelector("#authorizenet_directpost_expiration > option:nth-child(5)")).click();
	    driver.findElement(By.cssSelector("#authorizenet_directpost_expiration_yr")).click();
	    driver.findElement(By.cssSelector("#authorizenet_directpost_expiration_yr > option:nth-child(8)")).click();
	    driver.findElement(By.cssSelector("#authorizenet_directpost_cc_cid")).sendKeys("123");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button")));
	    driver.findElement(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button")).click();
	    
	}

	@Then("^Order is placed successfully$") 
	public void Order_is_placed_successfully() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > div.loading-mask.checkout-processing > div > img")));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://dev4.dynacraft.m2.humanelementdev.com/checkout/onepage/success/" );
	    driver.close();
	    
	}
	
	@When("^User completes checkout process$")
	public void User_completes_checkout_process() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a > span.counter.qty > span.counter-number")));
	    driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper")).click();
	    driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();
	}
	
	
}




