package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FactoryPostPage {
    public final WebDriver webDriver;
    public static final String POST_URL = "http://training.skillo-bg.com:4200/posts/create";


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
    @FindBy(xpath = "//div[text()='Writing the comment test.']")
    public WebElement isPostExist;
    @FindBy(xpath = "//div[@class= 'gallery-item-info']")
    public List<WebElement> elements;
    @FindBy(xpath = "//*[@id='toast-container']//*[@class='toast-message ng-star-inserted']")
    public WebElement invalidPasswordBox;
    @FindBy(css = "app-post .gallery-item")
    public List<WebElement> allPosts;
}
