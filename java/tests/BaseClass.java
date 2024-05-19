package tests;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;


public class BaseClass extends CalculatorExtentReport{
//	AppiumDriver<MobileElement> driver; 
	File file;
	FileInputStream fip;
	Properties prop;

	public void initialConfig()
	{
		file=new File (System.getProperty("user.dir")+"/src/test/java/config/config.properties");
		try {
			fip= new FileInputStream(file);
			prop = new Properties();
			prop.load(fip);
		}catch(FileNotFoundException e){

			System.out.println("FileNotFoundException caught in initial config "+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String ReadProperty(String key) {

		return prop.getProperty(key);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getResultText(WebElement element) {
		return element.getText();
	}

	public void assertResult(String actualResultMesage,String actualResult,String expectedResultMessage,String expectedResult)
	{
		if (actualResult.equals(expectedResult)) {
			System.out.println("Assertion passed: "+actualResultMesage +" is equal to "+expectedResultMessage);
		} else {
			System.out.println("Assertion failed: "+actualResultMesage +" is not equal to "+expectedResultMessage);
		}
		assertEquals(actualResult,expectedResult);
	}

}