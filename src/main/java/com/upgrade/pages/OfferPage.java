package com.upgrade.pages;

import com.upgrade.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class OfferPage extends BasePage {

    @FindBy(xpath = "//span[@data-auto ='userLoanAmount']")
    private WebElement loanAmount;
    @FindBy(xpath = "//span[@data-auto ='defaultMonthlyPayment']")
    private WebElement monthlyPaymentAmount;
    @FindBy(xpath = "//div[@data-auto ='defaultLoanTerm']")
    private WebElement defaultLoanTerm;
    @FindBy(xpath = "//div[@data-auto ='defaultMoreInfoAPR']")
    private WebElement defaultAPR;
    @FindBy(xpath = "//*[text()='Menu']")
    private WebElement menu;
    @FindBy(xpath = "//a[text()='Sign Out']")
    private WebElement signOut;
    @FindBy(xpath = "//button[text()='Select']")
    private WebElement selectButton;


    public OfferPage(WebDriver driver) {
        super(driver);
    }


    public boolean isInitialized() {
        return loanAmount.isDisplayed();
    }

    public String getLoanAmount() {
        return loanAmount.getText();

    }

    public String getMonthlyPaymentAmount() {
        return monthlyPaymentAmount.getText();

    }

    public String getdefaultLoanTerm() {
        return defaultLoanTerm.getText();

    }

    public String getdefaultAPR() {
        return defaultAPR.getText();

    }

    public void signOut() {
        waitSpinner();
        menu.click();
        signOut.click();
    }

}
