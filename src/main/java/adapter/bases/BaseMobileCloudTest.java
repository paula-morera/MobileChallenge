package adapter.bases;

import adapter.screens.*;
import core.ConfigCapabilitiesCloud;
import core.MobileAppDriverCloud;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseMobileCloudTest {
    private AndroidDriver<AndroidElement> driver;
    public PopUps popUps;
    public GlobalNavigationScreen globalNavigationScreen;
    public MovieScreen movieScreen;
    public SearchScreen searchScreen;
    public LoginScreen loginScreen;

    @BeforeSuite(alwaysRun = true)
    public void SetUp(){
        driver = MobileAppDriverCloud.getMoviesAppCloudDriver(ConfigCapabilitiesCloud.getCapabilities());
        globalNavigationScreen = new GlobalNavigationScreen(driver);
        loginScreen = new LoginScreen(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
        popUps = new PopUps(driver);
        popUps.denyLocation();
        popUps.acceptNotification();
        loginScreen.skipSingIn();
    }

    @AfterSuite(alwaysRun = true)
    public void TearDown()
    {
        if(driver!=null){
            driver.quit();
        }
    }
}
