package com.Automation.Automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript_popUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//for accept Javapopup window
		
		WebElement java1 = driver.findElement(By.xpath("(//button[@onclick])[1]"));
		java1.click();
		Alert a = driver.switchTo().alert();
		a.accept(); 
		Thread.sleep(5000);
		
		//For cancel Javapopup window
		WebElement java2 = driver.findElement(By.xpath("(//button[@onclick])[2]"));
		java2.click(); 
		
		a.dismiss();
		
		Thread.sleep(5000);
		
		//For send inputData in Javapopup Text Window
		WebElement java3 = driver.findElement(By.xpath("(//button[@onclick])[3]"));
		java3.click();
		
		
		
		String S=a.getText();
		System.out.println(S);
		a.sendKeys("Girish");
		a.accept();
	}

}
