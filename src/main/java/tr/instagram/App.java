package tr.instagram;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App {

    WebDriver driver;
    String BASE_URL = "https://www.instagram.com/";

    By userNameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator = new By.ByCssSelector("button[type='submit']");
    By instagramLogoLocater = new By.ByClassName("_aagx");
    By firstPostLocater = new By.ByClassName("_aagu");
    By likeButton = new By.ByClassName("_aamw");
    By infoLocator = new By.ByClassName("_ac2a");
    By htmlTag =  By.tagName("html");

    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public App(){
      ChromeOptions options = new ChromeOptions();
      options.addArguments("start-maximized");
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(options);
      driver.get(BASE_URL);
    }

    public void loginWith(String username, String password){
        waitFor(userNameLocator);
        driver.findElement(userNameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        waitFor(instagramLogoLocater);

    }

    public void navigateToTargetProfile(String profileName){
        driver.navigate().to(BASE_URL.concat(profileName));
    }

    public void clickFirstPost(){
        waitFor(firstPostLocater);
        driver.findElements(firstPostLocater).get(0).click();
    }

    public void likePost(int count){
        while (count > 1){
            driver.findElement(likeButton).click();
            driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
            count --;
        }
    }

    public int getPostCount(){
        String count = driver.findElements(infoLocator).get(0).getText();
        return Integer.parseInt(count);
    }





}
