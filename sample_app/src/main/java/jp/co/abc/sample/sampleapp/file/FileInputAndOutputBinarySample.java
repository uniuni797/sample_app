package jp.co.abc.sample.sampleapp.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputAndOutputBinarySample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//-- 読み込み処理
		//ファイル情報を取得する
		File file = new File("/cap/sample.jpg");
		//ファイルサイズの戻り値はlongの為、intにダウンキャストする
		byte[] readBinary = new byte[(int)file.length()];
		try {


			//バイトストリームを開く
			FileInputStream fis = new FileInputStream(file);
			//バッファに読み込ませる
			BufferedInputStream bis = new BufferedInputStream(fis);
			//読み込んだバイナリデータをbyte配列にセットする
			bis.read(readBinary);

			//読み込んでバイトにデータを渡したのでストリームをクローズしておく
			bis.close();
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロックｘ
			e.printStackTrace();
		} catch( IOException e){
			e.printStackTrace();
		}


		//書き込み処理
		File writeFile = new File("/cap/sample_write.jpg");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(writeFile);
			bos = new BufferedOutputStream(fos);

			//読み込んだバイトデータを書き込み
			bos.write(readBinary);
			bos.flush();

			//書き込んだらストリームをクローズしておく
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}


	}

}
