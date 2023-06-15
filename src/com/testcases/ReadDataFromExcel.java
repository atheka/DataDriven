package com.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class ReadDataFromExcel 
{
	@Test
	public void ReadDataFromExcel() throws EncryptedDocumentException, IOException
	{
	FileInputStream fs=new FileInputStream("./InputTestData/Input.xlsx");
	
     Workbook  wb= WorkbookFactory.create(fs);
     Sheet sh=wb.getSheet("Names");
     Row rw=sh.getRow(2);
     Cell celldata=rw.getCell(0);
     System.out.println("Value from excel sheet is "+celldata.getStringCellValue());
     for(int i=0;i<=sh.getLastRowNum();i++)
     {
    	 Row rowvalue=sh.getRow(i);
    	 System.out.println(rowvalue.getCell(0));
    	 
     }
     for(Row rowvalue:sh)
     {
    	 Cell password=rowvalue.getCell(1);
    	 System.out.println(password);
     }
    	 
}
}
