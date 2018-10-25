package com.qa.VetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewOwner {
@FindBy (id="firstName")
private WebElement firstName;
@FindBy (id="lastName")
private WebElement lastName;
@FindBy (id="address")
private WebElement address;
@FindBy (id="city")
private WebElement city;
@FindBy (id="telephone")
private WebElement telephone;
@FindBy (xpath="/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
private WebElement submitBtn;

public void fullForm(String arg0,String arg1,String arg2,String arg3,String arg4) {
	firstName.clear();
	firstName.sendKeys(arg0);
	lastName.clear();
	lastName.sendKeys(arg1);
	address.clear();
	address.sendKeys(arg2);
	city.clear();
	city.sendKeys(arg3);
	telephone.clear();
	telephone.sendKeys(arg4);
}
public void submit() {
	submitBtn.click();
}
}
