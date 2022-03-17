package tests;

import adapter.bases.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyTest extends BaseMobileTest {

    @Test
    public void movieDescription(){
        globalNavigationScreen.goToSearch();
        searchScreen.searchMovie("Fight club")
                    .selectMovie(0);
        Assert.assertEquals("An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more."
                          ,movieScreen.getOverview());
    }

    @Test
    public void watchList(){
        String movieAdded;
        globalNavigationScreen.goToSearch();
        movieAdded = searchScreen.searchMovie("the little mermaid")
                                .selectMovie(0);
        movieScreen.addToList();
        globalNavigationScreen.goToYou();
        youScreen.watchList();
        Assert.assertTrue(watchlistScreen.isMovieInWatchlist(movieAdded));
    }

    @Test
    public void rateMovie(){
        globalNavigationScreen.goToSearch();
        searchScreen.searchMovie("shutter island")
                .selectMovie(0);
        movieScreen.scrollUserReviews()
                .rateMovie();
        rateScreen.selectingRate(9)
                .submitRate()
                .isSubmit();
    }

    @Test
    public void flow(){
        /*
        populares por genero
        genero
        escoger pelicula
        verificar genero
         */
    }
}


