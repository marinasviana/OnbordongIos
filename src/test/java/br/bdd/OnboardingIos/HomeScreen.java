package br.bdd.OnboardingIos;


import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomeScreen {
	
	private AppiumDriver<MobileElement> driver;
	
	
	

	public HomeScreen(AppiumDriver<MobileElement> driver)  {
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	  }
	
	@iOSFindBy(xpath = "//*[@name=\"Geostorm\"]")
	public RemoteWebElement filmeName;
	
	public String filme() {
		
		return filmeName.getText();
	}

}
