package org.example.pages;

import static org.example.stepDefinitions.Hooks.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class P02_Login {

    public P02_Login(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(className ="ico-login")
    public WebElement loginPage;

    @FindBy(className="email")
    public WebElement email;
    @FindBy(className ="password")
    public WebElement password;
    @FindBy(id="RememberMe")
    public  WebElement rememberme;
    @FindBy(className = "login-button")
    public WebElement loginBtn;
    @FindBy (className = "ico-account")
    public WebElement myAccountTab;
    @FindBy(className = "message-error")
    public WebElement failedMsg;


}
