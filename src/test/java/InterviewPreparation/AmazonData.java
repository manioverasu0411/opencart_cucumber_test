package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AmazonData {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("T-shirts", Keys.ENTER);

        List<Map<String,String>> dataList = new LinkedList<>();

        List<WebElement> cardList = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']"));
        System.out.println("The total no card size is: "+cardList.size());

        for (int i = 0; i<cardList.size(); i++) {
            Map<String,String> TMap = new HashMap<>();
            List<WebElement> TnameList = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            List<WebElement> Tprice = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']//span[@class='a-price-whole']"));
            TMap.put("Name",TnameList.get(i).getText());
            TMap.put("Price",Tprice.get(i).getText());
            dataList.add(TMap);

        }
        System.out.println(dataList);

        System.out.printf("-----------------------------------------------------------------------------------------%n");
        System.out.printf("                   AMAZON T-SHIRT DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------%n");
        System.out.printf("| %-80s | %-5s |%n", "NAME", "PRICE");
        System.out.printf("-----------------------------------------------------------------------------------------%n");

        for(Map<String,String> m: dataList){
            System.out.printf("| %-80s | %-5s |%n", m.get("Name"),m.get("Price"));
        }

        driver.close();





    }
}
