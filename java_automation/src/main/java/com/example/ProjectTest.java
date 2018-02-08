package com.example;

import org.testng.annotations.*;

public class ProjectTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }

    @Test
    public void findingASiteOnGoogleUiddb50ca56a3134b7c834198e8d1ab4ada() {
        // Given I open "http://google.com"
        actionwords.iOpenP1("http://google.com");
        // When I search for "Hiptest"
        actionwords.iSearchForP1("Hiptest");
        // Then a link to "Hiptest: Agile test management tool & behavior driven development" is shown in the results
        actionwords.aLinkToP1IsShownInTheResults("Hiptest: Agile test management tool & behavior driven development");
    }
}
