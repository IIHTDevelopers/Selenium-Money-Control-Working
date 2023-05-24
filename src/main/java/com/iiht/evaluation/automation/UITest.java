package com.iiht.evaluation.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;
//import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;

public class UITest {
	
	public static boolean mouseOverPersonalFinance(WebDriver driver, String baseUrl)  {
		try {
			WebElement menuOption = driver.findElement(By.partialLinkText("Personal Finance"));
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
			WebElement subMenuOption = driver.findElement(By.linkText("Tools")); 
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

			WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Home Loan')]"));

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
			driver.findElement(By.id("carhome_loan")).clear();
			driver.findElement(By.id("carhome_loan")).sendKeys("3000000");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	public static boolean enterValueLoanPeriod(WebDriver driver) {
		try {
			driver.findElement(By.id("loan_period")).clear();
			driver.findElement(By.id("loan_period")).sendKeys("20");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	public static boolean selectEMIStartsFrom(WebDriver driver) {
		try {
			Select select = new Select(driver.findElement(By.id("emi_start_from")));
			select.selectByVisibleText("At the time of loan disbursement");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	public static boolean enterInterestRate(WebDriver driver) {
		try {
			driver.findElement(By.id("interest_rate")).clear();
			driver.findElement(By.id("interest_rate")).sendKeys("10");
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean enterValueUpfrontCharges(WebDriver driver) {
		try {
			driver.findElement(By.id("upfront_charges")).clear();
			driver.findElement(By.id("upfront_charges")).sendKeys("10000");
		}catch(Exception ex) {
			return false;
		}
		return true;
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
