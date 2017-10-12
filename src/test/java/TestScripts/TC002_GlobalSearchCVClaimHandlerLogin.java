package TestScripts;

import org.testng.annotations.Test;


import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.ClaimsPage_CV;
import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.LoginPage_CV;
import PageObjects.UpDateUser_CV;

public class TC002_GlobalSearchCVClaimHandlerLogin extends DriverScript {
	
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="GLobal Search CV Claim Handler Login";
	
	
	 @Test
	
	    public static void tc02() throws Throwable{
	    	
		 isTestCaseRunnable(TCID, DataTable);
	    	
	    	
	    	ReportEvent.testStepReport("", "Info", "GLobal Search CV Claim Handler Login");
	    /*	LoginPage_CV.loginToClaimVantage(browser, rd.getCellData(DataTable, "tUserName", TCID), 
	    											  rd.getCellData(DataTable, "tPassword", TCID));*/
	    	Thread.sleep(10000);
	    	BrowserDescription des=new BrowserDescription();
	    	Browser[] brs = BrowserFactory.getAllOpenBrowsers(des);
	    	brs[0].highlight();
	    	browser=brs[0];
	    	
	    	/*HomePage_CV.enteringSearchText(browser,  rd.getCellData(DataTable, "Search_Text", TCID));
	    	HomePage_CV.clickingSearchButton(browser);
	    	HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
	    	ContactsPage_CV.clickingSearchContactNameInContactSec(browser, rd.getCellData(DataTable, "Contact_Name", TCID));
	    	ContactsPage_CV.confirmingContactPageNavigation(browser);
	    	
	    	String screentitle=browser.getTitle();
	    	System.out.println(screentitle);
	    	
	    	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	    	
	    	browser = GenericClass.createActiveScreenBrowser();
	    	
	    	///////////////////////////
	    	ReportEvent.testStepReport("", "Info", "Creating a Claim");
	    	
	    	ContactsPage_CV.clickingClaimOfClaimRelationshipSec(browser, rd.getCellData(DataTable, "Claim_Number", TCID));
	    	ContactsPage_CV.confirmingClaimIDPageNavigation(browser, rd.getCellData(DataTable, "Claim_Number", TCID));
	    	
	    	ContactsPage_CV.clickingAddBenefitClaimedButton(browser);
	    	ContactsPage_CV.confirmingSearchAccounPolicyPageNavigation(browser);
	    	BenefitClaimedPage_CV.fillingSearchCriteriaSecFields(browser,	rd.getCellData(DataTable, "GroupID_Label", TCID),
															    			rd.getCellData(DataTable, "GroupID", TCID),
															    			rd.getCellData(DataTable, "Policy_Label", TCID),
															    			rd.getCellData(DataTable, "Policy_Id", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedCreationPage(browser, rd.getCellData(DataTable, "Search_Button", TCID));
	    	ContactsPage_CV.refreshingSearchResultsPage(browser);
	    	UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedCreationPage(browser, rd.getCellData(DataTable, "Next_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingSelectBenefitPageNavigation(browser);
	    	UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
	    	BenefitClaimedPage_CV.clickButtonOfSelectBenefitPage(browser,  rd.getCellData(DataTable, "Next_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedCreationDetailPageNavigation(browser);
	    	////////////////////////
	    	
	    	BenefitClaimedPage_CV.UpdatingBenefitClaimedSectionFields(browser,	rd.getCellData(DataTable, "ProclaimClient_Label", TCID),
																    			rd.getCellData(DataTable, "ProclaimClient_ID", TCID),
																    			rd.getCellData(DataTable, "Assign_Label", TCID),
																    			rd.getCellData(DataTable, "Assign_Checkbox", TCID),
																    			rd.getCellData(DataTable, "AssignUser_Textbox", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailsPage(browser,  rd.getCellData(DataTable, "Create_Button", TCID));
	    	BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(browser, rd.getCellData(DataTable, "Dialog_Button", TCID));
	    	
	    	
	    	ReportEvent.testStepReport("", "Info", "Creating a Benefit Claim/Assigned Account Users");
	    	
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(browser);
	   
	    	BenefitClaimedPage_CV.verifyingCurrentBenefitClaimedSectionAvailability(browser);
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	        BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(browser,rd.getCellData(DataTable, "Status_For_Approval", TCID),
	    																	rd.getCellData(DataTable, "Decision_Reason", TCID)  );
	    /////////// Have to include Row 48 step ///////////////
	    	
	    	//Incomplete Claim Review
	      	ReportEvent.reportStepInfo("Incomplete Claim Review");
	    	*/
	    	/////////// Have to include failed steps ///////////////
	    
	    	//ReportEvent.testStepReport("", "Info", "Anticipatory Claim Review");
	    	HomePage_CV.enteringSearchText(browser, "BC-2017-1095169" /*rd.getCellData(DataTable, "Search_Text", TCID)*/);
	    	HomePage_CV.clickingSearchButton(testCaseName,browser);
	    	BenefitClaimedPage_CV.clickingBenefitClaimedIdInSearchResultsPage(browser, "BC-2017-1095169");
	    	/*BenefitClaimedPage_CV.validatingDueBusinessDays(browser, 2, "Intake Incomplete Review: Need Employer Statement (00EZ2432)", "Subject","Last Modified Date" ,"Due Date");*/
	    	//BenefitClaimedPage_CV.validatingDueBusinessDaysInprogress(browser, 2, "Intake Incomplete Review: Need Employer Statement (00EZ2432)", "Subject","Last Modified Date", "Due Date");
	    	
	    	
	    	
	    	
	    	/*BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , rd.getCellData(DataTable, "StatusReason_Value", TCID) );
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	BenefitClaimedPage_CV.vefiryingDecisionReasonSecFieldValues(browser, rd.getCellData(DataTable, "Status_Label", TCID), rd.getCellData(DataTable, "StatusReason_Label", TCID));
	    	BenefitClaimedPage_CV.clickingLinkOfOpenActivitySecActionType(browser,  rd.getCellData(DataTable, "OpenActivity_Subject", TCID),
																					rd.getCellData(DataTable, "OpenActAction_Type", TCID));
	    	BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.verifyingStatusDropdownfieldValue(browser, rd.getCellData(DataTable, "Status_Label", TCID),
																			rd.getCellData(DataTable, "Status_Value", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(browser);
	    	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(browser,rd.getCellData(DataTable, "ActivityHistory_Subject", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.selectingLastWorkDate(browser, rd.getCellData(DataTable, "LostWork_DatePast", TCID));
	    	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , rd.getCellData(DataTable, "StatusReason_Value", TCID) );
	    	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	
	    	/////////// Have to include failed steps ///////////////
	    	
	    	ReportEvent.testStepReport("", "Info", "Claim Pending");
	    	
	    	BenefitClaimedPage_CV.clickingAllCheckboxOpenActivitySec(browser, rd.getCellData(DataTable, "CheckBox_Status", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfOpenActivitySection(browser, rd.getCellData(DataTable, "CloseTask_Button", TCID));
	    	BenefitClaimedPage_CV.refreshingBenefitClaimedPage(browser);
	    //	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(browser, subjectValue);
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(browser, rd.getCellData(DataTable, "StatusForApproval_ClaimPending", TCID) , rd.getCellData(DataTable, "DecisionReason_ClaimPending", TCID) );
	    	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , rd.getCellData(DataTable, "StatusReason_ClaimPending", TCID) );
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	
	    	///have to include expected results/////////////////////////////
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(browser,rd.getCellData(DataTable, "StatusReason_Label", TCID) , rd.getCellData(DataTable, "StatusReason_ClaimPending1", TCID) );
	    	///have to include expected results/////////////////////////////
	    */
	    /*	
	    	ReportEvent.testStepReport("", "Info", "Claim Denied");
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(browser, rd.getCellData(DataTable, "StatusForApproval_ClaimDenied", TCID),rd.getCellData(DataTable, "DecisionReason_ClaimDenied", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	
	    	//Have to include Error message method///////////////
	    	 BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Cancel_Button", TCID));
	    	BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(browser, rd.getCellData(DataTable, "Dialog_Button", TCID));
	    	
	    	//have to include two steps//////
	    	
	    	BenefitClaimedPage_CV.clickingActionTypeOfOpenActivitiesSec(browser,rd.getCellData(DataTable, "OpenActivities_SubjectValue", TCID),
	    																	rd.getCellData(DataTable, "OpenActivities_ActionType", TCID));
	    	
	    	BenefitClaimedPage_CV.confirmingCommunicateDeniedDecisionPageNavigation(browser);
	    	BenefitClaimedPage_CV.verifyingStatusDropdownfieldValue(browser, rd.getCellData(DataTable, "Status_Label", TCID),
																			rd.getCellData(DataTable, "Status_Value", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfTaskEditPage(browser, rd.getCellData(DataTable, "Button_Name6", TCID));
	    	BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(browser, rd.getCellData(DataTable, "ActivityHistory_Subject", TCID));
	    	*/
	    	///Upload Document (1)

	    /*	ReportEvent.testStepReport("", "Info", "Upload Document (1)");
	    	
	    	BenefitClaimedPage_CV.clickingNewDocumentsButton(browser);
	    	BenefitClaimedPage_CV.confirmingNewDocumentPageNavigation(browser);
	    	BenefitClaimedPage_CV.checkingDocumentEditScreenSecFields(browser, rd.getCellData(DataTable, "DocumentSection_Fields", TCID));
	    	BenefitClaimedPage_CV.verifyingAutoPapulatedValues(browser);
	    	BenefitClaimedPage_CV.fillingRequiredFieldsInDocumentInfo(browser, 
										    			rd.getCellData(DataTable, "Document_Label", TCID),
														rd.getCellData(DataTable, "Document_Name", TCID),
														rd.getCellData(DataTable, "Type_Label", TCID),
														rd.getCellData(DataTable, "Type_Value", TCID),
														rd.getCellData(DataTable, "DocumentType_Label", TCID),
														rd.getCellData(DataTable, "DocumentType_Value", TCID),
														rd.getCellData(DataTable, "Document_ReceivedDate", TCID));
	    	BenefitClaimedPage_CV.clickButtonOfDocumentEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingDocumentPageNavigation(browser);
	    	BenefitClaimedPage_CV.checkingButtonsInDocumentDetailPage(browser, rd.getCellData(DataTable, "Document_InputButtons", TCID));
			BenefitClaimedPage_CV.clickButtonOfDocumentDetailsPage(browser, rd.getCellData(DataTable, "Document_AttachButton", TCID))	;
			BenefitClaimedPage_CV.confirmingAttachFilePageNavigation(browser);
			BenefitClaimedPage_CV.browseToAttachFileFromComputer(browser, rd.getCellData(DataTable, "Document_ChooseButton", TCID), rd.getCellData(DataTable, "FileLocation", TCID), rd.getCellData(DataTable, "Document_AttachFileButton", TCID));
			BenefitClaimedPage_CV.confirmingAttachFileHeaderPageNavigation(browser);
			BenefitClaimedPage_CV.clickingDoneButton(browser);
			BenefitClaimedPage_CV.clickingBenefitClaimedLink(browser);
			BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(browser);
			/////////////have to include Due date functionality////////////////
			
			ReportEvent.testStepReport("", "Info", "Claim Reopened");
			
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(browser,rd.getCellData(DataTable, "StatusReason_Label", TCID),
																				rd.getCellData(DataTable, "StatusReason_ClaimReopened", TCID));
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
			BenefitClaimedPage_CV.vefiryingDecisionReasonSecFieldValues(browser, rd.getCellData(DataTable, "Status_Label", TCID),
																				rd.getCellData(DataTable, "StatusReason_Label", TCID));
			
			//////Have to include expected results/////last line
			BenefitClaimedPage_CV.clickingLinkOfOpenActivitySecActionType(browser,  rd.getCellData(DataTable, "OpenActivity_ClaimReopened", TCID),
																					rd.getCellData(DataTable, "OpenActAction_Type", TCID));
			BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(browser);
			BenefitClaimedPage_CV.verifyingStatusDropdownfieldValue(browser, rd.getCellData(DataTable, "TaskInfo_StatusLabel", TCID),
																				rd.getCellData(DataTable, "TaskInfo_StatusValue", TCID));
			BenefitClaimedPage_CV.clickButtonOfTaskEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
			BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(browser);
			BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(browser, rd.getCellData(DataTable, "OpenActivity_ClaimReopened", TCID));
		*/	
			/*
			ReportEvent.testStepReport("", "Info", "Claim Approved");
			
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
	    	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(browser, rd.getCellData(DataTable, "StatusForApproval_ClaimApproved", TCID) , rd.getCellData(DataTable, "DecisionReason_ClaimApproved", TCID) );
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	
			
	    	BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(browser,rd.getCellData(DataTable, "StatusForApproval_ClaimApproved", TCID) , rd.getCellData(DataTable, "DecisionReason_ClaimApproved", TCID) );
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	BenefitClaimedPage_CV.checkingErrormesg( browser, "Error: Last Worked Required,Error: Date of Disability Required,Error: Last 2 Amendments Required,Error: Cannot set Status For Approval to Approved as Certified Through Required, Benefit Start Required,Error: Benefit Through Required,Error: LTD Coverage with The Standard Required,Error: Life Coverage with The Standard Required");
	    	
			
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "BenefitDetail_EditButton", TCID));
			BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(browser);
			BenefitClaimedPage_CV.updatingDecisionReasonFieldValues(browser,rd.getCellData(DataTable, "StatusApproval_Value", TCID),
																			rd.getCellData(DataTable, "DecisionReason_Value", TCID));
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(browser,  rd.getCellData(DataTable, "SaveButton", TCID));
			BenefitClaimedPage_CV.sectionErrorMessagesValidation(browser, " Last 2 Amendments  Required, Cannot set Status For Approval to Approved as Certified Through Required, Benefit Through Required, LTD Coverage with The Standard Required, Life Coverage with The Standard Required");
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(browser, rd.getCellData(DataTable, "BenefitDetail_CancelButton", TCID));
			BenefitClaimedPage_CV.confirmingBenefitClaimedPageNavigation(browser);
			BenefitClaimedPage_CV.clickingCustomLinkOfBenefitClaimedPage(browser, rd.getCellData(DataTable, "CaseMagt_Link", TCID));
			BenefitClaimedPage_CV.confirmingCaseManagementPageNavigation(browser);
			BenefitClaimedPage_CV.clickingOccupationalTab(browser);
			BenefitClaimedPage_CV.isOccupationalSectionAvailability(browser);
			BenefitClaimedPage_CV.fillingOccupationalItemsFields(browser, rd.getCellData(DataTable, "Occupational_TitleLabel", TCID),
																			rd.getCellData(DataTable, "Occupational_Title", TCID),
																			rd.getCellData(DataTable, "Occupational_JobClass", TCID),
																			rd.getCellData(DataTable, "Occupational_Job", TCID));
			BenefitClaimedPage_CV.clickButtonOfOccupationalSec(browser,  rd.getCellData(DataTable, "SaveButton", TCID));
			
*/










	    	
	 }
}
