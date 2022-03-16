package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class SearchScreen extends BaseMobileScreen {

    private By searchBarBy = By.id("com.imdb.mobile:id/search_src_text");
    private By moviesBy = By.id("com.imdb.mobile:id/holder");
    public SearchScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public SearchScreen searchMovie(String movie){
        Logger.info("Searching for movie "+movie);
        findMobileElement(searchBarBy).click();
        findMobileElement(searchBarBy).sendKeys(movie);
        return this;
    }

    public String selectMovie(int index){
        AndroidElement movie = findMobileElements(moviesBy).get(index);
        String title = movie.getText();
        Logger.info("Selecting movie" + title);
        movie.click();
        return title;
    }
}
