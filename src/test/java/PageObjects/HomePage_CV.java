package PageObjects;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;
import com.sun.mail.imap.Utility;

public class HomePage_CV extends DriverScript{
	
	public static final String sectionAllTabs ="//label[text()='View:']/../../../../../../../../child::div[@class='pbBody']";
	public static final String tabPlus = "//img[@title='All Tabs']"/*"//img[@title='All Tabs']"*/;
	public static final String txtSearchValue = "//div[@class ='headerSearchContainer']/..//input[@title='Search...']";
	public static final String btnSearch = "//div[@class ='headerSearchContainer']/..//input[@value ='Search']";
	public static final String txtSearchResultsHeader="//h1[text()='Search Results']";
	public static final String txtCurrentStatusHome="//h1[@class='currentStatusUserName']/a";
	public static final String searchBox="//div[@class='searchBoxClearContainer']/..//input[@name='str']";
	
	
	// Function for navigating to "Search ~ Salesforce Unlimited-Edition" window
		public static boolean navigatingToWindow(Browser browser) {
			boolean navigatingToWindow = false;
			try {
				boolean fnStatus=false;

		    	Thread.sleep(3000);
		    	fnSwitchTab("Salesforce - Unlimited Edition");
		    	browser=BrowserFactory.attach(new BrowserDescription.Builder().title("Salesforce - Unlimited Edition").build()); 
		    	browser.highlight();

				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "pass", "window navigation  is succesful!!");
					
					navigatingToWindow = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Not Navigated to required window: ");
					errorCount++;
					navigatingToWindow = false;
				}
			}
				catch(Throwable t)
				{
					
					System.out.println("The Exception for clickingTabForNavigation  is : " + t.getMessage());
					utility.fnLogging("The Exception for clickingTabForNavigation  is : " + t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for clickingTabForNavigation  is : " + t.getMessage());
					errorCount++;
					navigatingToWindow = false;
				}
				return navigatingToWindow;
			}
			
	//Function to click on (+) tab and then click on respective tab
		public static boolean clickingTabForNavigation(Browser browser, String tabName)
		{
			boolean clickingTabForNavigation=false;
			try
			{
				boolean fnStatus = false;
				fnStatus = isElementExist(browser, tabPlus);
				if(fnStatus ==true)
				{
					 fnStatus = GenericClass.fnImageLinkOrButtonClick(browser, tabPlus);
						if(fnStatus==true)
						{
							fnStatus = isElementExist(browser, sectionAllTabs);
							if(fnStatus ==true)
							{
								String tabXpath = sectionAllTabs + "//a[text()='"+ tabName +"']";
								fnStatus = isElementExist(browser, tabXpath);
								if(fnStatus ==true)
								{
									fnStatus = fnWebElementClick(browser, tabXpath);
									if(fnStatus ==true)
									{
										ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on " + tabName + ", tab Successfully.");
										clickingTabForNavigation = true;
									}
									else
									{
										ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + tabName + ", tab.");
										softAssert.fail( "Failed to click on " + tabName + ", tab.");
										errorCount++;
										clickingTabForNavigation = false;
									}
									
								}
								else
								{
									ReportEvent.testStepReport(tTestCaseName, "FAIL", tabName + ", element is not available.");
									softAssert.fail(tabName + ", element is not available.");
									errorCount++;
									clickingTabForNavigation = false;
								}
							}
							else
							{
								ReportEvent.testStepReport(tTestCaseName, "FAIL", "Element with Xpath : " + sectionAllTabs + "is not available.");
								softAssert.fail("Element with Xpath : " + sectionAllTabs + "is not available.");
								errorCount++;
								clickingTabForNavigation = false;
							}
							
						}
						else
						{
							ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on '+' Tab.");
							softAssert.fail("Failed to click on '+' Tab.");
							errorCount++;
							clickingTabForNavigation = false;
						}
				}
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Element with Xpath : " + tabPlus + "is not available.");
					softAssert.fail("Element with Xpath : " + tabPlus + "is not available.");
					errorCount++;
					clickingTabForNavigation = false;
				}
				
			
			}
			catch(Throwable t)
			{
				
				System.out.println("The Exception for clickingTabForNavigation  is : " + t.getMessage());
				utility.fnLogging("The Exception for clickingTabForNavigation  is : " + t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingTabForNavigation  is : " + t.getMessage());
				errorCount++;
				clickingTabForNavigation = false;
			}
			return clickingTabForNavigation;
		}

		//Function related to entering Search Text
		
		public static boolean enteringSearchText(Browser browser, String searchText)
		{
			boolean enteringSearchText=false;
			try
			{
				boolean fnStatus =false;
				browser.describe(EditField.class, new XPathDescription("//div[@class='searchBoxClearContainer']/..//input[@name='str']")).highlight();
				browser.describe(EditField.class, new XPathDescription("//div[@class='searchBoxClearContainer']/..//input[@name='str']")).click();
				browser.describe(EditField.class, new XPathDescription("//div[@class='searchBoxClearContainer']/..//input[@name='str']")).setValue(searchText);
				if(fnStatus==true)
					{
						ReportEvent.testStepReport(tTestCaseName, "PASS", "Search Text should be passed successfully " +searchText);
						enteringSearchText = true;
					}
					else
					{
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Search Text is not passed : " + searchText);
						softAssert.fail("Failed to enter Search Text in Search text box.. ");
						errorCount++;
						enteringSearchText = false;
					}
					
			}
			catch(Throwable t)
			{
				System.out.println("The Exception for enteringSearchText is : "+t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for enteringSearchText is : "+t.getMessage());
				softAssert.fail("The Exception for enteringSearchText is : "+t.getMessage());
				errorCount++;
				enteringSearchText = false;
		}
				
			return enteringSearchText;
		}
		
		//Function related to Clicking Search Button
		
		public static boolean clickingSearchButton(String testCaseName,Browser browser)
		{
			boolean clickingSearchButton = false;
			try
			{
				boolean fnStatus = isElementExist(browser, btnSearch);
				GenericClass.reportlogger(fnStatus,testCaseName,"Search button Availability :"+btnSearch);
				if(fnStatus=true)
				{
						fnStatus=fnButtonClick(browser, btnSearch);
						GenericClass.reportlogger(fnStatus,testCaseName,"Search button Should be clicked :"+btnSearch);
				}
				
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for clickingSearchButton is : ",t);
			}
			return clickingSearchButton;
		}
		//Function navigated to Search results page..
		
				public static boolean confirmingNavigatedtoSearchResultsPage(Browser browser)
				{
					boolean confirmingNavigatedtoSearchResultsPage = false;
					try
					{
						boolean fnStatus = isElementExist(browser, txtSearchResultsHeader);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Search Results screen display ");
						
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingNavigatedtoSearchResultsPage is : ",t);
						
					}
					return confirmingNavigatedtoSearchResultsPage;
				}

			///////////////////today 23/09/2017////////////////////
				
				//Function for navigated to Home page..
				public static void confirmingHomePageNavigation(String testCaseName,Browser browser,String userName)
				{
					try
					{
						WebElement homePage=browser.describe(WebElement.class, new XPathDescription(txtCurrentStatusHome));
						homePage.highlight();
						String homePagetext=homePage.getInnerText();
						boolean fnStatus = (homePagetext.contains(userName));
						GenericClass.reportlogger(fnStatus,testCaseName,"CV Home Page validation ");	
							
						}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for confirmingHomePageNavigation is : ",t);
					}
				}
				
				//Function related to entering Search Text
				
				public static boolean globalSearchText(String tTestCaseName,Browser browser, String searchText)
				{
					boolean globalSearchText=false;
					try
					{
						boolean fnStatus =isElementExist(browser, searchBox);
						GenericClass.reportlogger(fnStatus,tTestCaseName,"Search BOX Text Element : " +searchText);
						if(fnStatus=true)
						{
							browser.describe(EditField.class, new XPathDescription(searchBox)).highlight();
							browser.describe(EditField.class, new XPathDescription(searchBox)).click();
							browser.describe(EditField.class, new XPathDescription(searchBox)).setValue(searchText);
							GenericClass.reportlogger(fnStatus,tTestCaseName,"Search Text : " +searchText);
						}
					}
					catch(Throwable t)
					{
						GenericClass.Catchhandler("The Exception for globalSearchText is :",t);
					}
						
					return globalSearchText;
				}
				
				
				
				///////////////////////////04/10/2017////////////////////////////////////
				
				/********************************Step_01*********************************//*
				public static void step_01(Browser browser,String testCaseName,String userName,String password,String homePageHeaderText)
				{
					boolean fnStatus=false;
					try
					{
						fnStatus=LoginPage_CV.loginToClaimVantage(testCaseName, browser, userName, password);
						if(fnStatus==true)
						{
							fnStatus=HomePage_CV.confirmingHomePageNavigation(browser, homePageHeaderText);
							if(fnStatus==true)
							{
								ReportEvent.testStepReport(testCaseName, "Pass", "Step1 Executed Successfully.");
							}
							else
							{
								ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Navigate Home page.");
			 					errorCount++;	
							}
							
						}
						else
						{
							ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Login Claim Vantage Application.");
			 				errorCount++;
						}
					}
					catch(Throwable t)
					{
						System.out.println(t.getMessage());
			 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-01 is : "+t.getMessage());
			 			errorCount++;
					}
				}
				*/
				
						
				
}
