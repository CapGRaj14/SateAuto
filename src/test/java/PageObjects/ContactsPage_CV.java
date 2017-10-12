package PageObjects;

import java.awt.Dimension;
import java.util.List;


import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableRow;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

public class ContactsPage_CV extends DriverScript {

	public static final String txtContactsHeader = "//div[@class ='bPageTitle']/..//h1[text()='Contacts']";
	public static final String btnNew = "//h3[text()='Recent Contacts']/../..//input";
	public static final String sectionSelectContactRecord ="//h2[text()='Select Contact Record Type']/../../../../../..";
	public static final String dropDownRecordType = "//label[text()='Record Type of new record']/../..//select";
	public static final String btnContinue  ="//input[@title='Continue']";
	public static final String datePicker = "//table[@class ='outer']//following-sibling::div[@class='datePicker']";
	public static final String txtNewContactHeader = "//div[@class ='bPageTitle']//h1[text()='New Contact']";
	public static final String txtContactEditHeader = "//div[@class ='bPageTitle']//h1[text()='Contact Edit']";
	public static final String sectionContactInformation="//h3[text() ='Contact Information']/../following-sibling::div[1]";
	public static final String btnNewAbsenceClaim = "//h2[text()='Contact Detail']/../..//input[@title= 'New Absence Claim']";
	public static final String tablePrimary = "//div[@class='listBody']//child::div[@class ='x-grid3-body']";
	public static final String btnGo = "//label[text()='View:']/..//input";
	public static final String dropDownView = "//label[text()='View:']/..//select";
	public static final String sectionContactDetails ="//td[text()='Contact Owner']/../../..//parent::div[@class='pbSubsection']";
	public static final String sectionParentOFSections="//div[contains(@class,'brandSecondaryBrd')]/child::div[@class='pbBody']";
	public static final String txtContactHeader ="//div[@class='ptBody']/..//h1[text()='Contact']";
	public static final String sectionClaimRelationship="//h3[text()='Claim Relationships']/../../../../../..//parent::div[contains(@class,'listRelatedObject')]";
	public static final String txtClaimHeaderID="//h1[text()='Claim']/..";
	public static final String btnAddBenefitClaimed="//h2[text()='Claim Detail']/../../..//input";
	public static final String txtSearchPolicyHeader="//h2[text()='Search Account and Policy']";
	public static final String tblSearchContact="//div[@id='Contact_body']/../..//table[@class='list']";
	public static final String txtBenefitClaimCreationHeader="//div[@class='content']";
	public static final String txtSearchResultsHeader="//h3[text()='Search Results (1 Record)']";
	public static final String txtSelectRecordTypeHeader="//h2[text()=' Select Contact Record Type']";
	
	
	public static final String sectionAddressInformation="//h3[text()='Address Information']/../following-sibling::div[1]";
	
	
	//Function for confirming contacts page navigation..
		public static boolean confirmingContactsPageNavigation(Browser browser)
		{
			boolean confirmingContactsPageNavigation = false;
			try
			{
				boolean fnStatus = isElementExist(browser, txtContactsHeader);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Contacts Page successfully!!");
							confirmingContactsPageNavigation = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Contacts Page");
							errorCount++;
							confirmingContactsPageNavigation = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for confirmingContactsPageNavigation is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for confirmingContactsPageNavigation is : "+t.getMessage());
				softAssert.fail("The Exception for confirmingContactsPageNavigation is : "+t.getMessage());
				errorCount++;
				confirmingContactsPageNavigation = false;
				
			}
			return confirmingContactsPageNavigation;
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
		//Function for Confirming New Contact page navigation.
		public static boolean confirmingNewContactPageNavigation(Browser browser)
		{
			boolean confirmingNewContactPageNavigation = false;
			try
			{
				boolean fnStatus = isElementExist(browser, txtNewContactHeader);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to New Contact Page successfully!!");
							confirmingNewContactPageNavigation = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to New Contact Page");
							errorCount++;
							confirmingNewContactPageNavigation = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for confirmingNewContactPageNavigation is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for confirmingNewContactPageNavigation is : "+t.getMessage());
				softAssert.fail("The Exception for confirmingNewContactPageNavigation is : "+t.getMessage());
				errorCount++;
				confirmingNewContactPageNavigation = false;
				
			}
			return confirmingNewContactPageNavigation;
		}
		/*//Function for selecting Record type dropdown value..
		public static boolean selectingRecordType(Browser browser, String recordType)
		{
			boolean selectingRecordType = false;
			try
			{
				boolean fnStatus = GenericClass.fnClickListBox(browser, dropDownRecordType);
				if(fnStatus == true)
				{
					fnStatus = fnListBox(browser, dropDownRecordType, recordType);
					if(fnStatus == true)
					{
						selectingRecordType = true;
					}
					else
					{
						ReportEvent.testStepReport("", "FAIL", "Failed to select record type as : " + recordType);
					}
				}
				else{
					ReportEvent.testStepReport("", "FAIL", "Failed to click on Record Type dropdown");
					errorCount++;
					selectingRecordType = false;
				}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for selectingRecordType is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for selectingRecordType is : "+t.getMessage());
				softAssert.fail("The Exception for selectingRecordType is : "+t.getMessage());
				errorCount++;
				selectingRecordType = false;
			}
			return selectingRecordType;
		}*/
		//Function for clicking Continue button..
		public static boolean clickingContinueButton(Browser browser)
		{
			boolean clickingContinueButton = false;
			try
			{
				boolean fnStatus =fnButtonClick(browser, btnContinue);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "'Continue' button Should be clicked successfully");
							clickingContinueButton = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'Continue' button is not clicked ");
							errorCount++;
							clickingContinueButton = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for clickingContinueButton is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingContinueButton is : "+t.getMessage());
				softAssert.fail("The Exception for clickingContinueButton is : "+t.getMessage());
				errorCount++;
				clickingContinueButton = false;
			}
			return clickingContinueButton;

		}
		//Function for confirming navigation to Contact Edit page
		public static boolean confirmingContactEditPageNavigation(Browser browser)
		{
			boolean confirmingContactEditPageNavigation = false;
			try
			{
				boolean fnStatus = isElementExist(browser, txtContactEditHeader);
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Contact Edit Page successfully!!");
							confirmingContactEditPageNavigation = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Contact Edit Page");
							errorCount++;
							confirmingContactEditPageNavigation = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for confirmingContactEditPageNavigation is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for confirmingContactEditPageNavigation is : "+t.getMessage());
				softAssert.fail("The Exception for confirmingContactEditPageNavigation is : "+t.getMessage());
				errorCount++;
				confirmingContactEditPageNavigation = false;
				
			}
			return confirmingContactEditPageNavigation;
		}
		
		//Function for clicking new absence claim button.,.
		public static boolean clickingNewAbsenceClaimButton(Browser browser)
		{
			boolean clickingNewAbsenceClaimButton = false;
			try
			{
				boolean fnStatus = fnButtonClick(browser, btnNewAbsenceClaim);
					
						if(fnStatus ==true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "New Absence Claim button is clicked successfully");
							clickingNewAbsenceClaimButton = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "New Absence Claim button is not clicked : ");
							errorCount++;
							clickingNewAbsenceClaimButton = false;
						}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for clickingNewAbsenceClaimButton is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingNewAbsenceClaimButton is : "+t.getMessage());
				softAssert.fail("The Exception for clickingNewAbsenceClaimButton is : "+t.getMessage());
				errorCount++;
				clickingNewAbsenceClaimButton = false;
			}
			return clickingNewAbsenceClaimButton;
		}
		//Function for clicking View drop down.
				public static boolean clickingViewDropDown(Browser browser) {
					boolean clickingViewDropDown = false;
					try {
						boolean fnStatus = GenericClass.fnClickListBox(browser, dropDownView);
						if (fnStatus == true) {
							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked View dropDown Successfully");
							clickingViewDropDown = true;
						} else {
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "View dropDown  is not clicked : ");
							softAssert.fail("Failed to click View dropDown  ");
							errorCount++;
							clickingViewDropDown = false;
						}
					} catch (Throwable t) {
						System.out.println("The Exception for clickingViewDropDown is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingViewDropDown is : " + t.getMessage());
						softAssert.fail("The Exception for clickingViewDropDown is : " + t.getMessage());
						errorCount++;
						clickingViewDropDown = false;
					}
					return clickingViewDropDown;
				}
				//Function for selecting values of View drop down.
				public static boolean selectingView(Browser browser, String visibleText) {
					boolean selectingView = false;
					try {
						boolean fnStatus = fnListBox(browser,dropDownView, visibleText);
						if (fnStatus == true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "View dropdown Value selected successfully!!");
							selectingView = true;
						} 
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "View dropdown Value  is not selected ");
							errorCount++;
							selectingView = false;
						}
					}
					catch (Throwable t)
					{
						System.out.println("The Exception for selectingView is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for selectingView is : " + t.getMessage());
						softAssert.fail("The Exception for selectingView is : " + t.getMessage());
						errorCount++;
						selectingView = false;

					}
					return selectingView;
				}
				//Clicking on Go! button
				public static boolean clickingGoButton(Browser browser)
				{
					boolean clickingGoButton = false;
					try
					{
						boolean fnStatus = fnButtonClick(browser, btnGo);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "Go! button clicked successfully");
									clickingGoButton = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "Go! button is not clicked : ");
									errorCount++;
									clickingGoButton = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingGoButton is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingGoButton is : "+t.getMessage());
						softAssert.fail("The Exception for clickingGoButton is : "+t.getMessage());
						errorCount++;
						clickingGoButton = false;
					}
					return clickingGoButton;
				}
		//Function to click on a contactName Link of  a record in Contacts table..
				public static boolean clickingRecordValueOfTable(Browser browser, String tableLocator, String contactName )
				{
					boolean clickingRecordValueOfTable = false;
					try
					{
						if(isElementExist(browser, tableLocator))
						{
						
							int rowCount = GenericClass.getSectionTableRowCount(browser, tableLocator);
							outerloop:
								for(int i=1; i<=rowCount; i++)
							{
								String columnPath = tableLocator.concat("/div["+ i + "]//td");
								WebElement[] tdTags = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(columnPath).build());
								for(int l=0;l<= tdTags.length-1;l++ )
								{
									WebElement[] spanTags = tdTags[l].findChildren(WebElement.class, new WebElementDescription.Builder().xpath("//a/span").build());
								for (WebElement spanTag : spanTags)
									{
										if(spanTag.getInnerText().equals(contactName))
										{
											System.out.println(spanTag.getInnerText());
											spanTag.click();
											break outerloop;
										}
										else
										{
											continue;
										}
									}
								}
							}
							
							clickingRecordValueOfTable = true;
						}
						else
						{
							System.out.println("Parent object is not available");
							clickingRecordValueOfTable = false;
						}
					
				}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingRecordValueOfTable is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingRecordValueOfTable is : " + t.getMessage());
						softAssert.fail("The Exception for clickingRecordValueOfTable is : " + t.getMessage());
						errorCount++;
						clickingRecordValueOfTable = false;
					
					}
					
					return clickingRecordValueOfTable;
				}
				//Clicking contact name based on inputs in Contact table..
				public static boolean clickingContactNameFromTable(Browser browser,String contactName)
				{
					boolean clickingContactNameFromTable = false;
					try
					{
						boolean fnStatus = clickingRecordValueOfTable(browser, tablePrimary, contactName);
						if (fnStatus == true) 
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", contactName + " : is clicked successfully!!");
							clickingContactNameFromTable = true;
						} 
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on contact");
							errorCount++;
							clickingContactNameFromTable = false;
						}
					} 
					catch (Throwable t) 
					{
						System.out.println("The Exception for clickingContactNameFromTable is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingContactNameFromTable is : " + t.getMessage());
						softAssert.fail("The Exception for clickingContactNameFromTable is : " + t.getMessage());
						errorCount++;
						clickingContactNameFromTable = false;

					}
					return clickingContactNameFromTable;
				}

				//Function to click on either Save Or Save & New Or Cancel button of "Contact Edit", Page based on the user inputs..
	 			public static boolean  clickButtonOfContactEditPage(Browser browser, String buttonName)
	 			{
					boolean clickButtonOfContactEditPage = false;
					try
					{
						boolean fnStatus = false;
						String buttonXpath = "//h2[text()='Contact Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
						fnStatus = isElementExist(browser, buttonXpath);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Availabillity of "+ buttonXpath + ", element .");
						if(fnStatus ==true)
						{
							fnStatus = fnButtonClick(browser, buttonXpath);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Clicked on " + buttonName + ", button");
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickButtonOfNoteEditPage is :",t);
					}
					return  clickButtonOfContactEditPage;
					
				} 
			//Function for Filling New Contact Information Details section..	
				
				public static boolean fillingContactInfoFieldsClaimantType(Browser browser, String firstNameLabel,String firstNameValue,String lastNameLabel,String lastNameValue,
																			String ssNumberLabel,String ssNumber,String birthDate,String genderLabel,String genderValue)
				{
					boolean fillingContactInfoFieldsClaimantType=false;
					try
					{
						String contactInformationSecXpath = sectionContactInformation;
						boolean fnStatus=false;
						fnStatus=isElementExist(browser, contactInformationSecXpath);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of contactInformationSecXpath "+ contactInformationSecXpath);
						if(fnStatus==true)
						{
							 /*fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, firstNameLabel, preferenceValue);
							 if(fnStatus==true)
							 {
								 ReportEvent.testStepReport(tTestCaseName, "Pass", "Selected Name Preference as: "+preferenceValue);
								 fillingContactInfoFieldsClaimantType=true;
							 */
							//Enter first name..
						 fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser, firstNameLabel, firstNameValue);
						 GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered First name as: "+firstNameValue);
						 						
						//Enter Last name..
						 fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser,lastNameLabel, lastNameValue);
						 GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered Last name as: "+lastNameValue);
													
						//Enter SSNumber..
						 fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser,ssNumberLabel, ssNumber);
						 GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered Social Security Number as: "+ssNumber+" ");
						 
							
						 //Select Gender..
						 fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, genderLabel, genderValue);
						 GenericClass.reportlogger(fnStatus,tTestCaseName,"Selected Gender as: "+genderValue);
						
						//Selecting Birth date..
						 String birthDateXpath=contactInformationSecXpath.concat("//label[text()='Birthdate']/../..//input[@name='con7']"); 
							fnStatus=GenericClass.fnClikEditOrDateField(browser, birthDateXpath);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"clicked on Birth date text box");
							//Function for selecting a Birth date
							if(fnStatus == true)
							{
								fnStatus = GenericClass.datePicker(browser, datePicker,  GenericClass.dateConversion(birthDate, "FullMonth/dd/yyyy"));
								GenericClass.reportlogger(fnStatus,tTestCaseName,"Selected Birth date  as:" + birthDate);
								
							}
														
							/*############### Have to include New Cade going forword ######################*/
						}
						}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for fillingContactInfoFieldsClaimantType is :",t);
						
					}
					return fillingContactInfoFieldsClaimantType;
				}
				
			//Function for filling Address Information Section..
				public static boolean fillingAddressInfoFieldsClaimantType(Browser browser,String mailingStreetLabel,String mailingStreet,String mailingCityLabel,String mailingCity,String mailingStateLabel,String mailingState){
					boolean fillingAddressInfoFieldsClaimantType=false;
					try
					{
						String addressInformationSecXpath = sectionAddressInformation;
						boolean fnStatus =isElementExist(browser, addressInformationSecXpath);
						GenericClass.reportlogger(fnStatus,tTestCaseName, addressInformationSecXpath + ", Section availability ");
						
						if(fnStatus==true)
						{
							//Enter mailing street..
							fnStatus=GenericClass.sendKeysToAreaTextBoxByLabel(browser, mailingStreetLabel, mailingStreet);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered Mailing street address as : " +mailingStreet);
							
							//Enter Mailing City..
							fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser, mailingCityLabel, mailingCity);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered Mailing City address as : " +mailingCity);
							
							//Enter Mailing State..
							fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser, mailingStateLabel, mailingState);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered Mailing State address as : " +mailingState);
							
							
							/*###################### Have to Include new code in going forword ############################*/
							
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for fillingAddressInfoFieldsClaimantType is : ",t);
						
					}
					return fillingAddressInfoFieldsClaimantType;
				}
			
				////////////02082017/////////////// have to check the code....
				
				//Function for clicking claim number in Claim relationship section..
				public static boolean clickingClaimOfClaimRelationshipSec(Browser browser, String claimLink)
				{
					boolean clickingClaimOfClaimRelationshipSec = false;
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
								String aTagXpath = tableXpath.concat("//th/a");
								Link[] aTags=browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXpath).build());
								//List<WebElement> aTags = driver.findElements(By.xpath(subjectxPath)); 
								for (Link cellText : aTags)
								{
										if(cellText.getInnerText().equals(claimLink))
										{
											cellText.highlight();
											cellText.click();
											ReportEvent.testStepReport("", "PASS", "Clicked on Claim ID as:"+cellText+" in claim Relationship section successfully." );
											clickingClaimOfClaimRelationshipSec = true;
											break outerloop;
										}
										else
										{
											continue;
										}
								}
							}
							
							clickingClaimOfClaimRelationshipSec = true;
						}
						else
						{
							//System.out.println("Claim Relationship dynamic table is not available");
							ReportEvent.testStepReport("", "PASS", "Claim Relationship dynamic table is not available");
							errorCount++;
							clickingClaimOfClaimRelationshipSec = false;
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingClaimOfClaimRelationshipSec is : ",t);
					}
					return clickingClaimOfClaimRelationshipSec;
					
				}
				//Function for confirming the Claim Page navigation..
				
				public static boolean confirmingClaimIDPageNavigation(Browser browser,String claimId)
				{
					boolean confirmingNewContactPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtClaimHeaderID);
								if(fnStatus ==true)
								{
									WebElement ele=browser.describe(WebElement.class,new XPathDescription(txtClaimHeaderID));
									String claimHeader=ele.getInnerText();
									if(claimHeader.contains(claimId))
									{
									
									ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Calim Relation ship id:"+claimId+" successfully!!");
									confirmingNewContactPageNavigation = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to New Contact Page");
									errorCount++;
									confirmingNewContactPageNavigation = false;
								}
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for confirmingNewContactPageNavigation is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for confirmingNewContactPageNavigation is : "+t.getMessage());
						softAssert.fail("The Exception for confirmingNewContactPageNavigation is : "+t.getMessage());
						errorCount++;
						confirmingNewContactPageNavigation = false;
						
					}
					return confirmingNewContactPageNavigation;
				}
				
				//Function for clicking Add Benefit Claimed Button..
				public static boolean clickingAddBenefitClaimedButton(Browser browser)
				{
					boolean clickingAddBenefitClaimedButton = false;
					try
					{
						boolean fnStatus = fnButtonClick(browser, btnAddBenefitClaimed);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"'Add Benefit Claimed' button Should be clicked ");
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingAddBenefitClaimedButton is : ",t);
					}
					return clickingAddBenefitClaimedButton;
				}
						
				
				//Function for confirming the Search Account and Policy navigation..
				
				public static boolean confirmingSearchAccounPolicyPageNavigation(Browser browser)
				{
					boolean confirmingSearchAccounPolicyPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtBenefitClaimCreationHeader);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Benefit Claimed Creation - Search Account and Policy Page!!");
									confirmingSearchAccounPolicyPageNavigation = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Benefit Claimed Creation - Search Account and Policy Page");
									errorCount++;
									confirmingSearchAccounPolicyPageNavigation = false;
								}
								
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for confirmingSearchAccounPolicyPageNavigation is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for confirmingSearchAccounPolicyPageNavigation is : "+t.getMessage());
						softAssert.fail("The Exception for confirmingSearchAccounPolicyPageNavigation is : "+t.getMessage());
						errorCount++;
						confirmingSearchAccounPolicyPageNavigation = false;
						
					}
					return confirmingSearchAccounPolicyPageNavigation;
				}
				
				//Function for clicking Search contact from Contacts section..
				public static boolean clickingSearchContactNameInContactSec(Browser browser, String contactName)
					{
					boolean clickingSearchContactNameInContactSec = false;
					try
					{
						boolean fnStatus = false;
						String tableXpath = tblSearchContact;
						fnStatus = isElementExist(browser, tableXpath);
						if(fnStatus == true)
						{
							int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
							outerloop:
							for(int i=1; i<=rowCount; i++)
							{
								String aTagXpath = tableXpath.concat("//th/a");
								Link[] aTags=browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXpath).build());
								for (Link cellText : aTags)
								{
										if(cellText.getInnerText().equals(contactName))
										{
											cellText.click();
											clickingSearchContactNameInContactSec = true;
											break outerloop;
										}
										else
										{
											continue;
										}
								}
							}
							
							clickingSearchContactNameInContactSec = true;
						}
						else
						{
							System.out.println("Search Contact dynamic table is not available");
							errorCount++;
							clickingSearchContactNameInContactSec = false;
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingSearchContactNameInContactSec is :",t);
					}
					return clickingSearchContactNameInContactSec;
					
				}


				
				
				
				
		//////////////////////////////////
		public static boolean checkingTextboxLabel(Browser browser,String labelName/*,String inputValue*/)
		{
			boolean checkingdate = false;
			try
			{
				//String date=sectionContactInformation.concat("//input[contains(@name,'BUBI9')]");
				boolean fnStatus =GenericClass.checkFieldNameAvailabilityInSection(browser, labelName, sectionContactDetails);
				
				//Function for selecting a Birth date
				if(fnStatus == true)
				{
					//fnStatus = datePicker(browser, datePicker,  dateConversion(dateOfHire, "FullMonth/dd/yyyy"));
					if(fnStatus == true)
					{
						//ReportEvent.testStepReport("", "PASS", "Selected Birth date  as:" + dateOfHire);
						checkingdate =  true;
					}
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Didn't selected the Birth date as :");
						errorCount++;
						checkingdate =  false;
					}
				}
				
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Didn't clicked on Birth date text box");
					errorCount++;
					checkingdate =  false;
				}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for clickingNewAbsenceClaimButton is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingNewAbsenceClaimButton is : "+t.getMessage());
				softAssert.fail("The Exception for clickingNewAbsenceClaimButton is : "+t.getMessage());
				errorCount++;
				checkingdate = false;
			}
			return checkingdate;
		}
		//Function for confirming contact page navigation..
				public static boolean confirmingContactPageNavigation(Browser browser)
				{
					boolean confirmingContactPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtContactHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to Contact Page successfully!!");
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingContactPageNavigation is :",t);
					}
					return confirmingContactPageNavigation;
				}
		//Function for refreshing the search results page after clicking the search button..
				public static boolean refreshingSearchResultsPage(Browser browser)
				{
					boolean refreshingSearchResultsPage = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtSearchResultsHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Search Results Page should be refreshed with record");		
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for refreshingSearchResultsPage is :",t);
					}
					return refreshingSearchResultsPage;
				}
				
				
				///////////////23092017/////////////////
				//Function for selecting Record type dropdown value..
				public static boolean selectingRecordType(Browser browser, String recordType)
				{
					boolean selectingRecordType = false;
					try
					{
						boolean fnStatus =isElementExist(browser, sectionSelectContactRecord);
						if(fnStatus==true)
						{
						fnStatus = GenericClass.fnClickListBox(browser, dropDownRecordType);
						if(fnStatus == true)
						{
							fnStatus = fnListBox(browser, dropDownRecordType, recordType);
							if(fnStatus == true)
							{
								ReportEvent.testStepReport("", "Pass", "Selected Record Type of new record as : " + recordType);
								selectingRecordType = true;
							}
							else
							{
								ReportEvent.testStepReport("", "FAIL", "Failed to select record type as : " + recordType);
								selectingRecordType = false;
							}
						}
						else{
							ReportEvent.testStepReport("", "FAIL", "Select Contact Record Type section is available");
							errorCount++;
							selectingRecordType = false;
						}
					}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for selectingRecordType is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for selectingRecordType is : "+t.getMessage());
						softAssert.fail("The Exception for selectingRecordType is : "+t.getMessage());
						errorCount++;
						selectingRecordType = false;
					}
					return selectingRecordType;
				}

				//Function for confirming Selected Record contact Type page navigation..
				public static boolean confirmingSelectedRecordTypeNavigation(Browser browser)
				{
					boolean confirmingSelectedRecordTypeNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtSelectRecordTypeHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to Selected Contact Record Type Page ");
								
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingSelectedRecordTypeNavigation is : ",t);
					}
					return confirmingSelectedRecordTypeNavigation;
				}
		
			//Function for validating the field values of Contact information section or contact details section based on label name..
				public static void validatingContactDetailSecFieldValues(Browser browser,String nameLabel,String birthdateLabel,String genderLabel,String ssNumber,String accountLabel, String inputValues)
				{
					boolean validatingContactDetailSecFieldValues=false;
					int counter = 0;
					String name = null, birthdate= null,gender= null, ssNo = null,account=null;
					try
					{
						String[] splitArray =inputValues.split(",");
						boolean fnStatus=isElementExist(browser, sectionContactDetails);
								
						if(fnStatus==true)
						{
							name = GenericClass.getFieldValueOfSection(browser, nameLabel , sectionContactDetails);
							/*birthdate = GenericClass.getFieldValueOfSection(browser, birthdateLabel , sectionContactDetails);*/
							gender = GenericClass.getFieldValueOfSection(browser, genderLabel , sectionContactDetails);
							ssNo = GenericClass.getFieldValueOfSection(browser, ssNumber , sectionContactDetails);
							account = GenericClass.getFieldValueOfSection(browser, accountLabel , sectionContactDetails);
							String[] appData = {name,gender,ssNo,account};
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
							
							/*if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Contact Detail section :"+nameLabel+" label related value should be Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Detail section :"+nameLabel+" label related value is not Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,birthdateLabel , sectionContactDetails);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Contact Detail section :"+birthdateLabel+" label related value should be Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Detail section :"+birthdateLabel+" label related value is not Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,genderLabel , sectionContactDetails);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Contact Detail section :"+genderLabel+" label related value should be Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Detail section :"+genderLabel+" label related value is not Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,ssNumber , sectionContactDetails);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Contact Detail section :"+ssNumber+" label related value should be Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Detail section :"+ssNumber+" label related value is not Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,accountLabel , sectionContactDetails);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Contact Detail section :"+accountLabel+" label related value should be Updated !!");
								validatingContactDetailSecFieldValues=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Detail section :"+accountLabel+" label related value is not Updated !!");
								validatingContactDetailSecFieldValues=true;
							}*/
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", "Contact Detail Section is not available!!");
							errorCount++;
							
						}
						
							}
					catch(Throwable t)
					{
						System.out.println("The Exception for validatingContactDetailSecFieldValues is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for validatingContactDetailSecFieldValues is : "+t.getMessage());
						softAssert.fail("The Exception for validatingContactDetailSecFieldValues is : "+t.getMessage());
						errorCount++;
						
					}
				
				}
				
				
				
}
