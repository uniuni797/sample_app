package jp.co.abc.sample.sampleapp.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MakeFieldSample {

	public static void main(String args[]){
		try {

			//TestBeanクラスをロード
			Class clazz = Class.forName("jp.co.abc.sample.sampleapp.reflect.TestBean");
			try {

				//インスタンスを生成する(TestBean)
				Object obj = clazz.newInstance();

				System.out.println("----Public Field----");

				//Publicなフィールドを取得
				Field publicField = clazz.getField("strPublic");
				//取得したフィールドの名前を確認
				System.out.println("フィールド名は？ : " + publicField.getName());
				//メソッドのアクセス修飾子の確認
				System.out.println("このフィールドはpublicですか？ ："+ Modifier.isPublic(publicField.getModifiers()));
				System.out.println("このフィールドの型は？ : "+publicField.getType().getName());
				System.out.println("このフィールドの値は？ : "+publicField.get(obj));

				System.out.println("----Private Field----");

				Field privateField = clazz.getDeclaredField("strPrivate");
				//取得したメソッドの名前を確認
				System.out.println("メソッド名は？ : " + privateField.getName());
				//メソッドのアクセス修飾子の確認
				System.out.println("このメソッドはpublicですか？ ："+ Modifier.isPublic(privateField.getModifiers()));
				//メソッドの戻り値
				System.out.println("このフィールドの型は？ : "+privateField.getType().getName());

				//privateなのでアクセス権を付与する
				privateField.setAccessible(true);

				System.out.println("このフィールドの値は？ : "+privateField.get(obj));

			} catch (InstantiationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
