package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.FrameworkConstants;

public class DataProviderUtils {
	
	public static Object[] getData(String sheetname) {
		Object[] data = null;
		FileInputStream fs =null;
		
		try {
		 fs= new FileInputStream(FrameworkConstants.getExcelpathfordata());
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int rownum = sheet.getLastRowNum();
		int columnnum = sheet.getRow(0).getLastCellNum();
		
		data = new Object[rownum];
		Map<String,String> map;
		
		for(int i=1;i<=rownum;i++) {
			map = new HashMap<>();
			for(int j=0;j<columnnum;j++) {
				
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				data[i-1] = map;
			}
		}
		
	}
	
	catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		finally {
			try {
				if(Objects.isNull(fs))
					fs.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
