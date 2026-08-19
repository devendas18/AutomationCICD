package DevendraTest.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DevendraTest.TestComponents_20.BaseTest;
import POM.pageobjects.CartPage;
import POM.pageobjects.CheckOutPage;
import POM.pageobjects.ConfirmationPage;
import POM.pageobjects.ProductCatalogue;
import POM.pageobjects.LandingPage;
import POM.pageobjects.OrderPage;

public class SubmitOrderTestSection20 extends BaseTest {  //170

	//  public static void main(String[] args) /*throws InterruptedException*/ {  // removed in 170
				
			String productName="ZARA COAT 3";  //moved in 173
			//170	
			@Test       														//TestNG
			public void submitOrder() throws IOException, InterruptedException {

				//removed for 169
				/*WebDriver driver = new ChromeDriver();	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize(); */
		
				//LandingPage landingPage=new LandingPage(driver);  //added for POM sesssion 162 //removed for 170
				//landingPage.goTo(); //  
				//LandingPage landingPage=launchApplication();  //170   removed in 171
				ProductCatalogue productCatalogue=landingPage.loginApplication("ved18@gmail.com", "User@1234"); //added for POM sesssion 163 & 167 ProductCatalogue productCatalogue

				List<WebElement> products=productCatalogue.getproductList();
				//165
				productCatalogue.addProductToCart(productName);
				CartPage cartPage=productCatalogue.goTocartPage();    //167 added for POM session  //added CartPage cartPage 			
				//167 added for POM session
				//CartPage cartPage=new CartPage(driver); removed for 167, added in method
				Boolean match=cartPage.VerifyProductDisplay(productName);
				Assert.assertTrue(match);   //validations cannot go in to POM files, POM should have only the code to perform actions
				//added for POM 168
				CheckOutPage checkOutPage=cartPage.goToCheckout();
				checkOutPage.selectCountry("india");
				ConfirmationPage confirmationPage=checkOutPage.submitOrder();
				
				String confirmMessage= confirmationPage.getConfirmationMessage();
				Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
				//driver.close();   //171
				
				System.out.println("Done");
			}
			//173
			@Test (dependsOnMethods={"submitOrder"})      //if submits orders run then only this test will run
			public void OrderHstoryTest() {
				//"ZARA COAT 3"
				
				ProductCatalogue productCatalogue=landingPage.loginApplication("ved18@gmail.com", "User@1234");
				OrderPage ordersPage=productCatalogue.goToOrdersPage();
				Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
				
			}


	}


