/**
 * This class  contains generic function that's specific to Selenium WebDriver and Test set on AUT
 * 
 * @author Pavan Koppu
 * @since June 2017
 */

package com.sic.accelerators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Page;
import com.sic.utilities.SendMail;
import com.sic.utilities.Zip;
import com.sic.utilities.utility;

public class TestEngine {
	public static Browser browser;


		/*
	 * Function to get the parameters from the Environment.properties File
	 * 
	 */
	public static String getPageSource(Browser browser) throws GeneralLeanFtException{
		return browser.getVisibleText();
}
	public static String loadEnvironment(String strEnv, String strValue) throws IOException {

		File file = new File("Environment.properties");
		FileInputStream input = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(input);
		String strComplete = strEnv.concat(strValue);
		//System.out.println("getting URL for " + strCompleteURL);
		System.out.println(properties.getProperty(strComplete));
		return properties.getProperty(strComplete);
	}

	
	/*
	 * Function to send an email including test results
	 * 
	 */
	@AfterSuite(alwaysRun = true)
	public void baseAfterSuite() throws Exception {

		Zip.zipFile();

		if (utility.fnReadPropFile("SendMail").equalsIgnoreCase("True")) {

			try {
				SendMail.attachReportsToEmail();
			} catch (Exception e) {

				utility.fnLogging(e.getMessage());
			}

		}
	}

}
