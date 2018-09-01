package com.automationtestcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class AutomationPratciceTestCases{


	WebDriver driver;

	public void setNewUserData(NewUserBean bean) {

		bean.setEmail(RandomStringUtils.randomAlphanumeric(5)+"@mailinator.com");
		bean.setFirstName("Manoj");
		bean.setLastName("Manoj");
		bean.setPassword("Password@123");
		bean.setState("5");
		bean.setZipCode("11111");
		bean.setCity("Hyderabad");
		bean.setPhoneNumber("1111111111");
		bean.setAlias("Manoj");
		bean.setAddress("Manoj");
	}


	public void createNewUser(NewUserBean bean) throws InterruptedException {
		driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();

		driver.findElement(By.id("email_create")).sendKeys(bean.getEmail());

		driver.findElement(By.id("SubmitCreate")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("id_gender1")).click();

		driver.findElement(By.id("customer_firstname")).sendKeys(bean.getFirstName());

		driver.findElement(By.id("customer_lastname")).sendKeys(bean.getLastName());

		driver.findElement(By.id("passwd")).sendKeys(bean.getPassword());

		driver.findElement(By.id("address1")).sendKeys(bean.getAddress());

		driver.findElement(By.id("city")).sendKeys(bean.getCity());

		new Select(driver.findElement(By.id("id_state"))).selectByValue(bean.getState());

		driver.findElement(By.id("postcode")).sendKeys(bean.getZipCode());

		driver.findElement(By.id("phone_mobile")).sendKeys(bean.getPhoneNumber());

		driver.findElement(By.id("alias")).sendKeys(bean.getAlias());

	}


//	@Test
	public void createAccountTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\LatestChrome\\chromedriver.exe");

		NewUserBean bean=new NewUserBean();

		setNewUserData(bean);
		driver=new ChromeDriver();
		String url="http://automationpractice.com";
		driver.get(url);
		createNewUser(bean);

		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(4000);
		String actualtext=driver.findElement(By.xpath("//*[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")).getText();
		Assert.assertTrue(actualtext.contains("Welcome to"));
	}


	//@Test
	public void editAccountTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\LatestChrome\\chromedriver.exe");

		NewUserBean bean=new NewUserBean();

		setNewUserData(bean);
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com");

		createNewUser(bean);

		driver.findElement(By.id("submitAccount")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[text()='My personal information']")).click();

		driver.findElement(By.id("firstname")).clear();

		driver.findElement(By.id("firstname")).sendKeys("Hilarious Test");

		driver.findElement(By.id("lastname")).clear();

		driver.findElement(By.id("lastname")).sendKeys("Chinnu");

		new Select(driver.findElement(By.id("months"))).selectByValue("6");

		driver.findElement(By.id("old_passwd")).sendKeys("Heman2000");

		driver.findElement(By.xpath("//*[text()='Save']")).click();

		Thread.sleep(5000);

		String expectedText="Your personal information has been successfully updated.";

		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Your personal information has been successfully updated.')]")).getText(), expectedText);

		driver.quit();
	}

	
	
	@Test
	public void createWishList() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\LatestChrome\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
		driver.get("http://automationpractice.com/index.php");
		
		
		NewUserBean bean=new NewUserBean();
		
		setNewUserData(bean);
		
		createNewUser(bean);
		driver.findElement(By.id("submitAccount")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@title='My wishlists']")).click();
		
		driver.findElement(By.id("name")).sendKeys("testing");
	}

}
