package com.sic.accelerators;
/**
 * @author Subrto Sarkar
 * ActionEngine.java
 * Feb 4, 2017
 */



//import com.HCL_SIC.utlities.utility;
//import com.HCL_SIC.utilities.*;
//import com.HCL_SIC.utilities.ExtentManager;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.winforms.Button;
import com.hp.lft.sdk.winforms.ButtonDescription;
import com.hp.lft.sdk.winforms.ComboBox;
import com.hp.lft.sdk.winforms.ComboBoxDescription;
import com.hp.lft.sdk.winforms.EditField;
import com.hp.lft.sdk.winforms.EditFieldDescription;
import com.hp.lft.sdk.winforms.ListView;
import com.hp.lft.sdk.winforms.ListViewDescription;
import com.hp.lft.sdk.winforms.Window;
import com.hp.lft.sdk.winforms.WindowDescription;
import com.hp.lft.unittesting.TestNgUnitTestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;
import com.hp.lft.sdk.winforms.WindowDescription;


//import com.hp.lft.sdk.*;


public class ActionEngine extends TestEngine{


	// WindowDescription
		public static WindowDescription windowDescription(boolean childWindow, boolean ownedWindow, String objectName,
				String windowTitleRegExp) {
			WindowDescription windowDescription = new WindowDescription.Builder().childWindow(childWindow)
					.ownedWindow(ownedWindow).objectName(objectName).windowTitleRegExp(windowTitleRegExp).build();
			return windowDescription;
		}
		

		// EditFieldDescription
		public static EditFieldDescription editFieldDescription(String objectName) {
			EditFieldDescription editFieldDescription = new EditFieldDescription.Builder().objectName(objectName).build();
			return editFieldDescription;
		}
		public static EditFieldDescription editFieldDescription(String objectName,String fullNamePath,String fullType) {
			EditFieldDescription editFieldDescription = new EditFieldDescription.Builder().objectName(objectName)
					.fullNamePath(fullNamePath)
					.fullType(fullType).build();
			return editFieldDescription;
		}
		public static EditFieldDescription editFieldDescription(int windowId,String nativeClass,int index) {
			EditFieldDescription editFieldDescription = new EditFieldDescription.Builder().windowId(windowId).nativeClass(nativeClass).index(index).build();
			return editFieldDescription;
		}
		
		/*		
		####################################################################################
		##############################
		# Function Name : editFieldDescription
		# No of Parameter : 10
		# Description   : To Enter the data in window Textfield
		# Parameters and its datatype : boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String fullNamePath, String fullType, String text, String windowTitleRegExp, int index, String objectNameWinformEdit, String setText
		# Developed on : 02/04/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/
		
		public static String editFieldDescription(boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String fullNamePath, String fullType, String text, String windowTitleRegExp, int index, String objectNameWinformEdit, String setText) throws GeneralLeanFtException {
					
							/*Desktop.describe(Window.class, new WindowDescription.Builder()
									.childWindow(false).ownedWindow(true).objectName(objectNameWinformWin).fullNamePath(fullNamePath).fullType(fullType).text(text).windowTitleRegExp(windowTitleRegExp).index(index).build()).describe(EditField.class, new EditFieldDescription.Builder()
									.objectName(objectNameWinformEdit).build()).setText(" ");*/
							
							Desktop.describe(Window.class, new WindowDescription.Builder()
									.childWindow(childWindow).ownedWindow(ownedWindow).objectName(objectNameWinformWin).fullNamePath(fullNamePath).fullType(fullType).text(text).windowTitleRegExp(windowTitleRegExp).index(index).build()).describe(EditField.class, new EditFieldDescription.Builder()
									.objectName(objectNameWinformEdit).build()).setText(setText);
							
							String getText = Desktop.describe(Window.class, new WindowDescription.Builder()
									.childWindow(ownedWindow).ownedWindow(ownedWindow).objectName(objectNameWinformWin).fullNamePath(fullNamePath).fullType(fullType).text(text).windowTitleRegExp(windowTitleRegExp).index(index).build()).describe(EditField.class, new EditFieldDescription.Builder()
									.objectName(objectNameWinformEdit).build()).getText();
									System.out.println("editFieldDescription with 10 paramter is executed successfully");
									return getText;

									
			}
		
			
		/*		
		####################################################################################
		##############################
		# Function Name : editFieldDescription
		# No of Parameter : 6
		# Description   : To Enter the data in window Textfield
		# Parameters and its datatype : boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String fullNamePath, String fullType, String text, String windowTitleRegExp, int index, String objectNameWinformEdit, String setText
		# Developed on : 02/04/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/
			public static String editFieldDescription(boolean childWindow, boolean ownedWindow, String frmBnftPeriod, String windowTitleRegExp, String txtID3BnftPrdDysNbr, String setText ) throws GeneralLeanFtException{
							
						Desktop.describe(Window.class, new WindowDescription.Builder()
								.childWindow(childWindow).ownedWindow(ownedWindow).objectName(frmBnftPeriod).windowTitleRegExp(windowTitleRegExp).build()).describe(EditField.class, new EditFieldDescription.Builder()
								.objectName(txtID3BnftPrdDysNbr).build()).setText(setText);
						
						String getText=Desktop.describe(Window.class, new WindowDescription.Builder()
								.childWindow(childWindow).ownedWindow(ownedWindow).objectName(frmBnftPeriod).windowTitleRegExp(windowTitleRegExp).build()).describe(EditField.class, new EditFieldDescription.Builder()
								.objectName(txtID3BnftPrdDysNbr).build()).getText();
						return getText;
			}
		
		
		// ComboBoxDescription
		public static ComboBoxDescription comboBoxDescription(String objectName) {
			ComboBoxDescription comboBoxDescription = new ComboBoxDescription.Builder().objectName(objectName).build();
			return comboBoxDescription;
		}
		
		/*		
		####################################################################################
		##############################
		# Function Name : comboBoxDescription
		# No of Parameter : 6
		# Description   : To Enter the data in window Textfield
		# Parameters and its datatype : boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String windowTitleRegExp, String objectNameWinformLst, String selectVal
		# Developed on : 02/04/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/
		
		public static String comboBoxDescription(boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String windowTitleRegExp, String objectNameWinformLst, String selectVal) throws GeneralLeanFtException {
							
							Desktop.describe(Window.class, new WindowDescription.Builder()
	    							.childWindow(childWindow).ownedWindow(ownedWindow).objectName(objectNameWinformWin).windowTitleRegExp(windowTitleRegExp).build()).describe(ComboBox.class, new ComboBoxDescription.Builder()
	    							.objectName(objectNameWinformLst).build()).select(selectVal);
							String getText = Desktop.describe(Window.class, new WindowDescription.Builder()
	    							.childWindow(childWindow).ownedWindow(ownedWindow).objectName(objectNameWinformWin).windowTitleRegExp(windowTitleRegExp).build()).describe(ComboBox.class, new ComboBoxDescription.Builder()
	    							.objectName(objectNameWinformLst).build()).getText();	
									System.out.println("comboBoxDescription with 6 paramter is executed successfully");
									return getText;			
			}
		
		
		/*		
		####################################################################################
		##############################
		# Function Name : comboBoxDescription
		# No of Parameter : 6
		# Description   : To Enter the data in window Textfield
		# Parameters and its datatype : boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String windowTitleRegExp, String objectNameWinformLst, String selectVal
		# Developed on : 02/04/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/
		
		public static void listViewDescription(boolean childWindow, boolean ownedWindow, String objectName, String windowTitleRegExp, String objectNameWinformLst, String selectVal) throws GeneralLeanFtException {
			
/*					Desktop.describe(Window.class, new WindowDescription.Builder()
							.childWindow(false).ownedWindow(false).objectName("frmBnftPeriod").windowTitleRegExp("IDM_BNFT_PERIOD").build()).describe(ListView.class, new ListViewDescription.Builder()
							.objectName("lvwBnftPeriod").build()).select(3);*/
					
							Desktop.describe(Window.class, new WindowDescription.Builder()
									.childWindow(childWindow).ownedWindow(ownedWindow).objectName(objectName).windowTitleRegExp(windowTitleRegExp).build()).describe(ListView.class, new ListViewDescription.Builder()
									.objectName(objectNameWinformLst).build()).select(Integer.valueOf(selectVal));
							System.out.println("comboBoxDescription with 6 paramter is executed successfully");		
}
		
		
		// ButtonDescription
		public static ButtonDescription buttonDescription(String objectName) {
			ButtonDescription buttonDescription = new ButtonDescription.Builder().objectName(objectName).build();
			return buttonDescription;
		}
		public static ButtonDescription buttonDescription(String text,String nativeClass) {
			ButtonDescription buttonDescription = new ButtonDescription.Builder().text(text).nativeClass(nativeClass).build();
			return buttonDescription;
		}
		
		/*		
		####################################################################################
		##############################
		# Function Name : buttonDescription
		# No of Parameter : 5
		# Description   : To click a winbutton
		# Parameters and its datatype : boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String windowTitleRegExp, String objectNameWinformBtn
		# Developed on : 02/03/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/		
		public static void buttonDescription(boolean childWindow, boolean ownedWindow, String objectNameWinformWin, String windowTitleRegExp, String objectNameWinformBtn) throws GeneralLeanFtException{
			
						Desktop.describe(Window.class, new WindowDescription.Builder()
								.childWindow(childWindow).ownedWindow(ownedWindow).objectName(objectNameWinformWin).windowTitleRegExp(windowTitleRegExp).build()).describe(Button.class, new ButtonDescription.Builder()
								.objectName(objectNameWinformBtn).build()).click();	
								System.out.println("buttonDescription with 5 parameters is executed successfully");
								
			}
		

		// ListViewDescription
		public static ListViewDescription listViewDescription(String objectName) {
			ListViewDescription listViewDescription = new ListViewDescription.Builder().objectName(objectName).build();
			return listViewDescription;
		}

		// DialogDescription
		public static DialogDescription dialogDescription(boolean ownedWindow, boolean childWindow, String text,
				String nativeClass) {
			DialogDescription dialogDescription = new DialogDescription.Builder().ownedWindow(true).childWindow(false)
					.text(text).nativeClass(nativeClass).build();
			return dialogDescription;


       }
//***************************************************************************************************************************
//																							keywords for OPUS
//***************************************************************************************************************************
		
		
		public static boolean fnEditFieldDDescription(boolean childWindow, boolean ownedWindow, String objNameWindow, String windowTitleRegExp, String objNameEditField, String setText){
				
					try{
							
								Desktop.describe(Window.class, new WindowDescription.Builder()
										.childWindow(childWindow).ownedWindow(ownedWindow).objectName(objNameWindow).windowTitleRegExp(windowTitleRegExp).build()).describe(EditField.class, new EditFieldDescription.Builder()
										.objectName(objNameEditField).build()).setText(setText);
								return true;

					}catch(Throwable t){
								System.out.println("The Exception for fnEditFieldDDescription  is : "+t.getMessage());
								utility.fnLogging("The Exception for fnEditFieldDDescription  is : "+t.getMessage());
								ReportEvent.testStepReport("", "fail", "The Exception for fnEditFieldDDescription  is : "+t.getMessage());
								return false;
					}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
