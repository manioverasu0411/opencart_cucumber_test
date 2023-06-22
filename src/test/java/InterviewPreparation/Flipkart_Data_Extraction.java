package InterviewPreparation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Flipkart_Data_Extraction {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/clothing-and-accessories/topwear/tshirts/pr?sid=clo%2Cash%2Cank&otracker=categorytree&sort=popularity");

        List<WebElement> AllTshirtsBrandName = driver.findElements(By.xpath("//div[@class='_2WkVRV']"));
        //System.out.println("Total No of Tshirts: " + AllTshirtsBrandName.size());


        /*for (WebElement e : AllTshirtsBrandName) {
            System.out.println(e.getText());
        }*/

        List<WebElement> AllTshirtNames = driver.findElements(By.cssSelector("a.IRpwTa"));
        //System.out.println("Total No of Tshirts Names : " + AllTshirtNames.size());


        /*for (WebElement element:AllTshirtNames){
            System.out.println(element.getText());
        }*/

        List<WebElement> TshirtPrice = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
       // System.out.println("Total price count  : " + TshirtPrice.size());


        /*for(WebElement webElement:TshirtPrice){
            System.out.println(webElement.getText());
        }*/

        System.out.printf("--------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                   FLIPKART T-SHIRT PRICE DETAILS                                                       %n");
        System.out.printf("--------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-25s | %-65s | %4s |%n","BRAND","T-SHIRT NAME","PRICE");
        System.out.printf("--------------------------------------------------------------------------------------------------------%n");

        for(int i = 0; i<AllTshirtsBrandName.size(); i++){
           // System.out.println(AllTshirtsBrandName.get(i).getText()+"-------"+AllTshirtNames.get(i).getText()+"-------"+TshirtPrice.get(i).getText());
            System.out.printf("| %-25s | %-65s | %-5s |%n",AllTshirtsBrandName.get(i).getText(),AllTshirtNames.get(i).getText(),TshirtPrice.get(i).getText());
        }


        driver.close();

    }
}
