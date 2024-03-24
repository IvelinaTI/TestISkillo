package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";
    private final WebDriver webDriver;

    @FindBy(xpath = "//*[@name='usernameOrEmail']" )
    private WebElement userNameText;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement passwordText;
    @FindBy(xpath = "//*[@class='remember-me']/input[@type='checkbox']")
    private WebElement rememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    private WebElement signInButton;
    public LoginPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }
    public boolean isUrlLoginPageLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(LOGIN_URL));
    }
    public void fillUserName(String name){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(userNameText));
        userNameText.sendKeys(name);
    }
    public void  fillPassword(String password){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordText));
        passwordText.sendKeys(password);
    }
    public void checkRememberMe(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(rememberMeCheckBox));
        rememberMeCheckBox.click();
    }
    public boolean isCheckedRememberMe(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(rememberMeCheckBox));
        return rememberMeCheckBox.isSelected();
    }
    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }
}
