package com.sic.accelerators;
/**
 * @author Subrto Sarkar
 * ActionEngine.java
 * Feb 4, 2017
 */

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.ListItem;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

import java.util.List;


import com.hp.lft.sdk.stdwin.EditField;
import com.hp.lft.sdk.stdwin.EditFieldDescription;

public class ActionEngine_Dialog extends TestEngine {
	static Browser browser;
	static String text;
	
				/*		
				####################################################################################
				##############################
				# Function Name : fnEditFieldDialog
				# No of Parameter : 8
				# Description   : Enter a value in the text field of dialog box
				# Parameters and its datatype : boolean ownedWindow, boolean childWindow, String windowsSecurity, String nativeClass, int windowId, int index, String setText
				# Developed on : 02/06/2017
				# Developed By : Subrato Sarkar
				####################################################################################
				##############################	
				*/
	
	
				public static boolean fnEditFieldDialog(Browser browser, boolean ownedWindow, boolean childWindow, String windowsSecurity, String nativeClass, int windowId, int index, String setText) throws GeneralLeanFtException{
							try{
									browser.describe(Dialog.class, new DialogDescription.Builder()
							    			.ownedWindow(ownedWindow).childWindow(childWindow).text(windowsSecurity).nativeClass(nativeClass).build()).describe(EditField.class, new EditFieldDescription.Builder()
							    			.attachedText("").windowId(windowId).nativeClass("Edit").index(index).build()).setText(setText);
									return true;
							}catch(Throwable t){
									System.out.println("The Exception for fnEditFieldDialog  is : "+t.getMessage());
									utility.fnLogging("The Exception for fnEditFieldDialog  is : "+t.getMessage());
									ReportEvent.testStepReport("", "fail", "The Exception for fnEditFieldDialog is : "+t.getMessage());
									return false;
							}

					
				}
				
				/*		
				####################################################################################
				##############################
				# Function Name : fnButtonClickDialog
				# Description   : Clicking ok button in dialog box
				# Developed on : 02/07/2017
				# Developed By : Subrato Sarkar
				####################################################################################
				##############################	
				*/		
				
				public static void fnDialogOk(Browser browser,String text,String dText) throws Throwable{
					
					browser.describe(Dialog.class, new DialogDescription.Builder()
							.text(dText).build()).describe(Button.class, new ButtonDescription.Builder()
							.text(text).build()).click();
					}
				
				public static void handleDialogue(Browser browser) throws GeneralLeanFtException {
					Dialog dialog = browser.describe(Dialog.class, new DialogDescription.Builder().ownedWindow(true)
							.childWindow(false).text("standard.com needs some information").nativeClass("#32770").build());
					if (dialog.exists()) {
						dialog.describe(Button.class, new ButtonDescription.Builder().text("Cancel").nativeClass("Button").build())
								.click();
					} else {
						System.out.println("No dialogue box appeared");
					}
				}
				/*		
				####################################################################################
				##############################
				# Function Name : fnOKorCancelButtonInDialodBox
				# No of Parameter : 2
				# Description   : Clicking OK or Cancel button based on User inputs in dialog box.
				# Parameters and its datatype : Browser browser,String buttonName
				# Developed on : 25/07/2017
				# Developed By : Rajesh
				####################################################################################
				##############################	
				*/		//"OK"
				public static boolean fnOKorCancelButtonInDialodBox(Browser browser, String PopUpTitle,String buttonName) throws GeneralLeanFtException{
					
					try
					{
						browser.describe(Dialog.class, new DialogDescription.Builder()
								.windowTitleRegExp(PopUpTitle/*"Message from webpage"*/).build()).describe(Button.class, new ButtonDescription.Builder()
								.windowTitleRegExp(buttonName).build()).highlight();
						browser.describe(Dialog.class, new DialogDescription.Builder()
								.windowTitleRegExp(PopUpTitle/*"Message from webpage"*/).build()).describe(Button.class, new ButtonDescription.Builder()
								.windowTitleRegExp(buttonName).build()).click();
						/*browser.describe(Dialog.class, new DialogDescription()).describe(Button.class, new ButtonDescription.Builder()
								.windowTitleRegExp(buttonName).build()).highlight();
						browser.describe(Dialog.class, new DialogDescription()).describe(Button.class, new ButtonDescription.Builder()
								.windowTitleRegExp(buttonName).build()).click();*/
						return true;
					}
					catch(Throwable t)
					{
								System.out.println("The Exception for fnOKorCancelButtonInDialodBox  is : "+t.getMessage());
								utility.fnLogging("The Exception for fnOKorCancelButtonInDialodBox  is : "+t.getMessage());
								ReportEvent.testStepReport("", "fail", "The Exception for fnOKorCancelButtonInDialodBox is : "+t.getMessage());
								return false;
					}
					
					
				}
}
