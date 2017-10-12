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

import PageObjects.AccountsPage_CV;
import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;

public class TC004_AssignedPolicyUsers extends DriverScript
{
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="Assigned Policy User";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	
	 @Test
	
	 public static void tc01() throws Throwable
	 {
		browser = GenericClass.createActiveScreenBrowser();
		DBnBrowserloading(TCID, DataTable);
		ReportEvent.testStepReport("", "Info", "Assigned Policy Users");
	
		File f = new File(configFilepath);
		FileReader fr = new FileReader(f);
		Properties prop = new Properties();
		prop.load(fr);
		String policyNo = prop.getProperty("policyID");

		
//Step 18
//*** Clicking policy id link in policy relationship section..
	AccountsPage_CV.clickPolicyLinkOfPolicyRelationshipsSection(browser,rd.getCellData(DataTable, "PolicyRelationship_Section", TCID),
																		rd.getCellData(DataTable, "Show_Link", TCID), policyNo);
	
//*** Navigated to policy id Page..	

	GenericClass.navigationBasedOnH2HeaderText(browser, policyNo);
	
//Step 19
//Click New Assigned Policy user button..
	AccountsPage_CV.clickingNewAssignedPolicyUserButton(browser);
	

	AccountsPage_CV.confirmingNewAssignedPolicyUserPageNavigation(browser);
	
	AccountsPage_CV.fillingAssignedPolicyUserInfoFields(browser, rd.getCellData(DataTable, "ClaimComplexity_Available", TCID),rd.getCellData(DataTable, "ClaimComplexity_Available2", TCID),rd.getCellData(DataTable, "BenefitType_Available", TCID));
	

//*** Navigated to new policy user page navigation..
	AccountsPage_CV.confirmingNewAssignedPolicyUserPageNavigation(browser);
	
//Step 20
//*** filling new assigned policy user section fields..
	AccountsPage_CV.fillingAssignedPolicyUserInfoFields(browser,rd.getCellData(DataTable, "ClaimComplexity_Available", TCID),
																rd.getCellData(DataTable, "ClaimComplexity_Available2", TCID),
																rd.getCellData(DataTable, "BenefitType_Available", TCID));

//*** Selecting CV mangement Lead name...

	AccountsPage_CV.selectingUserNameFromAssignedPolicyWindowFrame(browser, "Andrea Libemday"/*rd.getCellData(DataTable, "SearchCriteria_ApprovalName", TCID)*/);
	
//*** Verifying ChosenListbox values..
	AccountsPage_CV.verifyingChosenListBoxValuesInClaim(browser,  rd.getCellData(DataTable, "ClaimComplexity_ListBoxValues", TCID));
	
//*** Verifying benefit type values..	
	AccountsPage_CV.verifyingChosenListBoxValuesInBenefitType(browser,  rd.getCellData(DataTable, "BenefitType_ListBoxValues", TCID));
	
//*** Click Save button..
	AccountsPage_CV.clickButtonOfAssignedPolicyUserEditPage(browser,rd.getCellData(DataTable, "Save_Button", TCID));
	
//*** Navigated to Assigned policy user details page..	
	AccountsPage_CV.confirmingAssignedPolicyUserDetailPage(browser);
	
//*** Checking Assigned policy user details section fields..
	AccountsPage_CV.checkingAssignedPolicyUserDetailSecFields(browser, "Assigned Policy Name,Policy,Claim Complexity Assignments,Benefit Type Assignments,User Name,Created By,Last Modified By"/*rd.getCellData(DataTable, "AssignedPolicyDetail_Fields", TCID)*/);
	
	String screentitle=browser.getTitle();
	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }
}
