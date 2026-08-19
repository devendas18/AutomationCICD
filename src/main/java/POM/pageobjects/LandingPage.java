package POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DevendraTest.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent  { //164 to inherit the abstractcomponents
		//162
		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			super(driver);  //164 to use the driver code in child
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);      //this refers to current class driver			
		}
		
		//WebElement userEmails = driver.findElement(By.id("userEmail"));
		
		//PageFactory                                       //PageFactoy
		
		@FindBy(id="userEmail")                 //FindBy  annotation will construct the  attribute as per the above locator and 
		WebElement userEmail;                    //will assign to element in useremail		
		
		//driver.findElement(By.id("userPassword"));
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		//171
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		//163  to login
		public ProductCatalogue loginApplication(String email,String password)     //167 return type changes to productCatalogue 
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			//167 
			ProductCatalogue productCatalogue =new ProductCatalogue(driver);
			return productCatalogue;
		}
		//to go on landing page
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
 
		//171
		public String getErrorMessage() {
			
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}


}
