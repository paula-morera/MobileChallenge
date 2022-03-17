package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class YouScreen extends BaseMobileScreen {
    private By watchListBy = By.id("com.imdb.mobile:id/see_all");
    public YouScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Clicking in watchlist")
    public void watchList(){
        Logger.info("Clicking in watchlist");
        findMobileElement(watchListBy).click();
    }
}
