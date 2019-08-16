package com.upgrade.pages;

import com.upgrade.BasePage;
import com.upgrade.users.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@data-auto='login']")
    private WebElement submitButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public OfferPage login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
        return new OfferPage(driver);
    }
}
