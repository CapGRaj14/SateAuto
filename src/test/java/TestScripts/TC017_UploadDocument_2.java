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
import PageObjects.TestCase_TestSteps;
import PageObjects.sample;

public class TC017_UploadDocument_2 extends DriverScript{
	
	public static String TCID="CV_TC017";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	public static String testCaseName="TC017_Upload Document2";
	
	 @Test
	
	    public static void tc02() throws Throwable{
		
		 isTestCaseRunnable(TCID, DataTable);
		 
		GenericClass.sdkConfig();
	     
	     browser = GenericClass.createActiveScreenBrowser();
		DBnBrowserloading(TCID,DataTable);
		 
		
		
		String claimNumber=null;
		String  benefitClaimedID=null;
		
		 ReportEvent.testStepReport("", "Info", "Upload Document (1)");
	    	
		 File f = new File(configFilepath);
	   	 FileReader fr = new FileReader(f);
	   	 Properties prop = new Properties();
	   	 prop.load(fr);
	   	 claimNumber = prop.getProperty("claimID");
	   	 benefitClaimedID=prop.getProperty("benefitID");
	   	
	    	sample.step_100(browser, testCaseName, rd.getCellData(DataTable, "Claim_Label", TCID), claimNumber, 
	    			 											rd.getCellData(DataTable, "BenefitClaimed_Label", TCID), benefitClaimedID, 
	    			 											rd.getCellData(DataTable, "Document_Label", TCID),
	    			 											rd.getCellData(DataTable, "Type_Label", TCID),
	    			 											rd.getCellData(DataTable, "Claim_Label", TCID),
	    			 											rd.getCellData(DataTable, "BenefitClaimed_Label", TCID),
	    			 											rd.getCellData(DataTable, "DocumentType_Label", TCID), 
	    			 											rd.getCellData(DataTable, "Document_ReceivedDateLabel", TCID));

	    	/*	
>>>>>>> bea5b4d1154289ecbb64714fd6c84f6fda13b41a
	    	 TestCase_TestSteps.step_101(browser, testCaseName, 
											    			 	rd.getCellData(DataTable, "Document_Label", TCID),
																rd.getCellData(DataTable, "Document_Name", TCID),
																rd.getCellData(DataTable, "Type_Label", TCID),
																rd.getCellData(DataTable, "Type_Value", TCID),
																rd.getCellData(DataTable, "DocumentType_Label", TCID),
																rd.getCellData(DataTable, "DocumentType_Value", TCID),
																rd.getCellData(DataTable, "Document_ReceivedDate", TCID),
																rd.getCellData(DataTable, "DocumentDesc_Label", TCID),
																rd.getCellData(DataTable, "DocumentDesc_Value", TCID), 
																rd.getCellData(DataTable, "Save_Button", TCID), 
																rd.getCellData(DataTable, "Document_Name", TCID),
																rd.getCellData(DataTable, "Document_InputValues", TCID),
																rd.getCellData(DataTable, "Document_InputButtons", TCID));
	    
	    	 
	    	 TestCase_TestSteps.step_102(browser, testCaseName, 
												    			 rd.getCellData(DataTable, "Document_AttachButton", TCID), 
												    			 rd.getCellData(DataTable, "Document_Name", TCID), 
												    			 rd.getCellData(DataTable, "Document_ChooseButton", TCID), 
												    			 rd.getCellData(DataTable, "FileLocation", TCID),
												    			 rd.getCellData(DataTable, "Document_AttachFileButton", TCID), 
												    			 rd.getCellData(DataTable, "Document_Name", TCID), 
												    			 rd.getCellData(DataTable, "Document_ViewDocLabel", TCID), 
												    			 rd.getCellData(DataTable, "Document_ViewAttchlink", TCID));
	    
			
	    	 TestCase_TestSteps.step_104(browser,testCaseName, 
												    			 rd.getCellData(DataTable, "BenefitClaimed_Label", TCID), benefitClaimedID,
												    			 rd.getCellData(DataTable, "OpenActivity_DocumentValue", TCID),
												 				rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
												 				rd.getCellData(DataTable, "OpenActivity_AssignToHeader", TCID),
												 				rd.getCellData(DataTable, "OpenActivity_AssignUser", TCID),
												 				Integer.parseInt(rd.getCellData(DataTable, "OpenActivity_5BusinessDays", TCID)),
																rd.getCellData(DataTable, "OpenActivity_DocumentValue", TCID),
																rd.getCellData(DataTable, "OpenActivity_SubjectHeader", TCID),
																rd.getCellData(DataTable, "OpenActivity_LastModifedHeader", TCID),
																rd.getCellData(DataTable, "OpenActivity_DueDateHeader", TCID)
																rd.getCellData(DataTable, "Comments_Label", TCID));

			*/ 
			String screentitle=browser.getTitle();
			GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }

}
