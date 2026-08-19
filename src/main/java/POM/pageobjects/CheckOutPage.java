package POM.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DevendraTest.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	//168
		WebDriver driver;
		
		public CheckOutPage(WebDriver driver)
		{
			super(driver);  //  to use the driver code in child`		
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);      //this refers to current class driver			
		}
		
		@FindBy(css=".action_submit") // not working so replaced ".btnn action__submit ng-star-inserted"  on 23/7/26 
		//@FindBy(css=".btnn.action__submit")
		//@FindBy(css=".btnn.action__submit.ng-star-inserted") 
		WebElement submit; 
		
		@FindBy(css="[placeholder='Select Country']") 
		//@FindBy(css="input[placeholder='Select Country']") 
		WebElement country; 
		
		//@FindBy(xpath="//button[contains(@class'ta-item')])[2]")  //not working so replaces with //button[@type='button'][2] on 23/7/26
		@FindBy(xpath="(//button[@type='button'])[2]")     
		//@FindBy(xpath="button:nth-child(2) span:nth-child(1)")
		WebElement selectCountry;  
		
		By results=By.cssSelector(".ta-results");    //list of select country
		
		public void selectCountry(String countryName)  {
			Actions a=new Actions(driver);			
			a.sendKeys(country,countryName).build().perform();
			waitForElementToAppear(results);
			selectCountry.click();
		}
		
		public ConfirmationPage submitOrder() {
			submit.click();
			return new ConfirmationPage(driver);
		}
		
 
		

}
