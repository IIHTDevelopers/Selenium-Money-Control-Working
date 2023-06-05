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
import static com.iiht.evaluation.automation.Helpers.*;

public class Activities {
	
		
	public boolean navigateToHomeLoanEMI(WebDriver driver) throws IOException{
		try {
				String baseUrl = "https://www.moneycontrol.com/"; 
				driver.get(baseUrl);
				if(!SubActivities.mouseOverPersonalFinance(driver, baseUrl))
					return false;
			}catch(Exception ex) {
				return false;
			}
		return true;
	}
	
	public boolean calculateHomeLoanEMI(WebDriver driver) throws InterruptedException
	{

		if(!SubActivities.enterValueLoanAmount(driver)) return false;
		if(!SubActivities.enterValueLoanPeriod(driver)) return false;
		if(!SubActivities.selectEMIStartsFrom(driver)) return false;
		if(!SubActivities.enterInterestRate(driver)) return false;
		
		if(!SubActivities.enterValueUpfrontCharges(driver)) return false;
		if(!SubActivities.clickSubmit(driver)) return false;
		
		return true;
	}
	
	public String getTotalPayment(WebDriver driver) throws Exception{
		WebElement totalPayment = SubActivities.getTotalPaymentElement(driver);
			
		return totalPayment.getText();
	}
	
	
	
	public String getEMI(WebDriver driver) throws Exception{
		WebElement ele = getEmiElement(driver);
		
		return ele.getText();
	}
	
	public String getTableDetails7thYearEMIPaymentInTheYear(WebDriver driver) throws InterruptedException{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,600)", "");
		return driver.findElement(By.xpath(getXpathfor7thYearEMIPayment())).getText();
	}
	public String getTableDetails7thYearInterestPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return driver.findElement(By.xpath(getXpathfor7thYearInterestPayment())).getText();
	}
	public String getTableDetails7thYearPrincipalPaymentInTheYear(WebDriver driver) throws InterruptedException{
		return driver.findElement(By.xpath(getXpathfor7thYearPrincipalPayment())).getText();
	}
	public String getTableDetails5thYearOutstandingPrincipalAtTheEndOfYear(WebDriver driver) throws InterruptedException{
		return driver.findElement(By.xpath(getXpathfor5thYearOutstandingPrincipalPayment())).getText();
	}

}
