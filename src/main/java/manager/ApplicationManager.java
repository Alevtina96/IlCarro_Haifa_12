package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;

    public void init() {
        wd = new ChromeDriver();
        logger.info("Test start in Chrome driver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        logger.info("The link of project -->" + wd.getCurrentUrl());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        search = new HelperSearch(wd);

    }

    public void stop() {
        wd.quit();

    }

    public HelperUser user() {
        return user;
    }

    public HelperCar car() {
        return car;
    }

    public HelperSearch search() {
        return search;

    }
}

