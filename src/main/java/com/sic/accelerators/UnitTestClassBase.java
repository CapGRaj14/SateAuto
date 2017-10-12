package com.sic.accelerators;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.Button;
import com.hp.lft.sdk.stdwin.ButtonDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.unittesting.TestNgUnitTestBase;
import com.sic.utilities.SendMail;

import com.sic.utilities.Zip;
import com.sic.utilities.utility;

public class UnitTestClassBase extends TestNgUnitTestBase {
    
    @BeforeSuite(alwaysRun=true)
    public void baseBeforeSuite() throws Exception{
        suiteSetup();
    }
    public void UnitTestClassBase(){
    	
    }

    @BeforeClass(alwaysRun=true)
    public void baseBeforeClass(ITestContext ctx) throws Exception {
        String[] context = { ctx.getSuite().getName(), ctx.getName(), this.getClass().getName() };
        className.set(this.getClass().getName());
        classSetup(context);
    }

    @BeforeMethod(alwaysRun=true)
    public void baseBeforeMethod(Object[] arguments, ITestContext ctx, Method method) throws Exception {
        String methodName = super.getMethodName(method, arguments);
        String[] context = { ctx.getSuite().getName(), ctx.getName(), this.getClass().getName(), methodName };
        testName.set(methodName);
        testSetup(context);
    }

    @AfterMethod(alwaysRun=true)
    public void baseAfterMethod(ITestResult result) throws Exception {
        testTearDown();
        setStatus(result.getStatus() == ITestResult.FAILURE ? Status.Failed : Status.Passed);
    }

    @AfterClass(alwaysRun=true)
    public void baseAfterClass(ITestContext ctx) throws Exception {
        classTearDown();
    }

    @AfterSuite(alwaysRun=true)
    public void baseAfterSuite() throws Exception {
    	/* suiteTearDown();
        getReporter().generateReport();*/
        Zip.zipFile();
        
		if(utility.fnReadPropFile("SendMail").equalsIgnoreCase("True")){	
			
			try {
				SendMail.attachReportsToEmail();
			} catch (Exception e) {
				//logger.debug(e.getMessage());
				utility.fnLogging(e.getMessage());
			}
			
					
		} 
		/*try {
		utility.openHTMLReport(utility.htmlReportPathGenerated());
		} catch (Exception e) {
			//logger.debug(e.getMessage());
			utility.fnLogging(e.getMessage());
		}*/
		
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

    @Override
    protected String getTestName() {
        return testName.get();
    }

    @Override
    protected String getClassName() {
        return className.get();
    }

    protected ThreadLocal<String> className = new ThreadLocal<String>();
    protected ThreadLocal<String> testName = new ThreadLocal<String>();
}