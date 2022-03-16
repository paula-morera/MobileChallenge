package adapter.bases;


import adapter.screens.*;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.*;


public class BaseMobileTest {
    private AndroidDriver<AndroidElement> driver;
    public PopUps popUps;
    public GlobalNavigationScreen globalNavigationScreen;
    public MovieScreen movieScreen;
    public SearchScreen searchScreen;
    public LoginScreen loginScreen;
    public YouScreen youScreen;
    public WatchlistScreen watchlistScreen;

    @BeforeSuite(alwaysRun = true)
    public void SetUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        globalNavigationScreen = new GlobalNavigationScreen();
        loginScreen = new LoginScreen();
        searchScreen = new SearchScreen();
        movieScreen = new MovieScreen();
        youScreen = new YouScreen();
        watchlistScreen = new WatchlistScreen();
        popUps = new PopUps();
        popUps.denyLocation();
        popUps.acceptNotiicacion();
    }

    @AfterSuite(alwaysRun = true)
    public void TearDown()
    {
        if(driver!=null){
            driver.quit();
        }
    }
}



