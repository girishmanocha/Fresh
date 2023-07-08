package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class LoginPage extends Base {

	public void user_enter_valid_userid_and_password() {
		WebElement clkSign = driver.findElement(By.xpath("//button[@aria-label='Toggle My Account Menu']"));
		clkSign.click();
		WebElement username = driver.findElement(By.xpath("//input[@autocomplete='email']"));
		username.sendKeys(prop.getProperty("username"));
		WebElement password = driver.findElement(By.xpath("//input[@autocomplete='current-password']"));
		password.sendKeys(prop.getProperty("PASSWORD"));
	}

	public void user_click_on_submit_button() {
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		try {
			submit.click();

		} catch (Exception e) {
			Executerclick(submit);
		}

	}

	public void validate_user_navigate_to_home_page() {
		WebElement myaccout = driver.findElement(By.xpath("(//a[@class='accountMenuItems-link-2R1'])[1]"));
		validation(true, myaccout);
		Executerclick(myaccout);
		WebElement logout = driver.findElement(
				By.xpath("//a[@class='accountSidebarItems-sidebarLink-1fw accountSidebarItems-signOut-29r']"));
		try {
			logout.click();
		} catch (Exception e) {
			Executerclick(logout);
		}
		driver.quit();
	}

	public void validate_user_should_get_error_massege() {
		WebElement errror = driver.findElement(By.xpath("//span[@class='errorMessage-errorMessage-3sE']"));
		String errrortext = errror.getText();

		try {
			Validation_by_Visible_Text(errrortext,
					"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");

		} catch (Exception e) {
			validation(true, errror);
		}

		driver.quit();
	}

	public void user_enter_invalid_and(String UserName, String PassWord) {
		WebElement clkSign = driver.findElement(By.xpath("//button[@aria-label='Toggle My Account Menu']"));
		clkSign.click();
		WebElement username = driver.findElement(By.xpath("//input[@autocomplete='email']"));
		username.sendKeys(UserName);
		WebElement password = driver.findElement(By.xpath("//input[@autocomplete='current-password']"));
		password.sendKeys(PassWord);
	}
}
