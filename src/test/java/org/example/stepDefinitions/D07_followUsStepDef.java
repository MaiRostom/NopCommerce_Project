package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.stepDefinitions.Hooks.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefinitions.Hooks.driver;

public class D07_followUsStepDef {
    P03_homePage homePage=new P03_homePage();
    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
    SoftAssert softAssert=new SoftAssert();
    String actualUrl;
    String expectedUrl;


    @When("user Select Facbook Link")
    public void userSelectFacbookLink() throws InterruptedException {
    homePage.facebookLink().click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(homePage.tabs().get(1));
        wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/nopCommerce"));

    }

    @Then("Facebook Tab will be opened")
    public void facebookTabWillBeOpened() {
         expectedUrl="https://www.facebook.com/nopCommerce";
        actualUrl=driver.getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        softAssert.assertAll();
        driver.close();
    }

    @When("user select Twitter Link")
    public void userSelectTwitterLink() throws InterruptedException {
        homePage.twitterLink().click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(homePage.tabs().get(1));
        wait.until(ExpectedConditions.urlToBe("https://twitter.com/nopCommerce"));

    }

    @Then("Twitter Tab will be opened")
    public void twitterTabWillBeOpened() {
        actualUrl=driver.getCurrentUrl();
        expectedUrl="https://twitter.com/nopCommerce";
       softAssert.assertEquals(actualUrl,expectedUrl);
       softAssert.assertAll();
       driver.close();
    }

    @When("user select Rss Link")
    public void userSelectRssLink() {
        homePage.rSSLink().click();

    }

    @Then("Rss Link will be opened Successfully")
    public void rssLinkWillBeOpenedSuccessfully() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(homePage.tabs().get(1));
        wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/new-online-store-is-open"));

        actualUrl=driver.getCurrentUrl();
        System.out.println("The actual link is "+actualUrl);
        expectedUrl="https://demo.nopcommerce.com/new-online-store-is-open";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        softAssert.assertAll();
        driver.close();
    }

    @When("user select Youtube link")
    public void userSelectYoutubeLink() {
        homePage.youtubeLink().click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(homePage.tabs().get(1));
        wait.until(ExpectedConditions.urlToBe("https://www.youtube.com/user/nopCommerce"));

    }

    @Then("Youtube Tab is opened Successfully")
    public void youtubeTabIsOpenedSuccessfully() {
        actualUrl=driver.getCurrentUrl();
        expectedUrl="https://www.youtube.com/user/nopCommerce";
        softAssert.assertEquals(actualUrl,expectedUrl);
        softAssert.assertAll();
        driver.close();
    }
}
