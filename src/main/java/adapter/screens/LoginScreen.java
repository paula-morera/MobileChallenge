package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pmw.tinylog.Logger;

public class LoginScreen extends BaseMobileScreen{
    private By skipBy = By.id("com.imdb.mobile:id/splash_not_now");
    private By signInIMDBby = By.id("com.imdb.mobile:id/google_oauth");
    private By accountBy = By.id("com.google.android.gms:id/select_dialog_listview");
    private By okAccountBy = By.id("android:id/button1");
    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void skipSingIn(){
        Logger.info("Skipping sing in");
        findMobileElement(skipBy).click();
        waitForHome();
    }

    public void signWithGoogle(){
        Logger.info("Sing in with google account");
        findMobileElement(signInIMDBby).click();
        waitForHome();
    }

    public LoginScreen selectAccount(){
        Logger.info("Selecting account to sing in");
        findMobileElement(accountBy).click();
        findMobileElement(okAccountBy).click();
        return this;
    }
}
