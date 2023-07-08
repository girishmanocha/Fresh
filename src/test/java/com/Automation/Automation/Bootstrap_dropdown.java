package com.Automation.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("	http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().window().maximize();
		
		WebElement botstrp = driver.findElement(By.xpath("//button[@id='menu1']"));
		botstrp.click();
		List<WebElement>dropdwnlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
		int size = dropdwnlist.size();
		System.out.println(size); 
		//Loop --for each
		for(WebElement ele: dropdwnlist) {
			String value = ele.getText();	
			if (value.equals("JavaScript")) {
				Thread.sleep(3000);
				ele.click();
				break;
			} 
			 
		}
		
	}
 
}
