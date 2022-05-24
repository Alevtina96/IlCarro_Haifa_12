package manager;
import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class HelperCar extends HelperBase{



    public HelperCar(WebDriver wd) {
        super(wd);
    }

//    public HeperCar(WebDriver wd) {
//        super(wd);
//    }

    public void openCarForm() {

        // click(By.id("1"));
        click(By.cssSelector("[href='/let-car-work']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getAddress());

        type(By.id("make"),car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"),car.getEngine());

        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWD());

        type(By.id("doors"), car.getDoors());

    }
    public void select(By locator, String option){
//        new Select(wd.findElement(By.id("fuel"))).selectByIndex(1);
////        new Select(wd.findElement(By.id("fuel"))).selectByValue("Petrol");
////        new Select(wd.findElement(By.id("fuel"))).selectByVisibleText(" Diesel ");

        new Select (wd.findElement(locator)).selectByValue(option);
    }


    private void typeLocation(String address) {
type(By.id("pickUpPlace"),address);
pause(500);
click(By.cssSelector(".pac-item"));
        pause(500);

    }

    public void submitCarForm() {
    }
    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);

    }
}


