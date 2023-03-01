package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	static final String currentDirectoryPath=System.getProperty("user.dir");
static 	XSSFWorkbook workbook;
static XSSFSheet sheet;
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fo=new FileOutputStream(currentDirectoryPath+"/writeData.xlsx");
		
		workbook=new XSSFWorkbook();
	sheet=	workbook.createSheet("sample1");
	
	for(int i=0;i<2;i++) {
		XSSFRow row=	sheet.createRow(i);
		
		for(int j=0;j<2;j++) {
			 XSSFCell cell=row.createCell(j);	
			 System.out.println("Enter data ");
			 Scanner scanner=new Scanner(System.in);
			 cell.setCellValue(scanner.next());
		}
		
	}
	
	
	 
	
		
		workbook.write(fo);
		fo.close();
		
		
		
		
	}
	
}
