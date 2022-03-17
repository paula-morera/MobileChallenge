package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class GenreScreen extends BaseMobileScreen {
    private By movies = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout");

    public GenreScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    @Step("Selecting movie in genre")
    public MovieScreen selectMovie(int index){
        Logger.info("Selecting the "+index +"th movie");
        findMobileElements(movies).get(index).click();
        return new MovieScreen(driver);
    }

}
