package PageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.XPathDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;
import com.sic.utilities.utility;

public class ContractsPage_CV extends DriverScript
{
	public static int generatedNo;
	public static String configFilepath = System.getProperty("user.dir")+"\\config.properties"; 
	public static int policyIdValue ;
	public static String sectionContractDetail = "//h2[text()='Contract Detail']/../ancestor::div[1]/following-sibling::div[@class='pbBody']/child::div[@class='pbSubsection']";

	//Function to validate auto populated Account name with input data..
	public static boolean validatePopulatedAccountName(Browser browser, String labelName, String inputAccountName)
	{
		boolean validatePopulatedAccountName = false;
		String appText = null;
		try
		{
			appText = GenericClass.getAutoPopulatedValueOfTextBoxByLabel(browser, labelName);
			if(appText.equalsIgnoreCase(inputAccountName))
			{
				ReportEvent.testStepReport(tTestCaseName, "pass", inputAccountName + " : is auto populating as expected.");
				validatePopulatedAccountName = true;
			}
			else
			{
				ReportEvent.testStepReport(tTestCaseName, "Fail", inputAccountName + " : is NOT auto populated.");
				validatePopulatedAccountName = false;
			}
		}
		catch(Throwable t)
		{
			System.out.println("The Exception for validatePopulatedAccountName is : "+t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for validatePopulatedAccountName is : "+t.getMessage());
			softAssert.fail("The Exception for validatePopulatedAccountName is : "+t.getMessage());
			errorCount++;
		}
	return validatePopulatedAccountName;	
	}


	//Function to randomly generate contract no.
	
	public static int generateRandomNo()
	{
		int randomNo = 0;
		try
		{
			Random randomObj = new Random();
			randomNo = randomObj.nextInt(999999);
			
			if(randomNo<99999)
			{
				while(randomNo<99999 && randomNo>=0)
				{
					
					randomNo = randomObj.nextInt(999999);
					if(randomNo>=100000 && randomNo<1000000 && randomNo!=0)
					{
						generatedNo=randomNo;
						break;
					}
					else
					{
						continue;
					}
				}
			}
			else
			{
				generatedNo=randomNo;
			}
			ReportEvent.testStepReport(tTestCaseName, "pass","Generated No :" + generatedNo);
			//System.out.println("Generated No :" + generatedNo);
		}
		catch(Throwable t)
		{
			System.out.println("The Exception for generateRandomNo is : "+t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for generateRandomNo is : "+t.getMessage());
			softAssert.fail("The Exception for generateRandomNo is : "+t.getMessage());
			errorCount++;
		}
		return randomNo;
	}
	
	
	
	/*//Assigning generated Random no. to config file..
	public static void assignPolicyIDInConfigPropFile()
	{
		try
		{
			OutputStream output = null;
			
			File file = new File(configFilepath);
			FileReader frReader = new FileReader(file);
			Properties prop = new Properties();
			prop.load(frReader);
			policyIdValue = Integer.parseInt(prop.getProperty("policyID"));
			generatedNo = generateRandomNo();
			String updatedPolicyIDValue = Integer.toString(generatedNo);
			output = new FileOutputStream(file);
			if(policyIdValue!=generatedNo)
			{
				prop.setProperty("policyID",updatedPolicyIDValue);
				prop.setProperty("NewData",updatedPolicyIDValue);
				prop.store(output, "");
			}
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		
	}
	
*/	
	//Assign value to Contract No.
	
	public static void enterContractNo(Browser browser, String labelName, String inputValue)
	{
		GenericClass.sendKeysToTextBoxByLabel(browser, labelName, inputValue);
	}
	
	//Function to click on either Save Or Save & New Or Cancel button of "Task Edit", Page based on the user inputs..
		public static boolean  clickButtonOfNewContractPage(Browser browser, String buttonName)
		{
		boolean clickButtonOfTaskEditPage = false;
		try
		{
			boolean fnStatus = false;
			String buttonXpath = "//h2[text()='Contract Edit']/../../../..//input[@class='btn' and @title ='" + buttonName + "']";                    
			fnStatus = isElementExist(browser, buttonXpath);
			if(fnStatus ==true)
			{
				fnStatus = fnButtonClick(browser, buttonXpath);
				if(fnStatus ==true)
				{
					ReportEvent.testStepReport(tTestCaseName, "Pass", "Clicked on " + buttonName + ", button successfully.");
					clickButtonOfTaskEditPage = true;
				}
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "FAIL", "Failed to click on " + buttonName + ", button.");
					softAssert.fail( "Failed to click on " + buttonName + ", button.");
					errorCount++;
					clickButtonOfTaskEditPage = false;
				}
				
			}
			else
			{
				ReportEvent.testStepReport(tTestCaseName, "FAIL", buttonXpath + ", element is not available.");
				softAssert.fail(buttonXpath + ", element is not available.");
				errorCount++;
				clickButtonOfTaskEditPage = false;
			}
		}
		catch(Throwable t)
		{
			System.out.println("The Exception for clickButtonOfTaskEditPage is : "+t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickButtonOfTaskEditPage is : "+t.getMessage());
			softAssert.fail("The Exception for clickButtonOfTaskEditPage is : "+t.getMessage());
			errorCount++;
			clickButtonOfTaskEditPage = false;
		}
		return  clickButtonOfTaskEditPage;
		
	} 

		//Assigning generated Random no. to config file..
			public static boolean  assignPolicyIDInConfigPropFile()
			{
				boolean assignPolicyIDInConfigPropFile= false;
				try
				{
					OutputStream output = null;
					File file = new File(configFilepath);
					FileReader frReader = new FileReader(file);
					Properties prop = new Properties();
					prop.load(frReader);
					String updatedPolicyIDValue = Integer.toString(policyIdValue);
					output = new FileOutputStream(file);
					prop.setProperty("policyID",updatedPolicyIDValue);
					prop.store(output, "");
					int crossCheck = Integer.parseInt(prop.getProperty("policyID"));
					
					if(crossCheck==policyIdValue)
					{
						/*System.out.println("Saved 'policID' as : " + policyIdValue + " in config file");*/
						assignPolicyIDInConfigPropFile = true;
					}
					else
					{
						System.out.println("Failed to save the 'policID' as : " + policyIdValue + " in config file");
						assignPolicyIDInConfigPropFile = false;
					}
					
				}
				catch(Throwable t)
				{
					System.out.println(t.getMessage());
				}
				
				return assignPolicyIDInConfigPropFile;
			}
			
	//Function to chk if the random no. is already used or not.
	
	
	public static void createContract(Browser browser, String labelAccountName, String inputAccountName,
			String labelContract, String buttonName)
	{
		boolean isErrorVisibile = false;
		try
		{
			boolean fnStatus = false;
			fnStatus =validatePopulatedAccountName(browser, labelAccountName, inputAccountName);
			if(fnStatus==true)
			{
				do  
				{
					policyIdValue = generateRandomNo();
					enterContractNo(browser, labelContract, String.valueOf(policyIdValue));
					clickButtonOfNewContractPage(browser, buttonName);
					String errorXpath = "//div[@class='errorMsg' and text()=' Duplicate value on record: ']";
					WebElement errorMsg = browser.describe(WebElement.class, new XPathDescription(errorXpath));
					isErrorVisibile = errorMsg.exists();
				}
				while (isErrorVisibile==true);
				if(isErrorVisibile==false)
				{
					ReportEvent.testStepReport(tTestCaseName, "pass", "Contract was created with Policy ID : "+ policyIdValue);
					fnStatus = assignPolicyIDInConfigPropFile();
					GenericClass.reportlogger(fnStatus,tTestCaseName,"Saved 'policyID' as : " + policyIdValue + " in config.Properties file ");
				}	
			}
			else
			{
				ReportEvent.testStepReport(tTestCaseName, "Fail", inputAccountName +" : is NOT auto populated in Account name field.");
				//System.out.println(inputAccountName +" : is NOT auto populated in Account name field.");
			}
			
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("The Exception for createContract  is :",t);
		}
		
	}
	
	
	//Function to click AccountName link
	
	public static void clickAccountNameLink(Browser browser, String fieldName)
	{
		   boolean clickAccountNameLink=false;
		try
		{
			boolean fnStatus = false;
			fnStatus=GenericClass.clickingFieldValueOfSectionBasedOnLabel(browser, fieldName, sectionContractDetail);
			GenericClass.reportlogger(fnStatus,tTestCaseName,"label related link successfully.");
		}
		catch(Throwable t)
		{
			GenericClass.Catchhandler("The Exception for clickAccountNameLink is :",t);
			}
	}



}
