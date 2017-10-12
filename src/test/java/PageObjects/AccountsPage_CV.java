package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hp.lft.sdk.java.InternalFrame;
import com.hp.lft.sdk.java.InternalFrameDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.Frame;
import com.hp.lft.sdk.web.FrameDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListItem;
import com.hp.lft.sdk.web.Page;
import com.hp.lft.sdk.web.PageDescription;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableRow;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

public class AccountsPage_CV extends DriverScript{
	
	
	public static final String txtAccountsHeader = "//div[@class ='bPageTitle']/..//h1[text()='Accounts']";
	public static final String tblRecentAbsenceClaimsAbsenceClaim="//div[@title='Action']/..//ancestor::div[@class='x-grid3-viewport']/child::div[2]/child::div[@class='x-grid3-body']";
	public static final String sectionAssignedAccountUsers="//h3[text()='Assigned Account Users']/../../../../../..//parent::div[contains(@class,'listRelatedObject')]";
	public static final String btnNewAssignedAccountUsers="//h3[text()='Assigned Account Users']/../../../../../..//input";
	public static final String txtNewAssignedAccountHeader="//h2[text()=' New Assigned Account User']";
	public static final String sectionAssignedAccountInfo="//h3[text() ='Information']/../..";
	public static final String imgLinkRightClaim="//img[contains(@id,'A2JD5_right')]";
	public static final String linkClaimNavigationBtn = "//div[@class='pbSubsection']/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/a[1]/img";
	public static final String imgLinkRightBenefitType="//img[contains(@id,'A2JD4_right')]";
	public static final String linkBenefitNavigationBtn = "//div[@class='pbSubsection']/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[2]/a[1]/img";
	public static final String imgLinkLeftClaim="//img[contains(@id,'A2JD5_left')]";
	public static final String imgLinkLeftBenefitType="//img[contains(@id,'A2JD4_left')]";
	public static final String tblPrimary = "//div[@class='listBody']//child::div[@class ='x-grid3-body']";
	public static final String sectionPolicyRelationship = "//h3[text()='Policy Relationships']/../../../../../..";
	public static final String txtpolicyDetailPageHeader = "//div[@class='ptBody']//child::h2[@class='pageDescription']";
	public static final String sectionContactPane="//h3[text()='Contacts']/../following-sibling::div[1]//iframe[@title='ContactRelatedListOverride']";
	public static final String tblContactPane="//div[@class='contactBlock']//div[@class='pbBody']/child::table";
	public static final String btnNewContact="//div[text()='Action']/../../../../..//input";
	public static final String sectionContactDetails ="//td[text()='Contact Owner']/../../..//parent::div[@class='pbSubsection']";
	public static final String btnNewAssignedPolicyUsers="//h3[text()='Assigned Policy Users']/../../../../../..//input";
	public static final String txtNewAssignedPolicyHeader="//h2[text()=' New Assigned Policy User']";
	public static final String sectionAssignedAccountUserDetail="//h2[text()='Assigned Account User Detail']/../../../../..//parent::div[contains(@class,'bPageBlock')]";
	public static final String sectionAssignedPolicyUserDetail="//h2[text()='Assigned Policy User Detail']/../../../../..//parent::div[contains(@class,'bPageBlock')]";
	public static final String txtSelectedAccountHeader ="//h2[text()='STD Only #1']";
	public static final String btnNewContract="//h3[text()='Contract']/../../../../../..//input";
	public static final String txtNewContractHeader ="//h2[text()='New Contract']";
	public static final String sectionContractInfo="//h3[text() ='Information']/../..";
	public static final String txtContractDetailHeader ="//h2[text()='Contract Detail']";
	public static final String sectionContract="//h3[text()='Contract']/../../../../../..";
	public static final String lstClaimComplexityChoosen="//select[contains(@title,'Complexity Assignments - Chosen')]";
	public static final String lstBenefitTypeChoosen="//select[contains(@title,'Benefit Type Assignments - Chosen')]";
	public static final String txtAssignedAccountUserHeader="//h1[text()='Assigned Account User']";
	public static final String sectionAssignedPolicyUsers="//h3[text()='Assigned Policy Users']/../../../../../..";
	public static final String sectionAssignedPolicyInfo="//label[text()='Policy']/../../../../..";
	public static final String sectionContact="//div[text()='Action']/../../../../..";
	public static final String txtAssignedAccountUserDetilHeader="//h2[text()='Assigned Account User Detail']";
	public static final String txtAssignedPolicyUserDetilHeader="//h2[text()='Assigned Policy User Detail']";
	//div[@class='content']
	
	//Function for confirming Accounts page navigation..
			public static boolean confirmingAccountsPageNavigation(Browser browser)
			{
				boolean confirmingContactsPageNavigation = false;
				try
				{
					boolean fnStatus = isElementExist(browser, txtAccountsHeader);
							if(fnStatus ==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to Accounts home Page successfully!!");
								confirmingContactsPageNavigation = true;
							}
							else 
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Accounts home Page");
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
			
			//Function for clicking Account Name..
			public static boolean clickingAccountNameFromTable(Browser browser,String AccountName)
			{
				boolean clickingAccountNameFromTable = false;
				try
				{
					boolean fnStatus = ContactsPage_CV.clickingRecordValueOfTable(browser, tblPrimary, AccountName);
					if (fnStatus == true) 
					{
						ReportEvent.testStepReport(tTestCaseName, "pass", AccountName + " : Should be clicked successfully!!");
						clickingAccountNameFromTable = true;
					} 
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on Account Name");
						errorCount++;
						clickingAccountNameFromTable = false;
					}
				} 
				catch (Throwable t)
				{
					System.out.println("The Exception for clickingAccountNameFromTable is : " + t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for clickingAccountNameFromTable is : " + t.getMessage());
					softAssert.fail("The Exception for clickingAccountNameFromTable is : " + t.getMessage());
					errorCount++;
					clickingAccountNameFromTable = false;

				}
				return clickingAccountNameFromTable;
			}
			
			
			//Function for Confirming Selected account page navigation.
			public static boolean confirmingAccountPageNavigation(Browser browser)
			{
				boolean confirmingAccountPageNavigation = false;
				try
				{
					boolean fnStatus = isElementExist(browser, txtSelectedAccountHeader);
					GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to Selected Account Page ");
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for confirmingAccountPageNavigation is : ",t);
				}
				return confirmingAccountPageNavigation;
			}
			
			/*//Function for clicking Action Type (Edit or Del) link in Assigned Account user section..
	public static boolean clickingActionTypeOfAssignedAccountUserSec(Browser browser, String assignAccName,String action)
		{
			
			boolean clickingActionTypeOfAssignedAccountUserSec = false;
			int j =0;
			try
			{
				boolean fnStatus = false;
				String tableXpath = sectionAssignedAccountUsers.concat("//div[@class='pbBody']//table");
				fnStatus = isElementExist(browser, tableXpath);
				if(fnStatus == true)
				{
					int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
					outerloop:
					for(int i=2; i<=rowCount; i++)
					{
						
						String aTagXPath = tableXpath+"//tr["+i+"]//a";
						Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
						
					for(Link atag : allLinks)
						{
							String atagText = atag.getInnerText();
							if(atagText.equals(assignAccName))
							{
								
								for(Link atagElement : allLinks)
								{
									String atagElementText = atagElement.getInnerText();
									if(atagElementText.equals(action))
									{
										String elementXpath = aTagXPath+"[text()='" + action + "']";	
										fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
										if(fnStatus==true)
										{
											clickingActionTypeOfAssignedAccountUserSec = true;
										}
										else
										{
											ReportEvent.testStepReport("", "fail", "Failed to click Assigned Account User action");
											errorCount++;
											clickingActionTypeOfAssignedAccountUserSec = false;	
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
					
					clickingActionTypeOfAssignedAccountUserSec = true;
				}
				else
				{
					
					ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table is not available");
					errorCount++;
					clickingActionTypeOfAssignedAccountUserSec = false;
				}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
				softAssert.fail("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
				errorCount++;
				clickingActionTypeOfAssignedAccountUserSec = false;
			}
			return clickingActionTypeOfAssignedAccountUserSec;
		}*/
		
		//Function for clicking New Assigned Account User Button..
		public static boolean clickingNewAssignedAccountUserButton(Browser browser)
		{
			boolean clickingNewAssignedAccountUserButton = false;
			try
			{
				boolean fnStatus = fnButtonClick(browser, btnNewAssignedAccountUsers);
				GenericClass.reportlogger(fnStatus,tTestCaseName,"'New Assigned Account User' button Should be clicked");
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for clickingNewAssignedAccountUserButton is : ",t);
			}
			return clickingNewAssignedAccountUserButton;
		}
		
				
		//Function for Confirming New Assigned Account User page navigation..
		public static boolean confirmingNewAssignedAccountUserPageNavigation(Browser browser)
				{
					boolean confirmingNewAssignedAccountUserPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtNewAssignedAccountHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to New Assigned Account User Page !!");
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingNewAssignedAccountUserPageNavigation is :",t);
					}
					return confirmingNewAssignedAccountUserPageNavigation;
				}
	
				//Function to click on either Save Or Save & New Or Cancel button of "Assigned Account User Edit", Page based on the user inputs..
	 			public static boolean  clickButtonOfAssignedAccountUserEditPage(Browser browser, String buttonName)
	 			{
					boolean clickButtonOfAssignedAccountUserEditPage = false;
					try
					{
						boolean fnStatus = false;
						String buttonXpath = "//h2[text()='Assigned Account User Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
						fnStatus = isElementExist(browser, buttonXpath);
						GenericClass.reportlogger(fnStatus,tTestCaseName,buttonXpath + ", element available.");
						
						if(fnStatus ==true)
						{
							fnStatus = fnButtonClick(browser, buttonXpath);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Clicked on " + buttonName + ", button");
							
						}
						
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickButtonOfAssignedAccountUserEditPage is :",t);
						
					}
					return  clickButtonOfAssignedAccountUserEditPage;
					
				} 
			
		/*//Function for Filling Assigned Account User Information section fields based on user inputs..
	 			
	 			public static boolean fillingAssignedAccountUserInfoFields(Browser browser,String claimAvailableValue,String benefitType)
	 			{
	 				boolean fillingAssignedAccountUserInfoFields=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedAccountInfo);
	 					if(fnStatus==true)
	 					{
	 						//Selecting Available list box value in Claim complexity..
	 						String claimComplexityXpath=sectionAssignedAccountInfo.concat("//select[contains(@title,'Complexity Assignments - Available')]");
	 						fnStatus=fnListBox(browser, claimComplexityXpath, claimAvailableValue);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightClaim);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Claim Complexity Right arrow successfully!!");
	 							fillingAssignedAccountUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Claim Complexity Right arrow");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Claim Complexity dropdown value");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 					//Selecting Available list box value in Benefit Type..
	 						String benefitTypeXpath=sectionAssignedAccountInfo.concat("//select[contains(@title,'Benefit Type Assignments - Available')]");
	 						fnStatus=fnListBox(browser, benefitTypeXpath, benefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightBenefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Benefit Type Assignments Right arrow successfully!!");
	 							fillingAssignedAccountUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Benefit Type Assignments Right arrow");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Benefit Type Assignments dropdown value");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 					
	 						
	 					}
	 					else
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Assigned account user section is not available");
							errorCount++;
							fillingAssignedAccountUserInfoFields=false;
	 					}
	 					
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					fillingAssignedAccountUserInfoFields=false;
	 				}
	 				return fillingAssignedAccountUserInfoFields;
	 			}
	 			*/
	 			//Clicking on Policy related link of Policy relationship section.. 
				/*public static boolean clickingLinkOfPolicyRelationship(Browser browser, String policyID)
				{
					boolean clickingLinkOfPolicyRelationship = false;
					try
					{
						boolean fnStatus = false;
						String tableXpath = sectionPolicyRelationship.concat("//div[@class='pbBody']//table");
						fnStatus = isElementExist(browser, tableXpath);
						if(fnStatus == true)
						{
							int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
							outerloop:
							for(int i=2; i<=rowCount; i++)
							{
								String aTagXpath = tableXpath.concat("//th/a");
								Link[] aTags=browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXpath).build());
								
								for (Link cell : aTags)
								{
									System.out.println(cell.getInnerText());
										if(cell.getInnerText().equals(policyID))
										{
											
											cell.click();
											clickingLinkOfPolicyRelationship = true;
											break outerloop;
										}
										else
										{
											continue;
										}
								}
							}
							
							clickingLinkOfPolicyRelationship = true;
						}
						else
						{
							System.out.println("Policy Relationship dynamic table is not available");
							errorCount++;
							clickingLinkOfPolicyRelationship = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
						softAssert.fail("The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
						errorCount++;
						clickingLinkOfPolicyRelationship = false;
					}
					return clickingLinkOfPolicyRelationship;
					
				}*/

				//Function for confirming navigation to Policy detail Page based on user inputs of policy ID.
				public static boolean confirmingPolicyDetailPageNavigation(Browser browser, String policyID)
						{
							boolean confirmingPolicyDetailPageNavigation=false;
							
								try
								{	
									WebElement policyHeader=browser.describe(WebElement.class,new XPathDescription(txtpolicyDetailPageHeader));
											String policyIDHeader=policyHeader.getInnerText();
											if(policyIDHeader.contains(policyID))
											{
											ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to "+policyID+" policy detail page successfully!!");
											confirmingPolicyDetailPageNavigation = true;
										}
										else 
										{
											ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to " + policyID +" : , policy detail page");
											errorCount++;
											confirmingPolicyDetailPageNavigation = false;
										}
							}
							catch(Throwable t)
							{
								System.out.println("The Exception for confirmingPolicyDetailPageNavigation is : "+t.getMessage());
								ReportEvent.testStepReport("", "fail", "The Exception for confirmingPolicyDetailPageNavigation is : "+t.getMessage());
								softAssert.fail("The Exception for confirmingPolicyDetailPageNavigation is : "+t.getMessage());
								errorCount++;
								confirmingPolicyDetailPageNavigation = false;
								
							}
								return confirmingPolicyDetailPageNavigation;
						}
				//Function for verifying the account field is updated available with account in a contact details section..
				public static boolean vefiryingAccountFieldInContactDetailsSec(Browser browser,String fieldName)
				{
					boolean vefiryingAccountFieldInContactDetailsSec=false;
					try
					{
						boolean fnStatus=false;
						String fieldValue=GenericClass.getFieldValueOfSection(browser, fieldName, sectionContactDetails);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Account Name : "+fieldValue+" should be validated successfully!!");
							vefiryingAccountFieldInContactDetailsSec = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to validate Account Name:  " + fieldValue +"");
							errorCount++;
							vefiryingAccountFieldInContactDetailsSec = false;
						}
						}
					catch(Throwable t)
					{
						System.out.println("The Exception for confirmingPolicyDetailPageNavigation is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for confirmingPolicyDetailPageNavigation is : "+t.getMessage());
						softAssert.fail("The Exception for confirmingPolicyDetailPageNavigation is : "+t.getMessage());
						errorCount++;
						vefiryingAccountFieldInContactDetailsSec=false;
					
					}
					return vefiryingAccountFieldInContactDetailsSec;
				}
				//Clicking on Contact name in Contact section under account details page.. 
				public static boolean clickingContactPaneNameFromTable(Browser browser,String pageTitle,String frameName,String contactName)
				{
					boolean clickingContactPaneNameFromTable = false;
					try
					{
						boolean fnStatus = false;

						fnStatus = isElementExist(browser, tblContactPane);
						if(fnStatus == true)
						{
							
							/*Table tbl=browser.describe(Page.class, new PageDescription.Builder()
									.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
											.id(frameName).build()).describe(Table.class, new XPathDescription(tblContactPane));*/
							Table tbl=browser.describe(Page.class, new PageDescription.Builder()
									.title("Account: CV LDS ~ Salesforce - Unlimited Edition").build()).describe(Frame.class, new FrameDescription.Builder()
									.id("066A0000001xEdg").build()).describe(Table.class, new XPathDescription(tblContactPane));
							
							tbl.highlight();
							List<TableRow> rowCount= tbl.getRows();
							int totalRowCount = rowCount.size();
						
							outerloop:
							for(int i=1; i<=totalRowCount; i++)
							{
								XPathDescription aTagsXpath = new XPathDescription(tblContactPane+ "//tr[" + i + "]//a");
								Link [] aTags=tbl.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagsXpath).build());
								int links=aTags.length;
								for (Link cellText : aTags)
								{
										if(cellText.getInnerText().equals(contactName))
										{
											cellText.click();
											ReportEvent.testStepReport(tTestCaseName, "pass", contactName + " : is clicked successfully!!");
											clickingContactPaneNameFromTable = true;
											break outerloop;
										}
										else
										{
											continue;
										}
								}
						
							clickingContactPaneNameFromTable = true;
							}
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on contact");
							errorCount++;
							clickingContactPaneNameFromTable = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingContactPaneNameFromTable is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingContactPaneNameFromTable is : " + t.getMessage());
						softAssert.fail("The Exception for clickingContactPaneNameFromTable is : " + t.getMessage());
						errorCount++;
						clickingContactPaneNameFromTable = false;
					}
					return clickingContactPaneNameFromTable;
					
				}

				/*//Function for clicking New Assigned Policy User Button..
				public static boolean clickingNewAssignedPolicyUserButton(Browser browser)
				{
					boolean clickingNewAssignedPolicyUserButton = false;
					try
					{
						boolean fnStatus = fnButtonClick(browser, btnNewAssignedPolicyUsers);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "'New Assigned Policy User' button Should be clicked successfully");
									clickingNewAssignedPolicyUserButton = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'New Assigned Policy User' button is not clicked ");
									errorCount++;
									clickingNewAssignedPolicyUserButton = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingNewAssignedPolicyUserButton is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingNewAssignedPolicyUserButton is : "+t.getMessage());
						softAssert.fail("The Exception for clickingNewAssignedPolicyUserButton is : "+t.getMessage());
						errorCount++;
						clickingNewAssignedPolicyUserButton = false;
					}
					return clickingNewAssignedPolicyUserButton;
				}
				*/
						
				//Function for Confirming New Assigned Policy User page navigation..
				public static boolean confirmingNewAssignedPolicyUserPageNavigation(Browser browser)
						{
							boolean confirmingNewAssignedPolicyUserPageNavigation = false;
							try
							{
								boolean fnStatus = isElementExist(browser, txtNewAssignedPolicyHeader);
								GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to New Assigned Policy User Page");
									
							}
							catch(Throwable t)
							{
								GenericClass.Catchhandler("The Exception for confirmingNewAssignedPolicyUserPageNavigation is : ",t);
							}
							return confirmingNewAssignedPolicyUserPageNavigation;
						}
				/*//Function for clicking New Contact Button in Accounts details section....
				public static boolean clickingNewConatctButton(Browser browser,String pageTitle,String frameName)
				{
					boolean clickingNewConatctButton = false;
					try
					{
						boolean fnStatus = GenericClass.fnClickButtonInTableWindowFrame(browser, pageTitle, frameName, btnNewContact);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "'New Conatct' button Should be clicked successfully");
									clickingNewConatctButton = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'New Conatct' button is not clicked ");
									errorCount++;
									clickingNewConatctButton = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingNewConatctButton is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingNewConatctButton is : "+t.getMessage());
						softAssert.fail("The Exception for clickingNewConatctButton is : "+t.getMessage());
						errorCount++;
						clickingNewConatctButton = false;
					}
					return clickingNewConatctButton;
				}
*/
				//Function for checking Fields are available in Assigned Account User Detail section based on user inputs..
				public static boolean checkingAssignedAccountUserDetailSecFields(Browser browser,String inputFieldValues)
				{
					boolean checkingAssignedAccountUserDetailSecFields=false;
					try
					{
						String sectionAssignedAccountUserDetail="//h2[text()='Assigned Account User Detail']/../../../../..//parent::div[contains(@class,'bPageBlock')]";
						boolean fnStatus=isElementExist(browser, sectionAssignedAccountUserDetail);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of Assigned Account User Detail Section ");
						
						if(fnStatus==true)
						{
							fnStatus=validatingSectionfieldsAvailability(browser, inputFieldValues, sectionAssignedAccountUserDetail);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Assigned Account User Detail Section fields are: "+inputFieldValues+"verified !!");
							
						}
						}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for checkingAssignedAccountUserDetailSecFields is :",t);
						
					}
				return checkingAssignedAccountUserDetailSecFields;
				}
				
				//Function for clicking Account Name field value in Assigned account User detail section..
				public static boolean clickingAccountNameAssignedAccUserDetailPage(Browser browser,String fieldName)
				{
					boolean clickingAccountNameAssignedAccUserDetailPage=false;
					try
					{
						String sectionAssignedAccountUserDetail="//td[text()='Assigned Account Name']/../../../.."/*"//h2[text()='Assigned Account User Detail']/../../../../..//parent::div[contains(@class,'bPageBlock')]"*/;
						boolean fnStatus=isElementExist(browser, sectionAssignedAccountUserDetail);
						GenericClass.reportlogger(fnStatus,tTestCaseName,fieldName + " Assigned Account User Detail Section is not available.!!");	
						
						if(fnStatus==true)
						{
							
							fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, fieldName, sectionAssignedAccountUserDetail);
							GenericClass.reportlogger(fnStatus,tTestCaseName,fieldName + " label related link successfully.");
							
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingAccountNameAssignedAccUserDetailPage is : ",t);
					}
				return clickingAccountNameAssignedAccUserDetailPage;
				}
				
				//Function for getting all td fields in a section..
				public static List<String> getTdTagsOfSection( String sectionXpath,Browser browser) {
					List<String> tdTagsList = new ArrayList<String>();
					try {
						String allTdTagsXpath = sectionXpath.concat("//table//td");
						
						WebElement[] allChild=browser.findChildren(WebElement.class, new XPathDescription(allTdTagsXpath));
				
						for (WebElement tdText:allChild)
						{
							/*tdText.highlight();*/
							System.out.println(tdText.getInnerText());
							tdTagsList.add(tdText.getInnerText());
						}

					} 
					catch (Throwable t)
					{
						System.out.println("The Exception for getTdTagsOfSection is : " + t.getMessage());
						utility.fnLogging("The Exception for getTdTagsOfSection is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for getTdTagsOfSection is : " + t.getMessage());
						
					}

					return tdTagsList;
				}

				public static boolean validatingSectionfieldsAvailability(Browser browser, String inputFieldValues,String sectionXpath) {
					int matchedFieldCounter = 0;
					boolean validationSectionfieldsAvailability = false;
					try {
						boolean fnStatus= false;
						String splitInputFields[] = inputFieldValues.split(",");
						List<String> splitInputFieldsList = new ArrayList<String>();
						splitInputFieldsList = Arrays.asList(splitInputFields);
						int inputFieldCount = splitInputFieldsList.size();
						List<String> pageSource = getTdTagsOfSection(sectionXpath,browser);
						/*for(int i =0;i<splitInputFields.length;i++)
						{
							fnStatus = GenericClass.checkFieldAvailabilityBasedOnLabel(browser, splitInputFields[i]);
							if(fnStatus==true)
							{
								matchedFieldCounter++;
							}
							else
							{
								continue;
							}
						}*/
						
						for (int i = 0; i <= pageSource.size() - 1; i++) 
						{
							for(int j=0;j<splitInputFieldsList.size();j++)
							{
								if (pageSource.get(i).equalsIgnoreCase(splitInputFieldsList.get(j))) 
								{
									matchedFieldCounter++;
								} else {
									continue;
								}
							}
							
						}
						if (matchedFieldCounter == (splitInputFieldsList.size())) {
							validationSectionfieldsAvailability = true;
						} else {
							int difference = (splitInputFieldsList.size()) - matchedFieldCounter;
							ReportEvent.testStepReport("", "FAIL", difference + "is count of unmatched field names.");
							validationSectionfieldsAvailability = false;
						}

					} catch (Throwable t) {
						System.out.println("The Exception for validationSectionfieldsAvailability is : " + t.getMessage());
						utility.fnLogging("The Exception for validationSectionfieldsAvailability is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail",
								"The Exception for validationSectionfieldsAvailability is : " + t.getMessage());
						//softAssert.fail("The Exception for fieldAvailabilityValidation is : " + t.getMessage());
						validationSectionfieldsAvailability = false;
					}

					return validationSectionfieldsAvailability;
				}
				
				
				
				
				/*//Function for Filling Assigned Policy User Information section fields based on user inputs..
	 			
	 			public static boolean fillingAssignedPolicyUserInfoFields(Browser browser,String claimAvailableValue,String benefitType)
	 			{
	 				boolean fillingAssignedPolicyUserInfoFields=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedPolicyInfo);
	 					if(fnStatus==true)
	 					{
	 						//Selecting Available list box value in Claim complexity..
	 						String claimComplexityXpath=sectionAssignedPolicyInfo.concat("//select[contains(@title,'Complexity Assignments - Available')]");
	 						fnStatus=fnListBox(browser, claimComplexityXpath, claimAvailableValue);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightClaim);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Claim Complexity Right arrow successfully!!");
	 							fillingAssignedPolicyUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Claim Complexity Right arrow");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Claim Complexity dropdown value");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 					//Selecting Available list box value in Benefit Type..
	 						String benefitTypeXpath=sectionAssignedPolicyInfo.concat("//select[contains(@title,'Benefit Type Assignments - Available')]");
	 						fnStatus=fnListBox(browser, benefitTypeXpath, benefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightBenefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Benefit Type Assignments Right arrow successfully!!");
	 							fillingAssignedPolicyUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Benefit Type Assignments Right arrow");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Benefit Type Assignments dropdown value");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 					
	 						
	 					}
	 					else
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Assigned account user section is not available");
							errorCount++;
							fillingAssignedPolicyUserInfoFields=false;
	 					}
	 					
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					fillingAssignedPolicyUserInfoFields=false;
	 				}
	 				return fillingAssignedPolicyUserInfoFields;
	 			}
	 			*/
				
				//Selecting Assigned Policy User Name  in a frame..
				public static boolean selectingUserNameFromAssignedPolicyWindowFrame(Browser browser, String nameValue)
				{
					boolean selectingUserNameFromAssignedPolicyWindowFrame= false;
					
					try
					{
						boolean fnStatus=false;
						
						
							String userNameTextBoxXpath=sectionAssignedPolicyInfo.concat("//span[@class='lookupInput']/..//child::input[@name='CF00NA000000A2JD9']");
							fnStatus = fnEditFieldTextEntry(browser, userNameTextBoxXpath, nameValue);	
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Entered Assigned User Name as :"+ nameValue);
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for selectingUserNameFromAssignedPolicyWindowFrame is : ",t);
						
					}
						return selectingUserNameFromAssignedPolicyWindowFrame;
				}	
				//Function to click on either Save Or Save & New Or Cancel button of "Assigned Policy User Edit", Page based on the user inputs..
	 			public static boolean  clickButtonOfAssignedPolicyUserEditPage(Browser browser, String buttonName)
	 			{
					boolean clickButtonOfAssignedPolicyUserEditPage = false;
					try
					{
						boolean fnStatus = false;
						String buttonXpath = "//h2[text()='Assigned Policy User Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
						fnStatus = isElementExist(browser, buttonXpath);
						GenericClass.reportlogger(fnStatus,tTestCaseName, buttonXpath + " ,element is availability  ");
						if(fnStatus ==true)
						{
							fnStatus = fnButtonClick(browser, buttonXpath);
							GenericClass.reportlogger(fnStatus,tTestCaseName," Clicked on " + buttonName + ", button ");
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickButtonOfAssignedPolicyUserEditPage is : ",t);
						
					}
					return  clickButtonOfAssignedPolicyUserEditPage;
					
				} 
	 			
	 			//Function for checking Fields are available in Assigned Policy User Detail section based on user inputs..
				public static boolean checkingAssignedPolicyUserDetailSecFields(Browser browser,String inputFieldValues)
				{
					boolean checkingAssignedAccountUserDetailSecFields=false;
					try
					{
						
						boolean fnStatus=isElementExist(browser, sectionAssignedPolicyUserDetail);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Assigned Account User Detail Section is not available!!");	
						if(fnStatus==true)
						{
							fnStatus=validatingSectionfieldsAvailability(browser, inputFieldValues, sectionAssignedPolicyUserDetail);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Assigned Account User Detail Section fields are: "+inputFieldValues+"verified !!");
							
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for checkingAssignedAccountUserDetailSecFields is : ",t);
						
					}
				return checkingAssignedAccountUserDetailSecFields;
				}
				//Function for clicking Account Name field value in Assigned account User detail section..
				public static boolean clickingPolicyIdAssignedPolicyUserDetailPage(Browser browser,String fieldName)
				{
					boolean clickingAccountNameAssignedAccUserDetailPage=false;
					try
					{
						String sectionAssignedAccountUserDetail="//td[text()='Assigned Policy Name']/../../..//parent::table";/*"//h2[text()='Assigned Account User Detail']/../../../../..//parent::div[contains(@class,'bPageBlock')]";*/
						boolean fnStatus=isElementExist(browser, sectionAssignedAccountUserDetail);
								
						if(fnStatus==true)
						{
							String field=GenericClass.clickFieldValueOfSection(browser, fieldName, sectionAssignedAccountUserDetail);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Account Name as: "+field+"  In Assigned Account User Detail Section. !!");
								clickingAccountNameAssignedAccUserDetailPage=true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "Fail", "Failed to Click Account Name as: "+field+"  In Assigned Account User Detail Section. !!");
								clickingAccountNameAssignedAccUserDetailPage=true;
							}
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "Fail", "Assigned Account User Detail Section is not available.!!");
							errorCount++;
							clickingAccountNameAssignedAccUserDetailPage=true;
						}
						
							}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingAccountNameAssignedAccUserDetailPage is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingAccountNameAssignedAccUserDetailPage is : "+t.getMessage());
						softAssert.fail("The Exception for clickingAccountNameAssignedAccUserDetailPage is : "+t.getMessage());
						errorCount++;
						clickingAccountNameAssignedAccUserDetailPage=false;
					}
				return clickingAccountNameAssignedAccUserDetailPage;
				}
				
				/*//Function for clicking New Contract button in contract section..
				public static boolean clickingNewContractButton(Browser browser)
				{
					boolean clickingNewContractButton = false;
					try
					{
						boolean fnStatus = fnButtonClick(browser, btnNewContract);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "'New Contract' button Should be clicked successfully");
									clickingNewContractButton = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", " 'New Contract' button is not clicked ");
									errorCount++;
									clickingNewContractButton = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingNewContractButton is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingNewContractButton is : "+t.getMessage());
						softAssert.fail("The Exception for clickingNewContractButton is : "+t.getMessage());
						errorCount++;
						clickingNewContractButton = false;
					}
					return clickingNewContractButton;
				}*/
				//Function for confirming New Contract page navigation..
				public static boolean confirmingNewContractPageNavigation(Browser browser)
				{
					boolean confirmingNewContractPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtNewContractHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to 'New Contract' Page");
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingNewContractPageNavigation is : ",t);
					}
					return confirmingNewContractPageNavigation;
				}
				
				//Function to click on either Save Or Save & New Or Cancel button of "Contract Edit", Page based on the user inputs..
	 			public static boolean  clickButtonOfContractEditPage(Browser browser, String buttonName)
	 			{
					boolean clickButtonOfContractEditPage = false;
					try
					{
						boolean fnStatus = false;
						String buttonXpath = "//h2[text()='Contract Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
						fnStatus = isElementExist(browser, buttonXpath);
						if(fnStatus ==true)
						{
							fnStatus = fnButtonClick(browser, buttonXpath);
							if(fnStatus ==true)
							{
								ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on " + buttonName + ", button successfully.");
								clickButtonOfContractEditPage = true;
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
								softAssert.fail( "Failed to click on " + buttonName + ", button.");
								errorCount++;
								clickButtonOfContractEditPage = false;
							}
							
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
							softAssert.fail(buttonXpath + ", element is not available.");
							errorCount++;
							clickButtonOfContractEditPage = false;
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickButtonOfContractEditPage is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickButtonOfContractEditPage is : "+t.getMessage());
						softAssert.fail("The Exception for clickButtonOfContractEditPage is : "+t.getMessage());
						errorCount++;
						clickButtonOfContractEditPage = false;
					}
					return  clickButtonOfContractEditPage;
					
				} 
	 			//Function for checking Fields are available in Contract Edit Info screen section based on user inputs..
				public static boolean checkingContractInfoSecFields(Browser browser,String inputFieldValues)
				{
					boolean checkingContractInfoSecFields=false;
					try
					{
						boolean fnStatus=isElementExist(browser, sectionContractInfo);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Contract Edit Information Section AVAILABILITY " );
						
						if(fnStatus==true)
						{
							fnStatus=GenericClass.fieldAvailabilityValidation(browser, inputFieldValues, sectionContractInfo);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Contract Edit Information Section fields are: "+inputFieldValues+"Displayed " );
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for checkingContractInfoSecFields is :",t);
					}
				return checkingContractInfoSecFields;
				}

				//Function for Entering the Contract Number in Contract Edit screen..
				public static boolean enteringContactNumber(Browser browser,String contractLabel,String contractName)
				{
				boolean enteringContactNumber=false;
				try
				{
					boolean fnStatus=GenericClass.sendKeysToTextBoxByLabel(browser, contractLabel, contractName);
					 if(fnStatus==true)
					 {
						 ReportEvent.testStepReport(tTestCaseName, "Pass", "Entered Contract Number as: "+contractName+" successfully.");
						 enteringContactNumber=true;
					 }
					 else
					 {
						 ReportEvent.testStepReport(tTestCaseName, "FAIL", "Filed to enter Contract Number");
						 softAssert.fail("Filed to enter Contract Number");
						enteringContactNumber = false;
						 
					 }
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for enteringContactNumber is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for enteringContactNumber is : "+t.getMessage());
					softAssert.fail("The Exception for enteringContactNumber is : "+t.getMessage());
					errorCount++;
					enteringContactNumber=false;
				}
				return enteringContactNumber;
				}
				
				//Function for confirming Contract Detail page navigation..
				public static boolean confirmingContractDetailPageNavigation(Browser browser)
				{
					boolean confirmingContractDetailPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtContractDetailHeader);
								if(fnStatus ==true)
								{
									ReportEvent.testStepReport(tTestCaseName, "pass", "User navigated to 'Contract Detail' Page successfully!!");
									confirmingContractDetailPageNavigation = true;
								}
								else 
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to 'Contract Detail' Page");
									errorCount++;
									confirmingContractDetailPageNavigation = false;
								}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for confirmingContractDetailPageNavigation is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for confirmingContractDetailPageNavigation is : "+t.getMessage());
						softAssert.fail("The Exception for confirmingContractDetailPageNavigation is : "+t.getMessage());
						errorCount++;
						confirmingContractDetailPageNavigation = false;
						
					}
					return confirmingContractDetailPageNavigation;
				}
				
				//Function for checking Fields are available in Contract Detail section based on user inputs..
				public static boolean checkingContractDetailSecFields(Browser browser,String inputFieldValues)
				{
					boolean checkingContractDetailSecFields=false;
					try
					{
						String sectionAssignedAccountUserDetail="//h2[text()='Contract Detail']/../../../../..//parent::div[contains(@class,'bPageBlock')]";
						boolean fnStatus=isElementExist(browser, sectionAssignedAccountUserDetail);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability Contract Detail Section ");
						
						if(fnStatus==true)
						{
							fnStatus=validatingSectionfieldsAvailability(browser, inputFieldValues, sectionAssignedAccountUserDetail);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Contract Detail Section fields are: "+inputFieldValues+"verified !!");
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for checkingContractDetailSecFields is : ",t);
						
					}
				return checkingContractDetailSecFields;
				}
				
				/////////////23092017//////////
				
				//Function for clicking New Contract button in contract section..
				public static boolean clickingNewContractButton(Browser browser)
				{
					boolean clickingNewContractButton = false;
					try
					{
						boolean fnStatus =isElementExist(browser, sectionContract);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Contract Section is not Available.");
						if(fnStatus=true)
						{
								fnStatus=fnButtonClick(browser, btnNewContract);
								GenericClass.reportlogger(fnStatus,tTestCaseName,"'New Contract' button Should be clicked");
						}
						
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingNewContractButton is :",t);
					}
					return clickingNewContractButton;
				}
				
				//Function for verifying new policies is updated in policy relationship section..
				public static boolean verifyingNewPolicyInPolicyRelationshipSec(String testCaseName,Browser browser, String sectionName, String linkName, String inputValueLink)
				{
					boolean verifyingNewPolicyInPolicyRelationshipSec = false;
					try
					{
						boolean fnStatus = isElementExist(browser, sectionPolicyRelationship);
						GenericClass.reportlogger(fnStatus,testCaseName,"Availability of Policy Relationship Section is ");
						if(fnStatus=true)
						checkPolicyAvailabilityOfPolicyRelationshipsSection(browser, sectionName, linkName, inputValueLink);
			
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for verifyingNewPolicyInPolicyRelationshipSec is :",t);
					}
					return verifyingNewPolicyInPolicyRelationshipSec;
					
				}	
				
				//Function for verifying new policies is updated in Contract section..
				public static boolean verifyingNewContractInContractSec(Browser browser, String sectionName, String linkName, String inputValueLink)
				{
					boolean verifyingNewPolicyInContractSec = false;
					try
					{
						boolean fnStatus = isElementExist(browser, sectionContract);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of Contract Related Section ");
						
						if(fnStatus=true)
						checkContractAvailabilityOfContractSection(browser, sectionName, linkName, inputValueLink);
						/*String tableXpath = sectionContract.concat("//div[@class='pbBody']//table");
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
										if(cellText.getInnerText().equals(newPolicyId))
										{
											cellText.highlight();
											ReportEvent.testStepReport("", "PASS", "New Policy ID :"+cellText+" Updated in Contract Related Section successfully." );
											verifyingNewPolicyInContractSec = true;
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
							ReportEvent.testStepReport("", "Fail", "Contract Related dynamic table record are not available");
							errorCount++;
							verifyingNewPolicyInContractSec = false;
						
						}
						}
						else
						{
							
							ReportEvent.testStepReport("", "Fail", "Contract Related dynamic table is not available");
							errorCount++;
							verifyingNewPolicyInContractSec = false;
						}*/
						}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for verifyingNewPolicyInContractSec is : ",t);
						
					}
					return verifyingNewPolicyInContractSec;
					
				}	
			/*	
				//Function for clicking Action Type (Edit or Del) link in Assigned Account user section..
				public static boolean clickingActionTypeOfAssignedAccountUserSec(Browser browser, String assignAccName,String action)
					{
						
						boolean clickingActionTypeOfAssignedAccountUserSec = false;
						int j =0;
						try
						{
							boolean fnStatus = isElementExist(browser, sectionAssignedAccountUsers);
							if(fnStatus=true)
								{
							
							String tableXpath = sectionAssignedAccountUsers.concat("//div[@class='pbBody']//table");
							fnStatus = isElementExist(browser, tableXpath);
							if(fnStatus == true)
							{
								int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
								if(rowCount>1)
								{
								outerloop:
								for(int i=2; i<=rowCount; i++)
								{
									
									String aTagXPath = tableXpath+"//tr["+i+"]//a";
									Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
									
								for(Link atag : allLinks)
									{
										String atagText = atag.getInnerText();
										if(atagText.equals(assignAccName))
										{
											
											for(Link atagElement : allLinks)
											{
												String atagElementText = atagElement.getInnerText();
												if(atagElementText.equals(action))
												{
													String elementXpath = aTagXPath+"[text()='" + action + "']";	
													fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
													if(fnStatus==true)
													{
														ReportEvent.testStepReport("", "Pass", "Clicked on :"+atagElementText+" Link in Assigned Account User Section Succesfully.");
														clickingActionTypeOfAssignedAccountUserSec = true;
													}
													else
													{
														ReportEvent.testStepReport("", "fail", "Failed to click Assigned Account User action link.");
														errorCount++;
														clickingActionTypeOfAssignedAccountUserSec = false;	
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
								
								clickingActionTypeOfAssignedAccountUserSec = true;
								}
								else
								{
									ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table records are not available");
									errorCount++;
									clickingActionTypeOfAssignedAccountUserSec = false;
								
								}
							}
							else
							{
								
								ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table is not available");
								errorCount++;
								clickingActionTypeOfAssignedAccountUserSec = false;
							}
								}
							else
							{
								ReportEvent.testStepReport("", "PASS", "Assigned account user Section is not available");
								clickingActionTypeOfAssignedAccountUserSec = false;
							
							}
						}
						catch(Throwable t)
						{
							System.out.println("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							ReportEvent.testStepReport("", "fail", "The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							softAssert.fail("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							errorCount++;
							clickingActionTypeOfAssignedAccountUserSec = false;
						}
						return clickingActionTypeOfAssignedAccountUserSec;
					}
				*/
				
				//Function for clicking Action Type (Del) link in Assigned Account user section..
				public static boolean clickingActionLinkInAssignedAccountUserSec(String testCaseName,Browser browser,String action)
					{
						
						boolean clickingActionLinkInAssignedAccountUserSec = false;
						int j =0;
						try
						{
							boolean fnStatus = isElementExist(browser, sectionAssignedAccountUsers);
							if(fnStatus=true)
								{
							
							String tableXpath = sectionAssignedAccountUsers.concat("//div[@class='pbBody']//table");
							fnStatus = isElementExist(browser, tableXpath);
							if(fnStatus == true)
							{
								int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
								if(rowCount>1)
								{
								outerloop:
								for(int i=2; i<=rowCount; i++)
								{
									
									String aTagXPath = tableXpath+"//tr["+i+"]//a";
									Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
									
									for(Link atagElement : allLinks)
									{
										String atagElementText = atagElement.getInnerText();
										if(atagElementText.equals(action))
										{
											String elementXpath = aTagXPath+"[text()='" + action + "']";	
											fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
											if(fnStatus==true)
											{
												ReportEvent.testStepReport("", "Pass", "Clicked on :"+atagElementText+" Link in Assigned Account User Section Succesfully.");
												clickingActionLinkInAssignedAccountUserSec = true;
												break outerloop;
											}
											else
											{
												ReportEvent.testStepReport("", "Pass", "No Records to displayed in Assigned Account user section.");
												errorCount++;
												clickingActionLinkInAssignedAccountUserSec = false;	
											}
											
											/*break outerloop;*/
										}
										else
										{
											continue;
										
										}
										
									}
									
								}
								
								clickingActionLinkInAssignedAccountUserSec = true;
								}
								else
								{
									ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table records are not available");
									errorCount++;
									clickingActionLinkInAssignedAccountUserSec = false;
								
								}
							}
							else
							{
								
								ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table is not available");
								errorCount++;
								clickingActionLinkInAssignedAccountUserSec = false;
							}
								}
							else
							{
								ReportEvent.testStepReport("", "PASS", "Assigned account user Section is not available");
								clickingActionLinkInAssignedAccountUserSec = false;
							
							}
						}
						catch(Throwable t)
						{
							System.out.println("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							ReportEvent.testStepReport("", "fail", "The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							softAssert.fail("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							errorCount++;
							clickingActionLinkInAssignedAccountUserSec = false;
						}
						return clickingActionLinkInAssignedAccountUserSec;
					}
				
			
				//Function for Filling Assigned Account User Information section fields based on user inputs..
	 			
	 			public static boolean fillingAssignedAccountUserInfoFields(Browser browser,String claimAvailableValue,String claimAvailableValue2,String benefitType)
	 			{
	 				boolean fillingAssignedAccountUserInfoFields=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedAccountInfo);
	 					if(fnStatus==true)
	 					{
	 						//Selecting Available list box value in Claim complexity..
	 						String claimComplexityXpath=sectionAssignedAccountInfo.concat("//select[contains(@title,'Complexity Assignments - Available')]");
	 						fnStatus=fnListBox(browser, claimComplexityXpath, claimAvailableValue);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightClaim);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Claim Complexity Right arrow successfully!!");
	 							fillingAssignedAccountUserInfoFields=true;
	 						}
	 						fnStatus=fnListBox(browser, claimComplexityXpath, claimAvailableValue2);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightClaim);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Claim Complexity Right arrow successfully!!");
	 							fillingAssignedAccountUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Claim Complexity Right arrow");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 						
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Claim Complexity dropdown value");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Claim Complexity Assignments Available section is not available.");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 					
	 					//Selecting Available list box value in Benefit Type..
	 						String benefitTypeXpath=sectionAssignedAccountInfo.concat("//select[contains(@title,'Benefit Type Assignments - Available')]");
	 						fnStatus=fnListBox(browser, benefitTypeXpath, benefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, imgLinkRightBenefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Benefit Type Assignments Right arrow successfully!!");
	 							fillingAssignedAccountUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Benefit Type Assignments Right arrow");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Benefit Type Assignments dropdown value");
								errorCount++;
								fillingAssignedAccountUserInfoFields=false;
	 						}
	 					
	 						
	 					}
	 					else
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Assigned account user section is not available");
							errorCount++;
							fillingAssignedAccountUserInfoFields=false;
	 					}
	 					
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for fillingAssignedAccountUserInfoFields is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for fillingAssignedAccountUserInfoFields is : " + t.getMessage());
						softAssert.fail("The Exception for fillingAssignedAccountUserInfoFields is : " + t.getMessage());
						errorCount++;
	 					fillingAssignedAccountUserInfoFields=false;
	 				}
	 				return fillingAssignedAccountUserInfoFields;
	 			}
				//Function for checking selected values in Choosen list box under assigned account user section..
	 			public static boolean checkingDropDownValuesAssignentAccountUserSec(Browser browser, String listBoxXpath,String inputValues)
	 			{
	 				
	 				boolean checkingDropDownValuesAssignentAccountUserSec = false;
	 				int matchedvalueCounter =0;
	 				try
	 				{
	 					String inputValArray[] =inputValues.split(",");
	 					List<String> inputValueList = Arrays.asList(inputValArray);
	 					String claimComplexityXpath=sectionAssignedAccountInfo.concat(listBoxXpath);
	 					outerloop:
	 					for(int level =1;level<=6;level++)
	 					{
	 					
	 						ListBox listItems=browser.describe(ListBox.class, new XPathDescription(claimComplexityXpath));
 							List<ListItem> allOptions = listItems.getItems();
 							for(ListItem allValues:allOptions)
 							{
 								for(String inputValue : inputValueList)
 								{
 									if(allValues.getText().equalsIgnoreCase(inputValue))
 									{
 										matchedvalueCounter++;
 									}
 									else
 									{
 										continue;
 									}
 								}
 							}
 							if(matchedvalueCounter==inputValueList.size())
 							{
 								checkingDropDownValuesAssignentAccountUserSec=true;
 								break outerloop;
 							}
 							else
 							{
 								checkingDropDownValuesAssignentAccountUserSec=false;
 							}
	 						
	 						
	 					}
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for checkingDropDownValuesAssignentAccountUserSec is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for checkingDropDownValuesAssignentAccountUserSec is : " + t.getMessage());
						softAssert.fail("The Exception for checkingDropDownValuesAssignentAccountUserSec is : " + t.getMessage());
						errorCount++;
						checkingDropDownValuesAssignentAccountUserSec=false;
	 				}
	 				return checkingDropDownValuesAssignentAccountUserSec;
	 			}
	 				 
	 			//Function for validating the Dropdown values in Assigned account user section based on user inputs..
	 			public static boolean verifyingChosenListBoxValuesInClaimComplexity(Browser browser,String inputValues )
	 			{
	 				boolean verifyingChosenListBoxValuesInClaimComplexity=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedAccountInfo);
	 					GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of Assigned account user section ");
	 					if(fnStatus==true)
	 					{
	 						fnStatus=checkingDropDownValuesAssignentAccountUserSec(browser, lstClaimComplexityChoosen, inputValues);
	 						GenericClass.reportlogger(fnStatus,tTestCaseName,"Verified Chosen ListBox values as:"+inputValues+", Under claim Complexity Type.");
	 						
	 					}
	 					}
	 				catch(Throwable t)
	 				{
	 					GenericClass.Catchhandler("The Exception for verifyingChosenListBoxValuesInClaimComplexity is :",t);
	 				}
	 				return verifyingChosenListBoxValuesInClaimComplexity;
	 			}
	 			
	 			public static boolean verifyingChosenValuesInBenefitType(Browser browser,String inputValues )
	 			{
	 				boolean verifyingChosenValuesInBenefitType=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedAccountInfo);
	 					GenericClass.reportlogger(fnStatus,tTestCaseName,"Assigned Policy user section availablility ");
	 					if(fnStatus==true)
	 					{
	 						fnStatus=checkingDropDownValuesAssignentAccountUserSec(browser, lstBenefitTypeChoosen, inputValues);
	 						GenericClass.reportlogger(fnStatus,tTestCaseName,"Verified Benefit Type Assignments Chosen ListBox values as:"+inputValues+".");
	 						
	 					}
	 				}
	 				catch(Throwable t)
	 				{
	 					GenericClass.Catchhandler("The Exception for verifyingChosenValuesInBenefitType is : ",t);
	 					
	 				}
	 				return verifyingChosenValuesInBenefitType;
	 			}
	 		
	 			//Function for confirming Assigned Accounts user page navigation..
				public static boolean confirmingAssignedAccountUserPageNavigation(Browser browser)
				{
					boolean confirmingAssignedAccountUserPageNavigation = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtAssignedAccountUserHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName, "navigate to Assigned Accounts User Page");
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingAssignedAccountUserPageNavigation is : ",t);
					}
					return confirmingAssignedAccountUserPageNavigation;
				}
				
					//Function for clicking account name  Assigned Account User Detail screen..
				public static boolean clickingAccountNameAssignedAccUserDetailsSec(Browser browser,String accountField,String userNameField)
				{
					boolean clickingAccountNameAssignedAccUserDetailsSec=false;
					try
					{
						boolean fnStatus=false;
						
						GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, accountField, sectionAssignedAccountUserDetail);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Account Field value Should be clicked successfully!!");
							clickingAccountNameAssignedAccUserDetailsSec = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to verify click account field value.");
							errorCount++;
							clickingAccountNameAssignedAccUserDetailsSec = false;
						}
						
						}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingAccountNameAssignedAccUserDetailsSec is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingAccountNameAssignedAccUserDetailsSec is : "+t.getMessage());
						softAssert.fail("The Exception for clickingAccountNameAssignedAccUserDetailsSec is : "+t.getMessage());
						errorCount++;
						clickingAccountNameAssignedAccUserDetailsSec=false;
					
					}
					return clickingAccountNameAssignedAccUserDetailsSec;
				}

				
				//Function for checking field values in Assigned Account User Detail screen..
				public static boolean CheckingAssignAccUserDetailSecFieldValues(Browser browser,String accountField,String userNameField)
				{
					boolean CheckingAssignAccUserDetailSecFieldValues=false;
					try
					{
						boolean fnStatus=false;
						//
						String fieldValue=GenericClass.getFieldValueOfSection(browser, accountField, sectionAssignedAccountUserDetail);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Acconut Field value as : "+fieldValue+" should be Verified!!");
							CheckingAssignAccUserDetailSecFieldValues = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to verify Acconut Field value value.");
							errorCount++;
							CheckingAssignAccUserDetailSecFieldValues = false;
						}
						
						String userName=GenericClass.getFieldValueOfSection(browser, userNameField, sectionAssignedAccountUserDetail);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(tTestCaseName, "pass", "Decision Reason Field value: "+userName+" should be Verified!!");
							CheckingAssignAccUserDetailSecFieldValues = true;
						}
						else 
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "User Name Field Value as:  " + fieldValue +" ,Claim handler.");
							errorCount++;
							CheckingAssignAccUserDetailSecFieldValues = false;
						}
						
						}
					catch(Throwable t)
					{
						System.out.println("The Exception for CheckingAssignAccUserDetailSecFieldValues is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for CheckingAssignAccUserDetailSecFieldValues is : "+t.getMessage());
						softAssert.fail("The Exception for CheckingAssignAccUserDetailSecFieldValues is : "+t.getMessage());
						errorCount++;
						CheckingAssignAccUserDetailSecFieldValues=false;
					
					}
					return CheckingAssignAccUserDetailSecFieldValues;
				}
				
				
				//Clicking on Policy related link of Policy relationship section.. 
				public static boolean clickingLinkOfPolicyRelationship(Browser browser, String policyID)
				{
					boolean clickingLinkOfPolicyRelationship = false;
					try
					{
						boolean fnStatus = false;
						fnStatus=isElementExist(browser, sectionPolicyRelationship);
						if(fnStatus=true)
						{
						String tableXpath = sectionPolicyRelationship.concat("//div[@class='pbBody']//table");
						fnStatus = isElementExist(browser, tableXpath);
						if(fnStatus == true)
						{
							int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
							if(rowCount>1)
							{
							outerloop:
							for(int i=2; i<=rowCount; i++)
							{
								String aTagXpath = tableXpath.concat("//th/a");
								Link[] aTags=browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXpath).build());
								
								for (Link cell : aTags)
								{
									System.out.println(cell.getInnerText());
										if(cell.getInnerText().equals(policyID))
										{
											cell.highlight();
											cell.click();
											ReportEvent.testStepReport(tTestCaseName, "pass", "Policy Id: "+cell+" should be Clicked successfully!!");
											clickingLinkOfPolicyRelationship = true;
											break outerloop;
										}
										else
										{
											continue;
										}
								}
							}
							
							clickingLinkOfPolicyRelationship = true;
						}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Policy Relationship dynamic table records are not available");
								errorCount++;
								clickingLinkOfPolicyRelationship = false;
							
							}
						}
						
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Policy Relationship dynamic table is not available");
							errorCount++;
							clickingLinkOfPolicyRelationship = false;
						}
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Policy Relationship Section is not available");
							errorCount++;
							clickingLinkOfPolicyRelationship = false;
						
						}
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
						softAssert.fail("The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
						errorCount++;
						clickingLinkOfPolicyRelationship = false;
					}
					return clickingLinkOfPolicyRelationship;
					
				}

				//Function for clicking New Assigned Policy User Button..
				public static boolean clickingNewAssignedPolicyUserButton(Browser browser)
				{
					boolean clickingNewAssignedPolicyUserButton = false;
					try
					{
						boolean fnStatus =isElementExist(browser, sectionAssignedPolicyUsers);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of ew Assigned Policy User section ");
						if(fnStatus==true)
						{
							fnButtonClick(browser, btnNewAssignedPolicyUsers);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"New Assigned Policy User' button Should be clicked");
							
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingNewAssignedPolicyUserButton is :",t);
						
					}
					return clickingNewAssignedPolicyUserButton;
				}
				
				//Function for Filling Assigned Policy User Information section fields based on user inputs..
	 			
	 			public static boolean fillingAssignedPolicyUserInfoFields(Browser browser,String claimAvailableValue,String claimAvailableValue2,String benefitType)
	 			{
	 				boolean fillingAssignedPolicyUserInfoFields=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedPolicyInfo);
	 					if(fnStatus==true)
	 					{
	 						//Selecting Available list box value in Claim complexity..
	 						String claimComplexityXpath=sectionAssignedPolicyInfo.concat("//select[contains(@title,'Complexity Assignments - Available')]");
	 						fnStatus=fnListBox(browser, claimComplexityXpath, claimAvailableValue);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, linkClaimNavigationBtn);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Claim Complexity Right arrow successfully!!");
	 							fillingAssignedPolicyUserInfoFields=true;
	 						}
	 						fnStatus=fnListBox(browser, claimComplexityXpath, claimAvailableValue2);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, linkClaimNavigationBtn);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Claim Complexity Right arrow successfully!!");
	 							fillingAssignedPolicyUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Claim Complexity Right arrow");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Claim Complexity dropdown value");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 					//Selecting Available list box value in Benefit Type..
	 						String benefitTypeXpath=sectionAssignedPolicyInfo.concat("//select[contains(@title,'Benefit Type Assignments - Available')]");
	 						fnStatus=fnListBox(browser, benefitTypeXpath, benefitType);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Selected Benefit Type Assignments List box value successfully!!");
	 							fnStatus=GenericClass.fnImageLinkOrButtonClick(browser, linkBenefitNavigationBtn);
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked Benefit Type Assignments Right arrow successfully!!");
	 							fillingAssignedPolicyUserInfoFields=true;
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click Benefit Type Assignments Right arrow");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Available Benefit Type Assignments dropdown value");
								errorCount++;
								fillingAssignedPolicyUserInfoFields=false;
	 						}
	 					
	 						
	 					}
	 					else
	 					{
	 						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Assigned Policy user section is not available");
							errorCount++;
							fillingAssignedPolicyUserInfoFields=false;
	 					}
	 					
	 					
	 				}
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for fillingAssignedPolicyUserInfoFields is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for fillingAssignedPolicyUserInfoFields is : "+t.getMessage());
						softAssert.fail("The Exception for fillingAssignedPolicyUserInfoFields is : "+t.getMessage());
						errorCount++;
	 					fillingAssignedPolicyUserInfoFields=false;
	 				}
	 				return fillingAssignedPolicyUserInfoFields;
	 			}
	 			
	 			//Function for checking selected values in Choosen list box under assigned account user section..
	 			public static boolean checkingDropDownValuesAssignedPolicyUserSec(Browser browser, String listBoxXpath,String inputValues)
	 			{
	 				
	 				boolean checkingDropDownValuesAssignedPolicyUserSec = false;
	 				int matchedvalueCounter =0;
	 				try
	 				{
	 					String inputValArray[] =inputValues.split(",");
	 					List<String> inputValueList = Arrays.asList(inputValArray);
	 					String claimComplexityXpath=sectionAssignedPolicyInfo.concat(listBoxXpath);
	 					outerloop:
	 					for(int level =1;level<=6;level++)
	 					{
	 					
	 						ListBox listItems=browser.describe(ListBox.class, new XPathDescription(claimComplexityXpath));
 							List<ListItem> allOptions = listItems.getItems();
 							for(ListItem allValues:allOptions)
 							{
 								for(String inputValue : inputValueList)
 								{
 									if(allValues.getText().equalsIgnoreCase(inputValue))
 									{
 										matchedvalueCounter++;
 									}
 									else
 									{
 										continue;
 									}
 								}
 							}
 							if(matchedvalueCounter==inputValueList.size())
 							{
 								checkingDropDownValuesAssignedPolicyUserSec=true;
 								break outerloop;
 							}
 							else
 							{
 								checkingDropDownValuesAssignedPolicyUserSec=false;
 							}
	 						
	 						
	 					}
	 					
	 				}
	 				catch(Throwable t)
	 				{
	 					System.out.println("The Exception for checkingDropDownValuesAssignedPolicyUserSec is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for checkingDropDownValuesAssignedPolicyUserSec is : " + t.getMessage());
						softAssert.fail("The Exception for checkingDropDownValuesAssignedPolicyUserSec is : " + t.getMessage());
						errorCount++;
						checkingDropDownValuesAssignedPolicyUserSec=false;
	 				}
	 				return checkingDropDownValuesAssignedPolicyUserSec;
	 			}
	 				 
	 			//Function for validating the Dropdown values in Assigned Policy user edit page under Claim Complexity Assignments Chosen ListBox..
	 			public static boolean verifyingChosenListBoxValuesInClaim(Browser browser,String inputValues )
	 			{
	 				boolean verifyingChosenListBoxValuesInClaim=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedPolicyInfo);
	 					GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of Assigned Policy user section ");
	 					if(fnStatus==true)
	 					{
	 						fnStatus=checkingDropDownValuesAssignedPolicyUserSec(browser, lstClaimComplexityChoosen, inputValues);
	 						GenericClass.reportlogger(fnStatus,tTestCaseName,"Verified Claim Complexity Assignments Chosen ListBox values as:"+inputValues+".");
	 						
	 					}
	 				}
	 				catch(Throwable t)
	 				{
	 					GenericClass.Catchhandler("The Exception for verifyingChosenListBoxValuesInClaim is :",t);
	 				}
	 				return verifyingChosenListBoxValuesInClaim;
	 			}
	 			
	 			//Function for validating the Dropdown values in Assigned Policy user edit page under Benefit Type Assignments chosen list box..
	 			public static boolean verifyingChosenListBoxValuesInBenefitType(Browser browser,String inputValues )
	 			{
	 				boolean verifyingChosenListBoxValuesInBenefitType=false;
	 				try
	 				{
	 					boolean fnStatus=isElementExist(browser, sectionAssignedPolicyInfo);
	 					GenericClass.reportlogger(fnStatus,tTestCaseName,"Availability of Assigned Policy user section ");
	 					if(fnStatus==true)
	 					{
	 						fnStatus=checkingDropDownValuesAssignedPolicyUserSec(browser, lstBenefitTypeChoosen, inputValues);
	 						GenericClass.reportlogger(fnStatus,tTestCaseName,"Verified Benefit Type Assignments Chosen ListBox values as:"+inputValues+".");
	 						
	 					}
	 				}
	 				catch(Throwable t)
	 				{
	 					GenericClass.Catchhandler("The Exception for verifyingChosenListBoxValuesInBenefitType is : ",t);
	 				}
	 				return verifyingChosenListBoxValuesInBenefitType;
	 			}
	 		
	 			//Function for clicking New Contact Button in Accounts details section....
				public static boolean clickingNewContactButton(Browser browser,
						String frameTitle, String frameTag, String frameId, String buttonName)
				{
					boolean clickingNewContactButton = false;
					try
					{
						boolean fnStatus = false;
						fnStatus = GenericClass.clickButtonInFrame(browser, frameTitle, frameTag, frameId, buttonName);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"click on' "+buttonName+" ', button.");
											
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickingNewContactButton is :",t);
						
					}
					return clickingNewContactButton;
				}
				
				
//Today's task --23-09..
				
				//Function to click on policy link of table of Policy Relationship section by checking availability of Go to list or Show more links.
				
				public static void clickPolicyLinkOfPolicyRelationshipsSection(Browser browser, String sectionName,
						String linkName, String inputValueLink)
				{
					try
					{
						boolean fnStatus = false;
						fnStatus =  GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Clicked on :"+inputValueLink);
						if(fnStatus ==true)
						{
							fnStatus = GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Clicked on :"+linkName);
							if(fnStatus ==true)
							{
								fnStatus =  GenericClass.clickingLinkOfSection(browser, sectionPolicyRelationship, inputValueLink);
								GenericClass.reportlogger(fnStatus,tTestCaseName,"Clicked on :"+inputValueLink);
								
							}
							
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for clickPolicyLinkOfPolicyRelationshipsSection is :",t);
					}
					
					
				}
				
				//Function for confirming Assigned POlicy user details page navigation..
				public static boolean confirmingAssignedPolicyUserDetailPage(Browser browser)
				{
					boolean confirmingAssignedPolicyUserDetailPage = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtAssignedAccountUserHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"User navigated to Assigned Policy User Detail Pag");		
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingAssignedPolicyUserDetailPage is :",t);
					}
					return confirmingAssignedPolicyUserDetailPage;
				}
				

				
				
				
				//Today's task --26092017
				
				public static void checkPolicyAvailabilityOfPolicyRelationshipsSection(Browser browser, String sectionName,
						String linkName, String inputValueLink)
				{
					try
					{
						boolean fnStatus = false;
						fnStatus =  GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
						if(fnStatus ==true)
						{
							fnStatus = GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
							if(fnStatus ==true)
							{
								
								fnStatus =  GenericClass.checkColumnValueAvailabilityOfSection(browser, sectionPolicyRelationship, inputValueLink);
								if(fnStatus ==true)
								{
									System.out.println(inputValueLink+ " is available as expected .");
									ReportEvent.testStepReport("", "Pass", inputValueLink+ " is available as expected in "+sectionName +" section.");
								}
								else
								{
									System.out.println(inputValueLink+ " is available as expected.");
									ReportEvent.testStepReport("", "Fail", inputValueLink+ " is NOT available.");
									
								}
							}
							else
							{
								System.out.println("Failed to click on :"+linkName);
								ReportEvent.testStepReport("", "Fail", "Failed to click on :"+linkName);
								
							}
						}
						
						else
						{
							fnStatus =  GenericClass.checkColumnValueAvailabilityOfSection(browser, sectionPolicyRelationship, inputValueLink);
							if(fnStatus ==true)
							{
								System.out.println(inputValueLink+ " is available as expected.");
								ReportEvent.testStepReport("", "Pass", inputValueLink+ " is available as expected.");
							}
							else
							{
								System.out.println(inputValueLink+ " is available as expected.");
								ReportEvent.testStepReport("", "Fail", inputValueLink+ " is NOT available.");
								/*System.out.println("Failed to click on :"+inputValueLink);*/
							}
						}
						
						
						
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for checkPolicyAvailabilityOfPolicyRelationshipsSection is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for checkPolicyAvailabilityOfPolicyRelationshipsSection is : "+t.getMessage());
						softAssert.fail("The Exception for checkPolicyAvailabilityOfPolicyRelationshipsSection is : "+t.getMessage());
						errorCount++;
						System.out.println(t.getMessage());
					}
					
					
				}
				

				

				
				public static void checkContractAvailabilityOfContractSection(Browser browser, String sectionName,
						String linkName, String inputValueLink)
				{
					try
					{
						boolean fnStatus = false;
						fnStatus =  GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
						if(fnStatus ==true)
						{
							fnStatus = GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
							if(fnStatus ==true)
							{
								
								fnStatus =  GenericClass.checkColumnValueAvailabilityOfSection(browser, sectionContract, inputValueLink);
								if(fnStatus ==true)
								{
									System.out.println("Clicked on :"+inputValueLink+ " successfully.");
									ReportEvent.testStepReport("", "PASS", inputValueLink+ " is available as expected in "+sectionName +" section.");
									
									
								}
								else
								{
									System.out.println("Failed to click on :"+inputValueLink);
									ReportEvent.testStepReport("", "Fail", inputValueLink+ " is NOT available.");
								}
							}
							else
							{
								System.out.println("Failed to click on :"+linkName);
								ReportEvent.testStepReport("", "Fail", "Failed to click on :"+linkName);
							}
						}
						
						else
						{
							fnStatus = GenericClass.checkColumnValueAvailabilityOfSection(browser, sectionContract, inputValueLink);
							if(fnStatus ==true)
							{
								System.out.println("Clicked on :"+inputValueLink+ " successfully.");
								ReportEvent.testStepReport("", "PASS", inputValueLink+ " is available as expected.");
								
								
							}
							else
							{
								System.out.println("Failed to click on :"+inputValueLink);
								ReportEvent.testStepReport("", "Fail", inputValueLink+ " is NOT available.");
							}
						}
						
						
						
					}
					catch(Throwable t)
					{
						System.out.println("The Exception for checkContractAvailabilityOfContractSection is : "+t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for checkContractAvailabilityOfContractSection is : "+t.getMessage());
						softAssert.fail("The Exception for checkContractAvailabilityOfContractSection is : "+t.getMessage());
						errorCount++;
						System.out.println(t.getMessage());
					}
					
					
				}
				

				
				
				
				
				//Function for clicking Action Type (Del) link in Assigned Account user section..
				public static boolean clickingActionLinkInAssignedAccountSection(String testCaseName,Browser browser,String action)
					{
						boolean clickingActionLinkInAssignedAccountUserSec = false;
						int j =0;
						try
						{
							boolean fnStatus = isElementExist(browser, sectionAssignedAccountUsers);
							if(fnStatus=true)
								{
							
							String tableXpath = sectionAssignedAccountUsers.concat("//div[@class='pbBody']//table");
							fnStatus = isElementExist(browser, tableXpath);
							if(fnStatus == true)
							{
								int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
								if(rowCount>1)
								{
								outerloop:
								for(int i=2; i<=rowCount; i++)
								{
									
									String aTagXPath = tableXpath+"//tr["+i+"]//a";
									Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
									
									for(Link atagElement : allLinks)
									{
										String atagElementText = atagElement.getInnerText();
										if(atagElementText.equals(action))
										{
											String elementXpath = aTagXPath+"[text()='" + action + "']";	
											fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
											if(fnStatus==true)
											{
												ReportEvent.testStepReport("", "Pass", "Clicked on :"+atagElementText+" Link in Assigned Account User Section Succesfully.");
												clickingActionLinkInAssignedAccountUserSec = true;
												break outerloop;
											}
											else
											{
												ReportEvent.testStepReport("", "Pass", "No Records to displayed in Assigned Account user section.");
												errorCount++;
												clickingActionLinkInAssignedAccountUserSec = false;	
											}
											
										
										}
										else
										{
											continue;
										
										}
										
									}
									
								}
								
								clickingActionLinkInAssignedAccountUserSec = true;
								}
								else
								{
									ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table records are not available");
									errorCount++;
									clickingActionLinkInAssignedAccountUserSec = false;
								
								}
							}
							else
							{
								
								ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table is not available");
								errorCount++;
								clickingActionLinkInAssignedAccountUserSec = false;
							}
								}
							else
							{
								ReportEvent.testStepReport("", "PASS", "Assigned account user Section is not available");
								clickingActionLinkInAssignedAccountUserSec = false;
							
							}
						}
						catch(Throwable t)
						{
							System.out.println("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							ReportEvent.testStepReport("", "fail", "The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							softAssert.fail("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							errorCount++;
							clickingActionLinkInAssignedAccountUserSec = false;
						}
						return clickingActionLinkInAssignedAccountUserSec;
					}
				
			
				
				
				
				//Function for clicking Action Type (Del) link in Assigned Account user section..
				public static boolean recursiveDeletionOfRecordsAssignedAccountSection(String testCaseName,Browser browser,String action, String popUpWindowTitle,
						String inputTextMessage, String buttonName)
					{
						boolean clickingActionLinkInAssignedAccountUserSec = false;
						int j =0;
						try
						{
							boolean fnStatus = false;
							String secXpath = sectionAssignedAccountUsers;
							WebElement sectionObj = browser.describe(WebElement.class, new XPathDescription(secXpath));
							fnStatus =sectionObj.exists();
							if(fnStatus=true)
								{
							
							String tableXpath = sectionAssignedAccountUsers.concat("//div[@class='pbBody']//table");
							fnStatus = isElementExist(browser, tableXpath);
							if(fnStatus == true)
							{
								int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
					
			mainLoop : 		while(rowCount!=1)
								{
									outerloop:
										for(int i=2; i<=rowCount; i++)
										{	
											String aTagXPath = tableXpath+"//tr["+i+"]//a";
											Link[] allLinks = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXPath).build());
											
											for(Link atagElement : allLinks)
											{
												String atagElementText = atagElement.getInnerText();
												if(atagElementText.equals(action))
												{
													String elementXpath = aTagXPath+"[text()='" + action + "']";	
													fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
													if(fnStatus==true)
													{
														ReportEvent.testStepReport("", "Pass", "Clicked on :"+atagElementText+" Link in Assigned Account User Section Succesfully.");
														
														UpDateUser_CV.popUpMessageValidation(testCaseName, browser, popUpWindowTitle, inputTextMessage);
													BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(testCaseName,browser, popUpWindowTitle, buttonName);
														if(fnStatus==true)
														{
															clickingActionLinkInAssignedAccountUserSec = true;
															System.out.println("Clicked on OK button.");
															break outerloop;
														}
														else
														{
															System.out.println("Failed to click on OK button.");
															clickingActionLinkInAssignedAccountUserSec = false;
														}
															
													}
													else
													{
														ReportEvent.testStepReport("", "Fail", "No Records to displayed in Assigned Account user section.");
														errorCount++;
														clickingActionLinkInAssignedAccountUserSec = false;	
													}
													
												
												}
												else
												{
													continue;
												
												}
												
											}
											
										
										}
								 rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
								 if(rowCount>1)
								 {
									 continue;
								 }
								 else
								 {
									 break mainLoop;
									 
								 }
								}
								
								/*
								if(rowCount==1)
								{
									
								}
								else
								{
									
								}*/
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								if(rowCount>1)
								{
								
								
								clickingActionLinkInAssignedAccountUserSec = true;
								}
								else
								{
									ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table records are not available");
									errorCount++;
									clickingActionLinkInAssignedAccountUserSec = false;
								
								}
							}
							else
							{
								
								ReportEvent.testStepReport("", "fail", "Assigned Account User dynamic table is not available");
								errorCount++;
								clickingActionLinkInAssignedAccountUserSec = false;
							}
								}
							else
							{
								ReportEvent.testStepReport("", "PASS", "Assigned account user Section is not available");
								clickingActionLinkInAssignedAccountUserSec = false;
							
							}
						}
						catch(Throwable t)
						{
							System.out.println("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							ReportEvent.testStepReport("", "fail", "The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							softAssert.fail("The Exception for clickingActionTypeOfAssignedAccountUserSec is : " + t.getMessage());
							errorCount++;
							clickingActionLinkInAssignedAccountUserSec = false;
						}
						return clickingActionLinkInAssignedAccountUserSec;
					}
				
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				//Function for verifying new policies is updated in policy relationship section..
				public static boolean verifyingCVHndlrInAssignAccUserSec(String testCaseName,Browser browser, String sectionName, String linkName, String inputValueLink)
				{
					boolean verifyingCVHndlrInAssignAccUserSec = false;
					try
					{
						boolean fnStatus = isElementExist(browser, sectionAssignedAccountUsers);
						GenericClass.reportlogger(fnStatus,testCaseName,"Availability of Policy Relationship Section ");
						
						if(fnStatus=true)
							checkUsrNameAvailabilityinAssignAccUserSection(browser, sectionName, linkName, inputValueLink);
						
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for verifyingCVHndlrInAssignAccUserSec is : ",t);
						
					}
					return verifyingCVHndlrInAssignAccUserSec;
					
				}	
				
				
				
				
				
				

				public static void checkUsrNameAvailabilityinAssignAccUserSection(Browser browser, String sectionName,
						String linkName, String inputValueLink)
				{
					try
					{
						boolean fnStatus = false;
						fnStatus =  GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
						if(fnStatus ==true)
						{
							fnStatus = GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Click on show more section ");
							if(fnStatus ==true)
							{
								
								fnStatus =  GenericClass.checkColumnValueAvailabilityOfSection(browser, sectionAssignedAccountUsers, inputValueLink);
								GenericClass.reportlogger(fnStatus,tTestCaseName,inputValueLink+" is available as expected in "+sectionName +" section.");
							}
							
						}
						
						else
						{
							fnStatus =  GenericClass.checkColumnValueAvailabilityOfSection(browser, sectionAssignedAccountUsers, inputValueLink);
							GenericClass.reportlogger(fnStatus,tTestCaseName,inputValueLink+" is available as expected.");
							
						}
						}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for checkPolicyAvailabilityOfPolicyRelationshipsSection is : ",t);
						
					}
					
					
				}
				

				
				
				
				

}