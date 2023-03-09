package org.example.stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_RegStepDefs {
    P01_Register register=new P01_Register();


    @Given("User Go to Register Page")
    public void goToRegisteration(){
        register.registerLink().click();

    }

    @When("user select genderType")
    public void userSelectGenderType() {
        register.genderType.click();
    }

    @And("User enter {string} and {string}")
    public void userEnterAnd(String Firstname, String Lastname) {
    register.firstname.sendKeys(Firstname);
    register.lastname.sendKeys(Lastname);
    }

    @And("user select Birthdate")
    public void userSelectBirthdate() {
        Select dayList=new Select(register.day);
        dayList.selectByValue("14");
        Select monthList=new Select(register.month);
        monthList.selectByValue("12");
        Select yearList=new Select(register.year);
        yearList.selectByValue("1991");


    }

    @And("User write the email")
    public void userWriteThe() throws InterruptedException {
//        Faker fake=new Faker();
//       String emailAddress= fake.internet().emailAddress();
//        register.email.sendKeys(emailAddress);
       register.email.sendKeys("test@example.com");
        Thread.sleep(3000);
    }



    @And("user enter {string} Password and Confirm password")
    public void userEnterPasswordAndConfirmPassword(String arg0) {
    register.password.sendKeys(arg0);
    register.confirmpw.sendKeys(arg0);
    }

    @And("user click on Register")
    public void userClickOnRegister() {
    register.registerBtn.click();
    }

    @Then("user Registered in successfully")
    public void userRegisteredInSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        String actualMessage=register.successMsg.getText();
        String successColor=register.successMsg.getCssValue("color");
        successColor=Color.fromString(successColor).asHex();
        String expectedMsg="Your registration completed";
       softAssert.assertTrue(actualMessage.contains(expectedMsg));
       softAssert.assertEquals(successColor,"#4cb17c");

        System.out.println("Assertion");
        softAssert.assertAll();
    }
}
