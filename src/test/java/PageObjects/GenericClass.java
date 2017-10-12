package PageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
/*import com.hp.lft.sdk.java.ButtonDescription;*/
import com.hp.lft.sdk.java.InternalFrame;
import com.hp.lft.sdk.java.InternalFrameDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.stdwin.Static;
import com.hp.lft.sdk.stdwin.StaticDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.CheckBox;
import com.hp.lft.sdk.web.CheckBoxDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.EventInfoFactory;
import com.hp.lft.sdk.web.Frame;
import com.hp.lft.sdk.web.FrameDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListItem;
import com.hp.lft.sdk.web.Page;
import com.hp.lft.sdk.web.PageDescription;
import com.hp.lft.sdk.web.Table;
import com.hp.lft.sdk.web.TableDescription;
import com.hp.lft.sdk.web.TableRow;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

public class GenericClass extends DriverScript {

	public static final String datePickerTable = "//table[@class ='outer']//following-sibling::div[@class='datePicker']";

	/*
	 * #########################################################################
	 * ########### ############################## # FunctionName :
	 * getTableRowCount # No of Parameter : 2 # Description : Function for
	 * getting total row count in a dynamic table.. # Parameters and its
	 * data-type : WebDriver driver, String tableLocator # Developed on :
	 * 6/04/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### #############################
	 */
	public static int fngetTableRowCount(Browser browser, String tableXpath)
			throws GeneralLeanFtException, CloneNotSupportedException {

		try {
			List<TableRow> totalRows = browser.describe(Table.class, new XPathDescription(tableXpath)).getRows();
			int rowcount = totalRows.size();
			return rowcount;
		} catch (Throwable t) {
			System.out.println("The Exception for fngetTableRowCount is : " + t.getMessage());
			utility.fnLogging("The Exception for fngetTableRowCount is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fngetTableRowCount is : " + t.getMessage());
			return 0;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # FunctionName :
	 * getTableRowCount # No of Parameter : 2 # Description : Function for
	 * getting total row count in a Section in a table.. # Parameters and its
	 * data-type :Browser browser, String tableLocator # Developed on :
	 * 24/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### #############################
	 */
	public static int getSectionTableRowCount(Browser browser, String tableLocator) {
		int count = 0;
		try {
			if (isElementExist(browser, tableLocator)) {

				WebElement table = browser.describe(WebElement.class, new XPathDescription(tableLocator));
				WebElement[] tdTags = table.findChildren(WebElement.class,
						new WebElementDescription.Builder().tagName("tr").build());
				int totalRows = tdTags.length;
				System.out.println(totalRows);
				return totalRows;

			} else {
				ReportEvent.testStepReport("", "FAIL", "Table is not available");
			}
			return count;
		} catch (Throwable t) {
			System.out.println("The Exception for getTableRowCount is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getTableRowCount is : " + t.getMessage());
			return count;
		}
	}

	/*
	 * #########################################################################
	 * ########### ############################## # FunctionName :
	 * getHeadersFromTable # No of Parameter : 2 # Description : Function for
	 * getting total headers in a dynamic table.. # Parameters and its data-type
	 * : Browser browser, String tableXpath # Developed on : 21/07/2017 #
	 * Developed By : Rajesh
	 * #########################################################################
	 * ########### #############################
	 */
	public static List<String> getHeadersFromTable(Browser browser, String tableXpath) {
		List<String> headerList = new ArrayList<String>();

		try {

			List<String> columnHeaders = browser.describe(Table.class, new XPathDescription(tableXpath))
					.getColumnHeaders();
			for (int columns = 0; columns < columnHeaders.size(); columns++) {

				String eachCell = columnHeaders.get(columns);
				headerList.add(eachCell);
			}

		} catch (Throwable t) {
			System.out.println("The Exception for getHeadersFromTable is : " + t.getMessage());
			utility.fnLogging("The Exception for getHeadersFromTable is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getHeadersFromTable is : " + t.getMessage());

		}

		return headerList;

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnButtonClick # No of Parameter : 1 # Description : To click a ImageLink
	 * or Button # Parameters and its datatype : String imgXpath # Developed on
	 * : 19/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean fnImageLinkOrButtonClick(Browser browser, String imgXpath) throws GeneralLeanFtException {

		try {
			browser.describe(Image.class, new XPathDescription(imgXpath)).highlight();
			Thread.sleep(5000);
			browser.describe(Image.class, new XPathDescription(imgXpath)).click();

			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnImageLinkOrButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnImageLinkOrButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for fnImageLinkOrButtonClick  is : " + t.getMessage());
			return false;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnSwitchToParentTab # No of Parameter : 1 # Description : Switch To Super
	 * window Tab based on title. # Parameters and its datatype : String
	 * tabTitle # Developed on : 19/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean fnSwitchToParentTab(Browser browser, String tabTitle) throws GeneralLeanFtException {

		try {

			Thread.sleep(3000);
			browser = BrowserFactory.attach(new BrowserDescription.Builder().title(tabTitle).build());
			browser.highlight();
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnSwitchToParentTab  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnSwitchToParentTab  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnSwitchToParentTab  is : " + t.getMessage());
			return false;
		}
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fncheckBoxValidation # No of Parameter : 3 # Description : Function to
	 * checking or unchecking checkbox based on user inputs.. # Parameters and
	 * its datatype : String tabTitle # Developed on : 21/07/2017 # Developed By
	 * : Rajesh & Durga
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean fncheckBoxValidation(Browser browser, String checkBoxXpath, String checkBoxValue) {
		boolean fncheckBoxValidation = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, checkBoxXpath);
			if (fnStatus == true) {
				CheckBox chk = browser.describe(CheckBox.class,
						new CheckBoxDescription.Builder().xpath(checkBoxXpath).build());
				chk.highlight();
				if (checkBoxValue.equals("Check")) {
					fnStatus = fnClickCheckBox(browser, checkBoxXpath);
					if (fnStatus == true) {
						ReportEvent.testStepReport("testCaseName", "PASS", "Clicked on Checkbox successfully!!");
						fncheckBoxValidation = true;
					} else {
						ReportEvent.testStepReport("testCaseName", "FAIL", "Failed to click on inpatient Checkbox");
						fncheckBoxValidation = false;
					}

				} else {
					ReportEvent.testStepReport("", "PASS", "User didn't passed inputs to click Checkbox.");
					fncheckBoxValidation = true;
				}

			} else {
				ReportEvent.testStepReport("", "FAIL", "There is no check box with xPath : " + checkBoxXpath);
				fncheckBoxValidation = false;
			}
			return fncheckBoxValidation;
		} catch (Throwable t) {
			System.out.println("The Exception for fncheckBoxValidation  is : " + t.getMessage());
			utility.fnLogging("The Exception for fncheckBoxValidation  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fncheckBoxValidation  is : " + t.getMessage());
			return false;
		}
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnClikListBox # No of Parameter : 3 # Description : To select Click
	 * ListBox by using Click method(DropDown) # Parameters and its datatype :
	 * Browser browser,String xpathval # Developed on : 21/07/2017 # Developed
	 * By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnClickListBox(Browser browser, String listBoxXpath) {
		boolean fnClickListBox = false;

		try {

			browser.describe(ListBox.class, new XPathDescription(listBoxXpath)).highlight();
			browser.describe(ListBox.class, new XPathDescription(listBoxXpath)).click();
			fnClickListBox = true;

		} catch (Throwable t) {
			fnClickListBox = false;
		}
		return fnClickListBox;
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnClikEditorDateField # No of Parameter : 3 # Description : To select
	 * Click ListBox by using Click method(Date Field) # Parameters and its
	 * datatype : Browser browser,String xpathval # Developed on : 21/07/2017 #
	 * Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnClikEditOrDateField(Browser browser, String xpathval) throws GeneralLeanFtException {
		try {
			isElementExist(browser, xpathval);
			browser.describe(EditField.class, new XPathDescription(xpathval)).click();
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnClikEditOrDateField  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnClikEditOrDateField  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnClikEditOrDateField  is : " + t.getMessage());
			return false;
		}
	}
	/*
	 * #FunctionName : checkOrUncheckCheckBoxByLabel No of Parameter : 3
	 * Description : Function to check OR Uncheck CheckBox by just passing label
	 * name of check box along with checkboxstatus = 'Check'. Parameters and its
	 * data-type :Browser browser, String labelName, String checkBoxStatus
	 * Developed on : 24/07/2017 Developed By : Rajesh & Durga Return type :
	 * Boolean
	 * #########################################################################
	 * ###########
	 */

	public static boolean checkOrUncheckCheckBoxByLabel(Browser browser, String labelName, String checkBoxStatus) {
		boolean checkOrUncheckCheckBoxByLabel = false;
		try {
			boolean fnStatus = false;
			// String immediateParentXpath =
			// "//label[text()='"+labelName+"']/..";
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				// WebElement immediateParent =
				// driver.findElement(By.xpath(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {

					String checkBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='checkbox']";
					fnStatus = isElementExist(browser, checkBoxXpath);
					if (fnStatus == true) {
						fnStatus = fncheckBoxValidation(browser, checkBoxXpath, checkBoxStatus);
						if (fnStatus == true) {
							checkOrUncheckCheckBoxByLabel = true;
							break outerloop;
						} else {
							checkOrUncheckCheckBoxByLabel = false;
						}
					} else {
						checkOrUncheckCheckBoxByLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("th")) {

					String checkBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='checkbox']";
					fnStatus = isElementExist(browser, checkBoxXpath);
					if (fnStatus == true) {
						fnStatus = fncheckBoxValidation(browser, checkBoxXpath, checkBoxStatus);
						if (fnStatus == true) {
							checkOrUncheckCheckBoxByLabel = true;
							break outerloop;
						} else {
							checkOrUncheckCheckBoxByLabel = false;
						}
					} else {
						checkOrUncheckCheckBoxByLabel = false;
					}

				}
				/*
				 * else if(parentTagName.equalsIgnoreCase("div")) { String
				 * updatedParentXpath = "//label[text()='"+labelName+"']";
				 * String checkBoxXpath = updatedParentXpath+
				 * "/following-sibling::div[1]//input[@type='checkbox']";
				 * fnStatus = isElementExist(browser, checkBoxXpath);
				 * if(fnStatus ==true) { fnStatus
				 * =checkBoxValidationAngularJS(browser, checkBoxXpath,
				 * checkBoxStatus);
				 * 
				 * if(fnStatus ==true) { checkOrUncheckCheckBoxByLabel = true;
				 * break outerloop;
				 * 
				 * 
				 * } else { checkOrUncheckCheckBoxByLabel = false; //break
				 * outerloop; } } else { checkOrUncheckCheckBoxByLabel = false;
				 * } }
				 */

				else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return checkOrUncheckCheckBoxByLabel;
	}

	/***
	 * Function name : clickLinkBasedOnLinkNameAndSectionXpath Description :
	 * Function to click on a link based on link name(unique link name) and by
	 * passing section Xpath..
	 * 
	 * @param testCaseName
	 * @param browser
	 * @param sectionXpath
	 * @param linkName
	 * @return boolean
	 * @author : N.Durgasivaramprasad
	 */
	public static boolean clickLinkBasedOnLinkNameAndSectionXpath(String testCaseName, Browser browser,
			String sectionXpath, String linkName) {
		boolean clickLinkBasedOnLinkNameAndSectionXpath = false;
		boolean isLinkClicked = false;
		try {
			String allLinkTagsXpath = sectionXpath + "//table//a";
			Link[] linkTags = browser.findChildren(Link.class,
					new LinkDescription.Builder().xpath(allLinkTagsXpath).build());

			for (int i = 0; i < linkTags.length; i++) {
				String linkTagInnerText = linkTags[i].getInnerText();
				if (linkTagInnerText.equalsIgnoreCase(linkName)) {
					linkTags[i].click();
					isLinkClicked = true;
					break;
				} else {
					continue;
				}

			}
			if (isLinkClicked == true) {
				clickLinkBasedOnLinkNameAndSectionXpath = true;
			} else {
				clickLinkBasedOnLinkNameAndSectionXpath = false;
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in clickLinkBasedOnLinkNameAndSectionXpath() is", t);
			clickLinkBasedOnLinkNameAndSectionXpath = false;

		}
		return clickLinkBasedOnLinkNameAndSectionXpath;
	}

	/*
	 * #FunctionName : selectValueByVisibleTextBasedOnLabel No of Parameter : 3
	 * Description : Function to select a value from a dropDown by just passing
	 * label name of drop down along with the value to be selected.. Parameters
	 * and its data-type :Browser browser, String labelName, String inputValue
	 * 
	 * Developed By : Rajesh & DurgaSivaram Prasad Return type : Boolean
	 * #########################################################################
	 * ###########
	 */

	public static boolean selectValueByVisibleTextBasedOnLabel(Browser browser, String labelName, String inputValue) {
		boolean selectValueByVisibleTextBasedOnLabel = false;
		try {
			boolean fnStatus = false;
			String parentXpath = null;
			/*
			 * String immediateParentXpath =
			 * "//label[text()='"+labelName+"']/..";
			 */
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				if (level == 1) {
					parentXpath = immediateParentXpath;
				} else {
					parentXpath = parentXpath;
				}
				/* String parentXpath = immediateParentXpath; */
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				// WebElement immediateParent =
				// driver.findElement(By.xpath(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if (fnStatus == true) {
						fnStatus = fnClickListBox(browser, dropdownXpath);
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if (fnStatus == true) {
							selectValueByVisibleTextBasedOnLabel = true;
							break outerloop;
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else {
						selectValueByVisibleTextBasedOnLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("th")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if (fnStatus == true) {
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if (fnStatus == true) {
							selectValueByVisibleTextBasedOnLabel = true;
							break outerloop;
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else {
						selectValueByVisibleTextBasedOnLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("div")) {
					String updatedParentXpath = "//label[text()='" + labelName + "']";
					String siblingXpath = updatedParentXpath + "/following-sibling::*";
					String siblingTagName = browser.describe(WebElement.class, new XPathDescription(parentXpath))
							.getTagName();

					if (siblingTagName.equalsIgnoreCase("div")) {
						String dropdownXpath = updatedParentXpath + "/following-sibling::" + siblingTagName
								+ "//select";
						fnStatus = isElementExist(browser, dropdownXpath);
						if (fnStatus == true) {
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if (fnStatus == true) {
								selectValueByVisibleTextBasedOnLabel = true;
								break outerloop;
							} else {
								selectValueByVisibleTextBasedOnLabel = false;
							}
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else if (siblingTagName.equalsIgnoreCase("select")) {
						String dropdownXpath = updatedParentXpath + "/following-sibling::" + siblingTagName;
						fnStatus = isElementExist(browser, dropdownXpath);
						if (fnStatus == true) {
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if (fnStatus == true) {
								selectValueByVisibleTextBasedOnLabel = true;
								break outerloop;
							} else {
								selectValueByVisibleTextBasedOnLabel = false;
							}
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else {
						// Need to include new tags if we came across any..
						continue;
					}

				} else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return selectValueByVisibleTextBasedOnLabel;
	}

	public static boolean selectValueByVisibleTextBasedOnLabelwithoutContains(Browser browser, String labelName,
			String inputValue) {
		boolean selectValueByVisibleTextBasedOnLabel = false;
		try {
			boolean fnStatus = false;
			String parentXpath = null;
			String immediateParentXpath = "//label[text()='" + labelName + "']/..";
			// String immediateParentXpath
			// ="//label[text()[contains(.,'"+labelName+"')]]/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				if (level == 1) {
					parentXpath = immediateParentXpath;
				} else {
					parentXpath = parentXpath;
				}
				/* String parentXpath = immediateParentXpath; */
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				// WebElement immediateParent =
				// driver.findElement(By.xpath(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if (fnStatus == true) {
						fnStatus = fnClickListBox(browser, dropdownXpath);
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if (fnStatus == true) {
							selectValueByVisibleTextBasedOnLabel = true;
							break outerloop;
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else {
						selectValueByVisibleTextBasedOnLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("th")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if (fnStatus == true) {
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if (fnStatus == true) {
							selectValueByVisibleTextBasedOnLabel = true;
							break outerloop;
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else {
						selectValueByVisibleTextBasedOnLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("div")) {
					String updatedParentXpath = "//label[text()='" + labelName + "']";
					String siblingXpath = updatedParentXpath + "/following-sibling::*";
					String siblingTagName = browser.describe(WebElement.class, new XPathDescription(parentXpath))
							.getTagName();

					if (siblingTagName.equalsIgnoreCase("div")) {
						String dropdownXpath = updatedParentXpath + "/following-sibling::" + siblingTagName
								+ "//select";
						fnStatus = isElementExist(browser, dropdownXpath);
						if (fnStatus == true) {
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if (fnStatus == true) {
								selectValueByVisibleTextBasedOnLabel = true;
								break outerloop;
							} else {
								selectValueByVisibleTextBasedOnLabel = false;
							}
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else if (siblingTagName.equalsIgnoreCase("select")) {
						String dropdownXpath = updatedParentXpath + "/following-sibling::" + siblingTagName;
						fnStatus = isElementExist(browser, dropdownXpath);
						if (fnStatus == true) {
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if (fnStatus == true) {
								selectValueByVisibleTextBasedOnLabel = true;
								break outerloop;
							} else {
								selectValueByVisibleTextBasedOnLabel = false;
							}
						} else {
							selectValueByVisibleTextBasedOnLabel = false;
						}
					} else {
						// Need to include new tags if we came across any..
						continue;
					}

				} else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return selectValueByVisibleTextBasedOnLabel;
	}

	/******************************************************/
	public static boolean selectValueByVisibleTextByLabelWithoutContains(Browser browser, String labelName,
			String inputValue) {
		boolean selectValueByVisibleTextByLabelWithoutContains = false;
		try {
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()='" + labelName + "']/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				// WebElement immediateParent =
				// driver.findElement(By.xpath(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if (fnStatus == true) {
						fnStatus = fnClickListBox(browser, dropdownXpath);
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if (fnStatus == true) {
							selectValueByVisibleTextByLabelWithoutContains = true;
							break outerloop;
						} else {
							selectValueByVisibleTextByLabelWithoutContains = false;
						}
					} else {
						selectValueByVisibleTextByLabelWithoutContains = false;
					}

				} else if (parentTagName.equalsIgnoreCase("th")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if (fnStatus == true) {
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if (fnStatus == true) {
							selectValueByVisibleTextByLabelWithoutContains = true;
							break outerloop;
						} else {
							selectValueByVisibleTextByLabelWithoutContains = false;
						}
					} else {
						selectValueByVisibleTextByLabelWithoutContains = false;
					}

				} else if (parentTagName.equalsIgnoreCase("div")) {
					String updatedParentXpath = "//label[text()='" + labelName + "']";
					String siblingXpath = updatedParentXpath + "/following-sibling::*";
					String siblingTagName = browser.describe(WebElement.class, new XPathDescription(parentXpath))
							.getTagName();

					if (siblingTagName.equalsIgnoreCase("div")) {
						String dropdownXpath = updatedParentXpath + "/following-sibling::" + siblingTagName
								+ "//select";
						fnStatus = isElementExist(browser, dropdownXpath);
						if (fnStatus == true) {
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if (fnStatus == true) {
								selectValueByVisibleTextByLabelWithoutContains = true;
								break outerloop;
							} else {
								selectValueByVisibleTextByLabelWithoutContains = false;
							}
						} else {
							selectValueByVisibleTextByLabelWithoutContains = false;
						}
					} else if (siblingTagName.equalsIgnoreCase("select")) {
						String dropdownXpath = updatedParentXpath + "/following-sibling::" + siblingTagName;
						fnStatus = isElementExist(browser, dropdownXpath);
						if (fnStatus == true) {
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if (fnStatus == true) {
								selectValueByVisibleTextByLabelWithoutContains = true;
								break outerloop;
							} else {
								selectValueByVisibleTextByLabelWithoutContains = false;
							}
						} else {
							selectValueByVisibleTextByLabelWithoutContains = false;
						}
					} else {
						// Need to include new tags if we came across any..
						continue;
					}

				} else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return selectValueByVisibleTextByLabelWithoutContains;
	}
	/*
	 * #FunctionName : sendKeysToTextBoxByLabel No of Parameter : 3 Description
	 * : Function to pass text to an input text box by just passing label name
	 * of text box along with the value to be entered. Parameters and its
	 * data-type :Browser browser, String labelName, String inputValue Developed
	 * on : 24/07/2017 Developed By : Rajesh & DurgaSivaramprasad Return type :
	 * Boolean
	 * #########################################################################
	 * ###########
	 */

	public static boolean sendKeysToTextBoxByLabel(Browser browser, String labelName, String inputValue) {
		boolean sendKeysToTextBoxByLabel = false;
		try {
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			outerloop:

			for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {

					String textBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {
						fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						if (fnStatus == true) {
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						} else {
							sendKeysToTextBoxByLabel = false;
						}
					} else {
						sendKeysToTextBoxByLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("th")) {

					String textBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {
						fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						if (fnStatus == true) {
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						} else {
							sendKeysToTextBoxByLabel = false;
						}
					} else {
						sendKeysToTextBoxByLabel = false;
					}

				}
				/*
				 * else if(parentTagName.equalsIgnoreCase("div")) { String
				 * updatedParentXpath = "//label[text()='"+labelName+"']";
				 * String textBoxXpath =
				 * updatedParentXpath+"/following-sibling::div[1]//input";
				 * ///following-sibling::div[1]//input[@type='text']";
				 * 
				 * 
				 * fnStatus = isElementExist(browser, textBoxXpath); if(fnStatus
				 * ==true) { fnStatus =fnEditFieldTextEntry(browser,
				 * textBoxXpath, inputValue); WebElement element =
				 * driver.findElement(By.xpath(textBoxXpath));
				 * element.sendKeys(Keys.DELETE); element.sendKeys(inputValue);
				 * 
				 * if(fnStatus ==true) { sendKeysToTextBoxByLabel = true; break
				 * outerloop; } else { sendKeysToTextBoxByLabel = false; } }
				 * else { sendKeysToTextBoxByLabel = false; } }
				 */

				else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return sendKeysToTextBoxByLabel;
	}

	/****************************************************************/
	public static boolean sendKeysToTextBoxByLabelWithoutContains(Browser browser, String labelName,
			String inputValue) {
		boolean sendKeysToTextBoxByLabel = false;
		try {
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()='" + labelName + "']/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {

					String textBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {
						fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						if (fnStatus == true) {
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						} else {
							sendKeysToTextBoxByLabel = false;
						}
					} else {
						sendKeysToTextBoxByLabel = false;
					}

				} else if (parentTagName.equalsIgnoreCase("th")) {

					String textBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {
						fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						if (fnStatus == true) {
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						} else {
							sendKeysToTextBoxByLabel = false;
						}
					} else {
						sendKeysToTextBoxByLabel = false;
					}

				}
				/*
				 * else if(parentTagName.equalsIgnoreCase("div")) { String
				 * updatedParentXpath = "//label[text()='"+labelName+"']";
				 * String textBoxXpath =
				 * updatedParentXpath+"/following-sibling::div[1]//input";
				 * ///following-sibling::div[1]//input[@type='text']";
				 * 
				 * 
				 * fnStatus = isElementExist(browser, textBoxXpath); if(fnStatus
				 * ==true) { fnStatus =fnEditFieldTextEntry(browser,
				 * textBoxXpath, inputValue); WebElement element =
				 * driver.findElement(By.xpath(textBoxXpath));
				 * element.sendKeys(Keys.DELETE); element.sendKeys(inputValue);
				 * 
				 * if(fnStatus ==true) { sendKeysToTextBoxByLabel = true; break
				 * outerloop; } else { sendKeysToTextBoxByLabel = false; } }
				 * else { sendKeysToTextBoxByLabel = false; } }
				 */

				else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return sendKeysToTextBoxByLabel;
	}

	/*
	 * #FunctionName : sendKeysToAreaTextBoxByLabel No of Parameter : 3
	 * Description : Function to pass text to an text Area box by just passing
	 * label name of text Area box along with the value to be entered.
	 * Parameters and its data-type :Browser browser, String labelName, String
	 * inputValue Developed on : 25/07/2017 Developed By : Rajesh &
	 * DurgaSivaramprasad Return type : Boolean
	 * #########################################################################
	 * ###########
	 */

	public static boolean sendKeysToAreaTextBoxByLabel(Browser browser, String labelName, String inputValue) {
		boolean sendKeysToAreaTextBoxByLabel = false;
		try {
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {

					String textAreaBoxXpath = parentXpath + "/following-sibling::td[1]//textarea";
					fnStatus = isElementExist(browser, textAreaBoxXpath);
					if (fnStatus == true) {
						fnStatus = fnEditFieldTextEntry(browser, textAreaBoxXpath, inputValue);
						if (fnStatus == true) {
							sendKeysToAreaTextBoxByLabel = true;
							break outerloop;
						} else {
							sendKeysToAreaTextBoxByLabel = false;
						}
					} else {
						sendKeysToAreaTextBoxByLabel = false;
					}

				} else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return sendKeysToAreaTextBoxByLabel;
	}

	/*
	 * #FunctionName : checkFieldNameAvailabilityInSection # No of Parameter : 4
	 * # Description : Function to check if a Field name is available with in a
	 * section. # Parameters and its data-type :Browser browser ,String
	 * fieldName, String sectionXpath # Developed on : 27/07/2017 # Developed By
	 * : Rajesh & DurgaSivaramprasad # Return type : boolean
	 * #########################################################################
	 * ###########
	 */

	public static boolean checkFieldNameAvailabilityInSection(Browser browser, String fieldName, String sectionXpath) {
		boolean checkFieldNameAvailabilityInSection = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionXpath);
			if (fnStatus == true) {
				String rowsXpath = sectionXpath.concat("//table/tbody/tr");
				WebElement[] rowElements = browser.findChildren(WebElement.class,
						new WebElementDescription.Builder().xpath(rowsXpath).build());
				// List<WebElement> rowElements =
				// driver.findElements(By.xpath(rowsXpath));
				int rowCount = rowElements.length;
				outerloop: for (int j = 1; j <= rowCount; j++) {
					String allThTagsXpath = rowsXpath + "[" + j + "]/th";
					WebElement[] rowThElements = rowElements[j].findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(allThTagsXpath).build());
					// List<WebElement> rowThElements =
					// driver.findElements(By.xpath(allThTagsXpath));
					int thElementCount = rowThElements.length;
					for (int k = 1; k <= thElementCount; k++) {
						String thChildTagsXpath = allThTagsXpath + "[" + k + "]/*";
						WebElement[] thChildElements = rowThElements[k].findChildren(WebElement.class,
								new WebElementDescription.Builder().xpath(thChildTagsXpath).build());
						// List<WebElement> thChildElements =
						// driver.findElements(By.xpath(thChildTagsXpath));
						int thChildElementCount = thChildElements.length;
						if (thChildElementCount != 0) {
							for (WebElement thChild : thChildElements) {
								String childElementTagName = thChild.getTagName();
								if (childElementTagName.equals("label")) {
									String childElementText = thChild.getInnerText();
									if (childElementText.equals(fieldName)) {
										System.out.println(fieldName + " : field name is available in the section..");
										checkFieldNameAvailabilityInSection = true;
										break outerloop;
									} else {
										/*
										 * System.out.println(fieldName +
										 * " : field name is NOT available in the section.."
										 * );
										 * checkFieldNameAvailabilityInSection=
										 * false;
										 */
										continue;
									}
								} else {
									continue;
								}

							}

						} else {
							/***
							 * Include if any new tags are available in future
							 */
							continue;
						}

					}
				}
			} else {
				System.out.println("Section is not available!!");
				ReportEvent.testStepReport("", "fail", sectionXpath + "Section is not available");
				// softAssert.fail(sectionXpath + "Section is not available");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for checkFieldNameAvailabilityInSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for checkFieldNameAvailabilityInSection is : " + t.getMessage());
		}
		return checkFieldNameAvailabilityInSection;
	}

	/*
	 * #FunctionName : fnClickFrameButtonByPageTitle # No of Parameter : 4 #
	 * Description : Function to Clicking the button of frame using Page Title.
	 * # Parameters and its data-type :Browser browser,String pageTitle,String
	 * frameName,String buttonXpath # Developed on : 25/07/2017 # Developed By :
	 * Rajesh # Return type : boolean
	 * #########################################################################
	 * ###########
	 */
	public static boolean fnClickFrameButtonByPageTitle(Browser browser, String pageTitle, String frameName,
			String buttonXpath) {
		boolean fnClickFrameButtonByPageTitle = false;

		try {

			browser = BrowserFactory.attach(new BrowserDescription.Builder().title(pageTitle).build());
			browser.highlight();

			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build())
					.describe(Button.class, new XPathDescription(buttonXpath)).highlight();
			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build())
					.describe(Button.class, new XPathDescription(buttonXpath)).click();

			fnClickFrameButtonByPageTitle = true;

		} catch (Throwable t) {
			fnClickFrameButtonByPageTitle = false;
		}
		return fnClickFrameButtonByPageTitle;
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name : datePicker #
	 * No of Parameter : 3 # Description : Function for selecting date from date
	 * picker # Parameters and its datatype : Browser browser, String
	 * tableLocator, String date # Developed on : 25/07/2017 # Developed By :
	 * Rajesh
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean datePicker(Browser browser, String tableLocator, String date) {
		boolean datePicker = false;

		try {
			if (isElementExist(browser, tableLocator)) {
				String[] strArray = date.split("/");
				String month = strArray[0]; // --//day
				String day = strArray[1]; // --//month
				String year = strArray[2];
				// ReportEvent.testStepReport("", "PASS", "Identified locator");
				String monthText = tableLocator.concat("//select[@title = 'Month']");
				String yearText = tableLocator.concat("//select[@title = 'Year']");
				String dateText = tableLocator.concat("//div/table");

				int rowCount = fngetTableRowCount(browser, dateText);
				// Year selection..
				browser.describe(WebElement.class, new XPathDescription(yearText)).click();
				boolean yearStatus = fnListBox(browser, yearText, year);
				if (yearStatus = true) {
					// ReportEvent.testStepReport("", "PASS", "selected year is
					// :" + year);
					// Month selection..
					browser.describe(WebElement.class, new XPathDescription(monthText)).click();
					boolean monthStatus = fnListBox(browser, monthText, month);
					if (monthStatus = true) {
						// ReportEvent.testStepReport("", "PASS", "selected
						// Month is :" + month);
						// Date selection..
						outerloop: for (int i = 1; i < rowCount; i++) {
							String rowPath = dateText.concat("//tr[" + i + "]");
							// Fetching all child elements of row tag.
							String allChildTagsXpath = rowPath.concat("/*");

							WebElement[] allChild = browser.findChildren(WebElement.class,
									new XPathDescription(allChildTagsXpath));
							for (int h = 0; h <= allChild.length - 1; h++) {
								System.out.println(allChild[h].getInnerText());
								String innerText = allChild[h].getInnerText();
								if (innerText.equalsIgnoreCase(day)) {
									allChild[h].click();
									datePicker = true;
									// ReportEvent.testStepReport("", "PASS",
									// "Clicked date :" + day);
									break outerloop;
								} else {
									continue;
								}
							}

						}

					}

					else {
						ReportEvent.testStepReport("", "FAIL", "Month is not selected");
					}
				} else {
					ReportEvent.testStepReport("", "FAIL", "Year is not selected");

				}
			} else {
				ReportEvent.testStepReport("", "FAIL", "Date is not selected");
				datePicker = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for datePicker is : " + t.getMessage());
			utility.fnLogging("The Exception for datePicker is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for datePicker is : " + t.getMessage());
		}
		return datePicker;
	}

	/*
	 * #FunctionName : dateConversion # No of Parameter : 5 # Description :
	 * Function to convert the date format from 'FullMonth/dd/yyyy' to
	 * 'mm/dd/yyyy' OR from 'mm/dd/yyyy' to 'FullMonth/dd/yyyy' # Parameters and
	 * its data-type : String inputDate, String dateFormat # Developed on :
	 * 14/06/2017 # Developed By : Subrato, Sarkar # Return type : int
	 * #########################################################################
	 * ###########
	 */
	public static String dateConversion(String inputDate, String dateFormat) {
		String convertedDate = null;

		HashMap<Integer, String> dateInput = new HashMap<Integer, String>();
		dateInput.put(1, "January");
		dateInput.put(2, "February");
		dateInput.put(3, "March");
		dateInput.put(4, "April");
		dateInput.put(5, "May");
		dateInput.put(6, "June");
		dateInput.put(7, "July");
		dateInput.put(8, "August");
		dateInput.put(9, "September");
		dateInput.put(10, "October");
		dateInput.put(11, "November");
		dateInput.put(12, "December");

		switch (dateFormat) {

		case "FullMonth/dd/yyyy":

			System.out.println(dateInput.get(Integer.parseInt(inputDate.split("/")[0])) + "/" + inputDate.split("/")[1]
					+ "/" + inputDate.split("/")[2]);
			convertedDate = dateInput.get(Integer.parseInt(inputDate.split("/")[0])) + "/" + inputDate.split("/")[1]
					+ "/" + inputDate.split("/")[2];
			return convertedDate;

		case "mm/dd/yyyy":

			for (Entry<Integer, String> entry : dateInput.entrySet()) {
				if (entry.getValue().equals(inputDate.split("/")[0])) {
					System.out.println(entry.getKey() + "/" + inputDate.split("/")[1] + "/" + inputDate.split("/")[2]);
					convertedDate = entry.getKey() + "/" + inputDate.split("/")[1] + "/" + inputDate.split("/")[2];
					System.out.println("convertedDate is:" + convertedDate);
					return convertedDate;
				} else {
					continue;
				}
			}
		}
		return convertedDate;
	}

	/*
	 * #FunctionName : DateAndTimeConversionBasedOnTimeZones No of Parameter : 2
	 * Description : Function to convert date and Time of TimeZone-1 to
	 * TimeZone2. Parameters and its data-type :String TimeZone1, String
	 * TimeZone2 Developed on : 07/08/2017 Developed By : Rajesh Return type :
	 * String Note : TimeZone of India is "Asia/Calcutta" and Time zone of
	 * Portland is "US/Pacific".
	 * #########################################################################
	 * ###########
	 */
	public static String DateAndTimeConversionBasedOnTimeZones(String TimeZone1, String TimeZone2) {
		String DATE_FORMAT = "M/dd/yyyy h:mm a";
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		String minutes = "";

		if (cal.get(Calendar.MINUTE) < 10) {
			minutes = String.format("%02d", cal.get(Calendar.MINUTE));
		} else {
			minutes = String.valueOf(cal.get(Calendar.MINUTE));
		}
		int hourVal = 0;
		if (hour == 0) {
			hourVal = 0;
		} else if (hour < 12) {
			hourVal = hour;
		} else if (hour == 12) {
			hourVal = 12;
		} else {
			hourVal = hour - 12;
		}
		int month = cal.get(Calendar.MONTH) + 1;
		String timeString = "";
		if (hour == 0) {
			timeString = "AM";
		} else if (hour < 12) {
			timeString = "AM";
		} else if (hour == 12) {
			timeString = "PM";
		} else {
			timeString = "PM";
		}

		String convertedDateTime = month + "/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR) + " " + hourVal
				+ ":" + minutes + " " + timeString;
		String dateInString = convertedDateTime;
		LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
		ZoneId TimeZone1Id = ZoneId.of(TimeZone1/* "Asia/Calcutta" */);
		System.out.println("TimeZone1 ID : " + TimeZone1Id);
		ZonedDateTime TimeZone1DateTime = ldt.atZone(TimeZone1Id);
		ZoneId TimeZone2Id = ZoneId.of(TimeZone2/* "US/Pacific" */);
		System.out.println("TimeZone2 ID : " + TimeZone2Id);
		ZonedDateTime TimeZone2DateTime = TimeZone1DateTime.withZoneSameInstant(TimeZone2Id);
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
		System.out.println("\n---DateTimeFormatter---");
		System.out.println("Formatted Date of TimeZone1 : " + format.format(TimeZone1DateTime));
		System.out.println("Formatted Date of TimeZone2 : " + format.format(TimeZone2DateTime));
		return format.format(TimeZone2DateTime);
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnClickLinkInLinkClass # No of Parameter : 1 # Description : To click a
	 * Link class link # Parameters and its datatype : String xpathVal #
	 * Developed on : 26/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean fnClickLinkInLinkClass(Browser browser, String xpathVal) throws GeneralLeanFtException {

		try {
			browser.describe(Link.class, new XPathDescription(xpathVal)).highlight();
			browser.describe(Link.class, new XPathDescription(xpathVal)).click();
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnClickLinkInLinkClass  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnClickLinkInLinkClass  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnClickLinkInLinkClass  is : " + t.getMessage());
			return false;
		}

	}

	// For converting date from "10/June/2017" to "6/10/2017" format
	public static String dateConversionFromddMMMYYYYTodMYYYY(String Inputdate) {
		String[] strArray = Inputdate.split("/");
		String day = strArray[0];
		String month = strArray[1];
		String year = strArray[2];
		String monthUpdated = null;
		switch (month) {
		case "January":
			monthUpdated = "1";
			break;
		case "February":
			monthUpdated = "2";
			break;
		case "March":
			monthUpdated = "3";
			break;
		case "April":
			monthUpdated = "4";
			break;
		case "May":
			monthUpdated = "5";
			break;
		case "June":
			monthUpdated = "6";
			break;
		case "July":
			monthUpdated = "7";
			break;
		case "August":
			monthUpdated = "8";
			break;
		case "September":
			monthUpdated = "9";
			break;
		case "October":
			monthUpdated = "10";
			break;
		case "November":
			monthUpdated = "11";
			break;
		case "December":
			monthUpdated = "12";
			break;
		}

		String formattedInputDate = monthUpdated + "/" + day + "/" + year;
		return formattedInputDate;

	}

	// For converting date from "6/10/2017" to "10/June/2017" format
	public static String dateConversionFromdMYYYYToddMMMYYYY(String Inputdate) {

		String[] strArray = Inputdate.split("/");
		String month = strArray[0];
		String day = strArray[1];
		String year = strArray[2];
		String monthUpdated = null;
		switch (month) {
		case "01":
			monthUpdated = "January";
		case "02":
			monthUpdated = "February";
		case "03":
			monthUpdated = "March";
		case "04":
			monthUpdated = "April";
		case "05":
			monthUpdated = "May";
		case "06":
			monthUpdated = "June";
		case "07":
			monthUpdated = "July";
		case "08":
			monthUpdated = "August";
		case "09":
			monthUpdated = "September";
		case "10":
			monthUpdated = "October";
		case "11":
			monthUpdated = "November";
		case "12":
			monthUpdated = "December";
		}

		String formattedInputDate = day + "/" + monthUpdated + "/" + year;

		return formattedInputDate;
	}

	/*
	 * #FunctionName : getLabelsOfSection # No of Parameter : 3 # Description :
	 * Function to fetch all Labels within a section into a list.. # Parameters
	 * and its data-type : Browser browser, String sectionXpath # Developed on :
	 * 04/08/2017 # Developed By : Rajesh # Return type : String
	 * #########################################################################
	 * ###########
	 */

	public static List<String> getLabelsOfSection(String sectionXpath, Browser browser) {
		List<String> labelList = new ArrayList<String>();
		try {
			String allLabelsXpath = sectionXpath.concat("//table//label");

			WebElement[] allChild = browser.findChildren(WebElement.class, new XPathDescription(allLabelsXpath));

			for (WebElement labelText : allChild) {
				labelText.highlight();
				System.out.println(labelText.getInnerText());
				labelList.add(labelText.getInnerText());
			}

		} catch (Throwable t) {
			System.out.println("The Exception for getLabelsOfSection is : " + t.getMessage());
			utility.fnLogging("The Exception for getLabelsOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getLabelsOfSection is : " + t.getMessage());

		}

		return labelList;
	}

	/*
	 * #FunctionName : fieldAvailabilityValidation # No of Parameter : 3 #
	 * Description : Function to check availability of fields of any
	 * section/page.. # Parameters and its data-type : Browser browser, String
	 * sectionXpath, String inputFieldValues # Developed on : 04/08/2017 #
	 * Developed By : Rajesh # Return type : boolean # Note : All input fields
	 * needs to be separated by Comma(,).
	 * #########################################################################
	 * ###########
	 */

	public static boolean fieldAvailabilityValidation(Browser browser, String inputFieldValues, String sectionXpath) {
		int matchedFieldCounter = 0;
		boolean fieldAvailabilityValidation = false;
		try {
			String splitInputFields[] = inputFieldValues.split(",");
			List<String> splitInputFieldsList = new ArrayList<String>();
			splitInputFieldsList = Arrays.asList(splitInputFields);
			int inputFieldCount = splitInputFieldsList.size();
			List<String> pageSource = getLabelsOfSection(sectionXpath, browser);
			for (int i = 0; i <= inputFieldCount - 1; i++) {
				if (pageSource.contains(splitInputFieldsList.get(i))) {
					matchedFieldCounter++;
				} else {
					continue;
				}
			}
			if (matchedFieldCounter == inputFieldCount) {
				fieldAvailabilityValidation = true;
			} else {
				int difference = inputFieldCount - matchedFieldCounter;
				ReportEvent.testStepReport("", "FAIL", difference + "is count of unmatched field names.");
				fieldAvailabilityValidation = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for fieldAvailabilityValidation is : " + t.getMessage());
			utility.fnLogging("The Exception for fieldAvailabilityValidation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for fieldAvailabilityValidation is : " + t.getMessage());
			// softAssert.fail("The Exception for fieldAvailabilityValidation is
			// : " + t.getMessage());
			fieldAvailabilityValidation = false;
		}

		return fieldAvailabilityValidation;
	}

	/*
	 * #FunctionName : checkingColumn2AvailabilityBetweenColumn1And3 # No of
	 * Parameter : 6 # Description : Function to check if column header-2 is
	 * available in between Column header-1 and column header-3 in a section.. #
	 * Parameters and its data-type : Browser browser,String tableXpath, String
	 * columnHeader1, String columnHeader2, String columnHeader3 # Developed on
	 * : 27/07/2017 # Developed By : Rajesh & DurgaSivaramprasad # Return type :
	 * boolean
	 * 
	 * #########################################################################
	 * ###########
	 */
	public static boolean checkingColumn2AvailabilityBetweenColumn1And3(Browser browser, String tableXpath,
			String columnHeader1, String columnHeader2, String columnHeader3) {
		boolean checkingColumn2AvailabilityBetweenColumn1And3 = false;
		List<String> columnHeadersList = new ArrayList<String>();
		int header2Index = 0;
		int header3Index = 0;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				columnHeadersList = getHeadersFromTable(browser, tableXpath);
				int headerCount = columnHeadersList.size();
				for (int i = 0; i <= headerCount; i++) {
					String headerText = columnHeadersList.get(i);
					if (headerText.equalsIgnoreCase(columnHeader1)) {
						header2Index = i + 1;
						String header2Text = columnHeadersList.get(header2Index);
						if (header2Text.equalsIgnoreCase(columnHeader2)) {
							header3Index = header2Index + 1;
							String header3Text = columnHeadersList.get(header3Index);
							if (header3Text.equalsIgnoreCase(columnHeader3)) {
								System.out.println(columnHeader2 + ", is available in between : " + columnHeader1
										+ " and " + columnHeader3);
								checkingColumn2AvailabilityBetweenColumn1And3 = true;
								break;
							} else {
								System.out.println(
										columnHeader2 + ", is not available BEFORE column header " + columnHeader3);
								ReportEvent.testStepReport("", "FAIL",
										columnHeader2 + ", is not available BEFORE column header " + columnHeader3);
								checkingColumn2AvailabilityBetweenColumn1And3 = false;
							}
						} else {
							System.out.println(
									columnHeader1 + ", is not available BEFORE column header " + columnHeader2);
							ReportEvent.testStepReport("", "FAIL",
									columnHeader1 + ", is not available BEFORE column header " + columnHeader2);
							checkingColumn2AvailabilityBetweenColumn1And3 = false;
						}
					} else {
						continue;
					}

				}
			} else {
				System.out.println(tableXpath + ", table xpath is not available.");
			}
		} catch (Throwable t) {
			System.out
					.println("The Exception for checkingColumn2AvailabilityBetweenColumn1And3 is : " + t.getMessage());
			utility.fnLogging("The Exception for checkingColumn2AvailabilityBetweenColumn1And3 is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for checkingColumn2AvailabilityBetweenColumn1And3 is : " + t.getMessage());
			// softAssert.fail("The Exception for
			// checkingColumn2AvailabilityBetweenColumn1And3 is : " +
			// t.getMessage());
			checkingColumn2AvailabilityBetweenColumn1And3 = false;
		}
		return checkingColumn2AvailabilityBetweenColumn1And3;
	}

	/*
	 * #FunctionName : checkingDropDownValues No of Parameter : 3 Description :
	 * Function to check availability of all values in a dropdown by just
	 * passing label name and dropdown values as input to the function.
	 * Parameters and its data-type :Browser browser, String labelName, String
	 * inputValues Developed on : 27/07/2017 Developed By : Rajesh & Durga
	 * Return type : Boolean
	 * #########################################################################
	 * ###########
	 */
	public static boolean checkingDropDownValues(Browser browser, String labelName, String inputValues) {

		boolean checkingDropDownValues = false;
		int matchedvalueCounter = 0;
		try {
			String inputValArray[] = inputValues.split(",");
			List<String> inputValueList = Arrays.asList(inputValArray);
			String immediateParentXpath = "//label[text()='" + labelName + "']/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";

				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {
					String dropdownXpath = parentXpath + "/following-sibling::td[1]//select";
					ListBox dropdownList = browser.describe(ListBox.class, new XPathDescription(dropdownXpath));
					List<ListItem> allItems = dropdownList.getItems();
					for (ListItem allValues : allItems) {
						for (String inputValue : inputValueList) {
							if (allValues.getText().equalsIgnoreCase(inputValue)) {
								System.out.println(allValues.getText());
								matchedvalueCounter++;
							} else {
								continue;
							}
						}
					}
					if (matchedvalueCounter == inputValueList.size()) {
						checkingDropDownValues = true;
						break outerloop;
					} else {
						checkingDropDownValues = false;
					}

				} else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return checkingDropDownValues;
	}

	/*
	 * #FunctionName : getFieldValueOfSection # No of Parameter : 4 #
	 * Description : Function to fetch Value of a field in a section based on
	 * user inputs related to field name/key.. # Parameters and its data-type :
	 * Browser browser,String fieldName, String sectionXpath # Developed on :
	 * 31/07/2017 # Developed By : Rajesh & Durga # Return type : String
	 * #########################################################################
	 * ###########
	 */
	/*
	 * public static String getFieldValueOfSection(Browser browser, String
	 * fieldName,String sectionXpath) { String fieldValue = null; try { boolean
	 * fnStatus = false; fnStatus = isElementExist(browser, sectionXpath); if
	 * (fnStatus == true) { String tableXpath = sectionXpath.concat("//table");
	 * int rowCount = getSectionTableRowCount(browser, tableXpath); outerloop:
	 * for (int j = 1; j <= rowCount; j++) { String allTdTagsXpath = tableXpath
	 * + "//tr[" + j + "]/td"; WebElement[] rowTdElements =
	 * browser.findChildren(WebElement.class, new
	 * WebElementDescription.Builder().xpath(allTdTagsXpath).build()); int
	 * tdElementCount = rowTdElements.length; for (int k = 0; k <=
	 * tdElementCount - 1; k++) { int h = k;
	 * 
	 * if (k % 2 == 0) { String tdElementText = rowTdElements[k].getInnerText();
	 * if (tdElementText.equals(fieldName)) { h++; // Checking for child tags..
	 * String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]" + "/*";
	 * WebElement[] tdChildElements = browser.findChildren(WebElement.class, new
	 * WebElementDescription.Builder().xpath(tdChildtagsXpath).build()); int
	 * tdchildCount = tdChildElements.length;
	 * 
	 * if (tdchildCount > 1) { for (int m = 0; m > tdchildCount; m++) { String
	 * tdChildTagName = tdChildElements[m].getTagName(); if
	 * (tdChildTagName.equalsIgnoreCase("a")) { fieldValue =
	 * tdChildElements[m].getInnerText(); System.out.println(fieldValue); break
	 * outerloop; } else { continue; } } } else { fieldValue =
	 * rowTdElements[h].getInnerText(); System.out.println(fieldValue); break
	 * outerloop; }
	 * 
	 * } else { continue; }
	 * 
	 * } else { continue; } } } } else { System.out.println(
	 * "Section is not available!!"); ReportEvent.testStepReport("", "fail",
	 * sectionXpath + "Section is not available");
	 * //softAssert.fail(sectionXpath + "Section is not available"); } } catch
	 * (Throwable t) { System.out.println(
	 * "The Exception for getFieldValueOfSection is : " + t.getMessage());
	 * ReportEvent.testStepReport("", "fail",
	 * "The Exception for getFieldValueOfSection is : " + t.getMessage()); }
	 * return fieldValue; }
	 */

	/*
	 * 
	 * #FunctionName : fnEnterInputTextInWindowFrame # No of Parameter : 4 #
	 * Description : Function to Enter the text in textfield under frame based
	 * on page title.. Parameters and its data-type :Browser browser,String
	 * pageTitle,String frameName,String inputTextBoxXpath,String inputTextName
	 * Developed on : 31/07/2017 # Developed By : Rajesh # Return Type : boolean
	 * #########################################################################
	 * ###########
	 */
	public static boolean fnEnterInputTextInWindowFrame(Browser browser, String pageTitle, String frameName,
			String inputTextBoxXpath/* ,String inputTextName */) {
		boolean fnEnterInputTextInWindowFrame = false;

		try {
			/*
			 * browser=BrowserFactory.attach(new
			 * BrowserDescription.Builder().title(
			 * "Search for a user ~ Salesforce - Unlimited Edition").build());
			 * browser=BrowserFactory.attach(new
			 * BrowserDescription.Builder().title(
			 * "Search ~ Salesforce - Unlimited Edition").build());
			 * 
			 * browser.highlight();
			 */

			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build())
					.describe(EditField.class, new EditFieldDescription.Builder().xpath(inputTextBoxXpath).build())
					.highlight();
			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build())
					.describe(EditField.class, new EditFieldDescription.Builder().xpath(inputTextBoxXpath)
							.build());/* .setValue(inputTextName); */

			fnEnterInputTextInWindowFrame = true;

		} catch (Throwable t) {
			fnEnterInputTextInWindowFrame = false;
			System.out.println(t.getMessage());
		}
		return fnEnterInputTextInWindowFrame;
	}

	public static boolean fnEnterInputTextInFrameTextbox(Browser browser, String pageTitle, String frameName,
			String inputTextBoxXpath/* ,String inputTextName */) {
		boolean fnEnterInputTextInWindowFrame = false;

		try {

			browser = BrowserFactory
					.attach(new BrowserDescription.Builder().title("Search ~ Salesforce - Unlimited Edition").build());

			browser.highlight();

			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build())
					.describe(EditField.class, new EditFieldDescription.Builder().xpath(inputTextBoxXpath).build())
					.highlight();
			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build())
					.describe(EditField.class, new EditFieldDescription.Builder().xpath(inputTextBoxXpath)
							.build());/* .setValue(inputTextName); */

			fnEnterInputTextInWindowFrame = true;

		} catch (Throwable t) {
			fnEnterInputTextInWindowFrame = false;
			System.out.println(t.getMessage());
		}
		return fnEnterInputTextInWindowFrame;
	}

	/*
	 * #FunctionName : clickingTableLinkInFrame # No of Parameter : 4 #
	 * Description : Function to click link in table frame based on page title..
	 * Parameters and its data-type :Browser browser,String pageTitle,String
	 * frameName,String linkName Developed on : 31/07/2017 # Developed By :
	 * Rajesh # Return Type : boolean
	 * #########################################################################
	 * ###########
	 */
	public static boolean clickingTableLinkInFrame(
			Browser browser/*
							 * ,String pageTitle,String frameName,String
							 * linkName
							 */) {
		boolean clickingTableLinkInFrame = false;
		try {

			Link lnk = browser
					.describe(Page.class, new PageDescription.Builder().title("Salesforce - Unlimited Edition").build())
					.describe(Frame.class, new FrameDescription.Builder().name("066A0000001XCIx").build())
					.describe(Table.class, new TableDescription.Builder().tagName("TABLE").build())
					.describe(Link.class, new LinkDescription.Builder()
							.xpath("//FORM[1]/TABLE[1]/TBODY[1]/TR[2]/TD[1]/A[1]").tagName("A").build());
			lnk.highlight();
			lnk.click();

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return true;
	}

	/*
	 * #FunctionName : fnClickButtonInTableWindowFrame # No of Parameter : 3 #
	 * Description : Function to click button in a frame based on user inputs..
	 * Parameters and its data-type :Browser browser,String pageTitle,String
	 * frameName,String buttonXpath Developed on : 03/08/2017 # Developed By :
	 * Rajesh # Return Type : boolean
	 * #########################################################################
	 * ###########
	 */
	public static boolean fnClickButtonInTableWindowFrame(Browser browser, String pageTitle, String frameName,
			String buttonXpath) {
		boolean fnClickButtonInTableWindowFrame = false;

		try {
			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().id(frameName).build())
					.describe(Table.class,
							new TableDescription.Builder().tagName("TABLE").innerText(" Contacts ").build())
					.describe(Button.class, new XPathDescription(buttonXpath)).highlight();

			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().id(frameName).build())
					.describe(Table.class,
							new TableDescription.Builder().tagName("TABLE").innerText(" Contacts ").build())
					.describe(Button.class, new XPathDescription(buttonXpath)).click();

			fnClickButtonInTableWindowFrame = true;

		} catch (Throwable t) {
			fnClickButtonInTableWindowFrame = false;
			System.out.println(t.getMessage());
		}
		return fnClickButtonInTableWindowFrame;
	}

	/*
	 * #FunctionName : fnSwitchToTableInWindowFrame # No of Parameter : 3 #
	 * Description : Function to Switch to table in a frame using table
	 * locator.. Parameters and its data-type :Browser browser,String
	 * pageTitle,String frameName,String tableXpath Developed on : 03/08/2017 #
	 * Developed By : Rajesh # Return Type : boolean
	 * #########################################################################
	 * ###########
	 */
	public static boolean fnSwitchToTableInWindowFrame(Browser browser, String pageTitle, String frameName,
			String tableXpath) {
		boolean fnSwitchToTableInWindowFrame = false;

		try {
			Table tbl = browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().id(frameName).build())
					.describe(Table.class, new XPathDescription(tableXpath));
			tbl.highlight();
			List<TableRow> rowCount = tbl.getRows();
			int totalRowCount = rowCount.size();

			fnSwitchToTableInWindowFrame = true;

		} catch (Throwable t) {
			fnSwitchToTableInWindowFrame = false;
			System.out.println(t.getMessage());
		}
		return fnSwitchToTableInWindowFrame;
	}

	/*
	 * #FunctionName : clickFieldValueOfSection # No of Parameter : 4 #
	 * Description : Function to click Value of a field in a section based on
	 * user inputs related to field name/key.. # Parameters and its data-type :
	 * Browser browser,String fieldName, String sectionXpath # Developed on :
	 * 07/08/2017 # Developed By : Rajesh & Durga # Return type : String
	 * #########################################################################
	 * ###########
	 */
	public static String clickFieldValueOfSection(Browser browser, String fieldName, String sectionXpath) {
		String fieldValue = null;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionXpath);
			if (fnStatus == true) {
				String tableXpath = sectionXpath; /*
													 * sectionXpath.concat(
													 * "//table");
													 */
				int rowCount = getSectionTableRowCount(browser, tableXpath);
				outerloop: for (int j = 1; j <= rowCount; j++) {
					String allTdTagsXpath = tableXpath + "//tr[" + j + "]/td";
					WebElement[] rowTdElements = browser.findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
					int tdElementCount = rowTdElements.length;
					for (int k = 0; k <= tdElementCount - 1; k++) {
						int h = k;

						if (k % 2 == 0) {
							String tdElementText = rowTdElements[k].getInnerText();
							if (tdElementText.equals(fieldName)) {
								h++;
								// Checking for child tags..
								String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]//a";
								Link[] tdChildElements = rowTdElements[h].findChildren(Link.class,
										new LinkDescription.Builder().xpath(tdChildtagsXpath).build());
								int tdchildCount = tdChildElements.length;

								if (tdchildCount > 1) {
									for (int m = 0; m > tdchildCount; m++) {
										String tdChildTagName = tdChildElements[m].getTagName();
										if (tdChildTagName.equalsIgnoreCase("a")) {
											tdChildElements[m].click();
											break outerloop;
										} else {
											continue;
										}
									}
								} else {
									rowTdElements[h].click();
									System.out.println(fieldValue);
									break outerloop;
								}

							} else {
								continue;
							}

						} else {
							continue;
						}
					}
				}
			} else {
				System.out.println("Section is not available!!");
				ReportEvent.testStepReport("", "fail", sectionXpath + "Section is not available");
				// softAssert.fail(sectionXpath + "Section is not available");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickFieldValueOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickFieldValueOfSection is : " + t.getMessage());
		}
		return fieldValue;
	}

	public static List<String> getInputButtonsOfSection(String sectionXpath, Browser browser) {
		List<String> buttonList = new ArrayList<String>();
		try {
			String allButtonsXpath = sectionXpath.concat("//input");

			WebElement[] allChild = browser.findChildren(WebElement.class, new XPathDescription(allButtonsXpath));

			for (WebElement buttonText : allChild) {
				buttonText.highlight();
				System.out.println(buttonText.getTitle());
				buttonList.add(buttonText.getTitle());
			}

		} catch (Throwable t) {
			System.out.println("The Exception for getInputButtonsOfSection is : " + t.getMessage());
			utility.fnLogging("The Exception for getInputButtonsOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getInputButtonsOfSection is : " + t.getMessage());
		}

		return buttonList;
	}

	/*
	 * #FunctionName : fieldAvailabilityValidation # No of Parameter : 3 #
	 * Description : Function to check availability of fields of any
	 * section/page.. # Parameters and its data-type : Browser browser, String
	 * sectionXpath, String inputFieldValues # Developed on : 04/08/2017 #
	 * Developed By : Rajesh # Return type : boolean # Note : All input fields
	 * needs to be separated by Comma(,).
	 * #########################################################################
	 * ###########
	 */

	public static boolean buttonsAvailabilityValidation(Browser browser, String inputFieldValues, String buttonXpath) {
		int matchedFieldCounter = 0;
		boolean buttonsAvailabilityValidation = false;
		try {
			String splitInputFields[] = inputFieldValues.split(",");
			List<String> splitInputFieldsList = new ArrayList<String>();
			splitInputFieldsList = Arrays.asList(splitInputFields);
			int inputFieldCount = splitInputFieldsList.size();
			List<String> pageSource = getInputButtonsOfSection(buttonXpath, browser);
			for (int i = 0; i <= inputFieldCount - 1; i++) {
				if (pageSource.contains(splitInputFieldsList.get(i))) {
					matchedFieldCounter++;
				} else {
					continue;
				}
			}
			if (matchedFieldCounter == inputFieldCount) {
				buttonsAvailabilityValidation = true;
			} else {
				int difference = inputFieldCount - matchedFieldCounter;
				ReportEvent.testStepReport("", "FAIL", difference + "is count of unmatched field names.");
				buttonsAvailabilityValidation = false;
			}

		} catch (Throwable t) {
			System.out.println("The Exception for buttonsAvailabilityValidation is : " + t.getMessage());
			utility.fnLogging("The Exception for buttonsAvailabilityValidation is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for buttonsAvailabilityValidation is : " + t.getMessage());
			// softAssert.fail("The Exception for fieldAvailabilityValidation is
			// : " + t.getMessage());
			buttonsAvailabilityValidation = false;
		}

		return buttonsAvailabilityValidation;
	}

	/*
	 * #FunctionName : gettingBusinessDays # No of Parameter : 1 # Description :
	 * Function to getting business days excluding weekends(Saturday & Sunday) #
	 * Parameters and its data-type : int days # Developed on : 19/09/2017
	 * Developed By : Rajesh # Return type : String
	 * #########################################################################
	 * ###########
	 */

	public static String gettingRequiredBusinessDayDate(int days) {

		java.util.Date date = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		date = calendar.getTime();
		SimpleDateFormat s = new SimpleDateFormat("M/dd/yyyy");
		System.out.println(s.format(date));
		for (int i = 0; i < days;) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);

			if (calendar.get(Calendar.DAY_OF_WEEK) <= 5) {
				i++;
			}

		}
		date = calendar.getTime();
		String businessDays = s.format(date);

		System.out.println(businessDays);
		return businessDays;
	}

	public static boolean fnSwitchToFrameNameByPageTitle(Browser browser, String pageTitle, String frameName) {
		boolean fnSwitchToFrameNameByPageTitle = false;

		try {
			browser = BrowserFactory.attach(new BrowserDescription.Builder()
					.title(pageTitle/* "Search for a user ~ Salesforce - Unlimited Edition" */).build());
			browser.highlight();

			browser.describe(Page.class, new PageDescription.Builder().title(pageTitle).build())
					.describe(Frame.class, new FrameDescription.Builder().name(frameName).build()).highlight();
			fnSwitchToFrameNameByPageTitle = true;

		} catch (Throwable t) {
			fnSwitchToFrameNameByPageTitle = false;
		}
		return fnSwitchToFrameNameByPageTitle;
	}

	/***
	 * #FunctionName : clickingFieldValueOfSectionBasedOnLabel Description :
	 * Function to click link Value of a field in a section based on user inputs
	 * related to field name/key.. Author : N.Durgasivaramprasad Developed on :
	 * 19/09/2017
	 * 
	 * @param browser
	 * @param fieldName
	 * @param sectionXpath
	 * @return boolean
	 * 
	 */

	public static boolean clickingFieldValueOfSectionBasedOnLabel(Browser browser, String fieldName,
			String sectionXpath) {
		/* String fieldValue = null; */
		boolean clickingFieldValueOfSectionBasedOnLabel = false;

		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionXpath);
			if (fnStatus == true) {
				String tableXpath = sectionXpath.concat("//table");
				int rowCount = getSectionTableRowCount(browser, tableXpath);
				outerloop: for (int j = 1; j <= rowCount; j++) {
					String allTdTagsXpath = tableXpath + "//tr[" + j + "]/td";
					WebElement[] rowTdElements = browser.findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
					int tdElementCount = rowTdElements.length;
					for (int k = 0; k <= tdElementCount - 1; k++) {
						int h = k;

						if (k % 2 == 0) {
							String tdElementText = rowTdElements[k].getInnerText();
							if (tdElementText.equals(fieldName)) {
								h++;
								// Checking for child tags..
								String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]//a";
								Link aTagElement = browser.describe(Link.class, new XPathDescription(tdChildtagsXpath));
								aTagElement.highlight();
								aTagElement.click();
								clickingFieldValueOfSectionBasedOnLabel = true;
								break outerloop;
							} else {
								continue;
							}

						} else {
							continue;
						}
					}
				}
			} else {
				System.out.println("Section is not available!!");
				ReportEvent.testStepReport("", "fail", sectionXpath + "Section is not available");
				// softAssert.fail(sectionXpath + "Section is not available");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickingFieldValueOfSectionBasedOnLabel is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingFieldValueOfSectionBasedOnLabel is : " + t.getMessage());
		}
		return clickingFieldValueOfSectionBasedOnLabel;
	}

	/***
	 * #FunctionName : selectingDateBasedOnLabel Description : Function to
	 * select date Value of a label in a section based on user inputs related to
	 * label and input date.. Author : N.Durgasivaramprasad Developed on :
	 * 19/09/2017
	 * 
	 * @param browser
	 * @param fieldName
	 * @param sectionXpath
	 * @return boolean
	 * 
	 */

	public static boolean selectingDateBasedOnLabel(Browser browser, String sectionXpath, String fieldName,
			String inputDate) {
		boolean selectingDateBasedOnLabel = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionXpath);
			if (fnStatus == true) {
				String tableXpath = sectionXpath.concat("//table");
				int rowCount = getSectionTableRowCount(browser, tableXpath);
				outerloop: for (int i = 1; i <= rowCount; i++) {
					String allTdTagsXpath = tableXpath + "//tr[" + i + "]/td";
					WebElement[] allTdTags = browser.findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
					for (int j = 0; j < allTdTags.length; j++) {
						int k = j;
						if (j % 2 == 0) {
							String childElementsXpath = allTdTagsXpath + "[" + (j + 1) + "]/*";
							WebElement[] allChilds = browser.findChildren(WebElement.class,
									new WebElementDescription.Builder().xpath(childElementsXpath).build());
							if (allChilds.length != 0) {
								for (int l = 0; l < allChilds.length; l++) {
									String tagName = allChilds[l].getTagName();
									if (tagName.equalsIgnoreCase("label")) {
										String labelXpath = allTdTagsXpath + "[" + (j + 1) + "]//label";
										WebElement label = browser.describe(WebElement.class,
												new WebElementDescription.Builder().xpath(labelXpath).build());
										String labelName = label.getInnerText();
										if (labelName.equalsIgnoreCase(fieldName)) {
											String fieldValueXpath = allTdTagsXpath + "[" + (j + 2) + "]//input";
											WebElement inputDateText = browser.describe(WebElement.class,
													new XPathDescription(fieldValueXpath));
											inputDateText.click();
											fnStatus = datePicker(browser, datePickerTable,
													dateConversion(inputDate, "FullMonth/dd/yyyy"));
											if (fnStatus == true) {
												System.out.println("Selected " + fieldName + ", as : " + inputDate
														+ " successfully.");
												selectingDateBasedOnLabel = true;
												break outerloop;
											} else {
												System.out.println("Failed to select inputDate as " + inputDate);
												selectingDateBasedOnLabel = false;
											}
										} else {
											continue;
										}

									}
								}

							} else {
								String tdXpath = allTdTagsXpath + "[" + (j + 1) + "]";
								String tdTagText = (browser
										.describe(WebElement.class,
												new WebElementDescription.Builder().xpath(tdXpath).build())
										.getInnerText());
								if (tdTagText.equalsIgnoreCase(fieldName)) {
									String fieldValueXpath = allTdTagsXpath + "[" + (j + 2) + "]//input";
									WebElement inputDateText = browser.describe(WebElement.class,
											new XPathDescription(fieldValueXpath));
									inputDateText.click();
									fnStatus = datePicker(browser, datePickerTable,
											dateConversion(inputDate, "FullMonth/dd/yyyy"));
									if (fnStatus == true) {
										System.out.println(
												"Selected " + fieldName + ", as : " + inputDate + " successfully.");
										selectingDateBasedOnLabel = true;
										break outerloop;
									} else {
										System.out.println("Failed to select inputDate as " + inputDate);
										selectingDateBasedOnLabel = false;
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
				System.out.println("Section with Xpath : " + sectionXpath + ", doesn't exist.");
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return selectingDateBasedOnLabel;

	}

	/***
	 * getActiveScreenBrowser
	 */

	public static Browser createActiveScreenBrowser() {
		try {
			String path = System.getProperty("user.dir");
			File f = new File(path + "\\appData.properties");
			FileReader fr = new FileReader(f);
			Properties prObj = new Properties();
			prObj.load(fr);
			BrowserDescription br = new BrowserDescription();
			Browser[] b = BrowserFactory.getAllOpenBrowsers(br);
			for (int i = 0; i < b.length; i++) {
				String openBrowserTitle = b[i].getTitle();
				if (openBrowserTitle.equals(prObj.getProperty("activeScreenTitle"))) {
					browser = b[i];
					browser.highlight();
					break;
				} else {
					continue;
				}
			}
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return browser;

	}

	/***
	 * setActiveScreenTitleInConfigFile
	 */

	public static void setActiveScreenTitleInConfigFile(String activeScreenTitle) {
		try {
			String path = System.getProperty("user.dir");
			File f = new File(path + "\\appData.properties");
			OutputStream oStream = new FileOutputStream(f);
			FileReader fr = new FileReader(f);
			Properties prObj = new Properties();
			prObj.load(fr);

			prObj.setProperty("activeScreenTitle", activeScreenTitle);
			prObj.store(oStream, "");

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

	}

	/***
	 * #FunctionName : getPrimaryKeyRowID
	 * 
	 * @param browser
	 * @param tableXpath
	 * @param primaryKeyValue
	 * @param primaryKeyHeader
	 * @Description Function to get primary key row ID based on primary key
	 *              header and primary key value passed as inputs by user..
	 * 
	 * @return int
	 * @author DurgaSivaramprasad
	 * @Developed on : 20/09/2017
	 */

	public static int getPrimaryKeyRowID(Browser browser, String tableXpath, String primaryKeyValue,
			String primaryKeyHeader) {
		int primaryKeyRowID = 0;
		String primaryKeyValueCompare = null;
		List<String> headerList = new ArrayList<String>();
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = fngetTableRowCount(browser, tableXpath);
				headerList = getHeadersFromTable(browser, tableXpath);
				int headerCount = headerList.size();
				// looping on column headers
				for (int i = 0; i <= headerCount - 1; i++) {
					int h = i + 1;
					String headerXpath = tableXpath + "//tr[1]//th[" + h + "]";
					String headertext = (browser.describe(WebElement.class,
							new WebElementDescription.Builder().xpath(headerXpath).build())).getInnerText();
					/*
					 * String headertext =
					 * driver.findElement(By.xpath(headerXpath)).getText();
					 */
					if (headertext.equalsIgnoreCase(primaryKeyHeader)) {

						// looping on rows to find primary key value..
						outerloop: for (int j = 1; j <= rowCount - 1; j++) {
							int k = j + 1;

							String rowelementsXpath = tableXpath + "//tr[" + k + "]/*";
							WebElement[] rowelements = browser.findChildren(WebElement.class,
									new XPathDescription(rowelementsXpath));

							/*
							 * List<WebElement> rowelements =
							 * driver.findElements(By.xpath(rowelementsXpath));
							 */
							for (WebElement child : rowelements) {
								String childTagType = child.getTagName();
								//
								String tagChildXpath = tableXpath + "//tr[" + k + "]/" + childTagType + "/*";
								WebElement[] tagChildList = browser.findChildren(WebElement.class,
										new XPathDescription(tagChildXpath));

								/*
								 * List<WebElement> tagChildList =
								 * driver.findElements(By.xpath(tagChildXpath));
								 */
								if (tagChildList.length != 0) {
									for (WebElement tagChild : tagChildList) {
										String tagChildTagType = tagChild.getTagName();
										if (tagChildTagType.equalsIgnoreCase("a")) {
											primaryKeyValueCompare = tagChild.getInnerText();
											if (primaryKeyValueCompare.equalsIgnoreCase(primaryKeyValue)) {
												primaryKeyRowID = k;
												break outerloop;
											} else {
												continue;
											}

										} else {
											continue;
										}

									}

								} else {
									String tagXpath = tableXpath + "//tr[" + k + "]/" + childTagType;
									primaryKeyValueCompare = (browser.describe(WebElement.class,
											new XPathDescription(tagXpath))).getInnerText();
									/*
									 * primaryKeyValueCompare =
									 * driver.findElement(By.xpath(tagXpath)).
									 * getText();
									 */
									if (primaryKeyValueCompare.equalsIgnoreCase(primaryKeyValue)) {
										primaryKeyRowID = k;
										break outerloop;
									} else {
										continue;
									}
								}
							}
						}
					} else {
						continue;
					}
				}

			} else {
				System.out.println(tableXpath + "related table is not available");
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return primaryKeyRowID;
	}

	/***
	 * @FunctionName : getColumnValueFromTable
	 * @param browser
	 * @param tableXpath
	 * @param primaryKey
	 * @param primaryHeader
	 * @param columnHeader
	 * @return String
	 * @Functions called : getPrimaryKeyRowID()
	 * @Description : Function to get value of a column header from a table
	 *              based on primary key, primary key header and the column
	 *              header
	 * @author DurgaSivaramprasad
	 * @Developed on : 20/09/2017
	 */
	/*
	 * public static String getColumnValueFromTable(Browser browser, String
	 * tableXpath, String primaryKey, String primaryHeader, String columnHeader)
	 * { String columnValue = null; int exactRowID = 0; List<String> headerList
	 * = new ArrayList<String>(); try { exactRowID = getPrimaryKeyRowID(browser,
	 * tableXpath, primaryKey, primaryHeader); headerList =
	 * getHeadersFromTable(browser, tableXpath); int headerCount =
	 * headerList.size(); outerloop: for (int i = 0; i <= headerCount - 1; i++)
	 * { int h = i + 1;
	 * 
	 * String headerXpath = tableXpath + "//tr[1]//th[" + h + "]"; String
	 * headertext = (browser.describe(WebElement.class, new
	 * XPathDescription(headerXpath))).getInnerText();
	 * 
	 * String headertext = driver.findElement(By.xpath(headerXpath)).getText();
	 * if (headertext.equalsIgnoreCase(columnHeader)) { String rowelementsXpath
	 * = tableXpath + "//tr[" + exactRowID + "]/*"; WebElement[] rowelements =
	 * browser.findChildren(WebElement.class, new
	 * WebElementDescription.Builder().xpath(rowelementsXpath).build());
	 * 
	 * List<WebElement> rowelements =
	 * browser.findElements(By.xpath(rowelementsXpath)); for (int l = 0; l <=
	 * rowelements.length - 1; l++) { int exactColumnIndex = l + 1;
	 * 
	 * if (exactColumnIndex == h) { Link[] atags=
	 * rowelements[l].findChildren(Link.class, new
	 * LinkDescription.Builder().build() ); if(atags.length!=0) { for(Link aTag
	 * : atags) { columnValue = aTag.getInnerText(); break outerloop; } } else {
	 * columnValue = rowelements[l].getInnerText(); break outerloop; }
	 * 
	 * 
	 * 
	 * } else { continue; } }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } catch (Throwable t) { System.out.println("Exception is :" +
	 * t.getMessage()); } return columnValue;
	 * 
	 * }
	 * 
	 */

	/*
	 * #FunctionName : gettingBusinessDays # No of Parameter : 1 # Description :
	 * Function to getting business days excluding weekends(Saturday & Sunday) #
	 * Parameters and its data-type : int days # Developed on : 19/09/2017
	 * Developed By : Rajesh # Return type : String
	 * #########################################################################
	 * ###########
	 */

	public static String gettingRequiredBusinessDayDateInprogress(int days) {

		java.util.Date date = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		date = calendar.getTime();
		SimpleDateFormat s = new SimpleDateFormat("M/dd/yyyy");
		System.out.println(s.format(date));
		for (int i = 0; i < days;) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);

			if (calendar.get(Calendar.DAY_OF_WEEK) <= 5) {
				i++;
			}

		}
		date = calendar.getTime();
		String businessDays = s.format(date);

		System.out.println(businessDays);
		return businessDays;
	}

	/***
	 * @FunctionName : getColumnValueFromTable
	 * @param browser
	 * @param tableXpath
	 * @param primaryKey
	 * @param primaryHeader
	 * @param columnHeader
	 * @return String
	 * @Functions called : getPrimaryKeyRowID()
	 * @Description : Function to get value of a column header from a table
	 *              based on primary key, primary key header and the column
	 *              header
	 * @author DurgaSivaramprasad
	 * @Developed on : 20/09/2017
	 */
	public static String getColumnValueFromTable(Browser browser, String tableXpath, String primaryKey,
			String primaryHeader, String columnHeader) {
		String columnValue = null;
		int exactRowID = 0;
		List<String> headerList = new ArrayList<String>();
		try {
			exactRowID = getPrimaryKeyRowID(browser, tableXpath, primaryKey, primaryHeader);
			headerList = getHeadersFromTable(browser, tableXpath);
			int headerCount = headerList.size();
			outerloop: for (int i = 0; i <= headerCount - 1; i++) {
				int h = i + 1;

				String headerXpath = tableXpath + "//tr[1]//th[" + h + "]";
				String headertext = (browser.describe(WebElement.class, new XPathDescription(headerXpath)))
						.getInnerText();

				/*
				 * String headertext =
				 * driver.findElement(By.xpath(headerXpath)).getText();
				 */
				if (headertext.equalsIgnoreCase(columnHeader)) {
					String rowelementsXpath = tableXpath + "//tr[" + exactRowID + "]/*";
					WebElement[] rowelements = browser.findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(rowelementsXpath).build());

					/*
					 * List<WebElement> rowelements =
					 * browser.findElements(By.xpath(rowelementsXpath));
					 */
					for (int l = 0; l <= rowelements.length - 1; l++) {
						int exactColumnIndex = l + 1;

						if (exactColumnIndex == h) {
							Link[] atags = rowelements[l].findChildren(Link.class,
									new LinkDescription.Builder().build());
							Image[] imgTags = rowelements[l].findChildren(Image.class,
									new ImageDescription.Builder().build());
							if (atags.length != 0) {
								for (Link aTag : atags) {
									columnValue = aTag.getInnerText();
									break outerloop;
								}
							} else if (imgTags.length != 0) {
								for (Image imgTag : imgTags) {
									columnValue = imgTag.getTitle();
									break outerloop;
								}
							} else {
								columnValue = rowelements[l].getInnerText();
								break outerloop;
							}
						} else {
							continue;
						}
					}

				}

			}

		} catch (Throwable t) {
			System.out.println("Exception is :" + t.getMessage());
		}
		return columnValue;

	}

	/*
	 * public class RandomNoGeneration { public static int generatedNo; public
	 * static String configFilepath =
	 * System.getProperty("user.dir")+"\\config.properties"; public static int
	 * policyIdValue ;
	 */
	public static int generatedNo;
	public static String configFilepath = System.getProperty("user.dir") + "\\config.properties";
	public static int policyIdValue;

	// Today's task---23/9...
	// Function to check the availability of pop up window and then get text
	// message of pop up window.
	public static String getTextOfPopUp(Browser browser, String popUpWindowTitle, String inputMessage)
			throws GeneralLeanFtException {

		boolean getTextOfPopUp = false;
		String msgText = null;
		try {
			Dialog popupWndw = browser.describe(Dialog.class,
					new DialogDescription.Builder().windowTitleRegExp("Message from webpage").index(0).build());
			if (popupWndw.exists()) {
				popupWndw.highlight();
				System.out.println("Pop up window with title : " + popUpWindowTitle + " is available as expected.");
				getTextOfPopUp = true;
				Static textObj = popupWndw.describe(Static.class,
						new StaticDescription.Builder().nativeClass("Static").windowTitleRegExp(inputMessage).build());
				textObj.highlight();
				if (textObj.exists()) {
					msgText = textObj.getText();
				} else {
					System.out.println("Text message Object is not available.");
					getTextOfPopUp = false;
				}
			} else {
				System.out.println("Pop up window with title : " + popUpWindowTitle + " is NOT available.");
				getTextOfPopUp = false;
			}
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

		return msgText;
	}

	// Function to get auto populated of data of textbox based on label..

	/***
	 * @FunctionName: getAutoPopulatedValueOfTextBoxByLabel
	 * @Description:Function to get auto populated data of textbox based on
	 *                       label..
	 * @param browser
	 * @param labelName
	 * @return String
	 * @author N.Durgasivaramprasad
	 */
	public static String getAutoPopulatedValueOfTextBoxByLabel(Browser browser, String labelName) {

		String getAutoText = null;
		WebElement textBox = null;
		try {
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			outerloop: for (int level = 1; level <= 6; level++) {
				String parentXpath = immediateParentXpath;
				String parentLevel = "/..";
				WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if (parentTagName.equalsIgnoreCase("td")) {

					String textBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {
						textBox = browser.describe(WebElement.class, new XPathDescription(textBoxXpath));
						getAutoText = textBox.getAttribute("value");
						break outerloop;

					} else {
						System.out.println("Text box with Xpath : " + textBoxXpath + " is not available.");

					}

				} else if (parentTagName.equalsIgnoreCase("th")) {

					String textBoxXpath = parentXpath + "/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {
						textBox = browser.describe(WebElement.class, new XPathDescription(textBoxXpath));
						getAutoText = textBox.getAttribute("value");
						break outerloop;

					} else {
						System.out.println("Text box with Xpath : " + textBoxXpath + " is not available.");
					}

				} else if (parentTagName.equalsIgnoreCase("div")) {
					String updatedParentXpath = "//label[text()='" + labelName + "']";
					String textBoxXpath = updatedParentXpath + "/following-sibling::div[1]//input"; /// following-sibling::div[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if (fnStatus == true) {

						textBox = browser.describe(WebElement.class, new XPathDescription(textBoxXpath));
						getAutoText = textBox.getAttribute("value");
						break outerloop;

					} else {
						System.out.println("Text box with Xpath : " + textBoxXpath + " is not available.");
					}
				}

				else {
					parentXpath = parentXpath + parentLevel;
				}
			}

		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
		}
		return getAutoText;
	}

	/***
	 * @Function Name: saveGeneratedDataInConfigFile
	 * @Description: Function to get generated IDs from headerText and mapping
	 *               to inputKey and saving in Config.Properties file..
	 * @param browser
	 * @param pageH1HeaderText
	 * @param inputKey
	 * @return boolean
	 * @author N.Durgasivarmprasad
	 */
	public static boolean saveGeneratedDataInConfigFile(Browser browser, String pageH1HeaderText, String inputKey) {
		WebElement element = null;
		String generatedID = null;
		boolean saveGeneratedDataInConfigFile = false;
		try {
			OutputStream output = null;

			File file = new File(configFilepath);
			FileReader frReader = new FileReader(file);
			Properties prop = new Properties();
			prop.load(frReader);
			String h1HdrXpath = "//h1[@class='pageType' and text()='" + pageH1HeaderText + "']";
			boolean fnStatus = isElementExist(browser, h1HdrXpath);
			if (fnStatus == true) {
				String h2Xpath = "//h1[@class='pageType' and text()='" + pageH1HeaderText + "']/following-sibling::h2";
				fnStatus = isElementExist(browser, h2Xpath);
				if (fnStatus == true) {
					element = browser.describe(WebElement.class, new XPathDescription(h2Xpath));
					generatedID = (element.getInnerText()).trim();
					output = new FileOutputStream(file);
					prop.setProperty(inputKey, generatedID);
					prop.store(output, "");
					String crossCheck = prop.getProperty(inputKey);
					if (crossCheck.equals(generatedID)) {
						saveGeneratedDataInConfigFile = true;
					} else {
						System.out.println(
								"Failed to save the " + inputKey + " key, as : " + generatedID + " in config file");
						saveGeneratedDataInConfigFile = false;
					}

				} else {
					System.out.println("H2 header text object with Xpath: " + h2Xpath + " is not available.");
					saveGeneratedDataInConfigFile = false;
				}

			} else {
				System.out.println("H1 header text object with Xpath: " + h1HdrXpath + " is not available.");
				saveGeneratedDataInConfigFile = false;
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
			saveGeneratedDataInConfigFile = false;
		}

		return saveGeneratedDataInConfigFile;
	}

	/***
	 * @Function Name : navigationBasedOnH2HeaderText
	 * @Description : Function to check navigation to a page based on H2 header
	 *              text..
	 * @param browser
	 * @param h2HeaderText
	 * @author N.Durgasivaramprasad
	 */
	public static boolean navigationBasedOnH2HeaderText(Browser browser, String h2HeaderText) {
		boolean navigationBasedOnH2HeaderText = false;
		try {
			String h2HeaderXpath = "//h2[@class='pageDescription']";
			WebElement h2Object = browser.describe(WebElement.class, new XPathDescription(h2HeaderXpath));
			h2Object.highlight();
			String h2Text = (h2Object.getInnerText()).trim();
			boolean fnstatus = h2Text.equalsIgnoreCase(h2HeaderText);

			GenericClass.reportlogger(fnstatus, tTestCaseName, "Navigated to :" + h2HeaderText + "page ");

		} catch (Throwable t) {
			GenericClass.Catchhandler("The Exception for navigationBasedOnH2HeaderText is :", t);
		}
		return navigationBasedOnH2HeaderText;
	}

	/***
	 * @Function Name:clickShowMoreOrGoToListLinkOfSection
	 * @Description : Function to click 'Show More' button Or 'Go to List' links
	 *              of sections..
	 * @param browser
	 * @param sectionName
	 * @param linkName
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean clickShowMoreOrGoToListLinkOfSection(Browser browser, String sectionName,
			String linkName/* Show/Go to List */) {
		boolean clickShowMoreOrGoToListLinkOfSection = false;
		try {
			boolean fnStatus = false;
			String linkXpath = "//h3[text()='"
					+ sectionName/* Policy Relationships */
					+ "']/ancestor::div[1]/following-sibling::div[1]/child::div[1]//a[text()[contains(.,'"
					+ linkName /* Show */ + "')]]";
			fnStatus = isElementExist(browser, linkXpath);
			if (fnStatus == true) {
				WebElement linkObj = browser.describe(WebElement.class, new XPathDescription(linkXpath));
				linkObj.click();
				clickShowMoreOrGoToListLinkOfSection = true;
			} else {
				clickShowMoreOrGoToListLinkOfSection = false;
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return clickShowMoreOrGoToListLinkOfSection;

	}

	/***
	 * @Function checkShowMoreOrGoToListLink
	 * @Description : Function to check availability of 'Show More' button Or
	 *              'Go to List' links of sections..
	 * @param browser
	 * @param sectionName
	 * @param linkName
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean checkShowMoreOrGoToListLink(Browser browser, String sectionName,
			String linkName/* Show/Go to List */) {
		boolean checkShowMoreOrGoToListLink = false;
		try {
			boolean fnStatus = false;
			String linkXpath = "//h3[text()='"
					+ sectionName/* Policy Relationships */
					+ "']/ancestor::div[1]/following-sibling::div[1]/child::div[1]//a[text()[contains(.,'"
					+ linkName /* Show */ + "')]]";
			WebElement linkObj = browser.describe(WebElement.class, new XPathDescription(linkXpath));
			fnStatus = linkObj.exists();
			if (fnStatus == false) {
				System.out.println("Show more link is not available..");
				checkShowMoreOrGoToListLink = false;
			} else {
				while ((linkObj.exists()) == true) {

					if (fnStatus == true) {
						checkShowMoreOrGoToListLink = true;
						break;
					} else {
						checkShowMoreOrGoToListLink = false;
					}
				}
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return checkShowMoreOrGoToListLink;

	}

	/***
	 * Function: clickingLinkOfSection
	 * 
	 * @Description: Function to click on inputValue link of a table of the
	 *               passed section Xpath...
	 * @param browser
	 * @param sectionXpath
	 * @param inputValue
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean clickingLinkOfSection(Browser browser, String sectionXpath, String inputValue) {
		boolean clickingLinkOfSection = false;
		try {
			boolean fnStatus = false;
			String tableXpath = sectionXpath.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {
					String aTagXpath = tableXpath.concat("//th/a");
					Link[] aTags = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXpath).build());

					for (Link cell : aTags) {
						System.out.println(cell.getInnerText());
						if (cell.getInnerText().equals(inputValue)) {

							cell.click();
							clickingLinkOfSection = true;
							break outerloop;
						} else {
							continue;
						}
					}
				}

				clickingLinkOfSection = true;
			} else {
				/*
				 * System.out.println(
				 * "Policy Relationship dynamic table is not available");
				 */

				clickingLinkOfSection = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for clickingLinkOfPolicyRelationship is : " + t.getMessage());

			clickingLinkOfSection = false;
		}
		return clickingLinkOfSection;

	}

	/***
	 * @Function : generateLastName
	 * @Description : Function to generate last name by including system_Date
	 *              and input lastname..
	 * @param browser
	 * @param lastName
	 * @return
	 * @author N.Durgasivaramprasad
	 */
	public static String generateLastName(Browser browser, String lastName) {
		String generatedLastName = null;
		try {
			Calendar cal = Calendar.getInstance();
			Date dt = cal.getTime();
			String[] dateArray = (dt.toString()).split(" ");
			String date = dateArray[2];
			String Month = dateArray[1];
			String year = dateArray[5];
			String time = dateArray[3];
			generatedLastName = lastName + "_" + date + "-" + Month + "-" + year + "_" + time;
			System.out.println(generatedLastName);

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

		return generatedLastName;
	}

	/***
	 * @Function : concatenateFirstAndLastName Description :Function to
	 *           concatenate firstName and generated last name.
	 * @param browser
	 * @param firstName
	 * @param lastName
	 * @return String
	 * @author N.Durgasivaramprasad
	 */
	public static String concatenateFirstAndLastName(Browser browser, String firstName, String lastName) {
		/* String generatedLastName = null; */
		String updatedName = null;
		try {
			/* generatedLastName = generateLastName(browser, lastName); */
			updatedName = firstName + " " + lastName;

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

		return updatedName;
	}

	///////////////////////////////// 25092017/////////////////////////

	/*
	 * #FunctionName : orderOfColumnHeaderOfSection # No of Parameter : 4 #
	 * Description : Function to check if the order of Column headers in any
	 * section is same as that of order of column headers which are being passes
	 * as inputs.. # Parameters and its data-type : String testName, Browser
	 * browser, String allInputColumnHeaders, String tableXpath # Developed on :
	 * 25/09/2017 # Developed By : Rajesh & Durga# Return type : boolean # Note
	 * : All Column headers needs to be separated by Comma(,).
	 * #########################################################################
	 * ###########
	 */

	public static boolean orderOfColumnHeaderOfSection(Browser browser, String allInputColumnHeaders,
			String tableXpath) {
		boolean orderOfColumnHeaderOfSection = false;
		try {
			String[] allInputColumnHeadersArray = allInputColumnHeaders.split(",");
			List<String> allSourceColumnHeadersList = new ArrayList<String>();
			List<String> allInputColumnHeadersList = Arrays.asList(allInputColumnHeadersArray);
			allSourceColumnHeadersList = getHeadersFromTable(browser, tableXpath);
			for (int i = 0; i <= allSourceColumnHeadersList.size() - 1; i++) {
				for (int j = 0; j <= allInputColumnHeadersList.size() - 1; j++) {
					if (allSourceColumnHeadersList.get(i).equals(allInputColumnHeadersList.get(j))) {
						if (i == j) {
							System.out.println(allSourceColumnHeadersList.get(i)
									+ ", column header is having the same order as expected i.e.;" + (i + 1) + " and :"
									+ (j + 1));

						} else {
							continue;
						}

					} else {
						continue;
					}

				}
			}
			orderOfColumnHeaderOfSection = true;
		} catch (Throwable t) {
			System.out.println("The Exception for orderOfColumnHeaderOfSection is : " + t.getMessage());
			utility.fnLogging("The Exception for orderOfColumnHeaderOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for orderOfColumnHeaderOfSection is : " + t.getMessage());
			softAssert.fail("The Exception for orderOfColumnHeaderOfSection is : " + t.getMessage());
			orderOfColumnHeaderOfSection = false;
		}
		return orderOfColumnHeaderOfSection;
	}

	// Todays task --25092017

	/***
	 * Function : checkRequiredFieldAvailabilityBasedOnLabel Description :
	 * Function to check required fields availability of section based on
	 * label..
	 * 
	 * @param browser
	 * @param labelName
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean checkRequiredFieldAvailabilityBasedOnLabel(Browser browser, String labelName) {
		boolean checkRequiredFieldAvailabilityBasedOnLabel = false;

		try {
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			WebElement fieldObject = browser.describe(WebElement.class, new XPathDescription(immediateParentXpath));
			fieldObject.highlight();
			if (fieldObject.exists()) {
				String objClass = fieldObject.getClassName();
				if (objClass.equals("labelCol requiredInput")) {

					ReportEvent.testStepReport(tTestCaseName, "pass", labelName + ":  field is marked as required.");
					// System.out.println(labelName + ": field is marked as
					// required.");
					checkRequiredFieldAvailabilityBasedOnLabel = true;
				} else {
					ReportEvent.testStepReport(tTestCaseName, "pass",
							labelName + ":  field is NOT marked as required.");
					// System.out.println(labelName + ": field is NOT marked as
					// required.");
					checkRequiredFieldAvailabilityBasedOnLabel = false;
				}
			} else {
				ReportEvent.testStepReport(tTestCaseName, "pass", "Field :" + labelName + " is not available.");
				// System.out.println("Field :"+labelName+" is not available.");
				checkRequiredFieldAvailabilityBasedOnLabel = false;
			}
		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());

		}
		return checkRequiredFieldAvailabilityBasedOnLabel;
	}

	/***
	 * Function: getGeneratedIdFromH2Header Description : Function to get the
	 * generated Id's from H2 header Text of page..
	 * 
	 * @param browser
	 * @return String
	 * @author N.Durgasivaramprasad
	 */
	public static String getGeneratedIdFromH2Header(Browser browser) {
		String generatedId = null;
		try {
			String H2HeaderXpath = "//h2[@class='pageDescription']";
			WebElement h2Obj = browser.describe(WebElement.class, new XPathDescription(H2HeaderXpath));
			generatedId = (h2Obj.getInnerText()).trim();
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return generatedId;
	}

	public static void Date() {
		LocalDate start = null, starttrmp, capturedDate;
		// Input****************
		start = LocalDate.of(2017, 9, 22);
		int dys = 2;
		// ********************
		int count = 0, wknd = 0;
		int j = 1, i, dys_temp = 1;
		int sat = 0, sun = 0, flag = 1;

		dys_temp = dys;
		start = start.plusDays(1);
		final DayOfWeek startWeekDay = start.getDayOfWeek();
		DayOfWeek temp = startWeekDay;

		for (i = 1; i <= dys_temp + 1; i++) {
			if ((temp.name().equals("SATURDAY")) || (temp.name().equals("SUNDAY"))) {
				switch (temp.name()) {
				case "SATURDAY":
					sat = sat + 1;
					flag = 0;
					break;
				case "SUNDAY":
					sun = sun + 1;
					flag = 0;
					break;
				}
			}
			temp = temp.plus(1);
			count = count + 1;
		}

		starttrmp = start.plusDays((dys + sat + sun - 1));
		capturedDate = start.plusDays((dys + sat + sun - 1));
		final DayOfWeek startWeekDay1 = starttrmp.getDayOfWeek();
		DayOfWeek temp1 = startWeekDay;

		if ((temp.name().equals("SATURDAY"))) {
			capturedDate = capturedDate.plusDays((2));
		} else if ((temp.name().equals("SUNDAY"))) {
			capturedDate = capturedDate.plusDays((1));
		}

		System.out.println("Total weekend found : saturday's - " + sat + " sunday's - " + sun);
		System.out.println("Due date captured : " + capturedDate);

	}

	/***
	 * Function : checkFieldAvailabilityBasedOnLabel Description : Function to
	 * check fields availability of section based on label..
	 * 
	 * @param browser
	 * @param labelName
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean checkFieldAvailabilityBasedOnLabel(Browser browser, String labelName) {
		boolean checkFieldAvailabilityBasedOnLabel = false;

		try {
			String immediateParentXpath = "//label[text()[contains(.,'" + labelName + "')]]/..";
			WebElement fieldObject = browser.describe(WebElement.class, new XPathDescription(immediateParentXpath));
			if (fieldObject.exists()) {
				ReportEvent.testStepReport(tTestCaseName, "pass", labelName + ":  field is available as expected.");
				checkFieldAvailabilityBasedOnLabel = true;

			} else {
				ReportEvent.testStepReport(tTestCaseName, "pass", "Field :" + labelName + " is not available.");
				// System.out.println("Field :"+labelName+" is not available.");
				checkFieldAvailabilityBasedOnLabel = false;
			}
		} catch (Throwable t) {
			System.out.println("Exception message is : " + t.getMessage());
			checkFieldAvailabilityBasedOnLabel = false;
		}
		return checkFieldAvailabilityBasedOnLabel;
	}

	/***
	 * Function: checkColumnValueAvailabilityOfSection
	 * 
	 * @Description: Function to check availability of inputValue link of a
	 *               table of the passed section Xpath...
	 * @param browser
	 * @param sectionXpath
	 * @param inputValue
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean checkColumnValueAvailabilityOfSection(Browser browser, String sectionXpath,
			String inputValue) {
		boolean clickingLinkOfSection = false;
		try {
			boolean fnStatus = false;
			String tableXpath = sectionXpath.concat("//div[@class='pbBody']//table");
			fnStatus = isElementExist(browser, tableXpath);
			if (fnStatus == true) {
				int rowCount = fngetTableRowCount(browser, tableXpath);
				outerloop: for (int i = 2; i <= rowCount; i++) {
					String aTagXpath = tableXpath.concat("//th/a");
					Link[] aTags = browser.findChildren(Link.class,
							new LinkDescription.Builder().xpath(aTagXpath).build());

					for (Link cell : aTags) {
						System.out.println(cell.getInnerText());
						if (cell.getInnerText().equals(inputValue)) {
							cell.highlight();
							clickingLinkOfSection = true;
							break outerloop;
						} else {
							continue;
						}
					}
				}

				clickingLinkOfSection = true;
			} else {
				/*
				 * System.out.println(
				 * "Policy Relationship dynamic table is not available");
				 */

				clickingLinkOfSection = false;
			}
		} catch (Throwable t) {
			System.out.println("The Exception for checkColumnValueAvailabilityOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for checkColumnValueAvailabilityOfSection is : " + t.getMessage());

			clickingLinkOfSection = false;
		}
		return clickingLinkOfSection;

	}

	// Function to get child objects of Iframe window..

	public static boolean switchToIFrameBasedOnTitle1(Browser browser, String iFrameTitle) {
		boolean switchToIFrameBasedOnTitle = false;
		try {
			InternalFrame iframeObj = browser.describe(InternalFrame.class,
					new InternalFrameDescription.Builder().title(iFrameTitle).build());
			if (iframeObj.exists()) {
				iframeObj.highlight();
				iframeObj.activate();
				System.out.println("Switched To iframe");
				switchToIFrameBasedOnTitle = true;
			} else {
				switchToIFrameBasedOnTitle = false;
			}

		} catch (Throwable t) {
			switchToIFrameBasedOnTitle = false;
		}
		return switchToIFrameBasedOnTitle;
	}

	/***
	 * Function : createFrameObject Description : Function to switch to iframe
	 * based on iframeTitle.
	 * 
	 * @param browser
	 * @param iFrameTitle
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */

	public static Frame createFrameObject(Browser browser, String frameTitle,
			String frameTag/* IFRAME/FRAME */, String frameID) {

		Frame requiredFrameObj = null;
		String title = null, id = null;
		try {

			Frame[] frameObjArray = browser.findChildren(Frame.class, new FrameDescription.Builder().build());
			for (Frame frameObj : frameObjArray) {
				String tagName = frameObj.getTagName();
				// switch to iframe..
				if (tagName.equalsIgnoreCase("IFRAME")) {
					title = frameObj.getTitle();
					if (title.isEmpty()) {
						id = frameObj.getId();
						if (id.equalsIgnoreCase(frameID)) {
							frameObj.highlight();
							requiredFrameObj = frameObj;
							break;
						} else {
							System.out.println("IFrame is not having Title OR ID.");
						}
					} else {
						if (title.equalsIgnoreCase(frameTitle)) {
							frameObj.highlight();
							requiredFrameObj = frameObj;
							break;
						} else {
							continue;
						}
					}

				}
				// Switching to normal Frame.
				else {
					title = frameObj.getTitle();
					if (title.isEmpty()) {
						id = frameObj.getId();
						if (id.equalsIgnoreCase(frameID)) {
							frameObj.highlight();
							requiredFrameObj = frameObj;
							break;
						} else {
							System.out.println("Frame is not having Title OR ID.");
						}
					} else {
						if (title.equalsIgnoreCase(frameTitle)) {
							frameObj.highlight();
							requiredFrameObj = frameObj;
							break;
						} else {
							continue;
						}
					}
				}

			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return requiredFrameObj;
	}

	// Function to click button in a frame which is not embedded in any table..

	public static boolean clickButtonInFrame(Browser browser, String frameTitle,
			String frameTag/* IFRAME/FRAME */, String frameID, String buttonName) {
		boolean clickButtonInFrame = false;
		boolean btnAvailable = false;
		Frame frameObj = null;
		try {
			frameObj = createFrameObject(browser, frameTitle, frameTag, frameID);
			Button[] buttonsArray = frameObj.findChildren(Button.class,
					new ButtonDescription.Builder().buttonType("button").tagName("INPUT").build());
			for (Button btn : buttonsArray) {
				String btnName = btn.getName();
				if (btnName.equalsIgnoreCase(buttonName)) {
					btn.highlight();
					btn.click();
					btnAvailable = true;
					break;
				} else {
					continue;
				}
			}
			if (btnAvailable == true) {
				clickButtonInFrame = true;
			} else {
				clickButtonInFrame = false;
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return clickButtonInFrame;

	}

	// Function to click button in a frame which is Embedded in a table..

	public static boolean clickButtonEmbeddedInTableOFFrame(Browser browser, String frameTitle,
			String frameTag/* IFRAME/FRAME */, String frameID, String buttonName, String tableInnerText) {
		boolean clickButtonInFrame = false;
		Frame frameObj = null;
		try {
			frameObj = createFrameObject(browser, frameTitle, frameTag, frameID);
			Table tableObj = null;
			Table[] tblArray = frameObj.findChildren(Table.class, new TableDescription.Builder()
					./* innerText(tableInnerText). */build());
			for (Table tbl : tblArray) {
				String tblInnerText = tbl.getInnerText();
				if (tblInnerText.equalsIgnoreCase(tableInnerText)) {
					tableObj = tbl;
					break;

				} else {
					continue;
				}

			}
			tableObj.highlight();
			Link[] linkTagArray = tableObj.findChildren(Link.class, new LinkDescription.Builder().build());
			Link lnkObject = null;
			for (Link lnkObj : linkTagArray) {
				String lnkTagName = lnkObj.getTagName();
				if (lnkTagName.equalsIgnoreCase("A")) {
					lnkObj.highlight();
					lnkObject = lnkObj;
					break;
				}

			}

			Button[] bArray = lnkObject.findChildren(Button.class, new ButtonDescription.Builder().build());

			for (Button b : bArray) {
				if ((b.getInnerText()).equalsIgnoreCase(buttonName)) {
					b.highlight();
				} else {
					continue;
				}

			}

			Button[] buttonsArray = lnkObject.findChildren(Button.class, new ButtonDescription.Builder().build());
			for (Button btn : buttonsArray) {
				String btnName = btn.getInnerText();
				if (btnName.equalsIgnoreCase(buttonName)) {
					btn.highlight();
					btn.click();
					clickButtonInFrame = true;
				} else {
					continue;
				}
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return clickButtonInFrame;

	}

	/*
	 * #FunctionName : getFieldValueOfSection # No of Parameter : 4 #
	 * Description : Function to fetch Value of a field in a section based on
	 * user inputs related to field name/key.. # Parameters and its data-type :
	 * Browser browser,String fieldName, String sectionXpath # Developed on :
	 * 27/09/2017 # Developed By : Durga # Return type : String
	 * #########################################################################
	 * ###########
	 */

	public static String getFieldValueOfSection(Browser browser, String fieldName, String sectionXpath) {
		String fieldValue = null;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionXpath);
			if (fnStatus == true) {
				String tableXpath = sectionXpath.concat("//table");
				int rowCount = getSectionTableRowCount(browser, tableXpath);
				outerloop: for (int j = 1; j <= rowCount; j++) {
					String allTdTagsXpath = tableXpath + "//tr[" + j + "]/td";
					WebElement[] rowTdElements = browser.findChildren(WebElement.class,
							new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
					int tdElementCount = rowTdElements.length;
					for (int k = 0; k <= tdElementCount - 1; k++) {
						int h = k;

						if (k % 2 == 0) {
							String tdChildElementsXpath = allTdTagsXpath + "[" + (k + 1) + "]/*";
							WebElement[] tdChilds = browser.findChildren(WebElement.class,
									new XPathDescription(tdChildElementsXpath));

							if (tdChilds.length != 0) {
								for (int i = 0; i < tdChilds.length; i++) {
									String tagName = tdChilds[i].getTagName();
									if (tagName.equals("SPAN")) {
										String tdElementText = tdChilds[i].getInnerText();

										if (tdElementText.equalsIgnoreCase(fieldName)
												|| tdElementText.equalsIgnoreCase(fieldName)) {
											h++;

											String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]" + "/*";
											WebElement[] tdChildElements = browser.findChildren(WebElement.class,
													new WebElementDescription.Builder().xpath(tdChildtagsXpath)
															.build());
											int tdchildCount = tdChildElements.length;

											if (tdchildCount > 1) {
												for (int m = 0; m > tdchildCount; m++) {
													String tdChildTagName = tdChildElements[m].getTagName();
													if (tdChildTagName.equalsIgnoreCase("a")) {
														fieldValue = tdChildElements[m].getInnerText();
														System.out.println(fieldValue);
														break outerloop;
													} else {
														continue;
													}
												}
											} else {
												fieldValue = rowTdElements[h].getInnerText();

												System.out.println(fieldValue);
												break outerloop;
											}

										} else {
											continue;
										}
									} else {
										continue;
									}
								}
							} else {

								String tdElementText = rowTdElements[k].getInnerText();
								if (tdElementText.equals(fieldName)) {
									h++;
									// Checking for child tags..
									String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]" + "/*";
									WebElement[] tdChildElements = browser.findChildren(WebElement.class,
											new WebElementDescription.Builder().xpath(tdChildtagsXpath).build());
									int tdchildCount = tdChildElements.length;

									if (tdchildCount > 1) {
										for (int m = 0; m > tdchildCount; m++) {
											String tdChildTagName = tdChildElements[m].getTagName();
											if (tdChildTagName.equalsIgnoreCase("a")) {
												fieldValue = tdChildElements[m].getInnerText();
												System.out.println(fieldValue);
												break outerloop;
											} else {
												continue;
											}
										}
									} else {
										fieldValue = rowTdElements[h].getInnerText();
										System.out.println(fieldValue);
										break outerloop;
									}

								} else {
									continue;
								}

							}

						}

						else {
							continue;
						}
					}
				}
			} else {
				System.out.println("Section is not available!!");
				ReportEvent.testStepReport("", "fail", sectionXpath + "Section is not available");
				// softAssert.fail(sectionXpath + "Section is not available");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for getFieldValueOfSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getFieldValueOfSection is : " + t.getMessage());
		}
		return fieldValue;
	}

	/*******************/
	public static String getingBusinessDay(Browser browser, String lastModifiedDate, int days) {
		LocalDate start = null, starttrmp, capturedDate;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		String[] strArray = lastModifiedDate.split("/");
		String capturestring = "";
		String businessDays = "";
		int sat = 0, sun = 0, flag = 1;

		if (days > 0) {

			int date = Integer.parseInt(strArray[1]);
			int month = ((Integer.parseInt(strArray[0])));
			int year = Integer.parseInt(strArray[2]);

			LocalDate localDate = LocalDate.of(year, month, date);
			String format = (localDate).format(formatter);
			int count = 0, wknd = 0;
			int j = 1, i, dys_temp = 1;
			sat = 0;
			sun = 0;
			flag = 1;

			dys_temp = days;
			localDate = localDate.plusDays(1);
			final DayOfWeek startWeekDay = localDate.getDayOfWeek();
			DayOfWeek temp = startWeekDay;

			for (i = 1; i <= dys_temp + 1; i++) {
				if ((temp.name().equals("SATURDAY")) || (temp.name().equals("SUNDAY"))) {
					switch (temp.name()) {
					case "SATURDAY":
						sat = sat + 1;
						flag = 0;
						break;
					case "SUNDAY":
						sun = sun + 1;
						flag = 0;
						break;
					}
				}
				temp = temp.plus(1);
				count = count + 1;
			}

			starttrmp = localDate.plusDays((days + sat + sun - 1));
			capturedDate = localDate.plusDays((days + sat + sun - 1));
			final DayOfWeek startWeekDay1 = starttrmp.getDayOfWeek();
			DayOfWeek temp1 = startWeekDay;

			if ((temp.name().equals("SATURDAY"))) {
				capturedDate = capturedDate.plusDays((2));
			} else if ((temp.name().equals("SUNDAY"))) {
				capturedDate = capturedDate.plusDays((1));
			}
			businessDays = formatter.format(capturedDate);
			capturestring = capturedDate.toString();
		} else {
			businessDays = lastModifiedDate;
			sat = 0;
			sun = 0;
		}

		String[] strArray1 = businessDays.split("/");

		if (Integer.parseInt(strArray1[0]) < 9) {
			strArray1[0] = strArray1[0].replace("0", "");
		}

		if (Integer.parseInt(strArray1[1]) < 9) {
			strArray1[1] = strArray1[1].replace("0", "");
		}

		int date1 = Integer.parseInt(strArray1[1]);
		int month1 = ((Integer.parseInt(strArray1[0])));
		int year1 = Integer.parseInt(strArray1[2]);

		String finalstr = strArray1[0] + "/" + strArray1[1] + "/" + strArray1[2];

		System.out.println("Total weekend found : saturday's - " + sat + " sunday's - " + sun);
		System.out.println("Due date captured : " + finalstr);
		return finalstr;
	}

	/***
	 * Function : getAllErrorMessagesOfPage Description : Function to fetch all
	 * the displayed error messages of a page and including in a list..
	 * 
	 * @param browser
	 * @return List.
	 * @author N.Durgasivaramprasad
	 */

	public static List<String> getAllErrorMessagesOfPage(Browser browser) {
		List<String> allErrorMsgs = new ArrayList<String>();
		String errorsXpath = "//div[@class='errorMsg']";
		String pageErrorXpath = "//div[@class='pbError']";

		String tempStrongText = null, tempErrorText = null, exactErrorText = null;
		try {
			// Adding inner text of All labels error messages to list..
			WebElement[] errorsObj = browser.findChildren(WebElement.class, new XPathDescription(errorsXpath));
			int errorsCount = errorsObj.length;
			if (errorsCount != 0) {
				for (int i = 0; i < errorsCount; i++) {
					WebElement strongObj = errorsObj[i].describe(WebElement.class,
							new XPathDescription(errorsXpath.concat("/strong")));
					if (strongObj.exists()) {
						strongObj.highlight();
						tempStrongText = strongObj.getInnerText();
						tempErrorText = errorsObj[i].getInnerText();
						exactErrorText = tempStrongText.concat(tempErrorText);
						allErrorMsgs.add(exactErrorText);
					} else {
						continue;
					}

				}
			} else {
				System.out.println("There is NO Label level Error messages.");
			}
			// Adding innertext of All child elements of Div tag to list.
			WebElement[] pageErrors = browser.findChildren(WebElement.class,
					new XPathDescription(pageErrorXpath.concat("//*")));

			if (pageErrors.length != 0) {
				for (WebElement tag : pageErrors) {
					if (tag.getTagName().equalsIgnoreCase("br")) {
						exactErrorText = tag.getInnerText();
						allErrorMsgs.add(exactErrorText);
					} else {
						exactErrorText = tag.getInnerText();
						allErrorMsgs.add(exactErrorText);
					}
				}
			} else {
				System.out.println("There is NO child tags for Page level Object.");
			}

			// Adding innertext of Div tag to list.
			WebElement pageErrorObj = browser.describe(WebElement.class, new XPathDescription(pageErrorXpath));
			allErrorMsgs.add(pageErrorObj.getInnerText());
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
		return allErrorMsgs;
	}

	public static void sdkConfig(String uri) {
		try {
			ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
			config.setServerAddress(new URI(uri));
			SDK.init(config);
		} catch (Throwable t) {
			ReportEvent.testStepReport("", "Fail", "Exception is " + t.getMessage());
		}

	}

	public static void reportlogger(boolean fnStatus, String testCaseName, String description) {
		if (fnStatus == true) {
			ReportEvent.testStepReport(testCaseName, "Pass", description + " executed successfully");
		} else {
			ReportEvent.testStepReport(testCaseName, "Fail", description + " execution Failed");

		}
	}

	public static void Catchhandler(String des, Throwable t) {

		System.out.println(des + t.getMessage());
		utility.fnLogging(des + t.getMessage());
		ReportEvent.testStepReport("", "fail", des + t.getMessage());

	}

	public static void readingPropertyValue(Browser browser, String claimNumber, String contactName,
			String claimRelationshipID) throws IOException {
		File f = new File(configFilepath);
		FileReader fr = new FileReader(f);
		Properties prop = new Properties();
		prop.load(fr);
		claimNumber = prop.getProperty("claimID");
		contactName = prop.getProperty("contactName");
		claimRelationshipID = prop.getProperty("claimRelationshipID");
	}

	// Todays task ..--10092017

	/***
	 * function : inlineEditingOfFieldOfSectionByLabel Description : Function to
	 * perform in-line indentation based on label and section..
	 * 
	 * @param browser
	 * @param sectionXpath
	 * @param labelName
	 * @param existingValue
	 * @param inputValue
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */

	public static boolean inlineEditingOfFieldOfSectionByLabel(Browser browser, String sectionXpath, String labelName,
			String existingValue, String inputValue) {
		boolean inlineEditingOfFieldOfSectionByLabel = false;
		try {
			boolean fnStatus = false;
			String baseValueXpath = sectionXpath + "//table//td[text()='" + labelName/* Policy */
					+ "']/following-sibling::td[1]";
			String labelValueXpath = baseValueXpath + "//div[contains(@id,'inner')]";
			isElementExist(browser, labelValueXpath);
			String childLinkTagsXpath = labelValueXpath + "//a";
			WebElement valObj = browser.describe(WebElement.class, new XPathDescription(labelValueXpath));
			Link[] links = valObj.findChildren(Link.class,
					new LinkDescription.Builder().xpath(childLinkTagsXpath).build());
			if (links.length != 0) {
				for (Link linkTag : links) {
					String linkText = linkTag.getInnerText();
					if (linkText.equalsIgnoreCase(existingValue)) {
						String tdXpath = labelValueXpath + "/..";
						WebElement tdTag = browser.describe(WebElement.class,
								new WebElementDescription.Builder().xpath(tdXpath).build());
						tdTag.highlight();
						tdTag.doubleClick();
						tdTag.fireEvent(EventInfoFactory.createEventInfo("ondblclick"));
						break;
					} else {
						continue;
					}
				}
				String inputTextXpath = baseValueXpath + "//div[@class='inlineEditDiv']//input[@type='text']";
				isElementExist(browser, inputTextXpath);
				fnStatus = fnEditFieldTextEntry(browser, inputTextXpath, inputValue);
				if (fnStatus == true) {
					inlineEditingOfFieldOfSectionByLabel = true;
				} else {
					inlineEditingOfFieldOfSectionByLabel = false;
				}
			} else {
				valObj.highlight();
				valObj.doubleClick();
				String inputTextXpath = labelValueXpath + "//div[@class='inlineEditDiv']//input[@type='text']";
				isElementExist(browser, inputTextXpath);
				fnStatus = fnEditFieldTextEntry(browser, inputTextXpath, inputValue);
				if (fnStatus == true) {
					inlineEditingOfFieldOfSectionByLabel = true;
				} else {
					inlineEditingOfFieldOfSectionByLabel = false;
				}
			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in inlineEditingOfFieldOfSectionByLabel() is ", t);
			inlineEditingOfFieldOfSectionByLabel = false;
		}

		return inlineEditingOfFieldOfSectionByLabel;
	}

	/***
	 * Function : validateFieldValueWithInputValue Description : To validate
	 * whether the available field value is matching with that of user passed
	 * inputs based on section.
	 * 
	 * @param testCaseName
	 * @param browser
	 * @param sectionXpath
	 * @param labelName
	 * @param inputValue
	 * @return boolean
	 * @author N.Durgasivaramprasad
	 */
	public static boolean validateFieldValueWithInputValue(String testCaseName, Browser browser, String sectionXpath,
			String labelName, String inputValue) {
		boolean validateFieldValueWithInputValue = false;
		String appValue = null;
		try {
			appValue = GenericClass.getFieldValueOfSection(browser, labelName, sectionXpath);
			if (appValue.equalsIgnoreCase(inputValue)) {

				validateFieldValueWithInputValue = true;
			} else {

				validateFieldValueWithInputValue = false;
			}
		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception arised in inlineEditingOfPolicyID() is", t);
			validateFieldValueWithInputValue = false;
		}
		return validateFieldValueWithInputValue;
	}

	public static String getValueByTraversingToLowLevel(String testCaseName, Browser browser, String sectionXpath,
			String inputType) {
		String getValue = null;
		int baseTableRowCount = 0;
		int childTableRowCount = 0;
		int subchildTableRowCount = 0;
		try {
			String baseTableXpath = sectionXpath + "/table";
			baseTableRowCount = fngetTableRowCount(browser, baseTableXpath);

			// Traversing on base table rows..
			for (int i = 0; i <= baseTableRowCount; i++) {
				String baseRowXpath = baseTableXpath + "/tbody/tr[" + (i + 1) + "]";
				WebElement[] baseRowchildObjs = browser.findChildren(WebElement.class,
						new XPathDescription(baseRowXpath + "/*"));
				if (baseRowchildObjs.length != 0) {
					for (int j = 0; j <= baseRowchildObjs.length; j++) {
						String baseRowChildTag = baseRowchildObjs[j].getTagName();
						if (baseRowChildTag.equalsIgnoreCase("td")) {
							String baseTdTagXpath = baseRowXpath + "/td[" + (j + 1) + "]";
							WebElement[] baseTdChilds = browser.findChildren(WebElement.class,
									new XPathDescription(baseTdTagXpath + "/*"));
							if (baseTdChilds.length != 0) {
								for (int k = 0; k <= baseTdChilds.length; k++) {
									String baseTdChildTag = baseTdChilds[k].getTagName();
									if (baseTdChildTag.equalsIgnoreCase("table")) {
										String childtableTdTagXpath = baseTdTagXpath + "/table[" + (k + 1) + "]";
										childTableRowCount = fngetTableRowCount(browser, childtableTdTagXpath);
										// Traversing on child table rows..
										for (int l = 0; l <= childTableRowCount; l++) {
											String childTableRowXpath = childtableTdTagXpath + "/tbody/tr[" + (l + 1)
													+ "]";
											WebElement[] childRowchildObjs = browser.findChildren(WebElement.class,
													new XPathDescription(childTableRowXpath + "/*"));
											if (childRowchildObjs.length != 0) {
												for (int m = 0; m <= baseRowchildObjs.length; m++) {
													String rowChildTag = childRowchildObjs[m].getTagName();
													if (rowChildTag.equalsIgnoreCase("td")) {
														String childTdTagXpath = childTableRowXpath + "/td[" + (m + 1)
																+ "]";
														WebElement[] childTdChilds = browser.findChildren(
																WebElement.class,
																new XPathDescription(childTdTagXpath + "/*"));
														if (childTdChilds.length != 0) {
															for (int n = 0; n <= childTdChilds.length; n++) {
																String childTdChildTag = childTdChilds[n].getTagName();
																if (childTdChildTag.equalsIgnoreCase("table")) {
																	String subchildtableTagXpath = childTdChildTag
																			+ "/table[" + (n + 1) + "]";
																	subchildTableRowCount = fngetTableRowCount(browser,
																			subchildtableTagXpath);
																	// Traversing
																	// on sub
																	// child
																	// table
																	// rows..
																	for (int p = 0; p <= subchildTableRowCount; p++) {
																		String subchildTableRowXpath = subchildtableTagXpath
																				+ "/tbody/tr[" + (p + 1) + "]";
																		WebElement[] subchildRowchildObjs = browser
																				.findChildren(WebElement.class,
																						new XPathDescription(
																								subchildTableRowXpath
																										+ "/*"));
																		if (subchildRowchildObjs.length != 0) {
																			for (int q = 0; q <= subchildRowchildObjs.length; q++) {
																				String subChildRowChildTag = subchildRowchildObjs[q]
																						.getTagName();

																				if (subChildRowChildTag
																						.equalsIgnoreCase("td")) {
																					String subchildTdTagXpath = subchildTableRowXpath
																							+ "/td[" + (q + 1) + "]";
																					WebElement[] subchildTdChilds = browser
																							.findChildren(
																									WebElement.class,
																									new XPathDescription(
																											subchildTdTagXpath
																													+ "/*"));
																					if (subchildTdChilds.length != 0) {
																						for (int r = 0; r < subchildTdChilds.length; r++) {
																							String subchildTdChildTag = subchildTdChilds[r]
																									.getTagName();
																							if (subchildTdChildTag
																									.equalsIgnoreCase(
																											"textarea")
																									&& inputType
																											.equalsIgnoreCase(
																													"textarea")) {
																								getValue = subchildTdChilds[r]
																										.getInnerText();
																							} else if (subchildTdChildTag
																									.equalsIgnoreCase(
																											"text")
																									&& inputType
																											.equalsIgnoreCase(
																													"text")) {
																								getValue = subchildTdChilds[r]
																										.getInnerText();
																							} else {
																								// Future
																								// purpose
																								// if
																								// any
																								// tags
																								// are
																								// included
																								// other
																								// than
																								// text
																								// area..
																							}
																						}

																					} else {
																						System.out.println(
																								"There are no child elements for sub child Td tag..");
																					}
																				} else {
																					// Future
																					// neew
																					// to
																					// include
																					// other
																					// tags
																					// if
																					// there
																					// are
																					// any..
																					continue;
																				}
																			}
																		} else {
																			System.out.println(
																					"There are no child elements for sub child row..");
																		}
																	}
																} else {
																	// Future to
																	// include
																	// other
																	// tags
																	// other
																	// than
																	// table..
																	continue;
																}
															}
														} else {
															System.out.println(
																	"There are no child elements for child Td tag of child table....");

														}
													} else {
														// future purpose if
														// there are Some other
														// tags other than td..
														continue;
													}
												}
											} else {
												System.out.println("There are no child elements for child row..");
											}
										}

									} else {// Future purpose if any tags are
											// included other than table..
										continue;
									}
								}
							} else {
								System.out.println("There are no child elements for base Td tag..");
							}

						} else {
							// Future purpose if any tags are included other
							// than td..
							continue;
						}
					}
				} else {
					System.out.println("No child elements for base row..");

				}
			}

		} catch (Throwable t) {
			GenericClass.Catchhandler("Exception rised in getValueByTraversingToLowLevel() : ", t);
		}
		return getValue;
	}
	




	//Todays task --12102017
		
		/***
		 * Function : browserObjectOfChildBrowser
		 * Description : Create a child browser object after switching to the child browser..
		 * @param browserTitle
		 * @return Browser
		 * @author N.Durgasivaramprasad
		 */
		
		public static Browser browserObjectOfChildBrowser(Browser browser)
		{
			Browser switchedBrowser = null;
			String parentTitle=null;
			try
			{
				parentTitle = browser.getTitle();
				BrowserFactory br = new BrowserFactory();
				Browser[] allBrowsers = br.getAllOpenBrowsers(new BrowserDescription.Builder().build());
				for(Browser childBrowser : allBrowsers)
				{
					if(parentTitle.equalsIgnoreCase(childBrowser.getTitle()))
					{
						continue;
					}
					else
					{
						switchedBrowser = br.attach(new BrowserDescription.Builder().title(childBrowser.getTitle()).build());
					}
				}
				
				
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("Exception arised in switchToBrowserBasedOnTitle() is :", t);
			}
			return switchedBrowser ;
			
		}

		
		
		/***
		 * Function : browserObjectOfParentBrowser
		 * Description : create parent Browser Object after switching to the parent browser..
		 * @return Browser
		 * @author N.Durgasivaramprasad
		 */
		public static  Browser browserObjectOfParentBrowser()
		{
			Browser parentBrowser=null;
			String parentTitle=null;
			try
			{
				BrowserFactory br = new BrowserFactory();
				parentBrowser =br.attach(new BrowserDescription.Builder().title(parentTitle).build());
			}
			catch(Throwable t)
			{
				
			}
			return  parentBrowser;
			
			
		}
		
		/***
		 * Function name : checkLinkAvailableBasedOnLinkNameAndSectionXpath
		 * Description : Function to check availability of a link based on link name(unique link name) and by passing section Xpath..
		 * @param testCaseName
		 * @param browser
		 * @param sectionXpath
		 * @param linkName
		 * @return boolean 
		 * @author : N.Durgasivaramprasad
		 */
		public static boolean checkLinkAvailableBasedOnLinkNameAndSectionXpath(String testCaseName,Browser browser,String sectionXpath,String linkName)
		{
			boolean checkLinkAvailableBasedOnLinkNameAndSectionXpath= false;
			boolean isLinkClicked= false;
			try
			{
				String allLinkTagsXpath = sectionXpath+"//table//a";
					Link[] linkTags = browser.findChildren(Link.class, new LinkDescription.Builder().xpath(allLinkTagsXpath).build());
					
					for(int i=0;i<linkTags.length;i++)
					{
						String linkTagInnerText = linkTags[i].getInnerText();
						if(linkTagInnerText.equalsIgnoreCase(linkName))
						{
							isLinkClicked =true;
							break;
						}
						else
						{
							continue;
						}
						
					}
					if(isLinkClicked ==true)
					{
						checkLinkAvailableBasedOnLinkNameAndSectionXpath = true;
					}
					else
					{
						checkLinkAvailableBasedOnLinkNameAndSectionXpath = false;
					}
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("Exception arised in checkLinkAvailableBasedOnLinkNameAndSectionXpath() is", t);	
				checkLinkAvailableBasedOnLinkNameAndSectionXpath = false;
				
			}
			return checkLinkAvailableBasedOnLinkNameAndSectionXpath;
		}

		
		/***
		 * Function : clickLinkInFrameBasedOnLinkNameAndSectionXpath
		 * Description : To click a link which is available in a section by passing section xpath and Link name.. 
		 * @param browser
		 * @param frameName
		 * @param linkName
		 * @return Boolean
		 * @author N.Durgasivaramprasad
		 */
		public static boolean clickLinkInFrameBasedOnLinkNameAndSectionXpath(Browser browser, String frameName, String linkName )
		{
			boolean clickLinkInFrameBasedOnLinkNameAndSectionXpath = false;
			boolean isClicked = false;
			try
			{
				Frame obj =browser.describe(Frame.class, new FrameDescription.Builder().name(frameName).build());
				Link[] allLinks = obj.findChildren(Link.class, new LinkDescription.Builder().build());
				for(int i=0;i<allLinks.length;i++)
				{
					if(linkName.equalsIgnoreCase(allLinks[i].getInnerText()))
					{
						allLinks[i].click();
						isClicked = true;
						break;
					}
					else
					{
						continue;
					}
				}
				if(isClicked==true)
				{
					clickLinkInFrameBasedOnLinkNameAndSectionXpath= true;
				}
				else
				{
					clickLinkInFrameBasedOnLinkNameAndSectionXpath = false;	
				}
				
			}
			catch(Throwable t)
			{
				GenericClass.Catchhandler("Exception arised in checkLinkAvailableBasedOnLinkNameAndSectionXpath() is", t);	
				clickLinkInFrameBasedOnLinkNameAndSectionXpath = false;
			}
			return clickLinkInFrameBasedOnLinkNameAndSectionXpath;
		}
		
		
		
		
		

}
