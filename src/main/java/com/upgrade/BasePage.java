package com.upgrade;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentWait;

    @FindBy(xpath = "//div[@data-delay]")
    private WebElement spinner;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait = new WebDriverWait(driver, 30, 100);

        PageFactory.initElements(driver, this);
        waitPageLoad(driver);
    }

    public void waitPageLoad(WebDriver driver) {
        new WebDriverWait(driver, 90).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    protected void waitSpinner() {
        fluentWait.until(ExpectedConditions.attributeToBe(spinner, "z-index", "100"));
        fluentWait.until(ExpectedConditions.attributeToBe(spinner, "z-index", "0"));
    }

}
