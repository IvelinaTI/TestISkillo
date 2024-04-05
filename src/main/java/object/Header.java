package object;

import factory.FactoryHeader;
import org.openqa.selenium.WebDriver;

public class Header extends FactoryHeader {

    public Header(WebDriver driver){
        super(driver);
    }
    public void clickLogin(){
        loginLink.click();
    }
    public void clickHome(){
        homeLink.click();
    }
    public void clickProfile(){
        profileLink.click();
    }
    public void LogOut(){
        logOutButton.click();
    }
    public void clickNewPost(){
        newPostLink.click();
    }


//    public void clickLogin(){
//        loginLink.click();
//    }
//    public void clickHome(){
//        WebElement home = this.webDriver.findElement(By.id("nav-link-home"));
//        home.click();
//    }
//    public void clickProfile(){
//        WebElement profile = this.webDriver.findElement(By.id("nav-link-profile"));
//        profile.click();
//    }
//    public void LogOut(){
//        WebElement logOutButton = this.webDriver.findElement(By.xpath("//div[@id='navbarColor01']//i[@class='fas fa-sign-out-alt fa-lg']"));
//        logOutButton.click();
//    }
}
