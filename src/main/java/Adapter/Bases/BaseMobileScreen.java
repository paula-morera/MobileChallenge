package Adapter.Bases;

import Core.ConfigCapabilities;
import Core.MobileAppDriver;
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

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private AndroidElement androidElement;

    public BaseMobileScreen()  {
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        wait = new WebDriverWait(driver,30);
        initElements();
    }

    private void initElements(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Ok\")")
    public AndroidElement OkButton;

    public BaseMobileScreen findMobileElement(By locator){
        androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public BaseMobileScreen findMobileElement(String selector){
        androidElement = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator(selector)));
        return this;
    }

    public List<AndroidElement> findMobileElements(By locator){
        return driver.findElements(locator);
    }
    public List<AndroidElement> findMobileElements(String selector){
        return driver.findElementsByAndroidUIAutomator("");
    }


    public AndroidElement getAndroidElement() {
        return androidElement;
    }

    public Boolean elementExist(By locator){
        WebDriverWait innerWait = new WebDriverWait(driver, 5);
        innerWait.ignoring(TimeoutException.class);
        innerWait.ignoring(WebDriverException.class);
        try{
            return innerWait.until(innerDriver-> driver.findElements(locator).size()>0);
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
}


