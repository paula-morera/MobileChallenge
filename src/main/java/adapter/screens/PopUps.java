package adapter.screens;

import adapter.bases.BaseMobileScreen;
import org.openqa.selenium.By;

public class PopUps extends BaseMobileScreen {

    private By denyBy = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private By thisTimeBy = By.id("com.android.permissioncontroller:id/permission_deny_button");
    private By whileUsingBy = By.id("com.android.permissioncontroller:id/permission_allow_one_time_button");
    private By okBy = By.id("android:id/button2");

    public PopUps() {
        super();
    }

    public PopUps denyLocation(){
        findMobileElement(denyBy).click();
        return this;
    }
    public PopUps thisTimeLocation(){
        findMobileElement(thisTimeBy).click();
        return this;
    }
    public PopUps whileUsingLocation(){
        findMobileElement(whileUsingBy).click();
        return this;
    }
    public PopUps acceptNotiicacion(){
        findMobileElement(okBy).click();
        return this;
    }
}
