package br.bdd.OnboardingIos;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class TestIosHome {

	private static HomeScreen homeScreen;
	private static IOSDriver<MobileElement> iosDriver;
	private static org.openqa.selenium.Dimension size;
	
	@BeforeClass
	public static void setup() throws MalformedURLException {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("app",new File("apps/Team4Bootcamp.app"));
	  capabilities.setCapability("plataform", "MAC" );
	  capabilities.setCapability("plataformName", "ios" );
	  capabilities.setCapability("deviceName", "iPhone SE");
	  capabilities.setCapability("automationName" , "XCUITest");
	  iosDriver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
	  homeScreen = new HomeScreen(iosDriver);
	}
	
	@Test
    public void testVerticalScroll()throws Exception
    {
		 boolean isPresent = iosDriver.findElements(By.xpath("//*[@name=\"Geostorm\"]")).size() > 0;
		 boolean teste = iosDriver.findElements(By.name("Geostorm")).size() > 0;
		 
		 int count = 1;
		 while(!isPresent) {
			 
			 if (teste) {
				    
				 	isPresent = iosDriver.findElements(By.xpath("//*[@name=\"Geostorm\"]")).size() > 0;
				 	System.out.println("entro aqui");
				 	
				 	System.out.println(iosDriver.findElement(By.xpath("//*[@name=\"Geostorm\"]")));
				 	
			    	RemoteWebElement element = (RemoteWebElement)iosDriver.findElement(By.xpath("//*[@name=\"Team4Bootcamp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]"));
				 	String parentID = element.getId();
				 	HashMap<String, String> scrollObject = new HashMap<String, String>();
				 	scrollObject.put("element", parentID);
				 	scrollObject.put("name", "Geostorm");
				 	
				 	iosDriver.executeScript("mobile:scroll", scrollObject);
					
				 	iosDriver.findElement(By.xpath("//*[@name=\"Geostorm\"]")).click();
					
					Thread.sleep(50000);
					
			 }else {
			    	RemoteWebElement element = (RemoteWebElement)iosDriver.findElement(By.xpath("//*[@name=\"Team4Bootcamp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+ count +"]/XCUIElementTypeImage[1]"));
					String elementID = element.getId();
					HashMap<String, String> scrollObject = new HashMap<String, String>();
					scrollObject.put("element", elementID); // Only for ‘scroll in element’
					scrollObject.put("toVisible", "true");
					scrollObject.put("direction", "down");
					iosDriver.executeScript("mobile:scroll", scrollObject);
					teste = iosDriver.findElements(By.xpath("//*[@name=\"Geostorm\"]")).size() > 0;
					if (count >= 3) {
						count = 1;
					}else {
					count = count + 1;
					}
			    	 
			     }
		 }
		 
    }

    
    @AfterClass
    public static void testCaseTearDown()
    {
    	iosDriver.quit();
    }
	
	
}
