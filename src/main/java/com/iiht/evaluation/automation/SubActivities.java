package com.iiht.evaluation.automation;

import static com.iiht.evaluation.automation.Helpers.getElementforEMIStart;
import static com.iiht.evaluation.automation.Helpers.getElementforHomeLoan;
import static com.iiht.evaluation.automation.Helpers.getElementforInterestRate;
import static com.iiht.evaluation.automation.Helpers.getElementforLoanAmount;
import static com.iiht.evaluation.automation.Helpers.getElementforLoanPeriod;
import static com.iiht.evaluation.automation.Helpers.getElementforMouseOver;
import static com.iiht.evaluation.automation.Helpers.getElementforTool;
import static com.iiht.evaluation.automation.Helpers.getElementforUpfrontcharges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubActivities {
	
	public static boolean mouseOverPersonalFinance(WebDriver driver, String baseUrl)  {
		try {
			WebElement menuOption = getElementforMouseOver(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(menuOption).perform();
			if(!clickTools(driver, actions))
				return false;
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean clickTools(WebDriver driver, Actions actions)  {
		try {
			WebElement subMenuOption = getElementforTool(driver); 
			actions.moveToElement(subMenuOption).perform();
			actions.click().perform();
			if(!clickOnHomeLoanEMICalculator(driver))
				return false;
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	
	public static boolean clickOnHomeLoanEMICalculator(WebDriver driver) {
		//Click on Home Loan EMI Calculator
		try {

			WebElement ele = getElementforHomeLoan(driver);
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Home Loan')]"))));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",ele);	

		}
		catch (StaleElementReferenceException e)
		{
			return false;
		}
		return true;
	}

	
	public static boolean enterValueLoanAmount(WebDriver driver) 	{
		try {
			WebElement ele = getElementforLoanAmount(driver);
			ele.clear();
			ele.sendKeys("3000000");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	public static boolean enterValueLoanPeriod(WebDriver driver) {
		try {
			WebElement ele = getElementforLoanPeriod(driver);
			ele.clear();
			ele.sendKeys("20");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	public static boolean selectEMIStartsFrom(WebDriver driver) {
		try {
			WebElement ele = getElementforEMIStart(driver);
			Select select = new Select(ele);
			select.selectByVisibleText("At the time of loan disbursement");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	public static boolean enterInterestRate(WebDriver driver) {
		try {
			WebElement ele = getElementforInterestRate(driver);
			ele.clear();
			ele.sendKeys("10");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	
	public static boolean enterValueUpfrontCharges(WebDriver driver) {
		try {
			WebElement ele = getElementforUpfrontcharges(driver);
			ele.clear();
			ele.sendKeys("10000");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	
	public static WebElement getTotalPaymentElement(WebDriver driver) {
		try {
			WebElement totalPayment = new WebDriverWait(driver, Duration.ofSeconds(10))
			        .until(ExpectedConditions.presenceOfElementLocated(By.id("total_payment")));
			
			return totalPayment;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	
	public static boolean clickSubmit(WebDriver driver){
		try {
			driver.findElement(By.linkText("Submit")).click();
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	
	
}
