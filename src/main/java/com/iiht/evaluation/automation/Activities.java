package com.iiht.evaluation.automation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Activities {
	
		
	public boolean navigateToHomeLoanEMI(WebDriver driver) throws IOException{
		try {
				String baseUrl = "https://www.moneycontrol.com/"; 
				driver.get(baseUrl);
				if(!UITest.mouseOverPersonalFinance(driver, baseUrl))
					return false;
			}catch(Exception ex) {
				return false;
			}
		return true;
	}
	
	public boolean calculateHomeLoanEMI(WebDriver driver) throws InterruptedException
	{

		if(!UITest.enterValueLoanAmount(driver)) return false;
		if(!UITest.selectEMIStartsFrom(driver)) return false;
		if(!UITest.enterInterestRate(driver)) return false;
		if(!UITest.enterValueLoanPeriod(driver)) return false;
		if(!UITest.enterValueUpfrontCharges(driver)) return false;
		if(!UITest.clickSubmit(driver)) return false;
		
		return true;
	}
	
	public String getTotalPayment(WebDriver driver) throws Exception{
		WebElement totalPayment = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.presenceOfElementLocated(By.id("total_payment")));
		return totalPayment.getText();
	}
	
	public String getEMI(WebDriver driver) throws Exception{
		return driver.findElement(By.id("emi")).getText();
	}
	
	public String getTableDetails7thYearEMIPaymentInTheYear(WebDriver driver) throws InterruptedException{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,600)", "");
		return driver.findElement(By.xpath("//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='7']/following-sibling::td[2]")).getText();
	}
	public String getTableDetails7thYearInterestPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return driver.findElement(By.xpath("//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='7']/following-sibling::td[3]")).getText();
	}
	public String getTableDetails7thYearPrincipalPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return driver.findElement(By.xpath("//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='7']/following-sibling::td[4]")).getText();
	}
	public String getTableDetails5thYearOutstandingPrincipalAtTheEndOfYear(WebDriver driver) throws InterruptedException{
		return driver.findElement(By.xpath("//table[@id=\"emi_table\"]/tbody/tr/td[1][text()='5']/following-sibling::td[1]")).getText();
	}

}
