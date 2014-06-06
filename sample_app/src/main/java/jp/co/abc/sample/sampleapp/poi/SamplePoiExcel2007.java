package jp.co.abc.sample.sampleapp.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SamplePoiExcel2007 {

	public static void main(String args[]){

		Workbook wb = new XSSFWorkbook();

		try{

		 FileOutputStream fileOut = new FileOutputStream("new_workbook.xlsx");

		 // Create new sheet. name akb, ske
		 Sheet sheet1 = wb.createSheet("xlsxのシート１");
		 Sheet sheet2 = wb.createSheet("おまけのシート");

		 // 2行目のCに文字列を書き込む
		 Row row = sheet1.createRow( 1 );
		 Cell A_0 = row.createCell( 2 );
		 A_0.setCellValue( "シート1に書き込み" );

		 // 3行目のDに文字列を書き込む
		 Row row2 = sheet2.createRow( 2 );
		 Cell A_0_ske = row2.createCell( 3 );
		 A_0_ske.setCellValue( "最新のエクセルでも書き込める" );

		 // Write contents of work book into file.
		 wb.write(fileOut);
		 fileOut.close();
		}
		catch ( IOException oops ){
			oops.printStackTrace();
		}
	}
}
