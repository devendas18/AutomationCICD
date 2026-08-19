package POM.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DevendraTest.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	//167
	WebDriver driver;
	
	@FindBy(css=".totalRow button")                 
	WebElement chcekoutEle; 
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts; 
	
	public CartPage(WebDriver driver)
	{
		super(driver);  //  to use the driver code in child`		
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);      //this refers to current class driver			
	}
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match= cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckOutPage goToCheckout() {
		chcekoutEle.click();
		return new CheckOutPage(driver);
		
	}

}
