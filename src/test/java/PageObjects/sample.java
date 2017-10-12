package PageObjects;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.accelerators.ActionEngine_Web;
import com.sic.support.ReportEvent;

public class sample extends ActionEngine_Web{
public static final String btnNewDocuments="//h3[text()='Documents']/../..//input";	
public static final String txtNewDocumentsHeader="//h2[text()=' New Document']";

public static void step_100(Browser browser,String testCaseName,String labelName,String inputClaimID,
			String benefitLabel,String inputBcID,String docmentLabel,String typeLabel,String claimLabel,String benefitClaimedLabel,
			String docType,String docReceivedDateLabel)
	{
	boolean fnStatus=false;
	try
		{
		String appText = null;
//clicking the document button
		fnStatus = fnButtonClick(browser, btnNewDocuments);
		reportlogger(testCaseName,fnStatus,"Clicking Document upload button ");

//Validation on Element exist
		fnStatus = isElementExist(browser, txtNewDocumentsHeader);
		reportlogger(testCaseName,fnStatus,"Validation on Element exist is  ");

//Validation on auto population elements
		appText = ClaimsPage_CV.getAutoPopulatedClaimIdOfTextBoxByLabel(browser, labelName);
		if(appText.equalsIgnoreCase(inputClaimID)){
			reportlogger(testCaseName,fnStatus,inputClaimID + "Auto populating as expected  ");
		}else{
			reportlogger(testCaseName,fnStatus,"Auto populating as expected  ");
		}

//Validation on auto population elements
		appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, benefitLabel);
		if(appText.equalsIgnoreCase(inputBcID)){
			reportlogger(testCaseName,fnStatus,inputBcID + "Auto populating as expected  ");
		}else{
			reportlogger(testCaseName,fnStatus,"Auto populating as expected  ");
		}
		
//Validation on field is marked as required.
		fnStatus=checkRequiredFieldAvailabilityDocumentDetailsSec(browser, docmentLabel);
		reportlogger(testCaseName,fnStatus, docmentLabel + ":  field is marked as required.");
		
//Validation on field is marked as required.
		fnStatus=checkRequiredFieldAvailabilityDocumentDetailsSec(browser, typeLabel);
		reportlogger(testCaseName,fnStatus, typeLabel + ":  field is marked as required.");

//Validation on field is marked as required.		
		fnStatus= checkRequiredFieldAvailabilityDocumentDetailsSec(browser, claimLabel);
		reportlogger(testCaseName,fnStatus, claimLabel + ":  field is marked as required.");
		
//Validation on field is marked as required.
		fnStatus= checkRequiredFieldAvailabilityDocumentDetailsSec(browser, benefitClaimedLabel);
		reportlogger(testCaseName,fnStatus, benefitClaimedLabel + ":  field is marked as required.");
		
//Validation on field is marked as required.
		fnStatus= checkRequiredFieldAvailabilityDocumentDetailsSec(browser, docType);
		reportlogger(testCaseName,fnStatus, docType + ":  field is marked as required.");
		
//Validation on field is marked as required.
		fnStatus=checkRequiredFieldAvailabilityDocumentDetailsSec(browser, docReceivedDateLabel);
		reportlogger(testCaseName,fnStatus, docReceivedDateLabel + ":  field is marked as required.");
}
	catch(Throwable t)
	{
		System.out.println(t.getMessage());
		ReportEvent.testStepReport(testCaseName, "Fail", "Exception arised in Step-100 is : "+t.getMessage());

	}
}

public static boolean checkRequiredFieldAvailabilityDocumentDetailsSec(Browser browser, String labelName) throws GeneralLeanFtException
{
	boolean checkRequiredFieldAvailabilityDocumentDetailsSec = false;
	
		String immediateParentXpath = "//label[text()='"+labelName+"']/..";
		WebElement fieldObject = browser.describe(WebElement.class, new XPathDescription(immediateParentXpath));
		fieldObject.highlight();
		if(fieldObject.exists())
		{
			String objClass = fieldObject.getClassName();
			if(objClass.equals("labelCol requiredInput"))
			{
				checkRequiredFieldAvailabilityDocumentDetailsSec = true;
			}
			else
			{
				checkRequiredFieldAvailabilityDocumentDetailsSec = false;
			}
		}
		else
		{
			checkRequiredFieldAvailabilityDocumentDetailsSec = false;
		}
		return checkRequiredFieldAvailabilityDocumentDetailsSec;
}


public static void reportlogger(String tTestCaseName,boolean fnStatus,String des){
	if(fnStatus==true)
		{
			ReportEvent.testStepReport(tTestCaseName, "Pass", des + "Execution successfully.");
			
		}
		else
		{
			ReportEvent.testStepReport(tTestCaseName, "FAIL", des + "Execution Failed.");
		
		}
	}
}
