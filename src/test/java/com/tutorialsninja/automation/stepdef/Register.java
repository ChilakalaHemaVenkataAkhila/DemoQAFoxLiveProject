package com.tutorialsninja.automation.stepdef;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPageg;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register {
	
	RegisterPage rp=new RegisterPage();
	
	HeadersSection hs=new  HeadersSection();
	AccountSuccessPageg asp=new AccountSuccessPageg ();
	@Given("^I launch the application$")
	public void i_launch_the_application() {
		String url = Base.reader.getUrl();
		System.out.println("URL : " + url);
		Base.driver.get(url);
	}

	@And("^I navigate to Account Registration Page$")
	public void i_navigate_to_Account_Registration_Page() {
		
		Elements.click(HeadersSection.myAccountLink);
		Elements.click(HeadersSection.register);

	}

	@When("^I provide all the  below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable dataTable) {
	
		RegisterPage.enterAllDetails(dataTable,"unique");
		
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_Privacy_Policy() {
		Elements.click(RegisterPage.privacyPolicy);
	}
	
	

	@And("^I click on Continue Button$")
	public void i_click_on_Continue_Button() {
		Elements.click(RegisterPage.continueButton);
	}
	

	@Then("^I shuold see that the user account has successfully been created$")
	public void i_shuold_see_that_the_user_account_has_successfully_been_created() {
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPageg.successBreadcrumb));
		//Elements.isDisplayed(AccountSuccessPageg.successBreadcrumb);
	}
	

	@Then("^I should see that the User Account is not created$")
	public void i_should_see_that_the_User_Account_is_not_created()  {
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadcrumb));
	    
	}

	@Then("^I should see the error messages informing the user to fill the mandatory fields$")
	public void i_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields()  {
		
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstNameWarning));	
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastNameWarning));	
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailWarning));	
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephoneWarning));	
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordWarning));	
	Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainWarning));	
}
	@And("^I subscribe to Newsletter$")
	public void i_subscribe_to_Newsletter()  {
	   Elements.click(RegisterPage.yesToNewsletter);
	}
	@When("^I provide the  below duplicate details$")
	public void i_provide_the_below_duplicate_details(DataTable dataTable)  {
		RegisterPage.enterAllDetails(dataTable,"duplicate");
	}



	@Then("^I should see the warning message stating that the user is already created$")
	public void i_should_see_the_warning_message_stating_that_the_user_is_already_created()  {
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainWarning,"Warning: E-Mail Address is already registered!"));	
	}


}
