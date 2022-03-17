package adapter.bases;

import adapter.screens.*;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;

public class BaseMobileCloudTest {
    private AndroidDriver<AndroidElement> driver;
    public PopUps popUps;
    public GlobalNavigationScreen globalNavigationScreen;
    public MovieScreen movieScreen;
    public SearchScreen searchScreen;
    public LoginScreen loginScreen;
    public YouScreen youScreen;
    public WatchlistScreen watchlistScreen;
    public RateScreen rateScreen;

    @BeforeSuite(alwaysRun = true)
    public void SetUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        globalNavigationScreen = new GlobalNavigationScreen(driver);
        loginScreen = new LoginScreen(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
        popUps = new PopUps(driver);
        popUps.denyLocation();
        popUps.acceptNotificacion();
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
