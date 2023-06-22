package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePickerPaven {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(0);
        // Approach 1
        // driver.findElement(By.id("datepicker")).sendKeys("06/20/2023", Keys.ENTER);

        driver.findElement(By.id("datepicker")).click();

        String givenyear = "2024";
        String givenmonth = "March";
        String givendate = "15";

        // Select Month and Year
        while (true) {

            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            System.out.println(currentMonth);
            System.out.println(currentYear);


            if (currentMonth.equals(givenmonth) && currentYear.equals(givenyear)) {
                break;
            }


            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }


        // Select data from table

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement d : allDates) {

            if (d.getText().equals(givendate)) {
                d.click();
                break;
            }

        }


    }
}
