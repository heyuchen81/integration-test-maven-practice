package com.ingenta.com.ingenta.integration_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class MavenTests {

	@Test
	public void browserStack1() throws MalformedURLException {
//      String USERNAME = "xinhe1";
//      String AUTOMATE_KEY = "myHB39JW5AqqzGMhAzzT";
//		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		String URL = "https://$USERNAME:$AUTOMATE_KEY@hub.browserstack.com/wd/hub";
		
		DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("browser", "IE");
//	    caps.setCapability("browser_version", "7.0");
//	    caps.setCapability("os", "Windows");
//	    caps.setCapability("os_version", "XP");
	    caps.setCapability("browserstack.debug", "true");
	    
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "50.0");
	    caps.setCapability("os", "OS X");
	    caps.setCapability("os_version", "Mavericks");
	    caps.setCapability("resolution", "1920x1080");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("Xu Hui");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	}
	
}
