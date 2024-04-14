package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FactoryHomePage {
    public final WebDriver webDriver;

    public FactoryHomePage(WebDriver driver) {
        this.webDriver = driver;
    }

}
