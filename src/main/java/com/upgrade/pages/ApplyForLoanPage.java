package com.upgrade.pages;


import com.upgrade.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class ApplyForLoanPage extends BasePage {

    @FindBy(name = "desiredAmount")
    private WebElement loanAmount;
    @FindBy(xpath = "//select[@data-auto = 'dropLoanPurpose']")
    private WebElement loanPurposeDropDown;
    @FindBy(xpath = "//*[@value='SMALL_BUSINESS']")
    private WebElement loanPurposeBusiness;
    @FindBy(xpath = "//button[@data-auto='CheckYourRate']")
    private WebElement checkYourRateButton;
    @FindBy(xpath = "//h2[text()='Apply for a personal loan.']")
    private WebElement header;

    public ApplyForLoanPage(WebDriver driver) {
        super(driver);
    }

    public CheckYourRatePage applyLoanForBusiness() throws InterruptedException {
        loanAmount.click();
        loanAmount.sendKeys("2000");
        loanPurposeDropDown.click();
        loanPurposeBusiness.click();
        checkYourRateButton.click();
        return new CheckYourRatePage(driver);
    }

}
