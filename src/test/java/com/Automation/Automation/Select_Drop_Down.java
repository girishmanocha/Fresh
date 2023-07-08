package com.Automation.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select_Drop_Down {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://seleniumbase.io/demo_page");
		driver.manage().window().maximize();

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='mySelect']"));
		
		//Select S = new Select();
		Select s = new Select(dropdown);
		//s.selectByValue("75%");
		//s.selectByVisibleText("Set to 50%");
		s.selectByIndex(3);
		
		WebElement green = driver.findElement(By.xpath("//button[@id='myButton']"));
		green.click();
		
		
	}
}
