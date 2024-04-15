package IskilloTesting;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import object.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeletePostTest extends TestObject{
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{
                {"tonchevaIvelina","toncheva123456"}
        };
    }
    @Test(dataProvider = "getUser")
    public void deletePost (String username, String password) {
        Header header = new Header(webDriver);
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);
        profilePage.navigateTo();

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded());
        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoginPageLoaded());

        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me is not checked!");
        Assert.assertTrue(loginPage.isSignInButtonIsClickable());
        loginPage.clickSignIn();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");

        header.clickProfile();
        Assert.assertTrue(postPage.isPostedPictureExist(),"There is no posted picture!");
        int postsBefore = postPage.getAllPosts();
        System.out.println(postsBefore);

        postPage.clickPostedPicture();
        postPage.clickDeletePost();
        postPage.clickConfirmDelete();
        Assert.assertTrue(postPage.isAlertByTitleVisible(" Post Deleted! "));
        int postsAfter = postPage.getAllPosts();
        System.out.println(postsAfter);
        Assert.assertEquals(postsBefore, (postsAfter + 1));
    }
    }




