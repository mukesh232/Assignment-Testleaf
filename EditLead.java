package automation_projects_dummy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditLead {

    public static void main(String[] args) {

    
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest"); 
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       
        driver.get("http://leaftaps.com/opentaps/control/main");

   
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();

     
        driver.findElement(By.linkText("Find Leads")).click();

    
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");

    
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))).click();

   
        String title = driver.getTitle();
        System.out.println("Page title: " + title);

   
        driver.findElement(By.linkText("Edit")).click();

    
        driver.findElement(By.id("updateLeadForm_companyName")).clear();
        driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("NewCompany");

     
        driver.findElement(By.name("submitButton")).click();

      
        String updatedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
        System.out.println("Updated company name: " + updatedName);

        if (updatedName.contains("NewCompany")) {
            System.out.println("✅ Lead updated successfully!");
        } else {
            System.out.println("❌ Lead update failed.");
        }

        driver.quit();
    }
}
