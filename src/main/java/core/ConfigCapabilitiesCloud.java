package core;

import org.openqa.selenium.remote.DesiredCapabilities;

import static core.ReadJson.getJson;

public class ConfigCapabilitiesCloud {
    private static final String DEVICE_NAME = "deviceNameCloud";
    private static final String PLATFORM_NAME = "platformName";
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String APP = "app";

    private static final String JSON_FILE_PATH = "src/main/resources/Capabilities.json";

    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability("deviceName", getJson(DEVICE_NAME,JSON_FILE_PATH));
        capabilities.setCapability("platformName", getJson(PLATFORM_NAME,JSON_FILE_PATH));
        capabilities.setCapability("appPackage", getJson(APP_PACKAGE,JSON_FILE_PATH));
        capabilities.setCapability("appActivity", getJson(APP_ACTIVITY,JSON_FILE_PATH));
        capabilities.setCapability("platformVersion",getJson(PLATFORM_VERSION,JSON_FILE_PATH));
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app","storage:"+getJson(APP,JSON_FILE_PATH));
    }
    public static DesiredCapabilities getCapabilities(){
        if(capabilities.toJson().isEmpty()){
            ConfigCapabilitiesCloud.ApplicationSetUp(capabilities);
        }
        return capabilities;
    }


}
