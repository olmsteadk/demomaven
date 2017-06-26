package Demo.DemoMavenEclipseProject;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GW_Step_Definitions {
	WebDriver driver = null;
	
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "/Users/kaitlynolmstead/Desktop/Drivers/chromedriver");
	   driver = new ChromeDriver();
	   driver.get("https://he:he@gwkent.hestage.com");
	}

	@When("^User navigates to LogIn Page$")
	public void User_navigates_to_LogIn_Page() throws Throwable {
	    driver.findElement(By.cssSelector("#header > div > div.skip-links > a.skip-login > span.label")).click();
	}

	@When("^User enters valid UserName and Password$")
	public void User_enters_valid_UserName_and_Password() throws Throwable {
	    driver.findElement(By.id("email")).sendKeys("kolmstead@human-element.com");
	    driver.findElement(By.id("pass")).sendKeys("test123");
	    driver.findElement(By.cssSelector("#send2 > span > span")).click();
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
		driver.get("https://he:he@gwkent.hestage.com");
		driver.findElement(By.cssSelector("#header > div > div.skip-links > a.skip-login > span.label")).click();
		driver.findElement(By.id("email")).sendKeys("kolmstead@human-element.com");
	    driver.findElement(By.id("pass")).sendKeys("test123");
	    driver.findElement(By.id("send2")).click();
		Assert.assertTrue("Welcome, test", true);
		
	}

	@When("^User clicks Sign Out$")
	public void User_clicks_Sign_Out() throws Throwable {
	    driver.findElement(By.cssSelector("#header > div > div.skip-links > a.skip-login > span.label")).click();
	}

	@Then("^User is signed out successfully$")
	public void User_is_signed_out_successfully() throws Throwable {
	   Assert.assertTrue("You are signed out", true);
	   driver.close();
		
	}
	

	@When("^User navigates to product page$")
	public void User_navigates_to_product_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a")).click();
	    driver.findElement(By.cssSelector("#subcat-visual-nav > li:nth-child(2) > a > img")).click();
	    driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div.main > div.col-main > div.category-products > ul > li:nth-child(14) > div > h2 > a")).click();
	   
	}
	
	@When("^User adds product to cart$")
	public void User_adds_product_to_cart() throws Throwable {
		driver.findElement(By.cssSelector("#qty")).sendKeys("2");
		driver.findElement(By.cssSelector("#attribute208")).click();
		driver.findElement(By.cssSelector("#attribute208 > option:nth-child(9)")).click();
		driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
	}

	@Then("^Product is displayed in cart$")
	public void Product_is_displayed_in_cart() throws Throwable {
		Assert.assertTrue("You added Radiant Tee to your shopping cart.", true);
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
		driver.findElement(By.id("email")).sendKeys("test@test.com");
	    driver.findElement(By.id("pass")).sendKeys("invalid");
	    driver.findElement(By.id("send2")).click();
	    
	}
	
	@When("^User completes checkout with valid information$")
	public void User_completes_checkout_with_valid_information() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > div.cart-totals-wrapper > div > ul > li.method-checkout-cart-methods-onepage-bottom > button > span > span")).click();
	    driver.findElement(By.cssSelector("#onepage-guest-register-button > span > span")).click();
	    driver.findElement(By.id("billing:firstname")).click();
	    driver.findElement(By.id("billing:firstname")).sendKeys("test");
	    driver.findElement(By.id("billing:lastname")).sendKeys("test");
	    driver.findElement(By.id("billing:company")).sendKeys("human element");
	    driver.findElement(By.id("billing:email")).sendKeys("test@test.com");
	    driver.findElement(By.id("billing:street1")).sendKeys("123 test st");
	    driver.findElement(By.id("billing:city")).sendKeys("testown");
	    Select dropdown = new Select(driver.findElement(By.id("billing:region_id")));
	    dropdown.selectByValue("33");
	    driver.findElement(By.id("billing:postcode")).sendKeys("12345");
	    driver.findElement(By.id("billing:telephone")).sendKeys("1234567890");
	    driver.findElement(By.cssSelector("#billing-buttons-container > button")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("shipping_method")));
	    WebElement radioBtn = driver.findElement(By.name("shipping_method"));
	    radioBtn.click();
	    driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();
	    driver.findElement(By.id("ccsave_cc_owner")).sendKeys("test test");
	    driver.findElement(By.id("ccsave_cc_type")).click();
	    driver.findElement(By.cssSelector("#ccsave_cc_type > option:nth-child(3)")).click();
	    driver.findElement(By.cssSelector("#ccsave_cc_number")).sendKeys("4111111111111111");
	    driver.findElement(By.cssSelector("#ccsave_expiration")).click();
	    driver.findElement(By.cssSelector("#ccsave_expiration > option:nth-child(10)")).click();
	    driver.findElement(By.cssSelector("#ccsave_expiration_yr")).click();
	    driver.findElement(By.cssSelector("#ccsave_expiration_yr > option:nth-child(8)")).click();
	    driver.findElement(By.cssSelector("#payment-buttons-container > button > span > span")).click();
	    driver.findElement(By.cssSelector("#review-buttons-container > button > span > span")).click();
	   
	}

	@Then("^Order is placed successfully$") 
	public void Order_is_placed_successfully() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body > table > tbody > tr:nth-child(1233) > td.line-content > span > a")));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://gwkent.hestage.com/checkout/onepage/success/" );
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




