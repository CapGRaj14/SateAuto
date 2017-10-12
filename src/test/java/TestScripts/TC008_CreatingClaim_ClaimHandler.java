package TestScripts;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.Test;

import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.ClaimsPage_CV;
import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.UpDateUser_CV;

public class TC008_CreatingClaim_ClaimHandler extends DriverScript{
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	public static String testCaseName="Creating A Claim";
	@Test
    
    public static void tc02() throws Throwable{
		String claimNumber=null;
		String policyNumber=null;
		String benefitClaimedID=null;
		
		DBnBrowserloading(TCID,DataTable);	
		browser = GenericClass.createActiveScreenBrowser();
		ReportEvent.testStepReport("", "Info", "Creating a Claim");
	
		File f = new File(configFilepath);
		FileReader fr = new FileReader(f);
		 Properties prop = new Properties();
		 prop.load(fr);
		 claimNumber = prop.getProperty("claimID");
		 policyNumber = prop.getProperty("policyID");
		 benefitClaimedID=prop.getProperty("benefitID");
		 
	
		 ContactsPage_CV.clickingClaimOfClaimRelationshipSec(browser,claimNumber/*rd.getCellData(DataTable, "Claim_Number", TCID)*/);
		 
		 ClaimsPage_CV.confirmingClaimIdPageNavigation(browser, "Claim", claimNumber);
	
		 ContactsPage_CV.clickingAddBenefitClaimedButton(browser);
		 
		 GenericClass.navigationBasedOnH2HeaderText(browser, "Search Account and Policy");
	
		 BenefitClaimedPage_CV.fillingSearchCriteriaSecFields(browser,	rd.getCellData(DataTable, "GroupID_Label", TCID),
													    			rd.getCellData(DataTable, "GroupID", TCID),
													    			rd.getCellData(DataTable, "Policy_Label", TCID),
													    			policyNumber/*rd.getCellData(DataTable, "Policy_Id", TCID)*/);
		 BenefitClaimedPage_CV.clickButtonOfBenefitClaimedCreationPage(browser, rd.getCellData(DataTable, "Search_Button", TCID));
	
		 ContactsPage_CV.refreshingSearchResultsPage(browser);
		 
		 UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
		 
		 BenefitClaimedPage_CV.clickButtonOfBenefitClaimedCreationPage(browser, rd.getCellData(DataTable, "Next_Button", TCID));
	
		 GenericClass.navigationBasedOnH2HeaderText(browser, "Select a Benefit");
		 
		 UpDateUser_CV.selectingRadioButtonOfSearchResultsSec(browser);
		 
		 BenefitClaimedPage_CV.clickButtonOfSelectBenefitPage(browser,  rd.getCellData(DataTable, "Next_Button", TCID));
	
		 GenericClass.navigationBasedOnH2HeaderText(browser, "Benefit Claimed Details");
		 
		 BenefitClaimedPage_CV.UpdatingBenefitClaimedSectionFields(browser,	rd.getCellData(DataTable, "ProclaimClient_Label", TCID),
																			rd.getCellData(DataTable, "ProclaimClient_ID", TCID),
																			rd.getCellData(DataTable, "Assign_Label", TCID),
																			rd.getCellData(DataTable, "Assign_Checkbox", TCID),
																			rd.getCellData(DataTable, "AssignUser_Textbox", TCID));
	
		 BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailsPage(browser,  rd.getCellData(DataTable, "Create_Button", TCID));
		 
		 UpDateUser_CV.popUpMessageValidation("", browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID),rd.getCellData(DataTable, "PopUpMesg_Text", TCID) );
	
		 BenefitClaimedPage_CV.clickingOKbuttonOfDialogBox(testCaseName,browser,rd.getCellData(DataTable, "PopUpMesg_Title", TCID), rd.getCellData(DataTable, "Dialog_Button", TCID));
	
		 BenefitClaimedPage_CV.confirmingBenefitClaimedIdPageNavigation(testCaseName,browser, "Benefit Claimed", benefitClaimedID);
	
		String screentitle=browser.getTitle();
		GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	}
}
