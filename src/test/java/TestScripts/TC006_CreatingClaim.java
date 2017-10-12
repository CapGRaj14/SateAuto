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
import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.TestCase_TestSteps;
import PageObjects.UpDateUser_CV;

public class TC006_CreatingClaim extends DriverScript{
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	public static String testCaseName ="Creating Claim";

	
	 @Test
		
	    public static void tc01() throws Throwable
	 {

	     browser = GenericClass.createActiveScreenBrowser();
		 DBnBrowserloading(TCID, DataTable);
		 ReportEvent.testStepReport("", "Info", "Creating a Claim");
		 
		String claimNumber=null;
		String contactName=null;
		String claimRelationshipID=null;

//Step 25		 
//*** clicking claims Tab..		 
		HomePage_CV.clickingTabForNavigation(browser, rd.getCellData(DataTable, "Claims_Tab", TCID));
	
//*** Navigated to Claim Home page..
		boolean fnStatus = isElementExist(browser, ClaimsPage_CV.txtClaimsHeader);
		GenericClass.reportlogger(fnStatus,testCaseName,"User navigated to Claims Home Page");
		
//*** Checking Recently view claims..	
		ClaimsPage_CV.checkingRecentViewClaimsInClaimHomePage(testCaseName,browser);
	
//Step 26
	
//*** Clicking New button..
		fnStatus = fnButtonClick(browser, ClaimsPage_CV.btnNew);
		GenericClass.reportlogger(fnStatus,testCaseName,"New button Should be clicked ");
	
//*** Navigated to new claim page..
		fnStatus = isElementExist(browser, ClaimsPage_CV.txtNewClaimHeader);
		GenericClass.reportlogger(fnStatus,testCaseName,"User navigated to New Claim Page");
	
//*** Verifying status Dropdown field value as Pending..
		ClaimsPage_CV.verifyingStatusDropdownFieldAsPending(testCaseName,browser,rd.getCellData(DataTable, "Claims_StatusDropdown", TCID));

//*** Verifying status field as required..
		ClaimsPage_CV.verifyingStatusFieldsAsRequired(browser, rd.getCellData(DataTable, "Status_Label", TCID));
	
//*** Validating field value as blank based on label..
		ClaimsPage_CV.validatingFieldValueAsBlankInClaimInfoSec(browser, rd.getCellData(DataTable, "Claims_BenefitType", TCID),rd.getCellData(DataTable, "Claims_Claimant", TCID));
		
//Step27
//*** Clicking Save button..
		ClaimsPage_CV.clickButtonOfClaimEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));

//*** Navigated to claim id page..
		ClaimsPage_CV.confirmingClaimIdPageNavigation(testCaseName,browser, rd.getCellData(DataTable, "h1HeaderText", TCID),claimNumber );
		GenericClass.readingPropertyValue(browser, claimNumber, contactName,claimRelationshipID);
	
//Step 28
//*** Clicking New claim Relationship button..	
		fnStatus = fnButtonClick(browser, ClaimsPage_CV.btnNewClaimRelationShip);
		GenericClass.reportlogger(fnStatus,testCaseName,"New Claim Relationship button Should be clicked");
	
//*** Navigated to new claim relationship page..
		fnStatus = isElementExist(browser, ClaimsPage_CV.txtNewClaimHeader);
		GenericClass.reportlogger(fnStatus,testCaseName,"User navigated to New Claim Relationship Page");
	
//*** Checking claim relationship section fields..		
	
		ClaimsPage_CV.checkingClaimRelationshipSecFields(testCaseName,browser, rd.getCellData(DataTable, "ClaimRelationship_SecFields", TCID));

//*** Checking claim has required field..
		fnStatus=GenericClass.checkRequiredFieldAvailabilityBasedOnLabel(browser, rd.getCellData(DataTable, "Claim_Label", TCID));
			
//*** Checking Relationship Type has required field..
		fnStatus=GenericClass.checkRequiredFieldAvailabilityBasedOnLabel(browser, rd.getCellData(DataTable, "RelationshipType_Label", TCID));
			
//*** Validate auto papulated values..
		ClaimsPage_CV.validatePopulatedClaimId(testCaseName,browser, rd.getCellData(DataTable, "ClaimNumber_Label", TCID),claimNumber);
		
//Step 29 & 30
		
//*** Selecting contact name ..
		ClaimsPage_CV.selectingContactNameFromClaimRelationshipWindowFrame(testCaseName,browser, contactName);
		
//*** Validate Auto papulated contact name..
		ClaimsPage_CV.validatePopulatedContactName(testCaseName,browser, rd.getCellData(DataTable, "Conatct_Label", TCID), contactName);

		
//Step 31
//Selecting relationship type ..
		fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, rd.getCellData(DataTable, "ClaimRelationship_Type", TCID),
																			rd.getCellData(DataTable, "ClaimRelationship_ClaimantValue", TCID));
		GenericClass.reportlogger(fnStatus, testCaseName, "Selected Relationship dropdown value as: "+rd.getCellData(DataTable, "ClaimRelationship_ClaimantValue", TCID)+"");
		
//Clicking Save button..
		ClaimsPage_CV.clickButtonOfClaimRelationshipEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
		
		fnStatus=GenericClass.saveGeneratedDataInConfigFile(browser, rd.getCellData(DataTable, "ClaimRelationship_h1Header", TCID), 
																		rd.getCellData(DataTable, "ClaimRelationship_IdValue", TCID));
		
		GenericClass.readingPropertyValue(browser, claimNumber, contactName,claimRelationshipID);
		
//*** Navigated to Claim Relationship Id Page..
		fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, claimRelationshipID);

//*** Validating Claim Relationship updated fields..
		ClaimsPage_CV.validatingClaimRelaShipDetailSecFieldValues(browser, rd.getCellData(DataTable, "Contact_Label", TCID), 
																		rd.getCellData(DataTable, "ClaimRelationship_Type", TCID), 
																		rd.getCellData(DataTable, "Claim_CreatedBy", TCID), 
																		rd.getCellData(DataTable, "Claim_LastModifiedBy", TCID), 
																		rd.getCellData(DataTable, "ClaimRelationship_DetailsSecFields", TCID));
																		
//Step 32
		
//*** Clicking Claim ID in Claim Relationship Details section..	
		fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, rd.getCellData(DataTable, "Claim_Label", TCID), claimNumber);
		GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on :"+ rd.getCellData(DataTable, "Claim_Label", TCID) + " label related link");
		
//*** Navigated to Claim Id page ..
		fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, claimNumber);

//*** Verifying Contact list displayed in Claim Related list..
		fnStatus=ClaimsPage_CV.verifyingClaimRelRelatedListInContactRel(browser, contactName);
	
//Step 33
	
//*** Clicking New claim Relationship button..	
		fnStatus = fnButtonClick(browser, ClaimsPage_CV.btnNewClaimRelationShip);
		GenericClass.reportlogger(fnStatus,testCaseName,"New Claim Relationship button Should be clicked");
		
//*** Navigated to new claim relationship page..
		fnStatus = isElementExist(browser, ClaimsPage_CV.txtNewClaimHeader);
		GenericClass.reportlogger(fnStatus,testCaseName,"User navigated to New Claim Relationship Page");
		
//*** Checking claim relationship section fields..		
		ClaimsPage_CV.checkingClaimRelationshipSecFields(testCaseName,browser, rd.getCellData(DataTable, "ClaimRelationship_SecFields", TCID));

//*** Checking claim has required field..
		fnStatus=GenericClass.checkRequiredFieldAvailabilityBasedOnLabel(browser, rd.getCellData(DataTable, "Claim_Label", TCID));
				
//*** Checking Relationship Type has required field..
		fnStatus=GenericClass.checkRequiredFieldAvailabilityBasedOnLabel(browser, rd.getCellData(DataTable, "RelationshipType_Label", TCID));
				
//*** Validate auto papulated values..
		ClaimsPage_CV.validatePopulatedClaimId(testCaseName,browser, rd.getCellData(DataTable, "ClaimNumber_Label", TCID),claimNumber);


//Step 34 & 35

//*** Selecting Account name..
		ClaimsPage_CV.selectingAccountNameFromClaimRelationshipWindowFrame(testCaseName,browser, rd.getCellData(DataTable, "Account_Name", TCID));
			
//*** Validate Autopapulated Account name..
		ClaimsPage_CV.validatePopulatedContactName(testCaseName,browser, rd.getCellData(DataTable, "Account_Label", TCID), 
																		rd.getCellData(DataTable, "Account_Name", TCID));
//Step 36
			
//*** Selecting relationship type ..
		fnStatus=GenericClass.selectValueByVisibleTextBasedOnLabel(browser, rd.getCellData(DataTable, "ClaimRelationship_Type", TCID),
																				rd.getCellData(DataTable, "ClaimRelationship_PolicyValue", TCID));
		GenericClass.reportlogger(fnStatus, testCaseName, "Selected Relationship dropdown value as: "+rd.getCellData(DataTable, "ClaimRelationship_PolicyValue", TCID)+"");
			
//*** Clicking Save button..
		ClaimsPage_CV.clickButtonOfClaimRelationshipEditPage(testCaseName,browser, rd.getCellData(DataTable, "Save_Button", TCID));
			
			
//*** Validating Claim Relationship updated fields..
		ClaimsPage_CV.validatingClaimRelaShipDetailSecFieldValues(browser, rd.getCellData(DataTable, "Account_Label", TCID), 
																				rd.getCellData(DataTable, "ClaimRelationship_Type", TCID), 
																				rd.getCellData(DataTable, "Claim_CreatedBy", TCID), 
																				rd.getCellData(DataTable, "Claim_LastModifiedBy", TCID), 
																				rd.getCellData(DataTable, "ClaimRelationship_UpdatedFields", TCID));
//Step 37
			
//*** Clicking Claim Relationship id..
		fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser,rd.getCellData(DataTable, "Claim_Label", TCID) , ClaimsPage_CV.tblClaimRelationShipDetail);
		GenericClass.reportlogger(fnStatus, testCaseName, "Claim Relationship Detail section :"+rd.getCellData(DataTable, "Claim_Label", TCID)+" label related value should be Clicked");
			
//*** Navigated to claim relationship id page..			
		fnStatus=GenericClass.navigationBasedOnH2HeaderText(browser, claimNumber);
			
//*** Verifying account name displayed in Claim relationship section..
		fnStatus=ClaimsPage_CV.verifyNewTaskDisplayedClaimRelSection(browser, rd.getCellData(DataTable, "Account_Name", TCID));
		GenericClass.reportlogger(fnStatus, testCaseName, "Account Name value is:"+rd.getCellData(DataTable, "Account_Name", TCID)+" updated");
			
		
	String screentitle=browser.getTitle();
	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }
}
