package object;

import factory.FactoryRegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends FactoryRegisterPage {
    public void navigateTo() {
        this.webDriver.get(REGISTER_PAGE);
    }
    public RegisterPage (WebDriver driver){
        super(driver);
    }
    public boolean isUrlRegisterPageLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REGISTER_PAGE));
    }
    public void fillUserNameText(String name) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(fillUserName));
        fillUserName.sendKeys(name);
    }
    public void fillEmailText(String email){
        fillEmail.sendKeys(email);
    }
    public void fillPasswordText(String password){
        fillPassword.sendKeys(password);
    }
    public void fillConfirmPassword(String password){
        fillConfirmPassword.sendKeys(password);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
