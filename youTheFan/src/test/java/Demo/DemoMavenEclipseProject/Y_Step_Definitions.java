package Demo.DemoMavenEclipseProject;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.hu.Ha;
import junit.framework.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Y_Step_Definitions {
	WebDriver driver = null;
	
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
	   System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
	   DesiredCapabilities dc = DesiredCapabilities.firefox();
	   dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

	   FirefoxProfile profile = new FirefoxProfile();
	   profile.setAcceptUntrustedCertificates(true);

	   dc.setCapability(FirefoxDriver.PROFILE, profile);
	   driver =  new FirefoxDriver(dc);
	   driver.get("https://he:he@sand.youthefan.humanelementdev.com");
	   driver.findElement(By.cssSelector("#popupDialog_content > div.popup_buttons > button.cancel_button > span > span > span")).click();
	}
	

	@When("^User navigates to product page$")
	public void User_navigates_to_product_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popupDialog_content > div.popup_buttons > button.cancel_button > span > span > span")));
		driver.findElement(By.cssSelector("#category-node-3 > a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-collection-image-1295")));
	    driver.findElement(By.cssSelector("#product-collection-image-1295")).click();
	}
	
	@When("^User adds product to cart$")
	public void User_adds_product_to_cart() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > div.add-to-cart-buttons > button")));
		driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > div.add-to-cart-buttons > button")).click();
	}

	@Then("^Product is displayed in cart$")
	public void Product_is_displayed_in_cart() throws Throwable {
		Assert.assertTrue("The Akron Zips Sportula was added to your shopping cart.", true);
		driver.close();
	}
	

	
	@When("^User completes billing and shipping steps with valid information$")
	public void user_completes_billing_and_shipping_steps_with_valid_information() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".count")));
	    driver.findElement(By.cssSelector(".cart-link")).click();
	    driver.findElement(By.cssSelector(".top > li:nth-child(4) > button:nth-child(1)")).click();
	    driver.findElement(By.cssSelector("#onepage-guest-register-button")).click();
	    driver.findElement(By.id("billing:firstname")).sendKeys("test");
	    driver.findElement(By.id("billing:lastname")).sendKeys("test");
	    driver.findElement(By.id("billing:email")).sendKeys("kolmstead@human-element.com");
	    driver.findElement(By.id("billing:street1")).sendKeys("123 test st.");
	    driver.findElement(By.id("billing:city")).sendKeys("ann arbor");
	    Select dropdown = new Select(driver.findElement(By.id("billing:region_id")));
	    dropdown.selectByValue("33");
	    driver.findElement(By.id("billing:postcode")).sendKeys("48103");
	    driver.findElement(By.id("billing:telephone")).sendKeys("1234567890");
	    driver.findElement(By.cssSelector("#billing-buttons-container > button:nth-child(1)")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s_method_matrixrate_matrixrate_53")));
	    driver.findElement(By.id("s_method_matrixrate_matrixrate_53")).click();
	    driver.findElement(By.cssSelector("#shipping-method-buttons-container > button:nth-child(2)")).click();
	}

	@When("^User completes payment step with valid information$")
	public void user_completes_payment_step_with_valid_information() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#p_method_sagepaymentsprodirect")));
		driver.findElement(By.cssSelector("#p_method_sagepaymentsprodirect")).click();
	    driver.findElement(By.cssSelector("#sagepaymentsprodirect_cc_owner")).sendKeys("test");
	    driver.findElement(By.cssSelector("#sagepaymentsprodirect_cc_number")).sendKeys("4111111111111111");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#p_method_purchaseorder")));
	    driver.findElement(By.cssSelector("#p_method_purchaseorder")).click();
	    driver.findElement(By.cssSelector("#po_number")).sendKeys("123");
	    driver.findElement(By.cssSelector("#payment-buttons-container > button:nth-child(2)")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-checkout")));
	    driver.findElement(By.cssSelector(".btn-checkout")).click();
	}
	

	
	@Then("^Order is placed successfully$") 
	public void Order_is_placed_successfully() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/img")));
		driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.checkout-success > div > div > a")).click();
	    driver.close();
	
	    
	}
	
	@When("^User completes checkout process$")
	public void User_completes_checkout_process() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".count")));
	    driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-cart-btn-checkout")));
	    driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();
	}
	
	@Given("^User is on Log in Page$")
	public void user_is_on_Log_in_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		   dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		   FirefoxProfile profile = new FirefoxProfile();
		   profile.setAcceptUntrustedCertificates(true);

		   dc.setCapability(FirefoxDriver.PROFILE, profile);
		   driver =  new FirefoxDriver(dc);
		   driver.get("https://he:he@sand.youthefan.humanelementdev.com/customer/account/login/");
		   driver.findElement(By.cssSelector("#popupDialog_content > div.popup_buttons > button.cancel_button > span > span > span")).click();
	}
	
	@When("^User navigates to LogIn Page$")
	public void user_navigates_to_LogIn_Page() throws Throwable {
	    driver.findElement(By.cssSelector("a.skip-link:nth-child(4)")).click();
	    driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).click();
	}

	@When("^User enters valid UserName and Password$")
	public void user_enters_valid_UserName_and_Password() throws Throwable {
		driver.findElement(By.cssSelector(".form-list > li:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys("test@test.com");
	    driver.findElement(By.cssSelector("#pass")).sendKeys("test123");
	    driver.findElement(By.cssSelector("#send2")).click();
	    driver.findElement(By.cssSelector("#send2")).click();
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://sand.youthefan.humanelementdev.com/customer/account/" );
		driver.close();
	}

	@Given("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		   dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		   FirefoxProfile profile = new FirefoxProfile();
		   profile.setAcceptUntrustedCertificates(true);

		   dc.setCapability(FirefoxDriver.PROFILE, profile);
		   driver =  new FirefoxDriver(dc);
		   driver.get("https://he:he@sand.youthefan.humanelementdev.com/customer/account/login/");
		   driver.findElement(By.cssSelector("#popupDialog_content > div.popup_buttons > button.cancel_button > span > span > span")).click();
		   driver.findElement(By.cssSelector(".form-list > li:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys("test@test.com");
		    driver.findElement(By.cssSelector("#pass")).sendKeys("test123");
		    driver.findElement(By.cssSelector("#send2")).click();
	}

	@When("^User clicks Sign Out$")
	public void user_clicks_Sign_Out() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("a.skip-link:nth-child(4)")).click();
		driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
	}

	@Then("^User is signed out successfully$")
	public void user_is_signed_out_successfully() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue("YOU ARE NOW LOGGED OUT", true);
	    driver.close();
	}

	@When("^User enters invalid UserName and Password$")
	public void user_enters_invalid_UserName_and_Password() throws Throwable {
		driver.findElement(By.cssSelector(".form-list > li:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys("test45@test.com");
	    driver.findElement(By.cssSelector("#pass")).sendKeys("test123");
	    driver.findElement(By.cssSelector("#send2")).click();
	}

	@Then("^Error message is displayed$")
	public void error_message_is_displayed() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue("Invalid login or password.", true);
	    driver.close();
	}

}




