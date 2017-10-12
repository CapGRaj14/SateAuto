package PageObjects;


import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.Frame;
import com.hp.lft.sdk.web.FrameDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

public class ClaimsPage_CV extends DriverScript{
	
	public static final String txtClaimsHeader="//h1[text()='Claims']";
	public static final String btnNew="//h3[text()='Recent Claims']/../..//input";
	public static final String txtNewClaimHeader="//h2[text()=' New Claim']";
	public static final String sectionClaimInfo="//h3[text()='Information']/..//parent::div[@class='pbBody']";
	public static final String sectionClaimRelationship="//h3[text()='Claim Relationships']/../../../../../..//parent::div[contains(@class,'listRelatedObject')]";
	public static final String txtClaimRelationshipHeader="//h3[text()='Claim Relationships']";
	public static final String btnNewClaimRelationShip="//h3[text()='Claim Relationships']/../..//input";
	public static final String txtNewClaimRelationShipHeader="//h2[text()=' New Claim Relationship']";
	public static final String sectionClaimRelationShipInfo="//h3[text()='Information']/../..";
	public static final String tblClaimRelationShipDetail="//td[text()='Claim Relationship Name']/../../../..";
	public static final String txtClaimHeader="//h1[text()='Claim']";
	public static final String sectionRecentClaims="//h3[text()='Recent Claims']/../../../../../../..";
	public static final String buttonxpath2="']";
	public static final String btnClaimRelationshipEditPage="//h2[text()='Claim Relationship Edit']/../../../..//input[@class='btn' and @title ='" ;

	
	
	//Function for confirming Claims Home page navigation..
			public static boolean confirmingClaimsPageNavigation(Browser browser)
			{
				boolean confirmingClaimsPageNavigation = false;
				try
				{
					boolean fnStatus = isElementExist(browser, txtClaimsHeader);
							if(fnStatus ==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Claims Home Page successfully!!");
								confirmingClaimsPageNavigation = true;
							}
							else 
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Claims Home Page");
								errorCount++;
								confirmingClaimsPageNavigation = false;
							}
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for confirmingClaimsPageNavigation is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for confirmingClaimsPageNavigation is : "+t.getMessage());
					softAssert.fail("The Exception for confirmingClaimsPageNavigation is : "+t.getMessage());
					errorCount++;
					confirmingClaimsPageNavigation = false;
					
				}
				return confirmingClaimsPageNavigation;
			}
			//Function for clicking New Button..
			public static boolean clickingNewButton(Browser browser)
			{
				boolean clickingNewButton = false;
				try
				{
					boolean fnStatus = fnButtonClick(browser, btnNew);
							if(fnStatus ==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "New button Should be clicked successfully");
								clickingNewButton = true;
							}
							else 
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'New' button is not clicked ");
								errorCount++;
								clickingNewButton = false;
							}
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for clickingNewButton is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for clickingNewButton is : "+t.getMessage());
					softAssert.fail("The Exception for clickingNewButton is : "+t.getMessage());
					errorCount++;
					clickingNewButton = false;
				}
				return clickingNewButton;
			}
			//Function for Confirming New Claim page navigation.
			public static boolean confirmingNewClaimPageNavigation(Browser browser)
			{
				boolean confirmingNewClaimPageNavigation = false;
				try
				{
					boolean fnStatus = isElementExist(browser, txtNewClaimHeader);
							if(fnStatus ==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to New Claim Page successfully!!");
								confirmingNewClaimPageNavigation = true;
							}
							else 
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to New Calim Page");
								errorCount++;
								confirmingNewClaimPageNavigation = false;
							}
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for confirmingNewClaimPageNavigation is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for confirmingNewClaimPageNavigation is : "+t.getMessage());
					softAssert.fail("The Exception for confirmingNewClaimPageNavigation is : "+t.getMessage());
					errorCount++;
					confirmingNewClaimPageNavigation = false;
					
				}
				return confirmingNewClaimPageNavigation;
			}
			
	
	//Function to click on either Save Or Save & New Or Cancel button of "Claim Edit", Page based on the user inputs..
		public static boolean  clickButtonOfClaimEditPage(Browser browser, String buttonName)
		{
		boolean clickButtonOfClaimEditPage = false;
		try
		{
			boolean fnStatus = false;
			String buttonXpath = "//h2[text()='Claim Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
			fnStatus = isElementExist(browser, buttonXpath);
			if(fnStatus ==true)
			{
				fnStatus = fnButtonClick(browser, buttonXpath);
				if(fnStatus ==true)
				{
					ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on " + buttonName + ", button successfully.");
					clickButtonOfClaimEditPage = true;
				}
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail( "Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfClaimEditPage = false;
				}
				
			}
			else
			{
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfClaimEditPage = false;
			}
		}
		catch(Throwable t)
		{
			System.out.println("The Exception for clickButtonOfClaimEditPage is : "+t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickButtonOfClaimEditPage is : "+t.getMessage());
			softAssert.fail("The Exception for clickButtonOfClaimEditPage is : "+t.getMessage());
			errorCount++;
			clickButtonOfClaimEditPage = false;
		}
		return  clickButtonOfClaimEditPage;
		
	} 
	
		
		/*//Function for clicking New Claim Relationship Button..
		public static boolean clickingNewClaimRelationshipButton(Browser browser)
		{
			boolean clickingNewClaimRelationshipButton = false;
			try
			{
				boolean fnStatus = fnButtonClick(browser, btnNewClaimRelationShip);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "New Claim Relationship button Should be clicked successfully");
							clickingNewClaimRelationshipButton = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'New Claim Relationship' button is not clicked ");
							errorCount++;
							clickingNewClaimRelationshipButton = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for clickingNewClaimRelationshipButton is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingNewClaimRelationshipButton is : "+t.getMessage());
				softAssert.fail("The Exception for clickingNewClaimRelationshipButton is : "+t.getMessage());
				errorCount++;
				clickingNewClaimRelationshipButton = false;
			}
			return clickingNewClaimRelationshipButton;
		}*/
	
		//Function for Confirming New Claim Relationship page navigation.
		public static boolean confirmingNewClaimRelationshipPageNavigation(Browser browser)
		{
			boolean confirmingNewClaimRelationshipPageNavigation = false;
			try
			{
				boolean fnStatus = isElementExist(browser, txtNewClaimRelationShipHeader);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to New Claim Relationship Page successfully!!");
							confirmingNewClaimRelationshipPageNavigation = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to New Calim Relationship Page");
							errorCount++;
							confirmingNewClaimRelationshipPageNavigation = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for confirmingNewClaimRelationshipPageNavigation is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for confirmingNewClaimRelationshipPageNavigation is : "+t.getMessage());
				softAssert.fail("The Exception for confirmingNewClaimRelationshipPageNavigation is : "+t.getMessage());
				errorCount++;
				confirmingNewClaimRelationshipPageNavigation = false;
				
			}
			return confirmingNewClaimRelationshipPageNavigation;
		}
		
		//Function for confirming Claim Relationship section navigation..
				public static boolean navigatedToClaimRelationshipSec(Browser browser)
				{
					boolean navigatedToClaimRelationshipSec = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtClaimsHeader);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Claim Relationship section successfully!!");
									navigatedToClaimRelationshipSec = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Claim Relationship section");
									errorCount++;
									navigatedToClaimRelationshipSec = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for navigatedToClaimRelationshipSec is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for navigatedToClaimRelationshipSec is : "+t.getMessage());
						softAssert.fail("The Exception for navigatedToClaimRelationshipSec is : "+t.getMessage());
						errorCount++;
						navigatedToClaimRelationshipSec = false;
						
					}
					return navigatedToClaimRelationshipSec;
				}
			
				
				//Function for verifying Status field contains default as Pending..
				
				public static boolean verifyingStatusDropdownFieldAsPending(Browser browser,String dopdownValue )
				{
					boolean verifyingStatusDropdownFieldAsPending=false;
					try
					{
						boolean fnStatus=false;
						String statusXpath=sectionClaimInfo.concat("//select[contains(@name,'A2IpU')]");
						fnStatus = GenericClass.fnClickListBox(browser, statusXpath);
						if (fnStatus == true) 
						{
							fnStatus =fnListBox(browser, statusXpath, dopdownValue);
							if (fnStatus == true)
							{
								ReportEvent.testStepReport(tTestCaseName, "PASS", dopdownValue+ ": As default value in Status Dropdown !! ");
								verifyingStatusDropdownFieldAsPending = true;

							} 
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL",dopdownValue + ": is NOT default value in Status Dropdown!! ");
								verifyingStatusDropdownFieldAsPending = false;
							}
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Didn't clicked on 'Status' related drop down");
							errorCount++;
							verifyingStatusDropdownFieldAsPending = false;
						}

						
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for verifyingStatusFieldsAsRequired is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for verifyingStatusFieldsAsRequired is : "+t.getMessage());
						softAssert.fail("The Exception for verifyingStatusFieldsAsRequired is : "+t.getMessage());
						errorCount++;
						verifyingStatusDropdownFieldAsPending=false;
					}
					return verifyingStatusDropdownFieldAsPending;
				}
				
				
				//Function for verifying Status field marked as Required..
				public static boolean verifyingStatusFieldsAsRequired(Browser browser, String labelName)
				{
					boolean verifyingStatusFieldsAsRequired=false;
					try
					{
						boolean fnStatus=false;
						fnStatus = GenericClass.checkRequiredFieldAvailabilityBasedOnLabel(browser, labelName);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport("", "pass", labelName+ " is marked as Required as expected.!!");
						}
						else
						{
							ReportEvent.testStepReport("", "Fail", labelName+ " is NOT marked as Required.");
							errorCount++;
						}
						/*String statusRequiredXpath=sectionClaimInfo.concat("//label[text()='Status']/../..//div[@class='requiredBlock']");
						fnStatus=isElementExist(browser, statusRequiredXpath);
						if(fnStatus==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Verified the Status field marked as Required.!!");
							verifyingStatusFieldsAsRequired = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Verify the Status field marked as Required");
							errorCount++;
							verifyingStatusFieldsAsRequired = false;
						}*/
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for verifyingStatusFieldsAsRequired is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for verifyingStatusFieldsAsRequired is : "+t.getMessage());
						softAssert.fail("The Exception for verifyingStatusFieldsAsRequired is : "+t.getMessage());
						errorCount++;
						/*verifyingStatusFieldsAsRequired=false;*/
					}
					return verifyingStatusFieldsAsRequired;
				}
				//Function for Validating the Claimant/Insured field value is blank or not..
				public static boolean verifyingClaimantInjuredFieldBank(Browser browser,String fieldName)
				{
					boolean verifyingClaimantInjuredFieldBank=false;
					try
					{
						String fieldValue=GenericClass.getFieldValueOfSection(browser, fieldName, sectionClaimInfo);
						if(fieldValue.isEmpty())
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Claimant/Insured field value should be Null!!");
							verifyingClaimantInjuredFieldBank = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Claimant/Insured field value Is not Empty");
							errorCount++;
							verifyingClaimantInjuredFieldBank = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for verifyingClaimantInjuredFieldBank is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for verifyingClaimantInjuredFieldBank is : "+t.getMessage());
						softAssert.fail("The Exception for verifyingClaimantInjuredFieldBank is : "+t.getMessage());
						errorCount++;
						verifyingClaimantInjuredFieldBank=false;
					}
					return verifyingClaimantInjuredFieldBank;
				}
				
				//Function for verifying New Claim Number created or not..
				public static boolean verifyingCreatedClaimNumber(Browser browser,String fieldName)
				{
					boolean verifyingCreatedClaimNumber=false;
					try
					{
						boolean fnStatus=true;
						String table="//td[text()='Claim Number']/../../..//parent::div[@class='pbSubsection']";
						String fieldValue=GenericClass.getFieldValueOfSection(browser, fieldName, table);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Verified on " + fieldValue + " Claim Number Successfully ");
							verifyingCreatedClaimNumber = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Verify " + fieldValue + " Claim Number Successfully ");
							errorCount++;
							verifyingCreatedClaimNumber = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for verifyingCreatedClaimNumber is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for verifyingCreatedClaimNumber is : "+t.getMessage());
						softAssert.fail("The Exception for verifyingCreatedClaimNumber is : "+t.getMessage());
						errorCount++;
						verifyingCreatedClaimNumber=false;
					}
					return verifyingCreatedClaimNumber;
				}

				//Function for checking Fields are available in Claim Relation ship section based on user inputs..
				public static boolean checkingClaimRelationshipSecFields(Browser browser,String inputFieldValues)
				{
					boolean checkingClaimRelationshipSecFields=false;
					try
					{
						boolean fnStatus=isElementExist(browser, sectionClaimRelationShipInfo);
						if(fnStatus==true)
						{
							fnStatus=GenericClass.fieldAvailabilityValidation(browser, inputFieldValues, sectionClaimRelationShipInfo);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Calim Relationship Information Section fields are verified !!");
								checkingClaimRelationshipSecFields=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Calim Relationship Information Section fields are not verified !!");
								checkingClaimRelationshipSecFields=true;
							}
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", "Calim Relationship Section is not available!!");
							errorCount++;
							checkingClaimRelationshipSecFields=true;
						}
						
							}
					catch(Throwable t)
					{
						System.out.println("The Exception for checkingClaimRelationshipSecFields is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for checkingClaimRelationshipSecFields is : "+t.getMessage());
						softAssert.fail("The Exception for checkingClaimRelationshipSecFields is : "+t.getMessage());
						errorCount++;
						checkingClaimRelationshipSecFields=false;
					}
				return checkingClaimRelationshipSecFields;
				}
				//Function to click on either Save Or Save & New Or Cancel button of "Claim Relationship Edit", Page based on the user inputs..
				public static boolean  clickButtonOfClaimRelationshipEditPage(Browser browser, String buttonName)
				{
				boolean clickButtonOfClaimRelationshipEditPage = false;
				try
				{
					boolean fnStatus = false;
					String buttonXpath = "//h2[text()='Claim Relationship Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
					fnStatus = isElementExist(browser, buttonXpath);
					if(fnStatus ==true)
					{
						fnStatus = fnButtonClick(browser, buttonXpath);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on " + buttonName + ", button successfully.");
							clickButtonOfClaimRelationshipEditPage = true;
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
							softAssert.fail( "Failed to click on " + buttonName + ", button.");
							errorCount++;
							clickButtonOfClaimRelationshipEditPage = false;
						}
						
					}
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
						softAssert.fail(buttonXpath + ", element is not available.");
						errorCount++;
						clickButtonOfClaimRelationshipEditPage = false;
					}
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for clickButtonOfClaimEditPage is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for clickButtonOfClaimEditPage is : "+t.getMessage());
					softAssert.fail("The Exception for clickButtonOfClaimEditPage is : "+t.getMessage());
					errorCount++;
					clickButtonOfClaimRelationshipEditPage = false;
				}
				return  clickButtonOfClaimRelationshipEditPage;
				
			} 

				//Function for selecting relationship dropdown value...
				public static boolean selectingRelationshipDropdownValue(Browser browser,String relationshipType,String dropdownValue)
				{
					boolean selectingRelationshipDropdownValue=false;
					try
					{
						boolean fnStatus=false;
						fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, relationshipType, dropdownValue);
						if(fnStatus==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Relationship dropdown value as: "+dropdownValue+"Successfully");
							selectingRelationshipDropdownValue = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Select Relationship dropdown value as: "+dropdownValue+"");
							errorCount++;
							selectingRelationshipDropdownValue = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for selectingRelationshipDropdownValue is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for selectingRelationshipDropdownValue is : "+t.getMessage());
						softAssert.fail("The Exception for selectingRelationshipDropdownValue is : "+t.getMessage());
						errorCount++;
						selectingRelationshipDropdownValue=false;
					}
					return selectingRelationshipDropdownValue;
				}
				//Selecting Claim Relationship Contact Name  in a frame..
				public static boolean selectingContactNameFromClaimRelationshipWindowFrame(Browser browser, String nameValue)
				{
					boolean selectingContactNameFromClaimRelationshipWindowFrame= false;
					
					try
					{
						boolean fnStatus=false;
						
						
							String contactTextBoxXpath=sectionClaimRelationShipInfo.concat("//input[@name='CF00NA000000A2IoW']");
							String contactImgXpath="//input[@name='CF00NA000000A2IoW']/..//img";
							
							fnStatus =ClaimsPage_CV.selectingNameFromWindowFrame(browser, contactTextBoxXpath, contactImgXpath,nameValue );
							
							if(fnStatus == true)
							{
								ReportEvent.testStepReport(tTestCaseName, "PASS", "Selected Contact Name as :"+ nameValue);
								selectingContactNameFromClaimRelationshipWindowFrame = true;
								
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Contact Name as :"+ nameValue);
								errorCount++;
								selectingContactNameFromClaimRelationshipWindowFrame = false;
							}
						
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for selectingContactNameFromClaimRelationshipWindowFrame is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for selectingContactNameFromClaimRelationshipWindowFrame is : "+t.getMessage());
						softAssert.fail("The Exception for selectingContactNameFromClaimRelationshipWindowFrame is : "+t.getMessage());
						errorCount++;
						selectingContactNameFromClaimRelationshipWindowFrame = false;
					}
						return selectingContactNameFromClaimRelationshipWindowFrame;
				}	
				//Selecting Claim Relationship Account Name  in a frame..
				public static boolean selectingAccountNameFromClaimRelationshipWindowFrame(Browser browser, String nameValue)
				{
					boolean selectingAccountNameFromClaimRelationshipWindowFrame= false;
					
					try
					{
						boolean fnStatus=false;
						
						
							String accountTextBoxXpath=sectionClaimRelationShipInfo.concat("//input[@name='CF00NA000000A2IoS']");
							String accountImgXpath="//input[@name='CF00NA000000A2IoS']/..//img";
							
							fnStatus =ClaimsPage_CV.selectingNameFromWindowFrame(browser, accountTextBoxXpath, accountImgXpath,nameValue );
							
							if(fnStatus == true)
							{
								ReportEvent.testStepReport(tTestCaseName, "PASS", "Selected Account Name as :"+ nameValue);
								selectingAccountNameFromClaimRelationshipWindowFrame = true;
								
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Account Name as :"+ nameValue);
								errorCount++;
								selectingAccountNameFromClaimRelationshipWindowFrame = false;
							}
						
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for selectingAccountNameFromClaimRelationshipWindowFrame is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for selectingAccountNameFromClaimRelationshipWindowFrame is : "+t.getMessage());
						softAssert.fail("The Exception for selectingAccountNameFromClaimRelationshipWindowFrame is : "+t.getMessage());
						errorCount++;
						selectingAccountNameFromClaimRelationshipWindowFrame = false;
					}
						return selectingAccountNameFromClaimRelationshipWindowFrame;
				}
				
			
				
				/*//Function for confirming Claim page navigation..
				public static boolean confirmingClaimPageNavigation(Browser browser)
				{
					boolean confirmingClaimPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtClaimHeader);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "System should be displayed Claim Page successfully!!");
									confirmingClaimPageNavigation = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "System is not displaying Claim Page");
									errorCount++;
									confirmingClaimPageNavigation = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for confirmingClaimPageNavigation is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for confirmingClaimPageNavigation is : "+t.getMessage());
						softAssert.fail("The Exception for confirmingClaimPageNavigation is : "+t.getMessage());
						errorCount++;
						confirmingClaimPageNavigation = false;
						
					}
					return confirmingClaimPageNavigation;
				}*/
				//Function for Verifying New Tasks Name is displayed in Claim Relationship section..
	 			public static boolean verifyNewTaskDisplayedClaimRelSection(Browser browser, String subjectValue)
	 			{
	 				
	 				boolean verifyNewTaskDisplayedClaimRelSection = false;
	 				
	 				try
	 				{
	 					boolean fnStatus = false;
	 					String tableXpath = sectionClaimRelationship.concat("//div[@class='pbBody']//table");
	 					fnStatus = isElementExist(browser, tableXpath);
	 					if(fnStatus == true)
	 					{
	 						int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
	 						outerloop:
	 						for(int i=1; i<=rowCount; i++)
	 						{
	 							String subjectxPath = tableXpath.concat("//th/a");
	 							Link[] aTagObject = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(subjectxPath).build());
	 							for (Link cell : aTagObject)
	 							{
	 									if(cell.getInnerText().equals(subjectValue))
	 									{
	 										
	 											//ReportEvent.testStepReport(tTestCaseName, "PASS", "Contact Name value is:"+subjectValue+" updated Successfully : "  );
	 											verifyNewTaskDisplayedClaimRelSection =true;
	 											break outerloop;
	 										}
	 										else
	 										{
	 											ReportEvent.testStepReport(tTestCaseName, "Fail", "New Task  is not Updated Successfully : "  );
	 											errorCount++;
	 											verifyNewTaskDisplayedClaimRelSection =false;
	 										}
	 										
	 									}
	 							}
	 						}
	 					
	 							
	 					else
	 					{
	 						System.out.println(" Claim Relationship dynamic table is not available");
	 						errorCount++;
	 						verifyNewTaskDisplayedClaimRelSection = false;
	 					}
	 						
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for verifyNewTaskDisplayedClaimRelSection is : " + t.getMessage());
	 					ReportEvent.testStepReport("", "fail", "The Exception for verifyNewTaskDisplayedClaimRelSection is : " + t.getMessage());
	 					softAssert.fail("The Exception for verifyNewTaskDisplayedClaimRelSection is : " + t.getMessage());
	 					errorCount++;
	 					verifyNewTaskDisplayedClaimRelSection = false;
	 				}
	 				return verifyNewTaskDisplayedClaimRelSection;
	 				
	 			}
	 			
	 			//Function for verifying Contact Name in Claim relationship section..
	 			public static boolean verifyContactNameDisplayedClaimRelSection(Browser browser, String subjectValue)
	 			{
	 				
	 				boolean verifyContactNameDisplayedClaimRelSection = false;
	 				
	 				try
	 				{
	 					boolean fnStatus=verifyNewTaskDisplayedClaimRelSection(browser, subjectValue);
	 				if(fnStatus==true)
	 					{

								ReportEvent.testStepReport(tTestCaseName, "PASS", "Contact Name value is:"+subjectValue+" updated Successfully : "  );
								verifyContactNameDisplayedClaimRelSection =true;
								
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Name  is not Updated Successfully : "  );
								errorCount++;
								verifyContactNameDisplayedClaimRelSection =false;
							}
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for verifyContactNameDisplayedClaimRelSection is : " + t.getMessage());
	 					ReportEvent.testStepReport("", "fail", "The Exception for verifyContactNameDisplayedClaimRelSection is : " + t.getMessage());
	 					softAssert.fail("The Exception for verifyContactNameDisplayedClaimRelSection is : " + t.getMessage());
	 					errorCount++;
	 					verifyContactNameDisplayedClaimRelSection=false;
	 				}
	 				return verifyContactNameDisplayedClaimRelSection;
	 			}
	 			//Function for verifying Account Name in Claim relationship section..
	 			public static boolean verifyAccountNameDisplayedClaimRelSection(Browser browser, String subjectValue)
	 			{
	 				
	 				boolean verifyAccountNameDisplayedClaimRelSection = false;
	 				
	 				try
	 				{
	 					boolean fnStatus=verifyNewTaskDisplayedClaimRelSection(browser, subjectValue);
	 				if(fnStatus==true)
	 					{

								ReportEvent.testStepReport(tTestCaseName, "PASS", "Account Name value is:"+subjectValue+" updated Successfully : "  );
								verifyAccountNameDisplayedClaimRelSection =true;
								
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Account Name  is not Updated Successfully : "  );
								errorCount++;
								verifyAccountNameDisplayedClaimRelSection =false;
							}
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for verifyAccountNameDisplayedClaimRelSection is : " + t.getMessage());
	 					ReportEvent.testStepReport("", "fail", "The Exception for verifyAccountNameDisplayedClaimRelSection is : " + t.getMessage());
	 					softAssert.fail("The Exception for verifyAccountNameDisplayedClaimRelSection is : " + t.getMessage());
	 					errorCount++;
	 					verifyAccountNameDisplayedClaimRelSection=false;
	 				}
	 				return verifyAccountNameDisplayedClaimRelSection;
	 			}

	 			/////////23092017///////
	 			//Function for checking recent viewed Claims in claim home page...
	 			public static boolean checkingRecentViewClaimsInClaimHomePage(Browser browser)
					{
						
						boolean checkingRecentViewClaimsInClaimHomePage = false;
						
						try
						{
							boolean fnStatus = isElementExist(browser, sectionRecentClaims);
							if(fnStatus=true)
								{
							
							String tableXpath = sectionRecentClaims.concat("//div[@class='pbBody']//table");
							fnStatus = isElementExist(browser, tableXpath);
							if(fnStatus == true)
							{
								int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
								if(rowCount>1)
								{
									ReportEvent.testStepReport("tTestCaseName", "Pass", "Recently Viewed claim records are available ");
									errorCount++;
									
								
								}
								else
								{
									ReportEvent.testStepReport("", "fail", "Recently Viewed claims section having No records are displayed.");
									errorCount++;
									
								
								}
							}
							else
							{
								
								ReportEvent.testStepReport("", "fail", "Recently Viewed Claims are not available");
								errorCount++;
								
							}
								}
							
						}
						catch(Throwable t)
						{
							System.out.println("The Exception for checkingRecentViewClaimsInClaimHomePage is : " + t.getMessage());
							ReportEvent.testStepReport("", "fail", "The Exception for checkingRecentViewClaimsInClaimHomePage is : " + t.getMessage());
							softAssert.fail("The Exception for checkingRecentViewClaimsInClaimHomePage is : " + t.getMessage());
							errorCount++;
							
						}
						return checkingRecentViewClaimsInClaimHomePage;
					}
	 			//Function for validating to field value as blank based on lable name in New claim information section..
	 			public static boolean validatingFieldValueAsBlankInClaimInfoSec(Browser browser,String benefitfieldName,String claimantInsured)
	 			{
	 				boolean validatingFieldValueAsBlankInClaimInfoSec=false;
	 				String fieldValue=null;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionClaimInfo);
	 					if(fnStatus==true)
	 					{
	 					/*fieldValue=GenericClass.getFieldValueOfSection(browser, benefitfieldName, sectionClaimInfo);*/
	 					fieldValue=GenericClass.getFieldValueOfSection(browser, benefitfieldName, sectionClaimInfo);
	 					if(fieldValue.length()!=0)
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "Pass", ""+benefitfieldName+" , field is blank as expected.");
	 						
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", ""+benefitfieldName+" , field is NOT blank.");
							errorCount++;
							
						}
	 					fieldValue=GenericClass.getFieldValueOfSection(browser, claimantInsured, sectionClaimInfo);
	 					if(fieldValue.length()!=0)
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "Pass", ""+claimantInsured+" , field is blank as expected.");
	 						
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", ""+claimantInsured+" , field is NOT blank.");
							errorCount++;
							
						}
	 					}
	 					else
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "FAIL", sectionClaimInfo+" Section is not available.");
							errorCount++;
							
							
	 					}
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for validatingFieldValueAsBlank is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for validatingFieldValueAsBlank is : "+t.getMessage());
						softAssert.fail("The Exception for validatingFieldValueAsBlank is : "+t.getMessage());
						errorCount++;
						
	 				}
	 				return validatingFieldValueAsBlankInClaimInfoSec;
	 			}
	 			
	 			//Function for clicking New Claim Relationship Button..
	 			public static boolean clickingNewClaimRelationshipButton(Browser browser)
	 			{
	 				boolean clickingNewClaimRelationshipButton = false;
	 				try
	 				{
	 					boolean fnStatus = isElementExist(browser, sectionClaimRelationship);
	 					if(fnStatus==true)
	 					{
	 							fnStatus=fnButtonClick(browser, btnNewClaimRelationShip);
	 							if(fnStatus ==true)
	 							{
	 								ReportEvent.testStepReport(tTestCaseName, "pass", "New Claim Relationship button Should be clicked successfully");
	 								clickingNewClaimRelationshipButton = true;
	 							}
	 							else 
	 							{
	 								ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'New Claim Relationship' button is not clicked ");
	 								errorCount++;
	 								clickingNewClaimRelationshipButton = false;
	 							}
	 				}
	 					else
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Claim Relationship Section is not available.");
							errorCount++;
							clickingNewClaimRelationshipButton = false;
							
	 					}
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for clickingNewClaimRelationshipButton is : "+t.getMessage());
	 					ReportEvent.testStepReport("", "fail", "The Exception for clickingNewClaimRelationshipButton is : "+t.getMessage());
	 					softAssert.fail("The Exception for clickingNewClaimRelationshipButton is : "+t.getMessage());
	 					errorCount++;
	 					clickingNewClaimRelationshipButton = false;
	 				}
	 				return clickingNewClaimRelationshipButton;
	 			}

	 			//Function for confirming Claim page navigation..
				public static boolean confirmingClaimIdPageNavigation(Browser browser,String h1HeaderText,String configName)
				{
					boolean confirmingClaimIdPageNavigation = false;
					try
					{
						boolean fnStatus =false;
						GenericClass.saveGeneratedDataInConfigFile(browser, h1HeaderText, configName);
						GenericClass.reportlogger(fnStatus,tTestCaseName, "Navigated to Claim id: "+configName+" ,Page ");
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingClaimIdPageNavigation is : ",t);
					}
					return confirmingClaimIdPageNavigation;
				}
	 			
				//Function to validate auto populated Claim ID with input data..
				public static boolean validatePopulatedClaimId(Browser browser, String labelName, String inputClaimID)
				{
					boolean validatePopulatedClaimId = false;
					String appText = null;
					try
					{
						appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, labelName);
						if(appText.equalsIgnoreCase(inputClaimID))
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", inputClaimID + " : is auto populating as expected.");
							validatePopulatedClaimId = true;
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", inputClaimID + " : is NOT auto populated.");
							validatePopulatedClaimId = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for validatePopulatedClaimId is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for validatePopulatedClaimId is : "+t.getMessage());
						softAssert.fail("The Exception for validatePopulatedClaimId is : "+t.getMessage());
						errorCount++;
					}
				return validatePopulatedClaimId;	
				}
				
				//Function for confirming Claim page navigation..
				public static boolean confirmingClaimRelationshipIdPageNavigation(Browser browser,String h1HeaderText,String configName)
				{
					boolean confirmingClaimRelationshipIdPageNavigation = false;
					try
					{
						boolean fnStatus =false;
						GenericClass.saveGeneratedDataInConfigFile(browser, h1HeaderText, configName);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "System should be displayed Claim Relationship id: "+configName+" ,Page successfully!!");
									confirmingClaimRelationshipIdPageNavigation = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "System is not displaying Claim Relationship id Page");
									errorCount++;
									confirmingClaimRelationshipIdPageNavigation = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for confirmingClaimIdPageNavigation is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for confirmingClaimIdPageNavigation is : "+t.getMessage());
						softAssert.fail("The Exception for confirmingClaimIdPageNavigation is : "+t.getMessage());
						errorCount++;
						confirmingClaimRelationshipIdPageNavigation = false;
						
					}
					return confirmingClaimRelationshipIdPageNavigation;
				}

				
				//Function for checking Fields are available in Claim Relationship Detail section fields based on user inputs..
				public static boolean checkingClaimRelaShipDetailSecFieldValues(Browser browser,String contactLabel,String relationshipTypeLabel,String createdBy,String lostModifiedBy)
				{
					boolean checkingClaimRelaShipDetailSecFieldValues=false;
					try
					{
						
						boolean fnStatus=isElementExist(browser, tblClaimRelationShipDetail);
								
						if(fnStatus==true)
						{
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,contactLabel , tblClaimRelationShipDetail);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Claim Relationship Detail section :"+contactLabel+" label related value should be Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail section :"+contactLabel+" label related value is not Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,relationshipTypeLabel , tblClaimRelationShipDetail);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Claim Relationship Detail section :"+relationshipTypeLabel+" label related value should be Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail section :"+relationshipTypeLabel+" label related value is not Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,createdBy , tblClaimRelationShipDetail);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Claim Relationship Detail section :"+createdBy+" label related value should be Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail section :"+createdBy+" label related value is not Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,lostModifiedBy , tblClaimRelationShipDetail);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Claim Relationship Detail section :"+lostModifiedBy+" label related value should be Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail section :"+lostModifiedBy+" label related value is not Updated !!");
								checkingClaimRelaShipDetailSecFieldValues=true;
							}
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail Section is not available!!");
							errorCount++;
							checkingClaimRelaShipDetailSecFieldValues=true;
						}
						
							}
					catch(Throwable t)
					{
						System.out.println("The Exception for checkingClaimRelaShipDetailSecFieldValues is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for checkingClaimRelaShipDetailSecFieldValues is : "+t.getMessage());
						softAssert.fail("The Exception for checkingClaimRelaShipDetailSecFieldValues is : "+t.getMessage());
						errorCount++;
						checkingClaimRelaShipDetailSecFieldValues=false;
					}
				return checkingClaimRelaShipDetailSecFieldValues;
				}
				public static void clickClaimIDLink(Browser browser, String fieldName)
				{
					   boolean clickClaimIDLink=false;
					try
					{
						boolean fnStatus = false;
						fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, fieldName, tblClaimRelationShipDetail);
						if(fnStatus==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked on :"+ fieldName + " label related link successfully.");
							clickClaimIDLink=true;
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Failed to click on :"+ fieldName + " label related link.");
							clickClaimIDLink=false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickClaimIDLink is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickClaimIDLink is : " + t.getMessage());
						softAssert.fail("The Exception for clickClaimIDLink is : " + t.getMessage());
						errorCount++;
						clickClaimIDLink=false;
						
					}
				}
				
				//Function for verifying new policies is updated in policy relationship section..
				public static boolean verifyingClaimRelRelatedListInContactRel(Browser browser, String contactList)
				{
					boolean verifyingClaimRelRelatedListInContactRel = false;
					try
					{
						boolean fnStatus = isElementExist(browser, sectionClaimRelationship);
						if(fnStatus=true)
						{
						String tableXpath = sectionClaimRelationship.concat("//div[@class='pbBody']//table");
						fnStatus = isElementExist(browser, tableXpath);
						if(fnStatus == true)
						{
							int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
							if(rowCount>1)
							{
							outerloop:
							for(int i=1; i<=rowCount; i++)
							{
								String aTagXpath = tableXpath.concat("//th/a");
								Link[] aTags=browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXpath).build());
								for (Link cellText : aTags)
								{
										if(cellText.getInnerText().equals(contactList))
										{
											cellText.highlight();
											ReportEvent.testStepReport("", "PASS", "Contact Name :"+cellText+" Updated in Claim Relationship Section successfully." );
											verifyingClaimRelRelatedListInContactRel = true;
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
							ReportEvent.testStepReport("", "PASS", "Claim Relationship dynamic table record are not available");
							errorCount++;
							verifyingClaimRelRelatedListInContactRel = false;
						
						}
						}
						else
						{
							
							ReportEvent.testStepReport("", "PASS", "Claim Relationship dynamic table is not available");
							errorCount++;
							verifyingClaimRelRelatedListInContactRel = false;
						}
						}
						else
						{
							ReportEvent.testStepReport("", "PASS", "Claim Relationship Section is not available");
							verifyingClaimRelRelatedListInContactRel = false;
						}	
					
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for verifyingClaimRelRelatedListInContactRel is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for verifyingClaimRelRelatedListInContactRel is : " + t.getMessage());
						softAssert.fail("The Exception for verifyingClaimRelRelatedListInContactRel is : " + t.getMessage());
						errorCount++;
						verifyingClaimRelRelatedListInContactRel = false;
					}
					return verifyingClaimRelRelatedListInContactRel;
					
				}
				
				
				//Function for Clicking Claim id in Claim Relationship Detail section field  based on label..
				public static boolean clickingClaimRelationshipID(Browser browser,String claimLabel)
				{
					boolean clickingClaimRelationshipID=false;
					try
					{
						
						boolean fnStatus=isElementExist(browser, tblClaimRelationShipDetail);
								
						if(fnStatus==true)
						{
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,claimLabel , tblClaimRelationShipDetail);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Claim Relationship Detail section :"+claimLabel+" label related value should be Clicked !!");
								clickingClaimRelationshipID=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail section :"+claimLabel+" label related value is not clicked !!");
								clickingClaimRelationshipID=true;
							}
							
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail Section is not available!!");
							errorCount++;
							clickingClaimRelationshipID=true;
						}
						
							}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingClaimRelationshipID is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingClaimRelationshipID is : "+t.getMessage());
						softAssert.fail("The Exception for clickingClaimRelationshipID is : "+t.getMessage());
						errorCount++;
						clickingClaimRelationshipID=false;
					}
				return clickingClaimRelationshipID;
				}
				//general function for selecting  name from  window frame related to Search criteria..
				public static boolean selectingNameFromWindowFrame(Browser browser,String inputTextBoxXpath, String btnSearchXpath, String inputName)
				{
					
					boolean selectingValueFromWindowFrame= false;
					try
					{
						boolean fnStatus= false;
						
						WebElement ele= browser.describe(WebElement.class, new XPathDescription(inputTextBoxXpath));
						fnStatus =ele.exists();
						if(fnStatus == true)
							{
							fnStatus = fnEditFieldTextEntry(browser, inputTextBoxXpath, inputName);	
							
							fnStatus = GenericClass.fnImageLinkOrButtonClick(browser, btnSearchXpath);
								if(fnStatus == true)
								{
									ReportEvent.testStepReport(tTestCaseName, "PASS", "Navigated to child window By title");
										String searchBoxXPath = "//label[text()='Search']/..//input[@name='lksrch']";
										GenericClass.fnEnterInputTextInFrameTextbox(browser,"Search ~ Salesforce - Unlimited Edition", "searchFrame",searchBoxXPath/*, inputName*/);
										
										if(fnStatus == true)
										{
											ReportEvent.testStepReport(tTestCaseName, "PASS", "Switched to Search frame");
											String btnGoXpath ="//input[@title='Go!']";
											GenericClass.fnClickFrameButtonByPageTitle(browser,"Search ~ Salesforce - Unlimited Edition", "searchFrame", btnGoXpath);
											if(fnStatus == true)
											{
												ReportEvent.testStepReport(tTestCaseName, "PASS", "Clicked on Go! button");
												browser=BrowserFactory.attach(new BrowserDescription.Builder().title("Search ~ Salesforce - Unlimited Edition").build()); 
												browser.highlight();
												fnStatus = GenericClass.fnSwitchToFrameNameByPageTitle(browser, "Search ~ Salesforce - Unlimited Edition","resultsFrame");
												if(fnStatus == true)
												{
													ReportEvent.testStepReport(tTestCaseName, "PASS", "Switched to Results frame");
													String tblXpath ="//div[@id='Contact_body']/..//following-sibling::div[@class='pbBody']//table//tr[2]//th[1]/a";
													
													Link aTagObject=browser.describe(Frame.class, new FrameDescription.Builder()
															.name("resultsFrame").build()).describe(Table.class, new TableDescription.Builder()
															.className("list").tagName("TABLE").build()).describe(Link.class, new LinkDescription.Builder()
															.tagName("A").innerText(inputName/*"Test STD_27-Sep-2017_17:06:53"*/).build());
																																					
														if(aTagObject.getInnerText().equalsIgnoreCase(inputName))
																	{
																		aTagObject.highlight();
																		aTagObject.click();
																		ReportEvent.testStepReport(tTestCaseName, "PASS", "Clicked on contactname : "+ inputName);
																		selectingValueFromWindowFrame = true;
																		
																		
																	}
																	else
																	{
																		ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on contactname : "+ inputName);
																		errorCount++;
																		selectingValueFromWindowFrame = false;
																		
																	}
											}
											else
												{
													ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to switch to Results Frame");
													errorCount++;
													selectingValueFromWindowFrame =false;
												}
														
												}
											else
											{
												ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on Go button");
												errorCount++;
												selectingValueFromWindowFrame = false;
											}
											}
										else
										{
											ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to pass Name as : " + inputName);
											errorCount++;
											selectingValueFromWindowFrame = false;
										}
										}
									
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Search Criteria section is not available.");
							errorCount++;	
							selectingValueFromWindowFrame = false;
						}
							}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for selectingValueFromWindowFrame is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for selectingValueFromWindowFrame is : "+t.getMessage());
						softAssert.fail("The Exception for selectingValueFromWindowFrame is : "+t.getMessage());
						errorCount++;
						selectingValueFromWindowFrame = false;
					}
					return selectingValueFromWindowFrame;
					
				}
				
				
				
				//Function to validate auto populated Contact with input data..
				public static boolean validatePopulatedContactName(Browser browser, String labelName, String inputName)
				{
					boolean validatePopulatedContactName = false;
					String appText = null;
					try
					{
						appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, labelName);
						if(appText.equalsIgnoreCase(inputName))
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", inputName + " : is auto populating as expected.");
							validatePopulatedContactName = true;
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", inputName + " : is NOT auto populated.");
							validatePopulatedContactName = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for validatePopulatedClaimId is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for validatePopulatedClaimId is : "+t.getMessage());
						softAssert.fail("The Exception for validatePopulatedClaimId is : "+t.getMessage());
						errorCount++;
					}
				return validatePopulatedContactName;	
				}
				
				public static void validatingClaimRelaShipDetailSecFieldValues(Browser browser,String contactLabel,String relationshipTypeLabel,String createdBy,String lostModifiedBy,String inputValues)
				{
					boolean validatingClaimRelaShipDetailSecFieldValues=false;
						boolean fnStatus=isElementExist(browser, tblClaimRelationShipDetail);
						int counter = 0;
						String contact = null, relationship= null,createdby= null, lastModified = null;
						try
						{
							String[] splitArray =inputValues.split(",");
					
						fnStatus=isElementExist(browser, tblClaimRelationShipDetail);
								
						if(fnStatus==true)
						{
							contact = GenericClass.getFieldValueOfSection(browser, contactLabel , tblClaimRelationShipDetail);
							relationship = GenericClass.getFieldValueOfSection(browser, relationshipTypeLabel , tblClaimRelationShipDetail);
							createdby = GenericClass.getFieldValueOfSection(browser, createdBy , tblClaimRelationShipDetail);
							lastModified = GenericClass.getFieldValueOfSection(browser, lostModifiedBy , tblClaimRelationShipDetail);
							String[] appData = {contact,relationship,createdby,lastModified};
							for(int i=0;i<splitArray.length;i++)
							{
								for(int j=0;j<appData.length;j++)
								{
									if(splitArray[i].equalsIgnoreCase(appData[j]))
									{
										counter++;
									}
									else
									{
										continue;
									}
								}
							}
							if(counter==splitArray.length)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "All labels are displaying correctly with the user passed input values successfully.");
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "All labels are NOT displaying with the user passed input values successfully.");
							}
							
							
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim Relationship Detail Section is not available!!");
							errorCount++;
							
						}
						
							}
					catch(Throwable t)
					{
						System.out.println("The Exception for validatingClaimRelaShipDetailSecFieldValues is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for validatingClaimRelaShipDetailSecFieldValues is : "+t.getMessage());
						softAssert.fail("The Exception for validatingClaimRelaShipDetailSecFieldValues is : "+t.getMessage());
						errorCount++;
						
					}
				
					}
				
				
				//Function for verifying the autopapulated claim id in Document details section based on labels...
				public static String getAutoPopulatedClaimIdOfTextBoxByLabel(Browser browser,  String labelName)
				{
					
					String getAutoText = null;
					WebElement textBox = null;
					try
					{
						boolean fnStatus = false;
						String immediateParentXpath = "//label[text()='"+labelName+"']/..";
						outerloop:
						for(int level =1;level<=6;level++)
						{
							String parentXpath = immediateParentXpath;
							String parentLevel ="/..";
							WebElement immediateParent=browser.describe(WebElement.class, new XPathDescription(parentXpath));
							String parentTagName = immediateParent.getTagName();
							if(parentTagName.equalsIgnoreCase("td"))
							{
								
								String textBoxXpath = parentXpath+"/following-sibling::td[1]//input[@type='text']";
								fnStatus = isElementExist(browser, textBoxXpath);
								if(fnStatus ==true)
								{
									textBox = browser.describe(WebElement.class, new XPathDescription(textBoxXpath));
									getAutoText = textBox.getAttribute("value");
									break outerloop;
									
								}
								else
								{
										System.out.println("Text box with Xpath : " +textBoxXpath+" is not available.");
									
								}
								
							}
							else if(parentTagName.equalsIgnoreCase("th"))
							{
								
								String textBoxXpath = parentXpath+"/following-sibling::td[1]//input[@type='text']";
								fnStatus = isElementExist(browser, textBoxXpath);
								if(fnStatus ==true)
								{
									textBox = browser.describe(WebElement.class, new XPathDescription(textBoxXpath));
									getAutoText = textBox.getAttribute("value");
									break outerloop;
									
								}
								else
								{
									System.out.println("Text box with Xpath : " +textBoxXpath+" is not available.");
								}
								
							}
							else if(parentTagName.equalsIgnoreCase("div"))
							{
								String updatedParentXpath = "//label[text()='"+labelName+"']";
								String textBoxXpath = updatedParentXpath+"/following-sibling::div[1]//input";     ///following-sibling::div[1]//input[@type='text']";
								fnStatus = isElementExist(browser, textBoxXpath);
								if(fnStatus ==true)
								{
									
									textBox = browser.describe(WebElement.class, new XPathDescription(textBoxXpath));
									getAutoText = textBox.getAttribute("value");
									break outerloop;
								
								}
								else
								{
									System.out.println("Text box with Xpath : " +textBoxXpath+" is not available.");
								}
							}
							
							else
							{
								parentXpath = parentXpath+parentLevel;
							}
						}
						
					}
					catch(Throwable t)
					{
						System.out.println("Exception message is : "+t.getMessage());
					}
					return getAutoText;
				}
				
				//Function to validate auto populated Claim ID in Document details section..
				public static void validateAutoPopulatedClaimId(String testCaseName, Browser browser, String labelName, String inputClaimID)
				{
					
					String appText = null;
					try
					{
						appText = ClaimsPage_CV.getAutoPopulatedClaimIdOfTextBoxByLabel(browser, labelName);
						if(appText.equalsIgnoreCase(inputClaimID))
						{
							ReportEvent.testStepReport(testCaseName, "pass", inputClaimID + " : is auto populating as expected.");
						}
						else
						{
							ReportEvent.testStepReport(testCaseName, "Fail", inputClaimID + " : is NOT auto populated.");
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for validatePopulatedClaimId is : ", t);
						
					}
					
				}
				
				
				//Function to validate auto populated Benefit Claimed ID with input data..
				public static void validatePopulatedBenefitId(String testCaseName,Browser browser, String labelName, String inputBcID)
				{
					
					String appText = null;
					try
					{
						appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, labelName);
						if(appText.equalsIgnoreCase(inputBcID))
						{
							ReportEvent.testStepReport(testCaseName, "pass", inputBcID + " : is auto populating as expected.");
						}
						else
						{
							ReportEvent.testStepReport(testCaseName, "Fail", inputBcID + " : is NOT auto populated.");
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for validatePopulatedBenefitId is : ", t);
					}
				}
				
				
//Function for checking required field in document details section based on labels..
public static void checkRequiredFieldAvailabilityDocumentDetailsSec(String testCaseName, Browser browser, String labelName)
{
	try
	{
		String immediateParentXpath = "//label[text()='"+labelName+"']/..";
		WebElement fieldObject = browser.describe(WebElement.class, new XPathDescription(immediateParentXpath));
		fieldObject.highlight();
		if(fieldObject.exists())
		{
			String objClass = fieldObject.getClassName();
			if(objClass.equals("labelCol requiredInput"))
			{
				ReportEvent.testStepReport(testCaseName, "pass", labelName + ":  field is marked as required.");
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "fail", labelName + ":  field is NOT marked as required.");
			}
		}
		else
		{
			ReportEvent.testStepReport(testCaseName, "fail", "Field :"+labelName+" is not available.");
		}
	}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("Exception arised in checkRequiredFieldAvailabilityDocumentDetailsSec is :", t);
	}
	
}






	//Function for checking recent viewed Claims in claim home page...
	public static void checkingRecentViewClaimsInClaimHomePage(String testCaseName ,Browser browser)
	{
		try
		{
			boolean fnStatus = isElementExist(browser, sectionRecentClaims);
			if(fnStatus=true)
				{
			
			String tableXpath = sectionRecentClaims.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if(fnStatus == true)
			{
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				if(rowCount>1)
				GenericClass.reportlogger(fnStatus,testCaseName,"Recently Viewed claim records are available ");
			}
			else
			{
				
				ReportEvent.testStepReport("", "fail", "Recently Viewed Claims are not available");
			}
			}
			}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("The Exception for checkingRecentViewClaimsInClaimHomePage is : ", t);

		}
	}


//Function for verifying Status field contains default as Pending..

public static void verifyingStatusDropdownFieldAsPending(String testCaseName,Browser browser,String dopdownValue )
{
	try
	{
		boolean fnStatus=false;
		String statusXpath=sectionClaimInfo.concat("//select[contains(@name,'A2IpU')]");
		fnStatus = GenericClass.fnClickListBox(browser, statusXpath);
		if (fnStatus == true) 
		{
			fnStatus =fnListBox(browser, statusXpath, dopdownValue);
			GenericClass.reportlogger(fnStatus,testCaseName,dopdownValue+ ": As default value in Status Dropdown !! ");
		}
		else 
		{
			ReportEvent.testStepReport(tTestCaseName, "FAIL", "Didn't clicked on 'Status' related drop down");
		}
		}
	catch(Throwable t)
	{

		GenericClass.Catchhandler("The Exception for verifyingStatusFieldsAsRequired is : ", t);
		}
}
//Function for verifying Status field marked as Required..
public static void verifyingStatusFieldsAsRequired(String testCaseName,Browser browser, String labelName)
{
	try
	{
		boolean fnStatus=false;
		fnStatus = GenericClass.checkRequiredFieldAvailabilityBasedOnLabel(browser, labelName);
		GenericClass.reportlogger(fnStatus, testCaseName, labelName+ " is marked as Required as");
		
		}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception is verifyingStatusFieldsAsRequired", t);

	}
	
}


public static final String btnClaimEditPage="//h2[text()='Claim Edit']/../../../..//input[@class='btn' and @title ='";
//Function to click on either Save Or Save & New Or Cancel button of "Claim Edit", Page based on the user inputs..
public static void  clickButtonOfClaimEditPage(String testCaseName,Browser browser, String buttonName)
{
try
{
boolean fnStatus = false;
fnStatus = isElementExist(browser, btnClaimEditPage+buttonName+buttonxpath2);
GenericClass.reportlogger(fnStatus,testCaseName, btnClaimEditPage+buttonName+buttonxpath2+" : Xpath is ");
fnStatus = fnButtonClick(browser, btnClaimEditPage+buttonName+buttonxpath2);
GenericClass.reportlogger(fnStatus,testCaseName,"Clicked on :" + buttonName + ", button.");
}
catch(Throwable t)
{
GenericClass.Catchhandler("The Exception for clickButtonOfClaimEditPage  is : ",t);

}
} 

//Function for confirming Claim page navigation..
public static void confirmingClaimIdPageNavigation(String testCaseName,Browser browser,String h1HeaderText,String configName)
{
	try
	{
		boolean fnStatus =false;
		GenericClass.saveGeneratedDataInConfigFile(browser, h1HeaderText, configName);
		GenericClass.reportlogger(fnStatus, testCaseName, "Navigated to Claim id: "+configName+" ,Page");
				
	}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception for confirmingClaimIdPageNavigation is : ", t);
		}
	}
	
//Function for checking Fields are available in Claim Relation ship section based on user inputs..
public static void checkingClaimRelationshipSecFields(String testCaseName, Browser browser,String inputFieldValues)
{
	try
	{
		boolean fnStatus=isElementExist(browser, sectionClaimRelationShipInfo);
		if(fnStatus==true)
		{
			fnStatus=GenericClass.fieldAvailabilityValidation(browser, inputFieldValues, sectionClaimRelationShipInfo);
			GenericClass.reportlogger(fnStatus, testCaseName, "Calim Relationship Information Section fields are verified ");
		}
		else
		{
			ReportEvent.testStepReport(tTestCaseName, "Fail", "Calim Relationship Section is not available!!");
		}
		}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception for checkingClaimRelationshipSecFields is : ", t);
		}}


//Function to validate auto populated Claim ID with input data..
public static void validatePopulatedClaimId(String testCaseName,Browser browser, String labelName, String inputClaimID)
{
	String appText = null;
	try
	{
		appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, labelName);
		boolean fnStatus=appText.equalsIgnoreCase(inputClaimID);
		GenericClass.reportlogger(fnStatus, testCaseName, inputClaimID + " : is auto populating as expected");
	}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception for validatePopulatedClaimId is : ", t);
	}
}

//Selecting Claim Relationship Contact Name  in a frame..
public static void selectingContactNameFromClaimRelationshipWindowFrame(String testCaseName,Browser browser, String nameValue)
{
	try
	{
		boolean fnStatus=false;
		
		
			String contactTextBoxXpath=sectionClaimRelationShipInfo.concat("//input[@name='CF00NA000000A2IoW']");
			String contactImgXpath="//input[@name='CF00NA000000A2IoW']/..//img";
			
			fnStatus =ClaimsPage_CV.selectingNameFromWindowFrame(browser, contactTextBoxXpath, contactImgXpath,nameValue );
			GenericClass.reportlogger(fnStatus, testCaseName, "Selected Contact Name as :"+ nameValue);
			}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception for selectingContactNameFromClaimRelationshipWindowFrame is : ", t);
		}
}	

//Function to validate auto populated Contact with input data..
public static void validatePopulatedContactName(String testCaseName,Browser browser, String labelName, String inputName)
{
	String appText = null;
	try
	{
		appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, labelName);
		boolean fnStatus=appText.equalsIgnoreCase(inputName);
		GenericClass.reportlogger(fnStatus, testCaseName, inputName + " : is auto populating as expected");
		
	}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception for validatePopulatedContactName is : ", t);
		}
}




//Selecting Claim Relationship Account Name  in a frame..
public static void selectingAccountNameFromClaimRelationshipWindowFrame(String testCaseName, Browser browser, String nameValue)
{
	try
	{
			String accountTextBoxXpath=sectionClaimRelationShipInfo.concat("//input[@name='CF00NA000000A2IoS']");
			String accountImgXpath="//input[@name='CF00NA000000A2IoS']/..//img";
			boolean	fnStatus =ClaimsPage_CV.selectingNameFromWindowFrame(browser, accountTextBoxXpath, accountImgXpath,nameValue );
			GenericClass.reportlogger(fnStatus, testCaseName, "Selected Account Name as :"+ nameValue);
			}
	catch(Throwable t)
	{
		GenericClass.Catchhandler("The Exception for selectingAccountNameFromClaimRelationshipWindowFrame is : ", t);
		}
	}

//Function to click on either Save Or Save & New Or Cancel button of "Claim Relationship Edit", Page based on the user inputs..
public static void  clickButtonOfClaimRelationshipEditPage(String testCaseName,Browser browser, String buttonName)
{
try
{
	boolean fnStatus = false;
	fnStatus = isElementExist(browser, btnClaimRelationshipEditPage+buttonName+buttonxpath2);
	GenericClass.reportlogger(fnStatus,testCaseName, btnClaimEditPage+buttonName+buttonxpath2+" : Xpath is ");
	fnStatus = fnButtonClick(browser, btnClaimEditPage+buttonName+buttonxpath2);
	GenericClass.reportlogger(fnStatus,testCaseName,"Clicked on :" + buttonName + ", button.");
}
catch(Throwable t)
{
	GenericClass.Catchhandler("The Exception for clickButtonOfClaimRelationshipEditPage  is : ",t);
	
}
}
				
//Today's task --11102017

//Function to check availability of fields of Info section of new doc page.. 
	public static void checkFieldAvailabilityOfInformationSection(String testCaseName,Browser browser, String labelNames)
	{
		boolean fnStatus = false; int counterLabel= 0;
		try
		{
			String[] labelsArray = labelNames.split(",");
			for(int i=0;i<labelsArray.length;i++)
			{
				fnStatus= GenericClass.checkFieldAvailabilityBasedOnLabel(browser, labelsArray[i]);
				if(fnStatus==true)
				{
					counterLabel++;
				}
				else
				{
					continue;
				}
			}
			if((labelsArray.length)==counterLabel)
			{
				ReportEvent.testStepReport(testCaseName, "Pass", "Labels : " + labelsArray + " are available as expected." );
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Pass", "Labels : " + labelsArray + " are NOT available." );
			}
			
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("Exception arised in clickAddDocumentLink() is : " , t);
		}
	}
	

	
	public static final String drpdwnDocDescValue ="//label[text()='Document Description']/parent::td/following-sibling::td[1]//select[@disabled]";
	
	
//Function to check if Document Description value is greyed out or not..
	public static void checkDocumentDescriptionGreyedOut (String testCaseName,Browser browser)
	{
		boolean fnStatus = false;
		try
		{
			fnStatus =isElementExist(browser, drpdwnDocDescValue);
			GenericClass.reportlogger(fnStatus, testCaseName, "'Document Description' Label value is greyed out ");
			
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("Exception arised in checkDocumentDescriptionGreyedOut() is : " , t);
		}
	}
	
	
	
	public static final String sectionDocumentsInfo="//h3[text()='Information']/../..";
	public static final String datePicker = "//table[@class ='outer']//following-sibling::div[@class='datePicker']";

	//Function to fill required fields while creation of new document for mgmt lead..
	public static void fillingRequiredFieldsOfNewDocument(String testCaseName, Browser browser,String documentLabel,String documentName,String typeLabel,String typeValue,
																 String documentTypeLabel,String documentTypeValue,String documentDescLabel, String documentDescValue, String docReceivedDate)
	{
		boolean fnStatus=false;
		try
		{
			
			fnStatus=isElementExist(browser, sectionDocumentsInfo);
			if(fnStatus=true)
			{
				//Enter document name..
				 fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser, documentLabel, documentName);
				 GenericClass.reportlogger(fnStatus, testCaseName, "Entered Document name as: "+documentName);
				
				 //Select type..
				 fnStatus=GenericClass.selectValueByVisibleTextByLabelWithoutContains(browser, typeLabel, typeValue);
				 GenericClass.reportlogger(fnStatus, testCaseName,"Selected Type List box Value as: "+typeValue);
				 
				//Select Document type..
				 fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, documentTypeLabel, documentTypeValue);
				 GenericClass.reportlogger(fnStatus, testCaseName,"Selected Document Type List Box Value as: "+documentTypeValue);
				 
				//Select Document desc..
				 fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, documentDescLabel, documentDescValue);
				 GenericClass.reportlogger(fnStatus, testCaseName,"Selected Document description List Box Value as: "+documentDescValue);
				 
				 
				//Selecting Document Received date..
				 String receivedDateXpath=sectionDocumentsInfo.concat("//input[contains(@name,'A2JFe')]"); 
				 GenericClass.fnClikEditOrDateField(browser, receivedDateXpath);
				 fnStatus = GenericClass.datePicker(browser, datePicker,  GenericClass.dateConversion(docReceivedDate, "FullMonth/dd/yyyy"));
				 GenericClass.reportlogger(fnStatus, testCaseName,  "Selected Document Received date  as:" + docReceivedDate);
					
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "FAIL", sectionDocumentsInfo + ", Section xpath is not available.");
			}
			
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("The Exception for fillingRequiredFieldsOfNewDocument() is : ", t);
			
		}
		
	}
	

				
	public static final String tblDocumentDetail="//td[text()='Document Name']/../../../..";
	
	//Function for checking Saved changes in Document details section..
		
		public static void checkingUpdatedValuesInDocumentDetailsSec_MgmtLead(String testCaseName, Browser browser,String documentNameLabel,String typeLabel,
			 String documentTypeLabel,String documentreceivedDateLabel,String inputValues)
		
		{
			boolean fnStatus = false;
			int counter = 0;
		String docName = null, type= null,docType= null, docDesc = null;
		try
		{
			String[] splitArray =inputValues.split(",");
	
		fnStatus=isElementExist(browser, tblDocumentDetail);
				
		if(fnStatus==true)
		{
			docName = GenericClass.getFieldValueOfSection(browser, documentNameLabel , tblDocumentDetail);
			type = GenericClass.getFieldValueOfSection(browser, typeLabel , tblDocumentDetail);
			docType = GenericClass.getFieldValueOfSection(browser, documentTypeLabel , tblDocumentDetail);
			docDesc = GenericClass.getFieldValueOfSection(browser, documentreceivedDateLabel , tblDocumentDetail);
			String[] appData = {docName,type,docType,docDesc};
			for(int i=0;i<splitArray.length-1;i++)
			{
				for(int j=0;j<appData.length;j++)
				{
					if(splitArray[i].equalsIgnoreCase(appData[j]))
					{
						counter++;
					}
					else
					{
						continue;
					}
				}
			}
			if(counter==splitArray.length)
			{
				ReportEvent.testStepReport(testCaseName, "pass", "All labels are displaying correctly with the user passed input values successfully.");
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "All labels are NOT displaying with the user passed input values successfully.");
			}	
		}
		else
		{
			ReportEvent.testStepReport(testCaseName, "Fail", "Document Detail Section is not available!!");
		}
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for checkingUpdatedValuesInDocumentDetailsSec is : ", t);
				
			}
		
		}
			
	
			
				
				
}
				
				

