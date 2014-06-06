package jp.co.abc.sample.sampleapp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileInputTextAndOutputBinary {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//読み込み用
		File readFile = new File("/cap/sample.txt");
		//読み込んだ文字列を書き込み用に保存する
		ArrayList<String> list = new ArrayList<String>();
		try{

			//読み込み処理(バイトストリームから文字ストリームへ変換)
			FileInputStream fis = new FileInputStream(readFile);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String lineStr = null;

			//読み込んだ文字を書き込み用に保持しておく
			while ( (lineStr = br.readLine()) != null ){
				System.out.println(lineStr);
				list.add(lineStr);

			}

			br.close();
			isr.close();
			fis.close();

		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}

		//書き込み用
		File writefile = new File("/cap/sample_output_writer.txt");
		try {
			//書き出し処理(バイトストリームから文字ストリームへ変換)
			FileOutputStream fis = new FileOutputStream(writefile);
			OutputStreamWriter osw = new OutputStreamWriter(fis);
			BufferedWriter bw = new BufferedWriter(osw);

			//読み込み処理で取得した文字列を書き込む
			for ( String writeStr : list ){
				bw.write(writeStr);
				//改行を設定
				bw.newLine();
			}

			//ファイルに書き込む
			bw.flush();

			//書き込み用ストリームをクローズする
			bw.close();
			osw.close();
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
