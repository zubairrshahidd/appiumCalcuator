package tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import static org.testng.Assert.assertEquals;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.CalculatorPage;
import utilities.Constants;

public class CalculatorTesting extends BaseClass{

	AndroidDriver<MobileElement> driver; 
	CalculatorPage calculatorObject = new CalculatorPage();
	@BeforeTest
	public void setup() throws Exception
	{
		initialConfig();
		//		StartAppiumServer.StartServer();
		//		Runtime.getRuntime().exec("sudo appium --base-path=/wd/hub --log-level debug");
		System.out.println("Appium Server Started Successfully...........");
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
			caps.setCapability(MobileCapabilityType.UDID, ReadProperty("emulatorUDID"));
			//			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			URL url= new URL(Constants.LOCALHOST);
			driver = new AndroidDriver<MobileElement>(url,caps);
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
			boolean isAppInstalled = driver.isAppInstalled("com.google.android.calculator");
			if(isAppInstalled) {
				System.out.println("APK Already Installed");
//				driver.startActivity(new Activity("com.google.android.calculator", "com.android.calculator2.Calculator"));
				driver.startActivity(new Activity(ReadProperty("calculatorActivity"),ReadProperty("calculatorPackage")));

			} else {
				System.out.println("installing APK");
				driver.installApp(System.getProperty("user.dir")+"/calculatorApp/Calculator.apk");
				try {
					driver.startActivity(new Activity(ReadProperty("calculatorActivity"),ReadProperty("calculatorPackage")));
				} catch (Exception e){
				}
			}
		} catch (Exception exp ) {
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is :"+exp.getMessage());
			exp.printStackTrace();
		} 
	}

	@AfterAll
	public void teardown() {

		//		driver.quit();
		driver.closeApp() ;
		//		driver.close();
	}

	@Test
	public void testAddition() throws InterruptedException {
		ExtentTest test = extent.createTest("Addition Test", "Addition of 2 integers");
		test.log(Status.INFO, "Addition Test Initiated");
		clickElement(driver.findElementById(ReadProperty("7Digit")));
		clickElement(driver.findElementById(ReadProperty("add")));
		clickElement(driver.findElementById(ReadProperty("5Digit")));
		String previewText = getResultText(driver.findElementById(ReadProperty("previewResult")));
		clickElement(driver.findElementById(ReadProperty("equal"))); 
		String actualCalculatorResult =getResultText(driver.findElementById(ReadProperty("finalResult")));
		test.log(Status.PASS, "Integers added successfully within Calculator App");
		assertEquals(actualCalculatorResult,previewText);
		//		Arithmetic calculation
		test.log(Status.INFO, "Arithmetic addition process initiated");
		int calculatedSum = calculatorObject.addIntegers(Constants.DIGIT_SEVEN, Constants.DIGIT_FIVE);
		String calculatedAdditionResult = String.valueOf(calculatedSum);
		test.log(Status.PASS, "Addition calculated successfully");
		assertResult("actualCalculatorResult",actualCalculatorResult,"calculatedAdditionResult",calculatedAdditionResult);
		test.log(Status.PASS, "Calculator addition result is similar to the arithmetic method");
	}

	@Test
	public void testSubstraction() {
		ExtentTest test = extent.createTest("Substraction Test", "Substraction of 2 integers");
		test.log(Status.INFO, "Substraction Test Initiated");
		clickElement(driver.findElementById(ReadProperty("9Digit")));
		clickElement(driver.findElementById(ReadProperty("subtract")));
		clickElement(driver.findElementById(ReadProperty("5Digit")));
		String previewText = getResultText(driver.findElementById(ReadProperty("previewResult")));
		clickElement(driver.findElementById(ReadProperty("equal"))); 
		String actualCalculatorResult =getResultText(driver.findElementById(ReadProperty("finalResult")));
		test.log(Status.PASS, "Integers substracted successfully within Calculator App");
		assertEquals(actualCalculatorResult,previewText);
		//		Arithmetic calculation
		test.log(Status.INFO, "Arithmetic substraction process initiated");
		int calculatedSubstraction = calculatorObject.subtractIntegers(9, 5);
		String calculatedSubstractionResult = String.valueOf(calculatedSubstraction);
		test.log(Status.PASS, "Substraction calculated successfully");
		assertResult("actualCalculatorResult",actualCalculatorResult,"calculatedSubstractionResult",calculatedSubstractionResult);
		test.log(Status.PASS, "Calculator substraction result is similar to the arithmetic method");
	}

	@Test
	public void testMultiplication() {
		ExtentTest test = extent.createTest("Multiply Test", "Multiplication of 2 integers");
		test.log(Status.INFO, "Multiply Test Initiated");
		clickElement(driver.findElementById(ReadProperty("4Digit")));
		clickElement(driver.findElementById(ReadProperty("multiply")));
		clickElement(driver.findElementById(ReadProperty("5Digit")));
		String previewText = getResultText(driver.findElementById(ReadProperty("previewResult")));
		clickElement(driver.findElementById(ReadProperty("equal"))); 
		String actualCalculatorResult =getResultText(driver.findElementById(ReadProperty("finalResult")));
		test.log(Status.PASS, "Integers Multiplied successfully within Calculator App");
		assertEquals(actualCalculatorResult,previewText);
		//		Arithmetic calculation
		test.log(Status.INFO, "Arithmetic Multiplication process initiated");
		int calculatedMultiplication = calculatorObject.multiplyIntegers(4, 5);
		String calculatedMultiplicationResult = String.valueOf(calculatedMultiplication);
		test.log(Status.PASS, "Multiplication calculated successfully");
		assertResult("actualCalculatorResult",actualCalculatorResult,"calculatedMultiplicationResult",calculatedMultiplicationResult);
		test.log(Status.PASS, "Calculator Multiplication result is similar to the arithmetic method");
	}

	@Test
	public void testDivision() {
		ExtentTest test = extent.createTest("Division Test", "Division of 2 integers");
		test.log(Status.INFO, "Division Test Initiated");
		clickElement(driver.findElementById(ReadProperty("8Digit")));
		clickElement(driver.findElementById(ReadProperty("divide")));
		clickElement(driver.findElementById(ReadProperty("4Digit")));
		String previewText = getResultText(driver.findElementById(ReadProperty("previewResult")));
		clickElement(driver.findElementById(ReadProperty("equal"))); 
		String actualCalculatorResult =getResultText(driver.findElementById(ReadProperty("finalResult")));
		test.log(Status.PASS, "Integers divided successfully within Calculator App");
		assertEquals(actualCalculatorResult,previewText);
		//		Arithmetic calculation
		test.log(Status.INFO, "Arithmetic division process initiated");
		int calculatedDivision = calculatorObject.divideIntegers(8, 4);
		String calculatedDivisionResult = String.valueOf(calculatedDivision);
		test.log(Status.PASS, "Division calculated successfully");
		assertResult("actualCalculatorResult",actualCalculatorResult,"calculatedDivisionResult",calculatedDivisionResult);
		test.log(Status.PASS, "Calculator division result is similar to the arithmetic method");
	}
}
