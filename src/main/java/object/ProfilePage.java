package object;

import factory.FactoryProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends FactoryProfilePage {
    //public static final String PROFILE_PAGE = "http://training.skillo-bg.com:4200/users/";
    public ProfilePage(WebDriver driver){
        super(driver);
    }
    public boolean isProfilePageLoaded1() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlContains(PROFILE_PAGE));
    }
    public void clickModifyProfileButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(modifyProfileButton));
        modifyProfileButton.click();
    }

    public void justClick() {
        justClickInContainer.click();
    }

    public void fillNewPassword(String newPassword) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(newPasswordText));
        newPasswordText.sendKeys(newPassword);
    }

    public void fillConfirmNewPassword(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(conformPasswordText));
        conformPasswordText.sendKeys(confirmPassword);
    }

    public void fillPublicInfo(String publicInfo) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(publicInfoText));
        publicInfoText.sendKeys(publicInfo);
    }

    public void clickSave() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(clickSaveButton));
        clickSaveButton.click();

    }
    public void navigateTo() {
        this.webDriver.get(PROFILE_PAGE);
    }

}
