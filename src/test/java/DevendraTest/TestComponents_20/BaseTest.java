package DevendraTest.TestComponents_20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import POM.pageobjects.LandingPage;

public class BaseTest {
	//169
	
	public WebDriver driver;     //so it can be used in whole class,no need to declaore in every method
	public LandingPage landingPage;   //171
	
	public WebDriver initializeDriver() throws IOException{  //170 void to WebDriver
		//properties class
		
		Properties prop=new Properties();
		//FileInputStream fis=new FileInputStream("C://Users//surjan//eclipse-workspace//SeleniumFrameworkDesign1_Section18_19_20/src//src//main//java//POM//resources//GlobalData.properties");   //path fro GlobalData.properties
		//dynamic path for every system
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+("//src//main//java//POM//resources//GlobalData.properties"));  
		
		prop.load(fis);	
		//185 ternary operator added for maven command, it will pick maven parametsr or globaldata
		String browserName =System.getProperty("browser") !=null ? System.getProperty("browser") :prop.getProperty("browser");          //	185 added for maven commend 
		// String browserName=prop.getProperty("browser");              //getting from GlobalData.properties file //185 used in upper condition
		
		if (browserName.contains("chrome")) {						//188 changes to contains so it will chcek chrome or chromeheadless
			ChromeOptions options=new ChromeOptions();						//188	to run the tc without browser
		   																	//188
				if (browserName.contains("headless")) 							//188	
				{																
					options.addArguments("headless");  							//188	
				}	
				driver = new ChromeDriver(options); 					//188 added options
				driver.manage().window().setSize(new Dimension(1440,900));   //188 to open in maximized mode full scrren in headless mode (its optional)
				//driver.manage().window().setSize(new Dimension(1920,1080));
		}
		
		/*
		if (browserName.equalsIgnoreCase("chrome")) {												
				driver = new ChromeDriver(); 							
		} */
		
		else if(browserName.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver","edge.exe");
		driver=new EdgeDriver();		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
		driver=new FirefoxDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;  //170
			
	}
	
	//177
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		//read json to string
		//String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//main//java//DevendraTest//data//PurchaseOrder.json"),StandardCharsets.UTF_8);
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);  // to make it generic getting data from class and chnages it to filepath
		
		//string to HashMap jackson databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		//{map}{map} it will convert to map & 2 map as purchaseorder json has 2 datasets
		
	}
	
	
	//178 moved here in 181
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {  //181 added WebDriver driver
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		//File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");"
		File file=new File(System.getProperty("user.dir") + "//reports//" + testCaseName +".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
	}

	
	
	@BeforeMethod (alwaysRun=true)  //171 //174
	//170
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		landingPage=new LandingPage(driver);   //171
		// LandingPage landingPage=new LandingPage(driver); removed in 171 and made it public so it can see in child class
		landingPage.goTo();
		return landingPage;
		
	}
	//171
	@AfterMethod (alwaysRun=true) //174 it will run in every group or tests
	public void tearDown() {
		driver.close();	
		//if (driver != null) {   //getting error in jenkins so added this 187
	       // driver.close();
	       // driver.quit();
	       // driver = null;
	    //}
		}

}
