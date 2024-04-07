package IskilloTesting;

import object.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestObject {
    @DataProvider(name="createUser")
    public Object[][] createUser(){
        return new Object[][]{
                {"IvelinaToncheva","ivelina123@gmail.com","toncheva123456"}
        };
    }
    @Test(dataProvider = "createUser")
    public void createNewUser(String username, String email, String password){
        Header header = new Header(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        registerPage.navigateTo();
        Assert.assertTrue(registerPage.isUrlRegisterPageLoaded());

        registerPage.fillUserNameText(username);
        registerPage.fillEmailText(email);
        registerPage.fillPasswordText(password);
        registerPage.fillConfirmPassword(password);
        registerPage.clickSignInButton();

        header.clickProfile();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");
    }
}
