package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
     fillInputCity(city);
     selectSimpleDateStringFormat(dateFrom, dateTo);
    }

    private void selectSimpleDateStringFormat(String dateFrom, String dateTo) {
        click(By.id("dates"));
        String [] splitFrom= dateFrom.split( "/");
        String []splitTo= dateTo.split( "/");

        String locatorFrom =String.format("//div[text()=' %s ']",splitFrom[1]);
        String locatorTo =String.format("//div[text()=' %s ']",splitTo[1]);

        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));
    }

    public void fillSearchFormCurrentMonth2(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
  String []dateF= dateFrom.split( "/");
  String []dateT= dateTo.split( "/");

  String locator = "//div[text()=' " + dateF[1] +" ']";
   //click(By.id("dates"));
        click(By.xpath(locator)); //"//div[text()= ' 31 ']"
        String locator2 = "//div[text()=' " + dateT[1] +" ']";
        click(By.xpath(locator2));
        pause(500);
    }

    public void fillInputCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector(".pac-item"));
        pause(500);


    }

    public boolean isListOfCarAppeared() {
    return isElementPresent(By.cssSelector(".search-result"));
    }

    public void returnToHome() {
        click(By.cssSelector(".header a[href='/']"));
    }


    public void fillSimpleDataCurrentMounth(String city, String dateFrom, String dateTo) {
     fillInputCity(city);
     selectSimpleDate(dateFrom, dateTo);
    }

    private void selectSimpleDate(String dateFrom, String dateTo) {
        //5/24/2022 - 5/25/2022 --> 24-25
        click(By.id("dates"));
        click(By.xpath("//div[text()= ' 24 ']")); //--->24
        click(By.xpath("//div[text()= ' 25 ']")); //--->25

    }

    private void selectSimpleDateNew(String dateFrom, String dateTo) {
        //5/27/2022 - 5/28/2022 --> 27-28
        click(By.id("dates"));

        //String dataForm "5/27/2022" -->["5"]["27"]["2022"] String.split("/"); - реж стринг по этому маркеру

        String [] splitFrom = dateFrom.split("/"); //splitFrom[1] -->дай мне только то что лежит по индексом 1
        String [] splitTo = dateTo.split("/");

        //String locatorFrom ="//div[text()=' 27 ']";
        // locatorFrom = "//div[text()=' " +"27"+ " ']";
        String locatorFrom = "//div[text()=' " +splitFrom[1]+ " ']";
        System.out.println(locatorFrom);
        click(By.xpath(locatorFrom)); //----> 27


//       String s = "Hello";
//       String s1 ="Word";
//       String s2 = s+" "+s1; //--> "Hello Word"

        String locatorTo= "//div[text()=' " +splitTo[1]+ " ']";
        System.out.println(locatorTo);

        click(By.xpath(locatorTo)); //----> 28
    }


}
