package com.qa.VetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfile {
	@FindBy (id="firstName")
	private WebElement nameField;
	@FindBy (xpath="/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]")
	private WebElement sbmtBtn;
	
	public void changeName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
	}
	
	public void saveChanges() {
		sbmtBtn.click();
	}
//	public boolean sendState() {
//		return sbmtBtn.getAttribute(state);
//	}
}
