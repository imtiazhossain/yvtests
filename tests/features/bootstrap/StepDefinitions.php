<?php
use Constants\Selectors;

require "vendor/autoload.php";
/**
 * Created by PhpStorm.
 * User: imtiazhossain
 * Date: 12/3/15
 * Time: 10:51 AM
 */
class StepDefinitions extends FeatureContext
{
    /**
     * @When I click on the explore link
     */
    public function iClickOnTheExploreLink()
    {
        $link = $this->getSession()->getDriver()->click(Selectors::$exploreButton);

//        $this->clickOnTheElementWithCSSSelector(".header-content-navlist > li:nth-of-type(2)");
    }

    /**
     * @When I fill in password
     */
    public function iFillInPassword()
    {
        $input = $this->getSession()->getPage()->find('xpath', "//*[@id=\"loginForm\"]/input[2]");
        $input->setValue("12345");
    }

    /**
     * @When I click New Tour
     */
    public function iClickNewTour()
    {
        $this->waitForAjax();
        $this->clickOnTheElementWithCSSSelector("#gridview > a");
    }

    /**
     * @When I select :arg1 from Tour Type
     */
    public function iSelectFromTourType($arg1)
    {
        $this->clickOnTheElementWithCSSSelector("#tour-type-select");
        $this->clickOnTheElementWithCSSSelector("#location-info > div > ul.tour-type-primary.open > li.other-btn > span");
        $this->clickOnTheElementWithCSSSelector("#location-info > div > ul.tour-type-secondary.open > li:nth-of-type(4)");
//        $this->pressButton("CREATE TOUR");
    }

}