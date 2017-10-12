package PageObjects;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

public class ReassignmentPage_CV extends DriverScript{
	
	public static final String sectionSearchCriteria="//h3[text()='Search Criteria']/../..";
	public static final String tblSearchResults="//table[@class='list tablesorter']";
	public static final String txtUpdatedMessage="//div[@role='alert']//div[@class='messageText']";
	public static final String txtBCReassignmentHeader="//h1[text()='Benefit Claimed Reassignment']";
	public static final String txtAssignedUser="//img[contains(@title,'User Lookup')]/../..//child::input";
	public static final String tblSearchResultsRecords="//div[text()='Select']/../../..//parent::table";
	
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	
	//Function for selecting Benefit claimed status dropdown valu based on label..
	public static void selectingBenefitClaiedStatusValue(String testCaseName,Browser browser,String labelName,String dropdownValue)
	{
		try
		{
			boolean fnStatus=isElementExist(browser, sectionSearchCriteria);
			if(fnStatus=true)
			{
			fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, labelName, dropdownValue);
			GenericClass.reportlogger(fnStatus, testCaseName, "Selected Benefit Climed Status Dropdown Value as:"+dropdownValue);
			}
			else
			{
				ReportEvent.testStepReport("", "fail", "Search Criteria section Is not available.");	
			}
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("The Exception for selectingBenefitClaiedStatusValue is : ", t);
		}
	}
	
	//Function for Selecting the check box under search results section..
	
	public static void selectingCheckBoxUnderSearchResultsPage(String testCaseName,Browser browser,String checkBoxStatus)
		{
		try
		{
			boolean fnStatus = false;
			int i=0;
			fnStatus = isElementExist(browser, tblSearchResults);
			if(fnStatus == true)
			{
				int rowCount = GenericClass.fngetTableRowCount(browser, tblSearchResults);
				if(rowCount>1)
				{
					
	outerloop:	for(i=1; i<=rowCount;i++)
				{
					String tdTagXpath=tblSearchResults+"/tbody/tr["+i+"]//td";
					WebElement[] tdTags = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(tdTagXpath).build());
					for(int j=0;j<= tdTags.length;j++)
					{
							String inputXpath=tdTagXpath.concat("//input");
							fnStatus = GenericClass.fncheckBoxValidation(browser, inputXpath, checkBoxStatus);
							break;
						}
					if(i==2)
					break outerloop;
					}
				}
				else
				{
					ReportEvent.testStepReport("", "fail", "No Records arae available in Search results table.");
				}
					}
			else
			{
				ReportEvent.testStepReport("", "fail", "Search results dynamic table is not available");
			}
		
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("The Exception for selectingCheckBoxUnderSearchResultsPage is : ",t);
		}
		}
	
	// generic clicking of button based on header & button name
		public static boolean  ClickOnButton(Browser browser, String buttonName,String searchheader)
			{
			boolean clickButtonOfBenefitClaimedCreationPage = false;
			try
			{
				boolean fnStatus = false;
				String buttonXpath = "//h2[text()='"+searchheader+"']/../../../..//child::div[@class='pbHeader']//child::input[@class='btn' and @value ='" + buttonName + "']";                    
				fnStatus = isElementExist(browser, buttonXpath);
				GenericClass.reportlogger(fnStatus,tTestCaseName,buttonXpath + ", element available.");
				if(fnStatus ==true) 
				{
					fnStatus = fnButtonClick(browser, buttonXpath);
					GenericClass.reportlogger(fnStatus,tTestCaseName,"Clicked on " + buttonName);
				}
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedCreationPage is : ",t);
			}
			return  clickButtonOfBenefitClaimedCreationPage;
			}  

		//Function for verifying Updated successfully message..
		public static void verifyingUpdatedMessage(String testCaseName,Browser browser,String updateMesg)
		{
			try
			{
			boolean fnStatus=false;
			WebElement message=browser.describe(WebElement.class, new XPathDescription(txtUpdatedMessage));
				message.highlight();
				String updatedMsg=message.getInnerText();
			fnStatus=(updatedMsg.contains(updateMesg));
			GenericClass.reportlogger(fnStatus,testCaseName,"Validated : "+updatedMsg+"");	
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for verifyingUpdatedMessage  is : ",t);
			}
		}

	//Function for filling Search criteria section fields based on user inputs..
		public static void fillingSearchCriteriaSectionFields(String testCaseName,Browser browser,String setText,String labelName,String dropdownValue,
																	String policyLabel)
		{
			try
			{
			//Entering Assigned user name as CV management name..
				boolean fnStatus=GenericClass.fnEditFieldTextEntry(browser, txtAssignedUser, setText);
				GenericClass.reportlogger(fnStatus, testCaseName, "Entered CV Management Name as:"+setText);
				//selecting Benefit Claimed Status dropdown value..
				selectingBenefitClaiedStatusValue(testCaseName, browser, labelName, dropdownValue);
				//getting policyNumber
				File f = new File(configFilepath);
				FileReader fr = new FileReader(f);
				 Properties prop = new Properties();
				 prop.load(fr);
				String policyNumber = prop.getProperty("policyID");
				 
				fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser, policyLabel, policyNumber);
				GenericClass.reportlogger(fnStatus, testCaseName, "Entered Policy Number as:"+policyNumber);
				
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for fillingSearchCriteriaSectionFields  is : ", t);
			}
		}

		//Function for checking Benefit Claimed list...
			public static void checkingBenefitClaimedList(String testCaseName,Browser browser)
			{
				try
				{
					boolean fnStatus = isElementExist(browser, tblSearchResults);
					if(fnStatus == true)
					{
						int rowCount = GenericClass.fngetTableRowCount(browser, tblSearchResults);
						if(rowCount>1)
						GenericClass.reportlogger(fnStatus, testCaseName, "List of benefit Claimed displayed as");
					}
					else
					{
						
						ReportEvent.testStepReport("", "fail", "Benefit Claimed List table not available");
					}
					}
				catch(Throwable t)
				{
				GenericClass.Catchhandler("The Exception for checkingBenefitClaimedList  is : ", t);	
				}
				
				}
			//Clicking on Benefit claimed related checkbox..
			public static void clickingBefitClaimedRelatedCheckBox(String testCaseName,Browser browser, String bcId,String checkBoxValue)
			{
				try
				{
					boolean fnStatus = false;
					fnStatus = isElementExist(browser, tblSearchResults);
					if(fnStatus == true)
					{
						int rowCount =GenericClass.fngetTableRowCount(browser, tblSearchResults);
						outerloop:
						for(int i=2; i<=rowCount; i++)
						{
							
							String aTagXPath = tblSearchResults+"//tr["+i+"]//a";
							Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
							for(Link atag : allLinks)
							{
								String atagText = atag.getInnerText();
								if(atagText.equals(bcId))
								{
								
									String inputXpath=tblSearchResults+"//tr["+i+"]//input";
									GenericClass.fncheckBoxValidation(browser, inputXpath, checkBoxValue);
									
								}
								else
								{
									ReportEvent.testStepReport("", "fail", "Benefit Claimed Id Is not matched.");
								}
								
								}
						}
					}
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for clickingBefitClaimedRelatedCheckBox  is : ", t);
				}
			}
	//Function for Entering New assigned user name..
			
			public static void enteringNewAssignedUserName(String testCaseName,Browser browser,String setText)
			{
				try
				{
					boolean fnStatus=GenericClass.fnEditFieldTextEntry(browser, txtAssignedUser, setText);
					GenericClass.reportlogger(fnStatus, testCaseName, "Entered CV Claim Handler User Name as:"+setText);
					
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for enteringNewAssignedUserName  is : ", t);
				}
			}
			
			//Function for Verifying CV Claim handler name in Search Results Section..
 			public static void verifyCVclaimHandlerUserName(String testCaseName, Browser browser, String assignedUserName)
 			{
 				try
 				{
 					boolean fnStatus = false;
 					fnStatus = isElementExist(browser, tblSearchResultsRecords);
 					if(fnStatus == true)
 					{
 						int rowCount = GenericClass.fngetTableRowCount(browser, tblSearchResultsRecords);
 						outerloop:
 						for(int i=1; i<=rowCount; i++)
 						{
 							//div[text()='Select']/../../..//parent::table//following::tr[3]
 							//String subjectxPath = tblSearchResultsRecords.concat("//th/a");
 							
 							String subjectxPath = tblSearchResultsRecords+"//following::tr["+i+"]//a";
 							
 							Link[] aTagObject = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(subjectxPath).build());
 							
 							for (Link cell : aTagObject)
 							{
 								
 									if(cell.getInnerText().contains(assignedUserName))
 									{
 										System.out.println(cell.getInnerText());
 										cell.highlight();
 											ReportEvent.testStepReport(testCaseName, "PASS", "Verified CV Claim Handler Name as :"+assignedUserName+" "  );
 											break outerloop;
 										}
 										else
 										{
 											continue;
 											
 										}
 										
 									}
 							}
 						}
 					
 							
 					else
 					{
 						ReportEvent.testStepReport(testCaseName, "Fail", "Search results dynamic table is not available");
 					}
 						
 				}
 				catch(Throwable t)
 				{
 					GenericClass.Catchhandler("The Exception for verifyCVclaimHandlerUserName is : ", t);
 				}
 				
 				
 			}
 			
 			//Function for clicking BC link in Search Results Section..
 			public static void clickingBCLinkInSearchResultsSection(String testCaseName, Browser browser, String assignedUserName)
 			{
 				try
 				{
 					boolean fnStatus = false;
 					fnStatus = isElementExist(browser, tblSearchResultsRecords);
 					if(fnStatus == true)
 					{
 						int rowCount = GenericClass.fngetTableRowCount(browser, tblSearchResultsRecords);
 						outerloop:
 						for(int i=1; i<=rowCount; i++)
 						{
 							//String subjectxPath = tblSearchResultsRecords.concat("//th/a");
 							
 							String subjectxPath = tblSearchResultsRecords+"//following::tr["+i+"]//a";
 							
 							Link[] aTagObject = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(subjectxPath).build());
 							
 							for (Link cell : aTagObject)
 							{
 								
 									if(cell.getInnerText().contains(assignedUserName))
 									{
 										System.out.println(cell.getInnerText());
 										cell.highlight();
 										cell.click();
 											ReportEvent.testStepReport(testCaseName, "PASS", "Clicked on BenefitClaimed id as:"+cell );
 											break outerloop;
 										}
 										else
 										{
 											continue;
 										}
 									}
 							}
 						}
 					
 							
 					else
 					{
 						ReportEvent.testStepReport(testCaseName, "Fail", "Search results dynamic table is not available");
 					}
 						
 				}
 				catch(Throwable t)
 				{
 					GenericClass.Catchhandler("The Exception for clickingBCLinkInSearchResultsSection is : ", t);
 				}
 			}
 			
 			//Function for verifying assigned user name in benefit claimed details page..
 			public static void verifyingAssignedUserName(String testCaseName,Browser browser,String labelName)
 			{
 				try
 				{
 					
 				}
 				catch(Throwable t)
 				{
 					
 				}
 			}
 			
}
