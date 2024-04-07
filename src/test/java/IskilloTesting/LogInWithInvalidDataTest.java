package IskilloTesting;

import object.Header;
import object.HomePage;
import object.LoginPage;
import object.ProfilePage;
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

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded());
        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoginPageLoaded());

        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me is not checked!");
        loginPage.clickSignIn();

        header.clickProfile();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");
    }
}
