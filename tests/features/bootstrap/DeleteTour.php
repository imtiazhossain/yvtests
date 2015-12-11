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
        sleep(1);
        $this->hoverOver("#gridview > div > form > div.tour");
        $this->clickByCSSSelector("#gridview > div > form > div.tour > div.actions > div.delete-button.action.icon-button");
        sleep(1);
        $this->clickByCSSSelector("#delete-dialog > span.button.primary.deletetour_action");
    }

    /**
     * @Then the deleted Tour should no longer be present
     */
    public function theDeletedTourShouldNoLongerBePresent()
    {
    }

}