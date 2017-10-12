package TestScripts;

import org.testng.annotations.Test;

import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.ReassignmentPage_CV;

public class TC026_Creating_Tasks_Consult extends DriverScript
{
	
	public static String TCID="CV_026";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	public static String testCaseName="Creating Tasks (Consult)";
	public static String uri = "ws://localhost:5095";
	
	 @Test
	
	    public static void tc018() throws Throwable
	 {
		//LeanfT SDK configurations..
		 GenericClass.sdkConfig(uri);
		//Loading MS access DB.
		 DBnBrowserloading(TCID,DataTable);	
		//Initializing browser with the active screen.
		 browser = GenericClass.createActiveScreenBrowser();
		ReportEvent.testStepReport("", "Info", testCaseName);
		String claimNumber=null;
		String  benefitClaimedID=null;
		
		//Step-147
		
	//*** Click new task button..
		 
		BenefitClaimedPage_CV.clickButtonOfOpenAcivitySec(testCaseName,browser,"New Task" /*rd.getCellData(DataTable, "NewTask_Button", TCID)*/);
		 
	//*** Takes you to New Task screen..
	 GenericClass.navigationBasedOnH2HeaderText(browser,"New Task"/* rd.getCellData(DataTable, "NewTask_Header", TCID)*/);

	//Step-148
	 
	//*** selecting subject task value..
		 BenefitClaimedPage_CV.selectingSubjectValueInNewTaskPage(testCaseName, browser, "Consult: NCM"/*rd.getCellData(DataTable, "Subject_Value", TCID)*/);
		//Checking availability of Template in Comments section
		BenefitClaimedPage_CV.checkingTemplateAvailabilityInComments(testCaseName, browser, "Comments");
		
	//Step-149..
		
		//*** Selecting Due date..
		BenefitClaimedPage_CV.selectingDueDate(testCaseName,browser, "10/11/2017"/*rd.getCellData(DataTable, "Duedate_Value", TCID)*/);

		BenefitClaimedPage_CV.assignUserToTask(benefitClaimedID, browser, "User", "CVTest6 CV_ClaimsHandler_Auto","resultsFrame");
		//Switched to parent window and assigning browser object to parent browser object.
		browser = GenericClass.browserObjectOfParentBrowser();
		
		
		//*** Click Save button..
		 ReassignmentPage_CV.ClickOnButton(browser,"Save","New Task" /*rd.getCellData(DataTable, "Save_Button", TCID), 
					 							rd.getCellData(DataTable, "NewTask_Header", TCID)*/);
		//*** return to BC Screen..
		 BenefitClaimedPage_CV.confirmingBenefitClaimedDetailsPageNavigation(browser);
	
		 

		//*** Verifying new task generated in open activity section..
			BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName, browser,"Consult: NCM (00EZ2468)" /*rd.getCellData(DataTable, "OpenActivity_SubjectTask", TCID)*/);

		
		//Validating assigned user
			 BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser,"Consult: NCM (00EZ2468)","Subject","Assigned To","CVTest6 CV_ClaimsHandler_Auto"
						/*rd.getCellData(DataTable, "OpenActivity_SubjectTaskValue", TCID),
						rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
						rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
						rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID)*/);

		
			//*** Verifying Due date and user date..
			 BenefitClaimedPage_CV.valaidateDuedateAndUserDate(testCaseName, browser, "Consult: NCM (00EZ2468)","Subject","Due Date","10/11/2017"
					 																	/*rd.getCellData(DataTable, "OpenActivity_SubjectTaskValue", TCID), 
																						 rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID), 
																						 rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID), 
																						 rd.getCellData(DataTable, "Duedate_Value", TCID)*/);


		//Step-150
			 
			//Close   Consult: NCM (00EZ2468) task.
			 
			 BenefitClaimedPage_CV.selctCheckBoxBasedOnSubjectValue(testCaseName, browser,"Consult: NCM (00EZ2468)","Check","Close Tasks" /*rd.getCellData(DataTable, "OpenActivity_SubjectTaskValue", TCID),rd.getCellData(DataTable, "CheckBox_Status", TCID), rd.getCellData(DataTable, "CloseTask_Button", TCID)*/);

			 
			//*** Verifying new task generated in open activity section..
			 BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName, browser,"Consult Complete: NCM (00EZ2468)" /*rd.getCellData(DataTable, "SubjectTaskComplete", TCID)*/);
			 
		 
	//Validating 3 due business days by including todays date as well..
	BenefitClaimedPage_CV.validatingDueBusinessDays(benefitClaimedID, browser, 2, "Consult Complete: NCM (00EZ2468)", "Subject", "Last Modified Date", "Due Date");
			 
	//*** Verifying assigned user..
		BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser, "Consult Complete: NCM (00EZ2468)","Subject","Assigned To","CVTest6 CV_ClaimsHandler_Auto"
																					/*rd.getCellData(DataTable, "SubjectTaskComplete", TCID),
																					rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
																					rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
																					rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID)*/);
			
			
		//Step-151
		
		//Select check box based on subject value..
		
		 BenefitClaimedPage_CV.selctCheckBoxBasedOnSubjectValue(testCaseName, browser,"Consult Complete: NCM (00EZ2468)","Check","Close Tasks"/*rd.getCellData(DataTable, "SubjectTaskComplete", TCID),rd.getCellData(DataTable, "CheckBox_Status", TCID), rd.getCellData(DataTable, "CloseTask_Button", TCID)*/);
		 
		 //Checking navigation to BC detail page..
		 BenefitClaimedPage_CV.confirmingBenefitClaimedDetailsPageNavigation(browser);

		 
		//*** Function for validating new tsk displayed in activity history section..
		 BenefitClaimedPage_CV.checkTaskAvailabilityInActivityHistory(testCaseName, browser, "Activity History", "Show", "Consult Complete: NCM (00EZ2468)");

		 
		
		
	 }

}
