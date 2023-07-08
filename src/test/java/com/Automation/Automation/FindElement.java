package com.Automation.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.vuse.com/gb/en/");
		driver.manage().window().maximize();
		
		
		
		
		WebElement searchfield  = driver.findElement(By.xpath("//input[@class='textInput-input-BvJ field-input-1he field-input-23y']"));
		searchfield.sendKeys("abcd");
		
		WebElement cartbtn  = driver.findElement(By.xpath("//input[@class='textInput-input-BvJ field-input-1he field-input-23y']"));
		cartbtn.submit();
		
		
		
	}

}
