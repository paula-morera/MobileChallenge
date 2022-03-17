package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class LoginScreen extends BaseMobileScreen{
    private By skipBy = By.id("com.imdb.mobile:id/splash_not_now");
    private By signInIMDBby = By.id("com.imdb.mobile:id/google_oauth");
    private By accountBy = By.id("com.google.android.gms:id/select_dialog_listview");
    private By okAccountBy = By.id("android:id/button1");
    private String skipCroll = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollIntoView(new UiSelector().text(\"NOT NOW\"))";

    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Skipping sing in")
    public void skipSingIn(){
        Logger.info("Skipping sing in");
        findMobileElement(skipCroll);
        findMobileElement(skipBy).click();
        waitForHome();
    }

    @Step("Sing in with google account")
    public void signWithGoogle(){
        Logger.info("Sing in with google account");
        findMobileElement(signInIMDBby).click();
        waitForHome();
    }

    @Step("Selecting account to sing in")
    public LoginScreen selectAccount(){
        Logger.info("Selecting account to sing in");
        findMobileElement(accountBy).click();
        findMobileElement(okAccountBy).click();
        return this;
    }
}
