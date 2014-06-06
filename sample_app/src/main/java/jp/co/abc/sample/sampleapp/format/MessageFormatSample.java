package jp.co.abc.sample.sampleapp.format;

import java.sql.Date;
import java.text.MessageFormat;

public class MessageFormatSample {

	public static void main(String[] args) {

		MessageFormat mf = new MessageFormat("{0}が間違っています。");

		//IDが間違っていますを表示
		String[] message = {"id"};
		System.out.println(mf.format(message));

		//passが間違っていますを表示
		message[0] = "pass";
		System.out.println(mf.format(message));

		//{0}にはサブフォーマットを指定
		MessageFormat mf2 = new MessageFormat("今日は{0,date,yyyy年MM月dd日}、時刻は{0,time}。天気は{1}です。");
		//{0}は日付クラスを渡す
		Object[] message2 = {new Date(System.currentTimeMillis()),"晴れ"};
		//表示してみる
		System.out.println(mf2.format(message2));

	}

}
