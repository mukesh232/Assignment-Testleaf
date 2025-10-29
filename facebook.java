package automation_projects_dummy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebook {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();

        Thread.sleep(6000);

        driver.findElement(By.partialLinkText("Create")).click();
        Thread.sleep(6000);

        driver.findElement(By.name("firstname")).sendKeys("Mukesh");
        driver.findElement(By.name("lastname")).sendKeys("M S");
        driver.findElement(By.name("reg_email__")).sendKeys("mukeshaaron.38@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Test@1234");

        driver.findElement(By.name("birthday_day")).sendKeys("7");
        driver.findElement(By.name("birthday_month")).sendKeys("sep");
        driver.findElement(By.name("birthday_year")).sendKeys("2002");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@value='1']")).click();

        Thread.sleep(3000);

      
    }
}



