package tests;

import adapter.bases.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyTest extends BaseMobileTest {

    @Test
    public void movieDescription(){
        globalNavigationScreen.goToSearch();
        searchScreen.typeMovie("Fight club")
                    .selectMovie(0);
        Assert.assertEquals("An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more."
                          ,movieScreen.getOverview());
    }

    @Test
    public void watchList(){
        String movieAdded;
        globalNavigationScreen.goToSearch();
        movieAdded = searchScreen.typeMovie("Batman")
                                .selectMovie(0);
        movieScreen.addToList();
        globalNavigationScreen.goToYou();
        youScreen.watchList();
        Assert.assertTrue(watchlistScreen.isMovieInWatchlist(movieAdded));
    }

    @Test
    public void rateMovie(){
        globalNavigationScreen.goToSearch();
        searchScreen.typeMovie("Shutter island")
                .selectMovie(0);
        movieScreen.scrollUserReviews()
                .rateMovie();
        rateScreen.selectingRate(9)
                .submitRate();
        Assert.assertTrue(rateScreen.isSubmit());
    }

    @Test
    public void verifyGenre(){
        globalNavigationScreen.goToSearch();
        searchScreen.popularMoviesByGenre()
                .selectingGenre("Musical");
        genreScreen.selectMovie(2);
        Assert.assertTrue(movieScreen.isGenreInMovie("Musical"));
    }
}


