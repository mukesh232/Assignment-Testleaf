package automation_projects_dummy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.*;
import java.io.File;
import org.openqa.selenium.io.FileHandler;

public class SauceDemo {
    public static void main(String[] args) throws Exception {
      
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

      
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

       
        driver.findElement(By.id("login-button")).click();

       
        String firstProductName = driver.findElement(By.className("inventory_item_name")).getText();
        System.out.println("First Product Name: " + firstProductName);

      
        String firstProductPrice = driver.findElement(By.className("inventory_item_price")).getText();
        System.out.println("First Product Price: " + firstProductPrice);

      
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(translate(normalize-space(.), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'ADD TO CART')])[1]")
        ));
        addToCart.click();
        Thread.sleep(2000);


    
        driver.findElement(By.className("shopping_cart_link")).click();

      
        String cartPrice = driver.findElement(By.className("inventory_item_price")).getText();
        if (cartPrice.equals(firstProductPrice)) {
            System.out.println("Price verified successfully!");
        } else {
            System.out.println("Price mismatch!");
        }
        Thread.sleep(2000);

   
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(2000);


  
        List<WebElement> prices = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_price"))
        );

        List<Double> priceList = new ArrayList<>();

        for (WebElement p : prices) {
            String priceText = p.getText().replace("$", "").trim();
            if (!priceText.isEmpty()) {
                priceList.add(Double.parseDouble(priceText));
            }
        }

       
        Collections.sort(priceList, Collections.reverseOrder());

      
        if (priceList.size() > 1) {
            System.out.println("Second Largest Price: $" + priceList.get(1));
        } else if (priceList.size() == 1) {
            System.out.println("Only one price found: $" + priceList.get(0));
        } else {
            System.out.println("❌ No prices found on the page!");
        }

       
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(2000);


       
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("confirmation_page.png"));
        System.out.println("Screenshot saved.");

      
    }
}
