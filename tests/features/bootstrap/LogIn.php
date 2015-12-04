<?php

/**
 * Created by PhpStorm.
 * User: imtiazhossain
 * Date: 12/4/15
 * Time: 3:37 PM
 */
class LogIn extends StepDefinitions
{
    /**
     * @Given I click on the log in button
     */
    public function iClickOnTheLogInButton()
    {
        $this->clickOnTheElementWithCSSSelector("#container > header > nav > ul > li:nth-of-type(6) > div");
    }

}