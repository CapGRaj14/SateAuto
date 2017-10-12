package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.sic.accelerators.ActionEngine_Dialog;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.BenefitClaimedPage_CV;
import PageObjects.GenericClass;
import PageObjects.LoginPage_CV;


public class TC023_PhoneNotes extends DriverScript{
	public static String TCID="CV_001";
	public static String DataTable = "CV_REG";
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties";
	public static String testCaseName="In-Line editing";
	public static String uri = "ws://localhost:5095";
	
	 @Test
	
	 public static void tc023() throws Throwable
	 {
		 ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		 config.setServerAddress(new URI("ws://localhost:5095"));
	     SDK.init(config);
	     	
	         //isTestCaseRunnable(TCID, DataTable);
			 browser = GenericClass.createActiveScreenBrowser();
			 DBnBrowserloading(TCID,DataTable);
			 
			 BenefitClaimedPage_CV.ClickingCaseManagementLink(browser);
			 
			 BenefitClaimedPage_CV.PhoneNoteWinodw_DataFiling(browser);
			 
			 //--------------------------------------------------------------------------
	    	/*BenefitClaimedPage_CV.clickButtonOfBenefitClaimedDetailPage(testCaseName,browser,"Reassign");
	    	
	    	GenericClass.navigationBasedOnH2HeaderText(browser, "Benefit Claimed Selection");
	    	
	    	BenefitClaimedPage_CV.ckeckBoxValidation(browser, "BC-2017-1095168", "checked","checked");
	    	
	    	BenefitClaimedPage_CV.ClickOnButton(browser,"Next","Benefit Claimed Selection");
		 
	    	BenefitClaimedPage_CV.reassaingvalueANDbuttonvalidation(browser,"Reason","Other");
	    	
	    	boolean fnstatus=ActionEngine_Dialog.fnOKorCancelButtonInDialodBox(browser, rd.getCellData(DataTable, "PopUpMesg_Title", TCID),
																										rd.getCellData(DataTable, "Dialog_Button", TCID));
			GenericClass.reportlogger(fnstatus,testCaseName,"Clicked on " + rd.getCellData(DataTable, "Dialog_Button", TCID) + ", button");*/

	 }
}
