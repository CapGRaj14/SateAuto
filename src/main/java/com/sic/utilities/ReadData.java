package com.sic.utilities;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	ResultSetMetaData rsMetaData ;
	String someEntry =null ;
	int rowIndex;
	String data;
	int rowCount;
	FileInputStream input;
	String DBPassword;
	String msAccDBPath;
	public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");
	public Connection DBConnection(String DBname)
	{
		// Step 1: Loading or registering Oracle JDBC driver class
		System.out.println(DBname);
		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException cnfex) {

			System.out.println("Problem in loading or " + "registering MS Access JDBC driver"); 
			cnfex.printStackTrace();
		}

		// Step 2: Opening database connection
		try {
		
			 msAccDBPath = configProps.getProperty("TestDBPath");
					
			String msAccDB = msAccDBPath + DBname;
						
		//	String msAccDB = "C:\\Users\\s003579\\Workspace\\eb-eeoi-master - Access\\src\\main\\java\\com\\test\\data\\" + DBname ;
			String dbURL = "jdbc:ucanaccess://" + msAccDB +";" + "jackcessOpener=com.sic.utilities.CryptCodecOpener" ; 
			
		// Step 2.A: Create and get connection using DriverManager class
		 DBPassword= 	System.getProperty("DB.password");
				connection = DriverManager.getConnection(dbURL,"",DBPassword); 
					}
		catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
		return connection;
	}


	public int rowCount(String DBtable, String colName)
	{
		try {
			statement =  connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String query = "SELECT Count(*) FROM " + DBtable ;


		try {
			resultSet = statement.executeQuery(query);
			resultSet.next();
			rowCount = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;

	}
	
	public int getnoOfExecutableTestCases(String DBtable, String colName)
	{
		try {
			statement =  connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String query = "SELECT Count(*) FROM " + DBtable + " where " + colName + "= \"" + "Yes" +  "= \"";
		//String query = "SELECT Count(*) FROM " + DBtable + " where tExecute  =  Yes";
		try {
			resultSet = statement.executeQuery(query);
			resultSet.next();
			rowCount = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;

	}


	public void updateTcIndex(String DBtable, String TCID)
	{
		try {
			statement =  connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {


			statement.execute("update " + DBtable + " set tDataUsed='Yes' where tTestCaseID= \"" + TCID + "\"");

		} catch (SQLException e1) {

			e1.printStackTrace();
		}


	}

	public String  getCellData(String DBtable, String colName, String TCID)
	{
		//long start = System.currentTimeMillis(); 
		try {
			statement =  connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String query = "SELECT * FROM " + DBtable +" where  tTestCaseID  = \"" + TCID + "\"" ;
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(resultSet.next()){ 
				data = 	resultSet.getString(colName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		//long timeToLoad= (System.currentTimeMillis()-start);
		//System.out.println(timeToLoad);
		return data;
	}



	public  void closeConnection() {

		// Step 3: Closing database connection
		try {
			if(null != connection) {

				// cleanup resources, once after processing
				resultSet.close();
				statement.close();

				// and then finally close connection
				connection.close();
			}
		}
		catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}