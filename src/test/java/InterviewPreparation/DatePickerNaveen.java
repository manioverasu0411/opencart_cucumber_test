package InterviewPreparation;

import io.cucumber.java.sl.In;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DatePickerNaveen {
    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        selectDate("20","June","2022");

    }
    public static String[] getMonthYear(String monthYearVal){
        return monthYearVal.split(" ");
    }

    public static void selectDate(String givenDate, String givenMonth, String givenYear){

        if(givenMonth.equals("February") && Integer.parseInt(givenDate)>29){
            System.out.println("Wrong Date: "+ givenMonth+" : "+givenDate);
            return;
        }

        String monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
        System.out.println(monthYearVal);

        while (!(getMonthYear(monthYearVal)[0].equals(givenMonth) && getMonthYear(monthYearVal)[1].equals(givenYear))){
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
        }

        driver.findElement(By.xpath("//a[text()='"+givenDate+"']")).click();


    }


}
