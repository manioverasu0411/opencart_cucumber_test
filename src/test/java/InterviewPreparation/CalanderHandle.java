package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalanderHandle {

    public static WebDriver driver;

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        Calendar calendar = Calendar.getInstance();

        String targetDate = "01-Jun-2023";
        SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date formattedTargetDate;
        try{
            targetDateFormat.setLenient(false);
            formattedTargetDate  = targetDateFormat.parse(targetDate);
            calendar.setTime(formattedTargetDate);

            int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
            int targetMonth = calendar.get(Calendar.MONTH);
            int targetYear = calendar.get(Calendar.YEAR);

            driver.findElement(By.id("second_date_picker")).click();
            String actualDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

            int actualMonth = calendar.get(Calendar.MONTH);
            int actualYear = calendar.get(Calendar.YEAR);

            while (targetMonth< actualMonth || targetYear < targetYear){
                driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
               actualDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
                 actualMonth = calendar.get(Calendar.MONTH);
                actualYear = calendar.get(Calendar.YEAR);
            }


            /*driver.findElement(By.id("second_date_picker")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="+targetDay+"]")).click();*/


        }catch (ParseException e){
           throw  new Exception("Invalid data  is provided, pls check input date");
        }

        driver.close();



    }
}
