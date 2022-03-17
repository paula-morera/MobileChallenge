package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.pmw.tinylog.Logger;

import java.time.Duration;

public class MovieScreen extends BaseMobileScreen {
    private By overviewBy = By.id("com.imdb.mobile:id/plot_overview");
    private By contentScreenBy = By.id("com.imdb.mobile:id/main_content_scroller");
    private By addReviewButtonBy = By.xpath("//android.widget.TextView[@text=\"Rate\"]");
    private String addToWatchlist = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollIntoView(new UiSelector().resourceIdMatches(\"com.imdb.mobile:id/state_off\"))";
    private String scrollReviews = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollIntoView(new UiSelector().text(\"From top reviewers\"))";

    public MovieScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getOverview(){
        Logger.info("Getting overview of movie");
        return findMobileElement(overviewBy).getAndroidElement().getText();
    }

    public MovieScreen addToList(){
        Logger.info("Adding movie to watchlist");
        findMobileElement(addToWatchlist).click();
        return this;
    }

    public MovieScreen scrollUserReviews(){
        Logger.info("Scrolling to reviews");
        findMobileElement(scrollReviews);
        return this;
    }

    public RateScreen rateMovie(){
        Logger.info("Click rate button");
        findMobileElement(addReviewButtonBy).click();
        return new RateScreen(driver);
    }


}
