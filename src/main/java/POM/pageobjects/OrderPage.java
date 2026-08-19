package POM.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DevendraTest.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	//173
	WebDriver driver;
	
	@FindBy(css=".totalRow button")                 
	WebElement chcekoutEle; 
	//173
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsNames; 
	
	public OrderPage(WebDriver driver)
	{
		super(driver);  //  to use the driver code in child`		
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);      //this refers to current class driver			
	}
	
	public Boolean VerifyOrderDisplay(String productName) {      //it will chcek all the orerds and matches with ZARA COde 3
		Boolean match= productsNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
}
