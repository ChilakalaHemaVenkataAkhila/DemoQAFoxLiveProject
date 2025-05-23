package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
//import com.example.utils.Elements;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import cucumber.api.DataTable;

public class RegisterPage {

	public RegisterPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(id = "input-firstname")
	public static WebElement firstname;

	@FindBy(id = "input-lastname")
	public static WebElement lastname;

	@FindBy(id = "input-email")
	public static WebElement email;

	@FindBy(id = "input-telephone")
	public static WebElement telephone;

	@FindBy(id = "input-password")
	public static WebElement password;

	@FindBy(id = "input-confirm")
	public static WebElement confirmPassword;

	@FindBy(name = "agree")
	public static WebElement privacyPolicy;

	@FindBy(css = "input[type='submit'][value='Continue']")
	public static WebElement continueButton;

	@FindBy(linkText = "Register")
	public static WebElement registerBreadcrumb;

	@FindBy(css = "input[id='input-firstname']+div")
	public static WebElement firstNameWarning;

	@FindBy(css = "input[id='input-lastname']+div")
	public static WebElement lastNameWarning;

	@FindBy(css = "input[id='input-email']+div")
	public static WebElement emailWarning;

	@FindBy(css = "input[id='input-telephone']+div")
	public static WebElement telephoneWarning;

	@FindBy(css = "input[id='input-password']+div")
	public static WebElement passwordWarning;

	 @FindBy(xpath="//div[@class='container']//div[contains(@class, 'alert alert-danger alert-dismissible')]")
	// @FindBy(xpath="*[@id='account-register']/div[1]")
	// css="div.alert-dismissible"
	// .alert.alert-danger.alert-dismissible
	public static WebElement mainWarning;

	public static void enterAllDetails(DataTable dataTable, String detailsType) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Elements.TypeText(RegisterPage.firstname, map.get("FirstName"));
		Elements.TypeText(RegisterPage.lastname, map.get("LastName"));
		//Elements.TypeText(RegisterPage.email, System.currentTimeMillis()+ map.get("Email"));
		Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		Elements.TypeText(RegisterPage.password, map.get("Password"));

		Elements.TypeText(RegisterPage.confirmPassword, map.get("Password"));
	if (detailsType.equalsIgnoreCase("duplicate"))
		Elements.TypeText(RegisterPage.email, map.get("Email"));
	else
		Elements.TypeText(RegisterPage.email, System.currentTimeMillis() + map.get("Email"));

		// two reuse in single method if duplicate means only mail step execue or else
		// timestamp for not duplicate
	}

	@FindBy(css = "input[name='newsletter'][value='1']")
	public static WebElement yesToNewsletter;

}
