package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class AddtoCart extends Base {

	public void go_to_vape_kits_listing_page() {
		WebElement vipekit = driver.findElement(By.xpath("(//a[@href='/gb/en/vape-kits'])[1]"));
		Executerclick(vipekit);
	}

	public void add_two_products_in_basket() {
		WebElement add1product = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/main/div[4]/article/section/div/div/div[2]/form/section[2]/div/div/button[2]"));
		add1product.click();
		WebElement clkaddtobasket = driver.findElement(
				By.xpath("//*[@id=\"root\"]/main/div[4]/article/section/div/div/div[2]/form/section[2]/button/span"));
		waitforElementClickable(clkaddtobasket, 15);

		try {
			clkaddtobasket.click();

		} catch (Exception e) {
			Executerclick(clkaddtobasket);
		}
		WebElement Add2product = driver.findElement(
				By.xpath("//*[@id=\"root\"]/main/div[4]/article/section/div/div/div[3]/form/section[2]/button"));
		try {
			Add2product.click();

		} catch (Exception e) {
			Executerclick(Add2product);
		}

	}

	public void delete_these_product() {
		WebElement CLKBASKETBUSKETBUTTON = driver
				.findElement(By.xpath("//*[@id=\"header-navBar\"]/div/div[2]/div[4]/button/span[1]"));
		CLKBASKETBUSKETBUTTON.click();
		waitforexpectedelement(CLKBASKETBUSKETBUTTON, 10);
		WebElement delete1product = driver.findElement(
				By.xpath("//*[@id=\"header-navBar\"]/div/div[2]/aside[2]/div/div[3]/div[1]/div[1]/button"));
		waitforElementClickable(delete1product, 10);
		delete1product.click();

		WebElement delete2product = driver.findElement(
				By.xpath("//*[@id=\"header-navBar\"]/div/div[2]/aside[2]/div/div[3]/div[1]/div[2]/button"));
		waitforElementClickable(delete2product, 10);
		delete2product.click();
	}

	public void validate_there_is_no_any_product_in_basket() {
		WebElement vuse = driver.findElement(By.xpath("//*[@id=\"header-navBar\"]/div/a/div/div/img[2]"));
		Executerclick(vuse);

		WebElement emptycrt = driver
				.findElement(By.xpath("(//button[@aria-label='Toggle mini cart. You have 0 items in your cart.'])[1]"));
		waitforexpectedelement(emptycrt, 15);
		validation(true, emptycrt);
		driver.quit();
	}

	public void select_a_product() {
		WebElement selctproduct = driver.findElement(
				By.xpath("//*[@id=\"root\"]/main/div[4]/article/section/div/div/div[1]/form/a/div/img[1]"));
		try {
			selctproduct.click();

		} catch (Exception e) {
			Executerclick(selctproduct);
		}

	}

	public void add_product_from_product_discription_page() {
		WebElement AddQty = driver
				.findElement(By.xpath("//*[@id=\"root\"]/main/div[4]/form/div[2]/section[1]/div/button[2]"));
		try {
			AddQty.click();
		} catch (Exception e) {
			Executerclick(AddQty);
		}

		WebElement addinbasket = driver
				.findElement(By.xpath("//*[@id=\"root\"]/main/div[4]/form/div[2]/section[2]/button"));
		try {
			Executerclick(addinbasket);
		} catch (Exception e) {
			// TODO: handle exception
		}
		addinbasket.click();
	}

	public void validate_product_should_be_in_the_basket() {
		WebElement CLKBASKETBUSKETBUTTON = driver
				.findElement(By.xpath("//*[@id=\"header-navBar\"]/div/div[2]/div[4]/button/span[1]"));
		waitforElementClickable(CLKBASKETBUSKETBUTTON, 15);
		Executerclick(CLKBASKETBUSKETBUTTON);

		WebElement verifyobject = driver
				.findElement(By.xpath("//*[@id=\"header-navBar\"]/div/div[2]/aside[2]/div/div[3]/div[1]/div[2]/a[2]"));
		validation(true, verifyobject);

		driver.quit();

	}

}
