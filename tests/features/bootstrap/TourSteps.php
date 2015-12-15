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
        sleep(2);
    }

    /**
     * @Given I delete the Stop
     */
    public function iDeleteStop()
    {
        $this->clickByCSSSelector("#stops > div.ng-isolate-scope > div.ui-sortable > div > div.stop.ng-isolate-scope.ui-droppable.selected > span.delete");
        sleep(2);
        $this->clickByCSSSelector("body > div.appcontainer.ng-scope > div.modal_wrapper.animated.ngfade.ng-scope > div > div > a");
        sleep(2);
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

        $this->getSession()->getPage()->waitFor(100000,
            function (){
                return $this->getSession()->getDriver()->evaluateScript("$('.uploadstatus.live')");
            }
        );

        $endtime = microtime(true);
        $timediff = $endtime - $starttime;
        echo "Upload time = $timediff seconds";
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
    /**
     * @Given I assert that the photo exists
     */
    public function iAssertThatThePhotoExists()
    {
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
        $this->clickByCSSSelector("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-child(1) > div > a:nth-child(2)");

        $this->getSession()->getPage()->waitFor(100000,
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
        $this->assertElementOnPage("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the video
     */
    public function iDeleteTheVideo()
    {
        $this->hoverOver("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(1);
        $this->clickByCSSSelector("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-child(1) > div > a:nth-child(2)");
        sleep(2);
    }

    /**
     * @Given I upload a Panos
     */
    public function iUploadAPanos()
    {
        $this->clickByCSSSelector("#gallery_bottom > div.ng-isolate-scope.bar-control > div.bar_items > a.bar_item.panorama");
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
        $this->assertElementOnPage("#mediaBinContainer > div:nth-of-type(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the panos
     */
    public function iDeleteThePanos()
    {
        $this->hoverOver("#mediaBinContainer > div:nth-of-type(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(1);
        $this->clickByCSSSelector("#mediaBinContainer > div:nth-of-type(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-of-type(1) > div > a:nth-of-type(2)");
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
        $this->assertElementOnPage("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
    }

    /**
     * @Then I delete the 360
     */
    public function iDeleteTheThreeSixty()
    {
        $this->hoverOver("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div");
        sleep(1);
        $this->clickByCSSSelector("#mediaBinContainer > div:nth-child(1) > ul > li.mediagroup.ng-scope.ng-isolate-scope > div > div:nth-child(1) > div > a:nth-child(2)");
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
        $this->assertElementOnPage("#audioPlayer > div > div > div.audio_container.animated.fast.ngfade > div.buttons > span:nth-child(2)");
    }

    /**
     * @Then I delete the audio
     */
    public function iDeleteTheAudio()
    {
        $this->clickByCSSSelector("#audioPlayer > div > div > div.audio_container.animated.fast.ngfade > div.buttons > span.delete");
        sleep(1);
    }
}