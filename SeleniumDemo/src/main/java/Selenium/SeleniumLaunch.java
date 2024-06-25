package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumLaunch {
	public static void main(String[] args) throws InterruptedException {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
		extent.attachReporter(spark);
		
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String Title = driver.getTitle();
		System.out.println(Title);
		
		driver.findElement(By.id("APjFqb")).sendKeys("Google");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		driver.getCurrentUrl();
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		
		Thread.sleep(4000);
		driver.quit();

		if (Title.equals("Google")) {
			System.out.println("The URL is correct");
		}

		else {
			System.out.println("There is a missmatch");
		}

	}
}