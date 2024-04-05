package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryPostPage {
    public final WebDriver webDriver;

    public FactoryPostPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//h3[text()='Post a picture to share with your awesome followers']")
    public WebElement postTitle;
    @FindBy(xpath = "//*[@class='form-group']/input[@type='file']")
    public WebElement uploadFile;
    @FindBy(xpath = "//div[@class='input-group-addon']/input")
    public  WebElement postCaption;
    @FindBy(id = "create-post")
    public  WebElement submitButton;
    @FindBy(xpath = "//div[@class='gallery-item']")
    public WebElement postedPicture;
    @FindBy(xpath = "//app-comment-form/form/fieldset/div/input")
    public WebElement commentText;
    @FindBy(xpath = "//label[@class='delete-ask']/a[text()='Delete post']")
    public  WebElement deletePost;
    @FindBy(xpath = "//div[@class='delete-confirm']/button[text()='Yes']")
    public WebElement confirmDelete;
}
