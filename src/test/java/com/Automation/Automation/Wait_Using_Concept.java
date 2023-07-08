package com.Automation.Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_Using_Concept {

	public static void main(String[] args) {

		// Implicit wait
		// Explicit wait

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.vuse.com/gb/en/create-account");
		driver.manage().window().maximize(); 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// wait for find element
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));// wait for page loading
		WebDriverWait Wait =new WebDriverWait(driver, Duration.ofSeconds(15)); //Explicit Wait for different conditions 
		// Visiblity of element.
		//webelement to be clickable
		// text to be present
		WebElement acpt = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		acpt.click();
	
		WebElement over18= driver.findElement(By.xpath("(//button[@class='button-root_highPriority-3u6 button-root-16x clickable-root-2gB'])[8]"));
		Wait.until(ExpectedConditions.elementToBeClickable(over18));
		over18.click();
		
		
	}

}
