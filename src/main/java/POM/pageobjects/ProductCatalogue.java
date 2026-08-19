package POM.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DevendraTest.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
		//163
		WebDriver driver;
		
		public ProductCatalogue(WebDriver driver)
		{
			super(driver);  // 164 to use the driver code in child
			
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);      //this refers to current class driver			
		}
		//163
		//List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		
		@FindBy(css=".mb-3")                 //
		List<WebElement> products;           //using list so it will find elements also
		//165
		@FindBy(css=".ng-animating")                 //
		WebElement spinner; 
		
		//164
		By ProductsBy=By.cssSelector(".mb-3");
		//165
		By addProductToCart=By.cssSelector(".card-body button:last-of-type");
		By toastMessage=By.cssSelector("#toast-container");
		
		public List<WebElement> getproductList() {
			
			waitForElementToAppear(ProductsBy);
			return products;		
		}
		
		//165
		public WebElement getProductByName(String productName)
		{
			WebElement prod= getproductList().stream().filter(product->										 //replaced products with getproductList()
			product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;      //return prod so need to change void to WebElement
		}
		
		public void addProductToCart(String productname) throws InterruptedException
		{
			WebElement prod=getProductByName(productname);
			prod.findElement(addProductToCart).click();
			waitForElementToAppear(toastMessage);
			waitForElementToDisappear(spinner);


		}




}
