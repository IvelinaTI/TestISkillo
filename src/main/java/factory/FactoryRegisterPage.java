package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryRegisterPage {
//    public static final String REGISTER_PAGE = "http://training.skillo-bg.com:4200/users/register";
    public final WebDriver webDriver;
    public FactoryRegisterPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//form//input[@placeholder='Username']")
    public WebElement fillUserName;
    @FindBy(xpath = "//form//input[@placeholder='email']")
    public WebElement fillEmail;
    @FindBy(xpath = "//form//input[@name='password']")
    public WebElement fillPassword;
    @FindBy(xpath = "//form//input[@placeholder='Confirm Password']")
    public  WebElement fillConfirmPassword;
    @FindBy(xpath = "//div[@class='text-center']//button[text()='Sign in']")
    public WebElement signInButton;

}
