package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FactoryLoginPage {
    public static final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";
    public final WebDriver webDriver;

    @FindBy(xpath = "//*[@name='usernameOrEmail']" )
    public WebElement userNameText;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordText;
    @FindBy(xpath = "//*[@class='remember-me']/input[@type='checkbox']")
    public WebElement rememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    public WebElement signInButton;
    public FactoryLoginPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }
}
