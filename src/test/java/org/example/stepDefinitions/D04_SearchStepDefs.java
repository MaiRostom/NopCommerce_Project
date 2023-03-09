package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefinitions.Hooks.driver;

public class D04_SearchStepDefs {
    P03_homePage homepage=new P03_homePage();
    SoftAssert softAssert=new SoftAssert();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
    String keyword=null;
    String sku=null;


//    @When("user write the product name {string} in search bar")
//    public void userWriteTheProductNameInSearchBar(String arg0) throws InterruptedException {
//        System.out.println("The word is "+arg0);
//        homepage.searchbar.sendKeys(arg0);
//        keyword=arg0;
//        homepage.searchbtn().click();
//    }

    @When("user write the product name {string} in search bar")
    public void userWriteTheProductNameProductNameInSearchBar(String productName) {
        System.out.println("The word is "+productName);
      homepage.searchbar.sendKeys(productName);
       keyword=productName;
       homepage.searchbtn().click();
    }


    @Then("a page contains all product name appears")
    public void aPageContainsAllProductNameAppears() {
     wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/search?q="+keyword));
     String actualUrl=driver.getCurrentUrl();
     String expectedUrl="https://demo.nopcommerce.com/search?q=";
     softAssert.assertTrue(actualUrl.contains(expectedUrl));
     int count= homepage.searchItems().size();
     softAssert.assertTrue(count>=1);
     for(int i=0;i<count;i++){
         softAssert.assertTrue(homepage.searchItems().get(i).getText().toLowerCase().contains(keyword.toLowerCase()));
         System.out.println("Second Keyword " +keyword);
     }
     softAssert.assertAll();
    }


//    @When("user write sku of the product {string} in search bar")
//    public void userWriteSkuOfTheProductInSearchBar(String arg0) {
//        homepage.searchbar.sendKeys(arg0);
//        sku=arg0;
//        homepage.searchresult().click();
//    }
    @When("user write sku of the product  in search bar {string}")
    public void userWriteSkuOfTheProductInSearchBarProductSku(String skuNo) {
        homepage.searchbar.sendKeys(skuNo);
        sku=skuNo;
        homepage.searchresult().click();
    }
    @Then("verify that the item of that sKU is opened successfully")
    public void verifyThatTheItemOfThatSKUIsOpenedSuccessfully() {
        Assert.assertEquals(homepage.actualSku.getText(),sku);
    }

}
