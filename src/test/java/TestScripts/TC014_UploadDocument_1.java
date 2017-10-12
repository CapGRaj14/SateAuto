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
import PageObjects.ClaimsPage_CV;
import PageObjects.GenericClass;
import PageObjects.LoginPage_CV;

public class TC014_UploadDocument_1 extends DriverScript {
	
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	public static String uri = "ws://localhost:5095";
	public static String testCaseName ="Upload Document (1)";
	
	 @Test
	
	    public static void tc014() throws Throwable
	 {
		

		 
		//LeanfT SDK configurations..
		 GenericClass.sdkConfig(uri);

		//LeanfT SDK configurations..
		 ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
			config.setServerAddress(new URI( uri));
		    SDK.init(config);

		//Loading MS access DB.
		 DBnBrowserloading(TCID,DataTable);	
		//Initializing browser with the active screen.
		 browser = GenericClass.createActiveScreenBrowser();
		 
		ReportEvent.testStepReport("", "Info", testCaseName);
		
		
		String claimNumber=null;
		String  benefitClaimedID=null;
		
		 
//Step-69

		//Function for Clicking New Document button in Documents section...
	    	BenefitClaimedPage_CV.clickingNewDocumentsButton(testCaseName,browser);
	    	//Function for confirming New Document page navigation..
	    	BenefitClaimedPage_CV.confirmingNewDocumentPageNavigation(testCaseName,browser);
	    	
	    	//Loading config.properties file..
	     File f = new File(configFilepath);
	   	 FileReader fr = new FileReader(f);
	   	 Properties prop = new Properties();
	   	 prop.load(fr);
	   	 claimNumber = prop.getProperty("claimID");
	   	 benefitClaimedID=prop.getProperty("benefitID");
	   	
	   	 //Function to validate auto populated Claim ID in Document details section..
	    	 ClaimsPage_CV.validateAutoPopulatedClaimId(testCaseName, browser, "Claim", claimNumber);
	    	//Function to validate auto populated Benefit Claimed ID with input data..
	    	 ClaimsPage_CV.validatePopulatedBenefitId(testCaseName, browser, "Benefit Claimed", benefitClaimedID);
	    	//Function for checking required field in document details section based on labels..
	    	 ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(testCaseName, browser, "Document Name");
	    	 ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(testCaseName, browser, "Type");
	    	 ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(testCaseName, browser, "Claim");
	    	 ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(testCaseName, browser, "Benefit Claimed");
	    	 ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(testCaseName,browser, "Document Type");
	    	 ClaimsPage_CV.checkRequiredFieldAvailabilityDocumentDetailsSec(testCaseName,browser, "Document Received Date");
//Step-70	   
	    	 
	    	 //Function for filling required fields in document edit screen based on user inputs..


	    	BenefitClaimedPage_CV.fillingRequiredFieldsInDocumentInfo(testCaseName,browser,"Document Name","CV_MedicalDoc","Type","Medical","Document Type","MEDICAL_RECORDS","Document Description","MEDICAL_RECORDS","10/29/2017" 

										    			/*rd.getCellData(DataTable, "Document_Label", TCID),
														rd.getCellData(DataTable, "Document_Name", TCID),
														rd.getCellData(DataTable, "Type_Label", TCID),
														rd.getCellData(DataTable, "Type_Value", TCID),
														rd.getCellData(DataTable, "DocumentType_Label", TCID),
														rd.getCellData(DataTable, "DocumentType_Value", TCID),
														rd.getCellData(DataTable, "Document_ReceivedDate", TCID)*/);
	    	
	    	//Function to click on Save button of "Task Edit", Page based on the user inputs..
	    	BenefitClaimedPage_CV.clickButtonOfDocumentEditPage(testCaseName, browser, rd.getCellData(DataTable, "Save_Button", TCID));
	    	//Navigation to medical doc page..
	    	GenericClass.navigationBasedOnH2HeaderText(browser, "CV_MedicalDoc");
	    	//Function for checking Saved changes in Document details section..

	    BenefitClaimedPage_CV.checkingUpdatedValuesInDocumentDetailsSec(testCaseName, browser, "Document Name","Type","Document Type","Document Description","CV_MedicalDoc,Medical,MEDICAL_RECORDS,MEDICAL_RECORDS");
	    	
	    	//Function for verifying the buttons in Document Details section based on user inputs..
	    BenefitClaimedPage_CV.checkingButtonsInDocumentDetailPage(testCaseName, browser, rd.getCellData(DataTable, "Document_InputButtons", TCID));
	    	
//Step-71
	    	//Function for Clicking Done button in Attachment file section...
			BenefitClaimedPage_CV.clickButtonOfDocumentDetailsPage(testCaseName, browser, rd.getCellData(DataTable, "Document_AttachButton", TCID))	;
			//confirming Attach File to Document SampleDoc page navigation..
			BenefitClaimedPage_CV.confirmingAttachFilePageNavigation(testCaseName, browser,"CV_MedicalDoc");			
	   	 	
//Step-72			
			//Function for Click Browse to attach file from computer, click Attach file, then click Done.
			BenefitClaimedPage_CV.browseToAttachFileFromComputer(testCaseName, browser, rd.getCellData(DataTable, "Document_ChooseButton", TCID), rd.getCellData(DataTable, "FileLocation", TCID), rd.getCellData(DataTable, "Document_AttachFileButton", TCID));
			//Function for confirming Attach File page navigation..
			BenefitClaimedPage_CV.confirmingAttachFileHeaderPageNavigation(testCaseName, browser);
			//Function for Clicking Done button in Uploding the document...
			BenefitClaimedPage_CV.clickingDoneButton(testCaseName, browser);
	   	 	//Navigation to Medical doc page..
			GenericClass.navigationBasedOnH2HeaderText(browser, "CV_MedicalDoc");
			//Function for verifying the view attachment link related to view document..
			BenefitClaimedPage_CV.verifyingViewAttachmentLinkInDocumentDetailPage(testCaseName, browser, "View Document", "View Attachment");
//Step-73
			
			//Function for Clicking Benefit Claimed id in Document  Detail section field  based on label..
			BenefitClaimedPage_CV.clickingBenefitClaimedID(testCaseName,browser, "Benefit Claimed");
			//navigation to BC page
			GenericClass.navigationBasedOnH2HeaderText(browser,benefitClaimedID );
			
			//Function for validating the AssignTo user name Open Activity section based on header name..
			 BenefitClaimedPage_CV.verifyingColumnValueOFOpenActivitySec(testCaseName,browser, "Review Document: MEDICAL_RECORDS 08/29/2017 (00EZ2472)","Subject","Assigned To","CVTest9 CV_Mgmt_Lead_Auto");
				/*rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
				rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_PendingAssignUser", TCID));*/
			 
			 //validating due business days..
			 BenefitClaimedPage_CV.validatingDueBusinessDays(testCaseName, browser,2,"Review Document: MEDICAL_RECORDS 08/29/2017 (00EZ2472)","Subject","Last Modified Date","Due Date"); 
/*Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_SameDay", TCID)),
				rd.getCellData(DataTable, "OpenActivity_PendingValue", TCID),
				rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
				rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID));*/
		
			 //Function for clicking Subject link in Activity history section based on user inputs..
			 BenefitClaimedPage_CV.clickingSubjectOfActivityHistorySection(testCaseName,browser, "Review Document: MEDICAL_RECORDS 08/29/2017 (00EZ2472)");
			 //Function for Checking Task comments in Activity History section..
			 BenefitClaimedPage_CV.checkingTaskCommentLink(testCaseName, browser, "Comments");
	

	/*Capturing the screenTitle of Last page of TC and then saving it in appData.properties file*/	 
			String screentitle=browser.getTitle();
			GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }
	

}
