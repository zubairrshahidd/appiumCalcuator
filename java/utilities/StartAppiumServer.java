package utilities;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class StartAppiumServer {
	public static AppiumDriverLocalService service;
	
	public static String NodePath = "/usr/local/bin/node";
	public static String NodeJsMainPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
	public static String ServerAddress = "127.0.0.1";


	public static void StartServer() {

		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(NodePath))
				.withAppiumJS(new File(NodeJsMainPath))
				.withIPAddress(ServerAddress)
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
				.usingPort(4723).withLogFile(new File("/Users/ebricks/Documents/eBricks/testAutomation/ApiumServerLog.txt")));
		
		System.out.println("Starting Appium Server...");
		service.start();

		
	}

}
