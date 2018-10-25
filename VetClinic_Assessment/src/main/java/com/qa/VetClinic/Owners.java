package com.qa.VetClinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Owners {
	@FindBy (xpath="/html/body/app-root/app-owner-list/div/div/h2")
	private WebElement title;
	WebElement found;
	
	@FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement owners;

	@FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a")
	private WebElement addNewBtn;

	

	
	public String reTitle() {
		return title.getText();
	}	
	public void findUser(WebDriver driver, String username) {
	int count =driver.findElements(By.className("ownerFullName")).size();
	for (int a=1;a<count;a++) {
		WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr["+a+"]/td[1]/a"));
		String check = name.getText();
		if (check.contains(username)) {
			found = name;
			break;
		}
	}
}
	public void selectUser() {
		found.click();
	}
	
	public void selectID(WebDriver driver, String username) {
		driver.findElement(By.cssSelector("a[href='/petclinic/owners/"+username+"'")).click();
}
	public void createOwner() {
		owners.click();
		addNewBtn.click();
	}
	
}
