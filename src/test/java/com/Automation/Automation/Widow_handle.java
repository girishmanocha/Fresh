package com.Automation.Automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Widow_handle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
				
		String parentwindowid = driver.getWindowHandle();
		System.out.println(parentwindowid);
		
		WebElement button1 = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		button1.click();
		
		Set<String> childwindows= driver.getWindowHandles(); 
		//getwindowhandles capture all (parent + child window id )
		 
		for (String window:childwindows ) {
			if (!parentwindowid.equals(window)) {
			driver.switchTo().window(window).manage().window().maximize();
								
			}
		}
		
		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstname.sendKeys("Girish");
		Thread.sleep(3000);
		
		driver.close();
		driver.switchTo().window(parentwindowid);
		
		Thread.sleep(3000);
		driver.close();
	}
}




