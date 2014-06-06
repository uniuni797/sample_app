package jp.co.abc.sample.sampleapp.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SamplePoiExcel {

	public static void main(String args[]){

		Workbook wb = new HSSFWorkbook();

		try
		{
		//Excelファイル作成
		 FileOutputStream fileOut = new FileOutputStream("workbook.xls");

		 // シート作成
		 Sheet sheet1 = wb.createSheet("シート１");
		 Sheet sheet2 = wb.createSheet("シート２");

		 // 0行目、0カラム目(A0)に文字列を入力
		 Row row = sheet1.createRow( 0 );
		 Cell A_0 = row.createCell( 0 );
		 A_0.setCellValue( "シート１のA0に書き込み" );

		// 0行目、0カラム目(A0)に文字列を入力
		 Row row2 = sheet2.createRow( 0 );
		 Cell A_0_sheet2 = row2.createCell( 0 );
		 A_0_sheet2.setCellValue( "シート２でも書き込む" );

		 wb.write(fileOut);
		 fileOut.close();
		}
		catch ( IOException oops ){
			oops.printStackTrace();
		}


	}

}
