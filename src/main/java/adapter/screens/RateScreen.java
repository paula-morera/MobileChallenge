package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;
import org.testng.SkipException;

public class RateScreen extends BaseMobileScreen {
    private By rateScoresBy = By.xpath("//android.widget.ImageView[contains(@resource-id,\"star\")]");
    private By submitButtonBy = By.id("com.imdb.mobile:id/rate_title_button");
    private By submissionMessageBy = By.xpath("//android.widget.TextView[contains(@text,\"Rating saved\")]");

    public RateScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Step("Selecting rate score")
    public RateScreen selectingRate(int score){
        Logger.info("Rating the movie with "+score);
        if(score>=1 && score<=10){
            findMobileElements(rateScoresBy).get(score-1).click();
            return this;
        }else {
            Logger.error("Invalid score");
            throw new SkipException("Skipping test");
        }
    }

    @Step("Submitting rate")
    public RateScreen submitRate(){
        Logger.info("Submitting rate");
        findMobileElement(submitButtonBy).click();
        return this;
    }

    @Step("Verifying submission")
    public Boolean isSubmit(){
        Logger.info("Verifying submission");
        return elementExist(submissionMessageBy);
    }
}
