package tests;

import adapter.bases.BaseMobileCloudTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCloudEmulator extends BaseMobileCloudTest {

    @Test
    public void movieDescription(){
        globalNavigationScreen.goToSearch();
        searchScreen.typeMovie("Fight club")
                    .selectMovie(0);
        Assert.assertEquals("An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more."
                ,movieScreen.getOverview());
    }
}
