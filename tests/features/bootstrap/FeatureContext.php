<?php

use Behat\Behat\Context\SnippetAcceptingContext;
use Behat\MinkExtension\Context\MinkContext;

require "vendor/autoload.php";

/**
 * Defines application features from the specific context.
 */
class FeatureContext extends MinkContext implements SnippetAcceptingContext
{
    /**
     * Initializes context.
     *
     * Every scenario gets its own context instance.
     * You can also pass arbitrary arguments to the
     * context constructor through behat.yml.
     */
    public function __construct()
    {

    }

//    /** @AfterScenario */
//    public function after()
//    {
//        $this->getSession()->getDriver()->stop();
//    }

    /** @BeforeScenario */
    public function before()
    {
        $this->getSession()->getDriver()->maximizeWindow();
    }

    /**
     * Download remote file to local for use in Automated Tests...
     * @param $remote_url (string) of resource to download
     * @return string (string) local path of remote url
     */
    public function getLocalCopy($remote_url) {
        $file_path = sys_get_temp_dir() . "/" . md5($remote_url) . "." . pathinfo($remote_url, PATHINFO_EXTENSION);
        if (!file_exists($file_path)){
            echo "Writing: {$remote_url} to {$file_path}\n";
            file_put_contents($file_path, fopen($remote_url, 'r'));
        }
        return $file_path;
    }

}
