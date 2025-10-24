import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement button =  driver.findElement(By.xpath("//form[@id='input-example']/button"));

        button.click();

        String message = driver.findElement(By.id("message")).getText();

        if(message.equals("It's enabled!")){
            System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს.");
        }
        if(button.getText().equals("Disable")){
            System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");
        }

        WebElement inputEl =  driver.findElement(By.xpath("//form[@id='input-example']/input"));

        inputEl.sendKeys("Bootcamp");

        inputEl.clear();

        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement box_a = driver.findElement(By.id("column-a"));
        WebElement box_b = driver.findElement(By.id("column-b"));

        Number pos_a = box_a.getRect().getY();
        Number pos_b = box_a.getRect().getY();

        if(pos_a.equals(pos_b)){
            System.out.println("სვეტები A და B წარმატებით არიან გასწორებული");
        }

        driver.quit();

    }

}
