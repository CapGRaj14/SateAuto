package PageObjects;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.web.Browser;

public class MyTest {
	
	public static void handleDialogue(Browser browser) throws GeneralLeanFtException{
		Dialog dialog=browser.describe(Dialog.class, new DialogDescription.Builder()
				.ownedWindow(true).childWindow(false).text("standard.com needs some information").nativeClass("#32770").build());
		if(dialog.exists()){
			dialog.describe(Button.class, new ButtonDescription.Builder().text("Cancel").nativeClass("Button").build()).click();
		}else{
			System.out.println("No dialogue box appeared");
		}
	}

	public static void maximizeScreen(Browser browser) throws GeneralLeanFtException{
	/*Dimension dim=browser.getSize();	
	System.out.println(dim);*/
	browser.resizeTo(1366,673);
	}
}
