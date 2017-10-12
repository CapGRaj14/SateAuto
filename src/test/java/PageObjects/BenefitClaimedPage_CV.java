package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Calendar;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.stdwin.UiObject;
import com.hp.lft.sdk.stdwin.UiObjectDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.CheckBox;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Frame;
import com.hp.lft.sdk.web.FrameDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.Page;
import com.hp.lft.sdk.web.PageDescription;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.accelerators.ActionEngine_Dialog;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

public class BenefitClaimedPage_CV extends DriverScript {

	public static final String tblCustomLinks = "//td[text()='Custom Links']/../../../..//table[@class='customLinks']";
	public static final String txtCaseMgmtHeader = "//h1[text()='Case Management']";
	public static final String tblPhoneNote = "//td[text()='Phone Notes']/../../..";
	public static final String sectionPhoneNote = "//h2[text()='Phone Notes']/../../../../../../../..//div[@class='apexp']";

	public static final String sectionPhoneNotes = "//h3[text() ='Phone Notes']/../../../../../following-sibling::div[@class='pbBody']/../../..";
	public static final String txtPhoneNotesHeader = "//h1[text()='Phone Note Edit']";
	public static final String sectionPhoneNotesInformation = "//h3[text() ='Information']/../..";
	public static final String phoneNotesection_Xpath = "//form[@id='editPage']//div[@class='pbSubsection']";
	public static final String datePicker = "//table[@class ='outer']//following-sibling::div[@class='datePicker']";
	public static final String iframeNewPhoneNotesInfo = "//h3[text() ='Information']/../following-sibling::div[1]/table//tr//td[2]//iframe";
	public static final String tblCreatedPhoneNotes = "//div[@class='pbSubsection']/../..//following-sibling::table[@id='phoneNoteTable']";

	public static final String sectionOpenActivities = "//h3[text() ='Open Activities']/../../../../../following-sibling::div[@class='pbBody']/..";
	public static final String sectionActivityHistory = "//h3[text() ='Activity History']/../../../../../following-sibling::div[@class='pbBody']/../../..";
	public static final String txtBenefitClaimedHeader = "//h1[text()='Benefit Claimed']";
	public static final String txtBenefitClaimedEditHeader = "//h1[text()='Benefit Claimed Edit']";
	public static final String sectionDecision = "//h3[text()='Decision']/../following-sibling::div[1]";
	public static final String sectionDurationReviews = "//h3[text()='Duration Reviews']/../following-sibling::div[1]";
	public static final String txtSearchAccountPolicyHeader = "//h2[text()='Search Account and Policy']";
	public static final String sectionSearchCriteria = "//h3[text()='Search Criteria']/../..//child::div[@class='pbSubsection']";
	public static final String txtSelectBenefitHeader = "//h2[text()='Select a Benefit']";
	public static final String txtBenefitClaimedDetailsHeader = "//h2[text()='Benefit Claimed Details']";
	public static final String tblBenefitClaimedDetails = "//h3[text()='Benefit Claimed Details']/../..//parent::div[@class='pbBody']//table";
	public static final String txtAssignedUser = "//input[@name='j_id0:form:j_id2:j_id31:j_id36:j_id38']";
	public static final String sectionApprovalHistory = "//h3[text()='Approval History']/../../../../../..//parent::div[@class='relatedProcessHistory']";
	public static final String sectionDocuments = "//h3[text()='Documents']/../../../../../../..//parent::div[@class='bRelatedList first']";
	public static final String btnNewDocuments = "//h3[text()='Documents']/../..//input";
	public static final String txtNewDocumentsHeader = "//h2[text()=' New Document']";
	public static final String sectionDocumentsInfo = "//h3[text()='Information']/../..";
	public static final String txtAttachFileHeader = "//h1[contains(@class,'noSecondHeader')]";
	public static final String btnDone = "//table[@class='fileUploadTableBottom']/../..//input[@title='Done']";
	public static final String txtAttachFileUploadHeader = "//h1[text()='Attach File']";
	public static final String tblOpenActTaskInfo = "//label[text()='Assigned To']/../../../..//parent::div[@class='pbSubsection']//table";
	public static final String btnOccupational = "//td[text()='Occupational']/../../..";
	public static final String sectionOccupational = "//h2[text()='Occupational']/../../../../../..//parent::div[@class='apexp']";
	public static final String txtBenefitClaimCreationHeader = "//div[@class='content']";
	public static final String txtCurrentBenefitClaimedHeader = "//h2[text()='Current Benefit Claimed']/../..";
	public static final String txtTaskEditHeader = "//h2[text()='Task Edit']";
	public static final String tblBenefitClaimed = "//div[@id='cve__BenefitClaimed__c_body']/../..//table[@class='list']";
	public static final String lnkBenefitClaimed = "//td[text()='Benefit Claimed']/..//following-sibling::td//a";
	public static final String txtDocumentHeader = "//h1[text()='Document']";
	public static final String sectionInformation = "//label[text()='ProClaim Number']/ancestor::div[1]";
	public static final String tblOpenAcivities = "//h3[text() ='Open Activities']/../../../../../following-sibling::div[@class='pbBody']//table";
	public static final String tblCurrentBenefitClaimed = "//form[@name='j_id0:j_id2']/..//table";
	public static final String tblDocumentDetail = "//td[text()='Document Name']/../../../..";
	public static final String dueDateXpath = "//label[text()='Due Date']/../..//input";

	public static final String buttonXpathBCDetail_prefix = "//h2[text()='Benefit Claimed Detail']/../../../..//parent::div[@class='pbHeader']//input[@class='btn' and @title ='";
	public static final String buttonXpathBCDetail_suffix = "']";

	public static final String statusXpath = sectionDecision.concat("//select[contains(@name,'A2IhF')]");
	public static final String decisionReasonXpath = sectionDecision.concat("//select[contains(@name,'A2JF1')]");

	public static final String buttonXpathBCEdit_Prefix = "//h2[text()='Benefit Claimed Edit']/../../../../..//input[@class='btn' and @title ='";
	public static final String buttonXpathBCEdit_suffix = "']";
	public static final String buttonXpathTask_prefix = "//h1[text()='Task']/../../../..//parent::div[@class='pbHeader']//input[@class='btn' and @title ='";
	public static final String buttonXpathTask_suffix = "']";

	public static final String buttonXpathTaskEdit_prefix = "//h2[text()='Task Edit']/../../../..//input[@class='btn' and @title ='";
	public static final String buttonXpathTaskEdit_suffix = "']";
	public static final String lostWorkDateXpath = "//input[contains(@name,'A2IgW')]";

	public static final String buttonXpathOpenActivities_prefix = "//h3[text()='Open Activities']/../../../..//input[@class='btn' and @value ='";
	public static final String buttonXpathOpenActivities_suffix = "']";
	public static final String errorMesgXpath = sectionDecision.concat("//div[@class='errorMsg']");

	public static final String buttonXpathDocumentEdit_prefix = "//h2[text()='Document Edit']/../../../../..//input[@class='btn' and @title ='";
	public static final String buttonXpathDocumentEdit_suffix = "']";

	public static final String buttonXpathDocumentDetail_prefix = "//h2[text()='Document Detail']/../../../../..//input[@class='btn' and @title ='";
	public static final String buttonXpathDocumentDetail_suffix = "']";

	public static final String imgSubjectCombo = "//img[contains(@title,'Subject Combo')]";
	public static final String sectionNewTaskInfo = "//h3[text()='Task Information']/../..//following-sibling::div[@class='pbSubsection']";

	public static final String sectionPolicy_mgmtLead = "//h3[text()='Policy']/parent::div[1]/following-sibling::div[1]";

	public static final String Tablexpath = "//th[text()[contains(.,'Benefit Claimed Name')]]/ancestor::table[1]";

	public static final String ClickNextButton = "//form[@id='benefitClaimed:mainForm']//div[@class='pbHeader']//td[2]//input[@type ='submit' and @value='";

	public static final String CaseManagement_Link__sectionXpath = "//h2[text()='Benefit Claimed Detail']/../..//..//..//..//..//div[@class='pbBody']//div[@class='pbSubsection']";

	public static final String Tabstringpart1 = "//table[2]//td//tr//td[@id='p:f:";
	public static final String Tabstringpart2 = "_cell']//tbody//tbody//tr//td[@title='";
	public static final String addPhnNoteLinksectionXpath = "//td[@class='rich-tabpanel-content tabContent ' and @title='Phone Notes']//div[@class='pbBody']//div[@class='pbSubsection']";

	public static void ClickingCaseManagementLink(Browser browser) throws GeneralLeanFtException {
		try {

			// GenericClass.clickLinkBasedOnLinkNameAndSectionXpath(tTestCaseName,browser,CaseManagement_Link__sectionXpath,"Case
			// Management");
			BenefitClaimedPage_CV.clickTabCaseMgmt("", browser, "Phone Notes");
			GenericClass.clickLinkBasedOnLinkNameAndSectionXpath(tTestCaseName, browser, addPhnNoteLinksectionXpath,
					"Add");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingRequiredChkBoxOfOpenActivityTable is : ", t);
		}
	}

	public static void PhoneNoteWinodw_DataFiling(Browser browser)
			throws GeneralLeanFtException, AWTException, InterruptedException {
		try {
			GenericClass.sendKeysToTextBoxByLabel(browser, "Journal", "J-2017-728418");
			GenericClass.selectValueByVisibleTextBasedOnLabelwithoutContains(browser, "Call Type", "Incoming");
			GenericClass.selectValueByVisibleTextBasedOnLabel(browser, "Call Type Description", "Other");
			GenericClass.selectingDateBasedOnLabel(browser, phoneNotesection_Xpath, "*Call Date/Time", "10/25/2017");
			GenericClass.sendKeysToTextBoxByLabel(browser, "Spoke with", "Other");
			GenericClass.selectValueByVisibleTextBasedOnLabel(browser, "Caller Type Description", "Other");
			handlingIFrameForNewPhoneNote("Test Sample");
			ClickOnButton_PhoneNoteWindow(browser, "Save", "Phone Note Edit");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingRequiredChkBoxOfOpenActivityTable is : ", t);
		}
	}

	public static void handlingIFrameForNewPhoneNote(String value)
			throws GeneralLeanFtException, AWTException, InterruptedException {
		try {
			// html[@dir='ltr']//body[@id='00NA000000A2Iv5MAF_rta_body']
			browser.describe(Page.class,
					new PageDescription.Builder()
							.title("Phone Note Edit: New Phone Note ~ Salesforce - Unlimited Edition").build())
					.describe(Frame.class,
							new FrameDescription.Builder().tagName("IFRAME")
									.title("Rich Text Editor, 00NA000000A2Iv5MAF, Press ALT 0 for help").build())
					.describe(WebElement.class, new XPathDescription("//BODY")).highlight();
			;

			browser.describe(Page.class,
					new PageDescription.Builder()
							.title("Phone Note Edit: New Phone Note ~ Salesforce - Unlimited Edition").build())
					.describe(Frame.class,
							new FrameDescription.Builder().tagName("IFRAME")
									.title("Rich Text Editor, 00NA000000A2Iv5MAF, Press ALT 0 for help").build())
					.describe(WebElement.class, new XPathDescription("//BODY")).click();
			Thread.sleep(5000);
			Robot robot = new Robot();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(value);
			Thread.sleep(5000);
			clipboard.setContents(stringSelection, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(5000);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingRequiredChkBoxOfOpenActivityTable is : ", t);
		}
	}

	// Benefit calim page validatin & cliking next button
	public static void ckeckBoxValidation(Browser browser, String bcID, String checkboxActualstatus,
			String checkboxExpectedstatus) {
		try {

			int rwcnt = GenericClass.fngetTableRowCount(browser, Tablexpath);
			if (rwcnt > 1) {
				for (int i = 1; i <= rwcnt; i++) {
					String tblxpath = "//th[text()[contains(.,'Benefit Claimed Name')]]/ancestor::table[1]";
					String aTagXPath = tblxpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());
					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(bcID)) {
							String checkboxpath = tblxpath + "//tr[" + i + "][@class='dataRow']//input";
							CheckBox chck = browser.describe(CheckBox.class, new XPathDescription(checkboxpath));
							chck.highlight();
							boolean fnstatus = chck.isChecked();
							GenericClass.reportlogger(fnstatus, tTestCaseName,
									"Benefit Claimed Search Results checkbox clicked bydefault ");
						}
					}
				}
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingRequiredChkBoxOfOpenActivityTable is : ", t);
		}
	}

	// generic clicking of button based on header & button name
	public static boolean ClickOnButton(Browser browser, String buttonName, String searchheader) {
		boolean clickButtonOfBenefitClaimedCreationPage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h2[text()='" + searchheader
					+ "']/../../../..//child::div[@class='pbHeader']//child::input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			GenericClass.reportlogger(fnStatus, tTestCaseName, buttonXpath + ", element available.");
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				GenericClass.reportlogger(fnStatus, tTestCaseName, "Clicked on " + buttonName);
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedCreationPage is : ", t);
		}
		return clickButtonOfBenefitClaimedCreationPage;

	}

	// generic clicking of buttons based on phone note window
	public static boolean ClickOnButton_PhoneNoteWindow(Browser browser, String buttonName, String searchheader) {
		boolean clickButtonOfBenefitClaimedCreationPage = false;
		try {
			boolean fnStatus = false;
			// h2[text()='Phone Note
			// Edit']/../../../..//child::td[@class='pbButton']//input[@title='Save']
			String buttonXpath = "//h2[text()='" + searchheader
					+ "']/../../../..//child::td[@class='pbButton']//input[@title='" + buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			GenericClass.reportlogger(fnStatus, tTestCaseName, buttonXpath + ", element available.");
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				GenericClass.reportlogger(fnStatus, tTestCaseName, "Clicked on " + buttonName);
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedCreationPage is : ", t);
		}
		return clickButtonOfBenefitClaimedCreationPage;

	}

	// Generic function returns status of the button
	public static boolean ReturnButtonStatus(Browser browser, String buttonName, String searchheader) {
		boolean clickButtonOfBenefitClaimedCreationPage = false;
		boolean fnStatus = false;
		try {

			String buttonXpath = "//h2[text()='" + searchheader
					+ "']/../../../..//child::div[@class='pbHeader']//child::input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			GenericClass.reportlogger(fnStatus, tTestCaseName, buttonXpath + ", element available.");
			if (fnStatus == true) {
				fnStatus = IsButtonEnabled(browser, buttonXpath);

				return fnStatus;
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedCreationPage is : ", t);

		}
		return fnStatus;

	}
	// h2[text()='Search Benefit
	// Claimed(s)']/../../..//following::input[@class='btn' and @value =

	public static void reassaingvalueANDbuttonvalidation(Browser browser, String labelName, String inputValue) {

		boolean bfore = ReturnButtonStatus(browser, "Auto Reassign", "New Assigned User Selection");

		GenericClass.selectValueByVisibleTextBasedOnLabel(browser, labelName, inputValue);

		boolean after = ReturnButtonStatus(browser, "Auto Reassign", "New Assigned User Selection");
		if (bfore != after) {
			GenericClass.reportlogger(true, tTestCaseName, "behaviour of button as expection " + inputValue);
		} else {
			GenericClass.reportlogger(false, tTestCaseName, "behaviour of button as expection " + inputValue);
		}

		boolean fnstatus = ClickOnButton(browser, "Auto Reassign", "New Assigned User Selection");
		GenericClass.reportlogger(false, tTestCaseName, "Auto Reassign button cliked " + inputValue);

	}

	// Function to click on a Custom Links Benefit Claimed Detail page based on
	// user inputs..
	public static boolean clickingCustomLinkOfBenefitClaimedPage(Browser browser, String contactName) {
		boolean clickingCustomLinkOfBenefitClaimedPage = false;
		try {
			if (isElementExist(browser, tblCustomLinks)) {

				int rowCount = GenericClass.getSectionTableRowCount(browser, tblCustomLinks);
				outerloop: for (int i = 1; i <= rowCount; i++) {
					String columnPath = tblCustomLinks.concat("//tr[" + i + "]//td");
					WebElement[] tdTags = browser.findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(columnPath).build());
					for (int j = 0; j <= tdTags.length - 1; j++) {

						WebElement[] aTags = tdTags[j].findChildren(WebElement.class,
								new WebElementDescription.Builder().xpath("//a").build());
						for (WebElement aTag : aTags) {
							System.out.println(aTag.getInnerText());
							if (aTag.getInnerText().equals(contactName)) {
								aTag.click();
								ReportEvent.testStepReport(tTestCaseName, "pass",
										"Clicked on:" + aTag + " Link Successfully.!!");
								break outerloop;
							} else {
								continue;
							}
						}
					}
				}

				clickingCustomLinkOfBenefitClaimedPage = true;
			} else {
				System.out.println("Parent object is not available");
				clickingCustomLinkOfBenefitClaimedPage = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for clickingCustomLinkOfBenefitClaimedPage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingCustomLinkOfBenefitClaimedPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickingCustomLinkOfBenefitClaimedPage is : " + t.getMessage());
			errorCount++;
			clickingCustomLinkOfBenefitClaimedPage = false;

		}

		return clickingCustomLinkOfBenefitClaimedPage;
	}

	// Function for confirming Case Management page navigation..
	public static boolean confirmingCaseManagementPageNavigation(Browser browser) {
		boolean confirmingCaseManagementPageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtCaseMgmtHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Case Management Page successfully!!");
				confirmingCaseManagementPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Case Management  Page");
				errorCount++;
				confirmingCaseManagementPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for confirmingCaseManagementPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingCaseManagementPageNavigation is : " + t.getMessage());
			softAssert.fail("The Exception for confirmingCaseManagementPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingCaseManagementPageNavigation = false;

		}
		return confirmingCaseManagementPageNavigation;
	}

	// Function for filling Phone Note information section fields..
	public static boolean fillingPhoneNoteInformationSection(Browser browser, String callTypeLabel, String callType,
			String callTypeDescLabel, String callTypeDescription, String callerTypeDescLabel,
			String callerTypeDescription, String callDateTime, String spokeWithLabel, String spokeWith,
			String noteText) {
		boolean fillingPhoneNoteInformationSection = false;
		try {

			String phoneNoteInformationSecXpath = sectionPhoneNotesInformation.concat("//table");
			boolean fnStatus = isElementExist(browser, phoneNoteInformationSecXpath);
			{
				if (fnStatus == true) {

					// have to include frame handling cade....
					// Looping for all Dropdown values..

					fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, callTypeLabel, callType);
					if (fnStatus == true) {
						ReportEvent.testStepReport(tTestCaseName, "PASS", "Selected Call Type as : " + callType);
						fillingPhoneNoteInformationSection = true;
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Failed to  Select Call Type as : " + callType);
						errorCount++;
						fillingPhoneNoteInformationSection = false;
					}

					// Select Call type description..
					fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, callTypeDescLabel,
							callTypeDescription);
					if (fnStatus == true) {
						ReportEvent.testStepReport(tTestCaseName, "PASS",
								"Selected Call type description as : " + callTypeDescription);
						fillingPhoneNoteInformationSection = true;
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Failed to Selecte Call type description as : " + callTypeDescription);
						errorCount++;
						fillingPhoneNoteInformationSection = false;
					}
					// Select Caller type description..
					fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, callerTypeDescLabel,
							callerTypeDescription);
					if (fnStatus == true) {
						ReportEvent.testStepReport(tTestCaseName, "PASS",
								"Selected Caller type descriptionn as : " + callerTypeDescription);
						fillingPhoneNoteInformationSection = true;
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Failed to Selecte Caller type description as : " + callerTypeDescription);
						errorCount++;
						fillingPhoneNoteInformationSection = false;
					}
					// Select call date time..
					String callDateTimeXpath = sectionPhoneNotesInformation
							.concat("//table//span//input[@name='00NA000000BXcLn']");
					fnStatus = GenericClass.fnClikEditOrDateField(browser, callDateTimeXpath);

					if (fnStatus == true) {
						fnStatus = GenericClass.datePicker(browser, datePicker,
								GenericClass.dateConversion(callDateTime, "FullMonth/dd/yyyy"));
						if (fnStatus == true) {
							ReportEvent.testStepReport(tTestCaseName, "PASS",
									"Selected Call date and Time as :" + callDateTime);
							fillingPhoneNoteInformationSection = true;
						} else {
							ReportEvent.testStepReport(tTestCaseName, "FAIL",
									"Didn't selected the Call date and Time as :" + callDateTime);
							errorCount++;
							fillingPhoneNoteInformationSection = false;
						}
					}

					else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Didn't clicked on Call date and Time text box");
						errorCount++;
						fillingPhoneNoteInformationSection = false;
					}

					// Enter Speak with textbox field..
					fnStatus = GenericClass.sendKeysToTextBoxByLabel(browser, spokeWithLabel, spokeWith);
					if (fnStatus == true) {
						ReportEvent.testStepReport(tTestCaseName, "PASS",
								"Entered Call date and Time as : " + spokeWith);
						fillingPhoneNoteInformationSection = true;
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Failed to  Call date and Time as : " + spokeWith);
						errorCount++;
						fillingPhoneNoteInformationSection = false;
					}
					// Entering text into fame in text box.
					/*
					 * fnStatus = isElementExist(driver,
					 * iframeNewPhoneNotesInfo);
					 */
					if (fnStatus == true) {
						WebElement textBox = browser
								.describe(Page.class,
										new PageDescription.Builder()
												.title("Phone Note Edit: New Phone Note ~ Salesforce - Unlimited Edition")
												.build())
								.describe(Frame.class, new FrameDescription.Builder()
										.title("Rich Text Editor, 00NA000000A2Iv5MAF, Press ALT 0 for help").build())
								.describe(WebElement.class, new XPathDescription("//BODY"));
						textBox.click();
						EditField txt = textBox.describe(EditField.class,
								new com.hp.lft.sdk.web.EditFieldDescription.Builder().build());
						txt.setValue("test..Hi");
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to  NoteText as : " + noteText);
						errorCount++;
						fillingPhoneNoteInformationSection = false;
					}
					/*
					 * if(fnStatus == true) { String selectAll =
					 * Keys.chord(Keys.CONTROL, "a");
					 * driver.switchTo().frame(driver.findElement(By.xpath(
					 * iframeNewPhoneNotesInfo))); Actions action = new
					 * Actions(driver);
					 * action.moveToElement(driver.findElement(By.tagName("body"
					 * ))); action.click(); action.sendKeys(selectAll);
					 * //action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.
					 * CONTROL).perform(); action.sendKeys(noteText);
					 * action.build().perform();
					 * driver.switchTo().defaultContent();
					 * fillingPhoneNoteInformationSection = true; } else {
					 * ReportEvent.testStepReport(testName, "FAIL",
					 * "Failed to  NoteText as : " +noteText); errorCount++;
					 * fillingPhoneNoteInformationSection = false; }
					 */
				}

				else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL",
							" 'Phone Note Information' section is not available");
					errorCount++;
					fillingPhoneNoteInformationSection = false;
				}
			}

		}

		catch (Throwable t) {
			System.out.println("The Exception for fillingPhoneNoteInformationSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for fillingPhoneNoteInformationSection is : " + t.getMessage());
			softAssert.fail("The Exception for fillingPhoneNoteInformationSection is : " + t.getMessage());
			errorCount++;
			fillingPhoneNoteInformationSection = false;
		}

		return fillingPhoneNoteInformationSection;

	}

	// Function to click on either Save Or Save & New Or Cancel button of "Phone
	// Note Edit", Page based on the user inputs..
	public static boolean clickButtonOfPhoneNoteEditPage(Browser browser, String buttonName) {
		boolean clickButtonOfContactEditPage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h2[text()='Phone Note Edit']/../../../../..//input[@class='btn' and @title ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Clicked on " + buttonName + ", button successfully.");
					clickButtonOfContactEditPage = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail("Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfContactEditPage = false;
				}

			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfContactEditPage = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickButtonOfNoteEditPage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickButtonOfNoteEditPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickButtonOfNoteEditPage is : " + t.getMessage());
			errorCount++;
			clickButtonOfContactEditPage = false;
		}
		return clickButtonOfContactEditPage;

	}

	// Function for confirming New Phone Note page navigation..
	public static boolean confirmingNewPhoneNotePageNavigation(Browser browser) {
		boolean confirmingNewPhoneNotePageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtPhoneNotesHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to New Phone Note Edit Page successfully!!");
				confirmingNewPhoneNotePageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to New Phone Note Edit Page");
				errorCount++;
				confirmingNewPhoneNotePageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for confirmingNewPhoneNotePageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingNewPhoneNotePageNavigation is : " + t.getMessage());
			softAssert.fail("The Exception for confirmingNewPhoneNotePageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingNewPhoneNotePageNavigation = false;

		}
		return confirmingNewPhoneNotePageNavigation;
	}

	// Clicking on Name related link of Dates section
	public static boolean clickingLinkOfPhoneNoteActionType(Browser browser, String datesName, String action) {

		boolean clickingLinkOfPhoneNoteActionType = false;
		int j = 0;
		try {
			boolean fnStatus = false;
			String tableXpath = tblCreatedPhoneNotes;
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {

					String aTagXPath = tableXpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());

					// List<WebElement> atagElements
					// =driver.findElements(By.xpath(aTagXPath));
					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(datesName)) {

							for (Link atagElement : allLinks) {
								String atagElementText = atagElement.getInnerText();
								if (atagElementText.equals(action)) {
									String elementXpath = aTagXPath + "[text()='" + action + "']";
									fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
									if (fnStatus == true) {
										clickingLinkOfPhoneNoteActionType = true;
									} else {
										ReportEvent.testStepReport("", "fail", "Failed to click Dates action");
										errorCount++;
										clickingLinkOfPhoneNoteActionType = false;
									}

									break outerloop;
								} else {
									continue;

								}
							}
						} else {

						}

					}
				}

				clickingLinkOfPhoneNoteActionType = true;
			} else {

				ReportEvent.testStepReport("", "fail", "Absences  dates dynamic table is not available");
				errorCount++;
				clickingLinkOfPhoneNoteActionType = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickingLinkOfPhoneNoteActionType is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingLinkOfPhoneNoteActionType is : " + t.getMessage());
			softAssert.fail("The Exception for clickingLinkOfPhoneNoteActionType is : " + t.getMessage());
			errorCount++;
			clickingLinkOfPhoneNoteActionType = false;
		}
		return clickingLinkOfPhoneNoteActionType;
	}

	// Function to click on either Save Or Undo button of "Phone Notes", Page
	// based on the user inputs..
	public static boolean clickButtonOfPhoneNotePage(Browser browser, String buttonName) {
		boolean clickButtonOfPhoneNotePage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h2[text()='Phone Notes']/../../../../..//input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Clicked on " + buttonName + ", button successfully.");
					clickButtonOfPhoneNotePage = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail("Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfPhoneNotePage = false;
				}

			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfPhoneNotePage = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickButtonOfPhoneNotePage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickButtonOfPhoneNotePage is : " + t.getMessage());
			softAssert.fail("The Exception for clickButtonOfPhoneNotePage is : " + t.getMessage());
			errorCount++;
			clickButtonOfPhoneNotePage = false;
		}
		return clickButtonOfPhoneNotePage;

	}

	// Function to click on either New Task Or Close Task button of "Open
	// Acivity section" of the Selected benefit claimed Page based on the user
	// inputs..
	public static void clickButtonOfOpenAcivitySec(String testCaseName, Browser browser, String buttonName) {
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h3[text() ='Open Activities']/../../../../..//input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button");
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfOpenAcivitySec is : ", t);
		}
	}

	// Function for Selecting OK or Cancel button of Dialog box..
	public static void clickingOKbuttonOfDialogBox(String testCaseName, Browser browser, String popUpTitle,
			String buttonName) {
		try {
			boolean fnStatus = ActionEngine_Dialog.fnOKorCancelButtonInDialodBox(browser, popUpTitle, buttonName);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingOKbuttonOfDialogBox is : ", t);

		}
	}

	// Function for Verifying Closed tasks are Upadated in Activity history
	// Section..
	public static void verifyNewTaskDisplayedActivityHistory(String testCaseName, Browser browser,
			String subjectValue) {
		try {
			boolean fnStatus = false;
			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 1; i <= rowCount; i++) {
					String subjectxPath = tableXpath.concat("//th/a");
					Link[] aTagObject = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(subjectxPath).build());

					for (Link cell : aTagObject) {

						if (cell.getInnerText().contains(subjectValue)) {
							System.out.println(cell.getInnerText());
							cell.highlight();
							ReportEvent.testStepReport(testCaseName, "PASS",
									"Task value :" + subjectValue + " Should be updated Activity History Section.");

							break outerloop;
						} else {
							continue;

						}

					}
				}
			}

			else {
				ReportEvent.testStepReport(testCaseName, "Fail", " Activity History dynamic table is not available");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for virifyNewTaskDisplayedActivityHistory is : ", t);
		}

	}

	// Function for Navigated to benefit claimed page..

	public static void confirmingBenefitClaimedPageNavigation(String testCaseName, Browser browser) {
		boolean fnStatus = false;
		try {
			fnStatus = isElementExist(browser, txtBenefitClaimedHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "User navigated to Benefit Claimed Page");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingBenefitClaimedPageNavigation is : ", t);

		}

	}

	// Function to click on either Edit Or Submit for Approval Or Reassign
	// button of "Benefit Claimed Detail", Page based on the user inputs..
	public static void clickButtonOfBenefitClaimedDetailPage(String testCaseName, Browser browser, String buttonName) {

		try

		{
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, buttonXpathBCDetail_prefix + buttonName + buttonXpathBCDetail_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName,
					buttonXpathBCDetail_prefix + buttonName + buttonXpathBCDetail_suffix + " : Xpath is ");
			fnStatus = fnButtonClick(browser, buttonXpathBCDetail_prefix + buttonName + buttonXpathBCDetail_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on :" + buttonName + ", button.");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedDetailPage is : ", t);

		}

	}
	// Function for Navigated to benefit claimed Edit page..

	public static void confirmingBenefitClaimedEditPageNavigation(String testCaseName, Browser browser) {

		try {
			boolean fnStatus = isElementExist(browser, txtBenefitClaimedEditHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "User navigated to Benefit Claimed Edit Page ");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingBenefitClaimedEditPageNavigation is : ", t);

		}

	}

	// Function for Updating Decision Reason Field values based on user inputs..

	public static boolean updatingDecisionReasonFieldValues(String testCaseName, Browser browser, String statusValue,
			String reasonValue/* ,String throughDate */) {
		boolean updatingDecisionReasonFieldValues = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, statusXpath);
			// Update Status for Approval to Approved
			fnStatus = GenericClass.fnClickListBox(browser, statusXpath);
			fnStatus = fnListBox(browser, statusXpath, statusValue);
			GenericClass.reportlogger(fnStatus, testCaseName,
					"Updated Status for Approval to " + statusValue + " Listbox value ");
			// Update Decision Reason to Updated Medical Needed
			fnStatus = isElementExist(browser, decisionReasonXpath);
			fnStatus = GenericClass.fnClickListBox(browser, decisionReasonXpath);
			fnStatus = fnListBox(browser, decisionReasonXpath, reasonValue);
			GenericClass.reportlogger(fnStatus, testCaseName,
					"Updated Decision Reason to " + reasonValue + " Listbox value");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for updatingDecisionReasonFieldValues is : ", t);

		}
		return updatingDecisionReasonFieldValues;
	}

	// Function for Updating Duration Reviews Field values based on user
	// inputs..
	public static boolean updatingDurationReviewsFieldValues(Browser browser, String startDate, String throughDate,
			String ltdCoverageLabel, String ltdCoverage, String lifeCoverage, String lifeCoverageValue) {
		boolean updatingDurationReviewsFieldValues = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionDurationReviews);
			if (fnStatus == true) {
				// Update Benefit Start
				String startDateXpath = sectionDurationReviews.concat("//input[contains(@name,'A2Ifb')]");
				fnStatus = GenericClass.fnClikEditOrDateField(browser, startDateXpath);

				if (fnStatus == true) {
					fnStatus = GenericClass.datePicker(browser, datePicker,
							GenericClass.dateConversion(startDate, "FullMonth/dd/yyyy"));
					if (fnStatus == true) {
						ReportEvent.testStepReport(tTestCaseName, "PASS",
								"Updated Benefit Start date as :" + startDate);
						updatingDurationReviewsFieldValues = true;
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Didn't Update Benefit Start date as :" + startDate);
						errorCount++;
						updatingDurationReviewsFieldValues = false;
					}
				}

				else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Didn't clicked on Benefit Start Date text box.");
					errorCount++;
					updatingDurationReviewsFieldValues = false;
				}
				// Update Benefit Through dates
				String throughDateXpath = sectionDurationReviews.concat("//input[contains(@name,'A2Ifc')]");
				fnStatus = GenericClass.fnClikEditOrDateField(browser, throughDateXpath);

				if (fnStatus == true) {
					fnStatus = GenericClass.datePicker(browser, datePicker,
							GenericClass.dateConversion(throughDate, "FullMonth/dd/yyyy"));
					if (fnStatus == true) {
						ReportEvent.testStepReport(tTestCaseName, "PASS",
								"Updated Benefit Through date as :" + throughDate);
						updatingDurationReviewsFieldValues = true;
					} else {
						ReportEvent.testStepReport(tTestCaseName, "FAIL",
								"Didn't Update Benefit Through date as :" + throughDate);
						errorCount++;
						updatingDurationReviewsFieldValues = false;
					}
				}

				else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL",
							"Didn't clicked on Benefit Through Date text box.");
					errorCount++;
					updatingDurationReviewsFieldValues = false;
				}
				// Update LTD Coverage to Yes
				fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, ltdCoverageLabel, ltdCoverage);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Updated LTD Coverage to " + ltdCoverage + " Listbox value Successfully.");
					updatingDurationReviewsFieldValues = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL",
							"Failed to Update LTD Coverage to " + ltdCoverage + " Listbox value");
					softAssert.fail("Failed to Update LTD Coverage to " + ltdCoverage + " Listbox value");
					errorCount++;
					updatingDurationReviewsFieldValues = false;
				}
				// Update Life Coverage to Yes

				fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, lifeCoverage, lifeCoverageValue);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Updated Life Coverage to " + lifeCoverageValue + " Listbox value Successfully.");
					updatingDurationReviewsFieldValues = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL",
							"Failed to Update Life Coverage to " + lifeCoverageValue + " Listbox value");
					softAssert.fail("Failed to Update Life Coverage to " + lifeCoverageValue + " Listbox value");
					errorCount++;
					updatingDurationReviewsFieldValues = false;
				}
			} else {
				ReportEvent.testStepReport("", "fail", "Duration Reviews Section is not available");
				errorCount++;
				updatingDurationReviewsFieldValues = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for updatingDurationReviewsFieldValues is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for updatingDurationReviewsFieldValues is : " + t.getMessage());
			softAssert.fail("The Exception for updatingDurationReviewsFieldValues is : " + t.getMessage());
			errorCount++;
			updatingDurationReviewsFieldValues = false;
		}
		return updatingDurationReviewsFieldValues;
	}

	// Function to click on either Save Or Save & New Or Cancel button of "Phone
	// Note Edit", Page based on the user inputs..
	public static void clickButtonOfBenefitClaimedEditPage(String testCaseName, Browser browser, String buttonName) {

		try {
			boolean fnStatus = false;

			fnStatus = isElementExist(browser, buttonXpathBCEdit_Prefix + buttonName + buttonXpathBCEdit_suffix);
			fnStatus = fnButtonClick(browser, buttonXpathBCEdit_Prefix + buttonName + buttonXpathBCEdit_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedEditPage is : ", t);

		}

	}

	// Function for clicking link in Current Benefit Claimed section based on
	// user inputs..
	public static boolean clickLinkOfCurrentBenefitClaimedSection(Browser browser, String pageTitle, String frameName,
			String linkName) {
		boolean clickLinkOfCurrentBenefitClaimedSection = false;
		try {
			boolean fnStatus = false;
			// fnStatus=clickingTableLinkInFrame(browser,
			// pageTitle,/*"066A0000001XCIx"*/ frameName, linkName);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on " + linkName + ", Link successfully.");
				clickLinkOfCurrentBenefitClaimedSection = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to Click " + linkName + ", Link.");
				softAssert.fail("Failed to Click " + linkName + ", Link.");
				errorCount++;
				clickLinkOfCurrentBenefitClaimedSection = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for clickLinkOfCurrentBenefitClaimedSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickLinkOfCurrentBenefitClaimedSection is : " + t.getMessage());
			softAssert.fail("The Exception for clickLinkOfCurrentBenefitClaimedSection is : " + t.getMessage());
			errorCount++;
			clickLinkOfCurrentBenefitClaimedSection = false;
		}
		return clickLinkOfCurrentBenefitClaimedSection;
	}

	// Function for confirming Search Account and Policy page navigation..
	public static boolean confirmingSearchAccountPolicynPageNavigation(Browser browser) {
		boolean confirmingSearchAccountPolicynPageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtSearchAccountPolicyHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Search Account and Policy Page successfully!!");
				confirmingSearchAccountPolicynPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Failed to navigate to Search Account and Policy  Page");
				errorCount++;
				confirmingSearchAccountPolicynPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for confirmingSearchAccountPolicynPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingSearchAccountPolicynPageNavigation is : " + t.getMessage());
			softAssert.fail("The Exception for confirmingSearchAccountPolicynPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingSearchAccountPolicynPageNavigation = false;

		}
		return confirmingSearchAccountPolicynPageNavigation;
	}

	// Function for filling Search criteria section fields based on user
	// inputs..
	public static boolean fillingSearchCriteriaSecFields(Browser browser, String groupLabel, String groupId,
			String policyLabel, String policyId) {
		boolean fillingSearchCriteriaSecFields = false;
		try {
			boolean fnStatus = isElementExist(browser, sectionSearchCriteria);
			GenericClass.reportlogger(fnStatus, tTestCaseName, sectionSearchCriteria + ", Section available.");
			if (fnStatus == true) {
				// Enter Group id..
				fnStatus = GenericClass.sendKeysToTextBoxByLabel(browser, groupLabel, groupId);
				GenericClass.reportlogger(fnStatus, tTestCaseName, "Entered Group Id as: " + groupId);

				// Enter Policy Number..
				fnStatus = GenericClass.sendKeysToTextBoxByLabel(browser, policyLabel, policyId);
				GenericClass.reportlogger(fnStatus, tTestCaseName, "Entered Policy Number as: " + policyId);
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for fillingSearchCriteriaSecFields is :  ", t);
		}
		return fillingSearchCriteriaSecFields;
	}

	// Function to click on either Search Or Clear Or Next button of "Benefit
	// Claimed Creation", Page based on the user inputs..
	public static boolean clickButtonOfBenefitClaimedCreationPage(Browser browser, String buttonName) {
		boolean clickButtonOfBenefitClaimedCreationPage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h3[text()='Search Criteria']/../../../..//child::div[@class='pbHeader']//child::input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			GenericClass.reportlogger(fnStatus, tTestCaseName, buttonXpath + ", element available.");
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				GenericClass.reportlogger(fnStatus, tTestCaseName, "Clicked on " + buttonName);
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedCreationPage is : ", t);
		}
		return clickButtonOfBenefitClaimedCreationPage;

	}

	// Function for confirming Select a Benefit page navigation..
	public static boolean confirmingSelectBenefitPageNavigation(Browser browser) {
		boolean confirmingSelectBenefitPageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtBenefitClaimCreationHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Benefit Claimed Creation - Select a Benefit Page!!");
				confirmingSelectBenefitPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Failed to navigate to Benefit Claimed Creation - Select a Benefit Page");
				errorCount++;
				confirmingSelectBenefitPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for confirmingSelectBenefitPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingSelectBenefitPageNavigation is : " + t.getMessage());
			softAssert.fail("The Exception for confirmingSelectBenefitPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingSelectBenefitPageNavigation = false;

		}
		return confirmingSelectBenefitPageNavigation;
	}

	// Function to click on either Previous or Next button of "Select a Benefit"
	// Page based on the user inputs..
	public static boolean clickButtonOfSelectBenefitPage(Browser browser, String buttonName) {
		boolean clickButtonOfSelectBenefitPage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h3[text()='Benefits Available']/../../../../..//parent::div[@class='pbHeader']//input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Clicked on " + buttonName + ", button successfully.");
					clickButtonOfSelectBenefitPage = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail("Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfSelectBenefitPage = false;
				}

			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfSelectBenefitPage = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickButtonOfSelectBenefitPage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickButtonOfSelectBenefitPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickButtonOfSelectBenefitPage is : " + t.getMessage());
			errorCount++;
			clickButtonOfSelectBenefitPage = false;
		}
		return clickButtonOfSelectBenefitPage;

	}

	// Function for confirming Benefit Claimed Details page navigation..
	public static boolean confirmingBenefitClaimedDetailsPageNavigation(Browser browser) {
		boolean confirmingBenefitClaimedDetailsPageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtBenefitClaimedDetailsHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Benefit Claimed Details Page successfully!!");
				confirmingBenefitClaimedDetailsPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Failed to navigate to Benefit Claimed Details  Page");
				errorCount++;
				confirmingBenefitClaimedDetailsPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out
					.println("The Exception for confirmingBenefitClaimedDetailsPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingBenefitClaimedDetailsPageNavigation is : " + t.getMessage());
			softAssert.fail("The Exception for confirmingBenefitClaimedDetailsPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingBenefitClaimedDetailsPageNavigation = false;

		}
		return confirmingBenefitClaimedDetailsPageNavigation;
	}

	// Function for Updating Benefit claim Details section fields ..

	public static boolean UpdatingBenefitClaimedSectionFields(Browser browser, String proclaimIdLabel,
			String proclaimID, String assignLabel, String assignCheckBox, String assignUser) {
		boolean UpdatingBenefitClaimedSectionFields = false;
		try {

			boolean fnStatus = isElementExist(browser, tblBenefitClaimedDetails);
			{
				GenericClass.reportlogger(fnStatus, tTestCaseName, " Availabe Assign user Text box ");

				if (fnStatus == true) {

					// Upadte Proclaim Claint id To SI..
					fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, proclaimIdLabel, proclaimID);
					GenericClass.reportlogger(fnStatus, tTestCaseName, "Updated Proclaim Claint Id to : " + proclaimID);

					// Check Automatically assign box..
					fnStatus = GenericClass.checkOrUncheckCheckBoxByLabel(browser, assignLabel, assignCheckBox);
					GenericClass.reportlogger(fnStatus, tTestCaseName, "Checked Assign Check box automatically ");

					// Clear name from Assigned User field..
					fnStatus = isElementExist(browser, txtAssignedUser);
					if (fnStatus = true) {
						fnStatus = fnEditFieldTextEntry(browser, txtAssignedUser, assignUser);
						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_CONTROL);

						GenericClass.reportlogger(fnStatus, tTestCaseName, "Cleared Assign user Text box ");
					}
				}
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for UpdatingBenefitClaimedSectionFields is : ", t);
		}
		return UpdatingBenefitClaimedSectionFields;
	}

	// Function to click on either Previous or CreateBenefitClaimed button of
	// "Benefit Claimed Details" Page based on the user inputs..
	public static boolean clickButtonOfBenefitClaimedDetailsPage(Browser browser, String buttonName) {
		boolean clickButtonOfBenefitClaimedDetailsPage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h3[text()='Benefit Claimed Details']/../../../../..//parent::div[@class='pbHeader']//input[@class='btn' and @value ='"
					+ buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			GenericClass.reportlogger(fnStatus, tTestCaseName, buttonXpath + ", element availability check ");
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				GenericClass.reportlogger(fnStatus, tTestCaseName, "Clicked on " + buttonName + ", button ");
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfBenefitClaimedDetailsPage is :", t);
		}
		return clickButtonOfBenefitClaimedDetailsPage;

	}

	// Function for verifying the Status for approval value as Denied..
	public static void verifyingStatusFieldInDecisionReasonSec(String testCaseName, Browser browser, String fieldName,
			String inputValue) {

		try {

			String fieldValue = GenericClass.getFieldValueOfSection(browser, fieldName, sectionDecision);
			if (fieldValue.equals(inputValue)) {
				ReportEvent.testStepReport(testCaseName, "pass",
						"Status Field as : " + fieldValue + " should be Verified successfully!!");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to validate Status Field as:  " + fieldValue + "");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for vefiryingStatusFieldInDecisionReasonSec is : ", t);
		}

	}

	// Function for Validating the Updated date values based on different
	// timezones in Approval history section..
	public static void verifyingDateColumnInModifiedDateApprovalHistorySec(String testCaseName, Browser browser,
			String timeZone1, String timezone2) {

		String date = null;
		boolean fnStatus = false;
		try {

			fnStatus = isElementExist(browser, sectionApprovalHistory);
			if (fnStatus == true) {

				date = GenericClass.DateAndTimeConversionBasedOnTimeZones(timeZone1, timezone2);
				String tableXpath = sectionApprovalHistory.concat("//div[@class='pbBody']/table");
				String thXpath = tableXpath.concat("//tr[3]//th");
				WebElement updatedDate = browser.describe(WebElement.class, new XPathDescription(thXpath));
				updatedDate.highlight();
				String updatedDateValue = updatedDate.getInnerText();
				if (date.contains(updatedDateValue)) {
					ReportEvent.testStepReport(testCaseName, "Pass",
							"Approval History updated with time/date of submission and Approval:" + date);

				} else {
					ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to Update date value");

				}

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Approval History section is not available");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for verifyingDateColumnInModifiedDateApprovalHistorySec is : ", t);

		}

	}

	// Function for clicking Action Type (Edit or Del) link in Open Activities
	// section..
	public static void clickingActionTypeOfOpenActivitiesSec(String testCaseName, Browser browser, String subjectValue,
			String action) {

		int j = 0;
		try {
			boolean fnStatus = false;
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {

					String aTagXPath = tableXpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());

					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(subjectValue)) {

							for (Link atagElement : allLinks) {
								String atagElementText = atagElement.getInnerText();
								if (atagElementText.equals(action)) {
									String elementXpath = aTagXPath + "[text()='" + action + "']";
									fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);

									if (fnStatus == true) {
										ReportEvent.testStepReport("", "Pass", "Clicked on:" + subjectValue
												+ " Related to Action Link :" + action + " Successfully.");
										break outerloop;
									} else {
										ReportEvent.testStepReport("", "fail",
												"Failed to click Open Activities action");

									}

								} else {
									continue;

								}
							}
						} else {
							continue;
						}

					}
				}

			} else {

				ReportEvent.testStepReport("", "fail", "Open Activities dynamic table is not available");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingActionTypeOfOpenActivitiesSec is : ", t);

		}

	}

	// Function for verifying status dropdown value as Completed..
	public static void selectingStatusDropdownfieldValue(String testCaseName, Browser browser, String statuslLabel,
			String statusValue) {

		try {
			boolean fnStatus = false;
			fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, statuslLabel, statusValue);
			GenericClass.reportlogger(fnStatus, testCaseName, "Selected Status Listbox value as: " + statusValue);

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for selectingStatusDropdownfieldValue is : ", t);

		}

	}

	// Function to click on either Save Or Save & New Or Cancel button of "Task
	// Edit", Page based on the user inputs..
	public static void clickButtonOfTaskEditPage(String testCaseName, Browser browser, String buttonName) {
		boolean fnStatus = false;
		try {

			isElementExist(browser, buttonXpathTaskEdit_prefix + buttonName + buttonXpathTaskEdit_suffix);
			fnStatus = fnButtonClick(browser, buttonXpathTaskEdit_prefix + buttonName + buttonXpathTaskEdit_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfTaskEditPage is : ", t);

		}

	}

	// Function for confirming Communicate Denied Decision to Claimant page
	// navigation..
	public static boolean confirmingCommunicateDeniedDecisionPageNavigation(Browser browser) {
		boolean confirmingCommunicateDeniedDecisionPageNavigation = false;
		try {
			String communicateXpath = "//h2[text()=' Communicate Denied Decision to Claimant']";
			boolean fnStatus = isElementExist(browser, communicateXpath);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Communicate Denied Decision to Claimant Page successfully!!");
				confirmingCommunicateDeniedDecisionPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Failed to navigate to Communicate Denied Decision to Claimant Page");
				errorCount++;
				confirmingCommunicateDeniedDecisionPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println(
					"The Exception for confirmingCommunicateDeniedDecisionPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingCommunicateDeniedDecisionPageNavigation is : " + t.getMessage());
			softAssert
					.fail("The Exception for confirmingCommunicateDeniedDecisionPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingCommunicateDeniedDecisionPageNavigation = false;

		}
		return confirmingCommunicateDeniedDecisionPageNavigation;
	}
	// Function for Clicking New Document button in Documents section...

	public static void clickingNewDocumentsButton(String testCaseName, Browser browser) {

		boolean fnStatus = false;
		try {
			fnStatus = fnButtonClick(browser, btnNewDocuments);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on New Document button");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingNewDocumentsButton is : ", t);

		}

	}

	// Function for confirming New Document page navigation..
	public static void confirmingNewDocumentPageNavigation(String testCaseName, Browser browser) {

		try {
			boolean fnStatus = isElementExist(browser, txtNewDocumentsHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "User navigated to New Document Page");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingNewDocumentPageNavigation is :", t);
		}

	}

	// Function for checking Fields are available in Document edit screen
	// section based on user inputs..
	public static boolean checkingDocumentEditScreenSecFields(Browser browser, String inputFieldValues) {
		boolean checkingDocumentEditScreenSecFields = false;
		try {
			boolean fnStatus = isElementExist(browser, sectionDocumentsInfo);

			if (fnStatus == true) {
				fnStatus = GenericClass.fieldAvailabilityValidation(browser, inputFieldValues, sectionDocumentsInfo);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "pass",
							"Document Edit Screen Section fields are: " + inputFieldValues + "Displayed !!");
					checkingDocumentEditScreenSecFields = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "Fail",
							"Document Edit Screen Section fields are not verified !!");
					checkingDocumentEditScreenSecFields = true;
				}
			} else {
				ReportEvent.testStepReport(tTestCaseName, "Fail", "Document Edit Screen Section is not available!!");
				errorCount++;
				checkingDocumentEditScreenSecFields = true;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for checkingDocumentEditScreenSecFields is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for checkingDocumentEditScreenSecFields is : " + t.getMessage());
			softAssert.fail("The Exception for checkingDocumentEditScreenSecFields is : " + t.getMessage());
			errorCount++;
			checkingDocumentEditScreenSecFields = false;
		}
		return checkingDocumentEditScreenSecFields;
	}

	// Function for filling required fields in document edit screen based on
	// user inputs..

	public static void fillingRequiredFieldsInDocumentInfo(String testCaseName, Browser browser, String documentLabel,
			String documentName, String typeLabel, String typeValue, String documentTypeLabel, String documentTypeValue,
			String documentDescLabel, String documentDesc, String docReceivedDate) {
		boolean fnStatus = false;
		try {

			fnStatus = isElementExist(browser, sectionDocumentsInfo);
			if (fnStatus = true) {
				// Enter document name..
				fnStatus = GenericClass.sendKeysToTextBoxByLabel(browser, documentLabel, documentName);
				GenericClass.reportlogger(fnStatus, testCaseName, "Entered Document name as: " + documentName);

				// Select type..
				fnStatus = GenericClass.selectValueByVisibleTextByLabelWithoutContains(browser, typeLabel, typeValue);
				GenericClass.reportlogger(fnStatus, testCaseName, "Selected Type List box Value as: " + typeValue);

				// Select Document type..
				fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, documentTypeLabel,
						documentTypeValue);
				GenericClass.reportlogger(fnStatus, testCaseName,
						"Selected Document Type List Box Value as: " + documentTypeValue);

				// Select Document desc..
				fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, documentDescLabel, documentDesc);
				GenericClass.reportlogger(fnStatus, testCaseName,
						"Selected Document Description Value as: " + documentDesc);

				// Selecting Document Received date..
				String receivedDateXpath = sectionDocumentsInfo.concat("//input[contains(@name,'A2JFe')]");
				GenericClass.fnClikEditOrDateField(browser, receivedDateXpath);
				// Function for selecting a Birth date
				fnStatus = GenericClass.datePicker(browser, datePicker,
						GenericClass.dateConversion(docReceivedDate, "FullMonth/dd/yyyy"));
				GenericClass.reportlogger(fnStatus, testCaseName,
						"Selected Document Received date  as:" + docReceivedDate);

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", sectionDocumentsInfo + ", Section is not available.");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for fillingRequiredFieldsInDocumentInfo is : ", t);

		}

	}

	// Function to click on either Save Or Save & New Or Cancel button of "Task
	// Edit", Page based on the user inputs..
	public static void clickButtonOfDocumentEditPage(String testCaseName, Browser browser, String buttonName) {

		try {
			boolean fnStatus = false;

			isElementExist(browser, buttonXpathDocumentEdit_prefix + buttonName + buttonXpathDocumentEdit_suffix);
			fnStatus = fnButtonClick(browser,
					buttonXpathDocumentEdit_prefix + buttonName + buttonXpathDocumentEdit_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button ");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfDocumentEditPage is : ", t);

		}

	}

	// Function for verifying the buttons in Document Details section based on
	// user inputs..
	public static void checkingButtonsInDocumentDetailPage(String testCaseName, Browser browser,
			String inputFieldValues) {

		boolean fnStatus = false;
		try {
			String buttonXpath = "//h2[text()='Document Detail']/../../../../..";
			isElementExist(browser, buttonXpath);
			fnStatus = GenericClass.buttonsAvailabilityValidation(browser, inputFieldValues, buttonXpath);
			GenericClass.reportlogger(fnStatus, testCaseName, "Document Details Buttons are: " + inputFieldValues);
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for checkingButtonsInDocumentDetailPage is : ", t);
		}

	}

	// Function for Clicking Done button in Attachment file section...

	public static void clickButtonOfDocumentDetailsPage(String testCaseName, Browser browser, String buttonName) {

		try {
			boolean fnStatus = false;

			isElementExist(browser, buttonXpathDocumentDetail_prefix + buttonName + buttonXpathDocumentDetail_suffix);
			fnStatus = fnButtonClick(browser,
					buttonXpathDocumentDetail_prefix + buttonName + buttonXpathDocumentDetail_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfDocumentEditPage is : ", t);

		}

	}

	// Function for confirming Attach File to Document SampleDoc page
	// navigation..
	public static void confirmingAttachFilePageNavigation(String testCaseName, Browser browser, String docName) {

		try {
			isElementExist(browser, txtAttachFileHeader);
			WebElement ele = browser.describe(WebElement.class, new XPathDescription(txtAttachFileHeader));
			String attachmentText = ele.getInnerText();

			if (attachmentText.contains("Attach File to Document")) {
				ReportEvent.testStepReport(testCaseName, "pass",
						"User navigated to Attach File to Document " + docName + "  Page successfully!!");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to navigate to Attach File to Document Page");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingAttactFilePageNavigation is : ", t);
		}

	}

	// Function for Clicking Choose file or Attach file in file button in File
	// upload section...

	public static boolean clickButtonOfFileUploadingPage(Browser browser, String buttonName) {
		boolean clickButtonOfFileUploadingPage = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//div[@class='genericPageBlockTable']//table//input[@name ='" + buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Clicked on " + buttonName + ", button successfully.");
					clickButtonOfFileUploadingPage = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail("Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfFileUploadingPage = false;
				}

			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfFileUploadingPage = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickButtonOfDocumentEditPage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickButtonOfDocumentEditPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickButtonOfDocumentEditPage is : " + t.getMessage());
			errorCount++;
			clickButtonOfFileUploadingPage = false;
		}
		return clickButtonOfFileUploadingPage;

	}

	/*
	 * //Function for Click Browse to attach file from computer, click Attach
	 * file, then click Done. public static void
	 * browseToAttachFileFromComputer(String testCaseName, Browser
	 * browser,String choosefileButton,String filePath,String attachFileButton)
	 * throws GeneralLeanFtException { boolean fnStatus= false; try {
	 * fnStatus=clickButtonOfFileUploadingPage(browser, choosefileButton);
	 * if(fnStatus=true) { ComboBox combo= browser.describe(Dialog.class, new
	 * DialogDescription.Builder() .ownedWindow(true).childWindow(false).text(
	 * "Choose File to Upload"
	 * ).nativeClass("#32770").build()).describe(ComboBox.class, new
	 * ComboBoxDescription.Builder() .attachedText("File &name:"
	 * ).nativeClass("ComboBox").build());
	 * 
	 * combo.highlight(); combo.select(filePath); UiObject button=
	 * browser.describe(Dialog.class, new DialogDescription.Builder()
	 * .ownedWindow(true).childWindow(false).text("Choose File to Upload"
	 * ).nativeClass("#32770").build()).describe(UiObject.class, new
	 * UiObjectDescription.Builder()
	 * .windowClassRegExp("Button").windowId(1).build()); button.highlight();
	 * button.click();
	 * 
	 * fnStatus=clickButtonOfFileUploadingPage(browser, attachFileButton);
	 * GenericClass.reportlogger(fnStatus, testCaseName,
	 * "Document attachment file uploaded"); } else {
	 * ReportEvent.testStepReport(testCaseName, "fail",
	 * "Failed to click Browse button"); } } catch (Throwable t) {
	 * GenericClass.Catchhandler(
	 * "Exception arised in browseToAttachFileFromComputer is :", t); }
	 * 
	 * 
	 * }
	 */

	// Function for Clicking Done button in Uploding the document...

	public static void clickingDoneButton(String testCaseName, Browser browser) {
		boolean fnStatus = false;
		try {
			fnStatus = fnButtonClick(browser, btnDone);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on Done button ");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingDoneButton is : ", t);
		}

	}

	// Function for confirming Attach File page navigation..
	public static void confirmingAttachFileHeaderPageNavigation(String testCaseName, Browser browser) {
		boolean fnStatus = false;
		try {
			fnStatus = isElementExist(browser, txtAttachFileUploadHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "User navigated to Attach File Page");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingAttachFilePageNavigation is : ", t);
		}

	}

	// Function for Changing the status Reason to Reopen..
	public static void ChangingStatusReasonDropdownfieldValue(String testCaseName, Browser browser,
			String statusReasonlLabel, String statusReasonValue) {

		try {
			boolean fnStatus = false;

			fnStatus = GenericClass.selectValueByVisibleTextBasedOnLabel(browser, statusReasonlLabel,
					statusReasonValue);
			GenericClass.reportlogger(fnStatus, testCaseName,"Changed to Status Reason Listbox value as: " + statusReasonValue + " ,");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for ChangingStatusReasonDropdownfieldValue is : ", t);

		}

	}

	// Function for verifying the Decision reason section field values..
	public static void verifyingDecisionReasonSecFieldValues(String testCaseName, Browser browser, String statusField,
			String statusReasonField, String statusValue, String reasonValue) {

		try {
			boolean fnStatus = false;
			// Status field changed to Pending
			String fieldValue = GenericClass.getFieldValueOfSection(browser, statusField, sectionDecision);
			if (fieldValue.equals(statusValue)) {
				ReportEvent.testStepReport(testCaseName, "pass",
						"Status Field value as : " + fieldValue + " should be Verified successfully!!");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to Change Status Field as:  " + fieldValue + "");

			}
			// Status reason field changed to Reopen..
			String reasonFieldValue = GenericClass.getFieldValueOfSection(browser, statusReasonField, sectionDecision);
			if (reasonFieldValue.equals(reasonValue)) {
				ReportEvent.testStepReport(testCaseName, "pass",
						"Status Reason Field value as : " + reasonFieldValue + " should be Verified successfully!!");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to Change Status Reason Field as:  " + reasonFieldValue + "");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for vefiryingDecisionReasonSecFieldValues is : ", t);

		}

	}

	// Clicking on Name related link of Open activity action types..
	public static void clickingLinkOfOpenActivitySecActionType(String testCaseName, Browser browser, String subjectName,
			String actionType) {

		int j = 0;
		try {
			boolean fnStatus = false;
			String tableXpath = sectionOpenActivities.concat("//following-sibling::div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {

					String aTagXPath = tableXpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());
					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(subjectName)) {

							for (Link atagElement : allLinks) {
								String atagElementText = atagElement.getInnerText();
								if (atagElementText.equals(actionType)) {
									String elementXpath = aTagXPath + "[text()='" + actionType + "']";
									fnStatus = GenericClass.fnClickLinkInLinkClass(browser, elementXpath);
									if (fnStatus == true) {
										ReportEvent.testStepReport(testCaseName, "Pass",
												"Clicked on Cls Link on  'Benefit Claim Reopened' task Successfully");
										break outerloop;
									} else {
										ReportEvent.testStepReport(testCaseName, "fail",
												"Failed to click Open Activity action");

									}

								} else {
									continue;

								}
							}
						} else {
							continue;
						}

					}
				}

			} else {

				ReportEvent.testStepReport(testCaseName, "fail", "Open Activity dynamic table is not available");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingLinkOfOpenActivitySecActionType is : ", t);

		}

	}

	// Function for verifying the Error messages in Benefit claimed edit page..
	public static List<String> getErrorMessagesOfSection(Browser browser) {
		List<String> errorMegs = new ArrayList<String>();
		try {
			String errorMesgXpath = "//h2[text()='Benefit Claimed Edit']/../../../../..//parent::div//div[@class='errorMsg']";

			WebElement[] allErrorMessges = browser.findChildren(WebElement.class, new XPathDescription(errorMesgXpath));

			for (WebElement errorText : allErrorMessges) {

				System.out.println(errorText.getInnerText());
				errorMegs.add(errorText.getInnerText());
			}

		} catch (Throwable t) {
			System.out.println("The Exception for getInputButtonsOfSection is : " + t.getMessage());
			utility.fnLogging("The Exception for getInputButtonsOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getInputButtonsOfSection is : " + t.getMessage());
		}

		return errorMegs;
	}

	public static boolean sectionErrorMessagesValidation(Browser browser, String inputFieldValues) {
		int matchedFieldCounter = 0;
		boolean sectionErrorMessagesValidation = false;
		try {
			String splitInputFields[] = inputFieldValues.split(",");
			List<String> splitInputFieldsList = new ArrayList<String>();
			splitInputFieldsList = Arrays.asList(splitInputFields);
			int inputFieldCount = splitInputFieldsList.size();
			List<String> pageSource = getErrorMessagesOfSection(browser);
			for (int i = 0; i <= inputFieldCount - 1; i++) {
				if (pageSource.contains(splitInputFieldsList.get(i))) {
					matchedFieldCounter++;
				} else {
					continue;
				}
			}
			if (matchedFieldCounter == inputFieldCount) {
				sectionErrorMessagesValidation = true;
			} else {
				int difference = inputFieldCount - matchedFieldCounter;
				ReportEvent.testStepReport("", "FAIL", difference + "is count of unmatched Error Messages names.");
				sectionErrorMessagesValidation = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for sectionErrorMessagesValidation is : " + t.getMessage());
			utility.fnLogging("The Exception for sectionErrorMessagesValidation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for sectionErrorMessagesValidation is : " + t.getMessage());
			// softAssert.fail("The Exception for fieldAvailabilityValidation is
			// : " + t.getMessage());
			sectionErrorMessagesValidation = false;
		}

		return sectionErrorMessagesValidation;
	}

	// Function for clicking Occupational Tab in Case management page..

	public static boolean clickingOccupationalTab(Browser browser) {
		boolean clickingOccupationalTab = false;
		try {
			boolean fnStatus = isElementExist(browser, btnOccupational);
			fnStatus = fnWebElementClick(browser, btnOccupational);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on Occupational Tab successfully.");
				clickingOccupationalTab = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on Occupational Tab.");
				softAssert.fail("Failed to click on Occupational Tab.");
				errorCount++;
				clickingOccupationalTab = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for clickingOccupationalTab is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickingOccupationalTab is : " + t.getMessage());
			softAssert.fail("The Exception for clickingOccupationalTab is : " + t.getMessage());
			errorCount++;
			clickingOccupationalTab = false;
		}
		return clickingOccupationalTab;
	}

	// Function for checking occupational section availability...
	public static boolean isOccupationalSectionAvailability(Browser browser) {
		boolean isOccupationalSectionAvailability = false;
		try {
			boolean fnStatus = isElementExist(browser, sectionOccupational);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass", "Occupational Section should be available!!");
				isOccupationalSectionAvailability = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Occupational Section is not available");
				errorCount++;
				isOccupationalSectionAvailability = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for isOccupationalSectionAvailability is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for isOccupationalSectionAvailability is : " + t.getMessage());
			softAssert.fail("The Exception for isOccupationalSectionAvailability is : " + t.getMessage());
			errorCount++;
			isOccupationalSectionAvailability = false;

		}
		return isOccupationalSectionAvailability;
	}

	// Function for filling occupational items section fields based on user
	// inputs..
	public static boolean fillingOccupationalItemsFields(Browser browser,
			/* String titleLabel, */String titleValues, /* String jobLabel, */String jobClassification) {
		boolean fillingOccupationalItemsFields = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionOccupational);
			if (fnStatus == true) {
				// Enter Title..
				String titleXpath = sectionOccupational
						.concat("//input[contains(@name,'p:f:occupationalBlock:j_id1217')]");
				String jobClassXpath = sectionOccupational
						.concat("//select[contains(@name,'p:f:occupationalBlock:j_id1217:j_id1219')]");
				// fnStatus=sendKeysToTextBoxByLabel(browser, titleLabel,
				// titleValues);

				fnStatus = fnEditFieldTextEntry(browser, titleXpath, titleValues);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Entered Title as: " + titleValues + " successfully.");
					fillingOccupationalItemsFields = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Filed to enter Title");
					softAssert.fail("Filed to enter Title");
					errorCount++;
					fillingOccupationalItemsFields = false;

				}
				// Select Job Classification type..
				// fnStatus=selectValueByVisibleTextBasedOnLabel(browser,
				// jobLabel, jobClassification);
				fnStatus = GenericClass.fnClickListBox(browser, jobClassXpath);
				fnStatus = fnListBox(browser, jobClassXpath, jobClassification);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Selected Job Classification Type as: " + jobClassification);
					fillingOccupationalItemsFields = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Filed to select Job Classification Type value.");
					softAssert.fail("Filed to select Job Classification Type value.");
					errorCount++;
					fillingOccupationalItemsFields = false;

				}
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Occupational Section is not available");
				errorCount++;
				fillingOccupationalItemsFields = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for fillingOccupationalItemsFields is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for fillingOccupationalItemsFields is : " + t.getMessage());
			softAssert.fail("The Exception for fillingOccupationalItemsFields is : " + t.getMessage());
			errorCount++;
			fillingOccupationalItemsFields = false;
		}
		return fillingOccupationalItemsFields;
	}

	// Function for Clicking Save and Undo button in Occupational section...

	public static boolean clickButtonOfOccupationalSec(Browser browser, String buttonName) {
		boolean clickButtonOfOccupationalSec = false;
		try {
			boolean fnStatus = false;
			String buttonXpath = "//h2[text()='Occupational']/../../../..//input[@value ='" + buttonName + "']";
			fnStatus = isElementExist(browser, buttonXpath);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, buttonXpath);
				if (fnStatus == true) {
					ReportEvent.testStepReport(tTestCaseName, "Pass",
							"Clicked on " + buttonName + ", button successfully.");
					clickButtonOfOccupationalSec = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail("Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfOccupationalSec = false;
				}

			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfOccupationalSec = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickButtonOfOccupationalSec is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickButtonOfOccupationalSec is : " + t.getMessage());
			softAssert.fail("The Exception for clickButtonOfOccupationalSec is : " + t.getMessage());
			errorCount++;
			clickButtonOfOccupationalSec = false;
		}
		return clickButtonOfOccupationalSec;

	}

	// Function for Selecting OK or Cancel button of Dialog box..
	public static boolean clickOKbuttonOfDialogBox(Browser browser, String buttonName) {
		boolean clickingOKbuttonOfDialogBox = false;
		try {
			boolean fnStatus = true;
			/*
			 * browser.describe(Dialog.class, new DialogDescription.Builder()
			 * .text("Message from webpage").build()).describe(Button.class, new
			 * ButtonDescription.Builder() .windowTitleRegExp("OK").build());
			 */
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "Pass",
						"Clicked on " + buttonName + ", button successfully.");
				clickingOKbuttonOfDialogBox = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
				softAssert.fail("Failed to click on " + buttonName + ", button.");
				errorCount++;
				clickingOKbuttonOfDialogBox = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for clickingOKbuttonOfDialogBox is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingOKbuttonOfDialogBox is : " + t.getMessage());
			softAssert.fail("The Exception for clickingOKbuttonOfDialogBox is : " + t.getMessage());
			errorCount++;
			clickingOKbuttonOfDialogBox = false;
		}
		return clickingOKbuttonOfDialogBox;
	}

	// Function for confirming Benefit Claimed Creation - Benefit Claimed
	// Details screen navigation..
	public static boolean confirmingBenefitClaimedCreationDetailPageNavigation(Browser browser) {
		boolean confirmingBenefitClaimedCreationDetailPageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtBenefitClaimCreationHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Benefit Claimed Creation - Benefit Claimed Details Page!!");
				confirmingBenefitClaimedCreationDetailPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Failed to navigate to Benefit Claimed Creation - Benefit Claimed Details Page");
				errorCount++;
				confirmingBenefitClaimedCreationDetailPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println(
					"The Exception for confirmingBenefitClaimedCreationDetailPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingBenefitClaimedCreationDetailPageNavigation is : " + t.getMessage());
			softAssert.fail(
					"The Exception for confirmingBenefitClaimedCreationDetailPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingBenefitClaimedCreationDetailPageNavigation = false;

		}
		return confirmingBenefitClaimedCreationDetailPageNavigation;
	}

	// Function for confirming Benefit Claimed Creation - Benefit Claimed
	// Details screen navigation..
	public static boolean verifyingCurrentBenefitClaimedSectionAvailability(Browser browser) {
		boolean verifyingCurrentBenefitClaimedSectionAvailability = false;
		try {
			boolean fnStatus = isElementExist(browser, txtCurrentBenefitClaimedHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"'Current Benefit Claimed' section should be displayed on top left cornor!!");
				verifyingCurrentBenefitClaimedSectionAvailability = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Failed to display 'Current Benefit Claimed' section on top left cornor ");
				errorCount++;
				verifyingCurrentBenefitClaimedSectionAvailability = false;
			}
		} catch (Throwable t) {
			System.out.println(
					"The Exception for verifyingCurrentBenefitClaimedSectionAvailability is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for verifyingCurrentBenefitClaimedSectionAvailability is : " + t.getMessage());
			softAssert
					.fail("The Exception for verifyingCurrentBenefitClaimedSectionAvailability is : " + t.getMessage());
			errorCount++;
			verifyingCurrentBenefitClaimedSectionAvailability = false;

		}
		return verifyingCurrentBenefitClaimedSectionAvailability;
	}

	// Function for confirming Task Edit page navigation..
	public static void confirmingTaskEditPageNavigation(String testCaseName, Browser browser) {
		boolean fnStatus = false;
		try {
			fnStatus = isElementExist(browser, txtTaskEditHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "User Navigated to Task Edit Page");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingTaskEditPageNavigation is : ", t);

		}

	}

	// Function for clicking Benefit claimed ID from Search Results page..
	public static boolean clickingBenefitClaimedIdInSearchResultsPage(Browser browser, String contactName) {
		boolean clickingBenefitClaimedIdInSearchResultsPage = false;
		try {
			boolean fnStatus = false;
			String tableXpath = tblBenefitClaimed;
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 1; i <= rowCount; i++) {
					String aTagXpath = tableXpath.concat("//th/a");
					Link[] aTags = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXpath).build());
					for (Link cellText : aTags) {
						if (cellText.getInnerText().equals(contactName)) {
							cellText.click();
							clickingBenefitClaimedIdInSearchResultsPage = true;
							break outerloop;
						} else {
							continue;
						}
					}
				}

				clickingBenefitClaimedIdInSearchResultsPage = true;
			} else {
				System.out.println("Search Benefit Claimed dynamic table is not available");
				errorCount++;
				clickingBenefitClaimedIdInSearchResultsPage = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickingBenefitClaimedIdInSearchResultsPage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingBenefitClaimedIdInSearchResultsPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickingBenefitClaimedIdInSearchResultsPage is : " + t.getMessage());
			errorCount++;
			clickingBenefitClaimedIdInSearchResultsPage = false;
		}
		return clickingBenefitClaimedIdInSearchResultsPage;

	}

	// Function for verifying the data is auto papulated in New Document page..

	public static boolean verifyingAutoPapulatedValues(Browser browser) {
		boolean verifyingAutoPapulatedValues = false;
		String claimXapth = "//input[contains(@name,'CF00NA')]/..//child::span[@class='lookupInput']//input[@class='readonly']";
		String benefitClaimedXpath = "//input[contains(@name,'A2Irc')]/..//child::span[@class='lookupInput']//input";
		try {
			boolean fnStatus = false;
			// Claim Value
			EditField claim = browser.describe(EditField.class, new XPathDescription(claimXapth));
			claim.highlight();
			String claimValue = claim.getInnerText();
			if (claimValue != null) {
				ReportEvent.testStepReport(tTestCaseName, "PASS", "Claim value as :" + claimValue + "Auto populated");
				verifyingAutoPapulatedValues = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "Fail", "Claim value is not Auto populated");
				return verifyingAutoPapulatedValues;
			}
			// Benefit claimed
			EditField benefitclaimed = browser.describe(EditField.class, new XPathDescription(benefitClaimedXpath));
			benefitclaimed.highlight();
			String bcValue = claim.getInnerText();
			if (bcValue != null) {
				ReportEvent.testStepReport(tTestCaseName, "PASS",
						"Benefit Claimed value as :" + benefitclaimed + "Auto populated");
				verifyingAutoPapulatedValues = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "Fail", "Benefit Claimed value is not Auto populated");
				return verifyingAutoPapulatedValues;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for clickingBenefitClaimedIdInSearchResultsPage is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingBenefitClaimedIdInSearchResultsPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickingBenefitClaimedIdInSearchResultsPage is : " + t.getMessage());
			errorCount++;
			verifyingAutoPapulatedValues = false;
		}
		return verifyingAutoPapulatedValues;
	}

	// Function for clicking Benefit claimed link in Document details section..
	public static boolean clickingBenefitClaimedLink(Browser browser) {
		boolean clickingBenefitClaimedLink = false;
		try {
			boolean fnStatus = GenericClass.fnClickLinkInLinkClass(browser, lnkBenefitClaimed);
			if (fnStatus = true) {
				ReportEvent.testStepReport(tTestCaseName, "PASS", "Clicked Benefit Claimed ID link Successfully");
				clickingBenefitClaimedLink = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "Fail", "Failed to click Benefit claimed link");
				clickingBenefitClaimedLink = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickingBenefitClaimedLink is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingBenefitClaimedLink is : " + t.getMessage());
			softAssert.fail("The Exception for clickingBenefitClaimedLink is : " + t.getMessage());
			errorCount++;
			clickingBenefitClaimedLink = false;
		}
		return clickingBenefitClaimedLink;
	}

	// Function for confirming Document page navigation..
	public static boolean confirmingDocumentPageNavigation(Browser browser) {
		boolean confirmingDocumentPageNavigation = false;
		try {
			boolean fnStatus = isElementExist(browser, txtDocumentHeader);
			if (fnStatus == true) {
				ReportEvent.testStepReport(tTestCaseName, "pass",
						"User navigated to Document Page After cliking Save button.!!");
				confirmingDocumentPageNavigation = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to navigate to Document Page");
				errorCount++;
				confirmingDocumentPageNavigation = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for confirmingDocumentPageNavigation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for confirmingDocumentPageNavigation is : " + t.getMessage());
			softAssert.fail("The Exception for confirmingDocumentPageNavigation is : " + t.getMessage());
			errorCount++;
			confirmingDocumentPageNavigation = false;

		}
		return confirmingDocumentPageNavigation;
	}

	// Function for Refreshing the benefit claimed page..

	public static void refreshingBenefitClaimedPage(String testCaseName, Browser browser) {
		boolean fnStatus = false;
		try {
			fnStatus = isElementExist(browser, txtBenefitClaimedHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "Benefit Claimed Page refreshed");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for refreshingBenefitClaimedPage is : ", t);
		}

	}

	// Function to click on either NewTask Or CloseTask button of "OpenActivity
	// Section" based on the user inputs..
	public static void clickButtonOfOpenActivitySection(String testCaseName, Browser browser, String buttonName) {

		try {
			boolean fnStatus = false;
			isElementExist(browser, buttonXpathOpenActivities_prefix + buttonName + buttonXpathOpenActivities_suffix);
			fnStatus = fnButtonClick(browser,
					buttonXpathOpenActivities_prefix + buttonName + buttonXpathOpenActivities_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button ");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfOpenActivitySection is : ", t);

		}

	}

	// Function for verifying the status for approval and Decision reason field
	// values..
	public static void validatingDecisionReasonSecFieldValues(String testCaseName, Browser browser,
			String statusApprovalField, String decisionReasonField, String statusApprovalValue, String decisionValue) {

		try {
			boolean fnStatus = false;
			// Status field changed to Pending
			String fieldValue = GenericClass.getFieldValueOfSection(browser, statusApprovalField, sectionDecision);
			if (fieldValue.equals(statusApprovalValue)) {
				ReportEvent.testStepReport(testCaseName, "pass",
						"Status for approval Field value  : " + fieldValue + " should be Verified!!");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to verify Status for approval Field value.");

			}
			// Status reason field changed to Reopen..
			String reasonValue = GenericClass.getFieldValueOfSection(browser, decisionReasonField, sectionDecision);
			if (reasonValue.equals(decisionValue)) {
				ReportEvent.testStepReport(testCaseName, "pass",
						"Decision Reason Field value: " + reasonValue + " should be Verified!!");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to Change Status Reason Field as:  " + fieldValue + "");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingDecisionReasonSecFieldValues is : ", t);

		}

	}

	public static final String txtTaskPageHeader = "//div[@class='content']/h1[text()='Task']";

	// Function for clicking Subject link in Open Activities section based on
	// user inputs..
	public static void clickingSubjectOfOpenActivitiesSec(String testCaseName, Browser browser, String subjectValue) {

		int j = 0;
		try {
			boolean fnStatus = false;
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {

					String aTagXPath = tableXpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());

					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(subjectValue)) {
							String subjectAtag = tableXpath + "//tr[" + i + "]//a[text()[contains(.,'" + subjectValue
									+ "')]]";
							fnStatus = GenericClass.fnClickLinkInLinkClass(browser, subjectAtag);
							if (fnStatus == true) {
								ReportEvent.testStepReport(testCaseName, "Pass",
										"Clicked on " + subjectValue + " : subject of Open Activities section");
								break outerloop;
							} else {
								ReportEvent.testStepReport(testCaseName, "fail",
										"Failed to click subject of Open Activities section");
							}

						} else {
							continue;
						}

					}
				}

			} else {

				ReportEvent.testStepReport(testCaseName, "fail", "Open Activities dynamic table is not available");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingSubjectOfOpenActivitiesSec is : ", t);

		}

	}

	// Function for confirming Task page navigation..
	public static void confirmingTaskPageNavigation(String testCaseName, Browser browser) {
		boolean fnStatus = false;

		try {
			fnStatus = isElementExist(browser, txtTaskPageHeader);
			GenericClass.reportlogger(fnStatus, testCaseName, "User navigated to Task Details Page ");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for confirmingTaskPageNavigation is : ", t);

		}

	}

	// Function to click on any button of "Task Detail", Page based on the user
	// inputs..
	public static void clickButtonOfTaskDetailPage(String testCaseName, Browser browser, String buttonName) {
		try {
			boolean fnStatus = false;
			isElementExist(browser, buttonXpathTask_prefix + buttonName + buttonXpathTask_suffix);
			fnStatus = fnButtonClick(browser, buttonXpathTask_prefix + buttonName + buttonXpathTask_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + buttonName + ", button ");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickButtonOfTaskDetailPage is : ", t);

		}

	}

	// Function for selecting status dropdown value based on user inputs..
	public static void addingCommentsInTaskEditPage(String testCaseName, Browser browser, String labelName,
			String labelValue) {

		try {
			boolean fnStatus = false;
			fnStatus = GenericClass.sendKeysToAreaTextBoxByLabel(browser, labelName, labelValue);
			GenericClass.reportlogger(fnStatus, testCaseName, "Added comments as: " + labelValue);

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for addingCommentsInTaskEditPage is : ", t);

		}

	}

	public static String sectionTaskDetail = "//h2[text()='Task Detail']/ancestor::div[@class='pbHeader']/following-sibling::div[@class='pbBody']/div[2]";

	// Function to click On link ofTask detail section based on label.
	public static void clickLinkOfTaskDetailSection(String testCaseName, Browser browser, String fieldName) {
		boolean fnStatus = false;

		try {
			fnStatus = GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, fieldName, sectionTaskDetail);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on link of" + fieldName + ", button");

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in clickLinkOfTaskDetailSection is : ", t);
		}

	}

	// Function for selecting last date of working in benefit claimed section..
	public static void selectingLastWorkDate(String testCaseName, Browser browser, String lostWorkDate) {
		boolean fnStatus = false;
		try {

			fnStatus = GenericClass.fnClikEditOrDateField(browser, lostWorkDateXpath);

			if (fnStatus == true) {
				fnStatus = GenericClass.datePicker(browser, datePicker,
						GenericClass.dateConversion(lostWorkDate, "FullMonth/dd/yyyy"));
				GenericClass.reportlogger(fnStatus, testCaseName, "Selected Last Day at work as:" + lostWorkDate);

			}

			else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Didn't clicked on Last Day at work text box");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for selectingLastWorkDate is : ", t);

		}

	}

	// Function to select date based on label and the date passed by user of
	// information section.

	public static void selectDateOfInformationSection(String testCaseName, Browser browser, String labelName,
			String inputDate) {

		try {
			boolean fnStatus = false;
			fnStatus = GenericClass.selectingDateBasedOnLabel(browser, sectionInformation, labelName, inputDate);
			GenericClass.reportlogger(fnStatus, testCaseName, "Selected \"" + labelName + "\" as + : " + inputDate);

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for selectDateOfInformationSection is : ", t);

		}
	}

	// Function for Verifying New tasks are Updated in Open Activity Section..
	public static void validatingNewTaskDisplayedOpenActivitySec(String testCaseName, Browser browser,
			String subjectValue) {
		try {
			boolean fnStatus = false;
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 1; i <= rowCount; i++) {
					String subjectxPath = tableXpath.concat("//th/a");
					Link[] aTagObject = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(subjectxPath).build());

					for (Link cell : aTagObject) {

						if (cell.getInnerText().contains(subjectValue)) {

							cell.highlight();
							ReportEvent.testStepReport(testCaseName, "PASS", "NewTask value :'" + subjectValue
									+ "' Should be Displayed in Open Activity Section. ");
							break outerloop;
						} else {
							continue;

						}

					}
				}
			}

			else {

				ReportEvent.testStepReport("", "Fail", " Open Activity Section dynamic table is not available");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in validatingNewTaskDisplayedOpenActivitySec is ", t);

		}

	}

	// Function for validating the business days in open activity section based
	// on user inputs..

	/*
	 * public static boolean validatingDueBusinessDays(Browser browser, int
	 * businessDays,String primaryKey, String primaryHeader, String
	 * columnHeader1, String columnHeader2) {
	 * 
	 * boolean validatingDueBusinessDays = false;
	 * 
	 * try { boolean fnStatus = false; String
	 * businessDate=GenericClass.gettingRequiredBusinessDayDate(businessDays);
	 * String tableXpath =
	 * sectionOpenActivities.concat("//div[@class='pbBody']//table"); String
	 * lastModifiedDate=GenericClass.getColumnValueFromTable(browser,
	 * tableXpath, primaryKey, primaryHeader, columnHeader1); String
	 * dueDate=GenericClass.getColumnValueFromTable(browser, tableXpath,
	 * primaryKey, primaryHeader, columnHeader2);
	 * 
	 * DateFormat s = new SimpleDateFormat("m/dd/yyyy"); Date dt1 =
	 * (Date)s.parse(lastModifiedDate); Date dt2 = (Date)s.parse(dueDate);
	 * DateFormat requiredFormat = new SimpleDateFormat("yyyy-m-d"); Date
	 * tempDate1 = java.sql.Date.valueOf(requiredFormat.format(dt1)); Date
	 * tempDate2 = java.sql.Date.valueOf(requiredFormat.format(dt2)); int
	 * dayDiff = tempDate2.compareTo(tempDate1); if((dayDiff+1)==businessDays) {
	 * ReportEvent.testStepReport(tTestCaseName, "PASS", "Last Modified date : "
	 * +lastModifiedDate + " and Due date : "+ dueDate +" are in : "
	 * +businessDays+" Business days as expected. " );
	 * validatingDueBusinessDays=true; } else {
	 * ReportEvent.testStepReport(tTestCaseName, "PASS", "Last Modified date : "
	 * +lastModifiedDate + " and Due date : "+ dueDate +" are NOT in : "
	 * +businessDays+" Business days as expected. " );
	 * validatingDueBusinessDays=false; }
	 * 
	 * 
	 * 
	 * if(businessDate.equals(dueDate)) {
	 * ReportEvent.testStepReport(tTestCaseName, "PASS", "Due Date :'"
	 * +businessDate+"' Should be 2 Business days. " );
	 * validatingDueBusinessDaysInOpenActivitySec=true; } else {
	 * ReportEvent.testStepReport(tTestCaseName, "Fail", "Due Date :'"
	 * +businessDate+"' is not in 2 Business days" );
	 * validatingDueBusinessDaysInOpenActivitySec=false;
	 * 
	 * }
	 * 
	 * } catch(Throwable t) { System.out.println(
	 * "The Exception for validatingDueBusinessDays is : " + t.getMessage());
	 * ReportEvent.testStepReport("", "fail",
	 * "The Exception for validatingDueBusinessDays is : " + t.getMessage());
	 * softAssert.fail("The Exception for validatingDueBusinessDays is : " +
	 * t.getMessage()); errorCount++; validatingDueBusinessDays = false; }
	 * 
	 * return validatingDueBusinessDays; }
	 */

	// Function for Clicking 'ALL' Check boxes in Open Activity Section under
	// column as Action Type in Benefit Claimed page..

	public static void clickingAllCheckboxOpenActivitySec(String testCaseName, Browser browser, String checkBoxStatus) {
		try {
			boolean fnStatus = isElementExist(browser, sectionOpenActivities);
			if (fnStatus == true) {
				String tableXpath = sectionOpenActivities.concat("//table[@class='list']");
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);

				for (int i = 1; i <= rowCount; i++) {

					String checkBoxXPath = tableXpath + "//tr[" + i + "]//input";
					fnStatus = GenericClass.fncheckBoxValidation(browser, checkBoxXPath, checkBoxStatus);
					if (fnStatus == true) {
						ReportEvent.testStepReport(testCaseName, "PASS",
								"Clicked on All Checkboxs under Action Column in Open Activities Section!!");
						break;
					} else {
						ReportEvent.testStepReport(testCaseName, "FAIL",
								"Failed to click on All Checkbox in Action Column");
					}
				}
			} else {
				ReportEvent.testStepReport(testCaseName, "fail", "Open Activity Section is not available");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingAllCheckboxOpenActivitySec is : ", t);

		}

	}

	/*
	 * public static void validatingDueBusinessDays(Browser browser, int
	 * businessDays, String primaryKey, String primaryHeader, String
	 * LastModifiedHeader, String dueDateHeader) { Date
	 * formattedLastModifiedDate = null; try { String tableXpath =
	 * sectionOpenActivities.concat("//div[@class='pbBody']//table"); String
	 * lastModifiedDate=GenericClass.getColumnValueFromTable(browser,
	 * tableXpath, primaryKey, primaryHeader, LastModifiedHeader); String
	 * dueDate=GenericClass.getColumnValueFromTable(browser, tableXpath,
	 * primaryKey, primaryHeader, dueDateHeader); DateFormat s = new
	 * SimpleDateFormat("M/dd/yyyy"); String[] strArray=
	 * lastModifiedDate.split("/"); int date = Integer.parseInt(strArray[1]);
	 * int month = ((Integer.parseInt(strArray[0]))-1); int year=
	 * Integer.parseInt(strArray[2]); Calendar lastModified =
	 * Calendar.getInstance(); lastModified.set(year, month, date); for(int
	 * i=0;i<businessDays;) { lastModified.add(lastModified.DAY_OF_MONTH, 1);
	 * 
	 * if((lastModified.get(lastModified.DAY_OF_WEEK)-2)<=5) {
	 * formattedLastModifiedDate = lastModified.getTime(); i++; }
	 * 
	 * }
	 * 
	 * String dueDateDesignValue=new
	 * SimpleDateFormat("M/dd/yyyy").format(formattedLastModifiedDate);
	 * if(dueDateDesignValue.equalsIgnoreCase(dueDate)) {
	 * 
	 * ReportEvent.testStepReport(tTestCaseName, "PASS", "Last Modified date : "
	 * +lastModifiedDate + " and Due date : "+ dueDate +" are in : "
	 * +businessDays+" Business days as expected. " ); //System.out.println(
	 * "Last Modified date : "+lastModifiedDate + " and Due date : "+ dueDate +
	 * " are in : "+businessDays+" Business days as expected. " ); } else { //
	 * System.out.println("Last Modified date : "+lastModifiedDate +
	 * " and Due date : "+ dueDate +" are NOT in : "+businessDays+
	 * " Business days." ); ReportEvent.testStepReport(tTestCaseName, "Fail",
	 * "Last Modified date : "+lastModifiedDate + " and Due date : "+ dueDate +
	 * " are NOT in : "+businessDays+" Business days."); } } catch(Throwable t)
	 * { System.out.println("The Exception for validatingDueBusinessDays is : "
	 * + t.getMessage()); ReportEvent.testStepReport("", "fail",
	 * "The Exception for validatingDueBusinessDays is : " + t.getMessage());
	 * softAssert.fail("The Exception for validatingDueBusinessDays is : " +
	 * t.getMessage()); errorCount++; } }
	 */
	// Function for validating the AssignTo user name Open Activity section
	// based on header name..
	public static void verifyingColumnValueOFOpenActivitySec(String testCaseName, Browser browser, String primaryKey,
			String primaryHeader, String columnHeader, String inputValue) {
		boolean verifyingColumnValueOFOpenActivitySec = false;
		String fieldVal = null;
		try {
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					columnHeader);
			if (fieldVal.equals(inputValue)) {
				ReportEvent.testStepReport(testCaseName, "Pass",
						"Assign To user " + fieldVal + ", Should be Verified successfully.");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to verify Assign To user  " + fieldVal + ".");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception for verifyingColumnValueOFOpenActivitySec() is ", t);

		}

	}

	// Function for checking field value in Decision reason section..

	public static void checkingFieldValueInDecisionSec(String testCaseName, Browser browser, String fieldName,
			String inputFieldValue) {

		String fieldValue = null;
		try {
			isElementExist(browser, sectionDecision);
			fieldValue = GenericClass.getFieldValueOfSection(browser, fieldName, sectionDecision);
			if (fieldValue.equals(inputFieldValue)) {
				ReportEvent.testStepReport(testCaseName, "Pass", "Verified  " + fieldName + " Field Vlaue as : "
						+ fieldValue + "  in : " + inputFieldValue + " Successfully. ");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to verify " + fieldName + " Field Vlaue as : " + fieldValue + ".");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception for checkingFieldValueInDecisionSec is :", t);
		}
	}

	// Function for validating to field value as blank based on lable name..
	public static void validatingFieldValueAsBlank(String testCaseName, Browser browser, String fieldName) {

		String fieldValue = null;
		try {
			isElementExist(browser, sectionDecision);
			fieldValue = GenericClass.getFieldValueOfSection(browser, fieldName, sectionDecision);
			if (fieldValue.length() != 0) {
				ReportEvent.testStepReport(testCaseName, "Pass", "" + fieldName + " Field  Should be in Null value.");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to " + fieldName + " Field is not having Null value.");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingFieldValueAsBlank is : ", t);

		}
	}

	// Function to validate Required check box status of Open activity
	// table.('Not Checked/Checked' are parameters of requiredChkBoxStatus)
	public static void validatingRequiredChkBoxOfOpenActivityTable(String testCaseName, Browser browser,
			String primaryKey, String primaryHeader, String columnHeader, String requiredChkBoxStatus) {

		String fieldVal = null;
		try {
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					columnHeader);

			if (fieldVal.equalsIgnoreCase(requiredChkBoxStatus)) {
				ReportEvent.testStepReport(testCaseName, "Pass",
						"Required check Box which is mapped to \"" + primaryKey + "\" task was :" + fieldVal);

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Please cross check the inputData as the application indicating 'Required' check box as :"
								+ fieldVal);

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingRequiredChkBoxOfOpenActivityTable is : ", t);

		}
	}

	// Function to validate Required check box status of Open activity
	// table.('Not Checked/Checked' are parameters of requiredChkBoxStatus)
	public static void validatingRequiredChkBoxOfActivityHistoryTable(Browser browser, String primaryKey,
			String primaryHeader, String columnHeader, String requiredChkBoxStatus) {
		boolean validatingRequiredChkBoxOfActivityHistoryTable = false;
		String fieldVal = null;
		try {
			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					columnHeader);
			if (fieldVal.equalsIgnoreCase(requiredChkBoxStatus)) {
				ReportEvent.testStepReport(tTestCaseName, "Pass",
						"Required check Box which is mapped to \"" + primaryKey + "\" task was :" + fieldVal);
				validatingRequiredChkBoxOfActivityHistoryTable = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL",
						"Please cross check the inputData as the application indicating 'Required' check box as :"
								+ fieldVal);
				validatingRequiredChkBoxOfActivityHistoryTable = false;
			}
		} catch (Throwable t) {
			System.out
					.println("The Exception for validatingRequiredChkBoxOfActivityHistoryTable is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for validatingRequiredChkBoxOfActivityHistoryTable is : " + t.getMessage());
			softAssert.fail("The Exception for validatingRequiredChkBoxOfActivityHistoryTable is : " + t.getMessage());
			errorCount++;
		}
	}

	public static void validatingDueBusinessDays1(String testCaseName, Browser browser, int businessDays,
			String primaryKey, String primaryHeader, String LastModifiedHeader, String dueDateHeader) {
		Date formattedLastModifiedDate = null;
		try {
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			String lastModifiedDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey,
					primaryHeader, LastModifiedHeader);
			String dueDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					dueDateHeader);
			DateFormat s = new SimpleDateFormat("M/dd/yyyy");
			String[] strArray = lastModifiedDate.split("/");
			int date = Integer.parseInt(strArray[1]);
			int month = ((Integer.parseInt(strArray[0]) - 1));
			int year = Integer.parseInt(strArray[2]);
			GregorianCalendar lastModified = (GregorianCalendar) GregorianCalendar.getInstance();
			lastModified.set(year, month, date);

			for (int i = 0; i < businessDays; i++) {
				System.out.println(lastModified.toString());
				System.out.println(lastModified.get(lastModified.DAY_OF_WEEK));

				lastModified.add(lastModified.DAY_OF_MONTH, 1);
				int ht = lastModified.DAY_OF_MONTH;
				int dat = lastModified.DAY_OF_WEEK;

				if (lastModified.get(lastModified.DAY_OF_WEEK) <= 5) {
					formattedLastModifiedDate = lastModified.getTime();

				}

			}

			String dueDateDesignValue = new SimpleDateFormat("M/dd/yyyy").format(formattedLastModifiedDate);
			if (dueDateDesignValue.equalsIgnoreCase(dueDate)) {

				ReportEvent.testStepReport(testCaseName, "PASS", "Last Modified date : " + lastModifiedDate
						+ " and Due date : " + dueDate + " are in : " + businessDays + " Business days as expected. ");

			} else {

				ReportEvent.testStepReport(testCaseName, "Fail", "Last Modified date : " + lastModifiedDate
						+ " and Due date : " + dueDate + " are NOT in : " + businessDays + " Business days.");
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in validatingDueBusinessDays1() is", t);
		}
	}

	// Function for confirming Claim page navigation..
	public static void confirmingBenefitClaimedIdPageNavigation(String testCaseName, Browser browser,
			String h1HeaderText, String configName) {

		try {
			boolean fnStatus = false;
			fnStatus = GenericClass.saveGeneratedDataInConfigFile(browser, h1HeaderText, configName);
			GenericClass.reportlogger(fnStatus, testCaseName, "BenefitClaim ID : " + configName + " was displayed.");

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in confirmingBenefitClaimedIdPageNavigation() is ", t);
		}

	}

	// Function to click on a Custom Links Benefit Claimed Detail page based on
	// user inputs..
	public static boolean verifyingLInksInCurrentBenefitClaimedSideBar(Browser browser, String sideBarLink) {
		boolean verifyingLInksInCurrentBenefitClaimedSideBar = false;
		String frameName = "066A0000001XCIx";
		try {

			Table tbl = browser.describe(Frame.class, new FrameDescription.Builder().name(frameName).build()).describe(
					Table.class,
					new TableDescription.Builder().xpath(tblCurrentBenefitClaimed).tagName("TABLE").build());

			tbl.highlight();

			WebElement[] tdTags = tbl.findChildren(WebElement.class,
					new WebElementDescription.Builder().tagName("tr").build());
			int totalRows = tdTags.length;

			outerloop: for (int i = 1; i <= totalRows; i++) {
				String columnPath = tblCurrentBenefitClaimed.concat("//tr[" + i + "]//td");
				WebElement[] tdTags1 = browser.findChildren(WebElement.class,
						new WebElementDescription.Builder().xpath(columnPath).build());
				for (int j = 0; j <= tdTags.length - 1; j++) {

					WebElement[] aTags = tdTags[j].findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath("//a").build());
					for (WebElement aTag : aTags) {
						System.out.println(aTag.getInnerText());
						if (aTag.getInnerText().equals(sideBarLink)) {
							aTag.highlight();
							ReportEvent.testStepReport(tTestCaseName, "pass",
									"System should be displayed Viewed Benefit Claimed id: " + aTag
											+ " , successfully!!");
							break outerloop;
						} else {
							continue;
						}
					}
				}
			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for verifyingLInksInCurrentBenefitClaimedSideBar is :", t);

			verifyingLInksInCurrentBenefitClaimedSideBar = false;

		}

		return verifyingLInksInCurrentBenefitClaimedSideBar;
	}

	// Function for validating the AssignTo user name Open Activity section
	// based on header name..
	public static void verifyingColumnValueOFActivityHistorySec(String testCaseName, Browser browser, String primaryKey,
			String primaryHeader, String columnHeader, String inputValue) {

		String fieldVal = null;
		try {
			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					columnHeader);
			if (fieldVal.equals(inputValue)) {
				ReportEvent.testStepReport(testCaseName, "Pass",
						"Closed by : " + fieldVal + ", Should be Verified successfully.");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to verify Closed by user  " + fieldVal + ".");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for verifyingColumnValueOFActivityHistorySec is : ", t);

		}
	}

	// Function for validating the Closed by Date in Activity History section
	// based on header name..
	public static void verifyingClosedDateOFActivityHistorySec(String testCaseName, Browser browser, String primaryKey,
			String primaryHeader, String columnHeader, String inputValue) {

		String fieldVal = null;
		try {
			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					columnHeader);
			if (fieldVal.equals(inputValue)) {
				ReportEvent.testStepReport(testCaseName, "Pass",
						" Closed by Date: " + fieldVal + "  should be verifyed Successfully");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to verify Closed Date.");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for verifyingColumnValueOFActivityHistorySec is : ", t);
		}
	}

	/* Validating due business days */
	public static void validatingDueBusinessDays(String testCaseName, Browser browser, int businessDays,
			String primaryKey, String primaryHeader, String LastModifiedHeader, String dueDateHeader) {

		Date formattedLastModifiedDate = null;
		try {
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			String lastModifiedDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey,
					primaryHeader, LastModifiedHeader);
			String dueDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					dueDateHeader);
			String businessDay = GenericClass.getingBusinessDay(browser, lastModifiedDate, businessDays);

			if (businessDay.equalsIgnoreCase(dueDate)) {

				ReportEvent.testStepReport(testCaseName, "PASS", "Last Modified date : " + lastModifiedDate
						+ " and Due date : " + dueDate + " are in : " + businessDays + " Business days as expected. ");

			} else {

				ReportEvent.testStepReport(testCaseName, "Fail", "Last Modified date : " + lastModifiedDate
						+ " and Due date : " + dueDate + " are NOT in : " + businessDays + " Business days.");
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingDueBusinessDays() is : ", t);

		}

	}

	public static boolean validatingDueBusinessDaysActivityHistorySection(Browser browser, int businessDays,
			String primaryKey, String primaryHeader, String LastModifiedHeader, String dueDateHeader) {
		boolean validatingDueBusinessDays = false;
		Date formattedLastModifiedDate = null;
		try {
			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			String lastModifiedDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey,
					primaryHeader, LastModifiedHeader);
			String dueDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					dueDateHeader);
			String businessDay = GenericClass.getingBusinessDay(browser, lastModifiedDate, businessDays);

			if (businessDay.equalsIgnoreCase(dueDate)) {

				ReportEvent.testStepReport(tTestCaseName, "PASS", "Last Modified date : " + lastModifiedDate
						+ " and Due date : " + dueDate + " are in : " + businessDays + " Business days as expected. ");
				// System.out.println("Last Modified date : "+lastModifiedDate +
				// " and Due date : "+ dueDate +" are in : "+businessDays+"
				// Business days as expected. " );
			} else {
				// System.out.println("Last Modified date : "+lastModifiedDate +
				// " and Due date : "+ dueDate +" are NOT in : "+businessDays+"
				// Business days." );
				ReportEvent.testStepReport(tTestCaseName, "Fail", "Last Modified date : " + lastModifiedDate
						+ " and Due date : " + dueDate + " are NOT in : " + businessDays + " Business days.");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for validatingDueBusinessDays is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for validatingDueBusinessDays is : " + t.getMessage());
			softAssert.fail("The Exception for validatingDueBusinessDays is : " + t.getMessage());
			errorCount++;
		}
		return validatingDueBusinessDays;
	}

	//////////////////////////////////////////////////////////////////////

	// Function for Verifying Closed tasks are Upadated in Activity history
	// Section..
	public static List<String> storingAllSubjectText(Browser browser) {

		boolean verifyNewTaskDisplayedActivityHistory = false;
		String subjectText = null;
		List<String> list = new ArrayList<>();
		try {
			boolean fnStatus = false;

			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {
					String subjectxPath = tableXpath.concat("//th/a");
					Link[] aTagObject = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(subjectxPath).build());

					for (Link cell : aTagObject) {

						String allSubjectText = cell.getInnerText();

						System.out.println(allSubjectText);
						list.add(allSubjectText);

					}
				}
			}

			else {
				System.out.println(" Activity History dynamic table is not available");
				errorCount++;
				verifyNewTaskDisplayedActivityHistory = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for virifyNewTaskDisplayedActivityHistory is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for virifyNewTaskDisplayedActivityHistory is : " + t.getMessage());
			softAssert.fail("The Exception for virifyNewTaskDisplayedActivityHistory is : " + t.getMessage());
			errorCount++;
			verifyNewTaskDisplayedActivityHistory = false;
		}
		return list;

	}

	// Function to click on subject link of table of Activity history section by
	// checking availability of Go to list or Show more links.

	public static void clickSubjectLinkOfActivityHistorySection(String testCaseName, Browser browser,
			String sectionName, String linkName, String inputValueLink) {
		try {
			boolean fnStatus = false;
			fnStatus = GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
			if (fnStatus == true) {
				fnStatus = GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
				if (fnStatus == true) {
					fnStatus = GenericClass.clickingLinkOfSection(browser, sectionActivityHistory, inputValueLink);
					if (fnStatus == true) {
						System.out.println("Clicked on :" + inputValueLink + " successfully.");
						ReportEvent.testStepReport(testCaseName, "Pass",
								"Clicked on :" + inputValueLink + " successfully.");
					} else {
						System.out.println("Failed to click on :" + inputValueLink);
						ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click on :" + inputValueLink);
					}
				} else {
					System.out.println("Failed to click on :" + linkName);
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click on :" + linkName);
				}
			}

			else {
				fnStatus = GenericClass.clickingLinkOfSection(browser, sectionActivityHistory, inputValueLink);
				if (fnStatus == true) {
					System.out.println("Clicked on :" + inputValueLink + " successfully.");
					ReportEvent.testStepReport(testCaseName, "Pass",
							"Clicked on :" + inputValueLink + " successfully.");
				} else {
					System.out.println("Failed to click on :" + inputValueLink);
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click on :" + inputValueLink);
				}
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

	}

	// Function to click on Tab of Case management screen based on user inputs..
	// Values of tabNames : Reference, Eligibility, ActionPlan, Medical,
	// Financial, ReturnToWork, AdjustmentsAndOffsets, Occupational,
	// Correspondence,
	// Rehabilitation, Legal, Investigative, Other
	public static boolean clickTabCaseMgmt(String testCaseName, Browser browser, String tabName) {
		boolean clickTabCaseMgmt = false;
		if (tabName == "Phone Notes")
			tabName = "Correspondence";

		String tabXpath = "//td[@id ='p:f:" + tabName/* ReturnToWork */ + "_cell']/table/tbody//td[2]/table/tbody//td";
		try {
			WebElement tabObj = browser.describe(WebElement.class, new XPathDescription(tabXpath));
			if (tabObj.exists()) {
				tabObj.highlight();
				tabObj.click();
				ReportEvent.testStepReport(testCaseName, "fail", "Clicked on : " + tabName + " tab successfully.");
				clickTabCaseMgmt = true;
			} else {
				clickTabCaseMgmt = false;
				ReportEvent.testStepReport(testCaseName, "fail", "Failed to click on : " + tabName + " tab.");

			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickTabCaseMgmt is : " + t.getMessage());
			ReportEvent.testStepReport(testCaseName, "fail",
					"The Exception for clickTabCaseMgmt is : " + t.getMessage());
			softAssert.fail("The Exception for clickTabCaseMgmt is : " + t.getMessage());
			errorCount++;
			clickTabCaseMgmt = false;

		}
		return clickTabCaseMgmt;
	}

	// Function to click on Add link of Primary diagnosis Or Secondary diagnosis
	// based on user inputs..

	public static boolean clickAddLinkOfDiagnosis(String testCaseName, Browser browser, String diagnosisName) {
		boolean clickAddLinkOfDiagnosis = false;
		String addLinkXpath = null;

		// String addLinkXpath = "//h3[text()='Secondary Diagnosis
		// ']/../following-sibling::div[1]//a[text()='Add']";
		try {
			if (diagnosisName.equalsIgnoreCase("Secondary Diagnosis")) {
				addLinkXpath = "//h3[text()='Secondary Diagnosis ']/../following-sibling::div[1]//a[text()='Add']";
			} else {
				addLinkXpath = "//h3[text()='" + diagnosisName
						+ /* Primary Diagnosis */"']/../following-sibling::div[1]//a[text()='Add']";
			}

			WebElement addLinkObj = browser.describe(WebElement.class, new XPathDescription(addLinkXpath));
			if (addLinkObj.exists()) {
				addLinkObj.highlight();
				addLinkObj.click();
				ReportEvent.testStepReport(testCaseName, "Pass",
						"Clicked on 'Add' link of : " + diagnosisName + " successfully.");
				clickAddLinkOfDiagnosis = true;
			} else {
				ReportEvent.testStepReport(testCaseName, "Pass", "Failed to click on 'Add' link of : " + diagnosisName);
				clickAddLinkOfDiagnosis = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickAddLinkOfDiagnosis is : " + t.getMessage());
			ReportEvent.testStepReport(testCaseName, "fail",
					"The Exception for clickAddLinkOfDiagnosis is : " + t.getMessage());
			softAssert.fail("The Exception for clickAddLinkOfDiagnosis is : " + t.getMessage());
			errorCount++;
			clickAddLinkOfDiagnosis = false;
		}
		return clickAddLinkOfDiagnosis;
	}

	public static final String txtDiagnosisEditHeader = "//h1[text()='Diagnosis Edit']";

	// Function related to navigation of Diagnosis Edit screen..

	public static boolean confirmNavigationToDiagnosisEditPage(String testCaseName, Browser browser) {
		boolean confirmNavigationToDiagnosisEditPage = false;
		try {
			if (isElementExist(browser, txtDiagnosisEditHeader)) {
				ReportEvent.testStepReport(testCaseName, "Pass", "Navigated to 'Diagnosis Edit' page successfully.");
				confirmNavigationToDiagnosisEditPage = true;
			} else {
				ReportEvent.testStepReport(testCaseName, "Fail",
						"H1 header with Xpath: " + txtDiagnosisEditHeader + " is not available.");
				confirmNavigationToDiagnosisEditPage = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for confirmNavigationToDiagnosisEditPage is : " + t.getMessage());
			ReportEvent.testStepReport(testCaseName, "fail",
					"The Exception for confirmNavigationToDiagnosisEditPage is : " + t.getMessage());
			softAssert.fail("The Exception for confirmNavigationToDiagnosisEditPage is : " + t.getMessage());
			errorCount++;
			confirmNavigationToDiagnosisEditPage = false;
		}
		return confirmNavigationToDiagnosisEditPage;
	}

	public static final String btnLookUp = "//td/input[@value='Lookup']";

	// Function to click on LookUp button Of Diagnosis Edit page..
	public static boolean clickLookUpBtnDiagnosisEditPage(String testCaseName, Browser browser) {
		boolean clickLookUpBtnDiagnosisEditPage = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, btnLookUp);
			if (fnStatus == true) {
				fnStatus = fnButtonClick(browser, btnLookUp);
				if (fnStatus == true) {
					ReportEvent.testStepReport(testCaseName, "Fail", "Clicked LookUp button successfully.");
					clickLookUpBtnDiagnosisEditPage = true;
				} else {
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click LookUp button.");
					clickLookUpBtnDiagnosisEditPage = false;
				}
			} else {
				ReportEvent.testStepReport(testCaseName, "Fail", "LookUp button is not available.");
				clickLookUpBtnDiagnosisEditPage = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for clickLookUpBtnDiagnosisEditPage is : " + t.getMessage());
			ReportEvent.testStepReport(testCaseName, "fail",
					"The Exception for clickLookUpBtnDiagnosisEditPage is : " + t.getMessage());
			softAssert.fail("The Exception for clickLookUpBtnDiagnosisEditPage is : " + t.getMessage());
			errorCount++;
			clickLookUpBtnDiagnosisEditPage = false;
		}
		return clickLookUpBtnDiagnosisEditPage;
	}

	// Function to validate availability of values of Medical Code Description,
	// Minimum Duration
	// Optimum Duration, Maximum Duration and availability of MDA URL..

	public static final String sectionDiagnosisDetail = "//h2[text()='Diagnosis Detail']//ancestor ::div[1]/following-sibling::div[1]/child::div[@class='pbSubsection']";

	/*
	 * public static void validateFieldValuesOfDiagnosisEdit(String
	 * testCaseName,Browser browser, String medicalCodeLabel, String
	 * minimumLabel, String optimumLabel, String maximumLabel) { String
	 * medicalCodeVal =null, minimumLabelVal= null, optimumLabelVal = null,
	 * maximumLabelVal = null; medicalCodeVal = getFieldValueOfSection(browser,
	 * medicalCodeLabel, sectionDiagnosisDetail); minimumLabelVal =
	 * getFieldValueOfSection(browser, minimumLabel, sectionDiagnosisDetail);
	 * optimumLabelVal = getFieldValueOfSection(browser, optimumLabel,
	 * sectionDiagnosisDetail); maximumLabelVal =
	 * getFieldValueOfSection(browser, maximumLabel, sectionDiagnosisDetail);
	 * 
	 * 
	 * }
	 */

	// Function to validate the displayed errors are matching with those of
	// input text error messages which are being passed by user.
	/***
	 * @Function : validateErrorMessages
	 * @Description: Function to validate the displayed errors are matching with
	 *               those of input text error messages which are being passed
	 *               by user. Examples : Error: Invalid Data. Review all error
	 *               messages below to correct your data. • Primary Diagnosis
	 *               Description Required (Related field: Primary Diagnosis
	 *               Description) • Title Required (Related field: Title) Error:
	 *               Date of Disability Required Error: Last 2 Amendments
	 *               Required Error: Cannot set Status For Approval to Approved
	 *               as Certified Through Required, Benefit Start Required
	 *               Error: Benefit Through Required Error: LTD Coverage with
	 *               The Standard Required Error: Life Coverage with The
	 *               Standard Required
	 * @param testCaseName
	 * @param browser
	 * @param inputErrorMessages
	 */
	public static void validateErrorMessages(String testCaseName, Browser browser, String inputErrorMessages) {
		int counter = 0;
		try {
			String[] errorArray = inputErrorMessages.split(";");

			List<String> appErrors = GenericClass.getAllErrorMessagesOfPage(browser);
			for (String error : appErrors) {
				for (int i = 0; i < errorArray.length; i++) {
					String inputError = errorArray[i];
					if (error.contains(inputError)) {
						counter++;
					} else {
						continue;
					}
				}
			}

			if (counter == errorArray.length) {
				System.out.println(inputErrorMessages + ", error messages are available as expected.");
				ReportEvent.testStepReport(testCaseName, "PASS",
						inputErrorMessages + ", error messages are available as expected.");
			} else {
				System.out.println(inputErrorMessages + ", error messages are NOT available.");
				ReportEvent.testStepReport(testCaseName, "Fail",
						inputErrorMessages + ", error messages are NOT available.");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for validateErrorMessages is : " + t.getMessage());
			ReportEvent.testStepReport(testCaseName, "fail",
					"The Exception for validateErrorMessages is : " + t.getMessage());
			softAssert.fail("The Exception for validateErrorMessages is : " + t.getMessage());
			errorCount++;

		}
	}

	// Function for validating error message in Decision reason section based on
	// label

	public static void validatingDeniedErrorMessage(String testCaseName, Browser browser, String inputErrorMessage) {

		try {

			WebElement errorMesg = browser.describe(WebElement.class, new XPathDescription(errorMesgXpath));
			errorMesg.highlight();
			String errorText = errorMesg.getInnerText();
			if (errorText.equals(inputErrorMessage)) {
				ReportEvent.testStepReport(testCaseName, "PASS",
						inputErrorMessage + ", error messages are available as expected.");
			} else {
				ReportEvent.testStepReport(testCaseName, "Fail",
						inputErrorMessage + ", error messages are NOT available.");
			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for validatingDeniedErrorMessage is : ", t);

		}
	}

	// Function for validating the AssignTo user name Open Activity section
	// based on header name..
	public static void verifyingColumnValueOFOpenActivitySec1(Browser browser, String primaryKey, String primaryHeader,
			String columnHeader, String inputValue) {
		boolean verifyingColumnValueOFOpenActivitySec = false;
		String fieldVal = null;
		try {
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					columnHeader);
			if (fieldVal.equals(inputValue)) {
				ReportEvent.testStepReport(tTestCaseName, "Pass",
						"Assign To user " + fieldVal + ", Should be Verified successfully.");
				verifyingColumnValueOFOpenActivitySec = true;
			} else {
				ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to verify Assign To user  " + fieldVal + ".");
				softAssert.fail("Failed to verify Assign To user  " + fieldVal + ".");
				errorCount++;
				verifyingColumnValueOFOpenActivitySec = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for verifyingColumnValueOFOpenActivitySec is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for verifyingColumnValueOFOpenActivitySec is : " + t.getMessage());
			softAssert.fail("The Exception for verifyingColumnValueOFOpenActivitySec is : " + t.getMessage());
			errorCount++;
			verifyingColumnValueOFOpenActivitySec = false;
		}
	}

	// Function for checking Saved changes in Document details section..

	public static void checkingUpdatedValuesInDocumentDetailsSec(String testCaseName, Browser browser,
			String documentLabel, String typeLabel, String documentTypeLabel, String documentDescLabel,
			String inputValues)

	{
		boolean fnStatus = false;
		int counter = 0;
		String docName = null, type = null, docType = null, docDesc = null;
		try {
			String[] splitArray = inputValues.split(",");

			fnStatus = isElementExist(browser, tblDocumentDetail);

			if (fnStatus == true) {
				docName = GenericClass.getFieldValueOfSection(browser, documentLabel, tblDocumentDetail);
				type = GenericClass.getFieldValueOfSection(browser, typeLabel, tblDocumentDetail);
				docType = GenericClass.getFieldValueOfSection(browser, documentTypeLabel, tblDocumentDetail);
				docDesc = GenericClass.getFieldValueOfSection(browser, documentDescLabel, tblDocumentDetail);
				String[] appData = { docName, type, docType, docDesc };
				for (int i = 0; i < splitArray.length - 1; i++) {
					for (int j = 0; j < appData.length; j++) {
						if (splitArray[i].equalsIgnoreCase(appData[j])) {
							counter++;
						} else {
							continue;
						}
					}
				}
				if (counter == splitArray.length) {
					ReportEvent.testStepReport(testCaseName, "pass",
							"All labels are displaying correctly with the user passed input values successfully.");
				} else {
					ReportEvent.testStepReport(testCaseName, "Fail",
							"All labels are NOT displaying with the user passed input values successfully.");
				}

			} else {
				ReportEvent.testStepReport(testCaseName, "Fail", "Document Detail Section is not available!!");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for checkingUpdatedValuesInDocumentDetailsSec is : ", t);

		}

	}

	// Function for verifying the view attachment link related to view
	// document..
	public static void verifyingViewAttachmentLinkInDocumentDetailPage(String testCaseName, Browser browser,
			String viewDoc, String viewAttachmentLink) {

		try {
			String attachmentLink = GenericClass.getFieldValueOfSection(browser, viewDoc, tblDocumentDetail);
			if (attachmentLink.equals(viewAttachmentLink)) {
				ReportEvent.testStepReport(testCaseName, "Pass",
						"Viewed Document is having :  " + attachmentLink + ", Should be Verified.");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL",
						"Failed to verify view document link in document details section.");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for verifyingViewAttachmentLinkInDocumentDetailPage is : ", t);
		}

	}

	// Function for Clicking Benefit Claimed id in Document Detail section field
	// based on label..
	public static void clickingBenefitClaimedID(String testCaseName, Browser browser, String benefitClaimedLabel) {
		boolean fnStatus = false;
		try {
			isElementExist(browser, tblDocumentDetail);
			fnStatus = GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, benefitClaimedLabel,
					tblDocumentDetail);
			GenericClass.reportlogger(fnStatus, testCaseName,
					"Document Detail section :" + benefitClaimedLabel + " label related value is Clicked ");
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingBenefitClaimedID is : ", t);

		}

	}

	// Function for Checking Task comments in Activity History section..
	public static void checkingTaskCommentLink(String testCaseName, Browser browser, String commentLabel) {

		String fieldVal = null;
		try {
			String tableXpath = sectionTaskDetail;
			fieldVal = GenericClass.getFieldValueOfSection(browser, commentLabel, tableXpath);
			if (fieldVal.contains("https://")) {
				ReportEvent.testStepReport(testCaseName, "Pass",
						"Checked on Comment Lable is having :" + fieldVal + " Task Comment URL.");

			} else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to check Task Comment URL.");

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for checkingTaskCommentLink is : ", t);

		}

	}

	// Function for clicking Subject link in Activity history section based on
	// user inputs..
	public static void clickingSubjectOfActivityHistorySection(String testCaseName, Browser browser,
			String subjectValue) {

		boolean fnStatus = false;
		int j = 0;
		try {

			String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {

					String aTagXPath = tableXpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());

					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(subjectValue)) {
							String subjectAtag = tableXpath + "//tr[" + i + "]//a[text()[contains(.,'" + subjectValue
									+ "')]]";
							fnStatus = GenericClass.fnClickLinkInLinkClass(browser, subjectAtag);

							if (fnStatus == true) {
								ReportEvent.testStepReport(testCaseName, "Pass",
										"Clicked on " + subjectValue + " link of Activity History section.");
								break outerloop;
							} else {
								ReportEvent.testStepReport(testCaseName, "fail",
										"Failed to click subject of Activity History section");

							}

						} else {
							continue;
						}

					}
				}

			} else {

				ReportEvent.testStepReport(testCaseName, "fail", "Activity History dynamic table is not available");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for clickingSubjectOfActivityHistorySection is : ", t);

		}

	}

	public static final String sectionNotesOfCaseMgmt_mgmtLead = "//h3[text()='Treatment']//ancestor::div[2]/following-sibling::span[1]/div/div[@class='pbSubsection']";

	public static final String buttonXpathMedical_prefix = "//h2[text()='Medical']/../../../..//input[@value ='";
	public static final String buttonXpathMedical_suffix = "']";

	// Todays task ..--10092017

	// To perform inline edit of policy Id based on user inputs..
	public static void inlineEditingOfPolicyID(String testCaseName, Browser browser, String labelName,
			String existingValue, String inputValue) {
		boolean fnStatus = false;
		try {
			fnStatus = GenericClass.inlineEditingOfFieldOfSectionByLabel(browser, sectionPolicy_mgmtLead, labelName,
					existingValue, inputValue);
			GenericClass.reportlogger(fnStatus, testCaseName, "Passed inline Edit 'PolicyID' as :" + inputValue);
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in inlineEditingOfPolicyID() is", t);
		}
	}

	// Function to validate whether the field values of Policy section are
	// matching as that of user passed input values..
	public static void validateFieldValueWithInputValueOfPolicySection(String testCaseName, Browser browser,
			String labelName, String inputValue) {
		boolean fnStatus = false;
		try {
			fnStatus = GenericClass.validateFieldValueWithInputValue(testCaseName, browser, sectionPolicy_mgmtLead,
					labelName, inputValue);
			GenericClass.reportlogger(fnStatus, testCaseName,
					labelName + " is having the field value as :" + inputValue);

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in validateFieldValueWithInputValueOfPolicySection() is :", t);
		}
	}

	// Clicking Add note link..
	public static void clickAddNoteLink(String testCaseName, Browser browser) {
		try {
			String allLinkTagsXpath = sectionNotesOfCaseMgmt_mgmtLead + "/table//a";
			Link[] linkTags = browser.findChildren(Link.class,
					new LinkDescription.Builder().xpath(allLinkTagsXpath).build());

			for (int i = 0; i < linkTags.length; i++) {
				String linkTagInnerText = linkTags[i].getInnerText();
				if (linkTagInnerText.equalsIgnoreCase("Add")) {
					linkTags[i].click();
				} else {
					continue;
				}

			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in clickAddNoteLink() is : ", t);
		}
	}

	// validating proclaim number available in phone notes section with that of
	// proclaim number passed by user and updating with the input value passed
	// by user..
	public static void validateProclaimNumberAndUpdation(String testCaseName, Browser browser, String proclaimNumber,
			String inputValue) {
		try {
			Map<String, String> attributes = new HashMap<String, String>();
			String alltextAreaXpath = sectionNotesOfCaseMgmt_mgmtLead + "//table//textarea";
			String appValue = null;
			EditField[] textAreaObjs = browser.findChildren(EditField.class,
					new EditFieldDescription.Builder().xpath(alltextAreaXpath).build());
			for (int i = 0; i < textAreaObjs.length; i++) {
				attributes = textAreaObjs[i].getAttributes();
				if (attributes.containsKey("disabled")) {
					continue;
				} else {
					appValue = textAreaObjs[i].getInnerText();
					if (appValue.equalsIgnoreCase(proclaimNumber)) {
						textAreaObjs[i].highlight();
						ReportEvent.testStepReport(testCaseName, "Pass",
								"Proclaim number : " + proclaimNumber + " is matching as expected.");
						textAreaObjs[i].setValue(inputValue);
						ReportEvent.testStepReport(testCaseName, "Pass",
								"Note box is updated with : " + inputValue + " as expected.");
						break;
					} else {
						ReportEvent.testStepReport(testCaseName, "Fail",
								"Proclaim number : " + proclaimNumber + " is NOT matching.");
					}
				}
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in validateProclaimNumberOfNoteSection() is : ", t);

		}
	}

	// Function for Clicking Save OR Undo button in Medical section...
	public static void clickButtonOfMedicalSec(String testCaseName, Browser browser, String buttonName) {
		try {
			boolean fnStatus = false;
			isElementExist(browser, buttonXpathMedical_prefix + buttonName + buttonXpathMedical_suffix);
			fnStatus = fnButtonClick(browser, buttonXpathMedical_prefix + buttonName + buttonXpathMedical_suffix);
			GenericClass.reportlogger(fnStatus, testCaseName, " Clicked on " + buttonName + ", button ");
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in clickButtonOfMedicalSec() is :", t);
		}

	}

	// Function for selecting subject value in New task page under Open activity
	// section..

	public static void selectingSubjectValueInNewTaskPage(String testCaseName, Browser browser, String inputLink) {
		try {

			GenericClass.fnImageLinkOrButtonClick(browser, imgSubjectCombo);
			browser = BrowserFactory.attach(new BrowserDescription.Builder().title("ComboBox").build());
			browser.highlight();
			Page pg = browser.describe(Page.class, new PageDescription.Builder().title("ComboBox").build());
			pg.highlight();

			Link[] lnk = pg.findChildren(Link.class, new LinkDescription.Builder().tagName("A").build());

			for (Link allLinks : lnk) {
				String linkText = allLinks.getInnerText();

				if (linkText.contains(inputLink)) {
					allLinks.highlight();
					allLinks.click();
					ReportEvent.testStepReport(testCaseName, "Pass", "Selected :" + inputLink + "  value successfully");
					break;
				} else {
					continue;

				}
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception selectingSubjectValueInNewTaskPage is:", t);
		}
	}

	// Function for selecting Due date of New Task info section..
	public static void selectingDueDate(String testCaseName, Browser browser, String dueDate) {
		boolean fnStatus = false;
		try {

			fnStatus = GenericClass.fnClikEditOrDateField(browser, dueDateXpath);

			if (fnStatus == true) {
				fnStatus = GenericClass.datePicker(browser, datePicker,
						GenericClass.dateConversion(dueDate, "FullMonth/dd/yyyy"));
				GenericClass.reportlogger(fnStatus, testCaseName, "Selected Due date as:" + dueDate);
			}

			else {
				ReportEvent.testStepReport(testCaseName, "FAIL", "Didn't clicked on Due Day text box");

			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for selectingDueDate is : ", t);

		}

	}

	// Function for validating due date and user date..
	public static void valaidateDuedateAndUserDate(String testCaseName, Browser browser, String primaryKey,
			String primaryHeader, String dueDateHeader, String userDate) {
		try {
			String tableXpath = sectionOpenActivities.concat("//div[@class='pbBody']//table");
			String dueDate = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
					dueDateHeader);

			boolean fnStatus = dueDate.equals(userDate);
			GenericClass.reportlogger(fnStatus, testCaseName,
					"Verified Duedate :" + dueDate + " and Userdate " + userDate + " expected ");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception selectingSubjectValueInNewTaskPage is:", t);
		}
	}

	// Function for select check box based on subject value under open activity
	// section..

	public static void selctCheckBoxBasedOnSubjectValue(String testCaseName, Browser browser, String subjectText,
			String checkboxStatus, String buttonName) {
		try {
			String tableXpath = sectionOpenActivities.concat("//following-sibling::div[@class='pbBody']//table");
			int rwcnt = GenericClass.fngetTableRowCount(browser, tableXpath);
			if (rwcnt > 1) {
				for (int i = 1; i <= rwcnt; i++) {
					String aTagXPath = tableXpath + "//tr[" + i + "]//a";
					Link[] allLinks = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXPath).build());
					for (Link atag : allLinks) {
						String atagText = atag.getInnerText();
						if (atagText.equals(subjectText)) {
							String checkboxpath = tableXpath + "//tr[" + i + "]//input";
							GenericClass.fncheckBoxValidation(browser, checkboxpath, checkboxStatus);
							clickButtonOfOpenAcivitySec(testCaseName, browser, buttonName);
							break;
						}
					}
				}
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for selctCheckBoxBasedOnSubjectValue is : ", t);
		}
	}

	// Tasks --11/10/2017--

	// Clicking Add note link..
	public static void clickAddNoteLink(String testCaseName, Browser browser, String linkName) {
		boolean fnStatus = false;
		try {
			fnStatus = GenericClass.clickLinkBasedOnLinkNameAndSectionXpath(testCaseName, browser,
					sectionNotesOfCaseMgmt_mgmtLead, linkName);
			GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " + linkName + " link ");
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in clickAddNoteLink() is : ", t);
		}
	}

	/***********************************************************************/

	// Clicking Add link of document section of case mgmt..
	/*
	 * public static void clickAddDocumentLink(String testCaseName,Browser
	 * browser, String linkName) { boolean fnStatus = false; try { fnStatus=
	 * GenericClass.clickLinkBasedOnLinkNameAndSectionXpath(testCaseName,
	 * browser, sectionDocumentsOfCaseMgmt_mgmtLead, linkName);
	 * GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on " +linkName
	 * + " link "); } catch(Throwable t) { GenericClass.Catchhandler(
	 * "Exception arised in clickAddDocumentLink() is : " , t); } }
	 */

	// Function for Click Browse to attach file from computer, click Attach
	// file, then click Done.
	public static void browseToAttachFileFromComputer(String testCaseName, Browser browser, String choosefileButton,
			String filePath, String attachFileButton) throws GeneralLeanFtException {
		boolean fnStatus = false;
		try {
			fnStatus = clickButtonOfFileUploadingPage(browser, choosefileButton);
			if (fnStatus = true) {
				Dialog popupBox = browser.describe(Dialog.class, new DialogDescription.Builder()
						.windowClassRegExp("#32770").windowTitleRegExp("Choose File to Upload").index(0).build());

				com.hp.lft.sdk.stdwin.EditField textBox = popupBox.describe(com.hp.lft.sdk.stdwin.EditField.class,
						new com.hp.lft.sdk.stdwin.EditFieldDescription.Builder().windowClassRegExp("Edit").build());
				textBox.highlight();
				textBox.sendKeys(filePath);
				UiObject button = browser
						.describe(Dialog.class,
								new DialogDescription.Builder().ownedWindow(true).childWindow(false)
										.text("Choose File to Upload").nativeClass("#32770").build())
						.describe(UiObject.class,
								new UiObjectDescription.Builder().windowClassRegExp("Button").windowId(1).build());
				button.highlight();
				button.click();

				fnStatus = clickButtonOfFileUploadingPage(browser, attachFileButton);
				GenericClass.reportlogger(fnStatus, testCaseName, "Document attachment file uploaded");
			} else {
				ReportEvent.testStepReport(testCaseName, "fail", "Failed to click Browse button");
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in browseToAttachFileFromComputer is :", t);
		}

	}

	

	//Function to click on subject link of table of Activity history section by checking availability of Go to list or Show more links.
	
	public static void checkTaskAvailabilityInActivityHistory(String testCaseName, Browser browser, String sectionName,
			String linkName,  String inputValueLink)
	{
		try
		{
			boolean fnStatus = false;
			fnStatus = GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
			
			if(fnStatus ==true)
			{
				fnStatus =GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
				if(fnStatus ==true)
				{
					fnStatus =GenericClass.checkLinkAvailableBasedOnLinkNameAndSectionXpath(testCaseName, browser, sectionActivityHistory, inputValueLink);
					if(fnStatus ==true)
					{
						System.out.println(inputValueLink+ " : is available ");
						ReportEvent.testStepReport(testCaseName, "Pass", inputValueLink+ " : is available .");
					}
					else
					{
						System.out.println(inputValueLink+ " : is NOT available. ");
						ReportEvent.testStepReport(testCaseName, "Fail", inputValueLink+ " : is NOT available. ");
					}
				}
				else
				{
					System.out.println("Failed to click on :"+linkName);
					ReportEvent.testStepReport(testCaseName, "Fail", "Failed to click on :"+linkName);
				}
			}
			
			else
			{
				fnStatus =GenericClass.checkLinkAvailableBasedOnLinkNameAndSectionXpath(testCaseName, browser, sectionActivityHistory, inputValueLink);
				if(fnStatus ==true)
				{
					System.out.println(inputValueLink+ " : is available ");
					ReportEvent.testStepReport(testCaseName, "Pass", inputValueLink+ " : is available .");
				}
				else
				{
					System.out.println(inputValueLink+ " : is NOT available. ");
					ReportEvent.testStepReport(testCaseName, "Fail", inputValueLink+ " : is NOT available. ");
				}
			}
			
			
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		
		
	}
	
	// Function for validating the field value based on header name in Activity History section
		
		public static void verifyingColumnValuesOfActivityHistorySec(String testCaseName, Browser browser, String primaryKey,
																	String primaryHeader, String columnHeader, String inputValue,String sectionName,String linkName ) {

			String fieldVal = null;
			try {
				
				boolean fnStatus = GenericClass.checkShowMoreOrGoToListLink(browser, sectionName, linkName);
				if(fnStatus ==true)
				{
					fnStatus =GenericClass.clickShowMoreOrGoToListLinkOfSection(browser, sectionName, linkName);
					if(fnStatus ==true)
					{
				String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
				fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,
						columnHeader);
				if (fieldVal.contains(inputValue)) {
					ReportEvent.testStepReport(testCaseName, "Pass", fieldVal + "  should be verifyed Successfully");

				} else {
					ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to verify "+fieldVal);

				}
					}
				}
				else
				{
					ReportEvent.testStepReport(testCaseName, "FAIL", linkName+"is not available.");	
				}

			} catch (Throwable t) {
				GenericClass.Catchhandler("The Exception for verifyingColumnValueOFActivityHistorySec is : ", t);
			}
		}


		// Function for validating the Closed by Date in Activity History section
		// based on header name..
		public static void verifyingClosedDateOFActivityHistorySection(String testCaseName, Browser browser, String primaryKey,
				String primaryHeader, String columnHeader,String dueDateHeader) {

			String fieldVal = null;
			String dueDate =null;
			try {
				String tableXpath = sectionActivityHistory.concat("//div[@class='pbBody']//table");
				fieldVal = GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,columnHeader);
				dueDate= GenericClass.getColumnValueFromTable(browser, tableXpath, primaryKey, primaryHeader,dueDateHeader);
				String [] actualDate=fieldVal.split(" ");
				if (actualDate[0].equals(dueDate)) {
					ReportEvent.testStepReport(testCaseName, "Pass"," Closed by Date: " + actualDate + "  should be Today Date.");

				} else {
					ReportEvent.testStepReport(testCaseName, "FAIL", "Failed to verify Closed Date.");

				}

			} catch (Throwable t) {
				GenericClass.Catchhandler("The Exception for verifyingClosedDateOFActivityHistorySection is : ", t);
			}
		}
	
		//Function for Selecting the check box under search results section..
		
		public static void checkingRecordsAvailabilityOfOpenactivitySection(String testCaseName,Browser browser)
			{
			try
			{
				boolean fnStatus = false;
				int i=0;
				String tableXpath = sectionOpenActivities.concat("//following-sibling::div[@class='pbBody']//table");
				fnStatus = isElementExist(browser, tableXpath);
				if(fnStatus == true)
				{
					int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
					if(rowCount==1)
					{
						ReportEvent.testStepReport(testCaseName, "Pass", "No Records arae available in Open activity Section.");
					}
					else
					{
						ReportEvent.testStepReport(testCaseName, "fail", "Records arae available in Open activity table.");
					}
				}
				else
				{
					ReportEvent.testStepReport("", "fail", "Search results dynamic table is not available");
				}
			
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("The Exception for checkingRecordsAvailabilityOfOpenactivitySection is : ",t);
			}
			}
		
		
		//Todays task--12102017
		
		
		public static final String commentsLabelValXpath ="//label[text()='Comments']/../following-sibling::td[1]//textarea";
		
		//Checking template availability in comments section..
		public static void checkingTemplateAvailabilityInComments(String testCaseName,Browser browser,String fieldName)
		{
			String commentValue = null;
			try
			{
				isElementExist(browser, commentsLabelValXpath);
				WebElement obj = browser.describe(WebElement.class, new XPathDescription(commentsLabelValXpath));
				commentValue = obj.getInnerText();
				/*commentValue = GenericClass.getFieldValueOfSectionInProgress(browser, fieldName, sectionDescriptionInfo_mgmtLead);*/
				if((commentValue.length())!=0)
					{
					ReportEvent.testStepReport(testCaseName, "Pass", "Template is available in comments section as expected");
					}
				else
					{
					ReportEvent.testStepReport(testCaseName, "Fail", "Template is NOT available in comments section.");
					}
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("Exception arised in checkingTemplateAvailabilityInComments() is :", t);
			}
		}
		
		
		//assigning user to Task..
		public static final String assignedToBaseValXpath ="//label[text()='Assigned To']/../following-sibling::td[1]";
		public static final String sectionSearchResultsLukUpXpath ="//th[text()='Full Name']/ancestor::div[@class='listRelatedObject lookupBlock']";
	
		
		public static void assignUserToTask(String testCaseName,Browser browser,String assignedType ,String userName, String frameName/*"resultsFrame"*/)
		{
			String dropdownXpath = assignedToBaseValXpath.concat("//select");
			String textBoxXpath = assignedToBaseValXpath.concat("//span[@class='lookupInput']//input");
			String searchbuttonXpath = assignedToBaseValXpath.concat("//span[@class='lookupInput']//a//img[contains(@title,'Assigned To Lookup')]");
			boolean fnStatus = false;
			try
			{
				isElementExist(browser, dropdownXpath);
				fnStatus = fnListBox(browser, dropdownXpath, assignedType);
				GenericClass.reportlogger(fnStatus, testCaseName, "Selected Assigned to field type as :"+assignedType);
				isElementExist(browser, textBoxXpath);
				fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, userName);
				GenericClass.reportlogger(fnStatus, testCaseName, "Entered Assigned to text as:"+userName);
				//clicking search button..
				isElementExist(browser, searchbuttonXpath);
				fnStatus = fnWebElementClick(browser, searchbuttonXpath);
				GenericClass.reportlogger(fnStatus, testCaseName, "Clicked on Search button ");
				//Switch to child browser..
				browser = GenericClass.browserObjectOfChildBrowser(browser);
				fnStatus = fnswitchToFrameByName(browser, frameName);
				GenericClass.reportlogger(fnStatus, "Pass", "Switched to frame ");
				
				fnStatus = GenericClass.clickLinkInFrameBasedOnLinkNameAndSectionXpath(browser, frameName, userName);
				GenericClass.reportlogger(fnStatus, "Pass", "Selected full name as :"+ userName);
				
				
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("Exception arised in assignUserToTask() is :", t);
			}
			
			
			
			
		}
		
		
		
		
		
}
