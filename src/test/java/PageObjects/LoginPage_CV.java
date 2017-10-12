package PageObjects;

import com.hp.lft.sdk.web.Browser;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

public class LoginPage_CV extends DriverScript {

	public static String txtUsername = "//label[text()='Username']/..//input[@name='username']";
	public static String txtPassword = "//label[text()='Password']/..//input[@name='pw']";
	public static String btnLoginToSandbox = "//input[@name='Login']"/* "//input[@value='Log In to Sandbox']" */;

	public static void loginToClaimVantage(String testCaseName, Browser browser, String userName, String password) {
		try {
			boolean fnStatus = false;
			// Enter UserName
			fnStatus = fnEditFieldTextEntry(browser, txtUsername, userName);
			GenericClass.reportlogger(fnStatus, testCaseName, "User name is entered as:" + userName);

			// Enter Password
			fnStatus = fnEditFieldTextEntry(browser, txtPassword, password);
			GenericClass.reportlogger(fnStatus, testCaseName, "Password is entered as:" + password);
			// Click on LoginToSandbox button
			fnStatus = fnButtonClick(browser, btnLoginToSandbox);
			GenericClass.reportlogger(fnStatus, testCaseName, "LoginToSandbox button is clicked");
			Thread.sleep(6000);

			browser.highlight();
		} catch (Exception t) {

			GenericClass.Catchhandler("The Exception for loginToClaimVantage is:", t);
		}
	}

}
