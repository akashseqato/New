package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumLaunch2 {
    public static void main(String[] args) {
        // Set up ExtentReports
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Google Search Test");

        WebDriver driver = null;
        
        try {
            // Set up WebDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\seq_akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            test.info("ChromeDriver initiated");

            // Navigate to Google
            driver.get("https://www.google.com/");
            test.info("Navigated to Google");

            String title = driver.getTitle();
            System.out.println(title);
            test.info("Page title: " + title);

            // Perform search
            By searchBox = By.name("q");
            driver.findElement(searchBox).sendKeys("Google");
            driver.findElement(searchBox).sendKeys(Keys.ENTER);
            test.info("Performed search for 'Google'");

            String url = driver.getCurrentUrl();
            System.out.println(url);
            test.info("Current URL: " + url);

            // Check title
            if (title.equals("Google")) {
                System.out.println("The URL is correct");
                test.pass("The URL is correct");
            } else {
                System.out.println("There is a mismatch");
                test.fail("There is a mismatch");
            }
        } catch (Exception e) {
            e.printStackTrace();
            test.fail(e.getMessage());
        } finally {
            // Cleanup
            if (driver != null) {
                driver.quit();
                test.info("Driver quit successfully");
            }
            // Write to report
            extent.flush();
        }
    }
}
