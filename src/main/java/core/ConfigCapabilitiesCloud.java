package core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pmw.tinylog.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static core.ConfigRegion.region;

public class ConfigCapabilitiesCloud {
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String APP = "app";
    private static final String USERNAME = "username";
    private static final String ACCESS_KEY = "accessKey";
    private static final String JSON_CREDENTIALS_FILE_PATH = "src/main/resources/Credentials.json";

    private static AndroidDriver<AndroidElement> driver;

    private static final String JSON_FILE_PATH = "src/main/resources/CapabilitiesCloud.json";

    private static JsonParser parser = new JsonParser();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability("deviceName", getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability("platformName", getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
        capabilities.setCapability("platformVersion",getJsonDataProperty(PLATFORM_VERSION));
        //capabilities.setCapability("appWaitActivity", "com.imdb.mobile.HomeActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app","storage:"+getJsonDataProperty(APP));
    }
    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            Logger.error(e.getMessage(), e);
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        return "";
    }
    public static DesiredCapabilities getCapabilitiesCloud(){
        if(capabilities.toJson().isEmpty()){
            ConfigCapabilitiesCloud.ApplicationSetUp(capabilities);
        }
        return capabilities;
    }
    public static AndroidDriver getMoviesAppCloudDriver(DesiredCapabilities capabilities) {
        String sauceUrl;
        String username =getJsonCredentials(USERNAME);
        String accessKey = getJsonCredentials(ACCESS_KEY);
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
    private static String getJsonCredentials(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_CREDENTIALS_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            Logger.error(e.getMessage(), e);
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        return "";
    }
}
