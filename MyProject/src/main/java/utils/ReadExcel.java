package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
		
public static String[][] getExcelData() throws IOException {
	
	String filelocator  ="./Test-data/Login.xlsx" ;
	XSSFWorkbook wbook= new XSSFWorkbook(filelocator);
	XSSFSheet sheet = wbook.getSheetAt(0);
	int lastRowNum = sheet.getLastRowNum();                       // no. of rows 
	System.out.println("no.of rows= "+lastRowNum);                // testng exclude header row (1st)by default
	int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();   // TO include header row
	System.out.println("Includes header row= "+physicalNumberOfRows);
	short lastCellNum = sheet.getRow(0).getLastCellNum();          
	System.out.println("lastCellNum= "+lastCellNum);
	String[][] data= new String[lastRowNum][lastCellNum];
	/*for (int i =1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
		for (int j = 0; j <2; j++) {
		
			XSSFCell cell = row.getCell(j); 
			DataFormatter dft= new DataFormatter();            // this will convert any datatype to string
			String CellValue = dft.formatCellValue(cell);
//			String stringCellValue = cell.getStringCellValue();
         	//System.out.println(CellValue);
			data[i-1][j]=CellValue;                            //i-1 bcz we are excluding header but arrayindex start from
			                                                   //00 ,null pointer exception will come
			*/
	for (int i =1; i <= lastRowNum; i++) {
		for (int j = 0; j <2; j++) {
			//System.out.println( sheet.getRow(i).getCell(j).getStringCellValue());
		data[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
		}
		
  		//or data[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue(); //if (int i =0; i<lastRowNum; i++) 
                                               //but we want to exclude header and store this data in array as data[0][0]
		//}
		wbook.close();	
	}
	return data;
	
}

}

