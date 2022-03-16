package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class YouScreen extends BaseMobileScreen {
    private By watchListBy = By.id("com.imdb.mobile:id/see_all");
    public YouScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void watchList(){
        findMobileElement(watchListBy).click();
    }
}
