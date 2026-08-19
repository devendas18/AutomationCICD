package SeleniumFramework.stepDefinitions_23;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DevendraTest.TestComponents_20.BaseTest;
import POM.pageobjects.CartPage;
import POM.pageobjects.CheckOutPage;
import POM.pageobjects.ConfirmationPage;
import POM.pageobjects.LandingPage;
import POM.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImpl_23 extends BaseTest {
	//197
	public LandingPage landingPage;      //declared globally so it can be used anywhere
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		//code to land on ecomm
		landingPage = launchApplication();		
	}
	
	//@Given("Logged in with username Ved18@gmail.com and password User@123") 
	//we cant use it so making it generic so it can be used for other user details  with (.+) so it will use dynamic data
	
	@Given("^Logged in with username (.+) and password (.+)$")    // start with ^ and end with $ as its Regular exp (RegX)
		public void logged_inusername_and_password(String username,String password) {
		//code for login
		productCatalogue = landingPage.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException{
		List<WebElement> products=productCatalogue.getproductList();
		productCatalogue.addProductToCart(productName);		
	}
	
	//And  Chcekout <productName> and submit the order - this add is conjection of previous step so we can use WHEN also or AND 
	//@And("^Checkout (.+) and submit the order$")
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		
		CartPage cartPage=productCatalogue.goTocartPage();    
		Boolean match=cartPage.VerifyProductDisplay(productName); 
		Assert.assertTrue(match);   

		CheckOutPage checkOutPage=cartPage.goToCheckout();
		checkOutPage.selectCountry("india");
		confirmationPage=checkOutPage.submitOrder();		
	}
	//Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	@Then("{string} message is displayed on ConfirmationPage")         //if we have text already in the step so need to add that in method and use {}  
	public void message_displayed_confirmationPage(String string){
		String confirmMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();//"\"THANKYOU FOR THE ORDER.\"
	}
	//200
	/*@Then("{string} message is displayed")         
	public void message_displayed(String string){
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close(); */
		
		@Then("\"Incorrect email or password.\" message is displayed")
    public void message_is_displayed_on_confirmation_page() {
			Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
			driver.close(); 
	}

}
