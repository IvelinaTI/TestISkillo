package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static final String PROFILE_PAGE = "http://training.skillo-bg.com:4200/users/";
    private final WebDriver webDriver;
    public ProfilePage(WebDriver driver){
        this.webDriver = driver;
    }
    public boolean isProfilePageLoaded1(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlContains(PROFILE_PAGE));
    }
//    public boolean isProfilePageLoaded2(String userId){
//        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
//        return wait.until(ExpectedConditions.urlToBe(PROFILE_PAGE+userId));
//    }
    public void clickModifyProfileButton(){
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(15));
        WebElement modifyProfileButton = wait.until(ExpectedConditions.visibilityOf(
                this.webDriver.findElement(By.xpath("//div[@class='col-12 col-lg-6 profile-user-settings']/i"))));
        modifyProfileButton.click();
    }
    public void justClick(){
        WebElement justClick = this.webDriver.findElement(By.xpath("//*[@class='container profile-edit-container']"));
        justClick.click();
    }
    public void fillNewPassword(String newPassword){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement newPasswordText = wait.until(ExpectedConditions.visibilityOf(
                this.webDriver.findElement(By.xpath("//*[@class='ng-pristine ng-valid ng-touched']//div[3]//input[@type='password']"))));
        newPasswordText.sendKeys(newPassword);
    }

    public void fillConfirmNewPassword(String confirmPassword){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement conformPasswordText = wait.until(ExpectedConditions.visibilityOf(
                this.webDriver.findElement(By.xpath("//ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[4]/div/input"))));
        conformPasswordText.sendKeys(confirmPassword);
        //*[@class='ng-pristine ng-valid ng-touched']//div[4]//input[@type='password']
    }
    public void fillPublicInfo(String publicInfo){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement publicInfoText = wait.until(ExpectedConditions.visibilityOf(
                this.webDriver.findElement(By.xpath("//ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[5]/div/textarea"))));
        publicInfoText.sendKeys(publicInfo);
        //ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[5]/div/textarea
        //*[@class='ng-pristine ng-valid ng-touched']//div/textarea
    }
    public void clickSave(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.xpath("//*[@class='ng-pristine ng-valid ng-touched']//div/button"))));
        saveButton.click();

    }

}
