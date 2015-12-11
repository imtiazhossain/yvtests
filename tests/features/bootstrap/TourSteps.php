<?php

/**
 * Created by PhpStorm.
 * User: imtiazhossain
 * Date: 12/4/15
 * Time: 6:45 PM
 */
class TourSteps extends DeleteTour
{
    /**
     * @Given I edit a tour
     */
    public function iEditATour()
    {
        sleep(2);
        $this->hoverOver("#gridview > div > form > div.tour");
        sleep(1);
        $this->clickByCSSSelector("#gridview > div > form > div.tour > div.actions > div.rounded > div.edit-button.action.icon-button.icon-svg.dashed");
        sleep(5);
    }

    /**
     * @Given I click Add Stop
     */
    public function iClickAddStop()
    {
        $this->clickByCSSSelector("#stops > div.stop.add > span.title");
        sleep(5);
        $this->clickByCSSSelector("#stops > div.ng-isolate-scope > div.ui-sortable > div > div.stop.ng-isolate-scope.ui-droppable.selected > span.delete");
        sleep(3);
    }

//    /**
//     * @Given I click on Add Photo
//     */
//    public function iClickOnAddPhoto()
//    {
////        $this->clickByXPath("//*[@id=\"mediaBinContainer\"]/div[1]/ul/li[1]/div");
////        $location = "//*[@id=\"mediaBinContainer\"]/div[1]/ul/li[1]/div/input";
////        $field = $this->getSession()->getPage()->find('xpath', "//*[@id=\"mediaBinContainer\"]/div[1]/ul/li[1]/div/input");
////        echo "Done";
////        $field->attachFile("/Users/imtiazhossain/yv_website/Assets/img/tour/embedimage/1_b.png");
//        $file = "/Users/imtiazhossain/yv_website/Assets/img/tour/embedimage/1_b.png";
////        $element = $this->getSession()->getPage()->find("xpath", "//div[contains(@id, 'mediaBinContainer')]//input[contains(@class, 'fileInput')]");
////        $element->attachFile($file);
//        $this->getSession()->getDriver()->executeScript("$('#mediaBinContainer .addmedia .fileInput').css({'display':'block'})");
//        $element = $this->getSession()->getPage()->find("xpath", "//div[contains(@id, 'mediaBinContainer')]//input[contains(@class, 'fileInput')]");
//        $element->attachFile($file);
////        sleep(10);
////        $this->getSession()->getDriver()->executeScript("$('#mediaBinContainer .addmedia .fileInput').css({'display':'none'})");
//        sleep(10000);
////        $this->getSession()->getDriver()->attachFile("//div[contains(@id, 'mediaBinContainer')]//input[contains(@class, 'fileInput')]", "/Users/imtiazhossain/yv_website/Assets/img/tour/embedimage/1_b.png");
////        attachFileToField($location, "/Users/imtiazhossain/yv_website/Assets/img/tour/embedimage/1_b.png");
//    }

}