package core;

import static core.ConfigRegion.region;

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

public class MobileAppDriver {

    private static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> getMoviesAppDriver(DesiredCapabilities capabilities)  {
            try {
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        return driver;
    }

}
