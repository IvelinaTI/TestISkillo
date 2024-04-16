package IskilloTesting;

import object.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class PostTest extends TestObject {
    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        File postPicture = new File("src\\test\\resources\\upload\\SmileyDog.jpg");
        String caption = "Testing post picture";
        return new Object[][]{
                {"tonchevaIvelina", "toncheva123456", postPicture, caption}
        };
    }
    @DataProvider(name = "createSecondPost")
    public Object[][] createSecondPost() {
        File postPicture = new File("src\\test\\resources\\upload\\Rome.jpg");
        String caption = "Testing post picture";
        return new Object[][]{
                {"tonchevaIvelina", "toncheva123456", postPicture, caption}
        };
    }

    @Test(dataProvider = "getUser")
    public void createPostTest(String username, String password,File postPicture, String caption) {
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);

        loginPage.navigateTo();
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me is not checked!");
        loginPage.clickSignIn();

        header.clickProfile();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");
        int postsBefore = postPage.getAllPosts();
        System.out.println(postsBefore);
        header.clickNewPost();

        Assert.assertTrue(postPage.isNewPostLoaded(), "The form is not loaded!");
        Assert.assertTrue(postPage.isUrlPostPageLoaded());
        postPage.uploadPicture(postPicture);
        postPage.typePostCaption(caption);
        postPage.clickSubmitButton();
        int postsAfter = postPage.getAllPosts();
        System.out.println(postsAfter);
        Assert.assertEquals(postsBefore, (postsAfter));
    }
    @Test(dataProvider = "createSecondPost")
    public void createSecondPostTest(String username, String password,File postPicture, String caption) throws InterruptedException {
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);

        loginPage.navigateTo();
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me is not checked!");
        Assert.assertTrue(loginPage.isSignInButtonIsClickable());
        loginPage.clickSignIn();

        header.clickProfile();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");
        int postsBefore = postPage.getAllPosts();
        System.out.println(postsBefore);
        header.clickNewPost();
        Assert.assertTrue(postPage.isNewPostLoaded(), "The form is not loaded!");
        postPage.uploadPicture(postPicture);
        postPage.typePostCaption(caption);
        postPage.clickSubmitButton();
        int postsAfter = postPage.getAllPosts();
        System.out.println(postsAfter);
        Assert.assertEquals(postsBefore,(postsAfter));

    }
}
