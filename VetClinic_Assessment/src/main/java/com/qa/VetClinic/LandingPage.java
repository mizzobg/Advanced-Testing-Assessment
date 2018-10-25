package com.qa.VetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
@FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
private WebElement owners;

@FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
private WebElement view;


public void getOwnerOptions() {
	owners.click();
}
public void viewAllOwners() {
	view.click();
}

}
