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
        $this->clickByCSS("#gridview > div > form > div.tour > div.actions > div.rounded > div.edit-button.action.icon-button.icon-svg.dashed");
        sleep(5);
    }

    /**
     * @Given I go to tour settings
     */
    public function iGoToTourSettings()
    {
        sleep(2);
        $this->hoverOver("#gridview > div > form > div.tour");
        sleep(1);
        $this->clickByCSS("#gridview > div > form > div.tour > div.actions > div.location-details-button.action.icon-button.gtm-profile-settings");
        sleep(3);
    }

    /**
     * @Given I click Add Stop
     */
    public function iClickAddStop()
    {
        $this->clickByCSS("#stops > div.stop.add > span.title");
        sleep(2);
    }

    /**
     * @Given I delete the Stop
     */
    public function iDeleteStop()
    {
        $this->clickByCSS("#stops > div.ng-isolate-scope > div.ui-sortable > div > div.stop.ng-isolate-scope.ui-droppable.selected > span.delete");
        sleep(2);
        $this->clickByCSS("body > div.appcontainer.ng-scope > div.modal_wrapper.animated.ngfade.ng-scope > div > div > a");
        sleep(2);
    }

    /**
     * @Given I upload a Photo
     */
    public function iUploadAPhoto()
    {
        $file_url = "https://s3.amazonaws.com/youvisit-qa/Assets/Photo-1.jpg";
        $this->fileUpload( $this->getLocalCopy($file_url) );
        $this->checkLive();
    }

    public function fileUpload($file)
    {
        $this->getSession()->getDriver()->executeScript("$('#mediaBinContainer .addmedia .fileInput').css({'display':'block'})");
        $this->getSession()
            ->getPage()
            ->find("xpath", "//div[contains(@id, 'mediaBinContainer')]//input[contains(@class, 'fileInput')]")
            ->attachFile($file);
        $this->getSession()->getDriver()->executeScript("$('#mediaBinContainer .addmedia .fileInput').css({'display':'none'})");
    }

    public function checkLive(){
        $starttime = microtime(true);

        $this->getSession()->getPage()->waitFor(10,
            function (){
                return $this->getSession()->getDriver()->evaluateScript("$('.uploadstatus.live')");
            }
        );

        $endtime = microtime(true);
        $timediff = $endtime - $starttime;
        echo "Upload time = $timediff seconds";
    }

    /**
     * @Given I assert that the photo exists
     */
    public function iAssertThatThePhotoExists()
    {
        sleep(1);
        $this->assertElementOnPage("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the photo
     */
    public function iDeleteThePhoto()
    {
        sleep(1);
        $this->hoverOver("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(2);
        $this->clickByCSS("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-child(1) > div > a:nth-child(2)");

        $this->getSession()->getPage()->waitFor(360,
            function (){
                $text = $this->getSession()->getDriver()->evaluateScript("$('.flash').not('.ng-hide').find('.flashloading').html()");
                return stripos($text, "Deleted") !== false;
            }
        );
    }

    /**
     * @Given I upload a Video
     */
    public function iUploadAVideo()
    {
        $this->clickByXPath("//*[@id=\"gallery_bottom\"]/div[1]/div[2]/a[2]");
        $file_url = "https://s3.amazonaws.com/youvisit-qa/Assets/Video-1.mp4";
        $this->fileUpload( $this->getLocalCopy($file_url) );
        $this->checkLive();
    }

    /**
     * @Given I assert that the video exists
     */
    public function iAssertThatTheVideoExists()
    {
        sleep(1);
        $this->assertElementOnPage("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the video
     */
    public function iDeleteTheVideo()
    {
        sleep(1);
        $this->hoverOver("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(1);
        $this->clickByCSS("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-child(1) > div > a:nth-child(2)");
        sleep(2);
    }

    /**
     * @Given I upload a Panos
     */
    public function iUploadAPanos()
    {
        $this->clickByCSS("#gallery_bottom > div.ng-isolate-scope.bar-control > div.bar_items > a.bar_item.panorama");
        sleep(1);
        $file_url = "https://s3.amazonaws.com/youvisit-qa/Assets/Pano-1.jpg";
        $this->fileUpload( $this->getLocalCopy($file_url) );
        $this->checkLive();
    }

    /**
     * @Given I assert that the panos exists
     */
    public function iAssertThatThePanosExists()
    {
        sleep(1);
        $this->assertElementOnPage("#mediaBinContainer > div:nth-of-type(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the panos
     */
    public function iDeleteThePanos()
    {
        sleep(1);
        $this->hoverOver("#mediaBinContainer > div:nth-of-type(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(1);
        $this->clickByCSS("#mediaBinContainer > div:nth-of-type(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-of-type(1) > div > a:nth-of-type(2)");
        sleep(1);
    }

    /**
     * @Given I upload a 360 Video
     */
    public function iUploadAThreeSixty()
    {
        $this->clickByXPath("//*[@id=\"gallery_bottom\"]/div[1]/div[2]/a[4]");
        sleep(1);
        $file_url = "https://s3.amazonaws.com/youvisit-qa/Assets/360Video-1.mp4";
        $this->fileUpload( $this->getLocalCopy($file_url) );
        $this->checkLive();
    }

    /**
     * @Given I assert that the 360 exists
     */
    public function iAssertThatTheThreeSixtyExists()
    {
        sleep(1);
        $this->assertElementOnPage("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the 360
     */
    public function iDeleteTheThreeSixty()
    {
        sleep(1);
        $this->hoverOver("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(1);
        $this->clickByCSS("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-child(1) > div > a:nth-child(2)");
        sleep(1);
    }

    /**
     * @Given I upload an Audio file
     */
    public function iUploadAnAudio()
    {
        $this->clickByXPath("//*[@id=\"gallery_bottom\"]/div[1]/div[2]/a[5]");
        sleep(1);
        $file_url = "https://s3.amazonaws.com/youvisit-qa/Assets/Audio-1.mp3";
        $this->getSession()
            ->getPage()
            ->find("xpath", "//*[@id=\"audioPlayer\"]/div/div/input[1]")
            ->attachFile($this->getLocalCopy($file_url));
        sleep(2);
    }

    /**
     * @Given I assert that the audio exists
     */
    public function iAssertThatTheAudioExists()
    {
        sleep(1);
        $this->assertElementOnPage("#audioPlayer > div > div > div.audio_container.animated.fast.ngfade > div.buttons > span:nth-child(2)");
    }

    /**
     * @Then I delete the audio
     */
    public function iDeleteTheAudio()
    {
        sleep(2);
        $this->clickByCSS("#audioPlayer > div > div > div.audio_container.animated.fast.ngfade > div.buttons > span.delete");
        sleep(1);
    }

    /**
     * @Given I click Map tab
     */
    public function iClickMapTab()
    {
        $this->clickByCSS("#sidebar_container > div > div.text-center.ng-isolate-scope.bar-control > div.bar_items > a.bar_item.map");
    }

    /**
     * @Given I upload a Map file
     */
    public function iUploadAMapFile()
    {
        $file_url = "https://s3.amazonaws.com/youvisit-qa/Assets/Pano-1.jpg";

        $this->getSession()->getDriver()->executeScript("$('.map_upload_uploader .map_upload_padding > input').css({'display':'block'})");
        $this->getSession()
            ->getPage()
            ->find("xpath", "//*[@id=\"file_dropper\"]/div/div[1]/div[3]/input")
            ->attachFile($this->getLocalCopy($file_url));
        $this->getSession()->getDriver()->executeScript("$('.map_upload_uploader .map_upload_padding > input').css({'display':'none'})");



        $starttime = microtime(true);

        $this->getSession()->getPage()->waitFor(10,
            function (){
                return $this->getSession()->getDriver()->evaluateScript("$('.maploader.ng-hide')");
            }
        );

        $endtime = microtime(true);
        $timediff = $endtime - $starttime;
        echo "Upload time = $timediff seconds";
    }

    /**
     * @Then I assert that the map exists
     */
    public function iAssertThatTheMapExists()
    {
//        throw new PendingException();
    }

    /**
     * @Then I delete the map
     */
    public function iDeleteTheMap()
    {
        sleep(1);
        $this->clickByCSS("body > div.appcontainer.ng-scope > div.app.ng-scope > div.map_uploader.animated.ngfade.ng-scope > div > div.delete_map");
        sleep(2);
        $this->clickByCSS("body > div.appcontainer.ng-scope > div.modal_wrapper.animated.ngfade.ng-scope > div > div > a");
        sleep(10);
    }

}