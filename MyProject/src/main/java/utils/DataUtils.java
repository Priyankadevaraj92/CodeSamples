package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider(name="data")
	public String[][] getdata() throws IOException {
//		
//String[][] excelData = ReadExcel.getExcelData();
//		return excelData;
//		
		String[][] data= new String[1][2];     //or  //Object[][] data= new Object[1][2];
		
		data[0][0]="8609895686";
		data[0][1]="Passw0rd";
		return data;
		
	}
}
