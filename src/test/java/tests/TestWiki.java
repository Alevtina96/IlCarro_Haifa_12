package tests;

import manager.MyListenerNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListenerNG.class)

public class TestWiki {
    WebDriver wd;
    @Test
    public void openWikipedia() throws InterruptedException {
        wd= new ChromeDriver();
        wd.get("https://wikipedia.org");
        System.out.println("Current URL --->"+wd.getCurrentUrl());


        Thread.sleep(5000);
        wd.close();
    }
}

