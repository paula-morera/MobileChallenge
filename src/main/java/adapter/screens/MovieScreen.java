package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;


public class MovieScreen extends BaseMobileScreen {
    private By overviewBy = By.id("com.imdb.mobile:id/plot_overview");
    private By addReviewButtonBy = By.xpath("//android.widget.TextView[@text=\"Rate\"]");
    private String addToWatchlist = "new UiScrollable(new UiSelector().resourceIdMatches(\".*main_content\")).scrollForward().scrollIntoView(new UiSelector().resourceIdMatches(\"com.imdb.mobile:id/state_off\"))";
    private String scrollReviews = "new UiScrollable(new UiSelector().resourceIdMatches(\".*main_content\")).scrollForward().scrollIntoView(new UiSelector().text(\"From top reviewers\"))";
    private String scrollGenres = "new UiScrollable(new UiSelector().resourceIdMatches(\".*genres_list\")).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"%s\"))";

    public MovieScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Getting overview of movie")
    public String getOverview(){
        Logger.info("Getting overview of movie");
        return findMobileElement(overviewBy).getAndroidElement().getText();
    }

    @Step("Adding movie to watchlist")
    public MovieScreen addToList(){
        Logger.info("Adding movie to watchlist");
        findMobileElement(addToWatchlist).click();
        return this;
    }

    @Step("Scrolling to reviews")
    public MovieScreen scrollUserReviews(){
        Logger.info("Scrolling to reviews");
        findMobileElement(scrollReviews);
        return this;
    }

    @Step("Click rate button")
    public RateScreen rateMovie(){
        Logger.info("Click rate button");
        findMobileElement(addReviewButtonBy).click();
        return new RateScreen(driver);
    }

    @Step("Verify genre in movie")
    public Boolean isGenreInMovie(String genre){
        Logger.info("Verifying genre "+genre+" in movie");
        return elementExist(String.format(scrollGenres,genre));
    }

}
