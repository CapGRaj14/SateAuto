package TestScripts;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Properties;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;

public class TC015_ClaimReopened extends DriverScript{
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String uri = "ws://localhost:5095";
	public static String testCaseName ="Claim Reopened";
	
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	
	
	 @Test
	
	    public static void tc015() throws Throwable
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
		
		 //Loading config.properties file..
		 File f = new File(configFilepath);
	   	 FileReader fr = new FileReader(f);
	   	 Properties prop = new Properties();
	   	 prop.load(fr);
	   	 claimNumber = prop.getProperty("claimID");
	   	 benefitClaimedID=prop.getProperty("benefitID");
			
	   	 
//Step-74
	   	 
	   	 	//Click Edit button
			BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Edit_Button", TCID));
	    	//confirm BC edit page navigation..
			BenefitClaimedPage_CV.confirmingBenefitClaimedEditPageNavigation(testCaseName,browser);
	    	//Change status reason
			BenefitClaimedPage_CV.ChangingStatusReasonDropdownfieldValue(testCaseName,browser,rd.getCellData(DataTable, "StatusReason_Label", TCID),"Reopen"
																				/*rd.getCellData(DataTable, "StatusReason_ClaimReopened", TCID)*/);
			//Click save button
	    	BenefitClaimedPage_CV.clickButtonOfBenefitClaimedEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
			
			
			//Verifying Decision reason field values
			BenefitClaimedPage_CV.verifyingDecisionReasonSecFieldValues(testCaseName, browser, rd.getCellData(DataTable, "Status_Label", TCID),
																				rd.getCellData(DataTable, "StatusReason_Label", TCID),"Pending","Reopened"
																				/*rd.getCellData(DataTable, "Status_Pending", TCID),
																				rd.getCellData(DataTable, "StatusReason_Reopened", TCID)*/);
			//Validate  task in open activities section
			BenefitClaimedPage_CV.validatingNewTaskDisplayedOpenActivitySec(testCaseName,browser,"Benefit Claimed Reopen - State Disability Insurance (00EZ2472)" /*rd.getCellData(DataTable, "OpenActivity_ReopenedTask", TCID)*/);
			
			//Verify column value of open activity section..
			BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName, browser, "Benefit Claimed Reopen - State Disability Insurance (00EZ2472)","Subject","Assigned To","CVTest6 CV_ClaimsHandler_Auto");
				/*rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
				rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_PendingAssignUser", TCID));*/
			
			
			//Validate due business days..
			BenefitClaimedPage_CV.validatingDueBusinessDays(testCaseName, browser,0,"Benefit Claimed Reopen - State Disability Insurance (00EZ2472)","Subject","Last Modified Date","Due Date"); 
				/*Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_SameDay", TCID)),
				rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
				rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID));*/
			 
			
//Step-75
			//Clicking Cls link..
			BenefitClaimedPage_CV.clickingLinkOfOpenActivitySecActionType(testCaseName,browser, "Benefit Claimed Reopen - State Disability Insurance (00EZ2472)" /*rd.getCellData(DataTable, "OpenActivity_ClaimReopened", TCID)*/,"Cls"
																					/*rd.getCellData(DataTable, "OpenActAction_Type", TCID)*/);
			
			//navigation to Task edit page..
			BenefitClaimedPage_CV.confirmingTaskEditPageNavigation(testCaseName, browser);
			//select status drop down value..
			BenefitClaimedPage_CV.selectingStatusDropdownfieldValue(testCaseName,browser, rd.getCellData(DataTable, "TaskInfo_StatusLabel", TCID),"Completed"
																				/*rd.getCellData(DataTable, "TaskInfo_StatusValue", TCID)*/);
//Step-76
			
			//click save button..
			BenefitClaimedPage_CV.clickButtonOfTaskEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
			//navigation to BC page..
			GenericClass.navigationBasedOnH2HeaderText(browser,benefitClaimedID );
			//validate task in activity history section..
			BenefitClaimedPage_CV.verifyNewTaskDisplayedActivityHistory(testCaseName, browser,"Benefit Claimed Reopen - State Disability Insurance (00EZ2472)" /*rd.getCellData(DataTable, "OpenActivity_ClaimReopened", TCID)*/);
			
			/*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/
			String screentitle=browser.getTitle();
			GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	 }
}
