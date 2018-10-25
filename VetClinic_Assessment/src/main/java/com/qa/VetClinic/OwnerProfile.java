package com.qa.VetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerProfile {
	@FindBy (xpath="/html/body/app-root/app-owner-detail/div/div/table[1]/tbody/tr[1]/td/b")
	private WebElement fullName;
	@FindBy (xpath="/html/body/app-root/app-owner-detail/div/div/button[2]")
	private WebElement editBtn;
	public String reName() {
		return fullName.getText();
	}
	public void selectEdit() {
		editBtn.click();
	}
}
