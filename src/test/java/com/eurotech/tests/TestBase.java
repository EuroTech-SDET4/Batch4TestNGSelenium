package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;
   protected ExtentReports report;
   protected ExtentHtmlReporter htmlReporter;
   protected ExtentTest extentLogger;


   @BeforeTest
   public void setupTest(){

       //initialize the class
       report = new ExtentReports();

       //create a report path
       String projectPath = System.getProperty("user.dir");
       String path = projectPath + "/test-output/report.html";

       //initialize the html report with the report path
       htmlReporter= new ExtentHtmlReporter(path);

       //attach the html report to the report object
       report.attachReporter(htmlReporter);

       //title in report
       htmlReporter.config().setReportName("Eurotech Smoke Test");

       //set environment information
       report.setSystemInfo("Environment","Production");
       report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
       report.setSystemInfo("OS",System.getProperty("os.name"));
       report.setSystemInfo("Test Engineer","Erhan");


   }
   @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions=new Actions(Driver.get());
        wait=new WebDriverWait(Driver.get(),15);
        driver.get(ConfigurationReader.get("url"));


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2000);
        Driver.closeDriver();

    }
    @AfterTest
    public void tearDownTest(){
       report.flush();
    }

}
