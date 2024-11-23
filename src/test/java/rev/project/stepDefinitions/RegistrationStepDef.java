package rev.project.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import rev.project.hooks.Hooks;
import rev.project.pages.RegPageFactory;

import java.util.List;

public class RegistrationStepDef {
    WebDriver driver;
    RegPageFactory regPageFactory;

    // Constructor for Dependency Injection
    public RegistrationStepDef(Hooks driverHooks) {
        driver = driverHooks.getDriver();
        regPageFactory = new RegPageFactory(driver);
    }

    @Given("User is on the Registration Page")
    public void userIsOnRegistrationPage() {
        regPageFactory.navigateToRegPage(); // Navigate to Registration Page
    }

    @When("Fill {string} in First Name")
    public void fillFirstName(String firstName) {
        regPageFactory.fillFirstName(firstName); // Pass the dynamic parameter to fillFirstName
    }

    @When("Fill {string} in Last Name")
    public void fillLastName(String lastName) {
        regPageFactory.fillLastName(lastName); // Pass the dynamic parameter to fillLastName
    }

    @When("Click on the below Martial Status options")
    public void clickOnTheBelowOptions(DataTable dataTable) {
        // Extract the list of statuses from the DataTable
        List<String> statuses = dataTable.asList();

        // Iterate through each status and click the corresponding radio button
        for (String status : statuses) {
            regPageFactory.selectMaritalStatus(status); // Delegate to the Page Object
        }
    }

    @When("Click on the below hobby options")
    public void clickOnTheBelowHobbyOptions(DataTable dataTable) {
        List<String>hobbies=dataTable.asList();
        for(String hobby:hobbies){
            regPageFactory.selectHobby(hobby);
        }
    }
    @When("Click on the Country dropDown")
    public void clickOnCountryDropDown() {
        regPageFactory.clickOnCountryDropDown();
    }
    @And("Select the country from dropDown")
    public void selectTheCountryFromDropDown() {
        regPageFactory.selectCountryFromDropdown();
    }
    @When("Fill {string} in Phone Number")
    public void fillPhoneNumber(String phoneNumber) {
        regPageFactory.fillPhoneNumber(phoneNumber); // Pass the phone number to the page object
    }

    @When("Fill {string} in Email")
    public void fillEmail(String email) {
        regPageFactory.fillEmail(email); // Pass the email to the page object
    }

    @When("Fill {string} in Password")
    public void fillPassword(String passwordValue) {
        regPageFactory.fillPassword(passwordValue); // Pass the password to the page object
    }

    @And("Upload file {string}")
    public void uploadFile(String filePath) {
        regPageFactory.uploadFile(filePath); // Pass the file path to upload file
    }

}
