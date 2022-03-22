package core;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static core.ReadJson.getJson;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "deviceNameLocal";
    private static final String PLATFORM_NAME = "platformName";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String JSON_FILE_PATH = "src/main/resources/Capabilities.json";

    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability("appPackage", getJson(APP_PACKAGE,JSON_FILE_PATH));
        capabilities.setCapability("appActivity", getJson(APP_ACTIVITY,JSON_FILE_PATH));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJson(DEVICE_NAME,JSON_FILE_PATH));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJson(PLATFORM_NAME,JSON_FILE_PATH));
        capabilities.setCapability("automationName", "UiAutomator2");
    }


    public static DesiredCapabilities getCapabilities(){
        if(capabilities.toJson().isEmpty()){
            ConfigCapabilities.ApplicationSetUp(capabilities);
        }
        return capabilities;
    }

}
