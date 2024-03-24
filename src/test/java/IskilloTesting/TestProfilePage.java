package IskilloTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Header;
import object.HomePage;
import object.LoginPage;
import object.ProfilePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestProfilePage {
    ChromeDriver webDriver;


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testModifyProfilePage() {
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded());
        header.clickLogin();
        loginPage.fillUserName("tonchevaIvelina");
        loginPage.fillPassword("toncheva123456");
        Assert.assertTrue(loginPage.isUrlLoginPageLoaded());
        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me is not checked!");
        loginPage.clickSignIn();
        header.clickProfile();
        Assert.assertTrue(profilePage.isProfilePageLoaded1(), "Profile page is not loaded!");
        profilePage.clickModifyProfileButton();
        profilePage.justClick();
        profilePage.fillNewPassword("Ivka123456");
        profilePage.fillConfirmNewPassword("Ivka123456");
        profilePage.fillPublicInfo("Testing");
        // profilePage.clickSave();

    }

    @AfterMethod
    public void afterMethod() {
        webDriver.close();
    }
}
