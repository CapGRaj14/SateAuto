package PageObjects;

import com.hp.lft.sdk.web.Browser;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

public class TestCase_TestSteps extends DriverScript
{
	
	
	/********************************Step_01*********************************/
	public static void step_01(Browser browser,String testCaseName,String userName,String password,String homePageHeaderText)
	{
		boolean fnStatus=false;
		try
		{
				// login into CV application
			/*fnStatus=LoginPage_CV.loginToClaimVantage(testCaseName, browser, userName, password);
				reportlogger(fnStatus,testCaseName,"Login to CV application ");
			*/	//Validation CV application Home page
			HomePage_CV.confirmingHomePageNavigation(testCaseName,browser, homePageHeaderText);
				reportlogger(fnStatus,testCaseName,"CV Home validation ");
				
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-01 is : "+t.getMessage());
 			errorCount++;
		}
	}
	
	//Function for generating report statement..
public static void reportlogger(boolean fnStatus,String testCaseName,String description){
		if(fnStatus==true)
		{
			ReportEvent.testStepReport(testCaseName, "Pass", description+" executed successfully");
		}
		else
		{
			ReportEvent.testStepReport(testCaseName, "Fail", description+" execution Failed");
				errorCount++;	
		}
}
	
	/********************************Step_02*********************************/
	public static void step_02(Browser browser,String testCaseName,String tabName){
		boolean fnStatus=false;
		try
		{
				//Clicking updateuser tab..
	HomePage_CV.clickingTabForNavigation(browser, tabName);
				reportlogger(fnStatus,testCaseName,"Clicking Update User Tab");
				//Confirming Edit user Screen..
		UpDateUser_CV.confirmingEditUserPage(testCaseName,browser);
				reportlogger(fnStatus,testCaseName,"Navigated to Edit User Page");
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-02 is : "+t.getMessage());
 			errorCount++;
		}
	}
	
	
	/********************************Step_03*********************************/
	public static void step_03(Browser browser,String testCaseName,String nameValue,String buttonName,String inputFields)
	{
		boolean fnStatus=false;
		try
		{
			//Selecting Name from Search creteria Section..
		UpDateUser_CV.selectingNameFromSearchCreteriaWindowFrame(testCaseName,browser, nameValue);
			reportlogger(fnStatus,testCaseName,"Select CV Claimhandler name");
			//Clicked Search button..
		UpDateUser_CV.clickButtonOfSearchResultsPage(testCaseName,browser, buttonName);
		reportlogger(fnStatus,testCaseName,"Clicked Search button");
			//Checking Search Results Column fields..
		UpDateUser_CV.checkingSearchResultsColumnFields(testCaseName,browser, inputFields);
			reportlogger(fnStatus,testCaseName,"Checking Search Results Column fields");
		
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-03 is : "+t.getMessage());
 			errorCount++;
		}
	}
	
		/********************************Step_04*********************************/
		public static void step_04(Browser browser,String testCaseName,String buttonName)
		{
			boolean fnStatus=false;
			try
			{
				//Select radio button
			fnStatus=UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
				reportlogger(fnStatus,testCaseName,"Selected Radio Button");
				//Clicked Next Button
			UpDateUser_CV.clickButtonOfSearchResultsPage(testCaseName,browser, buttonName);
			reportlogger(fnStatus,testCaseName,"Clicked Next Button");
				//Confirming Update user Screen..
			fnStatus=UpDateUser_CV.confirmingUpdateUserPage(browser);
				reportlogger(fnStatus,testCaseName,"Confirming Update user Screen");
			
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-04 is : "+t.getMessage());
	 			errorCount++;
			}
		
		}
	
	
		/********************************Step_05*********************************/
		public static void step_05(Browser browser,String testCaseName,String mgtLeadName,String buttonName,String popUpWindowTitle,String inputTextMessage )
		{
			boolean fnStatus=false;
			try
			{
				//Select CV management lead name..
			UpDateUser_CV.selectingApproverForApprovalsFromSearchCreteriaWindowFrame(testCaseName,browser, mgtLeadName);
				reportlogger(fnStatus,testCaseName,"Select CV Management Name");
				//Click Update Button
			UpDateUser_CV.clickButtonOfSearchResultsPage(testCaseName,browser, buttonName);
				reportlogger(fnStatus,testCaseName,"Clicked Update Button");
				//Validate Popup message..
			UpDateUser_CV.popUpMessageValidation(testCaseName, browser, popUpWindowTitle, inputTextMessage);
				reportlogger(fnStatus,testCaseName,"Validate Popup message");
			
			
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-05 is : "+t.getMessage());
	 			errorCount++;
			}
		}
	
		/********************************Step_06*********************************/
		public static void step_06(Browser browser,String testCaseName,String popUpWindowTitle,String buttonName,String inputTextMessage)
		{
			boolean fnStatus=false;
			try
			{
				//Click OK button..
		BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(testCaseName,browser, popUpWindowTitle, buttonName);
				reportlogger(fnStatus,testCaseName,"Clicked OK button");
				//Validate Updated Message..
			UpDateUser_CV.verifyingUpdatedMessage(testCaseName,browser, inputTextMessage);
				reportlogger(fnStatus,testCaseName,"Validate Updated Message");
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-06 is : "+t.getMessage());
	 			errorCount++;
			}
		}
	
		/********************************Step_12_13_14*********************************/
	
		public static void step_12(Browser browser,String testCaseName,String action,String popUpWindowTitle,String buttonName,String inputTextMessage)
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=AccountsPage_CV.recursiveDeletionOfRecordsAssignedAccountSection(testCaseName, browser, action, popUpWindowTitle, inputTextMessage, buttonName);
			if(fnStatus==true)
			{
				ReportEvent.testStepReport(testCaseName, "Pass", "Step12 Executed Successfully.");
				
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Click Del Link.");
 				errorCount++;
			}
				
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-12-13-14 is : "+t.getMessage());
	 			errorCount++;
			}
		}
	
		/********************************Step_15*********************************/
	
		public static void step_15(Browser browser,String testCaseName)
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=AccountsPage_CV.clickingNewAssignedAccountUserButton(browser);
			if(fnStatus==true)
			{
				fnStatus=AccountsPage_CV.confirmingNewAssignedAccountUserPageNavigation(browser);
			if(fnStatus=true)
			{
				
					ReportEvent.testStepReport(testCaseName, "Pass", "Step15 Executed Successfully.");
				}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Navigate New Assigned Account user Screen.");
 				errorCount++;
			}
			
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Click New Assigned Accout User Button.");
 				errorCount++;
			}
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-15 is : "+t.getMessage());
	 			errorCount++;
			}
		
		}
	
		/********************************Step_16*********************************/
		public static void step_16(Browser browser,String testCaseName,String claimAvailableValue,String claimAvailableValue2,String benefitType,
									String claimHandlerName,String inputValues,String chosenBenefitValues,String buttonName,String inputFieldValues )
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=AccountsPage_CV.fillingAssignedAccountUserInfoFields(browser, claimAvailableValue, claimAvailableValue2, benefitType);
			if(fnStatus==true)
			{
				fnStatus=UpDateUser_CV.selectingUserNameFromAssignedUserWindowFrame(browser, claimHandlerName);
			if(fnStatus=true)
			{
				fnStatus=AccountsPage_CV.verifyingChosenListBoxValuesInClaimComplexity(browser, inputValues);
					if(fnStatus=true)
					{
						fnStatus=AccountsPage_CV.verifyingChosenValuesInBenefitType(browser, chosenBenefitValues);
						if(fnStatus=true)
						{
							fnStatus=AccountsPage_CV.clickButtonOfAssignedAccountUserEditPage(browser, buttonName);
							if(fnStatus=true)
							{
								fnStatus=AccountsPage_CV.confirmingAssignedAccountUserPageNavigation(browser);
								if(fnStatus=true)
								{
									fnStatus=AccountsPage_CV.checkingAssignedAccountUserDetailSecFields(browser, inputFieldValues);
										if(fnStatus=true)
										{
											ReportEvent.testStepReport(testCaseName, "Pass", "Step16 Executed Successfully.");	
										}
										else
										{
											ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Checking Assigned account user edit page fields.");
							 				errorCount++;
										}
								}
								else
								{
									ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Navigate Assigned Account user Edit page.");
					 				errorCount++;
								}
							}
							else
							{
								ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Click Save Button.");
				 				errorCount++;
							}
						}
						else
						{
							ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Verify Benefit Type Choosen List box values.");
			 				errorCount++;
						}
					}
					else
					{
						ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Verify Claim complexity Choosen List box values.");
		 				errorCount++;
					}
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Select Claim Handler Name.");
 				errorCount++;
			}
			
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to Fill Assigned account user Information fields.");
 				errorCount++;
			}
				
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-06 is : "+t.getMessage());
	 			errorCount++;
			}
		}
	
		/********************************Step_17*********************************/
		
		public static void step_17(Browser browser,String testCaseName,String fieldName,String h2HeaderText,String sectionName,String linkName,String inputValueLink )
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=AccountsPage_CV.clickingAccountNameAssignedAccUserDetailPage(browser, fieldName);
			if(fnStatus==true)
			{
				fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, h2HeaderText);
				if(fnStatus=true)
				{
					fnStatus=AccountsPage_CV.verifyingCVHndlrInAssignAccUserSec(testCaseName, browser, sectionName, linkName, inputValueLink);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(testCaseName, "Pass", "Step17 Executed Successfully.");
						}
						else
						{
							ReportEvent.testStepReport(testCaseName, "Fail", "Failed to verifyingCVHndlrInAssignAccUserSec.");
			 				errorCount++;
						}
				}
				else
				{
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to navigationBasedOnH2HeaderText.");
	 				errorCount++;
				}
				
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickingAccountNameAssignedAccUserDetailPage.");
 				errorCount++;
			}
				
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-17 is : "+t.getMessage());
	 			errorCount++;
			}
		}
	
		
		/********************************Step_21*********************************/
		public static void step_21(Browser browser,String testCaseName,String searchText,String  sectionName)
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=HomePage_CV.globalSearchText(testCaseName, browser, searchText);
			if(fnStatus==true)
			{
				fnStatus=HomePage_CV.clickingSearchButton(testCaseName,browser);
			if(fnStatus=true)
			{
				fnStatus=HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
				if(fnStatus=true)
				{
					fnStatus=SearchResultsPage.clickLinkOfSearchResultsSection(browser, sectionName, searchText);
					if(fnStatus=true)
					{
						fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, searchText);
						if(fnStatus=true)
						{
							ReportEvent.testStepReport(testCaseName, "Pass", "Step21 Executed Successfully.");
						}
						else
						{
							ReportEvent.testStepReport(testCaseName, "Fail", "Failed to navigationBasedOnH2HeaderText.");
			 				errorCount++;
						}
					}
					else
					{
						ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickLinkOfSearchResultsSection.");
		 				errorCount++;
					}
				}
				else
				{
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to confirmingNavigatedtoSearchResultsPage.");
	 				errorCount++;
				}
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickingSearchButton.");
 				errorCount++;
			}
			
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to search globalSearchText.");
 				errorCount++;
			}
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-21 is : "+t.getMessage());
	 			errorCount++;
			}
		
		}
	
		/********************************Step_22*********************************/
		public static void step_22(Browser browser,String testCaseName,String frameTitle,String frameTag,String frameId,String buttonName )
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=AccountsPage_CV.clickingNewContactButton(browser, frameTitle, frameTag, frameId, buttonName);
			if(fnStatus==true)
			{
				fnStatus=ContactsPage_CV.confirmingSelectedRecordTypeNavigation(browser);
			if(fnStatus=true)
			{
				
				ReportEvent.testStepReport(testCaseName, "Pass", "Step22 Executed Successfully.");
			}
			
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to confirmingSelectedRecordTypeNavigation.");
 				errorCount++;
			}
			
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to search clickingNewContactButton.");
 				errorCount++;
			}
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-22 is : "+t.getMessage());
	 			errorCount++;
			}
		
		}
			
		/********************************Step_23*********************************/
		public static void step_23(Browser browser,String testCaseName,String recordType )
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=ContactsPage_CV.selectingRecordType(browser, recordType);
			if(fnStatus==true)
			{
				fnStatus=ContactsPage_CV.clickingContinueButton(browser);
			if(fnStatus=true)
			{
				fnStatus=ContactsPage_CV.confirmingContactEditPageNavigation(browser);
				if(fnStatus=true)
				{
					ReportEvent.testStepReport(testCaseName, "Pass", "Step23 Executed Successfully.");
				}
				else
				{
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to confirmingContactEditPageNavigation.");
	 				errorCount++;
				}
				}
			
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickingContinueButton.");
 				errorCount++;
			}
			
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to search selectingRecordType.");
 				errorCount++;
			}
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-22 is : "+t.getMessage());
	 			errorCount++;
			}
		
		}
		
		/********************************Step_24*********************************/
		public static void step_24(Browser browser,String testCaseName,String firstNameLabel,String  firstNameValue,String lastNameLabel,String lastNameValue,String ssNumberLabel,
									String ssNumber,String birthDate,String genderLabel,String genderValue,String mailingStreetLabel,String mailingStreet,String mailingCityLabel,String  mailingCity,String mailingStateLabel,String mailingState,
									String buttonName )
		{
			boolean fnStatus=false;
			try
			{
			fnStatus=ContactsPage_CV.fillingContactInfoFieldsClaimantType(browser, firstNameLabel, firstNameValue, lastNameLabel, lastNameValue, ssNumberLabel, ssNumber, birthDate, genderLabel, genderValue);
			if(fnStatus==true)
			{
				fnStatus=ContactsPage_CV.fillingAddressInfoFieldsClaimantType(browser, mailingStreetLabel, mailingStreet, mailingCityLabel, mailingCity, mailingStateLabel, mailingState);
			if(fnStatus=true)
			{
				fnStatus=ContactsPage_CV.clickButtonOfContactEditPage(browser, buttonName);
				if(fnStatus=true)
				{
					ReportEvent.testStepReport(testCaseName, "Pass", "Step24 Executed Successfully.");
				}
				else
				{
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickButtonOfContactEditPage.");
	 				errorCount++;
				}
				}
			
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to fillingAddressInfoFieldsClaimantType.");
 				errorCount++;
			}
			
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to search fillingContactInfoFieldsClaimantType.");
 				errorCount++;
			}
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-22 is : "+t.getMessage());
	 			errorCount++;
			}
		
		}

/********************************Step_25*********************************/
public static void step_25(Browser browser,String testCaseName,String claimTab )
{
	boolean fnStatus=false;
	try
	{
	fnStatus=HomePage_CV.clickingTabForNavigation(browser, claimTab);
	if(fnStatus==true)
	{
		fnStatus=ClaimsPage_CV.confirmingClaimsPageNavigation(browser);
	if(fnStatus=true)
	{
		fnStatus=ClaimsPage_CV.checkingRecentViewClaimsInClaimHomePage(browser);
		if(fnStatus=true)
		{
			ReportEvent.testStepReport(testCaseName, "Pass", "Step25 Executed Successfully.");
		}
		else
		{
			ReportEvent.testStepReport(testCaseName, "Fail", "Failed to checkingRecentViewClaimsInClaimHomePage.");
				errorCount++;
		}
		}
	
	else
	{
		ReportEvent.testStepReport(testCaseName, "Fail", "Failed to confirmingClaimsPageNavigation.");
			errorCount++;
	}
	
	}
	else
	{
		ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickingTabForNavigation.");
			errorCount++;
	}
	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-25 is : "+t.getMessage());
			errorCount++;
	}

}

/********************************Step_26*********************************/
public static void step_26(Browser browser,String testCaseName,String dopdownValue,String statusLabel,String benefitfieldName,String claimantInsured)
{
	boolean fnStatus=false;
	try
	{
	fnStatus=ClaimsPage_CV.clickingNewButton(browser);
	if(fnStatus==true)
	{
		fnStatus=ClaimsPage_CV.confirmingNewClaimPageNavigation(browser);
	if(fnStatus=true)
	{
			fnStatus=ClaimsPage_CV.verifyingStatusDropdownFieldAsPending(browser, dopdownValue);
			if(fnStatus=true)
			{
			fnStatus=ClaimsPage_CV.verifyingStatusFieldsAsRequired(browser, statusLabel);	
			if(fnStatus=true)
			{
				fnStatus=ClaimsPage_CV.validatingFieldValueAsBlankInClaimInfoSec(browser, benefitfieldName, claimantInsured);
				if(fnStatus=true)
				{
					ReportEvent.testStepReport(testCaseName, "Pass", "Step26 Executed Successfully.");
				}
				else
				{
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to validatingFieldValueAsBlankInClaimInfoSec.");
					errorCount++;
				}
				
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to validatingFieldValueAsBlankInClaimInfoSec.");
				errorCount++;	
			}
			}
			else
			{
				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to verifyingStatusDropdownFieldAsPending.");
				errorCount++;
			}
		
		}
	
	else
	{
		ReportEvent.testStepReport(testCaseName, "Fail", "Failed to confirmingNewClaimPageNavigation.");
			errorCount++;
	}
	
	}
	else
	{
		ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickingNewButton.");
		errorCount++;
	}
	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-25 is : "+t.getMessage());
			errorCount++;
	}

}
/********************************Step_27*********************************/
public static void step_27(Browser browser,String testCaseName,String buttonName )
{
	boolean fnStatus=false;
	try
	{
	fnStatus=ClaimsPage_CV.clickButtonOfClaimEditPage(browser, buttonName);
	if(fnStatus==true)
	{
		fnStatus=ClaimsPage_CV.confirmingClaimsPageNavigation(browser);
	if(fnStatus=true)
	{
		fnStatus=ClaimsPage_CV.checkingRecentViewClaimsInClaimHomePage(browser);
		if(fnStatus=true)
		{
			ReportEvent.testStepReport(testCaseName, "Pass", "Step25 Executed Successfully.");
		}
		else
		{
			ReportEvent.testStepReport(testCaseName, "Fail", "Failed to checkingRecentViewClaimsInClaimHomePage.");
				errorCount++;
		}
		}
	
	else
	{
		ReportEvent.testStepReport(testCaseName, "Fail", "Failed to confirmingClaimsPageNavigation.");
			errorCount++;
	}
	
	}
	else
	{
		ReportEvent.testStepReport(testCaseName, "Fail", "Failed to clickButtonOfClaimEditPage.");
			errorCount++;
	}
	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-25 is : "+t.getMessage());
			errorCount++;
	}
}

/*
*//********************************Step_100*********************************//*
public static void step_100(String testCaseName,Browser browser,String labelName,String inputClaimID,

							String benefitLabel,String inputBcID,String docmentLabel,String typeLabel,String claimLabel,String benefitClaimedLabel,
							String docType,String docReceivedDateLabel)
{
	boolean fnStatus=false;
	try
	{
		

	fnStatus=BenefitClaimedPage_CV.clickingNewDocumentsButton(browser);
	fnStatus=BenefitClaimedPage_CV.confirmingNewDocumentPageNavigation(browser);
	fnStatus=ClaimsPage_CV.validateAutoPopulatedClaimId(browser, labelName, inputClaimID);
	fnStatus= ClaimsPage_CV.validatePopulatedBenefitId(browser, benefitLabel, inputBcID);
	fnStatus=ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(browser, docmentLabel);
	fnStatus=ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(browser, typeLabel);
	fnStatus= ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(browser, claimLabel);
	fnStatus= ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(browser, benefitClaimedLabel);
	fnStatus= ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(browser, docType);
	fnStatus=ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(browser, docReceivedDateLabel);

	
	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-100 is : "+t.getMessage());
			errorCount++;
	}
}

*//********************************Step_101*********************************//*

public static void step_101(Browser browser,String testCaseName,String documentLabel,String documentName,
							String typeLabel,String typeValue,String documentTypeLabel,String documentTypeValue,String docReceivedDate,
							String documentDescLabel,String documentDesc,String buttonName,
							String h2HeaderText,String inputValues,String inputButtons )
{
	boolean fnStatus=false;
	try
	{
		//Filling Require fields in Document detail secion...

	fnStatus=BenefitClaimedPage_CV.fillingRequiredFieldsInDocumentInfo(browser, documentLabel, documentName, typeLabel, typeValue, documentTypeLabel, documentTypeValue, documentDescLabel, documentDesc, docReceivedDate);
		//Clicking Save button in document edit page
	fnStatus=BenefitClaimedPage_CV.clickButtonOfDocumentEditPage(browser, buttonName);
		//Navigated to Documet detail page..
	fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, h2HeaderText);
		//Checking Saved Changes..
	fnStatus= BenefitClaimedPage_CV.checkingUpdatedValuesInDocumentDetailsSec(browser, documentLabel, typeLabel, documentTypeLabel, documentDescLabel, inputValues);
		//Checking buttons in document detail page..
	fnStatus=BenefitClaimedPage_CV.checkingButtonsInDocumentDetailPage(browser, inputButtons);

	
	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-101 is : "+t.getMessage());
			errorCount++;
	}
}



*//********************************Step_102*********************************//*

public static void step_102(Browser browser,String testCaseName,String buttonName,String docName,String choosefileButton,String filePath,
							String attachFileButton,String h2HeaderText,String viewDoc,String viewAttchmentLink )
{
	boolean fnStatus=false;
	try
	{
		//clicking attachment button..

	fnStatus=BenefitClaimedPage_CV.clickButtonOfDocumentDetailsPage(browser, buttonName);
		//Confirming attachment file page..
	fnStatus=BenefitClaimedPage_CV.confirmingAttachFilePageNavigation(browser, docName);
		//Browse file and click attachment file ..
	fnStatus=BenefitClaimedPage_CV.browseToAttachFileFromComputer(browser, choosefileButton, filePath, attachFileButton);
		//confirming attachment page..
	fnStatus=BenefitClaimedPage_CV.confirmingAttachFileHeaderPageNavigation(browser);
		//Click done button..
	fnStatus=BenefitClaimedPage_CV.clickingDoneButton(browser);
		//Confirming Navigation
	fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, h2HeaderText);
		//Verifying attachment link..
	fnStatus=BenefitClaimedPage_CV.verifyingViewAttachmentLinkInDocumentDetailPage(browser, viewDoc, viewAttchmentLink);

	
	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-102 is : "+t.getMessage());
			errorCount++;
	}
}



*//********************************Step_104*********************************//*

public static void step_104(Browser browser,String testCaseName,String benefitClaimedLabel,String h2HeaderText,String primaryKey,String primaryHeader,
							String columnHeader,String inputValue,int businessDays,String LastModifiedHeader,String dueDateHeader,String subjectValue,String commentLabel )
{
	boolean fnStatus=false;
	try
	{
		//clicking benefit claim id..

	fnStatus=BenefitClaimedPage_CV.clickingBenefitClaimedID(browser, benefitClaimedLabel);
		//Confirming benefit claimed id page..
	fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, h2HeaderText);
		//verifying assign to user in open activity section..
	BenefitClaimedPage_CV.verifyingColumnValueOFActivityHistorySec(browser, primaryKey, primaryHeader, columnHeader, inputValue);
		//validating due businee days.
	fnStatus=BenefitClaimedPage_CV.validatingDueBusinessDaysActivityHistorySection(browser, businessDays, primaryKey, primaryHeader, LastModifiedHeader, dueDateHeader);
		
	fnStatus=BenefitClaimedPage_CV.clickingSubjectOfActivityHistorySection(browser, subjectValue);
		
	fnStatus=BenefitClaimedPage_CV.checkingTaskCommentLink(browser, commentLabel);
		

	}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-104 is : "+t.getMessage());
			errorCount++;
	}
}

*/




}

		
	
		/*
	
	
	//......................Step-80...........
 	public static void step_80(Browser browser, String testCaseName,
 			String occupationalTab, String titleLabel, 
 			String titleValue, String jobLabel, String jobClassification, String buttonName )
 	{
 		boolean fnStatus = false;
 		try
 		{
 			fnStatus =BenefitClaimedPage_CV.clickTabCaseMgmt("", browser, "Occupational");
 			if(fnStatus==true)
 			{
 				fnStatus = BenefitClaimedPage_CV.fillingOccupationalItemsFields(browser, "Title", "Test_Software", "Job Classification" ,"Light");
 				if(fnStatus==true)
 				{
 					fnStatus = BenefitClaimedPage_CV.clickButtonOfOccupationalSec(browser, "Save");
 					if(fnStatus==true)
 					{
 						Thread.sleep(3000);
 					}
 					else
 					{
 						ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click Save button of Occupational related section.");
 						errorCount++;
 					}
 				}
 				else
 				{
 					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to fill Occupational related fields.");
 					errorCount++;
 				}
 			}
 			else
 			{
 				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click "+occupationalTab+": tab.");
 				errorCount++;
 			}	
 		}
 		catch(Throwable t)
 		{
 			System.out.println(t.getMessage());
 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in step-80 is : "+t.getMessage());
 			errorCount++;
 		}
 		
 		
 	}
 			
 	
 	public static void step_7(Browser browser, String testCaseName,  String searchText, String sectionName)
 	{
 		boolean fnStatus = false;
 		try
 		{
 			fnStatus =HomePage_CV.globalSearchText(testCaseName,browser,searchTextrd.getCellData(DataTable, "Account_Name", TCID));
 	 		if(fnStatus==true)
 	 		{
 	 			fnStatus = HomePage_CV.clickingSearchButton(browser);
 	 			if(fnStatus==true)
 	 			{
 	 				fnStatus = HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
 	 				if(fnStatus==true)
 	 				{
 	 					fnStatus =SearchResultsPage.clickLinkOfSearchResultsSection(browser, sectionName , searchText);
 	 					
 	 					if(fnStatus==true)
 	 	 				{
 	 						fnStatus =AccountsPage_CV.confirmingAccountPageNavigation(browser);
 	 						
 	 						if(fnStatus==true)
 	 						{
 	 							ReportEvent.testStepReport(testCaseName, "Pass", "Step-7 was executed successfully.");
 	 						}
 	 						else
 	 						{
 	 							ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute confirmingAccountPageNavigation() method.");
 	 							errorCount++;
 	 						}
 	 	 				}
 	 	 				else
 	 	 				{
 	 	 					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute clickLinkOfSearchResultsSection() method.");
	 						errorCount++;
 	 	 				}
 	 				}
 	 				else
 	 				{
 	 					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute confirmingNavigatedtoSearchResultsPage() method.");
						errorCount++;
 	 				}
 	 			}
 	 			else
 	 			{
 	 				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute clickingSearchButton() method.");
					errorCount++;
 	 			}
 	 		}
 	 		else
 	 		{
 	 			ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute globalSearchText() method.");
				errorCount++;
 	 		}
 		}
 		catch(Throwable t)
 		{
 			System.out.println(t.getMessage());
 			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in step-7 is : "+t.getMessage());
 			errorCount++;
 		}
 		
 	}
 	
 	
 	
 	
 	
 	
	
 	
	public static void step_8(Browser browser, String testCaseName)
	{
		boolean fnStatus = false;
		try
		{
			fnStatus =AccountsPage_CV.clickingNewContractButton(browser);
	 		if(fnStatus==true)
	 		{
	 			fnStatus =  AccountsPage_CV.confirmingNewContractPageNavigation(browser);
	 			if(fnStatus==true)
	 			{
	 				fnStatus = HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
	 				if(fnStatus==true)
	 				{
	 					fnStatus =SearchResultsPage.clickLinkOfSearchResultsSection(browser, sectionName , searchText);
	 					
	 					if(fnStatus==true)
	 	 				{
	 						fnStatus =AccountsPage_CV.confirmingAccountPageNavigation(browser);
	 						
	 						if(fnStatus==true)
	 						{
	 							ReportEvent.testStepReport(testCaseName, "Pass", "Step-7 was executed successfully.");
	 						}
	 						else
	 						{
	 							ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute confirmingAccountPageNavigation() method.");
	 							errorCount++;
	 						}
	 	 				}
	 	 				else
	 	 				{
	 	 					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute clickLinkOfSearchResultsSection() method.");
 						errorCount++;
	 	 				}
	 				}
	 				else
	 				{
	 					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute confirmingNavigatedtoSearchResultsPage() method.");
					errorCount++;
	 				}
	 			}
	 			else
	 			{
	 				ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute clickingSearchButton() method.");
				errorCount++;
	 			}
	 		}
	 		else
	 		{
	 			ReportEvent.testStepReport(testCaseName, "Fail", "Failed to execute clickingNewContractButton() method.");
			errorCount++;
	 		}
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in step-8 is : "+t.getMessage());
			errorCount++;
		}
		
	}
	
	*/
 	

