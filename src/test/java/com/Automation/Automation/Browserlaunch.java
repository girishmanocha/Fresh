package com.Automation.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserlaunch {

	public static void main(String[] args) {
	
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.newlook.com/uk");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//a[@class='cookiebanner-btns--btn cookiebanner-btns--btn__accept']")).click();
	}

}
  