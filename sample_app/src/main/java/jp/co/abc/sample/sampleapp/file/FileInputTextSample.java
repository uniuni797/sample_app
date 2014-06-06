package jp.co.abc.sample.sampleapp.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class FileInputTextSample {

	public static void main(String[] args) {
		String filePath = "/cap/sample.txt";
		// TODO 自動生成されたメソッド・スタブ

		try{
			System.out.println("------バッファ使用時------");
			//バッファ使用時
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String readText = null;
			//１行の文字列を読み込む
			while ( (readText = br.readLine()) != null ){
				//１行表示
				System.out.println(readText);
			}
			//文字ストリームを閉じる
			br.close();

			//バッファ未使用時
			System.out.println("------バッファ未使用時------");
			FileReader fr = new FileReader(filePath);
			int i = 0;
			//1文字ずつ読み込む
			while( (i = fr.read()) != -1 ){
				//charにキャストして文字を表示
				System.out.print((char)i);
			}
			System.out.println();
			//文字ストリームを閉じる
			fr.close();

			//バッファ未使用時(CharBuffer)
			System.out.println("------バッファ使用時(CharBuffer)------");
			fr = new FileReader(filePath);
			//バッファの容量を100文字分に設定
			CharBuffer cb = CharBuffer.allocate(100);
			//fileReaderで読み込んだファイルの内容をCharBufferにreadする
			fr.read(cb);
			//バッファの現在位置を先頭に戻す
			cb.rewind();
			//バッファの中身を先頭から出力する
			System.out.println(cb.toString());
			//文字ストリームを閉じる
			fr.close();






		}catch(IOException e){
			e.printStackTrace();
		}


	}

}
