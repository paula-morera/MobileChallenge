package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import org.openqa.selenium.By;

public class GlobalNavigationScreen extends BaseMobileScreen {

    private By homeBy = By.id("com.imdb.mobile:id/navigation_home");
    private By searchBy = By.id("com.imdb.mobile:id/navigation_search_browse");
    private By videoBy = By.id("com.imdb.mobile:id/navigation_video");
    private By youBy = By.id("com.imdb.mobile:id/navigation_you");

    public GlobalNavigationScreen(){
        super();
    }

    public void goToHome(){
        findMobileElement(homeBy).click();
    }

    public void goToSearch(){
        findMobileElement(searchBy).click();
    }

    public void goToVideo(){
        findMobileElement(videoBy).click();
    }

    public void goToYou(){
        findMobileElement(youBy).click();
    }
}
