package com.upgrade.tests;

import com.upgrade.BaseTest;
import com.upgrade.pages.ApplyForLoanPage;
import com.upgrade.pages.CheckYourRatePage;
import com.upgrade.pages.OfferPage;
import com.upgrade.pages.SignInPage;
import com.upgrade.users.User;
import com.upgrade.users.UsersHelper;
import org.junit.Assert;
import org.testng.annotations.Test;


/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class UseCaseTest extends BaseTest {


    @Test
    public void userCaseTest() throws InterruptedException {

        //Applies for loan with $2000 for business
        driver.get("https://www.credify.tech/phone/nonDMFunnel");
        ApplyForLoanPage applyForLoanPage = new ApplyForLoanPage(driver);
        CheckYourRatePage checkYourRatePage = applyForLoanPage.applyLoanForBusiness();

        //Fills out form and Signs up as user from San Francisco
        checkYourRatePage.fillOutFormCheckYourRate();
        User user = UsersHelper.getRandomUser();
        OfferPage offerPage = checkYourRatePage.signUp(user);

        //Saves parameters to be checked
        String loanAmount = offerPage.getLoanAmount();
        String monthlyPayment = offerPage.getMonthlyPaymentAmount();
        String defaultLoanTerm = offerPage.getdefaultLoanTerm();
        String defaultApr = offerPage.getdefaultAPR();

        //Signs out
        offerPage.signOut();

        //Opens login page
        driver.get("https://www.credify.tech/portal/login");
        SignInPage signInPage = new SignInPage(driver);

        //Sign in as user
        offerPage = signInPage.login(user);
        //Saves current parameters
        String loanAmountAfterLogin = offerPage.getLoanAmount();
        String monthlyPaymentAfterLogin = offerPage.getMonthlyPaymentAmount();
        String defaultLoanTermAfterLogin = offerPage.getdefaultLoanTerm();
        String defaultAprAfterLogin = offerPage.getdefaultAPR();

        //Compares current with previous parameters
        Assert.assertEquals(loanAmount, loanAmountAfterLogin);
        Assert.assertEquals(monthlyPayment, monthlyPaymentAfterLogin);
        Assert.assertEquals(defaultLoanTerm, defaultLoanTermAfterLogin);
        Assert.assertEquals(defaultApr, defaultAprAfterLogin);
    }
}
