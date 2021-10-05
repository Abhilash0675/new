package com.avesdo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.avesdo.utils.StringUtil;



public class XlsUtils {
	public static Workbook getWorkbook(final String FILE_PATH,
			final String FILE_NAME) {
		File file = new File(FILE_PATH, FILE_NAME);
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(file);
		}catch (IOException ioException) {
			System.err.println(ioException);
			ioException.printStackTrace();
		}
		catch (EncryptedDocumentException e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		return workbook;
	}
	public static Sheet getSheet(Workbook workbook, int sheetNo) {
		return (Sheet) workbook.getSheetAt(sheetNo);
	}
	
	public static Sheet getSheet(Workbook workbook, String sheetName) {
		return (Sheet) workbook.getSheet(sheetName);
	}
	
	public static Cell getCell(Sheet sheet, int col, int row) {
		Row rowDetails = sheet.getRow(row);
		return rowDetails.getCell(col);
	}

	public static String getCellData(Cell cell) {
		String value = "";
		if(cell!= null)
		{
			if(cell.getCellType() == CellType.STRING)
			{
				value = cell.getStringCellValue();
			}
			else
			{
			  Double doubleValue = cell.getNumericCellValue();
			  if(doubleValue != null)
			  {
				  long iPart = (long) doubleValue.doubleValue();
				  double fpart = doubleValue.doubleValue() - iPart;
				  if(fpart == 0.0)
				  {
					  value = Integer.toString(doubleValue.intValue());
				  }
				  else
				  {
					  value = Double.toString(doubleValue);
				  }

			  }
			}
			if(StringUtil.hasValue(value))
			{
				return value;
			}
			else
			{
				return "";
			}
		}
		else
		{
			return value;
		}
		

	}

	public static void closeWorkbook(Workbook workbook) {
		if (workbook != null) {
			try
			{
				workbook.close();
			}
			catch (IOException e)
			{
				System.err.println(e);
				e.printStackTrace();
			}
		}
	}

}