package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class SearchScreen extends BaseMobileScreen {

    private By searchBarBy = By.id("com.imdb.mobile:id/search_src_text");
    private By moviesBy = By.id("com.imdb.mobile:id/holder");
    private String popularByGenre = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().scrollIntoView(new UiSelector().text(\"Most popular by genre\"))";
    private String genresBy = "new UiScrollable(new UiSelector().resourceIdMatches(\".*list\")).scrollForward().scrollIntoView(new UiSelector().text(\"%s\"))";


    public SearchScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Typing movie in search bar")
    public SearchScreen typeMovie(String movie){
        Logger.info("Typing movie "+movie+" en search bar");
        findMobileElement(searchBarBy).click();
        findMobileElement(searchBarBy).sendKeys(movie);
        return this;
    }

    @Step("Selecting movie in results")
    public String selectMovie(int index){
        AndroidElement movie = findMobileElements(moviesBy).get(index);
        String title = movie.getText();
        Logger.info("Selecting movie" + title);
        movie.click();
        return title;
    }

    @Step("Clicking in popular movies by genre")
    public SearchScreen popularMoviesByGenre(){
        findMobileElement(popularByGenre).click();
        return this;
    }

    @Step("Selecting genre")
    public GenreScreen selectingGenre(String genre){
        Logger.info("Selecting genre "+genre);
        findMobileElement(String.format(genresBy,genre)).click();
        return new GenreScreen(driver);
    }
}
