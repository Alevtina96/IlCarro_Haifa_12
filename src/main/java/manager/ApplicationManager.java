package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;
    //WebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("Test start in Chrome driver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        logger.info("The link of project -->" + wd.getCurrentUrl());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        search = new HelperSearch(wd);
        wd.register(new MyListener());

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

