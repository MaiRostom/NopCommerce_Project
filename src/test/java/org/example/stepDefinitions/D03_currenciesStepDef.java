package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefinitions.Hooks.driver;

public class D03_currenciesStepDef {
    P03_homePage homepage=new P03_homePage();

@When("user Select the Euro currency form Dropdownlist")
    public void selectEuroCurrency(){

    Select currencyList=new Select(homepage.currencyDropdown());
    currencyList.selectByVisibleText("Euro");
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(homepage.currencyDropdown()));

}
@And("the Euro is reflected successfully in prodcuts")
    public void euroIsReflectedSuccessfully(){


    for(int i=0;i<homepage.pricesList().size();i++){
       String actualCurrency= homepage.pricesList().get(i).getText();
       SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualCurrency.contains("€"));
        softAssert.assertAll();
    }
}


}
