package step_Defination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.AddtoCart;

public class AddtoCart_StepDefination {

	AddtoCart Atc = new AddtoCart();

	@When("Go to Vape kits listing page")
	public void go_to_vape_kits_listing_page() {
		Atc.go_to_vape_kits_listing_page();
	}

	@When("Add Two Products in Basket")
	public void add_two_products_in_basket() {
		Atc.add_two_products_in_basket();
	}

	@When("Delete These Product")
	public void delete_these_product() {
		Atc.delete_these_product();
	}

	@Then("Validate There is no any product in basket")
	public void validate_there_is_no_any_product_in_basket() {
		Atc.validate_there_is_no_any_product_in_basket();
	}

	@When("Select a Product")
	public void select_a_product() {
		Atc.select_a_product();
	}

	@When("Add product from Product Discription Page")
	public void add_product_from_product_discription_page() {
		Atc.add_product_from_product_discription_page();
	}

	@Then("Validate Product Should be in The Basket")
	public void validate_product_should_be_in_the_basket() {
		Atc.validate_product_should_be_in_the_basket();
	}

}
