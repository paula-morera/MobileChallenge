package adapter.bases;


import adapter.screens.*;
import core.ConfigCapabilities;
import core.ConfigCapabilitiesCloud;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;


public class BaseMobileTest {
    private AndroidDriver<AndroidElement> driver;
    public PopUps popUps;
    public GlobalNavigationScreen globalNavigationScreen;
    public MovieScreen movieScreen;
    public SearchScreen searchScreen;
    public LoginScreen loginScreen;
    public YouScreen youScreen;
    public WatchlistScreen watchlistScreen;
    public RateScreen rateScreen;
    public GenreScreen genreScreen;

    @BeforeSuite(alwaysRun = true)
    public void SetUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        globalNavigationScreen = new GlobalNavigationScreen(driver);
        loginScreen = new LoginScreen(driver);
        searchScreen = new SearchScreen(driver);
        movieScreen = new MovieScreen(driver);
        youScreen = new YouScreen(driver);
        watchlistScreen = new WatchlistScreen(driver);
        rateScreen = new RateScreen(driver);
        genreScreen = new GenreScreen(driver);
        popUps = new PopUps(driver);
        popUps.denyLocation();
        popUps.acceptNotification();
        loginScreen.signWithGoogle();
    }

    @AfterMethod
    public void verifyFail(ITestResult result){
        if(!result.isSuccess()){
            Allure.addAttachment("Failed screenshot on "+ result.getMethod(),new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @AfterSuite(alwaysRun = true)
    public void TearDown()
    {
        if(driver!=null){
            driver.quit();
        }
    }
}



