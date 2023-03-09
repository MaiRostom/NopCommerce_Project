package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_LoginStepDefs {
    P02_Login login=new P02_Login();
    @Given("user opens login page")
    public void openLoginPage(){
            login.loginPage.click();
        }
    @When("user enter valid {string} and {string}")
    public void userEnterValidAnd(String arg0, String arg1) {
        login.email.sendKeys(arg0);
        login.password.sendKeys(arg1);
    }
    @And("user press remember me")
    public void pressRememberMe() throws InterruptedException {
        login.rememberme.click();
        Thread.sleep(2000);

    }

    @And("user press login")
    public void user_press_login() {
     login.loginBtn.click();
    }


    @Then("user logged in successfully")
    public void userLoggedInSuccessfully() {
        SoftAssert softAssert=new SoftAssert();
        Boolean displayed=login.myAccountTab.isDisplayed();
                softAssert.assertTrue(displayed);
        String expectedMsg=Hooks.driver.getCurrentUrl();
        System.out.println(expectedMsg);
        softAssert.assertEquals(expectedMsg,"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }


    @When("user enter invalid {string} and {string}")
    public void userEnterInvalidAnd(String arg0, String arg1) {
        login.email.sendKeys(arg0);
        login.password.sendKeys(arg1);
    }

    @Then("user don't logged " +
            "in successfully")
    public void userDonTLoggedInSuccessfully() {
        String actualMsg=login.failedMsg.getText();
        String expectedMsg="Login was unsuccessful. Please correct the errors and try again.";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualMsg.contains(expectedMsg));
        String expectedColor="#e4434b";
        String actualColor=login.failedMsg.getCssValue("color");
        actualColor=Color.fromString(actualColor).asHex();
        softAssert.assertEquals(actualColor,expectedColor);
        softAssert.assertAll();
    }



}


