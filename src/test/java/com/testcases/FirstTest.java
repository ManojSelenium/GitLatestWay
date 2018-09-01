package com.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTest {



@Test
public void testCase1() throws InterruptedException {

	
	CreateUserBean bean=new CreateUserBean();
	
	
	bean.setEmailID(RandomStringUtils.randomAlphabetic(5)+"@mailinator.com");
	
	bean.setFirstName("Manoj");
	bean.setLastName("Testing");
	bean.setPassword("Manoj@123");
	bean.setState("5");
	
	System.setProperty("webdriver.chrome.driver","C:\\LatestChrome\\chromedriver.exe");


	WebDriver driver=new ChromeDriver();

	driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");


	driver.findElement(By.id("email_create")).sendKeys(bean.getEmailID());

	
	driver.findElement(By.id("SubmitCreate")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.id("firstname")).sendKeys(bean.getFirstName());
	driver.findElement(By.id("lastname")).sendKeys(bean.getLastName());
	
	driver.findElement(By.id("passwd")).sendKeys(bean.getPassword());
	
	
	new Select(driver.findElement(By.id("id_state"))).selectByValue(bean.getState());
}

	
	
//	@Test(dataProvider="setData")
	public void testCase(String userName,String password) {

		System.setProperty("webdriver.chrome.driver","C:\\LatestChrome\\chromedriver.exe");


		WebDriver driver=new ChromeDriver();

		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");


		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("passwd")).sendKeys(password);


	}


	@DataProvider
	public Object[] setData() {

		Object testData[][]=new Object[3][2];

		testData[0][0]="selenium1";
		testData[0][1]="password1";
		

		testData[1][0]="selenium2";
		testData[1][1]="password2";
		

		testData[2][0]="selenium3";
		testData[2][1]="password3";
		
		return testData;
	}
	
}
