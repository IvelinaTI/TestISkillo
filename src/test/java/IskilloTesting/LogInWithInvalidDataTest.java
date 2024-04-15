package IskilloTesting;

import object.*;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInWithInvalidDataTest extends TestObject {
    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"tonchevaIvelina", "toncheva"}
        };
    }

    @Test(dataProvider = "getUser")
    public void LogWithInvaliPassword(String username, String password) {
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded());
        Assert.assertTrue(header.isLogInButtonExist());
        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoginPageLoaded());

        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me is not checked!");
        Assert.assertTrue(loginPage.isSignInButtonIsClickable());
        loginPage.clickSignIn();
        Assert.assertTrue(postPage.isInvalidPasswordBoxExist());
    }
}
