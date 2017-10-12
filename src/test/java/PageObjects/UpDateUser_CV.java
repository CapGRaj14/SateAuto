package PageObjects;

import java.util.List;




import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.Frame;
import com.hp.lft.sdk.web.FrameDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.Page;
import com.hp.lft.sdk.web.PageDescription;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableDescription;
import com.hp.lft.sdk.web.TableRow;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

public class UpDateUser_CV extends DriverScript {
	
	public static final String txtUpdateEditUserHeader="//h1[text()='Edit User']";
	public static final String sectionSearchCriteria="//h3[text()='Search Criteria']/../..";
	public static final String tblSearchResults="//div[text()='Select']/../../..//parent::table";
	public static final String txtUpdateUserHeader="//h2[text()='Update User']";
	public static final String txtUpdatedMessage="//div[@role='alert']//div[@class='messageText'] ";
	public static final String sectionUpdateUser="//h3[text()='Update User']/../..";
	public static final String sectionAssignedAccountInfo="//h3[text() ='Information']/../..";
	public static final String buttonxpath1 = "//h2[text()='Search Users']/../../../../..//parent::div[@class='pbHeader']//input[@type='submit' and @value ='";
	public static final String buttonxpath2 = "']"; 
	
	// Function for confirming the display of Edit User Page.
		public static void confirmingEditUserPage(String testCaseName,Browser browser) {
			try {
				boolean fnStatus = isElementExist(browser, txtUpdateEditUserHeader);
					GenericClass.reportlogger(fnStatus,testCaseName,"Navigated to Edit User page ");	
				} 
			catch (Throwable t)
			{
				GenericClass.Catchhandler("The Exception for confirmingEditUserPage",t);
			}
		}
		
		//Function to click on either Search or Clear or Next button of "Search Results page" based on the user inputs..
			public static void  clickButtonOfSearchResultsPage(String testCaseName,Browser browser, String buttonName){
			try{
				boolean fnStatus = false;
				fnStatus = isElementExist(browser, buttonxpath1+buttonName+buttonxpath2);
				GenericClass.reportlogger(fnStatus,testCaseName, buttonxpath1+buttonName+buttonxpath2+" : Xpath is ");
				fnStatus = fnButtonClick(browser, buttonxpath1+buttonName+buttonxpath2);
				
				GenericClass.reportlogger(fnStatus,testCaseName,"Clicked on :" + buttonName + ", button.");
			
			}catch(Throwable t){
				GenericClass.Catchhandler("The Exception for clickButtonOfSearchResultsPage  is : ",t);
			}
		}
			
			
			
			
			//Selecting Search Criteria Name in a frame..
			public static boolean enteringName(Browser browser, String nameValue)
			{
				
				
				boolean selectingNameFromSearchCreteriaWindowFrame= false;
				
				try
				{
					String nameTextBoxXpath=sectionSearchCriteria.concat("//input[@name='j_id0:mainForm:j_id3:j_id31:j_id32:j_id34']");
					//String nameImgXpath="//input[contains(@name,'j_id0:mainForm:j_id3:j_id31:j_id32:j_id34')]/../..//img[@class='lookupIcon']";
					boolean fnStatus = false;
					fnStatus =fnEditFieldTextEntry(browser, nameTextBoxXpath,nameValue );
					
					if(fnStatus == true)
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Selected Search Criteria Name as :"+ nameValue);
						selectingNameFromSearchCreteriaWindowFrame = true;
						
					}
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Search Criteria Name as :"+ nameValue);
						errorCount++;
						selectingNameFromSearchCreteriaWindowFrame = false;
					}
					
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for selectingNameFromSearchCreteriaWindowFrame is : "+t.getMessage());
					//Utility.fnLogging("The Exception for selectingAdditionalReportsToContactFromWindowFrame is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for selectingNameFromSearchCreteriaWindowFrame is : "+t.getMessage());
					softAssert.fail("The Exception for selectingNameFromSearchCreteriaWindowFrame is : "+t.getMessage());
					errorCount++;
					selectingNameFromSearchCreteriaWindowFrame = false;
				}
					return selectingNameFromSearchCreteriaWindowFrame;
			}	
			
			//Function to click on either Previous or Update button of "Edit user page" based on the user inputs..
			public static boolean  clickButtonOfEditUserPage(Browser browser, String buttonName)
			{
			boolean clickButtonOfSearchResultsPage = false;
			try
			{
				boolean fnStatus = false;
				String buttonXpath = "//h2[text()='Edit User']/../../../../..//parent::div[@class='pbHeader']//input[@type='submit' and @value ='" + buttonName + "']";                    
				fnStatus = isElementExist(browser, buttonXpath);
				if(fnStatus ==true)
				{
					fnStatus = fnButtonClick(browser, buttonXpath);
					if(fnStatus ==true)
					{
						clickButtonOfSearchResultsPage = true;
					}
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
						softAssert.fail( "Failed to click on " + buttonName + ", button.");
						errorCount++;
						clickButtonOfSearchResultsPage = false;
					}
					
				}
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
					softAssert.fail(buttonXpath + ", element is not available.");
					errorCount++;
					clickButtonOfSearchResultsPage = false;
				}
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for clickButtonOfSearchResultsPage  is : " + t.getMessage());
				utility.fnLogging("The Exception for clickButtonOfSearchResultsPage  is : " + t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickButtonOfSearchResultsPage  is : " + t.getMessage());
				softAssert.fail("The Exception for clickButtonOfSearchResultsPage is : "+t.getMessage());
				errorCount++;
				clickButtonOfSearchResultsPage = false;
			}
			return  clickButtonOfSearchResultsPage;
			
		}
			
			//////////////// 05 082017////////////
			
			//Selecting Search Criteria Approver For Approvals in a frame..
			public static boolean selectingApproverForApprovalNameSearchCreteria(Browser browser, String approvalValue)
			{
				
				
				boolean selectingApproverForApprovalNameSearchCreteria= false;
				
				try
				{
					String approvalTextBoxXpath=sectionSearchCriteria.concat("//input[contains(@name,'j_id49:j_id51')]/..//parent::span");
					String approvalImgXpath="//input[contains(@name,'j_id49:j_id51')]/..//parent::span//img";
					boolean fnStatus = false;
					fnStatus = selectingNameFromWindowFrame(browser, approvalTextBoxXpath, approvalImgXpath,approvalValue  );
					
					if(fnStatus == true)
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Selected Search Criteria Approver For Approvals Name as :"+ approvalValue);
						selectingApproverForApprovalNameSearchCreteria = true;
						
					}
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to select Search Criteria Approver For Approvals Name as :"+ approvalValue);
						errorCount++;
						selectingApproverForApprovalNameSearchCreteria = false;
					}
					
				}
				catch(Throwable t)
				{
					System.out.println("The Exception for selectingApproverForApprovalNameSearchCreteria is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for selectingApproverForApprovalNameSearchCreteria is : "+t.getMessage());
					softAssert.fail("The Exception for selectingApproverForApprovalNameSearchCreteria is : "+t.getMessage());
					errorCount++;
					selectingApproverForApprovalNameSearchCreteria = false;
				}
					return selectingApproverForApprovalNameSearchCreteria;
			}	
			
			//Function for checking Fields are available in Search Results table column fields based on user inputs..
			public static void checkingSearchResultsColumnFields(String testCaseName,Browser browser,String inputFields)
			{
				boolean checkingSearchResultsColumnFields=false;
				try
				{
					boolean fnStatus=isElementExist( browser, tblSearchResults);
					GenericClass.reportlogger(fnStatus,testCaseName,"Search Results Section is not available!!");
					if(fnStatus==true)
					{
						fnStatus=GenericClass.orderOfColumnHeaderOfSection(browser, inputFields, tblSearchResults);
						GenericClass.reportlogger(fnStatus,testCaseName,"Search Results table Section fields are: "+inputFields+"verified !!");
					}
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for checkingSearchResultsColumnFields is :",t);
				}
			}
			
			// Function for confirming the display of Edit User Page.
			public static boolean confirmingUpdateUserPage(Browser browser) {
				boolean confirmingUpdateUserPage = false;
				try {
					
					
					boolean fnStatus = isElementExist(browser, txtUpdateUserHeader);
					if (fnStatus == true)
					{
						ReportEvent.testStepReport(tTestCaseName, "pass", "System should be Displayed Upadte User page.");
						
						confirmingUpdateUserPage = true;
					} 
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to display Update User page");
						softAssert.fail("Failed to Failed to display Update User page ");
						errorCount++;
						confirmingUpdateUserPage = false;
					}
				} 
				catch (Throwable t)
				{
					System.out.println("The Exception for confirmingUpdateUserPage  is : " + t.getMessage());
					utility.fnLogging("The Exception for confirmingUpdateUserPage  is : " + t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for confirmingUpdateUserPage  is : " + t.getMessage());
					errorCount++;
					confirmingUpdateUserPage = false;
				}
				return confirmingUpdateUserPage;
			}
			
			//Function for verifying Updated successfully message..
			public static void verifyingUpdatedMessage(String testCaseName,Browser browser,String cvClaimsHandler)
			{
				try
				{
				boolean fnStatus=false;
				WebElement message=browser.describe(WebElement.class, new XPathDescription(txtUpdatedMessage));
					message.highlight();
					String updatedMsg=message.getInnerText();
					String generatedText = "User "+cvClaimsHandler+" updated successfully";
				fnStatus=(updatedMsg.contains(generatedText));
				GenericClass.reportlogger(fnStatus,testCaseName,"Verified Updated User : "+updatedMsg+"");	
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for verifyingUpdatedMessage  is : ",t);
				}
			}

			//general function for selecting  name from  window frame related to Search criteria..
			public static boolean selectingNameFromWindowFrame(Browser browser,String inputTextBoxXpath, String btnSearchXpath, String inputName)
			{
				
				boolean selectingValueFromWindowFrame= false;
				try
				{
					boolean fnStatus= false;
					fnStatus =isElementExist(browser, inputTextBoxXpath);
					if(fnStatus == true)
						{
						fnStatus = fnEditFieldTextEntry(browser, inputTextBoxXpath, inputName);	
						fnStatus = GenericClass.fnImageLinkOrButtonClick(browser, btnSearchXpath);
							if(fnStatus == true)
							{
								ReportEvent.testStepReport(tTestCaseName, "PASS", "Navigated to child window By title");
									String searchBoxXPath = "//label[text()='Search']/..//input[@name='lksrch']";
									GenericClass.fnEnterInputTextInWindowFrame(browser,"Search for a user ~ Salesforce - Unlimited Edition", "searchFrame",searchBoxXPath/*, inputName*/);
									
									if(fnStatus == true)
									{
										ReportEvent.testStepReport(tTestCaseName, "PASS", "Switched to Search frame");
										String btnGoXpath ="//input[@title='Go!']";
										GenericClass.fnClickFrameButtonByPageTitle(browser,"Search for a user ~ Salesforce - Unlimited Edition", "searchFrame", btnGoXpath);
										if(fnStatus == true)
										{
											ReportEvent.testStepReport(tTestCaseName, "PASS", "Clicked on Go! button");
											browser=BrowserFactory.attach(new BrowserDescription.Builder().title("Search for a user ~ Salesforce - Unlimited Edition").build()); 
											browser.highlight();
											fnStatus = GenericClass.fnSwitchToFrameNameByPageTitle(browser, "Search for a user ~ Salesforce - Unlimited Edition","resultsFrame");
											if(fnStatus == true)
											{
												ReportEvent.testStepReport(tTestCaseName, "PASS", "Switched to Results frame");
												String tblXpath ="//div[@id='Contact_body']/..//following-sibling::div[@class='pbBody']//table//tr[2]//th[1]/a";
														/*"//div[text()='Search Results']/..//following-sibling::div[@class='pbBody']//table//tr[2]//th[1]/a";*/
												Link aTagObject=browser.describe(Frame.class, new FrameDescription.Builder()
														.name("resultsFrame").build()).describe(Table.class, new TableDescription.Builder()
														.tagName("TABLE").build()).describe(Link.class, new LinkDescription.Builder()
														.xpath(tblXpath).tagName("A").build());
														aTagObject.highlight();
												
												
																/*if(aTagObject.getInnerText().equalsIgnoreCase(inputName))
																{*/
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
		
			//Selecting Search Criteria Name in a frame..
			public static void selectingNameFromSearchCreteriaWindowFrame(String testCaseName,Browser browser, String nameValue){
			try{
					String nameTextBoxXpath=sectionSearchCriteria.concat("//input[@name='j_id0:mainForm:j_id3:j_id31:j_id32:j_id34']");
					String nameImgXpath="//input[contains(@name,'j_id0:mainForm:j_id3:j_id31:j_id32:j_id34')]/../..//img[@class='lookupIcon']";
					boolean fnStatus = false;
					fnStatus = selectingNameFromWindowFrame(browser, nameTextBoxXpath, nameImgXpath,nameValue  );
					GenericClass.reportlogger(fnStatus,testCaseName,"Selected Search Criteria Name as :"+ nameValue);
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for selectingNameFromSearchCreteriaWindowFrame is :",t);
				}
			}	
			
			//Selecting Search Criteria Approver For Approvals name in a frame..
			public static void selectingApproverForApprovalsFromSearchCreteriaWindowFrame(String testCaseName,Browser browser, String approverName)
			{
				try
				{
					String approverTextBoxXpath=sectionUpdateUser.concat("//input[@name='j_id0:mainForm:j_id3:j_id32:j_id48:j_id50']");
					String approverImgXpath="//input[@name='j_id0:mainForm:j_id3:j_id32:j_id48:j_id50']/..//img";
					boolean fnStatus = false;
					fnStatus = selectingNameFromWindowFrame(browser, approverTextBoxXpath, approverImgXpath,approverName  );
					GenericClass.reportlogger(fnStatus,testCaseName,"Selected Search Criteria Approver For Approvals Name as :"+ approverName);
				}
				catch(Throwable t)
				{
					
					GenericClass.Catchhandler("The Exception for selectingApproverForApprovalsFromSearchCreteriaWindowFrame is : ",t);
				}
			}	
			
			//Selecting Assigned Account User Name  in a frame..
			public static boolean selectingUserNameFromAssignedUserWindowFrame(Browser browser, String nameValue)
			{
				boolean selectingUserNameFromAssignedUserWindowFrame= false;
				
				try
				{
					boolean fnStatus=false;
					String userNameTextBoxXpath=sectionAssignedAccountInfo.concat("//input[@name='CF00NA000000A2JD6']");
					
					fnStatus = fnEditFieldTextEntry(browser, userNameTextBoxXpath, nameValue);	

					GenericClass.reportlogger(fnStatus,tTestCaseName,"Selected Assigned User Name as :"+ nameValue);	
						
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for selectingUserNameFromAssignedUserWindowFrame is : ",t);
				}
					return selectingUserNameFromAssignedUserWindowFrame;
			}	
			
			
		
			
			//Checking rows
			public static boolean totalrows(Browser browser)
			{
				try
				{
				
				Link tblLink=	browser.describe(Page.class, new PageDescription.Builder()
							.title("Salesforce - Unlimited Edition").build()).describe(Frame.class, new FrameDescription.Builder()
							.name("066A0000001XCIx").build()).describe(Table.class, new TableDescription.Builder()
							.tagName("TABLE").build()).describe(Link.class, new LinkDescription.Builder()
							.tagName("A").name("Claimant Contact").build());
					
				tblLink.highlight();
				
				tblLink.click();
				
					
			}
				catch(Throwable t)
				{
					
				}
				return true;
			}
		
			
			/////23092017////////////
			
			
			
			//Selecting Radio button of Search Results Section..
			public static boolean selectingRadioButtonOfSearchResultsSec(Browser browser)
			{
				
				boolean selectingRadioButtonOfSearchResultsSec = false;
				
				try
				{
					boolean fnStatus = false;
					String tableXpath = tblSearchResults;
					fnStatus = isElementExist(browser, tableXpath);
					if(fnStatus == true)
					{
						int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
						if(rowCount>1)
						{
						outerloop:
						for(int i=1; i<=rowCount;i++)
						{
							String tdTagXpath=tableXpath+"/tbody/tr["+i+"]//td";
							WebElement[] tdTags = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(tdTagXpath).build());
							for(int j=0;j<= tdTags.length;j++)
							{
									String inputXpath=tdTagXpath.concat("//input");
									fnStatus = selectRadButtonClick(browser, inputXpath);
									GenericClass.reportlogger(fnStatus,tTestCaseName,"Selected Radio button ");
								}	
							}
						}
						else
						{
							ReportEvent.testStepReport("", "fail", "No Records arae available in Search results table.");
							errorCount++;
							selectingRadioButtonOfSearchResultsSec = false;
						}
							}
					else
					{
						
						ReportEvent.testStepReport("", "fail", "Search results dynamic table is not available");
						errorCount++;
						selectingRadioButtonOfSearchResultsSec = false;
					}
				
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for selectingRadioButtonOfSearchResultsSec is : ",t);
				}
				return selectingRadioButtonOfSearchResultsSec;
			}
			
//Function to validate the pop up text by cross checking with input text message.
			
		public static void  popUpMessageValidation(String testCaseName, Browser browser, String popUpWindowTitle, String inputTextMessage)
			{
				try
				{
					String getMsgText = GenericClass.getTextOfPopUp(browser, popUpWindowTitle, inputTextMessage);
					boolean fnStatus=(getMsgText.equalsIgnoreCase(inputTextMessage));
					GenericClass.reportlogger(fnStatus,testCaseName,inputTextMessage + " is available as expected.");
				}
				catch(Throwable t)
				{
					GenericClass.Catchhandler("The Exception for popUpMessageValidation is : " , t);
				}
			}
			
					
			
			
}
