package Tests;

import Adapter.Bases.BaseMobileTest;
import Adapter.Screens.YouScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyTest extends BaseMobileTest {

    @Test
    public void movieDescription(){
        loginScreen.SkipSingIn();
        globalNavigationScreen.goToSearch();
        searchScreen.searchMovie("Fight club")
                .selectMovie(0);
        System.out.println(movieScreen.getOverview());
        //Assert.assertEquals("",movieScreen.getOverview());
    }

    @Test
    public void watchList(){
        loginScreen.SignWithGoogle()
                .SelectAccount();
        searchScreen.searchMovie("Fight club")
                .selectMovie(0);
        movieScreen.addToList();
        globalNavigationScreen.goToYou();
        youScreen.watchList();
    }
}


