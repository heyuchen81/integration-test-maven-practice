package com.ingenta.com.ingenta.integration_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenTests {

	@Test
	public void browserStack1() throws MalformedURLException, InterruptedException {
//      String USERNAME = "xinhe1";
//      String AUTOMATE_KEY = "myHB39JW5AqqzGMhAzzT";
		String USERNAME = System.getenv("USERNAME");
		String AUTOMATE_KEY = System.getenv("AUTOMATE_KEY");
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
      
		DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("browser", "IE");
//	    caps.setCapability("browser_version", "7.0");
//	    caps.setCapability("os", "Windows");
//	    caps.setCapability("os_version", "XP");
	    caps.setCapability("browserstack.debug", "true");
	    
	    caps.setCapability("browser", "Opera");
	    caps.setCapability("browser_version", "12.15");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "8.1");
	    caps.setCapability("resolution", "1366x768");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("Beijing Union University");
	    element.submit();
	    
	    
	    Thread.sleep(3000);

	    System.out.println(driver.getTitle());
	    Assert.assertTrue(driver.getTitle().contains("Ingenta"));
	    Thread.sleep(1000);
	    driver.quit();
	}
	
}
