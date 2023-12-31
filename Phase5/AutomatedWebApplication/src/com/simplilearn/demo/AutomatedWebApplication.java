package com.simplilearn.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatedWebApplication {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:email\\:\\:content"));
		email.sendKeys("saptarshipaul63@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:password\\:\\:content"));
		password.sendKeys("Sanu@1234");
		Thread.sleep(1000);
		
		WebElement repassword = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:retypePassword\\:\\:content"));
		repassword.sendKeys("Sanu@1234");
		Thread.sleep(1000);
		
		WebElement country = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:country\\:\\:content"));
		country.sendKeys("India");
		
		WebElement firstname = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:firstName\\:\\:content"));
		firstname.sendKeys("Saptarshi");
		
		WebElement lastname = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:lastName\\:\\:content"));
		lastname.sendKeys("Paul");
		
		WebElement jobTitle = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:jobTitle\\:\\:content"));
		jobTitle.sendKeys("ASE");
		
		WebElement workPhone = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:workPhone\\:\\:content"));
		workPhone.sendKeys("9876543210");
		
		WebElement companyName = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:companyName\\:\\:content"));
		companyName.sendKeys("Mphasis");
		
		WebElement address = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:address1\\:\\:content"));
		address.sendKeys("Vill- Chaktarini, PO- Salboni, PS- Salboni, Dist- Paschim Medinipur");
		
		WebElement city = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:city\\:\\:content"));
		city.sendKeys("Medinipur");
		
		WebElement state = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:state\\:\\:content"));
		state.sendKeys("West Bengal");
		
		WebElement pinCode = driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:postalCode\\:\\:content"));
		pinCode.sendKeys("721147");
		
		Thread.sleep(1000);
		WebElement register= driver.findElement(By.cssSelector("#sView1\\:r1\\:0\\:b1"));
		register.click();
	}

}
