package manager;

import models.Auth;
import models.Car;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> loginValidDataSTR() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginValidDataAuth() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> carValidData() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")  /// address
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
                .carRegNumber("100-10-666")
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")  /// address
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
                .carRegNumber("100-10-667")
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")  /// address
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
                .carRegNumber("100-10-668")
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")  /// address
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
                .carRegNumber("100-10-669")
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car").build()});




        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> regValidData() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/tayahatum/Qa12Haifa/IlCarro_Haifa_12/reg.csv")));
        String line = reader.readLine();//   "Sony,Snow,wow@mail.com,Ww12345$"

        while (line!=null){
            String [] split = line.split(","); // ["Sony"] ["Snow"] ["wow@mail.com"] ["Ww12345$"]
            list.add(new Object[]{Auth.builder().name(split[0]).lastName(split[1]).email(split[2]).password(split[3]).build()});
            line =reader.readLine();  ///"Tony,Dow,wow1@mail.com,Ww12345$"
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> carValidDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/cardata.csv")));
String line = reader.readLine();
while (line!=null){
    String[] split =line.split(";");
    list.add(new Object[]{Car.builder()
            .address(split[0])  /// address
            .make(split[1])
            .model(split[2])
            .year(split[3])
            .engine(split[4])
            .fuel(split[5]) /// select
            .gear(split[6])/// select
            .wD(split[7]) /// select
            .doors(split[8])
            .seats(split[9])
            .clasS(split[10])
            .fuelConsumption(split[11])
            .carRegNumber(split[12])
            .price(split[13])
            .distanceIncluded(split[14])
            .features(split[15])
            .about(split[16])
            .build()});
    line =reader.readLine();
}
        return list.iterator(); //через итераторот можно запросить зай мне первый элемент или правда ли что там есть следующий элемент


    }
}
