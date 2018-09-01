package com.automationtestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WaitCommands {

	
	@Test
	public void tc_1() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\LatestChrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.google.co.in");
		
		driver.findElement(By.name("q")).isDisplayed();
		
		driver.findElement(By.name("q1")).sendKeys("selenium");
		
	}
}
