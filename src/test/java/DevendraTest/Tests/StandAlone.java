package DevendraTest.Tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class StandAlone {

	public static void main(String[] args) {
		//156-157-158
				//156

				String productName="ZARA COAT 3";  //added from session 159

				//WebDriverManager.edgedriver().setup(); not required now
				//WebDriver driver=new EdgeDriver();
				WebDriver driver=new ChromeDriver();	
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				
				driver.get("https://rahulshettyacademy.com/client");
				driver.findElement(By.id("userEmail")).sendKeys("ved18@gmail.com");
				driver.findElement(By.id("userPassword")).sendKeys("User@1234");
				driver.findElement(By.id("login")).click();
				
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5)); 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));  // wait till list load
				List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
			
				//157  - latest trend inplace - Stream
				WebElement prod= products.stream().filter(product->	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);      //changes from see 159 -"ZARA COAt 3"
				// stream will go and check for each item in the list
				// this code will check the first product and matches with text  
				
				
				prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();  //will add the product to cart
				
				//158  -waiting for items to load
				//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));     //pacing above
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
				//ng-animating should be invisible -waiting for loading icon
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); // performance issue
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));  
				driver.findElement(By.cssSelector("[routerlink*='cart']"));
				
				//159
				List <WebElement> cartProducts = driver.findElements(By.cssSelector("cartSection h3"));
				
				Boolean match= cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
				//Assert.assertTrue(match);
				Assert.assertFalse(match);
				driver.findElement(By.cssSelector(".totalRow button")).click();
				
				//160
				Actions a=new Actions(driver);
				a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
				
				//driver.findElement(By.xpath("//button[contains(@class,'ta-item')])[2]")).click(); not working so replaces with //button[@type='button'])[2] on 23/7/2026
				driver.findElement(By.xpath("//button[@type='button'])[2]")).click(); 
				//driver.findElement(By.cssSelector(".action_submit")).click(); not qorking so replaced ".btnn.action__submit" on23/7/26
				driver.findElement(By.cssSelector(".btnn.action__submit")).click();
				
				String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
				Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
				driver.close();
				
				System.out.println("Done");
		
		
		/*// TODO Auto-generated method stub
		
		//149-157
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		//WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("ved18@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("User@1234");
		driver.findElement(By.id("login")).click();
		
		//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3")); */
		

	}

}
