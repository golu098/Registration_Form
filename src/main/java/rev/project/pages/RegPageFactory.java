package rev.project.pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import rev.project.utils.ConfigUtils;

public class RegPageFactory {
    WebDriver driver;

    // Constructor to initialize WebDriver and elements
    public RegPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the First Name and Last Name fields
    @FindBy(xpath = "//input[@name='name']")
    private WebElement firstNameLocator;

    @FindBy(xpath = "//label[text()='Last Name:']/following-sibling::input")
    private WebElement lastNameLocator;

    @FindBy(xpath = "//label[text()=\" Single\"]")
    private WebElement singleRadioButton;

    @FindBy(xpath = "//label[text()=\" Married\"]")
    private WebElement marriedRadioButton;

    @FindBy(xpath = "//label[text()=\" Divorced\"]")
    private WebElement divorcedRadioButton;

    @FindBy(xpath = "//label[text()=\" Dance\"]")
    private  WebElement danceHobby;

    @FindBy(xpath = "//label[text()=\" Reading\"]")
    private WebElement readingHobby;

    @FindBy(xpath = "//label[text()=\" Cricket\"]")
    private WebElement cricketHobby;

    @FindBy(xpath = "//option[text()=\"India\"][1]//parent::select[1]")
    private WebElement countryDropdown;

    @FindBy(xpath = "//option[text()=\"Month\"][1]//parent::select[1]")
    private WebElement monthDropDown;

    @FindBy(xpath = "//option[text()=\"Day\"][1]//parent::select")
    private WebElement dayDropDown;

    @FindBy(xpath = "//option[text()=\"Year\"][1]//parent::select")
    private WebElement yearDropDown;

    @FindBy(xpath = "//label[text()='Phone Number:']/following-sibling::input")
    private WebElement phoneNo;

    @FindBy(xpath = "//label[text()='Username:']/following-sibling::input[1]")
    private WebElement userName;

    @FindBy(xpath = "//label[text()='E-mail:']/following-sibling::input")
    private  WebElement emailPath;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUpload;

    @FindBy(xpath = "//input[@type='password'][1]")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit'][1]")
    private WebElement submitButton;

    @FindBy(xpath = "//label[text()='This field is required.']")
    private WebElement errorMessages;



    // Method to navigate to the Registration Page
    public void navigateToRegPage() {
        String url = ConfigUtils.accessUrl("registrationPage.url");
        driver.get(url);
    }

    // Method to fill the First Name field
    public void fillFirstName(String firstName) {
        firstNameLocator.clear(); // Clear the input field before entering text
        firstNameLocator.sendKeys(firstName); // Enter the First Name
    }

    // Method to fill the Last Name field
    public void fillLastName(String lastName) {
        lastNameLocator.clear(); // Clear the input field before entering text
        lastNameLocator.sendKeys(lastName); // Enter the Last Name
    }

    public void selectMaritalStatus(String status) {
        switch (status) {
            case "Single":
                singleRadioButton.click();
                break;
            case "Married":
                marriedRadioButton.click();
                break;
            case "Divorced":
                divorcedRadioButton.click();
                break;
            default:
                System.out.println("All passed : " + status); // Logging for debugging

        }
    }


    public void selectHobby(String hobby) {
        switch(hobby){
            case "Dance":
                danceHobby.click();
                break;
            case "Reading":
                readingHobby.click();
                break;
            case "Cricket":
                cricketHobby.click();
                break;
            default:
                System.out.println("All hobby slected ");
//                throw new IllegalArgumentException("Not valid hooby");
        }
    }

    public void clickOnCountryDropDown() {
        countryDropdown.click();
    }

    public void selectCountryFromDropdown() {
        Select select=new Select(countryDropdown);
        select.selectByVisibleText("India");
        select.selectByIndex(1);
        select.selectByValue("India");
    }
    // Method to fill the Phone Number field
    public void fillPhoneNumber(String phoneNumber) {
        phoneNo.clear(); // Clear the field before entering new data
        phoneNo.sendKeys(phoneNumber); // Enter the phone number
    }

    // Method to fill the Email field
    public void fillEmail(String email) {
        emailPath.clear(); // Clear the field before entering new data
        emailPath.sendKeys(email); // Enter the email
    }

    // Method to fill the Password field
    public void fillPassword(String passwordValue) {
        password.clear(); // Clear the field before entering new data
        password.sendKeys(passwordValue); // Enter the password
    }

    // Method to upload a file
    public void uploadFile(String filePath) {
        fileUpload.sendKeys(filePath); // Upload the file using the file path
    }

}
