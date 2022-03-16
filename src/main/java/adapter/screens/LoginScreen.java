package adapter.screens;

import adapter.bases.BaseMobileScreen;
import org.openqa.selenium.By;

public class LoginScreen extends BaseMobileScreen{
    private By skipBy = By.id("com.imdb.mobile:id/splash_not_now");
    private By signInIMDBby = By.id("com.imdb.mobile:id/google_oauth");
    private By accountBy = By.id("com.google.android.gms:id/select_dialog_listview");
    private By okAccountBy = By.id("android:id/button1");
    public LoginScreen() {
        super();
    }

    public void skipSingIn(){
        findMobileElement(skipBy).click();
    }

    public LoginScreen signWithGoogle(){
        findMobileElement(signInIMDBby).click();
        return this;
    }

    public LoginScreen selectAccount(){
        findMobileElement(accountBy).click();
        findMobileElement(okAccountBy).click();
        return this;
    }
}
