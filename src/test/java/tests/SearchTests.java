package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    @Test
    public void searchTestsSimple() {
        //logger.info("Logger");
        //5/24/2022 - 5/25/2022
        app.search().fillSimpleDataCurrentMounth("Tel Aviv Israel", "5/24/2022", "5/25/2022");
        app.search().submit();

    }
}

//    @Test
//    public void searchTestsAnyData(){
//        //LocalDate Java
//        //5/24/2022 - 5/25/2022
//        app.search().fillSearchFormAnyData("Tel Aviv Israel" , "5/24/2022" , "5/25/2022");
//        app.search().submit();
//
//    }
//
//    @Test
//    public void searchPeriodCurrentMonth(){
//        //5/29/2022 - 5/31/2022
// app.search().fillSearchFormCurrentMonth("Haifa Israel","05/29/2022","05/31/2022");
// app.user().submit();
//
// Assert.assertTrue(app.search().isListOfCarAppeared());
//    }
//
//    @Test
//    public void searchPeriodCurrentMonth2() {
//        //5/29/2022 - 5/31/2022
//        app.search().fillSearchFormCurrentMonth("Tel-Aviv Israel","05/29/2022","05/31/2022");
//    app.search().pause(7000);
//    app.user().submit();
//    }
//@Test
//public void searchPeriodAnyDataInFuture(){
//        app.search().fillSearchFormInFuture("Haifa", "07/30/2022", "04/22/2023");
//app.user().submit();
//app.search().pause(7000);
//Assert.assertTrue(app.search().isListOfCarAppeared());
//
//    }
//    @AfterMethod
//    public void postCondition(){
//         app.search().returnToHome();
//    }
//
//}
