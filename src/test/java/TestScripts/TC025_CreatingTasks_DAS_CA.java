package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.sic.base.DriverScript;

import PageObjects.BenefitClaimedPage_CV;

import PageObjects.GenericClass;
import PageObjects.LoginPage_CV;
import PageObjects.ReassignmentPage_CV;

public class TC025_CreatingTasks_DAS_CA extends DriverScript {
	
	public static String TCID="CV_TC020";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="ReassignClaim_BulkReassign";
	public static String uri ="ws://localhost:5095";
	
	@Test
	
    public static void tc025() throws Throwable
 {
		/*isTestCaseRunnable(TCID, DataTable);
		LoginPage_CV.loginToClaimVantage(testCaseName, browser, "test_cv_mgmt_lead_auto@standard.com.int", "Password!1");
		*/
		
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setServerAddress(new URI( uri));
	    SDK.init(config);
	    
	 browser = GenericClass.createActiveScreenBrowser();
	 DBnBrowserloading(TCID, DataTable);
	 
 
//Step 143
	 
//*** Click new task button..
	 
	BenefitClaimedPage_CV.clickButtonOfOpenAcivitySec(testCaseName,browser,"New Task" /*rd.getCellData(DataTable, "NewTask_Button", TCID)*/);
	 
//*** Takes you to New Task screen..
 GenericClass.navigationBasedOnH2HeaderText(browser,"New Task"/* rd.getCellData(DataTable, "NewTask_Header", TCID)*/);

//Step 144
	 
//*** selecting subject task value..
	 BenefitClaimedPage_CV.selectingSubjectValueInNewTaskPage(testCaseName, browser, "DAS/CA Work Request: Other"/*rd.getCellData(DataTable, "Subject_Value", TCID)*/);
	 
//*** Selecting Due date..
	BenefitClaimedPage_CV.selectingDueDate(testCaseName,browser, "10/16/2017"/*rd.getCellData(DataTable, "Duedate_Value", TCID)*/);
	  
//*** Click Save button..
	 ReassignmentPage_CV.ClickOnButton(browser,"Save","New Task" /*rd.getCellData(DataTable, "Save_Button", TCID), 
												rd.getCellData(DataTable, "NewTask_Header", TCID)*/);
	 BenefitClaimedPage_CV.confirmingBenefitClaimedDetailsPageNavigation(browser);
//*** return to BC Screen..
	 
	
//*** Verifying new task generated in open activity section..
	BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName, browser,"DAS/CA Work Request: Other (00EZ2468)" /*rd.getCellData(DataTable, "OpenActivity_SubjectTask", TCID)*/);

	
//*** Verifying Due date and user date..
	 BenefitClaimedPage_CV.valaidateDuedateAndUserDate(testCaseName, browser, "DAS/CA Work Request: Other (00EZ2468)","Subject","Due Date","10/16/2017"
			 																	/*rd.getCellData(DataTable, "OpenActivity_SubjectTaskValue", TCID), 
																				 rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID), 
																				 rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID), 
																				 rd.getCellData(DataTable, "Duedate_Value", TCID)*/);

//*** Verifying assigned user..
	 
	 //DAS/CA Work Request Complete: Other (00EZ2431)
	 BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser,"DAS/CA Work Request: Other (00EZ2468)","Subject","Assigned To","CVTest9 CV_Mgmt_Lead_Auto"
																		/*rd.getCellData(DataTable, "OpenActivity_SubjectTaskValue", TCID),
																		rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
																		rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
																		rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID)*/);

	 //Step 145
//Close the task DAS/CA Work Request: Other..
	 
	 BenefitClaimedPage_CV.selctCheckBoxBasedOnSubjectValue(testCaseName, browser,"DAS/CA Work Request: Other (00EZ2468)","Check","Close Tasks" /*rd.getCellData(DataTable, "OpenActivity_SubjectTaskValue", TCID),rd.getCellData(DataTable, "CheckBox_Status", TCID), rd.getCellData(DataTable, "CloseTask_Button", TCID)*/);
	 //add navigation
	 
//*** Verifying new task generated in open activity section..
		 BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName, browser,"DAS/CA Work Request Complete: Other (00EZ2468)" /*rd.getCellData(DataTable, "SubjectTaskComplete", TCID)*/);
		 
//*** Verifying assigned user..
BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser, "DAS/CA Work Request Complete: Other (00EZ2468)","Subject","Assigned To","CVTest9 CV_Mgmt_Lead_Auto"
																			/*rd.getCellData(DataTable, "SubjectTaskComplete", TCID),
																			rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
																			rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
																			rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID)*/);
													//Edwin Otero
//Step 146
//*** Close the task DAS/CA Work Request: complete Other..

	 BenefitClaimedPage_CV.selctCheckBoxBasedOnSubjectValue(testCaseName, browser,"DAS/CA Work Request Complete: Other (00EZ2468)","Check","Close Tasks"/*rd.getCellData(DataTable, "SubjectTaskComplete", TCID),rd.getCellData(DataTable, "CheckBox_Status", TCID), rd.getCellData(DataTable, "CloseTask_Button", TCID)*/);
	 BenefitClaimedPage_CV.confirmingBenefitClaimedDetailsPageNavigation(browser);

//*** Function for validating new tsk displayed in activity history section..
	 BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName, browser, "DAS/CA Work Request Complete: Other (00EZ2468)"/*rd.getCellData(DataTable, "SubjectTaskComplete", TCID)*/);
 }
}
