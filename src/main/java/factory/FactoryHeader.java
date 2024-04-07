package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryHeader {
    public final WebDriver webDriver;

    @FindBy(id = "nav-link-login")
    public WebElement loginLink;
    @FindBy(id ="nav-link-home")
    public WebElement homeLink;
    @FindBy(id = "nav-link-profile")
    public WebElement profileLink;
    @FindBy(xpath ="//div[@id='navbarColor01']//i[@class='fas fa-sign-out-alt fa-lg']")
    public WebElement logOutButton;
    @FindBy(id = "nav-link-new-post")
    public  WebElement newPostLink;



    public FactoryHeader(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }
}
