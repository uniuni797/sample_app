package jp.co.abc.sample.sampleapp.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputTextSample {

	public static void main(String[] args) {
		//-- ファイル書き込み(バッファ)
		try{
			long start = System.currentTimeMillis();
			//ファイルオブジェクトの生成
			File file = new File("/cap/sample_write_buff.txt");
			//ファイル書き込み用オブジェクトにファイル情報を渡す
			FileWriter fw = new FileWriter(file);
			//バッファリングしながら書き込みを行う様に設定
			BufferedWriter bw = new BufferedWriter(fw);

			//ファイル書き込み開始
			for ( int i = 0 ; i < 1000000 ; i++ ){
				bw.write("さしすせソース");
				//プラットフォーム毎の改行コードを取得
				bw.newLine();
				bw.write("天心甘栗");
				bw.newLine();
			}
			//バッファに書き込んだ内容を実ファイルへの書き込みを実施する
			bw.flush();
			//文字ストリームをクローズする
			bw.close();
			fw.close();
			long end = System.currentTimeMillis();

			System.out.println(end - start);

		}catch(IOException e){
			e.printStackTrace();
		}

		//-- ファイル書き込み(バッファなし)
		try{
			long start = System.currentTimeMillis();
			//ファイルオブジェクトの生成
			File file = new File("/cap/sample_write.txt");
			//ファイル書き込み用オブジェクトにファイル情報を渡す
			FileWriter fw = new FileWriter(file);

			//ファイル書き込み開始
			for( int i = 0; i < 1000000; i++ ){
				fw.write("さしすせソース");
				//プラットフォーム毎の改行コードを取得
				fw.write(System.lineSeparator());
				fw.write("天心甘栗");
				fw.write(System.lineSeparator());
			}
			fw.flush();
			//文字ストリームをクローズする
			fw.close();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		}catch(IOException e){
			e.printStackTrace();
		}


	}

}
