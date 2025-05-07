package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class CheckoutPage {

	//to initialize this page we use constructor
	public CheckoutPage() {
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(id="button-payment-address")
	public static WebElement continueButtonofBillingDetailsSection;
	
	@FindBy(id="button-shipping-address")
	public static WebElement continueButtonofDeliveryDetailsSection;
	

	@FindBy(id="button-shipping-method")
	public static WebElement continueButtonofDeliveryMethodSection;
	
	
	@FindBy(name="agree")
	public static WebElement termsAndConditionsCheckbox;
	
	@FindBy(id="button-payment-method")
	public static WebElement continueButtonofPaymentMethodSection;
	
	@FindBy(id="button-confirm")
	public static WebElement confirmOrderButtonofCheckoutMethodSection;
	
	public static void placeAnOrder() {
		Elements.click(CheckoutPage.continueButtonofBillingDetailsSection);
		Elements.click(CheckoutPage.continueButtonofDeliveryDetailsSection);
		Elements.click(CheckoutPage.continueButtonofDeliveryMethodSection);
		
		Elements.click(CheckoutPage.termsAndConditionsCheckbox);
		Elements.click(CheckoutPage.continueButtonofPaymentMethodSection);
		Elements.click(CheckoutPage.confirmOrderButtonofCheckoutMethodSection);
		
		
	}
	
}
