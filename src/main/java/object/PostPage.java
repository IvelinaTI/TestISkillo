package object;

import factory.FactoryPostPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class PostPage extends FactoryPostPage {
    public PostPage (WebDriver driver){
        super(driver);
    }
    public boolean isNewPostLoaded(){
        return postTitle.isDisplayed();
    }
    public void uploadPicture (File file){
        uploadFile.sendKeys(file.getAbsolutePath());
    }
    public void typePostCaption(String text){
        postCaption.sendKeys(text);
    }
    public  void  clickSubmitButton(){
        submitButton.click();
    }
    public void clickPostedPicture(){
        postedPicture.click();
    }
    public void fillCommentPost(String text){
        commentText.sendKeys(text);
    }
    public void clickDeletePost(){
        deletePost.click();
    }
    public void clickConfirmDelete(){
        confirmDelete.click();
    }

}
