package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static final String PROFILE_PAGE = "http://training.skillo-bg.com:4200/users/";
    private final WebDriver webDriver;
    @FindBy(xpath = "//div[@class='col-12 col-lg-6 profile-user-settings']/i")
    private WebElement modifyProfileButton;
    @FindBy(xpath = "//*[@class='container profile-edit-container']")
    private WebElement justClick;
    @FindBy(xpath = "//*[@class='ng-pristine ng-valid ng-touched']//div[3]//input[@type='password']")
    private WebElement newPasswordText;

    @FindBy(xpath = "//ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[4]/div/input")
    private WebElement conformPasswordText;

    @FindBy(xpath = "//ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[5]/div/textarea")
    private WebElement publicInfoText;

    @FindBy(xpath = "//*[@class='ng-pristine ng-valid ng-touched']//div/button")
    private  WebElement clickSaveButton;

    public ProfilePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isProfilePageLoaded1() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlContains(PROFILE_PAGE));
    }

    //    public boolean isProfilePageLoaded2(String userId){
//        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
//        return wait.until(ExpectedConditions.urlToBe(PROFILE_PAGE+userId));
//    }
    public void clickModifyProfileButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(modifyProfileButton));
        modifyProfileButton.click();
    }

    public void justClick() {
        justClick.click();
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
        //*[@class='ng-pristine ng-valid ng-touched']//div[4]//input[@type='password']
    }

    public void fillPublicInfo(String publicInfo) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(publicInfoText));
        publicInfoText.sendKeys(publicInfo);
        //ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[5]/div/textarea
        //*[@class='ng-pristine ng-valid ng-touched']//div/textarea
    }

    public void clickSave() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(clickSaveButton));
        clickSaveButton.click();

    }

}
