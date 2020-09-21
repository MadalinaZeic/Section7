package org.projectTest.TestElements;

import org.openqa.selenium.By;
import org.projectTest.AppConfig;
import org.projectTest.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {
    protected WebDriver driver = null;

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getWebDriver(browser);
    }

    @After
    public void tearDown() {
       driver.quit();
    }

    public void openHomepage() {
        driver.get(AppConfig.getSiteURL());
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/button")).click();
    }

    public void openRegisterPage(){
        driver.get("https://demo.cart2quote.com/customer/account/create/");
    }

    public String fillFormGenerator(String input, int endIndex){

        String suffixGenerator = input + System.nanoTime();

        return suffixGenerator.substring(0, endIndex);
    }
    public String fillEmailGenerator(String input, int endIndex){
        String suffixGenerator = input + System.nanoTime();
        return suffixGenerator.substring(0, endIndex) + "@cocox.com";
    }
}

