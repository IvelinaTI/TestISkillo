package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    private final WebDriver webDriver;
    public Header(WebDriver driver){
        this.webDriver = driver;
    }

    public void clickLogin(){
        WebElement login = this.webDriver.findElement(By.id("nav-link-login"));
        login.click();
    }
    public void clickHome(){
        WebElement home = this.webDriver.findElement(By.id("nav-link-home"));
        home.click();
    }
    public void clickProfile(){
        WebElement profile = this.webDriver.findElement(By.id("nav-link-profile"));
        profile.click();
    }
    public void LogOut(){
        WebElement logOutButton = this.webDriver.findElement(By.xpath("//div[@id='navbarColor01']//i[@class='fas fa-sign-out-alt fa-lg']"));
        logOutButton.click();
    }
}
