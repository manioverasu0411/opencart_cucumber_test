package InterviewPreparation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartMobileDetailExtraction {
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

        // page wise mobile and mobile price
        List<WebElement> mobileNames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        List<WebElement> mobile_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

        for(int p = 1; p<=total_pages;p++){

            if(total_pages>1){
                WebElement active_page = driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[text()="+p+"]"));
                Thread.sleep(2000);
                System.out.println("Active Page: "+active_page.getText());
                active_page.click();

            }
        }

        driver.quit();
    }
}