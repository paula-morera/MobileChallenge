package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import org.openqa.selenium.By;

public class SearchScreen extends BaseMobileScreen {

    private By searcBarBy = By.id("com.imdb.mobile:id/search_plate");
    private String movieSelector = "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\").index(";
    public SearchScreen() {
        super();
    }

    public SearchScreen searchMovie(String movie){
        findMobileElement(searcBarBy).sendKeys(movie);
        return this;
    }

    public MovieScreen selectMovie(int index){
        movieSelector=movieSelector+Integer.toString(index)+")";
        findMobileElement(movieSelector).click();
        return new MovieScreen();
    }
}
