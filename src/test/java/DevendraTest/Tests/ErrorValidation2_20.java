package DevendraTest.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import DevendraTest.TestComponents_20.BaseTest;
import POM.pageobjects.CartPage;
import POM.pageobjects.ProductCatalogue;

public class ErrorValidation2_20 extends BaseTest {  

		//172	
			@Test (groups={"ErrorHandling"})    //174   														
			public void loginErrorValidation() throws IOException, InterruptedException {  //172 name changed
				//171
				String productName="ZARA COAT 3";  
				landingPage.loginApplication("atestuser1@gmail.com", "User@123");  //171 wrong pass
				Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
				

			}
			//172
			
			@Test       														
			public void productErrorValidation() throws IOException, InterruptedException {
	
				String productName="ZARA COAT 3";  
				ProductCatalogue productCatalogue=landingPage.loginApplication("ved18@gmail.com", "User@1234"); //use diff enamil id so it can be used parallel
				List<WebElement> products=productCatalogue.getproductList();
				productCatalogue.addProductToCart(productName);
				CartPage cartPage=productCatalogue.goTocartPage(); 		
				Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33"); //wrong name
				Assert.assertFalse(match);  //checking error msg so false
			}
			
			
	}


