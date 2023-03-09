package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D05_hoverCateogoriesStepDefs {
    P03_homePage homePage=new P03_homePage();

    @When("user select random category")
    public void selectRandomCategory() throws InterruptedException {

        //2- Select random profile then hover on the card then click on "View profile" link
//        List<WebElement> avatars = Hooks.driver.findElements(By.cssSelector("img[src=\"/img/avatar-blank.jpg\"]"));
//        int count = avatars.size();     //3
//        System.out.println(count);
//        //3- How to select random element
//
//        /*
//        Example:   Generate random int value from 0 to 2
//        int min = 0;  int max = 2;
//        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
//        */
//
//
//        int min = 0;
//        int max = count-1;   // you are selecting random value from 0 to 2 that's why  max = count-1
//        int selectedUser =  (int)Math.floor(Math.random()*(max-min+1)+min);
//        System.out.println(selectedUser);
//        Actions action = new Actions(Hooks.driver);
//
//        action.moveToElement(avatars.get(selectedUser)).perform();
//        Thread.sleep(2000);
//
//        List<WebElement> profileLinks =Hooks. driver.findElements(By.cssSelector("a[href*=\"/users/\"]"));
//        profileLinks.get(selectedUser).click();  // As we mentioned above, SelectedUser can't be 3

    }
    @And("user hover on the selected category with index {int}")
    public void userHoverOnTheSelectedCategoryWithIndex(int arg0) throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        WebElement figure=homePage.hoverelements().get(arg0-1);
        action.moveToElement(figure).perform();
        Thread.sleep(2000);


    }

String subCategoryName;
    @And("user get the text of subcategory and click on it")
    public void selectRandomSubcategory() {
int count =   homePage.subCategory.size();

        int min = 0;
       int max = count-1;   // you are selecting random value from 0 to 2 that's why  max = count-1
        int randomSub =  (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println(randomSub);
        //actual result 1
        subCategoryName = homePage.subCategory.get(randomSub).getText();
        homePage.subCategory.get(randomSub).click();

    }

    String pageTitle;

    @And("check the title of the category page")
    public void checkTheTitleOfTheCategoryPage() {
        //actual result 2
    pageTitle = homePage.pageTitle.getText();

    Assert.assertEquals(subCategoryName.toLowerCase(), pageTitle.toLowerCase());

    }


}
