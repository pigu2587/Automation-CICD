package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/java/cucumber", glue ="Section24_RahulshettyAcademy.StepDefination",
monochrome = true,tags = "@Regression", plugin= {"html:target/cucumber.html"})

public class TestNG_Cucumber extends AbstractTestNGCucumberTests {
	

}
