package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefinitions.Hooks.driver;

public class D08_WishlistStepDef {
    P03_homePage homePage=new P03_homePage();
    SoftAssert softAssert=new SoftAssert();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("user select on a product  whislist")
    public void userSelectOnAProductWhislist() throws InterruptedException {
     //int count=homePage.wishlistBtn().size();
      homePage.wishlistBtn().get(2).click();

        wait.until(ExpectedConditions.visibilityOf(homePage.sucessMsg()));
    }

    @Then("a success message appear")
    public void aSuccessMessageAppear() {
      Boolean isDisplayed= homePage.sucessMsg().isDisplayed();

       softAssert.assertTrue(isDisplayed);
       String actualColor=homePage.sucessMsg().getCssValue("background-color");
       String expectedColor="#4bb07a";
        actualColor=Color.fromString(actualColor).asHex();
        softAssert.assertTrue(actualColor.contains(expectedColor));
        softAssert.assertAll();
    }

    @And("SuccessMsg dissappear")
    public void successmsgDissappear()  {
        wait.until(ExpectedConditions.invisibilityOf(homePage.sucessMsg()));
    }

    @When("user Click on whislistBtn upright")
    public void userClickOnWhislistBtnUpright() {
        homePage.upWishList().click();
    }

    @Then("user get quantity of products greater than zero")
    public void userGetQuantityOfProductsGreaterThanZero() {
        String actualQuantity=homePage.qauntity().getAttribute("value");
        softAssert.assertTrue(Integer.parseInt(actualQuantity)>0);
        softAssert.assertAll();


    }
}
