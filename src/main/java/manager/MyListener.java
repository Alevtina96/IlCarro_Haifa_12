package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        System.out.println("before find by");
        logger.info("Start find element by locator -->"+by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("After find by --->"+by);
    }

    @Override //для прослушки события
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a problem -->"+driver.getCurrentUrl());
        logger.info("We have a problem -->"+throwable.getMessage());
        logger.info("We have a problem -->"+throwable.getStackTrace().toString());
        logger.info("We have a problem -->"+throwable.fillInStackTrace());

       File file=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    int i = (int)System.currentTimeMillis()/1000;
    String link = "src/test/screenshots/screen-"+i+".png";

    try{
        Files.copy(file, new File(link));
    }catch(IOException e){
        e.printStackTrace();
    }

    }
}
