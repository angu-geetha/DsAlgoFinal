package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	
	
	public static String readCell(String sheetName, String rowNo, String coloumnNo) {
		
		String cellContents = null;
		try {
			FileInputStream file = new FileInputStream(new File("./src/test/resources/excel/dsAlgoInput.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			 XSSFSheet sheet = workbook.getSheet(sheetName);
			 Row row = sheet.getRow(Integer.parseInt(rowNo));
			 Cell cell = (Cell) row.getCell(Integer.parseInt(coloumnNo));
			 cellContents = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellContents;
	}
	
	
	public static String[][] readRegisterData(String fileName) throws IOException {
		FileInputStream file = new FileInputStream(new File("./src/test/resources/excel/dsAlgoInput.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(fileName.trim());
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowCount][colCount];
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value =dft.formatCellValue(cell);
				data[i-1][j]=value;
				//String value = cell.getStringCellValue();
				//System.out.println(value);
			}
			//System.out.println("************");
		}
		workbook.close();
		return data;

	}
}
