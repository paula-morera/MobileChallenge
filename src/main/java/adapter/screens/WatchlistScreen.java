package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

import java.util.List;

public class WatchlistScreen extends BaseMobileScreen {
    private By moviesBy = By.id("com.imdb.mobile:id/primaryText");

    List<AndroidElement> resultElements;
    public WatchlistScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Verifying movie in watchlist")
    public Boolean isMovieInWatchlist(String movie){
        Logger.info("Verifying if "+movie+" is in watchlist");
        resultElements = findMobileElements(moviesBy);
        for(AndroidElement element: resultElements){
            if(element.getText().toLowerCase().contains(movie.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
