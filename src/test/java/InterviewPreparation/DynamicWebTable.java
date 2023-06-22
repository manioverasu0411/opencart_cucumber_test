package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DynamicWebTable {

    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
        driver.manage().window().maximize();



        //  verify that only 4 structure present in the table
        List<Map<String, String>> buildingList = new LinkedList<>();
        List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//thead//tr//th"));
        System.out.println(tableHeaders.size());
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr"));
        System.out.println(rowData.size());

        int structureCount = 0;
        for (WebElement row:rowData) {

        }

        System.out.println(buildingList);




        driver.close();

    }
}
