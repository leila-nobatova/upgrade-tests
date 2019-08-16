package com.upgrade.pages;

import com.upgrade.BasePage;
import com.upgrade.users.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class CheckYourRatePage extends BasePage {
    @FindBy(xpath = "//input[@data-auto='borrowerFirstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@data-auto='borrowerLastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@name='borrowerStreet']")
    private WebElement streetAddress;
    @FindBy(xpath = "(//b[text()='111'])[1]")
    private WebElement firstSuggestion;
    @FindBy(xpath = "//input[@name='borrowerCity']")
    private WebElement city;
    @FindBy(xpath = "//input[@name='borrowerState']")
    private WebElement state;
    @FindBy(xpath = "//input[@name='borrowerZipCode']")
    private WebElement zipCode;
    @FindBy(xpath = "//input[@name='borrowerDateOfBirth']")
    private WebElement birthDate;
    @FindBy(xpath = "//input[@name='borrowerIncome']")
    private WebElement individualIncome;
    @FindBy(xpath = "//input[@name='borrowerAdditionalIncome']")
    private WebElement additionalIncome;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='agreements']")
    private WebElement termsCheckbox;
    @FindBy(xpath = "//button[@data-auto='submitPersonalInfo']")
    private WebElement checkYourRateButton;


    public CheckYourRatePage(WebDriver driver) {
        super(driver);
    }


    public void fillOutFormCheckYourRate() {
        firstName.clear();
        firstName.sendKeys("John");
        lastName.clear();
        lastName.sendKeys("Jones");
        streetAddress.clear();
        streetAddress.sendKeys("111 Main street");
        firstSuggestion.click();
        birthDate.clear();
        birthDate.sendKeys("02211975");
        individualIncome.clear();
        individualIncome.sendKeys("150000");
        additionalIncome.clear();
        additionalIncome.sendKeys("7000");
    }

    public OfferPage signUp(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        emailField.click();

        Actions act = new Actions(driver);
        act.moveToElement(termsCheckbox).click().build().perform();
        checkYourRateButton.click();
        return new OfferPage(driver);
    }


}
