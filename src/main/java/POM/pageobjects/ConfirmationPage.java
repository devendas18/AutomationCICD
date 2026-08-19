package POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DevendraTest.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	//168
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);  //  to use the driver code in child`		
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);      //this refers to current class driver			
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public  String getConfirmationMessage() {
		return confirmationMessage.getText();
		
	}


}
