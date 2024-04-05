package IskilloTesting;

import object.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommentPostTest extends TestObject{
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{
                {"tonchevaIvelina","toncheva123456"}
        };
    }
    @Test(dataProvider = "getUser")
    public void commentPost (String username, String password){
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
        loginPage.clickSignIn();

        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");
        header.clickProfile();

        postPage.clickPostedPicture();
        postPage.fillCommentPost("Writing the comment test.");
        postPage.fillCommentPost(String.valueOf(Keys.RETURN));

    }
}
