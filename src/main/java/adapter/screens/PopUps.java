package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class PopUps extends BaseMobileScreen {

    private By denyBy = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private By thisTimeBy = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private By whileUsingBy = By.id("com.android.permissioncontroller:id/permission_allow_one_time_button");
    private By okBy = By.id("android:id/button2");

    public PopUps(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Deny location")
    public PopUps denyLocation(){
        Logger.info("Deny location");
        findMobileElement(denyBy).click();
        return this;
    }

    @Step("Accept location this time")
    public PopUps acceptThisTimeLocation(){
        Logger.info("Accept location this time");
        findMobileElement(thisTimeBy).click();
        return this;
    }

    @Step("Accept location while using")
    public PopUps acceptWhileUsingLocation(){
        Logger.info("Accept location while using");
        findMobileElement(whileUsingBy).click();
        return this;
    }

    @Step("Accept notifications")
    public PopUps acceptNotification(){
        Logger.info("Accept notifications");
        findMobileElement(okBy).click();
        return this;
    }
}
