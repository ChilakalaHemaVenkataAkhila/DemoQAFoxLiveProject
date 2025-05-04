package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class AccountSuccessPageg 
{
	public AccountSuccessPageg () {
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Success']")
public static WebElement successBreadcrumb;
}
//a[normalize-space()='Success']