package PageObjects;

import java.util.List;


import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;



public class AbsenceClaimPage_CV extends DriverScript{
	
	public static final  String sectionAbsenceDates="//h3[text() ='Dates']/../../../../../../.."; 
	public static final String sectionAbsences ="//h3[text()='Absences']/../../../../../following-sibling::div[@class='pbBody']";
	public static final String tblRecentAbsenceClaimsAbsenceClaim="//div[@title='Action']/..//ancestor::div[@class='x-grid3-viewport']/child::div[2]/child::div[@class='x-grid3-body']";
	public static final String txtAbsenceClaimDetailPageHeader="//h1[@class='pageType']";
	public static final String sectionEliminationPeriods="//h3[text()='Waiting and Elimination Periods']/..//following::div[1]";
	public static final String sectionClaim="//h3[text()='Claim']/../following-sibling::div[1]";
	
	//Function for clicking Absence Claim ID in absence claim table..
		public static boolean clickingAbsenceClaimFromTable(Browser browser,String AbsenceClaimId)
		{
			boolean clickingAbsenceClaimFromTable = false;
			try
			{
				boolean fnStatus = ContactsPage_CV.clickingRecordValueOfTable(browser, tblRecentAbsenceClaimsAbsenceClaim, AbsenceClaimId);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "pass", AbsenceClaimId + " : Should be clicked successfully!!");
					clickingAbsenceClaimFromTable = true;
				} 
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on Absence Claim");
					errorCount++;
					clickingAbsenceClaimFromTable = false;
				}
			} 
			catch (Throwable t)
			{
				System.out.println("The Exception for clickingAbsenceClaimFromTable is : " + t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingAbsenceClaimFromTable is : " + t.getMessage());
				softAssert.fail("The Exception for clickingAbsenceClaimFromTable is : " + t.getMessage());
				errorCount++;
				clickingAbsenceClaimFromTable = false;

			}
			return clickingAbsenceClaimFromTable;
		}
		//Function for navigating to the Absence Claim Detail page.. 
		public static boolean confirmingAbsenceClaimNavigation(Browser browser)
		{
			boolean confirmingAbsenceClaimNavigation = false;
			try
			{
				boolean fnStatus = isElementExist(browser, txtAbsenceClaimDetailPageHeader);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "Pass", "Navigated to 'Absence Claims' Detail Page successfully");
							confirmingAbsenceClaimNavigation = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to 'Absence Claims' Detail Page");
							errorCount++;
							confirmingAbsenceClaimNavigation = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for confirmingAbsenceClaimNavigation is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for confirmingAbsenceClaimNavigation is : "+t.getMessage());
				softAssert.fail("The Exception for confirmingAbsenceClaimNavigation is : "+t.getMessage());
				errorCount++;
				confirmingAbsenceClaimNavigation = false;
				
			}
			return confirmingAbsenceClaimNavigation;
		}
		
	
	//Clicking on Name related link of Dates section 
	public static boolean clickingLinkOfAbsenceDatesAction(Browser browser, String datesName,String action)
	{
		
		boolean clickingLinkOfAbsenceDatesAction = false;
		int j =0;
		try
		{
			boolean fnStatus = false;
			String tableXpath = sectionAbsenceDates.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if(fnStatus == true)
			{
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop:
				for(int i=2; i<=rowCount; i++)
				{
					
					String aTagXPath = tableXpath+"//tr["+i+"]//a";
					Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
					
					//List<WebElement> atagElements =driver.findElements(By.xpath(aTagXPath));
					for(Link atag : allLinks)
					{
						String atagText = atag.getInnerText();
						if(atagText.equals(datesName))
						{
							
							for(Link atagElement : allLinks)
							{
								String atagElementText = atagElement.getInnerText();
								if(atagElementText.equals(action))
								{
									String elementXpath = aTagXPath+"[text()='" + action + "']";	
									fnStatus =GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
									if(fnStatus==true)
									{
										clickingLinkOfAbsenceDatesAction = true;
									}
									else
									{
										ReportEvent.testStepReport("", "fail", "Failed to click Dates action");
										errorCount++;
										clickingLinkOfAbsenceDatesAction = false;	
									}
									
									break outerloop;
								}
								else
								{
									continue;
								
								}}}
					else
						{
								
						}
					
					}}
				
				clickingLinkOfAbsenceDatesAction = true;
			}
			else
			{
				
				ReportEvent.testStepReport("", "fail", "Absences  dates dynamic table is not available");
				errorCount++;
				clickingLinkOfAbsenceDatesAction = false;
			}
		}
		catch(Throwable t)
		{
			System.out.println("The Exception for clickingLinkOfAbsenceDatesAction is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickingLinkOfAbsenceDatesAction is : " + t.getMessage());
			softAssert.fail("The Exception for clickingLinkOfAbsenceDatesAction is : " + t.getMessage());
			errorCount++;
			clickingLinkOfAbsenceDatesAction = false;
		}
		return clickingLinkOfAbsenceDatesAction;
	}

	//Clicking on Subject related link of Absences section 
	public static boolean clickingLinkOfAbsenceAction(Browser browser, String absenceSubjectValue,String action)
	{
		
		boolean clickingLinkOfAbsenceAction = false;
		int j =0;
		try
		{
			boolean fnStatus = false;
			String tableXpath = sectionAbsences.concat("//table");
			fnStatus = isElementExist(browser, tableXpath);
			if(fnStatus == true)
			{
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop:
				for(int i=2; i<=rowCount; i++)
				{
					
					String aTagXPath = tableXpath+"//tr["+i+"]//a";
					Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
					//List<WebElement> atagElements =driver.findElements(By.xpath(aTagXPath));
					for(Link atag : allLinks)
					{
						String atagText = atag.getInnerText();
						if(atagText.equals(absenceSubjectValue))
						{
							
							for(Link atagElement : allLinks)
							{
								String atagElementText = atagElement.getInnerText();
								if(atagElementText.equals(action))
								{
									String elementXpath = aTagXPath+"[text()='" + action + "']";	
									fnStatus =GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
									break outerloop;
								}
								else
								{
									continue;
								
								}
								
								
								
							}
					
						}
					else
						{
								
						}
					
							}
				}
				
				clickingLinkOfAbsenceAction = true;
			}
			else
			{
				System.out.println("Absences dynamic table is not available");
				errorCount++;
				clickingLinkOfAbsenceAction = false;
			}
		}
		catch(Throwable t)
		{
			System.out.println("The Exception for clickingLinkOfAbsenceAction is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickingLinkOfAbsenceAction is : " + t.getMessage());
			softAssert.fail("The Exception for clickingLinkOfAbsenceAction is : " + t.getMessage());
			errorCount++;
			clickingLinkOfAbsenceAction = false;
		}
		return clickingLinkOfAbsenceAction;
	}
	//Checking script
	
	/*public static boolean verifyingClaimDaysOFEliminationPeriodTrial(String testName, WebDriver driver,String eliminationPeriod,String claimstartDate,String claimEndDate)
	{
		boolean verifyingClaimDaysOFEliminationPeriod=false;
		
		String eliminationPeriodValue;
		
		try
		{
			String formattedClaimStartDate = dateConversionFromddMMMYYYYTodMYYYY(claimstartDate);
			String formattedClaimEndDate=dateConversionFromddMMMYYYYTodMYYYY(claimEndDate);
			
				String startDate="01/14/2015"; 
				String endDate="01/22/2015";
				eliminationPeriodValue=getFieldValueOfSection(testName, driver, eliminationPeriod, sectionEliminationPeriods);
				System.out.print(eliminationPeriodValue);
				
				SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
				Date  d1 = format.parse(formattedClaimStartDate);
				Date  d2 = format.parse(formattedClaimEndDate);
				long diff = d2.getTime() - d1.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				long eliminatinvalue = Integer.parseInt(eliminationPeriodValue);
				if(diffDays > eliminatinvalue)
				{
					ReportEvent.testStepReport(testName, "PASS", "Difference between the claim date is GREATER than the Elimination period");
					verifyingClaimDaysOFEliminationPeriod = true;
					//System.out.println("Difference between the claim date is LESS than the Elimination period");
				}
				else if(diffDays < eliminatinvalue)
				{
					ReportEvent.testStepReport(testName, "PASS", "Difference between the claim date is LESS than the Elimination period");
					verifyingClaimDaysOFEliminationPeriod = true;
					//System.out.println("Difference between the claim date is GRATER than the Elimination period");
				}
				else
				{
					
					ReportEvent.testStepReport(testName, "FAIL", "Difference between the claim date is EQUAL to Elimination period");
					errorCount++;
					verifyingClaimDaysOFEliminationPeriod = false;
					//System.out.println("Difference between the claim date is EQUAL to Elimination period");
				}
				
			
			}
		catch(Throwable t)
		{
			System.out.println("The Exception for verifyingClaimDaysOFEliminationPeriod is : "+t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for verifyingClaimDaysOFEliminationPeriod is : "+t.getMessage());
			softAssert.fail("The Exception for verifyingClaimDaysOFEliminationPeriod is : "+t.getMessage());
			errorCount++;
			verifyingClaimDaysOFEliminationPeriod = false;
			
		}
		return verifyingClaimDaysOFEliminationPeriod;
	}
	
	
	
	
	

	
	//Compare claim startDate between Effective Start and EffectiveEndDate of policy
	public static boolean compareClaimStartDatebetweenEffectiveStartEndDatePolicy( String testName, WebDriver driver,String claimStartdateValue,
			String policyEffectiveStartDateField, String policyEffectiveEndDateField)
	{
		boolean compareClaimStartDatebetweenEffectiveStartEndDatePolicy =false;
		try
		{
		String date1= claimStartdateValue;
		String formattedClaimStartDate = dateConversionFromddMMMYYYYTodMYYYY(date1);
		//String date1="10/05/1832";--start date
		String date2= getPolicyEffectiveStartDate( testName,  driver, policyEffectiveStartDateField);
		
		//String date2="01/01/1901"; -- Effective Date
		//String date3="12/31/9999"; --Expiration Date
		String tempdate3 =null;getPolicyEffectiveEndDate( testName,  driver, policyEffectiveEndDateField);
		String date3 = "12/31/9999";null;
		if(tempdate3.isEmpty())
		{
			date3="12/31/9999";
		}
		else
		{
			date3 = tempdate3;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy",Locale.ENGLISH);
		LocalDate localdate1 = LocalDate.parse(formattedClaimStartDate, formatter);
		LocalDate localdate2 = LocalDate.parse(date2, formatter);
		LocalDate localdate3 = LocalDate.parse(date3, formatter);			
		Date claimstartDate = java.sql.Date.valueOf(localdate1);
		Date effectiveStartDate = java.sql.Date.valueOf(localdate2);
		Date expirationDate = java.sql.Date.valueOf(localdate3);		
		if(claimstartDate.after(effectiveStartDate) && claimstartDate.before(expirationDate))
			{
				System.out.println("Claim start date :" + claimstartDate + ", is in between Policy EffectiveStart date : "+ effectiveStartDate + " and End date : " + expirationDate);
				ReportEvent.testStepReport(testName, "PASS", "Claim start date :" + claimstartDate + ", is in between Policy EffectiveStart date : "+ effectiveStartDate + " and End date : " + expirationDate);
				compareClaimStartDatebetweenEffectiveStartEndDatePolicy = true;
			}
		else
			{
				System.out.println("Claim start date :" + claimstartDate + ", is NOT in between Policy EffectiveStart date : "+ effectiveStartDate + " and End date : " + expirationDate);
				ReportEvent.testStepReport(testName, "FAIL", "Claim start date :" + claimstartDate + ", is NOT in between Policy EffectiveStart date : "+ effectiveStartDate + " and End date : " + expirationDate);
				errorCount++;
				compareClaimStartDatebetweenEffectiveStartEndDatePolicy = false;
			}
	}
		catch(Throwable t)
			{
				System.out.println("The Exception for compareClaimStartDatebetweenEffectiveStartEndDatePolicy is : "+t.getMessage());
				Utility.fnLogging("The Exception for compareClaimStartDatebetweenEffectiveStartEndDatePolicy is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for compareClaimStartDatebetweenEffectiveStartEndDatePolicy is : "+t.getMessage());
				softAssert.fail("The Exception for compareClaimStartDatebetweenEffectiveStartEndDatePolicy is : "+t.getMessage());
				errorCount++;
				compareClaimStartDatebetweenEffectiveStartEndDatePolicy = false;
			}
	  return compareClaimStartDatebetweenEffectiveStartEndDatePolicy;
	}

	//Function for comparing claim start date in between Policy start date and Through dates..
	public static boolean compareClaimStartDateBetweenPolicyStartAndThroughDates(String testName, WebDriver driver, 
			String primaryKeyValue, String startDateHeader, String PrimaryKeyHeader, String throughDateHeader,
			 String claimStartDate)
			{
				boolean compareClaimStartDateBetweenPolicyStartAndThroughDates =false;
				try
				{
					String formattedClaimStartDate = dateConversionFromddMMMYYYYTodMYYYY(claimStartDate);
					String polStartDate = getPolicyStartDate( testName,  driver, primaryKeyValue,  PrimaryKeyHeader,  startDateHeader); 
					String polThroughDate = getPolicyThroughDate( testName,  driver, primaryKeyValue,  PrimaryKeyHeader,  throughDateHeader);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
					LocalDate localdateStart = LocalDate.parse(polStartDate, formatter);
					LocalDate localdateThrough = LocalDate.parse(polThroughDate, formatter);
					LocalDate localdateClaimStart = LocalDate.parse(formattedClaimStartDate, formatter);
					Date dateClaimStart = java.sql.Date.valueOf(localdateClaimStart);
					Date startDatePolicy = java.sql.Date.valueOf(localdateStart);
					Date ThroughDatePolicy = java.sql.Date.valueOf(localdateThrough);
					if(dateClaimStart.after(startDatePolicy) && dateClaimStart.before(ThroughDatePolicy))
					{
						ReportEvent.testStepReport(testName, "PASS", "Claim start date :" + dateClaimStart + ", is in between Start date : "+ startDatePolicy + " and Through date : " + ThroughDatePolicy);
						compareClaimStartDateBetweenPolicyStartAndThroughDates = true;
					}
					else
					{
						ReportEvent.testStepReport(testName, "FAIL", "Claim start date :" + dateClaimStart + ", is NOT in between Start date : "+ startDatePolicy + " and Through date : " + ThroughDatePolicy);
						errorCount++;
						compareClaimStartDateBetweenPolicyStartAndThroughDates = false;
					}
				}
			catch(Throwable t)
				{
				System.out.println("The Exception for compareClaimStartDateBetweenPolicyStartAndThroughDates is : "+t.getMessage());
				Utility.fnLogging("The Exception for compareClaimStartDateBetweenPolicyStartAndThroughDates is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for compareClaimStartDateBetweenPolicyStartAndThroughDates is : "+t.getMessage());
				softAssert.fail("The Exception for compareClaimStartDateBetweenPolicyStartAndThroughDates is : "+t.getMessage());
				errorCount++;
				compareClaimStartDateBetweenPolicyStartAndThroughDates = false;
				
			}
			return compareClaimStartDateBetweenPolicyStartAndThroughDates;
		}
*/
	
	
}
