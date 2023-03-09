
package org.example.pages;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.List;

public class P01_Register
{
    public P01_Register(){
        PageFactory.initElements(Hooks.driver,this);
}
    public WebElement registerLink(){
        WebElement register= Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
        return register;
    }
@FindBy(id="gender-female")
public WebElement genderType;

    @FindBy(id="FirstName")
    public WebElement firstname;
    @FindBy(id="LastName")
    public WebElement lastname;

    @FindBy(name="DateOfBirthDay")
    public WebElement day;

    @FindBy(name="DateOfBirthMonth")
    public WebElement month;

    @FindBy(name="DateOfBirthYear")
    public WebElement year;

    @FindBy(name="Email")
    public WebElement email;


        @FindBy(id="Password")

    public WebElement password;
    @FindBy(id="ConfirmPassword")

    public WebElement confirmpw;
    @FindBy(name="register-button")
    public WebElement registerBtn;

    @FindBy(className = "result")
    public WebElement successMsg;
}
