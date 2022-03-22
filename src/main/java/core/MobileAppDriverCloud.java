package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static core.ConfigRegion.region;
import static core.ReadJson.getJson;

public class MobileAppDriverCloud {
    private static final String JSON_CREDENTIALS_FILE_PATH = "src/main/resources/Credentials.json";

    private static final String USERNAME = "username";
    private static final String ACCESS_KEY = "accessKey";

    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver getMoviesAppCloudDriver(DesiredCapabilities capabilities) {
        String sauceUrl;
        String username = getJson(USERNAME,JSON_CREDENTIALS_FILE_PATH);
        String accessKey = getJson(ACCESS_KEY,JSON_CREDENTIALS_FILE_PATH);
        URL url;
        if(region.equalsIgnoreCase("eu")){
            sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";
        }else{
            sauceUrl = "@ondemand.us-west-1.saucelabs.com:443";
        }
        String SAUCE_REMOTE_URL = "https://" + username + ":" + accessKey + sauceUrl + "/wd/hub";
        try {
            url = new URL(SAUCE_REMOTE_URL);
            driver = new AndroidDriver(url, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
