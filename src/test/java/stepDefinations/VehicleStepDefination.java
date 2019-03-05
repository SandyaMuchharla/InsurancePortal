package stepDefinations;

import org.openqa.selenium.By;
import org.junit.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;


public class VehicleStepDefination extends Base 
{

	@Given("^Initialize the browser with \"([^\"]*)\"$")
	public void initialize_the_browser_with(String browser) throws Throwable 
	{
		driver =initializeDriver(browser);
	}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String url) throws Throwable 
	{
		driver.get(url);   
	}

	@When("^User enters vehicle registration number \"([^\"]*)\"$")
	public void user_enters_vehicle_registration_number(String vehicleNumber) throws Throwable
	{
		driver.findElement(By.id("vehicleReg")).sendKeys(vehicleNumber);
	}

	@And("^User click on Find Vehicle button$")
	public void user_click_on_Find_Vehicle_button() throws Throwable 
	{
		driver.findElement(By.name("btnfind")).click();
	}

	@Then("^User should be able to see vehicle registration details$")
	public void user_should_be_able_to_see_vehicle_registration_details() throws Throwable 
	{
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-container\"]/div[4]/div[1]")).isDisplayed());
	    
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable 
	{
	    //driver.close();
	}


	

}
