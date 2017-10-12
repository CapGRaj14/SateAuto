/**
 * 
 */
package com.sic.accelerators;



import org.apache.log4j.Logger;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.ComboBoxDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.stdwin.EditFieldDescription;
import com.hp.lft.sdk.stdwin.ListViewDescription;
import com.hp.lft.sdk.stdwin.Menu;
import com.hp.lft.sdk.stdwin.MenuDescription;
import com.hp.lft.sdk.stdwin.StaticDescription;
import com.hp.lft.sdk.stdwin.TabControlDescription;
import com.hp.lft.sdk.stdwin.ToolBarDescription;
import com.hp.lft.sdk.stdwin.TreeView;
import com.hp.lft.sdk.stdwin.TreeViewDescription;
import com.hp.lft.sdk.stdwin.UiObject;
import com.hp.lft.sdk.stdwin.UiObjectDescription;
import com.hp.lft.sdk.stdwin.Window;
import com.hp.lft.sdk.stdwin.WindowDescription;
import com.hp.lft.sdk.winforms.Button;

import com.hp.lft.sdk.winforms.EditField;

import com.hp.lft.sdk.winforms.TableDescription;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

/**
 * @author s003155
 *
 */
public class StdWinActionEngine extends TestEngine  {
	final static Logger logger = Logger.getLogger(StdWinActionEngine.class);
	static WindowDescription windowDescription;
	static EditFieldDescription editFieldDescription;
	static ComboBoxDescription comboBoxDescription;
	static ButtonDescription buttonDescription;
	static ListViewDescription listViewDescription;
	static DialogDescription dialogDescription;
	static TableDescription tableDescription;
	static StaticDescription staticDescription;
	static TabControlDescription tabControlDescription;
	static UiObjectDescription uiObjectDescription;
	static ToolBarDescription toolBardiscription;
	
	// WindowDescription
	public static WindowDescription windowDescriptionWithClassreg(boolean childWindow, boolean ownedWindow, String windowClassRegExp,String windowTitleRegExp) {
		
		try {
			windowDescription = new WindowDescription.Builder().childWindow(childWindow)
					.ownedWindow(ownedWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).build();
		} catch (Exception ex) {
			
			logger.error("Window Object Name: "+windowClassRegExp+" and"+"Window Title RegExp"+windowTitleRegExp+" is mandatory",ex);
			
		}
		return windowDescription;
	}
	
	public static WindowDescription windowDescription(boolean ownedWindow,boolean childWindow, String text, String windowClassRegExp,String windowTitleRegExp,int index) {
		
		try {
			windowDescription = new WindowDescription.Builder()
					.ownedWindow(ownedWindow).childWindow(childWindow).text(text).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).index(index).build();
		} catch (Exception ex) {
			
			logger.error("Window Object Name: "+windowClassRegExp+" and"+"Window Title RegExp"+windowTitleRegExp+" is mandatory",ex);
			
		}
		return windowDescription;
	}
	
	
	
	// EditFieldDescription
	public static EditFieldDescription editFieldDescription(int windowId,String nativeClass) {
		 try {
			editFieldDescription = new EditFieldDescription.Builder().windowId(windowId).nativeClass(nativeClass).build();
			
		} catch (Exception ex) {
			logger.error("Editfield Window ID: "+windowId+"Native class"+nativeClass+"is mandatory",ex);
		}
		return editFieldDescription;
	}

	public static EditFieldDescription editFieldDescription(int windowId, String nativeClass, int index) {
		 try {
			editFieldDescription = new EditFieldDescription.Builder().windowId(windowId)
					.nativeClass(nativeClass).index(index).build();
		} catch (Exception ex) {
			logger.error("Window ID:"+windowId+"nativeClass:"+nativeClass+"index:"+index+"is mandatory",ex);
		}
		return editFieldDescription;
	}

//ComboBoxDescription
	public static boolean selectUiComboBox(boolean ownedWindow,boolean childWindow,String windowClassRegExp,String winTitExp,String uiObjWinClassRegExp,String setText) {
		try {
			
			UiObject uiobj=Desktop.describe(Window.class, new WindowDescription.Builder()
					.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(winTitExp).build()).describe(UiObject.class, new UiObjectDescription.Builder()
							.windowClassRegExp(uiObjWinClassRegExp).build());
			uiobj.highlight();
			uiobj.click();
			uiobj.sendKeys(setText);
			uiobj.click();
			return true;
		} catch (Exception ex) {
			logger.error("objectName is mandatory:",ex);
			return false;
		}
		
	}

	// ButtonDescription
	public static ButtonDescription buttonDescription(String text, String nativeClass) {
	 try {
		buttonDescription = new ButtonDescription.Builder().text(text).nativeClass(nativeClass)
					.build();
	} catch (Exception ex) {
		logger.error("objectName:"+text+"and"+"nativeClass:"+nativeClass+"is mandatory:",ex);
	}
		return buttonDescription;
	}

	// ListViewDescription
	public static ListViewDescription listViewDescription(String nativeClass) {
		
		try {
			listViewDescription = new ListViewDescription.Builder().nativeClass(nativeClass).build();
		} catch (Exception ex) {
			logger.error("objectName:"+nativeClass+"is mandatory:",ex);
		}
		return listViewDescription;
	}
	
public static ListViewDescription listViewDescription(int windowId,String nativeClass,int index) {
		
		try {
			listViewDescription = new ListViewDescription.Builder().nativeClass(nativeClass).build();
		} catch (Exception ex) {
			logger.error("objectName:"+nativeClass+"is mandatory:",ex);
		}
		return listViewDescription;
	}


	// DialogDescription
	public static DialogDescription dialogDescription(boolean ownedWindow, boolean childWindow, String text,
			String nativeClass) {
		try {
			dialogDescription = new DialogDescription.Builder().ownedWindow(true).childWindow(false)
					.text(text).nativeClass(nativeClass).build();
		} catch (Exception ex) {
			logger.error("text:"+text+"and nativeClass:"+nativeClass+"is mandatory:",ex);
		}
		return dialogDescription;

	}
	
	// TableDescription
	public static TableDescription tableDescription(String objectName) {
		try {
			tableDescription = new TableDescription.Builder().objectName(objectName).build();
		} catch (Exception ex) {
			logger.error("objectName:"+objectName+"is mandatory:",ex);
		}
		return tableDescription;
	}
	
	// TabControlDescription
//		public static TabControlDescription tabControlDescription(String objectName) {
//			try {
//				tabControlDescription =new TabControlDescription.Builder()
//				.objectName(objectName).build();
//				
//			} catch (Exception ex) {
//				logger.error("objectName:"+objectName+"is mandatory:",ex);
//			}
//			return tabControlDescription;
//		}
//	
	// StaticDescription
		public static StaticDescription staticDescription(int windowID,
				String nativeClass) {
			try {
				staticDescription = new StaticDescription.Builder().windowId(windowID).nativeClass(nativeClass).build();
			} catch (Exception ex) {
				logger.error("windowId:"+windowID+"and nativeClass:"+nativeClass+"is mandatory:",ex);
			}
			return staticDescription;

		}
		//uiObject EditFieldDescription 2 parameters
		public static UiObjectDescription uiObjectDescription(String uiObjwindowClassRegExp,int uiObjwindowId){
			try{
				uiObjectDescription=new UiObjectDescription.Builder()
						.windowClassRegExp(uiObjwindowClassRegExp).windowId(uiObjwindowId).build();
				
			}catch (Exception ex) {


			}
			return uiObjectDescription;
		}
//UiObject one para
		public static UiObjectDescription uiObjectDescription(String uiObjectwindowClassRegExp)
		{
			uiObjectDescription=new UiObjectDescription.Builder().windowClassRegExp(uiObjectwindowClassRegExp).build();
			return uiObjectDescription;
		}
		public static UiObjectDescription uiObjectDescription(String uiObjectwindowClassRegExp,String text)
		{
			uiObjectDescription=new UiObjectDescription.Builder().windowClassRegExp(uiObjectwindowClassRegExp).build();
			return uiObjectDescription;
		}
	
//	public static boolean stdUiObjectEditField(boolean ownedWindow,boolean childWindow,String windowClassRegExp,String windowTitleRegExp,String uiObjectwindowClassRegExp,int windowid,String setText) throws Throwable
//	{
//		Robot robot=new Robot();
//		Window win;
//		try{
//			win=Desktop.describe(Window.class, new WindowDescription.Builder()
//					.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).build());
//			
//			UiObject obj=win.describe(UiObject.class, new UiObjectDescription.Builder()
//					.windowClassRegExp(uiObjectwindowClassRegExp).windowId(windowid).build());
//			obj.click();
//			Thread.sleep(3000);
//	    	robot.keyPress(KeyEvent.VK_CLEAR);
//	    	obj.sendKeys(setText);
//	    	
//			return true;
//		}catch(Exception e){
//			return false;
//			
//		}
//		
//		
//	}
	//ToolBarDiscription
	public static ToolBarDescription toolBardiscription(String text,String nativeClass)
	{
		try
		{
		toolBardiscription = new ToolBarDescription.Builder().text(text).nativeClass(nativeClass).build();
		}
		catch(Exception e)
		{
			logger.error("text:"+text+"and nativeClass:"+nativeClass+"is mandatory:",e);
			
		}
		return toolBardiscription;
		
		
	}
	//toolBar 2 Parameters
	public static ToolBarDescription toolBardiscription(String windowClassRegExp)
	{
		try
		{
		toolBardiscription = new ToolBarDescription.Builder().windowClassRegExp(windowClassRegExp).build();
		}
		catch(Exception e)
		{
			logger.error("windowClassRegExp:"+windowClassRegExp+"is mandatory:",e);
			
		}
		return toolBardiscription;
		
		
	}
	
	public static boolean fnclick(boolean ownedWindow,boolean childWindow,String text,String windowClassRegExp,String windowTitleRegExp,int index,String windowClassRegExp1,int windowID) throws Throwable{
	Desktop.describe(Window.class, new WindowDescription.Builder()
			.ownedWindow(true).childWindow(false).text("ProBonus Login").windowClassRegExp("ThunderRT6FormDC").windowTitleRegExp("ProBonus Login").index(0).build()).describe(UiObject.class, new UiObjectDescription.Builder()
			.windowClassRegExp("ThunderRT6CommandButton").windowId(4).build()).click();
	return true;
	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : sendKeys
	# No of Parameter : 3
	# Description   : To Enter the data in window Textfield
	# Parameters and its datatype : Window objectName,String editObjectName,String textValue
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static boolean sendKeys(boolean ownedWindow,boolean childWindow,String windowClassRegExp,String winTitExp,String uiObjWinClassRegExp,int windowId,String setText){
		
		try{
			UiObject uiObj=Desktop.describe(Window.class, new WindowDescription.Builder()
					.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(winTitExp).build()).describe(UiObject.class, new UiObjectDescription.Builder()
							.windowClassRegExp(uiObjWinClassRegExp).windowId(windowId).build());
			uiObj.highlight();
			uiObj.click();
			uiObj.sendKeys(setText);
			
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for sendKeys  is : "+t.getMessage());
					utility.fnLogging("The Exception for sendKeys  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for sendKeys  is : "+t.getMessage());
					return false;
		}
		

	}
	
	public static boolean clcik(boolean ownedWindow,boolean childWindow,String windowClassRegExp,String winTitExp,String uiObjWinClassRegExp,int windowId){
		
		try{
			UiObject uiObj=Desktop.describe(Window.class, new WindowDescription.Builder()
					.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(winTitExp).build()).describe(UiObject.class, new UiObjectDescription.Builder()
							.windowClassRegExp(uiObjWinClassRegExp).windowId(windowId).build());
			uiObj.highlight();
			uiObj.click();
			
			
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for sendKeys  is : "+t.getMessage());
					utility.fnLogging("The Exception for sendKeys  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for sendKeys  is : "+t.getMessage());
					return false;
		}
	}
	
	public static String getWindowTitle(boolean ownedWindow, boolean childWindow,String windowClassRegExp) throws GeneralLeanFtException{
		try{
			
		String windowTitle=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(windowClassRegExp).build()).getWindowTitleRegExp();
		
		
		return windowTitle;
		}catch(Exception e){
			return null;
		}
	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : sendKeys
	# No of Parameter : 3
	# Description   : To Enter the data in window Textfield
	# Parameters and its datatype : Window objectName,String editObjectName,String textValue
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static boolean sendKeys(Window objectName,int winID,String nativeClass,String textValue){
		
		try{
			objectName.describe(EditField.class,new EditFieldDescription.Builder().windowId(winID).nativeClass(nativeClass).build()).setText(textValue);
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for sendKeys  is : "+t.getMessage());
					utility.fnLogging("The Exception for sendKeys  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for sendKeys  is : "+t.getMessage());
					return false;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : buttonClick
	# No of Parameter : 2
	# Description   : To click the button
	# Parameters and its datatype : Window objectName,String btnObjectName
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static boolean buttonClick(Window objectName,String text, String nativeClass){
		
		try{

			objectName.describe(Button.class, buttonDescription(text,nativeClass)).click();
			
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for buttonClick  is : "+t.getMessage());
					utility.fnLogging("The Exception for buttonClick  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for buttonClick  is : "+t.getMessage());
					return false;
		}
		

	}
	
	
	/*		
	####################################################################################
	##############################
	# Function Name : Click
	# No of Parameter : 1
	# Description   : To click the button
	# Parameters and its datatype : UiObject uiObj
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static boolean Click(UiObject uiObj){
		
		try{

			uiObj.click();
			
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for buttonClick  is : "+t.getMessage());
					utility.fnLogging("The Exception for buttonClick  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for buttonClick  is : "+t.getMessage());
					return false;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : doubleClick
	# No of Parameter : 1
	# Description   : To doubleClick the button
	# Parameters and its datatype : UiObject uiObj
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static boolean doubleClick(UiObject uiObj){
		
		try{

			uiObj.doubleClick();
			
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for buttonClick  is : "+t.getMessage());
					utility.fnLogging("The Exception for buttonClick  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for buttonClick  is : "+t.getMessage());
					return false;
		}
		

	}
	

	/*		
	####################################################################################
	##############################
	# Function Name : buttonClick
	# No of Parameter : 3
	# Description   : To click the button
	# Parameters and its datatype : Dialog objectName,String text,String nativeClass
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static boolean buttonClick(Dialog objectName,String text,String nativeClass){
		
		try{

			objectName.describe(Button.class, buttonDescription(text,nativeClass)).click();
			
			return true;

		}catch(Throwable t){
					System.out.println("The Exception for buttonClick  is : "+t.getMessage());
					utility.fnLogging("The Exception for buttonClick  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for buttonClick  is : "+t.getMessage());
					return false;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : windowObject
	# No of Parameter : 4
	# Description   : To Create the window object
	# Parameters and its datatype : boolean childWindow, boolean ownWindow, String windowClassRegExp,String windowTitleRegExp
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static Window windowObject(boolean childWindow, boolean ownWindow, String windowClassRegExp,String windowTitleRegExp){
		
		try{

			Window winObj = Desktop.describe(Window.class, new WindowDescription.Builder()
					.ownedWindow(childWindow).childWindow(ownWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).build());
			
			return winObj;

		}catch(Throwable t){
					System.out.println("The Exception for windowObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for windowObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for windowObject  is : "+t.getMessage());
					return null;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : windowObject
	# No of Parameter : 6
	# Description   : To Create the window object
	# Parameters and its datatype : boolean ownedWindow,boolean childWindow, String text, String windowClassRegExp,String windowTitleRegExp,int index
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static Window windowObject(boolean ownedWindow,boolean childWindow, String text, String windowClassRegExp,String windowTitleRegExp,int index){
		
		try{

			Window winObj = Desktop.describe(Window.class, new WindowDescription.Builder()
					.ownedWindow(ownedWindow).childWindow(childWindow).text(text).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).index(index).build());
			
			return winObj;

		}catch(Throwable t){
					System.out.println("The Exception for windowObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for windowObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for windowObject  is : "+t.getMessage());
					return null;
		}
		

	}

	/*		
	####################################################################################
	##############################
	# Function Name : windowObject
	# No of Parameter : 5
	# Description   : To Create the window object
	# Parameters and its datatype :Window argWinObj ,boolean childWindow, boolean ownWindow,String windowClassRegExp,String windowTitleRegExp
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static Window windowObject(Window argWinObj ,boolean childWindow, boolean ownWindow,String windowClassRegExp,String windowTitleRegExp){
		
		try{

			Window winObj = argWinObj.describe(Window.class, new WindowDescription.Builder()
					.ownedWindow(childWindow).childWindow(ownWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).build());
			
			return winObj;

		}catch(Throwable t){
					System.out.println("The Exception for windowObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for windowObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for windowObject  is : "+t.getMessage());
					return null;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : menuObject
	# No of Parameter : 1
	# Description   : To Create the menu object
	# Parameters and its datatype :Window argWinObj
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static Menu menuObject(Window argWinObj){
		
		try{

			Menu menuObj = argWinObj.describe(Menu.class, new MenuDescription.Builder()
					.type(com.hp.lft.sdk.stdwin.MenuType.MENU).build());
			
			return menuObj;

		}catch(Throwable t){
					System.out.println("The Exception for menuObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for menuObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for menuObject  is : "+t.getMessage());
					return null;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : dialogObject
	# No of Parameter : 5
	# Description   :To Create the Dialog object
	# Parameters and its datatype : Window winObj,boolean childWindow, boolean ownWindow,String text,String nativeClass
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static Dialog dialogObject(Window winObj,boolean childWindow, boolean ownWindow,String text,String nativeClass){
		
		try{
			
			Dialog diaObj=winObj.describe(Dialog.class,dialogDescription(true, false, text, nativeClass));
			
			return diaObj;

		}catch(Throwable t){
					System.out.println("The Exception for dialogObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for dialogObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for dialogObject  is : "+t.getMessage());
					return null;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : UIObject
	# No of Parameter : 2
	# Description   :To Create the UI object
	# Parameters and its datatype : Window winObj,String uiObjectwindowClassRegExp
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static UiObject uiObject(Window winObj,String uiObjectwindowClassRegExp){
		
		try{
			
			UiObject uiObj=winObj.describe(UiObject.class, new UiObjectDescription.Builder().windowClassRegExp(uiObjectwindowClassRegExp).build());
			
			return uiObj;

		}catch(Throwable t){
					System.out.println("The Exception for uiObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for uiObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for uiObject  is : "+t.getMessage());
					return null;
		}
		

	}
	
	/*		
	####################################################################################
	##############################
	# Function Name : UIObject
	# No of Parameter : 5
	# Description   :To Create the UI object
	# Parameters and its datatype : Window winObj,boolean childWindow, boolean ownWindow,String text,String nativeClass
	# Developed on : 05/15/2017
	# Developed By : Gowthampandian G
	####################################################################################
	##############################	
	*/
	public static UiObject uiObject(Window winObj,String uiObjectwindowClassRegExp,int uiObjwindowId){
		
		try{
			
			UiObject uiObj=winObj.describe(UiObject.class, new UiObjectDescription.Builder().windowClassRegExp(uiObjectwindowClassRegExp).windowId(uiObjwindowId).build());
			
			return uiObj;

		}catch(Throwable t){
					System.out.println("The Exception for uiObject  is : "+t.getMessage());
					utility.fnLogging("The Exception for uiObject  is : "+t.getMessage());
					ReportEvent.testStepReport("", "fail", "The Exception for uiObject  is : "+t.getMessage());
					return null;
		}
		

	}
	
	//To Handle Dialogue Box
	public static boolean dialogBox(boolean ownedWindow,boolean childWindow, String participantClassRegExp,String mainWintitle,boolean ownedWindow1,boolean childWindow1,String text,String nativClass,String buttonText,String buttonNativeClass) throws Throwable{
	
		try {
			Dialog dialog = Desktop.describe(Window.class, new WindowDescription.Builder()

					.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(participantClassRegExp)
					.windowTitleRegExp(mainWintitle).build())
					.describe(Dialog.class, new DialogDescription.Builder().ownedWindow(ownedWindow1)
							.childWindow(childWindow1).text(text).nativeClass(nativClass).build());

			if (dialog.exists()) {
				dialog.describe(Button.class,
						new ButtonDescription.Builder().text(buttonText).nativeClass(buttonNativeClass).build())
						.click();
				return true;

			} else {
				System.out.println("No Dialog box is present");
				return false;

			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	//Handling Tree view
	
	public static boolean treeView(boolean ownedWindow,boolean childWindow, String windowClassRegExp,String windowTitleRegExp,boolean subownedWindow,boolean subchildWindow, String subwindowClassRegExp,String subindowTitleRegExp,int WindowId,String nativeclass,int Index ,int pos ) throws Throwable{
		try{
		TreeView treeview=Desktop.describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(ownedWindow).childWindow(childWindow).windowClassRegExp(windowClassRegExp).windowTitleRegExp(windowTitleRegExp).build()).describe(Window.class, new WindowDescription.Builder()
				.ownedWindow(subownedWindow).childWindow(subchildWindow).windowClassRegExp(subwindowClassRegExp).windowTitleRegExp(subindowTitleRegExp).build()).describe(TreeView.class, new TreeViewDescription.Builder()
				.windowId(WindowId).nativeClass(nativeclass).index(Index).build());
		
		treeview.activateNode(pos);
		return true;
		
	}catch(Throwable t){
		System.out.println("The Exception for uiObject  is : "+t.getMessage());
		utility.fnLogging("The Exception for uiObject  is : "+t.getMessage());
		ReportEvent.testStepReport("", "fail", "The Exception for uiObject  is : "+t.getMessage());
		return false;

	}
	}
}
