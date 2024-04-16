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
        return isPostExist.isDisplayed();
    }

    public boolean isUrlPostPageLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(POST_URL));
    }
    public boolean isInvalidPasswordBoxExist() {
        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(invalidPasswordBox).perform();
        String expectedText = "Ivalid password";
        String actualText = invalidPasswordBox.getText();
        return invalidPasswordBox.isDisplayed();
    }
        public int getAllPosts() {
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








