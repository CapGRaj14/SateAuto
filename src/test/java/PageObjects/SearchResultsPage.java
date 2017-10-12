package PageObjects;

import java.util.LinkedHashMap;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.sic.base.DriverScript;
import com.sic.support.ReportEvent;

public class SearchResultsPage extends DriverScript 
{

	
	/***
	 * clickLinkOfSearchResultsSection
	 * Description :Function to search the input text in Search results page based on sectionExample: sectionName : Account, searchText : STD Only #1
			 		Can be used for searching benefit  Claim(sectionName :Benefit Claim),
		     		Claim(sectionName : Claim), Contact (sectionName : Contact) and Policy(sectionName : Policy)
	 * @param browser
	 * @param sectionName
	 * @param searchText
	 */
	
	public static boolean clickLinkOfSearchResultsSection(Browser browser, String sectionName, String searchText)
	{
		boolean clickLinkOfSearchResultsSection=false;
		String xpath = null;
		String sectionXpath = null;
		boolean fnStatus = false;
		LinkedHashMap<String, String> sectionXpathMapping = new LinkedHashMap<String, String>(); 
		
		try
		{
			sectionXpathMapping.put("Account", "Account");
			sectionXpathMapping.put("Benefit Claim", "cve__BenefitClaimed__c");
			sectionXpathMapping.put("Claim", "cve__Claim__c");
			sectionXpathMapping.put("Contact", "Contact");
			sectionXpathMapping.put("Policy", "cve__Policy__c");
		
		if(sectionXpathMapping.containsKey(sectionName))
		{
			xpath = sectionXpathMapping.get(sectionName);
			sectionXpath = "//div[@id ='"+xpath+"']/../..//child::div[@id ='"+xpath+"']//div[@class='pbBody']";
			fnStatus = isElementExist(browser, sectionXpath);
			if(fnStatus==true)
			{
				String tableXpath = sectionXpath + "//table";
				fnStatus = isElementExist(browser, tableXpath);
				if(fnStatus == true)
				{
					int rowCount = GenericClass.fngetTableRowCount(browser, tableXpath);
					if(rowCount>1)
					{
					outerloop:
					for(int i=1; i<=rowCount; i++)
					{
						String aTagXpath = tableXpath.concat("//th/a");
						Link[] aTags=browser.findChildren(Link.class, new LinkDescription.Builder().xpath(aTagXpath).build());
						for (Link cellText : aTags)
						{
								if(cellText.getInnerText().equals(searchText))
								{
									cellText.highlight();
									cellText.click();
									ReportEvent.testStepReport(tTestCaseName, "pass", "Clicked on :"+cellText+" successfully");
									break outerloop;
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
						ReportEvent.testStepReport(tTestCaseName, "Fail", "No records are available in the table.");
						//System.out.println("No records are available in the table.");
					}
				}
				else
				{
					ReportEvent.testStepReport(tTestCaseName, "Fail", "Search Benefit Claimed dynamic table is not available");
					//System.out.println("Search Benefit Claimed dynamic table is not available");
					errorCount++;
					
				}
				
			}
			else
			{
				ReportEvent.testStepReport(tTestCaseName, "Fail", sectionName+": section is not available.");
				//System.out.println(sectionName+": section is not available.");
			}
		}
		else
		{
			ReportEvent.testStepReport(tTestCaseName, "Fail", "Please check the sectionName which is passed as input.");
			//System.out.println("Please check the sectionName which is passed as input."); 
			
		}
		
		
		}
		
		catch(Throwable t)
		{
			System.out.println("The Exception for clickLinkOfSearchResultsSection is : "+t.getMessage());
			ReportEvent.testStepReport("", "fail", "The Exception for clickLinkOfSearchResultsSection is : "+t.getMessage());
			softAssert.fail("The Exception for clickLinkOfSearchResultsSection is : "+t.getMessage());
			errorCount++;
		}
		return clickLinkOfSearchResultsSection;
	}
	
}
