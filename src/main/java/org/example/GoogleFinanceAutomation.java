package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class GoogleFinanceAutomation {
    private static WebDriver driver;

    @Test
    public void CheckDifferentPrice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       try {
            // Step 1: Open Google Finance
            driver.get("https://www.google.com/finance/");

            // Step 2: Search for GGRM
            String[] saham = {"GGR", "BBCA", "BBRI"};
            WebElement searchBox = driver.findElement(By.xpath("(//input[@class='Ax4B8 ZAGvjd'])[2]"));
            searchBox.sendKeys(saham[0]);

           String[] input_value = {"Gudang Garam Tbk PT", "Bank Central Asia", "Bank Rakyat Indonesia"};
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+input_value[0]+"']")));
           driver.findElement(By.xpath("//div[text()='"+input_value[0]+"']")).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+input_value[0]+"']")));

            // Step 3: Choose Chart Type
           String[] chart_type = {"1dayTab", "5dayTab", "1monthTab", "6monthTab", "ytdTab", "1yearTab", "5yearTab", "maxTab"};
            WebElement ButtonChartType = driver.findElement(By.id(chart_type[7]));
            ButtonChartType.click();

            // Step 4: Get the highest value in the MAX chart and save it as variable
//            1. Hover the mouse over the highest point.
//            2. Get the text value of the price.
//            3. Save the price value as a variable named "peakPrice."

            // Step 5: Calculate and print the difference between highest value and previous day
//           1. Getthe text value of the price 1 day before the peak day.
//           2. Save the price value as a variable named "priceMinusOne".
//           3. Print the variables "peakPrice" and "priceMinusOne".
//           4. Calculate the difference between "peakPrice" and "priceMinusOne" as "totalDifference".
//           5. Print the value of "totalDifference".

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
