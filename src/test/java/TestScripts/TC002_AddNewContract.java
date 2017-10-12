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
import PageObjects.ContractsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.SearchResultsPage;

public class TC002_AddNewContract extends DriverScript {
	
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="Add New Contract";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	
	
	@Test
    
    public static void tc01() throws Throwable{
    	
		String contractID = null;
		browser = GenericClass.createActiveScreenBrowser();
		DBnBrowserloading(TCID, DataTable);
		ReportEvent.testStepReport("", "Info", "Add New Contract");
	

		
		HomePage_CV.globalSearchText(testCaseName,browser, "STD Only #2"/*rd.getCellData(DataTable, "Account_Name", TCID)*/);
	
		
		HomePage_CV.clickingSearchButton(testCaseName,browser);
	 
		
		HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
	 
		
		SearchResultsPage.clickLinkOfSearchResultsSection(browser,rd.getCellData(DataTable, "Section_Name", TCID) , "STD Only #2"/*rd.getCellData(DataTable, "Account_Name", TCID)*/);
	 
		
		AccountsPage_CV.confirmingAccountPageNavigation(browser);
	 
		
		AccountsPage_CV.clickingNewContractButton(browser);
	 
		
		AccountsPage_CV.confirmingNewContractPageNavigation(browser);
	 
		
		AccountsPage_CV.checkingContractInfoSecFields(browser,rd.getCellData(DataTable, "Contract_InfoFields", TCID));
	 
		
		ContractsPage_CV.createContract(browser, rd.getCellData(DataTable, "AccountName_Label", TCID), "STD Only #2"/*rd.getCellData(DataTable, "Account_Name", TCID)*/, rd.getCellData(DataTable, "ContractNumber_Label", TCID), rd.getCellData(DataTable, "Save_Button", TCID));
	 
		
		contractID = GenericClass.getGeneratedIdFromH2Header(browser);
	 
		
		GenericClass.saveGeneratedDataInConfigFile(browser, "Contract", "contractID");

//Step7
//*** Searching Account name..
		HomePage_CV.globalSearchText(testCaseName,browser, rd.getCellData(DataTable, "Account_Name", TCID));
	
//*** Clicking Search Button..		
		HomePage_CV.clickingSearchButton(testCaseName,browser);
	 
//*** Confirming Navigated to Search Results page..		
		HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
	 
//*** Clicking Search account name..		
		SearchResultsPage.clickLinkOfSearchResultsSection(browser,rd.getCellData(DataTable, "Section_Name", TCID) ,
																rd.getCellData(DataTable, "Account_Name", TCID));
	 
//*** Confirming Account page Navigation..		
		GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "Account_Name", TCID));

//Step 8
//*** Clicking New Contract button..		
		AccountsPage_CV.clickingNewContractButton(browser);
	 
//*** Confirming New Contract Page..		
		AccountsPage_CV.confirmingNewContractPageNavigation(browser);
	 
//*** Checking Contract Section Fields..	
		AccountsPage_CV.checkingContractInfoSecFields(browser,rd.getCellData(DataTable, "Contract_InfoFields", TCID));
		
//Step 9 
//*** Creating New Contract		
		ContractsPage_CV.createContract(browser,rd.getCellData(DataTable, "AccountName_Label", TCID), 
												rd.getCellData(DataTable, "Account_Name", TCID), 
												rd.getCellData(DataTable, "ContractNumber_Label", TCID), 
												rd.getCellData(DataTable, "Save_Button", TCID));
	 
//*** Contract ID generated
		contractID = GenericClass.getGeneratedIdFromH2Header(browser);
	 
//*** Saved Contract ID generated		
		GenericClass.saveGeneratedDataInConfigFile(browser, rd.getCellData(DataTable, "Contract_Label", TCID), contractID);

	 
	 File f = new File(configFilepath);
	 FileReader fr = new FileReader(f);
	 Properties prop = new Properties();
	 prop.load(fr);
	 String policyNo = prop.getProperty("policyID");

			 
	 GenericClass.navigationBasedOnH2HeaderText(browser, contractID);
	 
	 
	 AccountsPage_CV.checkingContractDetailSecFields(browser,rd.getCellData(DataTable, "ContractDetail_Fields", TCID));
	 
	 
	 ContractsPage_CV.clickAccountNameLink(browser,rd.getCellData(DataTable, "AccountName_Label", TCID));
	 
	 
	 GenericClass.navigationBasedOnH2HeaderText(browser, "STD Only #2"/*rd.getCellData(DataTable, "Account_Name", TCID)*/);
	 
	 
	 AccountsPage_CV.verifyingNewPolicyInPolicyRelationshipSec("",browser, "Policy Relationships","Show",policyNo  );
	 
	 
	 AccountsPage_CV.verifyingNewContractInContractSec(browser, "Contract", "Show",contractID );

	 
//*** Navigated to Generated Contract Id page..
	 GenericClass.navigationBasedOnH2HeaderText(browser, contractID);
	 
//*** Checking Contract Details Section fields...
	 AccountsPage_CV.checkingContractDetailSecFields(browser,rd.getCellData(DataTable, "ContractDetail_Fields", TCID));

//Step 10
//*** Click Account Name link based on label.. 
	 ContractsPage_CV.clickAccountNameLink(browser,rd.getCellData(DataTable, "AccountName_Label", TCID));
	 
//*** Navigated to Clicked account name page.. 
	 GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "Account_Name", TCID));

//Step 11
//*** Verifying New Policy id in Policy relationship section.. 
	 AccountsPage_CV.verifyingNewPolicyInPolicyRelationshipSec(testCaseName,browser,rd.getCellData(DataTable, "PolicyRelationship_Section", TCID),
			 																		rd.getCellData(DataTable, "Show_Link", TCID),policyNo  );
	 
//*** Verifying New Contract id in Contract section.. 
	 AccountsPage_CV.verifyingNewContractInContractSec(browser, rd.getCellData(DataTable, "Contract_Section", TCID),
																rd.getCellData(DataTable, "Show_Link", TCID),contractID );

	
	 String screentitle=browser.getTitle();
	 GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	 

	 
	}

}
