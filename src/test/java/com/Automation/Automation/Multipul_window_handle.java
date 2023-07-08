package com.Automation.Automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multipul_window_handle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();

		WebElement button2 = driver.findElement(By.xpath("//button[@id='newWindowsBtn']"));
		button2.click();

		String parentwindowid = driver.getWindowHandle();
		Set<String> childwindows = driver.getWindowHandles();

		for (String window : childwindows) {
			System.out.println(window);
			if (!parentwindowid.equals(window)) {
				driver.switchTo().window(window).manage().window().maximize();

				String pagetitle = driver.getTitle();
				if (pagetitle.contains("Basic Controls")) {
					WebElement inptfstnme = driver.findElement(By.xpath("//input[@id='firstName']"));
					inptfstnme.sendKeys("Girish");
					Thread.sleep(5000);
					driver.close();
					break;
				
				}
				
			}
			

		}

	}

}
