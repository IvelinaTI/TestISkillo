package IskilloTesting;

import object.*;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestObject {
    @DataProvider(name="createUser")
    public Object[][] createUser(){
        return new Object[][]{
                {"Ivelinat0000","ive3344@gmail.com","toncheva1234567"}
        };
    }
    @Test(dataProvider = "createUser")
    public void createNewUser(String username, String email, String password){
        Header header = new Header(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);

        registerPage.navigateTo();
        Assert.assertTrue(registerPage.isUrlRegisterPageLoaded());

        registerPage.fillUserNameText(username);
        Assert.assertFalse(registerPage.isTypeUserName(),"The Username field is empty.");

        registerPage.fillEmailText(email);
        registerPage.fillPasswordText(password);
        registerPage.fillConfirmPassword(password);

        Assert.assertTrue(registerPage.signInButton.isEnabled());
        registerPage.clickSignInButton();
        Assert.assertTrue(profilePage.isProfilePageLoaded1());
        header.clickNewPost();
        Assert.assertTrue(postPage.isUrlPostPageLoaded());

    }
}
