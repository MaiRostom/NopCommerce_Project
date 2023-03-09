package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefinitions.Hooks.driver;

public class D06_homeSlidersStepDef {
    P03_homePage homePage=new P03_homePage();

    @When("user select on Nokia Lumia")
    public void userSelectOnNokiaLumia() {
        homePage.nokiaSlider().click();
    }

    @Then("verify that user navigates to Nokia-lumia page")
    public void verifyThatUserNavigatesToNokiaLumiaPage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/nokia-lumia-1020"));
        String actualNokiaUrl=driver.getCurrentUrl();
        String expectedNokiaUrl="https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(actualNokiaUrl,expectedNokiaUrl);
    }

    @When("user select iphone slider")
    public void userSelectIphoneSlider() {
        homePage.iphoneSlider().click();
    }

    @Then("verify that user navigates to Iphone page")
    public void verifyThatUserNavigatesToIphonePage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/iphone-6"));

        String actuaIphonelURL=driver.getCurrentUrl();
        String expectedIphoneUrl="https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(actuaIphonelURL,expectedIphoneUrl);
    }


}
