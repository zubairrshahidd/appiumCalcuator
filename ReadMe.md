## Appium Automation (Calcuator.apk)

# Description
- Test script will install the APK in the selected device
- If the app is already installed then it will skip the installation and will launch the calculator app
- Calculation will be performed first using calculator app.
- Then Arithmetic operations will be performed by java script
- At the end, Calculator resulst will be matched with the Arithmetic results.

# Pre-requisite:

- Appium Server should be up and running
- Emulator with UDID “emulator-5554” should be up. Or you can change the emulator UDID in config.properties file.

# Runs:
- CalculatorTesting.java files contains the Tests. 
- You can run it using TestNG OR you can also run the testing.xml directly

# Report:
- output-calculator-html-report.html is generated at project root at the end of execution