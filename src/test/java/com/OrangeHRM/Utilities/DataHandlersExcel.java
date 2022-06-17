package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlersExcel {

	static File f;
	static FileInputStream fis;
	static FileOutputStream fos;
	static Workbook wb;
	static Sheet st;
	static Row r;
	static Cell c;

	public static String readExcelData(String filePath, String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {

		String data = null;
		f = new File(filePath);
		fis = new FileInputStream(f);
		wb = WorkbookFactory.create(fis);
		
		st = wb.getSheet(sheetName);
		r = st.getRow(rowIndex);
		c = r.getCell(cellIndex);
		data = c.toString();
		return data;

	}

	public static void writeDataToExcel(String filePath, String sheetName, int rowIndex, int cellIndex, String data)
			throws EncryptedDocumentException, IOException {

		try {
			f = new File(filePath);
			fis = new FileInputStream(f);
			wb = WorkbookFactory.create(fis);
			
			st = wb.getSheet(sheetName);
			r = st.getRow(rowIndex);
			c = r.getCell(cellIndex);
			
			c.setCellValue(data);
			fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
}
