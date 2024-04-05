package IskilloTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class TestObject {
    public static final String TEST_RESOURCES_DIR = "src\\test\\resources\\";
    public static final String SCREENSHOTS_DIR = TEST_RESOURCES_DIR.concat("screenshots\\");
    public static final String UPLOAD_DIR = TEST_RESOURCES_DIR.concat("upload\\");
    ChromeDriver webDriver;
    @BeforeSuite
    protected final void setupTestSuite(){
//        cleanDirectory(SCREENSHOTS_DIR);
//        cleanDirectory(REPORTS_DIR);
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
        protected final void setUpTest(){
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterMethod
//    public void afterMethod() {
//        webDriver.close();
//    }
}
