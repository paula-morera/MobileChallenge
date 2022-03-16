package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class WatchlistScreen extends BaseMobileScreen {
    private String moviesBy ="new UiSelector().resourceId(\"com.imdb.mobile:id/primaryText\")";

    List<AndroidElement> resultElements;
    public WatchlistScreen() {
        super();
    }

    public Boolean movieInWatchlist(String movie){
        resultElements = findMobileElements(moviesBy);
        for(AndroidElement element: resultElements){
            if(element.getText().toLowerCase()==movie.toLowerCase()){
                return true;
            }
        }
        return false;
    }
}
