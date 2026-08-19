package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;     //need to import 


@CucumberOptions(features="src/test/java/cucumber",glue="SeleniumFramework.stepDefinitions_23",   //glue attribute used to define path of stepdef file
monochrome=true,tags="@Regression",          //200 tags will filter out can excute only with that tag name
plugin= {"html:target/cucumber.html"})                 //monochrome makws test result in readable format. format & path to save
public class TestNGTestRunner_23 extends AbstractTestNGCucumberTests {        //Inbuilt class AbstractTestNGCucumberTests to support testng in cucumber 

}
