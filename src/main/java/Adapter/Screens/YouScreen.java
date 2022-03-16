package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import org.openqa.selenium.By;

public class YouScreen extends BaseMobileScreen {
    private By watchListBy = By.id("com.imdb.mobile:id/see_all");
    public YouScreen() {
        super();
    }

    public void watchList(){
        findMobileElement(watchListBy).click();
    }
}
