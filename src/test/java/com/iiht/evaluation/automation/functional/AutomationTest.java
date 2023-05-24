package com.iiht.evaluation.automation.functional;


import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;


import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iiht.evaluation.automation.Activities;
import com.iiht.evaluation.automation.UITest;

@TestMethodOrder(OrderAnnotation.class)
public class AutomationTest {
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void preset() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	@Test 
	@Order(1)
	public void testNavigateToHomeLoanEMI() throws IOException{
		try {
				String baseUrl = "https://www.moneycontrol.com/"; 
				driver.get(baseUrl);
				if(!UITest.mouseOverPersonalFinance(driver, baseUrl)) {
					yakshaAssert(currentTest(), false, businessTestFile);
					return;
				}
			}catch(Exception ex) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(2)
	public void testCalculateHomeLoanEMI() throws IOException
	{

		if(!UITest.enterValueLoanAmount(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!UITest.selectEMIStartsFrom(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!UITest.enterInterestRate(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!UITest.enterValueLoanPeriod(driver)){
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!UITest.enterValueUpfrontCharges(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		if(!UITest.clickSubmit(driver)) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(3)
	public void testGetTotalPayment() throws Exception{
		try {
			Activities activities = new Activities();
			String payment = activities.getTotalPayment(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(4)
	public void testGetEMI() throws Exception{
		try {
			Activities activities = new Activities();
			String payment = activities.getEMI(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(5)
	public void testGetTableDetails7thYearEMIPaymentInTheYear() throws Exception{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails7thYearEMIPaymentInTheYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	
	@Test 
	@Order(6)
	public void testGetTableDetails7thYearInterestPaymentInTheYear() throws IOException{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails7thYearInterestPaymentInTheYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(7)
	public void testGetTableDetails7thYearPrincipalPaymentInTheYear() throws IOException{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails7thYearPrincipalPaymentInTheYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	@Test 
	@Order(8)
	public void testGetTableDetails5thYearOutstandingPrincipalAtTheEndOfYear() throws IOException{
		try {
			Activities activities = new Activities();
			String payment = activities.getTableDetails5thYearOutstandingPrincipalAtTheEndOfYear(driver);
			if(payment.contentEquals("")) {
				yakshaAssert(currentTest(), false, businessTestFile);
				return;
			}
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), true, businessTestFile);
	}
	
	  @AfterAll
	  public static void cleanUp() {
			driver.quit();
	  } 	 
}

