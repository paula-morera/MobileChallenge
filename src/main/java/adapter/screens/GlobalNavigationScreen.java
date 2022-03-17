package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class GlobalNavigationScreen extends BaseMobileScreen {

    private By homeBy = By.id("com.imdb.mobile:id/navigation_home");
    private By searchBy = By.id("com.imdb.mobile:id/navigation_search_browse");
    private By videoBy = By.id("com.imdb.mobile:id/navigation_video");
    private By youBy = By.id("com.imdb.mobile:id/navigation_you");

    public GlobalNavigationScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Go to Home page")
    public void goToHome(){
        Logger.info("Go to Home page");
        findMobileElement(homeBy).click();
    }

    @Step("Go to Search page")
    public void goToSearch(){
        Logger.info("Go to Search page");
        findMobileElement(searchBy).click();
    }

    @Step("Go to Video page")
    public void goToVideo(){
        Logger.info("Go to Video page");
        findMobileElement(videoBy).click();
    }

    @Step("Go to You page")
    public void goToYou(){
        Logger.info("Go to You page");
        findMobileElement(youBy).click();
    }


}
