package TestScripts;

import org.testng.annotations.Test;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.LoginPage_CV;

public class TC007_GlobalSearch extends DriverScript{
	
	public static String TCID="CV_002";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="Global Search";
	
	 @Test
	
	    public static void tc02() throws Throwable{
	    	
		 isTestCaseRunnable(TCID, DataTable);
	    	

//Step 38
//*** Enter Username , password and click login button.. 
		 	LoginPage_CV.loginToClaimVantage(testCaseName,browser, rd.getCellData(DataTable, "tUserName", TCID), 
	    											  rd.getCellData(DataTable, "tPassword", TCID));
//*** Navigated to Home page..
	    	HomePage_CV.confirmingHomePageNavigation(testCaseName,browser,rd.getCellData(DataTable, "HomePage_CurrentStatus", TCID));

//Step 39
//*** Search Contat name..
	    	HomePage_CV.globalSearchText(testCaseName,browser, rd.getCellData(DataTable, "Search_Text", TCID));
	    	
//*** Click Search button..
	    	HomePage_CV.clickingSearchButton(testCaseName,browser);
	    	
//*** Navigated to search results page..	    	
	    	HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
	    	
//Step 40
//*** Clicking Contact name ..
	    	ContactsPage_CV.clickingSearchContactNameInContactSec(browser, rd.getCellData(DataTable, "Contact_Name", TCID));
	    	
//*** Confirming Account page navigation..

	    	ContactsPage_CV.confirmingContactPageNavigation(browser);
	    	
	    	String screentitle=browser.getTitle();
	    	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	    }
}	
