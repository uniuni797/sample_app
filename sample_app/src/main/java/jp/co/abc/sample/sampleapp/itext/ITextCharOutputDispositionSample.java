package jp.co.abc.sample.sampleapp.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextCharOutputDispositionSample {

	public static void main(String args[]) throws Exception{
		//文書オブジェクトを生成
		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);

		//出力先(アウトプットストリーム)の生成
		FileOutputStream fos = new FileOutputStream("C:\\tmp\\itext\\test.pdf");

		//アウトプットストリームをPDFWriterに設定
		PdfWriter pdfwriter = PdfWriter.getInstance(doc, fos);

		//フォントの設定
		//Font font = new Font(BaseFont.createFont("HeiseiKakuGo-W5",
		//		"UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),15,Font.BOLD);
		BaseFont baseFont = BaseFont.createFont("HeiseiKakuGo-W5",
				"UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED);

		//文章オブジェクト オープン
		doc.open();

//↓↓↓↓↓ 今回変更部分 ↓↓↓↓↓

		//PdfContentByteの取得
		PdfContentByte pdfContentByte = pdfwriter.getDirectContent();

		//テキストの開始
		pdfContentByte.beginText();

		//フォントとサイズの設定
		pdfContentByte.setFontAndSize(baseFont, 17);

		//表示位置の設定
		pdfContentByte.setTextMatrix(300, 300);

		//表示する文字列の設定
		pdfContentByte.showText("テキストの位置を自由に配置する");

		//テキストの終了
		pdfContentByte.endText();

//		//PDF文章に文字列を追加
//		doc.add(new Paragraph("PDF作成", font));

//↑↑↑↑↑ 今回変更部分 ↑↑↑↑↑

		//文章オブジェクト クローズ
		doc.close();

		//PDFWriter クローズ
		pdfwriter.close();
	}

}
