package tests;
import models.Auth;
import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class AddNewCarTest extends TestBase{
    @BeforeMethod
    public void precondition(){

        if(!app.user().isLogOutPresent()){
            app.user().login(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build());
        }

    }

    @Test
    public void addNewCarSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car  = Car.builder()
                .address("Tel Aviv, Israel")  /// address
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.5")
                .fuel("Petrol") /// select
                .gear("MT")/// select
                .wD("AWD") /// select
                .doors("4")
                .seats("5")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-10-"+i)
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car")
                .build();

        logger.info("Tests start with car -->" +car.toString());
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("C:\\Users\\House\\Documents\\GitHub\\IlCarro_Haifa_12\\auto2.jpeg"); /// attach
        app.car().submitCarForm();
        app.car().submit();


    }
}
