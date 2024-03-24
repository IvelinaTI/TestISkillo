package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private final WebDriver webDriver;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id ="nav-link-home")
    private WebElement homeLink;

    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    @FindBy(xpath ="//div[@id='navbarColor01']//i[@class='fas fa-sign-out-alt fa-lg']")
    private WebElement logOutButton;

    public Header(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
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
}
