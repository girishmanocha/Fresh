package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class Hooks extends Base {

	@Before
	public void launchBrowser() {
		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("Url")); 

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("Url"));

		} else if (browserName.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
			driver = (WebDriver) new OperaDriverManager();
			driver.get(prop.getProperty("Url"));

		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("Url"));

		} else if (browserName.equalsIgnoreCase("Internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(prop.getProperty("Url"));

		} else {
			System.out.println("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement Acptcoockies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		waitforElementClickable(Acptcoockies, 10);
		try {
			Acptcoockies.click();
		} catch (Exception e) {
			Executerclick(Acptcoockies);
		}

		WebElement over18 = driver.findElement(
				By.xpath("(//button[@class='button-root_highPriority-3u6 button-root-16x clickable-root-2gB'])[16]"));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		try {
			over18.click();
		} catch (Exception e) {
			Executerclick(over18);
		}

	}

	@After
	public void TearsDown(Scenario S) {
		if (S.isFailed()) {
			GetScreenShot(S);
		}

		driver.quit();
	}

}
