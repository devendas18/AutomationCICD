package DevendraTest.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import DevendraTest.TestComponents_20.BaseTest;
import DevendraTest.TestComponents_20.Retry_22_183;
import POM.pageobjects.CartPage;
import POM.pageobjects.ProductCatalogue;

public class ErrorValidation22_180_181 extends BaseTest {  

		//172	
			@Test (groups={"ErrorHandling"},retryAnalyzer=Retry_22_183.class)    //174   //183 added retryAnalyzer ffor retry														
			public void loginErrorValidation() throws IOException, InterruptedException {  //172 name changed
				//171			
				String productName="ZARA COAT 3";  
				landingPage.loginApplication("atestuser1@gmail.com", "User@123");  //171 wrong pass
				Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage()); //181 removed or in msg to fail the tc
				

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


