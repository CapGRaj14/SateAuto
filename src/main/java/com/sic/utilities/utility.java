package com.sic.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.sic.support.ExtentManager;

import freemarker.log.Logger;
import org.apache.commons.codec.binary.Base64;

//import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class utility {

	public static String pathScreenshotCapturedPassedSteps;
	public static String pathScreenshotCapturedFailedSteps;
//	static File dir;
	public static String folderPathGeneratedForFailedScreenshot;
	public static String folderPathGeneratedWithFailedScreenshot;
	public static String folderPathGeneratedForFailedScreenshotFinal;
	public static int countOfscreeshotCaptureExecuted = 0;
	public static int countOfScreenshotCaptured=0;
    
	public static String screeshotCapture() throws Exception
    {		    			
    	//if(fnReadPropFile("screenshot_err").equalsIgnoreCase("Y")){
    					
			    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			        Calendar now = Calendar.getInstance();
			        Robot robot = new Robot();
			        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			        ImageIO.write(screenShot, "JPG", new File(System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensFail")+"\\Screenshot_"+formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_")+".jpg"));
			//        System.out.println(formatter.format(now.getTime()));
			        
			        pathScreenshotCapturedFailedSteps = System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensFail")+"\\Screenshot_"+formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_")+".jpg";
			        System.out.println (pathScreenshotCapturedFailedSteps);
			        return pathScreenshotCapturedFailedSteps;
   
    		
	}
	public static String passscreeshotCapture() throws Exception
    {		    			
    	//if(fnReadPropFile("screenshot_err").equalsIgnoreCase("Y")){
    					
			    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			        Calendar now = Calendar.getInstance();
			        Robot robot = new Robot();
			        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			        ImageIO.write(screenShot, "JPG", new File(System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensPass")+"\\Screenshot_"+formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_")+".jpg"));
			//        System.out.println(formatter.format(now.getTime()));
			        
			        pathScreenshotCapturedPassedSteps = System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensPass")+"\\Screenshot_"+formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_")+".jpg";
			        System.out.println (pathScreenshotCapturedPassedSteps);
			        return pathScreenshotCapturedPassedSteps;
   
    			
    }
	
	
	
	/*public static String screeshotCapture() throws Exception
    {		    			
    	//if(fnReadPropFile("screenshot_err").equalsIgnoreCase("Y")){
    					
			    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			        Calendar now = Calendar.getInstance();
			        Robot robot = new Robot();
			        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			        ImageIO.write(screenShot, "JPG", new File(System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensFail")+"\\Screenshot_"+formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_")+".jpg"));
			        pathScreenshotCapturedFailedSteps = System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensFail")+"\\Screenshot_"+formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_")+".jpg";
			        ArrayList<String> imageList = new ArrayList<String>();
			        while(countOfScreenshotCaptured>=0){
			        		imageList.add(countOfScreenshotCaptured, pathScreenshotCapturedFailedSteps);
			        }
			        countOfScreenshotCaptured++;
			        System.out.println("Count of screenshot taken for the current execution: "+countOfScreenshotCaptured);	
			        System.out.println (pathScreenshotCapturedFailedSteps);
			        return pathScreenshotCapturedFailedSteps;
   
    			
    }*/
	
	/*
	public static String screeshotCapture() throws Exception
    {		    			
    	//if(fnReadPropFile("screenshot_err").equalsIgnoreCase("Y")){
					boolean fnStatus=false;	
			        	while(countOfscreeshotCaptureExecuted==0){
			        			folderPathGeneratedForFailedScreenshot = System.getProperty("user.dir")+utility.fnReadPropFile("testResulsScreensFail")+"\\ScreenshotForFailedSteps_"+getCurrDateWithTime();	
			        			createNewDirectory(folderPathGeneratedForFailedScreenshot);
			        			countOfscreeshotCaptureExecuted++;
			        	}
			        	 folderPathGeneratedForFailedScreenshotFinal = folderPathGeneratedForFailedScreenshot;
					        	Robot robot = new Robot();
						        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
						        ImageIO.write(screenShot, "JPG", new File(folderPathGeneratedForFailedScreenshotFinal+"\\Screenshot_"+getCurrDateWithTime()+".jpg"));
						        System.out.println (folderPathGeneratedForFailedScreenshotFinal);
						        return folderPathGeneratedForFailedScreenshotFinal+"\\Screenshot_"+getCurrDateWithTime()+".jpg";
    }
	*/
    
    public static  String fnLogging(String outputToBeLogged){
		    	Logger logger = Logger.getLogger("devpinoyLogger");
		    	logger.debug(outputToBeLogged);
				return outputToBeLogged;
    }
    
    public static String logging(String outputToBeLogged){
	    	Logger logger = Logger.getLogger("devpinoyLogger");
	    	logger.debug(outputToBeLogged);
			return outputToBeLogged;
    }
    
    
	public static String fnReadPropFile(String strVal) throws IOException{
		
	//	try{
				
			String path=System.getProperty("user.dir")+"\\config.properties";
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream(path);
		//	System.out.println(System.getProperty("user.dir"));
			prop.load(fs);
			System.out.println(prop.getProperty(strVal));
			return prop.getProperty(strVal);
/*		}catch(Throwable t){
				System.out.println(t.getMessage());
		}
		return strVal;
*/		
	}
	
	public static String getProperty(String strVal) throws IOException{
				String path=System.getProperty("user.dir")+"\\config.properties";
				Properties prop = new Properties();
				FileInputStream fs = new FileInputStream(path);
				prop.load(fs);
				System.out.println(prop.getProperty(strVal));
				return prop.getProperty(strVal);
		}
	
	
	public static String fnPasswordEncoding(String strToBeEncoded){
				
			byte[] encodedValue = Base64.encodeBase64(strToBeEncoded.getBytes());
			System.out.println("Encoded String -> "+ new String(encodedValue));
			return encodedValue.toString();
				
	}
	public static String fnPasswordDecoding(String strToBeDecoded){
		
		byte[] valueDecoded= Base64.decodeBase64(strToBeDecoded.getBytes());
		System.out.println("Decoded value is " + new String(valueDecoded));
		return valueDecoded.toString();
		}

	/*		
	####################################################################################
	##############################
	# Function Name : appWait
	# No of Parameter : 1
	# Description   : Static wait depends as per user's inout
	# Parameters and its datatype : Integer
	# Developed on : 02/11/2017
	# Developed By : Subrato Sarkar
	####################################################################################
	##############################	
	*/
	
		public static void appWait(int timeout){
					
					try{
								Thread.sleep(timeout);
					}catch(Throwable t){
								System.out.println("The Exception for appWait  is : "+t.getMessage());
								utility.fnLogging("The Exception for appWait  is : "+t.getMessage());
					}
			
		}
		
		
		/*		
		####################################################################################
		##############################
		# Function Name : appSync
		# No of Parameter : 1
		# Description   : Static wait depends as per user's input
		# Parameters and its datatype : Integer
		# Developed on : 03/06/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/
		
			public static void appSync(int timeout){
						
						try{
									Thread.sleep(timeout*1000);
						}catch(Throwable t){
									System.out.println("The Exception for appWait  is : "+t.getMessage());
									utility.fnLogging("The Exception for appWait  is : "+t.getMessage());
						}
				
			}
		
		
		/*		
		####################################################################################
		##############################
		# Function Name : htmlReportPathGenerated
		# No of Parameter : 1
		# Description   : To know the HTML report path generated dynamically
		# Parameters and its datatype : String
		# Developed on : 02/21/2017
		# Developed By : Subrato Sarkar
		####################################################################################
		##############################	
		*/
public static String htmlReportPathGenerated(){
			try{
					System.out.println("Path of the HTML report generated dynamically : "+ExtentManager.dynamicHtmlReportPath);
					return ExtentManager.dynamicHtmlReportPath;
			}catch(Throwable t){
				System.out.println("The Exception for htmlReportPathGenerated  is : "+t.getMessage());
				utility.fnLogging("The Exception for htmlReportPathGenerated  is : "+t.getMessage());
				return null;
			}
							
}
		

public static String openHTMLReport(String htmlReportPath) throws IOException{
			if (fnReadPropFile("htmlReportToBeOpen").toUpperCase().equals("Y")){
				
				File file = new File(htmlReportPathGenerated());
		        
		        //first check if Desktop is supported by Platform or not
		        if(!Desktop.isDesktopSupported()){
		            System.out.println("Desktop is not supported");
		            utility.fnLogging("Desktop is not supported");
		        }
		        
		        Desktop desktop = Desktop.getDesktop();
		       if(file.exists()) desktop.open(file);
		        		return htmlReportPath;
				}else{
						return null;
				}
				
	}



public static boolean openHTMLReport() throws IOException{
	if (fnReadPropFile("htmlReportToBeOpen").toUpperCase().equals("Y")){
		
		File file = new File(htmlReportPathGenerated());
        
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            utility.fnLogging("Desktop is not supported");
        }
        
        Desktop desktop = Desktop.getDesktop();
       if(file.exists()) desktop.open(file);
        		return true;
		}else{
				return false;
		}
		
}


/*		
####################################################################################
##############################
# Function Name : getCurrDateWithTime
# No of Parameter : 0
# Description   : To get the current time
# Parameters and its datatype : String
# Developed on : 02/21/2017
# Developed By : Subrato Sarkar
####################################################################################
##############################	
*/
public static String getCurrDateWithTime(){
	
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Calendar now = Calendar.getInstance();
  //  System.out.println(formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_"));
	return formatter.format(now.getTime()).toString().replace("/", "_").replace(":", "_").replace(" ", "_");
}
			


public static String createNewDirectory(String pathDir){
	
			File file = new File(pathDir);
	        if (!file.exists()) {
	            if (file.mkdir()) {
	                	System.out.println("Directory is created!");
	                	return pathDir;
	            } else {
	                	System.out.println("Failed to create directory!");
	                	return null;
	            }
	        }else{
	        	System.out.println("Directory has already been created!");
	        	return pathDir;
	      }

}



/*public static void explicitWaitForElementToAppear(boolean elementToBeTested) throws GeneralLeanFtException{
	int nTime =1;   		
	boolean isExistElement = false;
	while(nTime<360){							
		isExistElement = elementToBeTested;
			if(isExistElement == true){
				nTime = 360;
				System.out.println("Element Aappeared");
				utility.fnLogging("Element Aappeared");
			}
			nTime++;
	}
}*/

public static String printStringInDoubleQuotes(String elementToBePrintedInDoubleQuotes){
			try{
				return ("\"" + elementToBePrintedInDoubleQuotes + "\"");
			}catch(Throwable t){
				System.out.println("The Exception for printStringInDoubleQuotes  is : "+t.getMessage());
				utility.fnLogging("The Exception for printStringInDoubleQuotes  is : "+t.getMessage());
				return null;
			}
			
}


/*		
####################################################################################
##############################
# Function Name : assignNewAccountName
# No of Parameter : 0
# Description   : To print a New account for OPUS application, this function is designed exclusively for OPUS application
# Parameters and its datatype : NA
# Developed on : 03/01/2017
# Developed By : Subrato Sarkar
####################################################################################
##############################	
*/

		public static String assignNewAccountName(){
			Date date = new Date();
	       SimpleDateFormat sdf = new SimpleDateFormat("MMdd_hhmmss"); 
	       String formattedDate = sdf.format(date);
	      // System.out.println(formattedDate + "_" + "NM");
	       return formattedDate + "_" + "NM_Auto_Reg_Phase1";
			
	}
}
