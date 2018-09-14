package com.linkreit.automationtest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Step {
    private WebDriver driver;


    @Given("^Go to linkreit home$")
    public void Go_to_linkreit_home() throws Exception{
        System.setProperty("webdriver.chrome.driver", "/Users/colbert.zhou/Downloads/LINK_Testing/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.linkreit.com/en/home/");
    }

    @When("^I find search button$")
    public WebElement I_find_search_button() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/nav/a[7]"))));
        element.click();
        return element;

    }

    @And("^Type the search text \"([^\"]*)\"$")
    public void type_the_search_text(String searchText) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"search-search\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"search-search\"]")).sendKeys(searchText);
    }


    @And("^Click the submit$")
    public void Click_the_submit() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/form/div/a")).click();

    }

    @Then("^Wait the query result$")
    public void Wait_the_query_result() throws InterruptedException{
        Thread.sleep(5000);
        WebElement header = driver.findElement(By.xpath("//*[@id=\"SearchPage\"]/div/div[3]/div[2]/a[1]/div[1]"));
        header.isDisplayed();
        String userInfo = driver.findElement(By.xpath("//*[@id=\"SearchPage\"]/div/div[3]/div[2]/a[1]/div[1]")).getText();
        System.out.println(userInfo);
        driver.quit();

    }
}
