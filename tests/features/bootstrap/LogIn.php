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
     * @Given I log in
     */
    public function iLogIn()
    {
        $this->iClickOnTheLogInButton();
        sleep(2);
        $this->iFillInId();
        $this->iFillInPassword();
    }

    /**
     * @Given I click on the log in button
     */
    public function iClickOnTheLogInButton()
    {
        $this->clickByCSS("#container > header > nav > ul.header-content-login > li:nth-child(1) > div");
    }

//    /**
//     * @Given I click sign in
//     */
//    public function iClickSignIn()
//    {
//        sleep(2);
//        $this->clickByCSS("#signin > a");
//    }

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