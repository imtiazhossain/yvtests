<?php
use Behat\Mink\Driver\Selenium2Driver;
/**
 * Created by PhpStorm.
 * User: imtiazhossain
 * Date: 12/4/15
 * Time: 2:38 PM
 */
class DeleteTour extends LogIn
{
    /**
     * @Given I created a Tour and I am on the profile page
     */
    public function iCreatedATourAndIAmOnTheProfilePage()
    {
    }

    /**
     * @When I click the delete button
     */
    public function iClickTheDeleteButton()
    {
        $tester = '#delete-dialog > span.button.primary.deletetour_action';
        $driver = $this->getSession();
        if ($driver instanceof Selenium2Driver) {
            $driver->wait(5000, );
        }
        $this->hoverOverTheElement("#gridview > div > form > div.tour");
        $this->clickOnTheElementWithCSSSelector("#gridview > div > form > div.tour > div.actions > div.delete-button.action.icon-button");

        $test = "#delete-dialog > span.button.primary.deletetour_action";
        $driver = $this->getSession()->getDriver();
        if ($driver instanceof Selenium2Driver) {
            $driver->wait(5000, $test);
        }
        $this->clickOnTheElementWithCSSSelector($test);
    }

    /**
     * @Then the deleted Tour should no longer be present
     */
    public function theDeletedTourShouldNoLongerBePresent()
    {
    }

}