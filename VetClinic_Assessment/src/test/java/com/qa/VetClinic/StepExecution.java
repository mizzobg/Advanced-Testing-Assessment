package com.qa.VetClinic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepExecution {
	
	public WebDriver driver =null;
	ExtentReports extent = new ExtentReports(Constants.Path_Reports+Constants.File_Report, false);
	ExtentTest test;
	
	@Before
	public void setup() {
	System.setProperty("webdriver.chrome.driver", Constants.Chrome_Driver);
	driver = new ChromeDriver();
	}
	@After
	public void tearDown() {
		driver.quit();			
		extent.endTest(test);
		extent.flush();	
	}
		
	
	@Given("^i search for all owners$")	//1
	public void i_search_for_all_owners() throws Throwable {
		test = extent.startTest("Search for all owners");
		test.log(LogStatus.INFO, "search for all owners");
		driver.get(Constants.webSource);
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.getOwnerOptions();
	}

	@When("^we get the all deatils$")
	public void we_get_the_all_deatils() throws Throwable {
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.viewAllOwners();
		test.log(LogStatus.INFO, "Select all owners menu");
	}

	@Then("^the correct page is loaded$")	//1
	public void the_correct_page_is_loaded() throws Throwable {
		Owners owners = PageFactory.initElements(driver, Owners.class);
		String title = owners.reTitle();
		if(title.contains(Constants.allUserTitle)) {
		test.log(LogStatus.PASS, "Loaded Successfuly");
		}
		else {
			test.log(LogStatus.FAIL, "Failed to load");
		}
		assertEquals("Is this all owners",Constants.allUserTitle,title);
	}

	@Given("^i search for the owner by last name$")	//2
	public void i_search_for_the_owner_by_last_name() throws Throwable {
		test = extent.startTest("Search for the owner by last name");
		test.log(LogStatus.INFO, "search for the owner by last name");
		driver.get(Constants.webSourceOwners);
		Owners owners = PageFactory.initElements(driver, Owners.class);
		owners.findUser(driver, "Davis");
		owners.selectUser();
	}

	@When("^we open their profile$")	//2,6
	public void we_open_their_profile() throws Throwable {
		//placeHolder action nothing done here
		test.log(LogStatus.INFO, "open their profile");
	}

	@Then("^verify their last name$")	//2
	public void verify_their_last_name() throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
//		assertEquals("Coleman", owner.reName());
		if(owner.reName().contains("Davis")) {
			test.log(LogStatus.PASS, "Found Successfuly");
			}
			else {
				test.log(LogStatus.FAIL, "Not Found");
			}
		Assert.assertTrue(owner.reName().contains("Davis"));
	}

	@Given("^i search for the owner by id$")	//3
	public void i_search_for_the_owner_by_id() throws Throwable {
		test = extent.startTest("Search for the owner by id");
		test.log(LogStatus.INFO, "Search for the owner by id 8");
		driver.get(Constants.webSourceOwners);
		Owners owners = PageFactory.initElements(driver, Owners.class);
		owners.selectID(driver, "8");
		
	    
	}
	@When("^we open the profile$")	//2
	public void we_open_the_profile() throws Throwable {
		//done in previous step
		test.log(LogStatus.INFO, "open their profile");
	}
	
	@When("^select edit owner$")	//3
	public void select_edit_owner() throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		owner.selectEdit();
		test.log(LogStatus.INFO, "Select the edit menu");
	}

	@When("^update their name$")//3
	public void update_their_name() throws Throwable {
		EditProfile edit = PageFactory.initElements(driver, EditProfile.class);
		edit.changeName("Josh");
		test.log(LogStatus.INFO, "Change their name");
	}

	@Then("^we save the changes$")//3
	public void we_save_the_changes() throws Throwable {
		EditProfile edit = PageFactory.initElements(driver, EditProfile.class);
		edit.saveChanges();
		test.log(LogStatus.PASS, "Profile Change Successful");
	}

	@Given("^a new owner needs to be added$")
	public void a_new_owner_needs_to_be_added() throws Throwable {
		test = extent.startTest("New owner needs to be added");
		test.log(LogStatus.INFO, "New owner button is pressed");
		driver.get(Constants.webSourceOwners);
		Owners owners = PageFactory.initElements(driver, Owners.class);
		owners.createOwner();
	}

	@When("^all parameters have been added correctly$")
	public void all_parameters_have_been_added_correctly() throws Throwable {
		CreateNewOwner owner = PageFactory.initElements(driver, CreateNewOwner.class);
		owner.fullForm("Joe","Smith","m502je","Manchester","0234512");
		test.log(LogStatus.INFO, "Profile inforamtion filled");
	}

	@Then("^we create the new owner$")
	public void we_create_the_new_owner() throws Throwable {
		CreateNewOwner owner = PageFactory.initElements(driver, CreateNewOwner.class);
		owner.submit();
		test.log(LogStatus.PASS, "New owner Created");
	}

	@Given("^an owner exists within the database$")
	public void an_owner_exists_within_the_database() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the admin deletes the owner with a specified id$")
	public void the_admin_deletes_the_owner_with_a_specified_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the user is removed from all owners$")
	public void the_user_is_removed_from_all_owners() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^i search for the owner by \"([^\"]*)\"$")
	public void i_search_for_the_owner_by(String arg1) throws Throwable {
		test = extent.startTest("i search for the owner by id : "+arg1);
		test.log(LogStatus.INFO, "Search started");
		driver.get(Constants.webSourceOwners);
		Owners owners = PageFactory.initElements(driver, Owners.class);
		owners.selectID(driver, arg1);
	}

	@Then("^verify their \"([^\"]*)\"$")
	public void verify_their(String arg1) throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
//		assertEquals("Coleman", owner.reName());
		if(owner.reName().contains(arg1)) {
			test.log(LogStatus.PASS, "Found Successfuly");
			}
			else {
				test.log(LogStatus.FAIL, "Not Found");
			}
		Assert.assertTrue(owner.reName().contains(arg1));
	}

}
