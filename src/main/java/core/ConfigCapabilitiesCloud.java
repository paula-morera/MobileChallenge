package core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pmw.tinylog.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ConfigCapabilitiesCloud {
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String APP = "appName";
    private static final String USERNAME = "username";
    private static final String ACCESS_KEY = "accessKey";
    private static final String REGION = "region";

    private static final String JSON_FILE_PATH = "src/main/resources/CapabilitiesCloud.json";
    private static final String JSON_CREDENTIALS_FILE_PATH = "src/main/resources/Credentials.json";

    private static AndroidDriver<AndroidElement> driver;
    private static JsonParser parser = new JsonParser();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,getJsonDataProperty(PLATFORM_VERSION));
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"storage:filename="+getJsonDataProperty(APP));
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
    public static DesiredCapabilities getCapabilitiesCloud(){
        if(capabilities.toJson().isEmpty()){
            ConfigCapabilities.ApplicationSetUp(capabilities);
        }
        return capabilities;
    }

    public static AndroidDriver<AndroidElement> getMoviesAppDriver(DesiredCapabilities capabilities)  {
        String sauceUrl;
        if(getJsonDataProperty(REGION).equalsIgnoreCase("eu")){
            sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";
        }else{
            sauceUrl = "@ondemand.us-west-1.saucelabs.com:443";
        }
        String SAUCE_REMOTE_URL = "https://"+ getJsonCredentials(USERNAME)+
                ":"+getJsonCredentials(ACCESS_KEY)+sauceUrl+"/wd/gub";
        try {
            driver = new AndroidDriver<AndroidElement>(new URL(SAUCE_REMOTE_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}