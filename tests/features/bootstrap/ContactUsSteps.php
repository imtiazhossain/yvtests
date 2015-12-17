<?php

/**
 * Created by PhpStorm.
 * User: imtiazhossain
 * Date: 12/16/15
 * Time: 2:39 PM
 */
class ContactUsSteps extends TourSteps
{
    /**
     * @When I fill in fullname
     */
    public function iFillInFullname()
    {
//        $this->findByCSS(".infopage-form-container > #submitForm > [name=name]")->setValue("QA Tester");
        $this->test('css', ".infopage-form-container > #submitForm > [name=name]");
    }

    public function test($selector, $locator){
        $this->getSession()->getPage()->waitFor(100000, $this->getSession()->getPage()->find($selector, $locator));
    }

    /**
     * @When I fill in email
     */
    public function iFillInEmail()
    {
        $this->findByCSS(".infopage-form-container > #submitForm > [name=email]")->setValue("qa@youvisit.com");
    }

    /**
     * @When I fill in phone
     */
    public function iFillInPhone()
    {
        $this->findByCSS(".infopage-form-container > #submitForm > [name=phone]")->setValue("555-555-555");
    }

    /**
     * @When I fill in message
     */
    public function iFillInMessage()
    {
        $this->findByCSS(".infopage-form-container > #submitForm > [name=message]")->setValue("This is a test");
    }

    /**
     * @When I click the Send button
     */
    public function iClickSend()
    {
        $this->clickByCSS(".infopage-form-container > #submitForm > #submitBtn");
    }
}