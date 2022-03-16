package tests;

import adapter.bases.BaseMobileTest;
import org.testng.annotations.Test;


public class MyTest extends BaseMobileTest {

    @Test
    public void movieDescription(){
        loginScreen.skipSingIn();
        globalNavigationScreen.goToSearch();
        searchScreen.searchMovie("Fight club")
                .selectMovie(0);
        System.out.println(movieScreen.getOverview());
        //Assert.assertEquals("",movieScreen.getOverview());
    }

    @Test
    public void watchList(){
        loginScreen.signWithGoogle()
                .selectAccount();
        searchScreen.searchMovie("Fight club")
                .selectMovie(0);
        movieScreen.addToList();
        globalNavigationScreen.goToYou();
        youScreen.watchList();
    }
}


