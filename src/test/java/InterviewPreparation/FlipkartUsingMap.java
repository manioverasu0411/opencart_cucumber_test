package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FlipkartUsingMap {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        // Closing dialog
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

        // Searching Samsung Mobile
        WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']"));
        search.sendKeys("Samsung Mobiles");
        search.sendKeys(Keys.ENTER);

        // To find total no of pages
        String pageText = driver.findElement(By.xpath("//div[@class='_2MImiq']//span[1]")).getText();
        System.out.println(pageText);
        int total_pages = Integer.parseInt(pageText.substring(pageText.indexOf("f") + 2));
        System.out.println("The total no of page is: " + total_pages);
        Thread.sleep(3000);

        WebElement nextButton = driver.findElement(By.xpath("//span[normalize-space()='Next']//parent::a"));

        List<Map<String,String>> mobileList = new LinkedList<>();

        for (int p = 1; p < total_pages; p++) {

            WebElement active_page = driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[text()=" + p + "]"));
            Thread.sleep(2000);

            List<WebElement> MobileCards = driver.findElements(By.xpath("//div[@class='_3pLy-c row']"));

            for (WebElement cards:MobileCards) {
                Map<String,String> MobileListMap = new LinkedHashMap<>();
                MobileListMap.put("Name",cards.findElement(By.xpath(".//div[1]/div[1]")).getText());
                MobileListMap.put("Price",cards.findElement(By.xpath(".//div[2]/div[1]/div[1]/div[1]")).getText());
                mobileList.add(MobileListMap);
            }

            active_page.click();
            Thread.sleep(2000);
            nextButton.click();

            }

        // System.out.println(mobileList);

        System.out.printf("----------------------------------------------------------------%n");
        System.out.printf("                   FLIPKART SAMSUNG MOBILE DETAILS               %n");
        System.out.printf("----------------------------------------------------------------%n");
        System.out.printf("| %-48s | %-5s |%n", "NAME", "PRICE");
        System.out.printf("----------------------------------------------------------------%n");

        for(Map<String,String> m: mobileList){
            System.out.printf("| %-48s | %-5s |%n", m.get("Name"),m.get("Price"));
        }



        driver.close();


    }
}
