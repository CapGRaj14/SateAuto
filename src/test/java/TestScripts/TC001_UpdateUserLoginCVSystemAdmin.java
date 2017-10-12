package TestScripts;

import org.testng.annotations.Test;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.AccountsPage_CV;
import PageObjects.BenefitClaimedPage_CV;
import PageObjects.HomePage_CV;
import PageObjects.UpDateUser_CV;

public class TC001_UpdateUserLoginCVSystemAdmin extends DriverScript {
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	
	@Test
    
    public static void tc01() throws Throwable{
    	
		String testCaseName = "";
		
		//DBnBrowserloading(TCID, DataTable,"Contracts: Home ~ Salesforce - Unlimited Edition");
		//browser.highlight();
		isTestCaseRunnable(TCID, DataTable);
    	ReportEvent.testStepReport("", "Info", "Update User Login");
    	
    	/*LoginPage_CV.loginToClaimVantage(browser, rd.getCellData(DataTable, "tUserName", TCID), 
    											  rd.getCellData(DataTable, "tPassword", TCID));*/
    
    	 //Thread.sleep(7000);
    	BrowserDescription des=new BrowserDescription();
    	Browser[] brs = BrowserFactory.getAllOpenBrowsers(des);
    	brs[0].highlight();
    	browser =brs[0];
    	
    	/*HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Tab", TCID));
    	UpDateUser_CV.confirmingEditUserPage(browser);
    	UpDateUser_CV.selectingNameFromSearchCreteriaWindowFrame(browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));
    	UpDateUser_CV.clickButtonOfSearchResultsPage(browser, rd.getCellData(DataTable, "Search_Button", TCID));
    	//UpDateUser_CV.checkingSearchCriteriaSecFields(browser, rd.getCellData(DataTable, "SearchCriteria_SecFields", TCID));
    	UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
    	UpDateUser_CV.clickButtonOfSearchResultsPage(browser, rd.getCellData(DataTable, "Next_Button", TCID));
    	UpDateUser_CV.confirmingUpdateUserPage(browser);
    	UpDateUser_CV.selectingApproverForApprovalsFromSearchCreteriaWindowFrame(browser, rd.getCellData(DataTable, "SearchCriteria_ApprovalName", TCID));
    	UpDateUser_CV.clickButtonOfEditUserPage(browser, rd.getCellData(DataTable, "Update_Button", TCID));
    	//BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(browser, rd.getCellData(DataTable, "Dialog_Button", TCID));
    	UpDateUser_CV.verifyingUpdatedMessage(browser, rd.getCellData(DataTable, "Message_Text", TCID));
    	*/
    	ReportEvent.testStepReport("", "Info", "Add New Contract");
    	
    	 HomePage_CV.enteringSearchText(browser,  rd.getCellData(DataTable, "Account_Name", TCID));
    	 HomePage_CV.clickingSearchButton(testCaseName, browser);
    	 AccountsPage_CV.confirmingAccountPageNavigation(browser);
    	 AccountsPage_CV.clickingNewContractButton(browser);
    	 AccountsPage_CV.confirmingNewContractPageNavigation(browser);
    	 AccountsPage_CV.checkingContractInfoSecFields(browser, rd.getCellData(DataTable, "Contract_InfoFields", TCID));
    	 AccountsPage_CV.enteringContactNumber(browser, /*Contract Number*/rd.getCellData(DataTable, "ContractNumber_Label", TCID), rd.getCellData(DataTable, "Contract_Number", TCID));
    	 AccountsPage_CV.clickButtonOfContractEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
    	 AccountsPage_CV.confirmingContractDetailPageNavigation(browser);
    	 AccountsPage_CV.checkingContractDetailSecFields(browser, rd.getCellData(DataTable, "ContractDetail_Fields", TCID));
    	 
	    
    	
    	/*ReportEvent.testStepReport("", "Info", "Assigned Account Users");
    	
    	HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Tab1", TCID));
    	AccountsPage_CV.confirmingAccountsPageNavigation(browser);
    	ContactsPage_CV.clickingViewDropDown(browser);
    	ContactsPage_CV.selectingView(browser, rd.getCellData(DataTable, "ViewValue", TCID));
    	//ContactsPage_CV.clickingGoButton(browser);
    	AccountsPage_CV.clickingAccountNameFromTable(browser, rd.getCellData(DataTable, "Account_Name", TCID));
    	AccountsPage_CV.confirmingAccountPageNavigation(browser);
    	
    	AccountsPage_CV.clickingActionTypeOfAssignedAccountUserSec(browser, rd.getCellData(DataTable, "AssignedAccount1", TCID), 
    																		rd.getCellData(DataTable, "Action_Value", TCID));
    	BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(browser,rd.getCellData(DataTable, "Dialog_Button", TCID));
    	AccountsPage_CV.clickingActionTypeOfAssignedAccountUserSec(browser, rd.getCellData(DataTable, "AssignedAccount2", TCID), 
    																		rd.getCellData(DataTable, "Action_Value", TCID));
    	BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(browser, rd.getCellData(DataTable, "Dialog_Button", TCID));

    	AccountsPage_CV.clickingNewAssignedAccountUserButton(browser);
    	AccountsPage_CV.confirmingNewAssignedAccountUserPageNavigation(browser);
    	AccountsPage_CV.fillingAssignedAccountUserInfoFields(browser, rd.getCellData(DataTable, "ClaimComplexity_Available", TCID),rd.getCellData(DataTable, "BenefitType_Available", TCID));
    	UpDateUser_CV.selectingUserNameFromAssignedUserWindowFrame(browser, rd.getCellData(DataTable, "SearchCriteria_Name", TCID));
    	AccountsPage_CV.clickButtonOfAssignedAccountUserEditPage(browser,rd.getCellData(DataTable, "SaveButton", TCID));
    	AccountsPage_CV.checkingAssignedAccountUserDetailSecFields(browser, rd.getCellData(DataTable, "AssignedAccountDetail_Fields", TCID));
    	AccountsPage_CV.clickingAccountNameAssignedAccUserDetailPage(browser, rd.getCellData(DataTable, "AssignedAccount_FieldName", TCID));
    	
    	//Adding two steps......
   	
    	/////Assigned Policy users////////////
    	ReportEvent.testStepReport("", "Info", "Assigned Policy Users");
    	
    	HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Tab1", TCID));
    	AccountsPage_CV.confirmingAccountsPageNavigation(browser);
    	ContactsPage_CV.selectingView(browser, rd.getCellData(DataTable, "ViewValue", TCID));
    	AccountsPage_CV.clickingAccountNameFromTable(browser, rd.getCellData(DataTable, "Account_Name", TCID));
    	AccountsPage_CV.confirmingAccountPageNavigation(browser);
    	AccountsPage_CV.clickingContactPaneNameFromTable(browser, 
										    		rd.getCellData(DataTable, "ContactPage_Title", TCID),
										    		rd.getCellData(DataTable, "ContactFrame_Name", TCID),
										    		rd.getCellData(DataTable, "Contact_Name", TCID));
    	AccountsPage_CV.clickingLinkOfPolicyRelationship(browser, rd.getCellData(DataTable, "NewPolicy_Id", TCID));
    	AccountsPage_CV.confirmingPolicyDetailPageNavigation(browser, rd.getCellData(DataTable, "NewPolicy_Id", TCID));
    	AccountsPage_CV.clickingNewAssignedPolicyUserButton(browser);
    	AccountsPage_CV.confirmingNewAssignedPolicyUserPageNavigation(browser);
    	AccountsPage_CV.fillingAssignedPolicyUserInfoFields(browser, rd.getCellData(DataTable, "ClaimComplexity_Available", TCID),rd.getCellData(DataTable, "BenefitType_Available", TCID));
    	AccountsPage_CV.selectingUserNameFromAssignedPolicyWindowFrame(browser, rd.getCellData(DataTable, "SearchCriteria_ApprovalName", TCID));
    	AccountsPage_CV.clickButtonOfAssignedPolicyUserEditPage(browser,rd.getCellData(DataTable, "SaveButton", TCID));
    	AccountsPage_CV.checkingAssignedPolicyUserDetailSecFields(browser, rd.getCellData(DataTable, "AssignedPolicyDetail_Fields", TCID));
    	
    	//Have to include steps///////
    	
    
    	ReportEvent.testStepReport("", "Info", "Create Contact");
    	
    	HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Tab1", TCID));
    	AccountsPage_CV.confirmingAccountsPageNavigation(browser);
    	ContactsPage_CV.selectingView(browser, rd.getCellData(DataTable, "ViewValue", TCID));
    	AccountsPage_CV.clickingAccountNameFromTable(browser, rd.getCellData(DataTable, "Account_Name", TCID));
    	AccountsPage_CV.confirmingAccountPageNavigation(browser);
    	AccountsPage_CV.clickingNewConatctButton(browser,	rd.getCellData(DataTable, "ContactPage_Title", TCID),
	    													rd.getCellData(DataTable, "ContactFrame_Name", TCID));
    	ContactsPage_CV.confirmingNewContactPageNavigation(browser);
    	ContactsPage_CV.selectingRecordType(browser, "Claimant");
    	ContactsPage_CV.clickingContinueButton(browser);
    	ContactsPage_CV.confirmingContactEditPageNavigation(browser);

    	ContactsPage_CV.fillingContactInfoFieldsClaimantType(browser,rd.getCellData(DataTable, "Contact_FirstNameLabel", TCID),
				
																		rd.getCellData(DataTable, "Contact_NameSolution", TCID),
																		rd.getCellData(DataTable, "Contact_FirstName", TCID),
																		rd.getCellData(DataTable, "Contact_LastNameLabel", TCID),
																		rd.getCellData(DataTable, "Contact_LastName", TCID),
																		rd.getCellData(DataTable, "Contact_SSNumberLabel", TCID),
																		rd.getCellData(DataTable, "Contact_SSNumber", TCID),
																		rd.getCellData(DataTable, "Contact_BirthDate", TCID),
																		rd.getCellData(DataTable, "Contact_GenderLabel", TCID),
																		rd.getCellData(DataTable, "Contact_Gender", TCID));
				
    	ContactsPage_CV.fillingAddressInfoFieldsClaimantType(browser, 
														    			rd.getCellData(DataTable, "Address_MailingStreetLabel", TCID),
																		rd.getCellData(DataTable, "Address_MailingStreet", TCID),
																		rd.getCellData(DataTable, "Address_MailingCityLabel", TCID),
																		rd.getCellData(DataTable, "Address_mailingCity", TCID),
																		rd.getCellData(DataTable, "Address_MailingStateLabel", TCID),
																		rd.getCellData(DataTable, "Address_MailingState", TCID));
				
    	ContactsPage_CV.clickButtonOfContactEditPage(browser, rd.getCellData(DataTable, "SaveButton", TCID));
    	
    	ReportEvent.testStepReport("", "Info", "Creating a Claim");
    	
    	HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Claims_Tab", TCID));
    	ClaimsPage_CV.confirmingClaimsPageNavigation(browser);
    	ClaimsPage_CV.clickingNewButton(browser);
    	ClaimsPage_CV.confirmingNewClaimPageNavigation(browser);
    	ClaimsPage_CV.verifyingStatusDropdownFieldAsPending(browser,rd.getCellData(DataTable, "Claims_StatusDropdown", TCID));
    	ClaimsPage_CV.verifyingStatusFieldsAsRequired(browser);
    	ClaimsPage_CV.clickButtonOfClaimEditPage(browser, rd.getCellData(DataTable, "SaveButton", TCID));
    	//ClaimsPage_CV.verifyingCreatedClaimNumber(browser, rd.getCellData(DataTable, "ClaimNumber_FieldName", TCID));
    	ClaimsPage_CV.clickingNewClaimRelationshipButton(browser);
    	ClaimsPage_CV.confirmingNewClaimRelationshipPageNavigation(browser);
    	ClaimsPage_CV.checkingClaimRelationshipSecFields(browser, rd.getCellData(DataTable, "ClaimRelationship_SecFields", TCID));
    	ClaimsPage_CV.selectingContactNameFromClaimRelationshipWindowFrame(browser, rd.getCellData(DataTable, "ClaimRelship_ConatctName", TCID));
    	ClaimsPage_CV.selectingRelationshipDropdownValue(browser,rd.getCellData(DataTable, "ClaimRelationship_Type", TCID),rd.getCellData(DataTable, "ClaimRelationship_PendingValue", TCID));
    	ClaimsPage_CV.clickButtonOfClaimRelationshipEditPage(browser,  rd.getCellData(DataTable, "SaveButton", TCID));
    	ClaimsPage_CV.checkingClaimRelShipDetailSecFields(browser, rd.getCellData(DataTable, "ClaimRelationship_DetailsSecFields", TCID));
    	///// have to add claim clicking step/////
    	ClaimsPage_CV.confirmingClaimPageNavigation(browser);
    	ClaimsPage_CV.verifyContactNameDisplayedClaimRelSection(browser, rd.getCellData(DataTable, "ClaimRelationship_Contact", TCID));
    	ClaimsPage_CV.clickingNewClaimRelationshipButton(browser);
    	ClaimsPage_CV.confirmingNewClaimRelationshipPageNavigation(browser);
    	ClaimsPage_CV.checkingClaimRelationshipSecFields(browser, rd.getCellData(DataTable, "ClaimRelationship_SecFields", TCID));
    	ClaimsPage_CV.selectingAccountNameFromClaimRelationshipWindowFrame(browser, rd.getCellData(DataTable, "ClaimRelship_AccountName", TCID));
    	ClaimsPage_CV.selectingRelationshipDropdownValue(browser,rd.getCellData(DataTable, "ClaimRelationship_Type", TCID),rd.getCellData(DataTable, "ClaimRelationship_PolicyValue", TCID));
    	ClaimsPage_CV.clickButtonOfClaimRelationshipEditPage(browser,  rd.getCellData(DataTable, "SaveButton", TCID));
    	ClaimsPage_CV.checkingClaimRelShipDetailSecFields(browser, rd.getCellData(DataTable, "ClaimRelationship_DetailsSecFields", TCID));
    	///// have to add claim clicking step/////
    	ClaimsPage_CV.confirmingClaimPageNavigation(browser);
    	ClaimsPage_CV.verifyAccountNameDisplayedClaimRelSection(browser, rd.getCellData(DataTable, "ClaimRelationship_Account", TCID));
    	
	*/
    	 
    	 /*AccountsPage_CV.clickingContactPaneNameFromTable(browser, 
 		rd.getCellData(DataTable, "ContactPage_Title", TCID),
 		rd.getCellData(DataTable, "ContactFrame_Name", TCID),
 		rd.getCellData(DataTable, "Contact_Name", TCID));*/
	}

}
