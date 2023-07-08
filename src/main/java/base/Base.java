package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	static {

		try {
			FileInputStream file = new FileInputStream("TestData/Testdata.properties");
			prop = new Properties();
			prop.load(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Actionclass(WebElement ele, String value) {

		Actions A = new Actions(driver);
		A.moveToElement(ele).build().perform();
		A.click(ele).build().perform();
		A.doubleClick().build().perform();
		A.sendKeys(value);
	}

	public void Executerclick(WebElement Ele) {
		JavascriptExecutor jsclick = (JavascriptExecutor) driver;
		jsclick.executeScript("arguments[0].click();", Ele);

	}

	public void SelectByVisibletext(WebElement Ele, String Value) {
		Select S = new Select(Ele);
		S.selectByVisibleText(Value);
	}

	public void SelectByVisiblIndex(WebElement Ele, int Value) {
		Select S = new Select(Ele);
		S.selectByIndex(Value);
	}

	public void waitforexpectedelement(WebElement ele, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitforElementClickable(WebElement ele, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void select_jspopup(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void GetScreenShot(Scenario Scenario) {
		TakesScreenshot Ts = (TakesScreenshot) driver;
		File scrFile = Ts.getScreenshotAs(OutputType.FILE);
		String SenarioName = Scenario.getName();
		System.out.println(SenarioName);
		String ScreenShotName = SenarioName.replaceAll("[^a-zA-Z0-9]", "_");
		try {
			FileUtils.copyFile(scrFile, new File("Screenshots/" + ScreenShotName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void validation(boolean B, WebElement Ele) {
		assert (Ele.isDisplayed());
	}

	public void Validation_by_Visible_Text(String Actualtext, String Expectedtext) {

		assert (Actualtext.equals(Expectedtext));
	}
}
