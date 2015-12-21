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
        $this->clickByCSS("#container > header > nav > ul > li:nth-of-type(4) > div");
    }

    /**
     * @Given I click sign in
     */
    public function iClickSignIn()
    {
        sleep(2);
        $this->clickByCSS("#signin > a");
    }

    /**
     * @Given I fill in id
     */
    public function iFillInId()
    {
        $this->fillField('identifier', "qa@youvisit.com");
    }

    /**
     * @When I fill in password
     */
    public function iFillInPassword()
    {
        $input = $this->getSession()->getPage()->find('xpath', "//*[@id=\"loginForm\"]/input[2]");
        $input->setValue("12345");
    }


}