# Mobile Automation with Appium Challenge
Mobile Testing with Appium Challenge for Endava interns

Following the scenarios in the guide I used Appium to create 
a server that allows me to connect with a mobile emulator created in 
Android Studio. And for the Maven project I decided to use the 
repository example, because it had the framework already with the 
configuration for the page object model and configuration for different
aspects of the project, such us the suite xml file, the capabilities
configuration, the bases classes, everything in an organized and 
easy to understand appearance.

Before the suite is executed there is a setup procedure, that goes
from the capabilities configuration, the application launching,
and the basic configuration of location and login process. 

## Test scenarios

There are 4 test scenarios, the mandatory ones: of overview match, 
verification of a movie added to the watchlist and the rating of 
a movie, for the last two it was mandatory to be logged, so I chose
the option of sign in with Google account that is previously open
in the emulator. 

As an additional scenario I created one genre which goes 
like;

* Given the application IMDB
* Login into the application
* Click on search page
* And click on 'Most popular by genre'
* And click on any genre
* And click on any movie
* Then the genre must be in the genres of the movie

## Reporting 
As a reporting tool I used Allure, even if TestNG has it own 
reporting tool embedded, it isn't as visually attractive as Allure,
that allows an easier understanding of the obtained results in the
execution of a test or a suite. Also, it allows the incorporation of 
images inside the report, so for the screenshot capture upon the test
failure it's a useful tool to use. 

The screenshot capture is made through a verification os success after 
each method, if the method failed the capture will be attached to the 
allure report. 

## Cloud emulation
For teh could emulation I sed SauceLabs as service provider, it provides
an easy implementation for appium and capabilities configuration, reporting
of the steps in the execution, a realtime video of the execution, that 
later on is saved, and it has a good documentation. The only requirements
are an account and the .apk of the application. 