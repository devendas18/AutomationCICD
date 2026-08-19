package DevendraTest.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DevendraTest.TestComponents_20.BaseTest;
import POM.pageobjects.CartPage;
import POM.pageobjects.CheckOutPage;
import POM.pageobjects.ConfirmationPage;
import POM.pageobjects.ProductCatalogue;
import POM.pageobjects.LandingPage;
import POM.pageobjects.OrderPage;

public class SubmitOrderTestSection21_176 extends BaseTest { 
		
			@Test(dataProvider="getData",groups= {"Purchase"})  	//175													
			public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {  //175

				ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password")); //176

				List<WebElement> products=productCatalogue.getproductList();
				productCatalogue.addProductToCart(input.get("product"));  //176
				CartPage cartPage=productCatalogue.goTocartPage();    
				Boolean match=cartPage.VerifyProductDisplay(input.get("product"));  //176
				Assert.assertTrue(match);   

				CheckOutPage checkOutPage=cartPage.goToCheckout();
				checkOutPage.selectCountry("india");
				ConfirmationPage confirmationPage=checkOutPage.submitOrder();
				
				String confirmMessage= confirmationPage.getConfirmationMessage();
				Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
				
				System.out.println("Done");
			}
			//173
			@Test (dependsOnMethods={"submitOrder"})      //if submits orders run then only this test will run
			public void OrderHstoryTest() {
				//"ZARA COAT 3"
				String productName="ZARA COAT 3"; //175 can be here or at the top also
				ProductCatalogue productCatalogue=landingPage.loginApplication("ved18@gmail.com", "User@1234");
				OrderPage ordersPage=productCatalogue.goToOrdersPage();
				Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
				
			}
			//175
			@DataProvider
			public Object[][] getData(){
				//176
				HashMap<String,String> map=new HashMap<String,String>();
				map.put("email", "ved18@gmail.com");
				map.put("password", "User@1234");
				map.put("product", "ZARA COAT 3");
				
				HashMap<String,String> map1=new HashMap<String,String>();
				map.put("email", "atestuser1");
				map.put("password", "User@1234");
				map.put("product", "ADIDAS ORIGINAL");
				
				return new Object[][] {{map},{map1}};
				
			}
			


	}


