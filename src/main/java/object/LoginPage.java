package object;

import factory.FactoryLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends FactoryLoginPage {
    public static final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";

    public LoginPage(WebDriver driver){
        super(driver);
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

    public void navigateTo() {
        this.webDriver.get(LOGIN_URL);
    }
//    public boolean isUrlLoginPageLoaded(){
//        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
//        return wait.until(ExpectedConditions.urlToBe(LOGIN_URL));
//    }
//    public void fillUserName(String name){
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//        WebElement userNameText = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.xpath("//*[@name='usernameOrEmail']"))));
//        userNameText.sendKeys(name);
//    }
//    public void  fillPassword(String password){
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//        WebElement passwordText = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.xpath("//*[@name='password']"))));
//        passwordText.sendKeys(password);
//    }
//    public void checkRememberMe(){
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//        WebElement rememberMeCheckBox = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.xpath("//*[@class='remember-me']/input[@type='checkbox']"))));
//        rememberMeCheckBox.click();
//    }
//    public boolean isCheckedRememberMe(){
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//        WebElement rememberMeCheckBox = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@class='remember-me']/input[@type='checkbox']"))));
//        return rememberMeCheckBox.isSelected();
//    }
//    public void clickSignIn(){
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
//        WebElement signInButton = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.id("sign-in-button"))));
//        signInButton.click();
//    }
}
