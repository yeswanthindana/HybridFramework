package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	
	//Data Provider 1
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException{
		String path =".\\testData\\testData_login.xlsx"; //taking excel from test Data
		
		excelUtility ex = new excelUtility(path); // Creating an object for excel utility file
		
		int totalroows = ex.getRowCount("Sheet1");
		int totalcols = ex.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalroows][totalcols]; //created 2-d array where data can be stored
		 
		for(int i=1;i<=totalroows;i++) // 1 , cread data from excel storing i
		{
			
			for(int j=0;j<totalcols;j++) { //0 , i is row and j is  column
				logindata[i-1][j] = ex.getCellData("Sheet1", i, j); // 1, 0 reason why i-1 is bcoz array row starts from 0
			}
						
		}

		return logindata;
		
	}
	
	//Data Provider 2
	
	// Data provider 3

}
