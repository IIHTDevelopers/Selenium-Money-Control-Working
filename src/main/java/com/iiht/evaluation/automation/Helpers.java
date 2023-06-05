package com.iiht.evaluation.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {

	public static WebElement getElementforMouseOver(WebDriver driver) {
		try {
			WebElement menuOption = driver.findElement(By.partialLinkText("Personal Finance"));
			return menuOption;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforTool(WebDriver driver) {
		try {
			WebElement subMenuOption = driver.findElement(By.linkText("Tools")); 
			return subMenuOption;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforHomeLoan(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Home Loan')]"));
			return ele;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforLoanAmount(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.id("carhome_loan"));
			return ele;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforLoanPeriod(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.id("loan_period"));
			return ele;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforEMIStart(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.id("emi_start_from"));
			return ele;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforInterestRate(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.id("interest_rate"));
			return ele;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getElementforUpfrontcharges(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.id("upfront_charges"));
			return ele;
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static WebElement getEmiElement(WebDriver driver) {
		try {
			WebElement ele = driver.findElement(By.id("emi"));
			return ele;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static String getXpathfor7thYearEMIPayment() {
		return "//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='7']/following-sibling::td[2]";
	}
	
	public static String getXpathfor7thYearInterestPayment() {
		return "//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='7']/following-sibling::td[3]";
	}
	
	public static String getXpathfor7thYearPrincipalPayment() {
		return "//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='7']/following-sibling::td[4]";
	}
	
	public static String getXpathfor5thYearOutstandingPrincipalPayment() {
		return "//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='5']/following-sibling::td[1]";
	}
}
