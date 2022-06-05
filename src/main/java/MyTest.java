import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyTest {
    // from: 06/10/2023    to: 01/10/2023  now:05/26/2022

    public static void main(String[] args) {

        String from = "06/10/2023";
        String[] fromSplit = from.split("/");
        String to = "01/10/2023";
        String []toSplit = to.split("/");

        /// string now ----> LocalDate.now();

        String now = "05/27/2022";
        LocalDate nowLD = LocalDate.now();
        String []nowSplit = now.split("/");



        int diffYear = Integer.parseInt(fromSplit[2]) - Integer.parseInt(nowSplit[2]); ///
        int diffYear1 = Integer.parseInt(fromSplit[2]) - nowLD.getYear(); ///

        int diffMonth;
        if(diffYear==0){
            diffMonth = Integer.parseInt(fromSplit[0])-Integer.parseInt(nowSplit[0]);
            System.out.println("diff  == 0");
        }else{
            diffMonth = 12-Integer.parseInt(nowSplit[0])+Integer.parseInt(fromSplit[0]);
            System.out.println("diff  == 1");
        }

        System.out.println(System.currentTimeMillis());


        // yyyy-mm-dd
        LocalDate localDateNow  =  LocalDate.now();
        System.out.println(localDateNow.getYear());
        System.out.println(localDateNow.getMonthValue());
        System.out.println(localDateNow.getDayOfMonth());
        System.out.println(localDateNow.getMonth());

        String first = "20.11.1999";
        LocalDate firstLocalDate = LocalDate.parse(first, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("***" +firstLocalDate);

        String second = "11-20-1999";
        LocalDate secondLocalDate = LocalDate.parse(second,DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        System.out.println("***"+secondLocalDate);

        String third = "20 November 1999";
        LocalDate thirdLocalDate = LocalDate.parse(third,DateTimeFormatter.ofPattern("dd MMMM yyyy"));

        if(firstLocalDate.equals(secondLocalDate)){
            System.out.println("They are equals");

        }else
            System.out.println("They are not equals");


    }
}
