package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FactoryProfilePage {
    public static final String PROFILE_PAGE = "http://training.skillo-bg.com:4200/users/";
    public final WebDriver webDriver;
    @FindBy(xpath = "//div[@class='col-12 col-lg-6 profile-user-settings']/i")
    public WebElement modifyProfileButton;
    @FindBy(xpath = "//*[@class='container profile-edit-container']")
    public WebElement justClickInContainer;
    @FindBy(xpath = "//div[@class='modal-content']//input[@formcontrolname='password']")
    public WebElement newPasswordText;
    @FindBy(xpath = "//div[@class='modal-content']//input[@formcontrolname='confirmPassword']")
    public WebElement conformPasswordText;
    @FindBy(xpath = "//div[@class='modal-content']//textarea[@formcontrolname='publicInfo']")
    public WebElement publicInfoText;
    @FindBy(xpath = "//div[@class='modal-content']//div/button")
    public WebElement clickSaveButton;

    public FactoryProfilePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
}
