package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartPaginationCheck {

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


        System.out.printf("----------------------------------------------------------------%n");
        System.out.printf("                   FLIPKART SAMSUNG MOBILE DETAILS               %n");
        System.out.printf("----------------------------------------------------------------%n");
        System.out.printf("| %-48s | %-5s |%n", "NAME", "PRICE");
        System.out.printf("----------------------------------------------------------------%n");

        for (int p = 1; p < total_pages; p++) {

            WebElement active_page = driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[text()=" + p + "]"));
            Thread.sleep(2000);

            List<WebElement> mobileNames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
            List<WebElement> mobile_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

            for (int m = 0; m < mobileNames.size(); m++) {
                //System.out.println(m + " " + mobileNames.size());
                System.out.printf("| %-48s | %-5s |%n", mobileNames.get(m).getText(), mobile_price.get(m).getText());
            }

            //System.out.println("Active Page: " + active_page.getText());
            active_page.click();

            Thread.sleep(2000);

            nextButton.click();


        }
    }

}