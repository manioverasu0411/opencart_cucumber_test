package InterviewPreparation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PrintAsciiValue {

    public static WebDriver driver;

    public static void main(String[] args) {
        char ch;
        int i ;
        for(ch='A'; ch<='Z'; ch++){
            i = ch;
            System.out.println(ch+" " +(i-64));
        }

    }



}
