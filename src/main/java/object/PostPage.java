package object;

import factory.FactoryPostPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class PostPage extends FactoryPostPage {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewPostLoaded() {
        return postTitle.isDisplayed();
    }

    public void uploadPicture(File file) {
        uploadFile.sendKeys(file.getAbsolutePath());
    }

    public void typePostCaption(String text) {
        postCaption.sendKeys(text);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickPostedPicture() {
        postedPicture.click();
    }
    public boolean isPostedPictureExist(){
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(postedPicture));
        return postedPicture.isDisplayed();
    }

    public void fillCommentPost(String text) {
        commentText.sendKeys(text);
    }

    public void clickDeletePost() {
        deletePost.click();
    }

    public void clickConfirmDelete() {
        confirmDelete.click();
    }

    public boolean isCommentPostExist() {
        WebElement isCommentPost = webDriver.findElement(By.xpath("//div[text()='Writing the comment test.']"));
        return isCommentPost.isDisplayed();
    }

    public boolean isUrlPostPageLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/create"));
    }
    public boolean isElementVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='post-img']/img[@src='https://i.imgur.com/3Qg8Bys.jpeg']")));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public int countVisibleElements1() {
        try {
            List<WebElement> elements = this.webDriver.findElements(By.xpath("//div[@class= 'gallery-item-info']"));
            int count = 0;
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    count++;
                }
            }
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public int countVisibleElements2() {
        try {
            List<WebElement> elements = this.webDriver.findElements(By.xpath("//div[@class= 'gallery-item-info']"));
            int count = 0;
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    count++;
                }
            }
            return count;
        } catch (Exception e) {
            return 0;
        }
    }
        public boolean countVisibleElements() {
            return countVisibleElements1() == countVisibleElements2();
        }
    public boolean isInvalidPasswordBoxExist() {
        WebElement invalidPasswordBox = webDriver.findElement(By.xpath("//*[@id='toast-container']//*[@class='toast-message ng-star-inserted']"));
        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(invalidPasswordBox).perform();
        String expectedText = "Ivalid password";
        String actualText = invalidPasswordBox.getText();
        return invalidPasswordBox.isDisplayed();
    }
        public int getAllPosts() {
            List<WebElement> allPosts = webDriver.findElements(By.cssSelector("app-post .gallery-item"));
            return allPosts.size();
        }

    public boolean isAlertByTitleVisible(String title) {
        try {
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
            WebElement alertByTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-message') and text()='" + title + "']")));
            return alertByTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}








