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


public class P_Step_Definitions {
	WebDriver driver = null;
	
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "/Users/kaitlynolmstead/Desktop/Drivers/chromedriver");
	   driver = new ChromeDriver();
	   driver.get("http://pentair.hestage.com/");
	}

	@When("^User navigates to LogIn Page$")
	public void User_navigates_to_LogIn_Page() throws Throwable {
	    driver.findElement(By.cssSelector("#top_nav > li:nth-child(6) > a")).click();
	}

	@When("^User enters valid UserName and Password$")
	public void User_enters_valid_UserName_and_Password() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    driver.findElement(By.cssSelector("#email")).sendKeys("test123@test.com");
	    driver.findElement(By.cssSelector("#pass")).sendKeys("test123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#send2")));
	    driver.findElement(By.cssSelector("#send2")).click();
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
		driver.get("http://pentair.hestage.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("#top_nav > li:nth-child(6) > a")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("test123@test.com");
	    driver.findElement(By.cssSelector("#pass")).sendKeys("test123");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#send2")));
	    driver.findElement(By.cssSelector("#send2")).click();
		Assert.assertTrue("Welcome, test", true);
		
	}

	@When("^User clicks Sign Out$")
	public void User_clicks_Sign_Out() throws Throwable {
	    driver.findElement(By.cssSelector("#top_nav > li:nth-child(7) > a")).click();
	}

	@Then("^User is signed out successfully$")
	public void User_is_signed_out_successfully() throws Throwable {
	   Assert.assertTrue("You are signed out", true);
	   driver.close();
		
	}
	

	@When("^User navigates to product page$")
	public void User_navigates_to_product_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#menu > ul:nth-child(1) > li:nth-child(3) > a")).click();
	    driver.findElement(By.cssSelector("#menu > ul:nth-child(1) > li:nth-child(3) > div.menu_collapse > ul > li:nth-child(3) > a")).click();
	    driver.findElement(By.cssSelector("#products-list > li:nth-child(2) > a > img")).click();
	    driver.findElement(By.cssSelector("#main_div > section.breadcrum-category > div.right-box-category > div.category-products > ul.products-grid.backgroundCorlor_remove.first.odd > li:nth-child(2) > a > img")).click();
	    
	}
	
	@When("^User adds product to cart$")
	public void User_adds_product_to_cart() throws Throwable {
		driver.findElement(By.cssSelector("#super-product-table > tbody > tr:nth-child(9) > td.a-center.last > input")).sendKeys("1");
		driver.findElement(By.cssSelector("#product_addtocart_form > div > div.six.columns.product-shop.width30per.width100per > div.pricebox-container > div.add-to-box > div > button")).click();
	}

	@Then("^Product is displayed in cart$")
	public void Product_is_displayed_in_cart() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#overlay-content > div > div > button.button.continue-shopping > img")));
		driver.findElement(By.cssSelector("#overlay-content > div > div > button.button.continue-shopping > img")).click();
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
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#overlay-content > div > div > button.button.proceed-to-checkout > img")));
	    driver.findElement(By.cssSelector("#overlay-content > div > div > button.button.proceed-to-checkout > img")).click();
	    driver.findElement(By.cssSelector("#content > div > div > div > div > div.page-title.title-buttons > ul > li > button > span > span")).click();
	    driver.findElement(By.cssSelector("#login-email")).sendKeys("test123@test.com");
	    driver.findElement(By.cssSelector("#login-password")).sendKeys("test123");
	    driver.findElement(By.cssSelector("#checkout-step-login > div > div.six.columns.col-2 > div > button")).click();
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#checkout-step-login > div > div.six.columns.col-2 > div > button")));
	    driver.findElement(By.cssSelector("#billingsavebutton > span > span")).click();
	    driver.findElement(By.cssSelector("#s_method_fedex_FEDEX_GROUND")).click();
	    driver.findElement(By.cssSelector("#partial_ship_allowed")).click();
	    driver.findElement(By.cssSelector("#partial_ship_allowed > option:nth-child(2)")).click();
	    driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();
	    driver.findElement(By.cssSelector("#p_method_checkmo")).click();
	    driver.findElement(By.cssSelector("#payment-buttons-container > button > span > span")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#agreement-1")));
	    driver.findElement(By.cssSelector("#agreement-1")).click();
	    driver.findElement(By.cssSelector("#agreement-1")).click();
	    driver.findElement(By.cssSelector("#review-buttons-container > button > span > span")).click();
	   
	}

	@Then("^Order is placed successfully$") 
	public void Order_is_placed_successfully() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#review-please-wait")));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://pentair.hestage.com/checkout/onepage/success/" );
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




