package adapter.bases;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseMobileScreen {

    protected AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private AndroidElement androidElement;
    private By homeElementBy = By.id("com.imdb.mobile:id/video_hero_view");
    private String scroll = "new UiScrollable(.scrollable(true)).scrollToBeginning(1)";

    public BaseMobileScreen(AndroidDriver<AndroidElement> driver)  {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Ok\")")
    public AndroidElement OkButton;

    public BaseMobileScreen findMobileElement(By locator){
        androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public BaseMobileScreen findMobileElement(String selector){
        androidElement = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(MobileBy.AndroidUIAutomator(selector))));
        return this;
    }

    public List<AndroidElement> findMobileElements(By locator){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }
    public List<AndroidElement> findMobileElements(String selector){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.AndroidUIAutomator(selector))));
        return driver.findElements(MobileBy.AndroidUIAutomator(selector));
    }

    public AndroidElement getAndroidElement() {
        return androidElement;
    }

    public Boolean elementExist(By locator){
        WebDriverWait innerWait = new WebDriverWait(driver, 5);
        innerWait.ignoring(TimeoutException.class);
        innerWait.ignoring(WebDriverException.class);
        try{
            return innerWait.until(innerDriver-> findMobileElements(locator).size()>0);
        }catch (Exception e){
            return false;
        }
    }

    public Boolean elementExist(String selector){
        WebDriverWait innerWait = new WebDriverWait(driver, 5);
        innerWait.ignoring(TimeoutException.class);
        innerWait.ignoring(WebDriverException.class);
        try{
            return innerWait.until(innerDriver-> findMobileElements(selector).size()>0);
        }catch (Exception e){
            return false;
        }
    }

    public BaseMobileScreen click(){
        androidElement.click();
        return this;
    }

    public BaseMobileScreen clear(){
        androidElement.clear();
        return this;
    }

    public BaseMobileScreen sendKeys(String text){
        androidElement.sendKeys(text);
        return this;
    }

    public BaseMobileScreen waitForHome(){
        findMobileElement(homeElementBy);
        return this;
    }
}



