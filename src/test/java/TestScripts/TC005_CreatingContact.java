package TestScripts;

import java.net.URI;

import org.testng.annotations.Test;

import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.web.Browser;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

import PageObjects.AccountsPage_CV;
import PageObjects.ContactsPage_CV;
import PageObjects.GenericClass;
import PageObjects.HomePage_CV;
import PageObjects.SearchResultsPage;
import PageObjects.TestCase_TestSteps;

public class TC005_CreatingContact extends DriverScript{
	public static String TCID="CV_TC005";
	public static String DataTable = "CV_REG";
	public static String testCaseName ="Creating Contact";
	public static String uri ="ws://localhost:5095";
	 @Test
	
	    public static void mthd_CreatingContact() throws Throwable
	 {
		 GenericClass.sdkConfig(uri);
	     
	     browser = GenericClass.createActiveScreenBrowser();
		 DBnBrowserloading(TCID, DataTable);
		 ReportEvent.testStepReport("", "Info", "Assigned Account Users");

// step 21

//*** Searching Account name..
	HomePage_CV.globalSearchText(testCaseName, browser, rd.getCellData(DataTable, "Account_Name", TCID));
	
//*** Click Search Button..
	HomePage_CV.clickingSearchButton(testCaseName,browser);
	
//*** Confirming navigated to Search Results page..
	HomePage_CV.confirmingNavigatedtoSearchResultsPage(browser);
	
//*** Click Account name link in Search results page..
	SearchResultsPage.clickLinkOfSearchResultsSection(browser, rd.getCellData(DataTable, "Section_Name", TCID), 
																rd.getCellData(DataTable, "Account_Name", TCID));

//*** Navigated to account name page..
	GenericClass.navigationBasedOnH2HeaderText(browser, rd.getCellData(DataTable, "Account_Name", TCID));

//step 22

//*** Click new contract button
	AccountsPage_CV.clickingNewContactButton(browser, 	rd.getCellData(DataTable, "ContactFrame_Title", TCID), 
														rd.getCellData(DataTable, "ContactFrame_TagName", TCID),
														rd.getCellData(DataTable, "ContactFrame_Id", TCID),
														rd.getCellData(DataTable, "NewContact_Button", TCID));

//*** Navigated to Selected records type page..
	ContactsPage_CV.confirmingSelectedRecordTypeNavigation(browser);
		
// Step 23
//*** Selection Contact type as Claimant..
	ContactsPage_CV.selectingRecordType(browser, rd.getCellData(DataTable, "Record_Type", TCID));
	
//*** Clicking Continue button..	
	ContactsPage_CV.clickingContinueButton(browser);

//*** Confirming navigated to contact edit page..

	ContactsPage_CV.confirmingContactEditPageNavigation(browser);
	
	String updatedLastName = GenericClass.generateLastName(browser, rd.getCellData(DataTable, "Contact_LastName", TCID));
	String contactName = GenericClass.concatenateFirstAndLastName(browser, rd.getCellData(DataTable, "Contact_FirstName", TCID), updatedLastName);

//Step 24

//*** Filling contact information section fields..

	ContactsPage_CV.fillingContactInfoFieldsClaimantType(browser,  rd.getCellData(DataTable, "Contact_FirstNameLabel", TCID),
			rd.getCellData(DataTable, "Contact_FirstName", TCID), rd.getCellData(DataTable, "Contact_LastNameLabel", TCID), updatedLastName, rd.getCellData(DataTable, "Contact_SSNumberLabel", TCID),
			rd.getCellData(DataTable, "Contact_SSNumber", TCID), rd.getCellData(DataTable, "Contact_BirthDate", TCID),rd.getCellData(DataTable, "Contact_GenderLabel", TCID),
			rd.getCellData(DataTable, "Contact_Gender", TCID));


//*** Filling Address information section fileds..

	ContactsPage_CV.fillingAddressInfoFieldsClaimantType(browser, rd.getCellData(DataTable, "Address_MailingStreetLabel", TCID),
			rd.getCellData(DataTable, "Address_MailingStreet", TCID),rd.getCellData(DataTable, "Address_MailingCityLabel", TCID),
			rd.getCellData(DataTable, "Address_mailingCity", TCID),	rd.getCellData(DataTable, "Address_MailingStateLabel", TCID),
			rd.getCellData(DataTable, "Address_MailingState", TCID));

//*** Clicking Save button..
	ContactsPage_CV.clickButtonOfContactEditPage(browser, rd.getCellData(DataTable, "Save_Button", TCID));
	
//*** Saving generated contact name..
	GenericClass.saveGeneratedDataInConfigFile(browser,rd.getCellData(DataTable, "Contact_h1Header", TCID), "contactName");

//*** Navigated to Contact name page ..
	GenericClass.navigationBasedOnH2HeaderText(browser, contactName);
	
//*** Verifying the saved changes in contact details section..	

	String inputVal = contactName +","+rd.getCellData(DataTable, "Contact_Gender", TCID)+","+rd.getCellData(DataTable, "Contact_SSNumber", TCID)+","+rd.getCellData(DataTable, "Account_Name", TCID);
	
	ContactsPage_CV.validatingContactDetailSecFieldValues(browser, rd.getCellData(DataTable, "Contact_Name", TCID),
																	rd.getCellData(DataTable, "Contact_BirthDateLabel", TCID),
																	rd.getCellData(DataTable, "Contact_GenderLabel", TCID),
																	rd.getCellData(DataTable, "Contact_SSNumberLabel", TCID),
																	rd.getCellData(DataTable, "AccountName_Label", TCID),inputVal);
		
	String screentitle=browser.getTitle();
	GenericClass.setActiveScreenTitleInConfigFile(screentitle);
	
	 }
}
