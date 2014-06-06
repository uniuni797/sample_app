package jp.co.abc.sample.sampleapp.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextCharOutputSample {

	public static void main(String args[]) throws Exception{

		//文書オブジェクトを生成
		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);

		//ファイル作成用ストリーム宣言
		FileOutputStream fos = new FileOutputStream("C:\\tmp\\itext\\test.pdf");

		//アウトプットストリームをPDFWriterに設定
		PdfWriter pdfwriter = PdfWriter.getInstance(doc, fos);

		//フォントの設定
		Font font = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),15,Font.BOLD);

		//文章オブジェクト オープン
		doc.open();

		//PDF文章に文字列を追加
		doc.add(new Paragraph("PDF作成", font));

		//文章オブジェクト クローズ
		doc.close();

		//PDFWriter クローズ
		pdfwriter.close();

	}

}
