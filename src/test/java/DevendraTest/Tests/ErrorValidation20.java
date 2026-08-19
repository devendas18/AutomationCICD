package DevendraTest.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DevendraTest.TestComponents_20.BaseTest;

public class ErrorValidation20 extends BaseTest {  

		//171	
			@Test       														
			public void submitOrder() throws IOException, InterruptedException {
	
				String productName="ZARA COAT 3";  
				//ProductCatalogue productCatalogue=landingPage.loginApplication("ved18@gmail.com", "User@1234");  //171 
				landingPage.loginApplication("ved18@gmail.com", "User@123");  //171 wrong pass
				//171
				Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
				

			}

	}


