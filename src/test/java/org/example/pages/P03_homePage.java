package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefinitions.Hooks.driver;

public class P03_homePage {

public P03_homePage()
{
    PageFactory.initElements(driver,this);
}

    //Hover

    public  List<WebElement> hoverelements(){
       return  driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
    }

    public WebElement gethoveredText(){
        return driver.findElement(By.cssSelector("div[class=\"category-grid home-page-category-grid\"] [class=\"category-item\"] [class=\"title\"]"));
    }

    //Currencies
   public WebElement currencyDropdown(){
      return driver.findElement(By.id("customerCurrency"));
   }
    public List<WebElement> pricesList(){
       return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    //Search
     @FindBy(name="q")
     public WebElement searchbar;
   public WebElement searchbtn(){
       return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
   }
     public List<WebElement> searchItems() {
         return driver.findElements(By.cssSelector("div[class=\"item-box\"]"));
     }
       public WebElement searchresult(){
           return driver.findElement(By.cssSelector("ul[id=\"ui-id-1\"]"));
         }
         @FindBy(css="span[id*=\"sku-\"]")
         public WebElement actualSku;


   @FindBy(xpath = "//div[@class=\"page-title\"]//h1")
   public WebElement pageTitle;

   @FindBy(css = "ul[class=\"top-menu notmobile\"]>li:nth-child(1)>ul>li>a[href]")
    public  List<WebElement> subCategory;
    //Slider
    public WebElement nokiaSlider() {
        return driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child(1)"));
    }

    public WebElement iphoneSlider() {
        return driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child(2)"));
    }

//FollowUS
    public ArrayList<String> tabs(){
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        return tabs;
    }
    public WebElement facebookLink(){
        return driver.findElement(By.cssSelector("ul[class=\"networks\"] [class=\"facebook\"]"));
    }

    public WebElement twitterLink(){
      return driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }
    public WebElement rSSLink(){
return  driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }
    public WebElement youtubeLink(){
return driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    //Wishlist
    public List<WebElement> wishlistBtn(){
        return driver.findElements(By.cssSelector("button[title=\"Add to wishlist\"]"));
    }
   public WebElement sucessMsg(){
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
   }
   public WebElement upWishList(){
        return driver.findElement(By.cssSelector("a[href=\"/wishlist\"]"));
   }
public WebElement qauntity(){
        return driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
}
}