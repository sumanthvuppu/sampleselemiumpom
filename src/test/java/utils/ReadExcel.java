package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	static final String currentDirectoryPath=System.getProperty("user.dir");
	 static FileInputStream in;
	 static XSSFWorkbook wb;
	public static void main(String[] args) {
	
		try {
			in = new FileInputStream(currentDirectoryPath+"/userCredentials.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
try {
	 wb = new XSSFWorkbook(in);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

XSSFSheet sheet=wb.getSheet("users");


System.out.println("last row number "+ sheet.getLastRowNum());
//System.out.println(sheet.getRow(0).getCell(0));
		
	//System.out.println("last col number"+row.getLastCellNum());	
	for(int i=0;i<=sheet.getLastRowNum();i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			System.out.print(row.getCell(j).toString()+"               ");
			
		}
		
		System.out.println();
		
	}
		
	}

}
