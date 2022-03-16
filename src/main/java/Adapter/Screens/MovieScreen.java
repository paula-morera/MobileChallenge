package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class MovieScreen extends BaseMobileScreen {
    private By overviewBy = By.id("com.imdb.mobile:id/plot_overview");
    private By addToListBy = By.id("com.imdb.mobile:id/state_off");

    public MovieScreen() {
        super();
    }

    public String getOverview(){
        return findMobileElement(overviewBy).getAndroidElement().getText();
    }

    public void addToList(){
        findMobileElement(addToListBy).click();
    }
}
