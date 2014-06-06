package jp.co.abc.sample.sampleapp.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertySample {

	public static void main(String[] args) {

		PropertySample ps = new PropertySample();
		ps.getProp();
	}


	public void getProp(){
		// TODO 自動生成されたメソッド・スタブ

		//テキスト
		Properties propText = new Properties();
		Class<? extends PropertySample> thisClass = this.getClass();
		//プレーンテキストを使用したプロパティ情報の取得
		try {

			propText.load(new InputStreamReader(thisClass.getResourceAsStream("/jp/co/ctc/sample/sampleapp/prop/prop_text.txt")));
			System.out.println(propText.getProperty("123"));
			System.out.println(propText.getProperty("@@@"));
			System.out.println(propText.getProperty("abc"));
			System.out.println(propText.getProperty("年収"));

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//XMLを使用したプロパティ情報の取得
		try {

			propText.loadFromXML(thisClass.getResourceAsStream("/jp/co/ctc/sample/sampleapp/prop/prop_xml.xml"));
			System.out.println(propText.getProperty("key"));
			System.out.println(propText.getProperty("プロパティ"));

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
