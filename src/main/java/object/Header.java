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
    public void clickLogOut(){
        logOutButton.click();
    }
    public void clickNewPost(){
        newPostLink.click();
    }


}
