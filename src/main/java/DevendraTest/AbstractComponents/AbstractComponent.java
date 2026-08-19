package DevendraTest.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.pageobjects.CartPage;
import POM.pageobjects.OrderPage;

public class AbstractComponent  {
	
	//164
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {  //used super in parent landing page 
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this); //167
	}

	//167
	@FindBy(css="[routerlink*='cart']")                 //
	WebElement cartHeader; 
	//173
	@FindBy(css="[routerlink*='myorders']")                 //
	WebElement orderHeader; 
	
	//165
	public void waitForElementToAppear(By FindBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5)); //to fix the driver issue need to add cconstructor so can use the code from parent (kanding page)
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));		
	}
	
	//171
	public void waitForWebElementToAppear(WebElement FindBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.visibilityOf(FindBy));		
	}
	
	
	//167
	public CartPage goTocartPage() {  //return type to cartPage
		cartHeader.click();
		CartPage cartPage=new CartPage(driver); //167
		return cartPage;
	}
	
	//173
	public OrderPage goToOrdersPage() {  //return type to cartPage
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver); //167
		return orderPage;
	}
	
	//165
	public void waitForElementToDisappear (WebElement ele) throws InterruptedException { //driver used so need to use WebElement
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		//or 
		//166 - due to heavy load on this site use thread.sleep so it will not take time to load
		Thread.sleep(1000);	
		
	}
	

}
