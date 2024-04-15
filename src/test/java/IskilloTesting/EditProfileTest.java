package IskilloTesting;

import object.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class EditProfileTest extends TestObject {

    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{
                {"Ivelinat05","toncheva1234567"}
        };
        }

    @Test(dataProvider = "getUser")
    public void editProfileTest(String username, String password) {
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
        header.clickProfile();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");

        profilePage.clickModifyProfileButton();
        profilePage.justClick();
        profilePage.fillNewPassword("toncheva123456");
        profilePage.fillConfirmNewPassword("toncheva123456");
        profilePage.fillPublicInfo("Testing");
        profilePage.clickSave();
        Assert.assertTrue(header.isLogOutButtonExist());
        header.clickLogOut();
        Assert.assertTrue(loginPage.isUrlLoginPageLoaded());
        Assert.assertTrue(header.isLogInButtonExist());
        header.clickLogin();
        loginPage.fillUserName(username);
        loginPage.fillPassword("toncheva123456");
        Assert.assertTrue(loginPage.isSignInButtonIsClickable());
        loginPage.clickSignIn();
        Assert.assertTrue(postPage.isInvalidPasswordBoxExist());

    }
}
//Принципно на този тест сайта има грешка,защото веднъж смениш ли паролата нито със старата нито с новата можеш да се логнеш отново.
