package com.Automation.Automation;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.vuse.com/gb/en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement Acptcoockies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		JavascriptExecutor jsclick = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Acptcoockies));
		try {
			Acptcoockies.click();
		} catch (Exception e) {
			jsclick.executeScript("arguments[0].click();", Acptcoockies);
		}

		WebElement over18 = driver.findElement(
				By.xpath("(//button[@class='button-root_highPriority-3u6 button-root-16x clickable-root-2gB'])[17]"));
		wait.until(ExpectedConditions.elementToBeClickable(over18));
		try {
			over18.click();
		} catch (Exception e) {
			jsclick.executeScript("arguments[0].click();", over18);
		}

		driver.findElement(By.xpath("//button[@aria-label='Toggle My Account Menu']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys("girish6987@yopmail.com");
		driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Acd@12345");
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		try {
			submit.click();

		} catch (Exception e) {
			jsclick.executeScript("arguments[0].click();", submit);
		}

		WebElement errror = driver.findElement(By.xpath("//span[@class='errorMessage-errorMessage-3sE']"));
		wait.until(ExpectedConditions.elementToBeClickable(errror));
		 

			assertTrue(errror.isDisplayed());
			TakesScreenshot Ts = (TakesScreenshot) driver;
			File scrFile = Ts.getScreenshotAs(OutputType.FILE);
			String ScreenShotName = "validate User Should not log in";

			try {
				FileUtils.copyFile(scrFile, new File("Screenshots/" + ScreenShotName + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		

		driver.quit();

	}
}
