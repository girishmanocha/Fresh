package step_Defination;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class Loginpage_StepDefination extends Base {

	LoginPage Login = new LoginPage();

	
	@When("User Enter valid Userid and Password")
	public void user_enter_valid_userid_and_password() {
		Login.user_enter_valid_userid_and_password();
	}

	@And("User click on Submit button")
	public void user_click_on_submit_button() {
		Login.user_click_on_submit_button();

	}

	@Then("Validate user Navigate to Home Page")
	public void validate_user_navigate_to_home_page() {
		Login.validate_user_navigate_to_home_page();
	}

	@Then("Validate user Should Get Error massege")
	public void validate_user_should_get_error_massege() {
		Login.validate_user_should_get_error_massege();
	}

	@When("User Enter Invalid {string} and {string}")
	public void user_enter_invalid_and(String UserName, String PassWord) {
		Login.user_enter_invalid_and(UserName, PassWord);
	}

}