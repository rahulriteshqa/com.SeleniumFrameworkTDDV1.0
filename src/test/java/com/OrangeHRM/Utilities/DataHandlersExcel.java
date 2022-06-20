package com.OrangeHRM.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHandlersExcel {
	public static String readExcelData(String filePath, int sheetIndex, int rowIndex, int cellIndex) throws IOException {
//Path of the excel file
		FileInputStream fis = new FileInputStream(filePath);
//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		System.out.println(sheet.getRow(rowIndex).getCell(cellIndex));
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
		
		/*
		 * Row row1 = sheet.getRow(1);
		 * 
		 * Cell cell1 = row1.getCell(1); System.out.println(sheet.getRow(0).getCell(1));
		 * Row row2 = sheet.getRow(1); Cell cell2 = row2.getCell(1);
		 * System.out.println(sheet.getRow(1).getCell(0)); Row row3 = sheet.getRow(1);
		 * Cell cell3 = row3.getCell(1);
		 *  
		System.out.println(sheet.getRow(1).getCell(1));
		 */
		
//String cellval = cell.getStringCellValue();
//System.out.println(cellval);
		
	}
	
	public static void writeDataToExcel(String filePath, int sheetIndex, String cellValue) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheetAt(sheetIndex);
		int lastRow = sh.getLastRowNum();
		for(int i=0;i<lastRow;i++) {
			Row r =sh.getRow(i);
			Cell cell = r.createCell(2);
			cell.setCellValue(cellValue);
		}
		
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
		
	}
}