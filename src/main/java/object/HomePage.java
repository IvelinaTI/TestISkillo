package object;

import factory.FactoryHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends FactoryHomePage {
    public static final String HOME_URL = "http://training.skillo-bg.com:4200/posts/all";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        this.webDriver.get(HOME_URL);
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(HOME_URL));
    }
}
