<?php

use Behat\Behat\Context\SnippetAcceptingContext;
use Behat\MinkExtension\Context\MinkContext;
use Constants\Selectors;

require "vendor/autoload.php";

/**
 * Defines application features from the specific context.
 */
class FeatureContext extends MinkContext implements SnippetAcceptingContext
{
    public function test()
    {
        $this->getSession()->maximizeWindow();
    }
    /**
     * Initializes context.
     *
     * Every scenario gets its own context instance.
     * You can also pass arbitrary arguments to the
     * context constructor through behat.yml.
     */
    public function __construct()
    {
//        $this->loadSpecificContexts();
    }

//    private function loadSpecificContexts() {
//        $base_dir = dirname(__FILE__);
//        if ($handle = opendir( $base_dir )) {
//            while (false !== ($file = readdir($handle))) {
//                echo $base_dir . "/" . $file . "\n";
//                if (!in_array($file, array(".", "..")) && strpos($file, ".php") !== false) {
//                    include_once($base_dir . "/". $file);
//                }
//            }
//            closedir($handle);
//        }
//    }



}
