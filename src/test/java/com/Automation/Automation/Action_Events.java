package com.Automation.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_Events {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://learn-automation.com/");
		driver.manage().window().maximize();
	
		WebElement museover = driver.findElement(By.xpath("//a[@href=\'http://learn-automation.com\']"));
		WebElement clkcucumbr = driver.findElement(By.xpath("//li[@id='menu-item-3649']"));

		Actions A = new Actions(driver);

		A.moveToElement(museover);
		A.click(clkcucumbr).build().perform();

		// buld.perform used for perform last action
	}

}
