package IskilloTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.apache.commons.io.FileUtils.cleanDirectory;

public class TestObject {
    public static final String TEST_RESOURCES_DIR = "src\\test\\resources\\";
    public static final String SCREENSHOTS_DIR = TEST_RESOURCES_DIR.concat("screenshots\\");
    public static final String UPLOAD_DIR = TEST_RESOURCES_DIR.concat("upload\\");
    ChromeDriver webDriver;

    @BeforeSuite
    protected final void setupTestSuite() throws IOException {
        cleanDirectory(new File(SCREENSHOTS_DIR));

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        takeScreenshot(testResult);
        //webDriver.close();
    }

    private void takeScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
                File screeshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String testName = testResult.getName();
                FileUtils.copyFile(screeshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                System.out.println("Unable to create a screenshot file: " + e.getMessage());
            }
        }
    }
}
