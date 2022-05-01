package com.learnautomation.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getStringData(int sheetAT,int row,int col) {
		return wb.getSheetAt(sheetAT).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(String sheet,int row,int col) {
		return wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
	}
	
	public Double getNumericData(String sheet,int row,int col) {
		return wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public static void main(String[] args) {
		ExcelDataProvider dp = new ExcelDataProvider();
		System.out.println(dp.getStringData("Login", 0, 0));
	}
	
	

}
