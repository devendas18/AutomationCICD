package POM.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG_22 {
	//180
	public static ExtentReports getreportObject() {   //static so can be used without declaring the class, classname and extent
		
		//180
		String path=System.getProperty("user.dir")+"\\reports\\index.html";    
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);  
		reporter.config().setReportName("Web Automation result");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();			
		extent.attachReporter(reporter);  
		extent.setSystemInfo("Tester", "Dev");
		return extent;
		
	}
	

}
