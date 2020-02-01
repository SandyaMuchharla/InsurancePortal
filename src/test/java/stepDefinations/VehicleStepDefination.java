package stepDefinations;

import org.openqa.selenium.By;
import org.junit.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;

import java.util.List;
import java.util.Random;


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
	    driver.close();
	}

	@When("^User selects random picture$")
	public void user_enters_selects_random_picture() throws Throwable {
		/*List<WebElement> items= driver.findElements(By.cssSelector(".product_list.grid.row.homefeatured>li"));
		Random rand = new Random();
		int randomProduct = rand.nextInt(items.size());
		System.out.println("The selected element index is:  "+ randomProduct);
		//Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", items.get(randomProduct));
		items.get(randomProduct).findElement(By.cssSelector(".product-name")).click();*/
		//Thread.sleep(4000);
		WebElement  dresses= driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]"));
		WebElement summerDresses= driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]//ul[@class='submenu-container clearfix first-in-line-xs']/li[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(dresses).perform();
		action.moveToElement(summerDresses).click().perform();

		Random rand = new Random();

		List<WebElement> sizeItems= driver.findElements(By.xpath("//ul[@id='ul_layered_id_attribute_group_1']/li"));
		List<WebElement> colorItems= driver.findElements(By.xpath("//ul[@id='ul_layered_id_attribute_group_3']/li"));

		int randomSize = rand.nextInt(sizeItems.size());
		System.out.println("The selected index for size: "+ randomSize);
		sizeItems.get(randomSize).findElement(By.xpath("//input[@class='checkbox']")).click();

		int randomColors=rand.nextInt(colorItems.size());
		System.out.println("The selected index for colors: "+ randomColors);
		colorItems.get(randomColors).findElement(By.xpath("//input[@class='color-option  ']")).click();


		List<WebElement> items= driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));
		int randomProduct = rand.nextInt(items.size());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", items.get(randomProduct));
		items.get(randomProduct).findElement(By.xpath("//a[@class='product-name']")).click();

        /*driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.cssSelector(".btn.btn-default.button-search")).click();
        //List<WebElement> dresses = driver.findElements(By.cssSelector(".product_list.grid.row>li"));
        List<WebElement> items= driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));
        Random random = new Random();
        int anydresses = random.nextInt(items.size());


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",items.get(anydresses));

        System.out.println("the selected index is" + anydresses);
        //items.get(anydresses).findElement(By.cssSelector(".product-name")).click();
        System.out.println(items.get(anydresses).findElement(By.xpath("//a[@class='product-name']")).getAttribute("href"));
        items.get(anydresses).findElement(By.xpath("//a[@class='product-name']")).click();*/




    }

	@Then("^User should be able to go to next page$")
	public void user_should_be_able_to_go_to_next_page() throws Throwable {
		//Assert.assertEquals(driver.getTitle().toString().contains("My Store"),true);

	}
	@When("^User selects an element from link$")
	public void user_selects_an_element_from_link() throws Throwable {

		WebElement  categories= driver.findElement(By.xpath("//a[@class='cat_btn hidden-xs giTrackElementHeader']"));
		WebElement subMenu = driver.findElement(By.xpath("//li[@class='course_category_name_menu']//a[@id='software-testing-certification-courses']"));
		WebElement course = driver.findElement(By.id("c535"));

		Actions action = new Actions(driver);
		action.moveToElement(categories).perform();
		action.moveToElement(subMenu).perform();
		action.moveToElement(course).click().perform();
	}

	

}
