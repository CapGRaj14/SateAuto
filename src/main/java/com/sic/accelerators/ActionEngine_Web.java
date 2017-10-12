package com.sic.accelerators;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * @author Subrto Sarkar
 * ActionEngine.java
 * Feb 4, 2017
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.text.html.HTML;

//*******************************************




import com.hp.lft.sdk.*;
import com.hp.lft.sdk.internal.web.WebEdit;
import com.hp.lft.sdk.internal.web.WebTestObjectFactory;
import com.hp.lft.sdk.stdwin.UiObject;
//import com.hp.lft.sdk.stdwin.UiObjectBaseDescription.Init;
import com.hp.lft.sdk.stdwin.UiObjectDescription;

/*import com.hp.lft.sdk.stdwin.EditField;
import com.hp.lft.sdk.stdwin.EditFieldDescription;*/
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;

import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.CheckBox;
import com.hp.lft.sdk.web.CheckBoxDescription;
import com.hp.lft.sdk.web.RadioGroup;
import com.hp.lft.sdk.web.RadioGroupDescription;
import com.hp.lft.sdk.web.Table;

import com.hp.lft.sdk.web.TableDescription;
import com.hp.lft.sdk.web.TableRow;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.sdk.web.WebTestObject;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;
import com.sun.mail.handlers.text_html;
import com.sun.tools.doclets.internal.toolkit.NestedClassWriter;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.ListItem;
import com.hp.lft.sdk.web.Page;
import com.hp.lft.sdk.web.PageDescription;

import freemarker.log.Logger;

import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Frame;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.FrameDescription;

import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;

//import com.hp.lft.*;

//*********************************************

public class ActionEngine_Web{

	static Browser browser;
	static Logger logger = Logger.getLogger("devpinoyLogger");

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :	 * fnButtonClick # No of Parameter : 1 # Description : To click a WebButton
	 * # Parameters and its datatype : String xpathVal # Developed on :
	 * 02/06/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean fnButtonClick(Browser browser, String xpathVal) throws GeneralLeanFtException {

		try {
			browser.describe(Button.class, new ButtonDescription.Builder().xpath(xpathVal).build()).highlight();
			browser.describe(Button.class, new ButtonDescription.Builder().xpath(xpathVal).build()).click();
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnButtonClick  is : " + t.getMessage());
			return false;
		}

	}
	
	/*
	 * #########################################################################
	 * ########### ############################## # Function Name : fnListBox #
	 * No of Parameter : 3 # Description : To select option from ListBox by
	 * using visible text # Parameters and its datatype : Browser browser,String
	 * xpathval,String selectval # Developed on : 05/16/2017 # Developed By :
	 * chennakesavulu P
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnListBox(Browser browser, String xpathval, String selectval) throws GeneralLeanFtException {
		try {
			isElementExist(browser, xpathval);
			browser.describe(ListBox.class, new XPathDescription(xpathval)).select(selectval);
			;
			// browser.describe(ListBox.class, new
			// ListBoxDescription.Builder().xpath(xpathval). build()).s;

			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnListBox  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnListBox  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnListBox  is : " + t.getMessage());
			return false;
		}
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name : fnListBox #
	 * No of Parameter : 3 # Description : To select option from ListBox by
	 * using visible text # Parameters and its datatype : Browser browser,String
	 * xpathval,String selectval # Developed on : 02/06/2017 # Developed By :
	 * Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnListBox(Browser browser, String xpathval, int indexval) throws GeneralLeanFtException {
		try {

			browser.describe(ListBox.class, new XPathDescription(xpathval)).select(indexval);
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnListBox  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnListBox  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnListBox  is : " + t.getMessage());
			return false;
		}
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnRadButtonClick # No of Parameter : 3 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String xpathVal,
	 * String selectVal # Developed on : 02/07/2017 # Developed By : Subrato
	 * Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnRadButtonClick(Browser browser, String xpathVal, int selectVal)
			throws GeneralLeanFtException {

		try {
			browser.describe(RadioGroup.class, new RadioGroupDescription.Builder().xpath(xpathVal).build())
					.select(selectVal);
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnRadButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnRadButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnRadButtonClick  is : " + t.getMessage());
			return false;
		}

	}
	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * radButtonClick # No of Parameter : 3 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String xpathVal,
	 * String selectVal # Developed on : 02/07/2017 # Developed By : Subrato
	 * Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */
	
	public static boolean selectRadButtonClick(Browser browser, String xpathVal) throws GeneralLeanFtException {

		try {
			browser.describe(RadioGroup.class, new XPathDescription(xpathVal)).highlight();
			browser.describe(RadioGroup.class, new XPathDescription(xpathVal)).click();
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnRadButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnRadButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnRadButtonClick  is : " + t.getMessage());
			return false;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * radButtonClick # No of Parameter : 3 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String xpathVal,
	 * String selectVal # Developed on : 02/07/2017 # Developed By : Subrato
	 * Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean selectRadButton(Browser browser, String type, String name) throws GeneralLeanFtException {

		try {
			browser.describe(WebElement.class,
					new XPathDescription("//FORM[@id=\"register\"]/TABLE[1]/TBODY[1]/TR[1]/TD[5]/span[2]/input[1]"))
					.highlight();
			browser.describe(WebElement.class,
					new XPathDescription("//FORM[@id=\"register\"]/TABLE[1]/TBODY[1]/TR[1]/TD[5]")).click();
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnRadButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnRadButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnRadButtonClick  is : " + t.getMessage());
			return false;
		}

	}

	// browser.describe(RadioGroup.class, new RadioGroupDescription.Builder()
	// .type("radio").tagName("INPUT").name("MHSQuestions[0].questionFlg").build());

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnPopButtonClick # No of Parameter : 2 # Description : To click a Pop
	 * Button # Parameters and its datatype : String xpathVal # Developed on :
	 * 02/16/2017 # Developed By : Ravi
	 * #########################################################################
	 * ########### ##############################
	 */
	public static boolean fnPopButtonClick(Browser browser, String xpathVal) throws GeneralLeanFtException {

		try {

			browser.describe(WebElement.class, new WebElementDescription.Builder().xpath(xpathVal).build()).click();
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnPopButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnPopButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnPopButtonClick  is : " + t.getMessage());
			return false;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnRadButtonClick # No of Parameter : 4 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String name,
	 * String xpathVal, String selectVal # Developed on : 02/15/2017 # Developed
	 * By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnRadButtonClick(Browser browser, String name, String xpathVal, String selectVal)
			throws GeneralLeanFtException {

		try {
			browser.describe(Frame.class, new FrameDescription.Builder().name("").build())
					.describe(RadioGroup.class, new RadioGroupDescription.Builder().xpath(xpathVal).build())
					.select(selectVal);
			
			browser.describe(RadioGroup.class, new RadioGroupDescription.Builder().xpath(xpathVal).build()).select(selectVal);
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnRadButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnRadButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnRadButtonClick  is : " + t.getMessage());
			return false;
		}
	}
	
	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnRadButtonClick # No of Parameter : 4 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String name,
	 * String xpathVal, String selectVal # Developed on : 02/15/2017 # Developed
	 * By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean radButtonClick(Browser browser, String name, String xpathVal, String selectVal)
			throws GeneralLeanFtException {

		try {
			
			browser.describe(RadioGroup.class, new RadioGroupDescription.Builder().xpath(xpathVal).build()).select(selectVal);
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnRadButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnRadButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnRadButtonClick  is : " + t.getMessage());
			return false;
		}
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnEditFieldTextEntry # No of Parameter : 3 # Description : To Enter value
	 * in an edit field of a web application # Parameters and its datatype :
	 * Browser browser, String xpathVal, String selectVal # Developed on :
	 * 02/07/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnEditFieldTextEntry(Browser browser, String xpathVal, String setText)
			throws GeneralLeanFtException {
		try {

			
			browser.describe(EditField.class, new EditFieldDescription.Builder().xpath(xpathVal).build()).highlight();

			browser.describe(EditField.class, new EditFieldDescription.Builder().xpath(xpathVal).build())
					.setValue(setText);
		
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnEditFieldTextEntry  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnEditFieldTextEntry  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnEditFieldTextEntry  is : " + t.getMessage());
			return false;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnEditFieldTextEntry # No of Parameter : 4 # Description : To Enter value
	 * in an edit field of a web application # Parameters and its datatype :
	 * Browser browser, String xpathVal, String selectVal, String name #
	 * Developed on : 02/15/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */
	public static String fnEditFieldTextEntry(Browser browser, String xpathVal, String setText, String name)
			throws GeneralLeanFtException {
		try {

			browser.describe(Frame.class, new FrameDescription.Builder().name(name).build())
					.describe(EditField.class, new EditFieldDescription.Builder().xpath(xpathVal).build())
					.setValue(setText);
			return setText;

		} catch (Throwable t) {
			System.out.println("The Exception for fnEditFieldTextEntry  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnEditFieldTextEntry  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnEditFieldTextEntry  is : " + t.getMessage());
			return null;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name : fnEditField
	 * # No of Parameter : 3 # Description : Verify the Edit field # Parameters
	 * and its datatype : Browser browser, String xpathVal, String name #
	 * Developed on : 02/15/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */
	public static EditField fnEditField(Browser browser, String xpathVal, String name) throws GeneralLeanFtException {
		try {

			return browser.describe(Frame.class, new FrameDescription.Builder().name(name).build())
					.describe(EditField.class, new EditFieldDescription.Builder().xpath(xpathVal).build());

		} catch (Throwable t) {
			System.out.println("The Exception for fnEditField  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnEditField  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnEditField  is : " + t.getMessage());
			return null;
		}

	}

	public static String fnReadFile(String pathOfFileToRead) throws IOException {
		String everything = null;
		BufferedReader br = new BufferedReader(new FileReader(pathOfFileToRead));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
			System.out.println(everything);
		} finally {
			br.close();
		}
		return everything;
	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnVerifyWebElement # No of Parameter : 3 # Description : To verify the
	 * webelement # Parameters and its datatype : Browser browser, String
	 * xpathVal, String selectVal # Developed on : 02/08/2017 # Developed By :
	 * Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static WebElement fnVerifyWebElement(Browser browser, String xpathVal) throws GeneralLeanFtException {
		try {
			return browser.describe(WebElement.class, new WebElementDescription.Builder().xpath(xpathVal).build());
		} catch (Throwable t) {
			System.out.println("The Exception for fnVerifyWebElement is : " + t.getMessage());
			utility.fnLogging("The Exception for fnVerifyWebElement is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnVerifyWebElement  is : " + t.getMessage());
			return null;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnVerifyWebElement # No of Parameter : 3 # Description : To verify the
	 * webelement # Parameters and its datatype : Browser browser, String
	 * xpathVal, String selectVal # Developed on : 02/08/2017 # Developed By :
	 * Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static WebElement fnVerifyWebElement(Browser browser, String xpathVal, String name)
			throws GeneralLeanFtException {

		try {
			return browser.describe(Frame.class, new FrameDescription.Builder().name(name).build())
					.describe(WebElement.class, new WebElementDescription.Builder().xpath(xpathVal).build());
		} catch (Throwable t) {
			System.out.println("The Exception for fnVerifyWebElement is : " + t.getMessage());
			utility.fnLogging("The Exception for fnVerifyWebElement is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnVerifyWebElement  is : " + t.getMessage());
			return null;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name : fnSwitchTab
	 * # No of Parameter : 1 # Description : To switch to current tab #
	 * Parameters and its datatype : String title # Developed on : 02/08/2017 #
	 * Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static Browser fnSwitchTab(String title) throws GeneralLeanFtException {
		try {
			Thread.sleep(4000);
			return BrowserFactory.attach(new BrowserDescription.Builder().title(title).build());
			
			
		} catch (Throwable t) {
			utility.fnLogging("The Exception for fnSwitchTab  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnSwitchTab  is : " + t.getMessage());
			return null;
		}

		
	}

	

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnClickCheckBox # No of Parameter : 2 # Description : To click on Check
	 * Box # Parameters and its datatype : Browser browser, String xpathVal #
	 * Developed on : 02/09/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnClickCheckBox(Browser browser, String xpathVal) {

		try {
			browser.describe(CheckBox.class, new CheckBoxDescription.Builder().xpath(xpathVal).build()).highlight();

			browser.describe(CheckBox.class, new CheckBoxDescription.Builder().xpath(xpathVal).build()).click();
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnClickCheckBox  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnClickCheckBox  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnClickCheckBox  is : " + t.getMessage());
			return false;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnQuitIEBrowser # No of Parameter : 0 # Description : To close all the IE
	 * browser # Parameters and its datatype : # Developed on : 02/10/2017 #
	 * Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static void fnQuitIEBrowser() {

		try {
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
		} catch (Throwable t) {
			System.out.println("The Exception for fnQuitIEBrowser  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnQuitIEBrowser  is : " + t.getMessage());
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnCountOfEditField # No of Parameter : 1 # Description : To count no of
	 * test boxes into the webpage # Parameters and its datatype : Browser
	 * browser # Developed on : 02/15/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static int fnCountOfEditField(Browser browser) throws GeneralLeanFtException, CloneNotSupportedException {
		try {
			EditFieldDescription targetEditFields = new EditFieldDescription.Builder().type("text").build();
			return browser.findChildren(EditField.class, targetEditFields).length;
		} catch (Throwable t) {
			System.out.println("The Exception for fnCountOfEditField is : " + t.getMessage());
			utility.fnLogging("The Exception for fnCountOfEditField is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnCountOfEditField is : " + t.getMessage());
			return 0;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnCountOfRadioGroup # No of Parameter : 1 # Description : To count no of
	 * radio buttons into the webpage # Parameters and its datatype : Browser
	 * browser # Developed on : 02/15/2017 # Developed By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static int fnCountOfRadioGroup(Browser browser) throws GeneralLeanFtException, CloneNotSupportedException {

		try {
			RadioGroupDescription targetRadioButton = new RadioGroupDescription.Builder().type("radio").build();
			return browser.findChildren(RadioGroup.class, targetRadioButton).length;
		} catch (Throwable t) {
			System.out.println("The Exception for fnCountOfRadioGroup is : " + t.getMessage());
			utility.fnLogging("The Exception for fnCountOfRadioGroup is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnCountOfRadioGroup is : " + t.getMessage());
			return 0;
		}

	}

	public static boolean waitForElementToBeDisappeared(Browser elementToBeTested) throws GeneralLeanFtException {
		int nTime = 1;
		boolean isExistElement = true;
		while (nTime < 360) {
			isExistElement = elementToBeTested.exists(2);
			if (isExistElement = false) {
				nTime = 360;
				System.out.println("Element Disappeared");
				utility.fnLogging("Element Disappeared");
			}
			nTime++;
		}
		return isExistElement;
	}
	/*
	 * #########################################################################
	 * ########### ############################## # Function Name : isElement
	 * Present # No of Parameter : 1 # Description : To verify the element is
	 * present or not # Parameters and its datatype : Browser browser,String
	 * xpath # Developed on : 05/17/2017 # Developed By : chennakesavulu p
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean isElementExist(Browser browser, String xpath) {
		try {
			if (browser.describe(WebElement.class, new XPathDescription(xpath)).exists()) {
				browser.describe(WebElement.class, new XPathDescription(xpath)).highlight();
			}
			return true;
		} catch (Throwable t) {
			
			System.out.println("The Exception for Is Element present is : " + t.getMessage());
			utility.fnLogging("The Exception for Is Element present is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for Is Element present is : " + t.getMessage());
			return false;
		}

	}

	
	
	// Handling UIObjects
	public static boolean isElementExist(Browser browser, String text, String winClassRegExp, int winId,
			String nativeClass) throws Throwable {

		if (browser.describe(UiObject.class, new UiObjectDescription.Builder().text(text)
				.windowClassRegExp(winClassRegExp).windowId(winId).nativeClass(nativeClass).build()).exists()) {
			browser.describe(UiObject.class, new UiObjectDescription.Builder().text(text)
					.windowClassRegExp(winClassRegExp).windowId(winId).nativeClass(nativeClass).build()).highlight();
		}
		return true;
	}

	// Verifying Title

	public static boolean verifyPageWithTitle(Browser browser, String pagetitle) throws GeneralLeanFtException {

		String title = browser.getTitle();
	
		if (title.equalsIgnoreCase(pagetitle)) {
			ReportEvent.testStepReport("testCaseName", "pass", pagetitle + " page is displayed");
			return true;
		} else {
			ReportEvent.testStepReport("testCaseName", "fail", pagetitle + " page is not displayed");
			return false;
		}
	}

	public static boolean fnWebElementClick1(Browser browser, String tagname, String inertext)
			throws GeneralLeanFtException {

		try {

			browser.describe(WebElement.class,
					new WebElementDescription.Builder().tagName(tagname).innerText(inertext).build());
			return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnWenElementClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnWenElementClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnWenElementClick  is : " + t.getMessage());
			return false;
		}

	}

	/*
	 * #########################################################################
	 * ########### ############################## 
	 * # Function Name :fnRadButtonClick 
	 * # No of Parameter : 3 
	 * # Description : To click a radio  button 
	 *# Parameters and its datatype : Browser browser, String xpathVal,
	 * String selectVal # Developed on : 
	 * # Developed By : Deepa
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnRadButtonClick1(Browser browser, String xpathVal) throws GeneralLeanFtException {

		try {
			browser.describe(RadioGroup.class, new RadioGroupDescription.Builder().xpath(xpathVal).build()).click();
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnRadButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnRadButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnRadButtonClick  is : " + t.getMessage());
			return false;
		}

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : isElementVisible
	# No of Parameter : 1
	# Description   : To select from drop down
	# Parameters and its datatype : String xpathVal
	# Developed on : 05/17/2017
	# Developed By : Deepa
	####################################################################################
	##############################	
	*/
	public static boolean isElementVisible(Browser browser,String xpath){
        try{
               if(browser.describe(WebElement.class, new XPathDescription(xpath)).isVisible()){
            	   browser.describe(Button.class, new XPathDescription(xpath));
                      browser.describe(WebElement.class, new XPathDescription(xpath)).highlight();
               }
               return true;
               }catch(Throwable t){
                      System.out.println("The Exception for Is Element present is : "+t.getMessage());
                      utility.fnLogging("The Exception for Is Element present is : "+t.getMessage());
                      ReportEvent.testStepReport("", "fail", "The Exception for Is Element present is : "+t.getMessage());
                      return false;
        }
               
        }
	
	public static boolean IsButtonEnabled(Browser browser,String xpath){
		 boolean fnstatus= false;
        try{
               	
        		if(browser.describe(WebElement.class, new XPathDescription(xpath)).isVisible())
            	  fnstatus =  true;
               }catch(Throwable t){
                      
                      fnstatus =  false;
        }
         return fnstatus;     
        }
	
	/*		
	####################################################################################
	##############################
	# Function Name : fnWebElementClick
	# No of Parameter : 1
	# Description   : To click a WebElement
	# Parameters and its datatype : String xpathVal
	# Developed on : 05/17/2017
	# Developed By : Deepa
	####################################################################################
	##############################	
	*/
	public static boolean fnWebElementClick(Browser browser, String xpathVal) throws GeneralLeanFtException{
		
		try{
			
			WebElement eb = browser.describe(WebElement.class, new XPathDescription(xpathVal));
			WebEdit e = eb.describe(WebEdit.class, new XPathDescription(xpathVal));
			e.highlight();
			
			
			browser.describe(WebElement.class, new WebElementDescription.Builder()
	        		.xpath(xpathVal).build()).click();
			return true;
			
		}catch(Throwable t){
					System.out.println("The Exception for fnWenElementClick  is : "+t.getMessage());
					utility.fnLogging("The Exception for fnWenElementClick  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for fnWenElementClick  is : "+t.getMessage());
					return false;
		}
	
      }
	
	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnRadButtonClick # No of Parameter : 4 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String name,
	 * String xpathVal, String selectVal # Developed on : 02/15/2017 # Developed
	 * By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnFrameButtonClick(Browser browser, String xpathVal)
			throws GeneralLeanFtException {
		

		try {
			Frame frame=browser.describe(Frame.class, new FrameDescription.Builder()
					.name("searchFrame").build());
			frame.describe(Button.class, new XPathDescription(xpathVal)).click();
			return true;
		} catch (Throwable t) {
			System.out.println("The Exception for fnFrameButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnFrameButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnFrameButtonClick  is : " + t.getMessage());
			return false;
		}
	}
	/*
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnRadButtonClick # No of Parameter : 4 # Description : To click a radio
	 * button # Parameters and its datatype : Browser browser, String name,
	 * String xpathVal, String selectVal # Developed on : 02/15/2017 # Developed
	 * By : Subrato Sarkar
	 * #########################################################################
	 * ########### ##############################
	 */

	public static boolean fnswitchToFrameByName(Browser browser,String name)
			throws GeneralLeanFtException {
		

		try {
			browser.describe(Frame.class, new FrameDescription.Builder()
					.name(name).build());
			
			return true;
			
			
		} catch (Throwable t) {
			System.out.println("The Exception for fnswitchToFrameByName  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnswitchToFrameByName  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnswitchToFrameByName  is : " + t.getMessage());
			return false;
		}
		
	}
/*
	
	 * #########################################################################
	 * ########### ############################## # FunctionName :
	 * getTableRowCount # No of Parameter : 2 # Description : Function for
	 * getting total row count in a dynamic table.. # Parameters and its
	 * data-type : WebDriver driver, String tableLocator # Developed on :
	 * 6/04/2017 # Developed By : Rajesh 
	 * #########################################################################
	 * ########### #############################
	 
	public static int fngetTableRowCount(Browser browser,String tableXpath) throws GeneralLeanFtException, CloneNotSupportedException {

		try {
			List<TableRow> totalRows = browser.describe(Table.class, new XPathDescription(tableXpath)).getRows();
			int rowcount=totalRows.size();
			return rowcount;
		} 
		catch (Throwable t)
		{
			System.out.println("The Exception for fngetTableRowCount is : " + t.getMessage());
			utility.fnLogging("The Exception for fngetTableRowCount is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fngetTableRowCount is : " + t.getMessage());
			return 0;
		}

	}
	
	 * #########################################################################
	 * ########### ############################## # FunctionName :
	 * getTableRowCount # No of Parameter : 2 # Description : Function for
	 * getting total row count in a Section in a table.. # Parameters and its
	 * data-type :Browser browser, String tableLocator # Developed on :
	 * 24/07/2017 # Developed By : Rajesh 
	 * #########################################################################
	 * ########### #############################
	 
	public static int getSectionTableRowCount(Browser browser, String tableLocator) {
		int count = 0;
		try {
			if (isElementExist(browser, tableLocator)) {
				
				WebElement table=browser.describe(WebElement.class, new XPathDescription(tableLocator));
				WebElement[] tdTags = table.findChildren(WebElement.class, new WebElementDescription.Builder().tagName("tr").build());
				int totalRows = tdTags.length;
				System.out.println(totalRows);
				return totalRows;
				
			} 
			else 
			{
				ReportEvent.testStepReport("", "FAIL", "Table is not available");
			}
			return count;
		} catch (Throwable t) {
			System.out.println("The Exception for getTableRowCount is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for getTableRowCount is : " + t.getMessage());
			return count;
		}
	}
	
	
	 * #########################################################################
	 * ########### ############################## # FunctionName :
	 * getHeadersFromTable # No of Parameter : 2 # Description : Function for
	 * getting total headers in a dynamic table.. # Parameters and its
	 * data-type : Browser browser, String tableXpath # Developed on :
	 * 21/07/2017 # Developed By : Rajesh 
	 * #########################################################################
	 * ########### #############################
	 
	public static List<String> getHeadersFromTable(Browser browser, String tableXpath) 
	{
		List<String> headerList = new ArrayList<String>();
		
		try {
			
			List<String> columnHeaders = browser.describe(Table.class, new XPathDescription(tableXpath)).getColumnHeaders();
			for (int columns = 1; columns < columnHeaders.size(); columns++)
			{
				String eachCell = columnHeaders.get(columns);
				headerList.add(eachCell);
			}
			
		 
		}
			catch(Throwable t) {
			System.out.println("The Exception for fnCountOfRadioGroup is : " + t.getMessage());
			utility.fnLogging("The Exception for fnCountOfRadioGroup is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnCountOfRadioGroup is : " + t.getMessage());
			
		}
		
	return headerList;
		
	}
	
	
	
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnButtonClick # No of Parameter : 1 # Description : To click a ImageLink or Button
	 * # Parameters and its datatype : String imgXpath # Developed on :
	 * 19/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 
	public static boolean fnImageLinkOrButtonClick(Browser browser, String imgXpath) throws GeneralLeanFtException {

		try {
			browser.describe(Image.class, new XPathDescription(imgXpath)).highlight();
			Thread.sleep(5000);
	    	browser.describe(Image.class, new XPathDescription(imgXpath)).click();
			
			return true;
			
		} catch (Throwable t) {
			System.out.println("The Exception for fnImageLinkOrButtonClick  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnImageLinkOrButtonClick  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnImageLinkOrButtonClick  is : " + t.getMessage());
			return false;
		}

	}
	
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnSwitchToParentTab # No of Parameter : 1 # Description : Switch To Super window Tab based on title.
	 * # Parameters and its datatype : String tabTitle # Developed on :
	 * 19/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 
	public static boolean fnSwitchToParentTab(Browser browser, String tabTitle) throws GeneralLeanFtException {

		try {
			
			Thread.sleep(3000);
	    	browser=BrowserFactory.attach(new BrowserDescription.Builder().title(tabTitle).build()); 
	    	browser.highlight();
	    	return true;

		} catch (Throwable t) {
			System.out.println("The Exception for fnSwitchToParentTab  is : " + t.getMessage());
			utility.fnLogging("The Exception for fnSwitchToParentTab  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fnSwitchToParentTab  is : " + t.getMessage());
			return false;
		}
	}
	
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fncheckBoxValidation # No of Parameter : 3 # Description : Function to checking or unchecking checkbox based on user inputs..
	 * # Parameters and its datatype : String tabTitle # Developed on :
	 * 21/07/2017 # Developed By : Rajesh & Durga
	 * #########################################################################
	 * ########### ##############################
	 
	public static boolean fncheckBoxValidation(Browser browser, String checkBoxXpath, String checkBoxValue) {
		boolean fncheckBoxValidation = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, checkBoxXpath);
			if (fnStatus == true)
			{
				browser.describe(CheckBox.class, new CheckBoxDescription.Builder().xpath(checkBoxXpath).build());
				
				if (checkBoxValue.equals("Check")) 
				{
					fnStatus = fnClickCheckBox(browser, checkBoxXpath);
					if (fnStatus == true) 
					{
					ReportEvent.testStepReport("testCaseName", "PASS", "Clicked on Checkbox successfully!!");
					fncheckBoxValidation = true;
					} 
					else
					{
						ReportEvent.testStepReport("testCaseName", "FAIL", "Failed to click on inpatient Checkbox");
						fncheckBoxValidation = false;
					}

				}
				else
				{
					ReportEvent.testStepReport("", "PASS", "User didn't passed inputs to click Checkbox.");
					fncheckBoxValidation = true;
				}

			} else {
				ReportEvent.testStepReport("", "FAIL", "There is no check box with xPath : " + checkBoxXpath);
				fncheckBoxValidation = false;
			}
			return fncheckBoxValidation;
		}
		catch (Throwable t) {
			System.out.println("The Exception for fncheckBoxValidation  is : " + t.getMessage());
			utility.fnLogging("The Exception for fncheckBoxValidation  is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for fncheckBoxValidation  is : " + t.getMessage());
			return false;
		}
	}
	
	
	
	 * #########################################################################
	 * ########### ############################## # Function Name : fnClikListBox #
	 * No of Parameter : 3 # Description : To select Click ListBox by
	 * using Click method(DropDown) # Parameters and its datatype : Browser browser,String
	 * xpathval # Developed on : 21/07/2017 # Developed By :
	 * Rajesh
	 * #########################################################################
	 * ########### ##############################
	 

	public static boolean fnClickListBox(Browser browser,String listBoxXpath)
	{
		boolean fnClickListBox=false;
	
		try
		{
			
			browser.describe(ListBox.class, new XPathDescription(listBoxXpath)).highlight();
			browser.describe(ListBox.class, new XPathDescription(listBoxXpath)).click();
			fnClickListBox=true;
			
		}
		catch(Throwable t)
		{
			fnClickListBox =false;
		}
		return fnClickListBox;
	}
	
	
	 * #########################################################################
	 * ########### ############################## # Function Name : fnClikEditorDateField #
	 * No of Parameter : 3 # Description : To select Click ListBox by
	 * using Click method(Date Field) # Parameters and its datatype : Browser browser,String
	 * xpathval # Developed on : 21/07/2017 # Developed By :
	 * Rajesh
	 * #########################################################################
	 * ########### ##############################
	 

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
	 #FunctionName : checkOrUncheckCheckBoxByLabel 
	 * No of Parameter : 3
	 * Description : Function to check OR Uncheck CheckBox by just passing label name of check box along with checkboxstatus = 'Check'. 
	 * Parameters and its data-type :Browser browser,  String labelName, String checkBoxStatus
	 * Developed on : 24/07/2017 
	 * Developed By : Rajesh & Durga
	 * Return type : Boolean
	 * #########################################################################
	 * ###########
	 

	public static boolean checkOrUncheckCheckBoxByLabel(Browser browser,  String labelName, String checkBoxStatus)
	{
		boolean checkOrUncheckCheckBoxByLabel = false;
		try
		{
			boolean fnStatus = false;
			//String immediateParentXpath = "//label[text()='"+labelName+"']/..";
			String immediateParentXpath = "//label[text()[contains(.,'"+labelName+"')]]/..";
			outerloop:
			for(int level =1;level<=6;level++)
			{
				String parentXpath = immediateParentXpath;
				String parentLevel ="/..";
				WebElement immediateParent=browser.describe(WebElement.class, new XPathDescription(parentXpath));
				//WebElement immediateParent = driver.findElement(By.xpath(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if(parentTagName.equalsIgnoreCase("td"))
				{
					
					String checkBoxXpath = parentXpath+"/following-sibling::td[1]//input[@type='checkbox']";
					fnStatus = isElementExist(browser, checkBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus = fncheckBoxValidation(browser, checkBoxXpath, checkBoxStatus);
						if(fnStatus ==true)
						{
							checkOrUncheckCheckBoxByLabel = true;
							break outerloop;
						}
						else
						{
							checkOrUncheckCheckBoxByLabel = false;
						}
					}
					else
					{
						checkOrUncheckCheckBoxByLabel = false;
					}
					
				}
				else if(parentTagName.equalsIgnoreCase("th"))
				{
					
					String checkBoxXpath = parentXpath+"/following-sibling::td[1]//input[@type='checkbox']";
					fnStatus = isElementExist(browser, checkBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus = fncheckBoxValidation(browser, checkBoxXpath, checkBoxStatus);
						if(fnStatus ==true)
						{
							checkOrUncheckCheckBoxByLabel = true;
							break outerloop;
						}
						else
						{
							checkOrUncheckCheckBoxByLabel = false;
						}
					}
					else
					{
						checkOrUncheckCheckBoxByLabel = false;
					}
					
				}
				else if(parentTagName.equalsIgnoreCase("div"))
				{
					String updatedParentXpath = "//label[text()='"+labelName+"']";
					String checkBoxXpath = updatedParentXpath+"/following-sibling::div[1]//input[@type='checkbox']";
					fnStatus = isElementExist(browser, checkBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus =checkBoxValidationAngularJS(browser, checkBoxXpath, checkBoxStatus);
						
						if(fnStatus ==true)
						{
							checkOrUncheckCheckBoxByLabel = true;
							break outerloop;
							
						
						}
						else
						{
							checkOrUncheckCheckBoxByLabel = false;
							//break outerloop;
						}
					}
					else
					{
						checkOrUncheckCheckBoxByLabel = false;
					}
				}
				
				else
				{
					parentXpath = parentXpath+parentLevel;
				}
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Exception message is : "+t.getMessage());
		}
		return checkOrUncheckCheckBoxByLabel;
	}
	
	 * #FunctionName : selectValueByVisibleTextBasedOnLabel 
	 * No of Parameter : 3
	 * Description : Function to select a value from a dropDown by just passing label name of drop down along with the value to be selected.. 
	 * Parameters and its data-type :Browser browser,  String labelName, String inputValue
	 
	 * Developed By : Rajesh & DurgaSivaram Prasad
	 * Return type : Boolean
	 * #########################################################################
	 * ###########
	 
	
	public static boolean selectValueByVisibleTextBasedOnLabel(Browser browser,  String labelName, String inputValue)
	{
		boolean selectValueByVisibleTextBasedOnLabel = false;
		try
		{
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()='"+labelName+"']/..";
			//String immediateParentXpath ="//label[text()[contains(.,'"+labelName+"')]]/..";
			outerloop:
			for(int level =1;level<=6;level++)
			{
				String parentXpath = immediateParentXpath;
				String parentLevel ="/..";
				WebElement immediateParent=browser.describe(WebElement.class, new XPathDescription(parentXpath));
				//WebElement immediateParent = driver.findElement(By.xpath(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if(parentTagName.equalsIgnoreCase("td"))
				{
					String dropdownXpath = parentXpath+"/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if(fnStatus ==true)
					{
						fnStatus=fnClickListBox(browser, dropdownXpath);
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if(fnStatus ==true)
						{
							selectValueByVisibleTextBasedOnLabel = true;
							break outerloop;
						}
						else
						{
							selectValueByVisibleTextBasedOnLabel = false;
						}
					}
					else
					{
						selectValueByVisibleTextBasedOnLabel = false;
					}
					
				}
				else if(parentTagName.equalsIgnoreCase("th"))
				{
					String dropdownXpath = parentXpath+"/following-sibling::td[1]//select";
					fnStatus = isElementExist(browser, dropdownXpath);
					if(fnStatus ==true)
					{
						fnStatus = fnListBox(browser, dropdownXpath, inputValue);
						if(fnStatus ==true)
						{
							selectValueByVisibleTextBasedOnLabel = true;
							break outerloop;
						}
						else
						{
							selectValueByVisibleTextBasedOnLabel = false;
						}
					}
					else
					{
						selectValueByVisibleTextBasedOnLabel = false;
					}
					
				}
				else if(parentTagName.equalsIgnoreCase("div"))
				{
					String updatedParentXpath = "//label[text()='"+labelName+"']";
					String siblingXpath = updatedParentXpath+"/following-sibling::*";
					String siblingTagName = browser.describe(WebElement.class, new XPathDescription(parentXpath)).getTagName();
					
					if(siblingTagName.equalsIgnoreCase("div"))
					{
						String dropdownXpath = updatedParentXpath+"/following-sibling::"+siblingTagName+"//select";
						fnStatus = isElementExist(browser, dropdownXpath);
						if(fnStatus ==true)
						{
							fnStatus = fnListBox(browser,dropdownXpath, inputValue);
							if(fnStatus ==true)
							{
								selectValueByVisibleTextBasedOnLabel = true;
								break outerloop;
							}
							else
							{
								selectValueByVisibleTextBasedOnLabel = false;
							}
						}
						else
						{
							selectValueByVisibleTextBasedOnLabel = false;
						}
					}
					else if(siblingTagName.equalsIgnoreCase("select"))
					{
						String dropdownXpath = updatedParentXpath+"/following-sibling::"+siblingTagName;
						fnStatus = isElementExist(browser, dropdownXpath);
						if(fnStatus ==true)
						{
							fnStatus = fnListBox(browser, dropdownXpath, inputValue);
							if(fnStatus ==true)
							{
								selectValueByVisibleTextBasedOnLabel = true;
								break outerloop;
							}
							else
							{
								selectValueByVisibleTextBasedOnLabel = false;
							}
						}
						else
						{
							selectValueByVisibleTextBasedOnLabel = false;
						}
					}
					else
					{
						//Need to include new tags if we came across any..
						continue;
					}
				
				}
				else
				{
					parentXpath = parentXpath+parentLevel;
				}
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Exception message is : "+t.getMessage());
		}
		return selectValueByVisibleTextBasedOnLabel;
	}
	 #FunctionName : sendKeysToTextBoxByLabel 
	 * No of Parameter : 3
	 * Description : Function to pass text to an input text box by just passing label name of text box along with the value to be entered. 
	 * Parameters and its data-type :Browser browser, String labelName, String inputValue
	 * Developed on : 24/07/2017 
	 * Developed By : Rajesh & DurgaSivaramprasad
	 * Return type : Boolean
	 * #########################################################################
	 * ###########
	 

	public static boolean sendKeysToTextBoxByLabel(Browser browser,  String labelName, String inputValue)
	{
		boolean sendKeysToTextBoxByLabel = false;
		try
		{
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()[contains(.,'"+labelName+"')]]/..";
			outerloop:
			for(int level =1;level<=6;level++)
			{
				String parentXpath = immediateParentXpath;
				String parentLevel ="/..";
				WebElement immediateParent=browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if(parentTagName.equalsIgnoreCase("td"))
				{
					
					String textBoxXpath = parentXpath+"/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						if(fnStatus ==true)
						{
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						}
						else
						{
							sendKeysToTextBoxByLabel = false;
						}
					}
					else
					{
						sendKeysToTextBoxByLabel = false;
					}
					
				}
				else if(parentTagName.equalsIgnoreCase("th"))
				{
					
					String textBoxXpath = parentXpath+"/following-sibling::td[1]//input[@type='text']";
					fnStatus = isElementExist(browser, textBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus = fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						if(fnStatus ==true)
						{
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						}
						else
						{
							sendKeysToTextBoxByLabel = false;
						}
					}
					else
					{
						sendKeysToTextBoxByLabel = false;
					}
					
				}
				else if(parentTagName.equalsIgnoreCase("div"))
				{
					String updatedParentXpath = "//label[text()='"+labelName+"']";
					String textBoxXpath = updatedParentXpath+"/following-sibling::div[1]//input";     ///following-sibling::div[1]//input[@type='text']";
					
					
					fnStatus = isElementExist(browser, textBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus =fnEditFieldTextEntry(browser, textBoxXpath, inputValue);
						WebElement element = driver.findElement(By.xpath(textBoxXpath));
						element.sendKeys(Keys.DELETE);
						element.sendKeys(inputValue);
						
						if(fnStatus ==true)
						{
							sendKeysToTextBoxByLabel = true;
							break outerloop;
						}
						else
						{
							sendKeysToTextBoxByLabel = false;
						}
					}
					else
					{
						sendKeysToTextBoxByLabel = false;
					}
				}
				
				else
				{
					parentXpath = parentXpath+parentLevel;
				}
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Exception message is : "+t.getMessage());
		}
		return sendKeysToTextBoxByLabel;
	}
	

	 #FunctionName : sendKeysToAreaTextBoxByLabel 
	 * No of Parameter : 3
	 * Description : Function to pass text to an text Area box by just passing label name of text Area box along with the value to be entered. 
	 * Parameters and its data-type :Browser browser,  String labelName, String inputValue
	 * Developed on : 25/07/2017 
	 * Developed By : Rajesh & DurgaSivaramprasad
	 * Return type : Boolean
	 * #########################################################################
	 * ###########
	 
	
	public static boolean sendKeysToAreaTextBoxByLabel(Browser browser,  String labelName, String inputValue)
	{
		boolean sendKeysToAreaTextBoxByLabel = false;
		try
		{
			boolean fnStatus = false;
			String immediateParentXpath = "//label[text()[contains(.,'"+labelName+"')]]/..";
			outerloop:
			for(int level =1;level<=6;level++)
			{
				String parentXpath = immediateParentXpath;
				String parentLevel ="/..";
				WebElement immediateParent=browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if(parentTagName.equalsIgnoreCase("td"))
				{
					
					String textAreaBoxXpath = parentXpath+"/following-sibling::td[1]//textarea";
					fnStatus = isElementExist(browser, textAreaBoxXpath);
					if(fnStatus ==true)
					{
						fnStatus = fnEditFieldTextEntry(browser, textAreaBoxXpath, inputValue);
						if(fnStatus ==true)
						{
							sendKeysToAreaTextBoxByLabel = true;
							break outerloop;
						}
						else
						{
							sendKeysToAreaTextBoxByLabel = false;
						}
					}
					else
					{
						sendKeysToAreaTextBoxByLabel = false;
					}
					
				}
				else
				{
					parentXpath = parentXpath+parentLevel;
				}
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Exception message is : "+t.getMessage());
		}
		return sendKeysToAreaTextBoxByLabel;
	}
	
	
	
	
	 * #FunctionName : checkFieldNameAvailabilityInSection # No of Parameter : 4
	 * # Description : Function to check if a Field name is available with in a
	 * section. # Parameters and its data-type :Browser browser ,String fieldName, String sectionXpath # Developed on : 27/07/2017
	 * # Developed By : Rajesh & DurgaSivaramprasad # Return type : boolean
	 * #########################################################################
	 * ###########
	 

	public static boolean checkFieldNameAvailabilityInSection(Browser browser, String fieldName,String sectionXpath) {
		boolean checkFieldNameAvailabilityInSection = false;
		try {
			boolean fnStatus = false;
			fnStatus = isElementExist(browser, sectionXpath);
			if (fnStatus == true) {
				String rowsXpath = sectionXpath.concat("//table/tbody/tr");
				WebElement[] rowElements = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(rowsXpath).build());
				//List<WebElement> rowElements = driver.findElements(By.xpath(rowsXpath));
				int rowCount = rowElements.length;
				outerloop: for (int j = 1; j <= rowCount; j++) {
					String allThTagsXpath = rowsXpath + "[" + j + "]/th";
					WebElement[] rowThElements = rowElements[j].findChildren(WebElement.class, new WebElementDescription.Builder().xpath(allThTagsXpath).build());
					//List<WebElement> rowThElements = driver.findElements(By.xpath(allThTagsXpath));
					int thElementCount = rowThElements.length;
					for (int k = 1; k <= thElementCount; k++) {
						String thChildTagsXpath = allThTagsXpath + "[" + k + "]/*";
						WebElement[] thChildElements = rowThElements[k].findChildren(WebElement.class, new WebElementDescription.Builder().xpath(thChildTagsXpath).build());
						//List<WebElement> thChildElements = driver.findElements(By.xpath(thChildTagsXpath));
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
										
										 * System.out.println(fieldName +
										 * " : field name is NOT available in the section.."
										 * );
										 * checkFieldNameAvailabilityInSection=
										 * false;
										 
										continue;
									}
								} else {
									continue;
								}

							}

							

						} else {
							*//***
							 * Include if any new tags are available in future
							 *//*
							continue;
						}

					}
				}
			} else {
				System.out.println("Section is not available!!");
				ReportEvent.testStepReport("", "fail", sectionXpath + "Section is not available");
				//softAssert.fail(sectionXpath + "Section is not available");
			}
		} catch (Throwable t) {
			System.out.println("The Exception for checkFieldNameAvailabilityInSection is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail",
					"The Exception for checkFieldNameAvailabilityInSection is : " + t.getMessage());
			}
		return checkFieldNameAvailabilityInSection;
	}
	
	
	 * #FunctionName : fnClickFrameButtonByPageTitle # No of Parameter : 4
	 * # Description : Function to Clicking the button of frame using Page Title.
	 * # Parameters and its data-type :Browser browser,String pageTitle,String frameName,String buttonXpath
	 * # Developed on : 25/07/2017
	 * # Developed By : Rajesh
	 * # Return type : boolean
	 * #########################################################################
	 * ###########
	 
	public static boolean fnClickFrameButtonByPageTitle(Browser browser,String pageTitle,String frameName,String buttonXpath)
	{
		boolean fnClickFrameButtonByPageTitle=false;
	
		try
		{
			
			browser=BrowserFactory.attach(new BrowserDescription.Builder().title(pageTitle).build()); 
			browser.highlight();
			
			
			browser.describe(Page.class, new PageDescription.Builder()
					.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
					.name(frameName).build()).describe(Button.class, new XPathDescription(buttonXpath)).highlight();
			browser.describe(Page.class, new PageDescription.Builder()
					.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
					.name(frameName).build()).describe(Button.class, new XPathDescription(buttonXpath)).click();
			
			fnClickFrameButtonByPageTitle=true;
			
		}
		catch(Throwable t)
		{
			fnClickFrameButtonByPageTitle =false;
		}
		return fnClickFrameButtonByPageTitle;
	}
	
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * datePicker # No of Parameter : 3 # Description : Function for selecting date from date picker 
	 * # Parameters and its datatype : Browser browser, String tableLocator, String date
	 * # Developed on :	25/07/2017 
	 * # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 
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
				
				int rowCount=fngetTableRowCount(browser, dateText);
				// Year selection..
				browser.describe(WebElement.class, new XPathDescription(yearText)).click();
				boolean yearStatus = fnListBox(browser, yearText, year);
				if (yearStatus = true) {
					// ReportEvent.testStepReport("", "PASS", "selected year is :" + year);
					// Month selection..
					browser.describe(WebElement.class, new XPathDescription(monthText)).click();
					boolean monthStatus = fnListBox(browser, monthText, month);
					if (monthStatus = true) {
						// ReportEvent.testStepReport("", "PASS", "selected Month is :" + month);
						// Date selection..
						outerloop: for (int i = 1; i < rowCount; i++) 
						{
							String rowPath = dateText.concat("//tr[" + i + "]");
							// Fetching all child elements of row tag.
							String allChildTagsXpath = rowPath.concat("/*");
							
							WebElement[] allChild=browser.findChildren(WebElement.class, new XPathDescription(allChildTagsXpath));
							for(int h=0;h<=allChild.length-1;h++)
							{
								System.out.println(allChild[h].getInnerText());
								String innerText = allChild[h].getInnerText();
								if (innerText.equalsIgnoreCase(day)) 
								{
									allChild[h].click();
									datePicker=true;
									// ReportEvent.testStepReport("", "PASS", "Clicked date :" + day);
									break outerloop;
								} 
								else
								{
									continue;
								}
							}
								
						}
							
							
							}

					else {
						ReportEvent.testStepReport("", "FAIL", "Month is not selected");
					}
				} 
				else {
					ReportEvent.testStepReport("", "FAIL", "Year is not selected");
					
				}	
			}
				else
				{
					ReportEvent.testStepReport("", "FAIL", "Date is not selected");
					datePicker = false;
				}
			}
		catch(Throwable t) {
			System.out.println("The Exception for datePicker is : " + t.getMessage());
			utility.fnLogging("The Exception for datePicker is : " + t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for datePicker is : " + t.getMessage());
		}
			return datePicker;
		}
	
	 * #FunctionName : dateConversion # No of Parameter : 5 # Description :
	 * Function to convert the date format from 'FullMonth/dd/yyyy' to
	 * 'mm/dd/yyyy' OR from 'mm/dd/yyyy' to 'FullMonth/dd/yyyy' # Parameters and
	 * its data-type : String inputDate, String dateFormat # Developed on :
	 * 14/06/2017 # Developed By : Subrato, Sarkar # Return type : int
	 * #########################################################################
	 * ###########
	 
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
	
	 * #FunctionName : DateAndTimeConversionBasedOnTimeZones 
	 * No of Parameter : 2
	 * Description : Function to convert date and Time of TimeZone-1 to TimeZone2. 
	 * Parameters and its data-type :String TimeZone1, String TimeZone2
	 * Developed on : 07/08/2017 
	 * Developed By : Rajesh
	 * Return type : String
	 * Note : TimeZone of India is "Asia/Calcutta" and Time zone of Portland is "US/Pacific".
	 * #########################################################################
	 * ###########
	 
	public static String DateAndTimeConversionBasedOnTimeZones(String TimeZone1, String TimeZone2)
	{
		String DATE_FORMAT = "M/dd/yyyy h:mm a";
		Calendar cal = Calendar.getInstance();
    	int hour = cal.get(Calendar.HOUR_OF_DAY);
    	String minutes ="";
    			
    	if(cal.get(Calendar.MINUTE)<10)
    	{
    		minutes=String.format("%02d",cal.get(Calendar.MINUTE));
    	}
    	else
    	{
    		minutes=String.valueOf(cal.get(Calendar.MINUTE));
    	}
    	int hourVal =0;
        if (hour == 0) {
        	hourVal =  0;  
    	} else if (hour < 12) {
    		hourVal = hour;
    	} else if (hour == 12) {
    		hourVal = 12;
    	} else {
    		hourVal = hour-12;
    	}
        int month=cal.get(Calendar.MONTH)+1;
    	String timeString="";
    	if (hour == 0) {
    	    timeString =  "AM";  
    	} else if (hour < 12) {
    	    timeString = "AM";
    	} else if (hour == 12) {
    	    timeString = "PM";
    	} else {
    	    timeString =  "PM";
    	}
    	
    	String convertedDateTime= month+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR)+" " + hourVal + ":"+minutes+ " "+timeString;
    	 String dateInString =convertedDateTime; 
         LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
         ZoneId TimeZone1Id = ZoneId.of(TimeZone1"Asia/Calcutta");
         System.out.println("TimeZone1 ID : " + TimeZone1Id);
         ZonedDateTime TimeZone1DateTime = ldt.atZone(TimeZone1Id);
         ZoneId TimeZone2Id = ZoneId.of(TimeZone2"US/Pacific");
         System.out.println("TimeZone2 ID : " + TimeZone2Id);
         ZonedDateTime TimeZone2DateTime = TimeZone1DateTime.withZoneSameInstant(TimeZone2Id);
         DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
         System.out.println("\n---DateTimeFormatter---");
         System.out.println("Formatted Date of TimeZone1 : " + format.format(TimeZone1DateTime));
         System.out.println("Formatted Date of TimeZone2 : " + format.format(TimeZone2DateTime));
		return format.format(TimeZone2DateTime);
	}
	
	
	 * #########################################################################
	 * ########### ############################## # Function Name :
	 * fnClickLinkInLinkClass # No of Parameter : 1 # Description : To click a Link class link
	 * # Parameters and its datatype : String xpathVal # Developed on :
	 * 26/07/2017 # Developed By : Rajesh
	 * #########################################################################
	 * ########### ##############################
	 
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
		
		
		
		
		 * #FunctionName : getLabelsOfSection # No of Parameter : 3 # Description :
		 * Function to fetch all Labels within a section into a list.. # Parameters
		 * and its data-type : Browser browser, String
		 * sectionXpath # Developed on : 04/08/2017 # Developed By :
		 * Rajesh # Return type : String
		 * #########################################################################
		 * ###########
		 
		
		public static List<String> getLabelsOfSection( String sectionXpath,Browser browser) {
			List<String> labelList = new ArrayList<String>();
			try {
				String allLabelsXpath = sectionXpath.concat("//table//label");
			
				WebElement[] allChild=browser.findChildren(WebElement.class, new XPathDescription(allLabelsXpath));
				
				for (WebElement labelText:allChild)
				{
					labelText.highlight();
					System.out.println(labelText.getInnerText());
					labelList.add(labelText.getInnerText());
				}

			} 
			catch (Throwable t)
			{
				System.out.println("The Exception for getLabelsOfSection is : " + t.getMessage());
				utility.fnLogging("The Exception for getLabelsOfSection is : " + t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for getLabelsOfSection is : " + t.getMessage());
				
			}

			return labelList;
		}
		
		
		 * #FunctionName : fieldAvailabilityValidation # No of Parameter : 3 #
		 * Description : Function to check availability of fields of any
		 * section/page.. # Parameters and its data-type : Browser browser, String sectionXpath, String inputFieldValues
		 *  # Developed on : 04/08/2017 #
		 * Developed By : Rajesh # Return type : boolean # Note : All
		 * input fields needs to be separated by Comma(,).
		 * #########################################################################
		 * ###########
		 
		

		public static boolean fieldAvailabilityValidation(Browser browser, String inputFieldValues,String sectionXpath) {
			int matchedFieldCounter = 0;
			boolean fieldAvailabilityValidation = false;
			try {
				String splitInputFields[] = inputFieldValues.split(",");
				List<String> splitInputFieldsList = new ArrayList<String>();
				splitInputFieldsList = Arrays.asList(splitInputFields);
				int inputFieldCount = splitInputFieldsList.size();
				List<String> pageSource = getLabelsOfSection(sectionXpath,browser);
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
				//softAssert.fail("The Exception for fieldAvailabilityValidation is : " + t.getMessage());
				fieldAvailabilityValidation = false;
			}

			return fieldAvailabilityValidation;
		}
		
		
		 * #FunctionName : checkingColumn2AvailabilityBetweenColumn1And3 # No of
		 * Parameter : 6 # Description : Function to check if column header-2 is
		 * available in between Column header-1 and column header-3 in a section.. #
		 * Parameters and its data-type : Browser browser,String
		 * tableXpath, String columnHeader1, String columnHeader2, String
		 * columnHeader3 # Developed on : 27/07/2017 # Developed By :
		 * Rajesh & DurgaSivaramprasad # Return type : boolean
		 * 
		 * #########################################################################
		 * ###########
		 
		public static boolean checkingColumn2AvailabilityBetweenColumn1And3(Browser browser,
				String tableXpath, String columnHeader1, String columnHeader2, String columnHeader3) {
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
									System.out.println(columnHeader2 + ", is available in between : " + columnHeader1+ " and " + columnHeader3);
									checkingColumn2AvailabilityBetweenColumn1And3 = true;
									break;
								} else {
									System.out.println(columnHeader2 + ", is not available BEFORE column header " + columnHeader3);
									ReportEvent.testStepReport("", "FAIL",columnHeader2 + ", is not available BEFORE column header " + columnHeader3);
									checkingColumn2AvailabilityBetweenColumn1And3 = false;
								}
							} else {
								System.out.println(columnHeader1 + ", is not available BEFORE column header " + columnHeader2);
								ReportEvent.testStepReport("", "FAIL",columnHeader1 + ", is not available BEFORE column header " + columnHeader2);
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
				//softAssert.fail("The Exception for checkingColumn2AvailabilityBetweenColumn1And3 is : " + t.getMessage());
				checkingColumn2AvailabilityBetweenColumn1And3 = false;
			}
			return checkingColumn2AvailabilityBetweenColumn1And3;
		}
		
		 * #FunctionName : checkingDropDownValues 
		 * No of Parameter : 3
		 * Description : Function to check availability of all values in a dropdown by just passing label name and dropdown values as input to the function. 
		 * Parameters and its data-type :Browser browser,  String labelName, String inputValues
		 * Developed on : 27/07/2017 
		 * Developed By : Rajesh & Durga
		 * Return type : Boolean
		 * #########################################################################
		 * ###########
		 
			public static boolean checkingDropDownValues(Browser browser,  String labelName, String inputValues)
			{
				
				boolean checkingDropDownValues = false;
				int matchedvalueCounter =0;
				try
				{
					String inputValArray[] =inputValues.split(",");
					List<String> inputValueList = Arrays.asList(inputValArray);
					String immediateParentXpath = "//label[text()='"+labelName+"']/..";
					outerloop:
					for(int level =1;level<=6;level++)
					{
						String parentXpath = immediateParentXpath;
						String parentLevel ="/..";
						
						WebElement immediateParent = browser.describe(WebElement.class, new XPathDescription(parentXpath));
						String parentTagName = immediateParent.getTagName();
						if(parentTagName.equalsIgnoreCase("td"))
						{
							String dropdownXpath = parentXpath+"/following-sibling::td[1]//select";
							ListBox dropdownList = browser.describe(ListBox.class,new XPathDescription(dropdownXpath));
							List<ListItem> allItems = dropdownList.getItems();
							for(ListItem allValues:allItems)
							{
								for(String inputValue : inputValueList)
								{
									if(allValues.getText().equalsIgnoreCase(inputValue))
									{
										System.out.println(allValues.getText());
										matchedvalueCounter++;
									}
									else
									{
										continue;
									}
								}
							}
							if(matchedvalueCounter==inputValueList.size())
							{
								checkingDropDownValues=true;
								break outerloop;
							}
							else
							{
								checkingDropDownValues=false;
							}
							
						}
						else
						{
							parentXpath = parentXpath+parentLevel;
						}
					}
					
				}
				catch(Throwable t)
				{
					System.out.println("Exception message is : "+t.getMessage());
				}
				return checkingDropDownValues;
			}
			 	
			
			 * #FunctionName : getFieldValueOfSection # No of Parameter : 4 #
			 * Description : Function to fetch Value of a field in a section based on
			 * user inputs related to field name/key.. # Parameters and its data-type :
			 * Browser browser,String fieldName, String sectionXpath #
			 * Developed on : 31/07/2017 # Developed By : Rajesh & Durga # Return
			 * type : String
			 * #########################################################################
			 * ###########
			 
		
			public static String getFieldValueOfSection(Browser browser, String fieldName,String sectionXpath) {
				String fieldValue = null;
				try {
					boolean fnStatus = false;
					fnStatus = isElementExist(browser, sectionXpath);
					if (fnStatus == true) {
						String tableXpath = sectionXpath.concat("//table");
						int rowCount = getSectionTableRowCount(browser, tableXpath);
						outerloop: for (int j = 1; j <= rowCount; j++) 
						{
							String allTdTagsXpath = tableXpath + "//tr[" + j + "]/td";
							WebElement[] rowTdElements = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
							int tdElementCount = rowTdElements.length;
							for (int k = 0; k <= tdElementCount - 1; k++) {
								int h = k;

								if (k % 2 == 0) {
									String tdElementText = rowTdElements[k].getInnerText();
									if (tdElementText.equals(fieldName)) {
										h++;
										// Checking for child tags..
										String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]" + "/*";
										WebElement[] tdChildElements = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(tdChildtagsXpath).build());
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
						}
					} else {
						System.out.println("Section is not available!!");
						ReportEvent.testStepReport("", "fail", sectionXpath + "Section is not available");
						//softAssert.fail(sectionXpath + "Section is not available");
					}
				} catch (Throwable t) {
					System.out.println("The Exception for getFieldValueOfSection is : " + t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for getFieldValueOfSection is : " + t.getMessage());
					}
				return fieldValue;
			}
			
			 * #FunctionName : fnEnterInputTextInWindowFrame # No of Parameter : 4 #
			 * Description : Function to Enter the text in textfield under frame based on page title..
			 * Parameters and its data-type :Browser browser,String pageTitle,String frameName,String inputTextBoxXpath,String inputTextName
			 * Developed on : 31/07/2017 # Developed By : Rajesh 
			 * # Return Type : boolean
			 * #########################################################################
			 * ###########
			 
			public static boolean fnEnterInputTextInWindowFrame(Browser browser,String pageTitle,String frameName,String inputTextBoxXpath,String inputTextName)
			{
				boolean fnEnterInputTextInWindowFrame=false;
			
				try
				{
					browser=BrowserFactory.attach(new BrowserDescription.Builder().title("Search for a user ~ Salesforce - Unlimited Edition").build()); 
					browser.highlight();
					
					
				browser.describe(Page.class, new PageDescription.Builder()
							.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
							.name(frameName).build()).describe(EditField.class, new EditFieldDescription.Builder().xpath(inputTextBoxXpath).build()).highlight();
				browser.describe(Page.class, new PageDescription.Builder()
						.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
						.name(frameName).build()).describe(EditField.class, new EditFieldDescription.Builder().xpath(inputTextBoxXpath).build());.setValue(inputTextName);
				
					
				fnEnterInputTextInWindowFrame=true;
					
				}
				catch(Throwable t)
				{
					fnEnterInputTextInWindowFrame =false;
					System.out.println(t.getMessage());
				}
				return fnEnterInputTextInWindowFrame;
			}

			
			 * #FunctionName : clickingTableLinkInFrame # No of Parameter : 4 #
			 * Description : Function to click link in table frame based on page title..
			 * Parameters and its data-type :Browser browser,String pageTitle,String frameName,String linkName
			 * Developed on : 31/07/2017 # Developed By : Rajesh 
			 * # Return Type : boolean
			 * #########################################################################
			 * ###########
			 
			public static boolean clickingTableLinkInFrame(Browser browser,String pageTitle,String frameName,String linkName)
			{
				boolean clickingTableLinkInFrame=false;
				try
				{
			
					Link lnk=browser.describe(Page.class, new PageDescription.Builder()
							.title("Salesforce - Unlimited Edition").build()).describe(Frame.class, new FrameDescription.Builder()
							.name("066A0000001XCIx").build()).describe(Table.class, new TableDescription.Builder()
							.tagName("TABLE").build()).describe(Link.class, new LinkDescription.Builder()
							.xpath("//FORM[1]/TABLE[1]/TBODY[1]/TR[2]/TD[1]/A[1]").tagName("A").build());
					lnk.highlight();
					lnk.click();
				
				}
				catch(Throwable t)
				{
					System.out.println(t.getMessage());
				}
				return true;
			}
			
			
			 * #FunctionName : fnClickButtonInTableWindowFrame # No of Parameter : 3 #
			 * Description : Function to click button in a frame based on user inputs..
			 * Parameters and its data-type :Browser browser,String pageTitle,String frameName,String buttonXpath
			 * Developed on : 03/08/2017 # Developed By : Rajesh 
			 * # Return Type : boolean
			 * #########################################################################
			 * ###########
			 
			public static boolean fnClickButtonInTableWindowFrame(Browser browser,String pageTitle,String frameName,String buttonXpath)
			{
				boolean fnClickButtonInTableWindowFrame=false;
			
				try
				{
					browser.describe(Page.class, new PageDescription.Builder()
							.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
							.id(frameName).build()).describe(Table.class, new TableDescription.Builder()
							.tagName("TABLE").innerText(" Contacts ").build()).describe(Button.class, new XPathDescription(buttonXpath)).highlight();
					
					browser.describe(Page.class, new PageDescription.Builder()
							.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
							.id(frameName).build()).describe(Table.class, new TableDescription.Builder()
							.tagName("TABLE").innerText(" Contacts ").build()).describe(Button.class, new XPathDescription(buttonXpath)).click();
					
					fnClickButtonInTableWindowFrame=true;
					
				}
				catch(Throwable t)
				{
					fnClickButtonInTableWindowFrame =false;
					System.out.println(t.getMessage());
				}
				return fnClickButtonInTableWindowFrame;
			}
			
			 * #FunctionName : fnSwitchToTableInWindowFrame # No of Parameter : 3 #
			 * Description : Function to Switch to table in a frame using table locator..
			 * Parameters and its data-type :Browser browser,String pageTitle,String frameName,String tableXpath
			 * Developed on : 03/08/2017 # Developed By : Rajesh 
			 * # Return Type : boolean
			 * #########################################################################
			 * ###########
			 
			public static boolean fnSwitchToTableInWindowFrame(Browser browser,String pageTitle,String frameName,String tableXpath)
			{
				boolean fnSwitchToTableInWindowFrame=false;
			
				try
				{
					Table tbl=browser.describe(Page.class, new PageDescription.Builder()
							.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
									.id(frameName).build()).describe(Table.class, new XPathDescription(tableXpath));
					tbl.highlight();
					List<TableRow> rowCount= tbl.getRows();
					int totalRowCount = rowCount.size();
					
					fnSwitchToTableInWindowFrame=true;
					
				}
				catch(Throwable t)
				{
					fnSwitchToTableInWindowFrame =false;
					System.out.println(t.getMessage());
				}
				return fnSwitchToTableInWindowFrame;
			}
			
			
			 * #FunctionName : clickFieldValueOfSection # No of Parameter : 4 #
			 * Description : Function to click Value of a field in a section based on
			 * user inputs related to field name/key.. # Parameters and its data-type :
			 * Browser browser,String fieldName, String sectionXpath #
			 * Developed on : 07/08/2017 # Developed By : Rajesh & Durga # Return
			 * type : String
			 * #########################################################################
			 * ###########
			 
			public static String clickFieldValueOfSection(Browser browser, String fieldName,String sectionXpath) {
				String fieldValue = null;
				try {
					boolean fnStatus = false;
					fnStatus = isElementExist(browser, sectionXpath);
					if (fnStatus == true) {
						String tableXpath =sectionXpath; sectionXpath.concat("//table");
						int rowCount = getSectionTableRowCount(browser, tableXpath);
						outerloop: for (int j = 1; j <= rowCount; j++) 
						{
							String allTdTagsXpath = tableXpath + "//tr[" + j + "]/td";
							WebElement[] rowTdElements = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
							int tdElementCount = rowTdElements.length;
							for (int k = 0; k <= tdElementCount - 1; k++) {
								int h = k;

								if (k % 2 == 0) {
									String tdElementText = rowTdElements[k].getInnerText();
									if (tdElementText.equals(fieldName)) {
										h++;
										// Checking for child tags..
										String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]//a";
									Link[] tdChildElements = rowTdElements[h].findChildren(Link.class, new LinkDescription.Builder().xpath(tdChildtagsXpath).build());
										int tdchildCount = tdChildElements.length;

										if (tdchildCount > 1)
										{
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
						//softAssert.fail(sectionXpath + "Section is not available");
					}
				} catch (Throwable t) {
					System.out.println("The Exception for clickFieldValueOfSection is : " + t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for clickFieldValueOfSection is : " + t.getMessage());
					}
				return fieldValue;
			}
			
			
				
				public static List<String> getInputButtonsOfSection( String sectionXpath,Browser browser) {
					List<String> buttonList = new ArrayList<String>();
					try {
						String allButtonsXpath = sectionXpath.concat("//input");
						
						WebElement[] allChild=browser.findChildren(WebElement.class, new XPathDescription(allButtonsXpath));
				
						for (WebElement buttonText:allChild)
						{
							//buttonText.getTitle();
							System.out.println(buttonText.getTitle());
							buttonList.add(buttonText.getTitle());
						}

					} 
					catch (Throwable t)
					{
						System.out.println("The Exception for getInputButtonsOfSection is : " + t.getMessage());
						utility.fnLogging("The Exception for getInputButtonsOfSection is : " + t.getMessage());
						ReportEvent.testStepReport("", "fail", "The Exception for getInputButtonsOfSection is : " + t.getMessage());
					}

					return buttonList;
				}
				
				
				 * #FunctionName : fieldAvailabilityValidation # No of Parameter : 3 #
				 * Description : Function to check availability of fields of any
				 * section/page.. # Parameters and its data-type : Browser browser, String sectionXpath, String inputFieldValues
				 *  # Developed on : 04/08/2017 #
				 * Developed By : Rajesh # Return type : boolean # Note : All
				 * input fields needs to be separated by Comma(,).
				 * #########################################################################
				 * ###########
				 
				

				public static boolean buttonsAvailabilityValidation(Browser browser, String inputFieldValues,String buttonXpath) {
					int matchedFieldCounter = 0;
					boolean buttonsAvailabilityValidation = false;
					try {
						String splitInputFields[] = inputFieldValues.split(",");
						List<String> splitInputFieldsList = new ArrayList<String>();
						splitInputFieldsList = Arrays.asList(splitInputFields);
						int inputFieldCount = splitInputFieldsList.size();
						List<String> pageSource = getInputButtonsOfSection(buttonXpath,browser);
						for (int i = 0; i <=inputFieldCount-1;i++ ) {
							if (pageSource.contains(splitInputFieldsList.get(i))) {
								matchedFieldCounter++;
							} 
							else 
							{
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
						//softAssert.fail("The Exception for fieldAvailabilityValidation is : " + t.getMessage());
						buttonsAvailabilityValidation = false;
					}

					return buttonsAvailabilityValidation;
				}
			
				
				 * #FunctionName : gettingBusinessDays # No of Parameter : 1 #
				 * Description : Function to getting business days excluding weekends(Saturday & Sunday)
				 * # Parameters and its data-type : int days
				 *  # Developed on : 19/09/2017
				 * Developed By : Rajesh 
				 * # Return type : String 
				 * #########################################################################
				 * ###########
				 
			
				public static String gettingBusinessDays(int days)
				{
					
					java.util.Date date=new java.util.Date();
					Calendar calendar = Calendar.getInstance();
					date=calendar.getTime(); 
				    SimpleDateFormat s=new SimpleDateFormat("M/dd/yyyy");
				    System.out.println(s.format(date));
				    for(int i=0;i<days;)
				    {
				        calendar.add(Calendar.DAY_OF_MONTH, 1);
				        
				        if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
				        {
				            i++;
				        }

				    }
				    date=calendar.getTime(); 
				    String businessDays=date.toString();
				    System.out.println(s.format(date));
				   return businessDays;
					}
				
				
			
			
		
		public static boolean fnSwitchToFrameNameByPageTitle(Browser browser,String pageTitle,String frameName)
		{
			boolean fnSwitchToFrameNameByPageTitle=false;
		
			try
			{
				browser=BrowserFactory.attach(new BrowserDescription.Builder().title("Search for a user ~ Salesforce - Unlimited Edition").build()); 
				browser.highlight();
				
				browser.describe(Page.class, new PageDescription.Builder()
						.title(pageTitle).build()).describe(Frame.class, new FrameDescription.Builder()
						.name(frameName).build()).highlight();
				fnSwitchToFrameNameByPageTitle=true;
				
			}
			catch(Throwable t)
			{
				fnSwitchToFrameNameByPageTitle =false;
			}
			return fnSwitchToFrameNameByPageTitle;
		}



	





		
		*//***
		 * #FunctionName : clickingFieldValueOfSectionBasedOnLabel
		 * Description : Function to click link Value of a field in a section based on
		 * 				 user inputs related to field name/key..
		 * Author : N.Durgasivaramprasad
		 * Developed on : 19/09/2017
		 * @param browser
		 * @param fieldName
		 * @param sectionXpath
		 * @return boolean
		 * 
		 *//*
		
		
		public static boolean clickingFieldValueOfSectionBasedOnLabel(Browser browser, String fieldName,String sectionXpath) 
		{
			String fieldValue = null;
			boolean clickingFieldValueOfSectionBasedOnLabel = false;
			
			try {
				boolean fnStatus = false;
				fnStatus = isElementExist(browser, sectionXpath);
				if (fnStatus == true) {
					String tableXpath =sectionXpath.concat("//table");
					int rowCount = getSectionTableRowCount(browser, tableXpath);
					outerloop: for (int j = 1; j <= rowCount; j++) 
					{
						String allTdTagsXpath = tableXpath + "//tr[" + j + "]/td";
						WebElement[] rowTdElements = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
						int tdElementCount = rowTdElements.length;
						for (int k = 0; k <= tdElementCount - 1; k++) {
							int h = k;

							if (k % 2 == 0) {
								String tdElementText = rowTdElements[k].getInnerText();
								if (tdElementText.equals(fieldName)) 
								{
									h++;
									// Checking for child tags..
									String tdChildtagsXpath = allTdTagsXpath + "[" + (h + 1) + "]//a";
									Link aTagElement = browser.describe(Link.class, new XPathDescription(tdChildtagsXpath));
									aTagElement.click();
									clickingFieldValueOfSectionBasedOnLabel = true;
									break outerloop;
								} 
								else {
									continue;
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
					//softAssert.fail(sectionXpath + "Section is not available");
				}
			} catch (Throwable t) {
				System.out.println("The Exception for clickingFieldValueOfSectionBasedOnLabel is : " + t.getMessage());
				ReportEvent.testStepReport("", "fail", "The Exception for clickingFieldValueOfSectionBasedOnLabel is : " + t.getMessage());
				}
			return clickingFieldValueOfSectionBasedOnLabel;
		}
		

		
		*//***
		 * #FunctionName : selectingDateBasedOnLabel
		 * Description : Function to select date Value of a label in a section based on
		 * 				 user inputs related to label and input date..
		 * Author : N.Durgasivaramprasad
		 * Developed on : 19/09/2017
		 * @param browser
		 * @param fieldName
		 * @param sectionXpath
		 * @return boolean
		 * 
		 *//*
		public static final String datePickerTable = "//table[@class ='outer']//following-sibling::div[@class='datePicker']";
		public static boolean selectingDateBasedOnLabel(Browser browser, String sectionXpath, String fieldName, String inputDate)
		{
			boolean selectingDateBasedOnLabel = false;
			try
			{
				boolean fnStatus =false;
				fnStatus = isElementExist(browser, sectionXpath);
				if(fnStatus==true)
				{
					String tableXpath =sectionXpath.concat("//table");
					int rowCount = getSectionTableRowCount(browser, tableXpath);
					outerloop :	for(int i=1;i<=rowCount;i++)
					{
						String allTdTagsXpath = tableXpath+"//tr["+i+"]/td";
						WebElement[] allTdTags = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(allTdTagsXpath).build());
						for(int j=0;j<allTdTags.length;j++)
						{
							int k=j;
							if(j%2==0)
							{
								String childElementsXpath = allTdTagsXpath+"["+(j+1)+"]/*";
								WebElement[] allChilds = browser.findChildren(WebElement.class, new WebElementDescription.Builder().xpath(childElementsXpath).build()); 
								if(allChilds.length!=0)
								{
									for(int l=0;l<allChilds.length;l++)
									{
										String tagName = allChilds[l].getTagName();
										if(tagName.equalsIgnoreCase("label"))
										{
											String labelXpath = allTdTagsXpath+"["+(j+1)+"]//label";
											WebElement label = browser.describe(WebElement.class, new WebElementDescription.Builder().xpath(labelXpath).build());
											String labelName = label.getInnerText();
											if(labelName.equalsIgnoreCase(fieldName))
											{
												String fieldValueXpath = allTdTagsXpath+"["+(j+2)+"]//input";
												WebElement inputDateText = browser.describe(WebElement.class, new XPathDescription(fieldValueXpath));
												inputDateText.click();
												fnStatus = datePicker(browser, datePickerTable, dateConversion(inputDate, "FullMonth/dd/yyyy"));
												if(fnStatus==true)
												{
													System.out.println("Selected " + fieldName+", as : " + inputDate +" successfully.");
													selectingDateBasedOnLabel = true;
													break outerloop;
												}
												else
												{
													System.out.println("Failed to select inputDate as "+ inputDate );
													selectingDateBasedOnLabel = false;
												}
											}
											else
											{
												continue;
											}
										
										}
									}
									
									
								}
								else
								{
									String tdXpath = allTdTagsXpath+"["+(j+1)+"]";
									String tdTagText = (browser.describe(WebElement.class, new WebElementDescription.Builder().xpath(tdXpath).build()).getInnerText());
									if(tdTagText.equalsIgnoreCase(fieldName))
									{
										String fieldValueXpath = allTdTagsXpath+"["+(j+2)+"]//input";
										WebElement inputDateText = browser.describe(WebElement.class, new XPathDescription(fieldValueXpath));
										inputDateText.click();
										fnStatus = datePicker(browser, datePickerTable, dateConversion(inputDate, "FullMonth/dd/yyyy"));
										if(fnStatus==true)
										{
											System.out.println("Selected " + fieldName+", as : " + inputDate +" successfully.");
											selectingDateBasedOnLabel = true;
											break outerloop;
										}
										else
										{
											System.out.println("Failed to select inputDate as "+ inputDate );
											selectingDateBasedOnLabel = false;
										}
									}
									else
									{
										continue;
									}
									
								}
								
							}
							else
							{
								continue;
							}
						
						}
					
					}
				}
				else
				{
					System.out.println("Section with Xpath : "+sectionXpath + ", doesn't exist.");
				}
						
				
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
			}
			return selectingDateBasedOnLabel;
			
		}
	
			*/
	
	public static boolean verifyingRecentViewBCidSideBar(Browser browser,String inputId)
	{
		boolean verifyingRecentViewBCidSideBar=false;
		try
		{
	
			Table tbl=browser.describe(Page.class, new PageDescription.Builder()
					.title("Salesforce - Unlimited Edition").build()).describe(Frame.class, new FrameDescription.Builder()
					.name("066A0000001XCIx").build()).describe(Table.class, new TableDescription.Builder()
					.tagName("TABLE").build());
			Link lk=tbl.describe(Link.class, new LinkDescription.Builder()
					.xpath("//FORM[1]/TABLE[1]/TBODY[1]/TR[2]/TD[1]/A[1]").tagName("A").build());
		String bcId=lk.getInnerText();
		if(bcId.equals(inputId))
		{
			ReportEvent.testStepReport("", "pass", "Verified Benefit Claimed ID :"+bcId+" in Current Benefit Claimed side bar!!");
			verifyingRecentViewBCidSideBar = true;
		}
		else 
		{
			ReportEvent.testStepReport("", "FAIL", "Failed to Verify Benefit Claimed ID in side bar.");
			verifyingRecentViewBCidSideBar = false;
		}
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		return true;
	}

	
	public static boolean checkingDropDownValues(Browser browser,  String labelName, String inputValues)
	{
		
		boolean checkingDropDownValues = false;
		int matchedvalueCounter =0;
		try
		{
			String inputValArray[] =inputValues.split(",");
			List<String> inputValueList = Arrays.asList(inputValArray);
			String immediateParentXpath = "//label[text()='"+labelName+"']/..";
			outerloop:
			for(int level =1;level<=6;level++)
			{
				String parentXpath = immediateParentXpath;
				String parentLevel ="/..";
				WebElement immediateParent=browser.describe(WebElement.class, new XPathDescription(parentXpath));
				String parentTagName = immediateParent.getTagName();
				if(parentTagName.equalsIgnoreCase("td"))
				{
					String dropdownXpath = parentXpath+"/following-sibling::td[1]//select";
					ListBox listItems=browser.describe(ListBox.class, new XPathDescription(dropdownXpath));
					List<ListItem> allOptions = listItems.getItems();
					for(ListItem allValues:allOptions)
					{
						for(String inputValue : inputValueList)
						{
							if(allValues.getText().equalsIgnoreCase(inputValue))
							{
								matchedvalueCounter++;
							}
							else
							{
								continue;
							}
						}
					}
					if(matchedvalueCounter==inputValueList.size())
					{
						checkingDropDownValues=true;
						break outerloop;
					}
					else
					{
						checkingDropDownValues=false;
					}
					
				}
				else
				{
					parentXpath = parentXpath+parentLevel;
				}
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Exception message is : "+t.getMessage());
		}
		return checkingDropDownValues;
	}

	
	
	
	
	
	
	
	
	
	
	
}

	
	
