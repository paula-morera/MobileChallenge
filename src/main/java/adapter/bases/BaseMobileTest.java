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
        globalNavigationScreen = new GlobalNavigationScreen(driver);
        loginScreen = new LoginScreen(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
        youScreen = new YouScreen(driver);
        watchlistScreen = new WatchlistScreen(driver);
        popUps = new PopUps(driver);
        popUps.denyLocation();
        popUps.acceptNotificacion();
    }

    @AfterSuite(alwaysRun = true)
    public void TearDown()
    {
        if(driver!=null){
    //        driver.quit();
        }
    }
}



