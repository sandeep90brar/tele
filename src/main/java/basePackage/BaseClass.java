package basePackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {
    public ChromeDriver driver;
    String fileWithPath="C:\\Users\\sande\\Desktop\\Training\\Selenium\\Screenshot\\";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
    public void openUrl(String url){
        driver.get(url);
    }
    public void openBrowser(String nameBrowser) {
        if(nameBrowser.equals("Chrome")){

        } else if (nameBrowser.equals("IE")) {

        } else if (nameBrowser.equals("Firefox")) {

        }else {
            System.out.println("Browser name is not correct.");
        }
    }
public void clickElement(WebElement elememt){
        elememt.click();
}
    public void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void waitForElement() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

}
public void waitForElementPresent(WebElement element){
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
    wait.until(ExpectedConditions.visibilityOf(element));

}
public void scrollToElement(WebElement element){
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView(false);", element);
    }
public void takeScreenshot(String name){
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
    Date date = new Date();
    TakesScreenshot scrShot = ((TakesScreenshot) driver);
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File DestFile = new File(fileWithPath + name + "_" + formatter.format(date) + ".png");
    try {
        FileUtils.copyFile(SrcFile, DestFile);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    public void selectFromDropdown1(WebElement element, String text) {
        Select dropdown = new Select(element);
        element.click();
        dropdown.selectByVisibleText(text);
}
    public void mouseMoveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
}
}
