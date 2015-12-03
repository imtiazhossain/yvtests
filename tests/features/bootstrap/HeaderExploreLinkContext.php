<?php
use Constants\Selectors;

require "vendor/autoload.php";
/**
 * Created by PhpStorm.
 * User: imtiazhossain
 * Date: 12/3/15
 * Time: 10:51 AM
 */
class HeaderExploreLinkContext extends FeatureContext
{

    /**
     * @When I click on the explore link
     */
    public function iClickOnTheExploreLink()
    {
        $link = $this->getSession()->getDriver()->click(Selectors::$exploreButton);

//        $this->clickOnTheElementWithCSSSelector(".header-content-navlist > li:nth-of-type(2)");
    }
}