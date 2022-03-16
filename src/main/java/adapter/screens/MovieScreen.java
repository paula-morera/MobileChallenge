package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.pmw.tinylog.Logger;

public class MovieScreen extends BaseMobileScreen {
    private By overviewBy = By.id("com.imdb.mobile:id/plot_overview");
    private By addToListBy = By.id("com.imdb.mobile:id/state_off");
    private By screenBy = By.id("com.imdb.mobile:id/main_content");

    public MovieScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getOverview(){
        Logger.info("Getting overview of movie");
        return findMobileElement(overviewBy).getAndroidElement().getText();
    }

    public void addToList(){
        Logger.info("Scrolling down");
        AndroidElement screen = findMobileElement(screenBy).getAndroidElement();
        TouchActions action = new TouchActions(driver);
        action.scroll(screen, 10, 100);
        action.perform();
        Logger.info("Adding movie to watchlist");
        findMobileElement(addToListBy).click();
    }
}
