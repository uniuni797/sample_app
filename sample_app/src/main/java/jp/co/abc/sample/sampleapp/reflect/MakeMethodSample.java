package jp.co.abc.sample.sampleapp.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MakeMethodSample {

	public static void main(String args[]){

		try {



			Class testBeanClass = Class.forName("jp.co.abc.sample.sampleapp.reflect.TestBean");
			//public void setConflictStr(String conflictStr)
			Method setStrPublic = testBeanClass.getMethod("setStrPublic", String.class);

			Object testBeanInstance = testBeanClass.newInstance();

			System.out.println("----getMethod-----");

			//取得したメソッドの名前を確認
			System.out.println("メソッド名は？ : " + setStrPublic.getName());
			//メソッドのアクセス修飾子の確認
			System.out.println("このメソッドはpublicですか？ ："+ Modifier.isPublic(setStrPublic.getModifiers()));
			//メソッドの戻り値
			System.out.println("戻り値は？ : "+setStrPublic.getReturnType().getName());

			setStrPublic.invoke(testBeanInstance,new Object[]{"reflectionを使用して作ったメソッドにアクセスしてみた(Public)"});

			//セットした文字列を表示してみる
			System.out.println(((TestBean)testBeanInstance).getStrPublic());

			System.out.println("-----getDeclareMethod----");
			//public void setConflictStr(String conflictStr)
			//Method setStrPrivate = testBeanClass.getMethod("setStrPrivate", String.class);
			
			//----private実行用に修正した範囲の開始----
			
			Method setStrPrivate = testBeanClass.getDeclaredMethod("setStrPrivate", String.class);
			//取得したメソッドの名前を確認
			System.out.println("メソッド名は？ : " + setStrPrivate.getName());
			//メソッドのアクセス修飾子の確認
			System.out.println("このメソッドはpublicですか？ ："+ Modifier.isPublic(setStrPrivate.getModifiers()));
			//メソッドの戻り値
			System.out.println("戻り値は？ : "+setStrPrivate.getReturnType().getName());

			//privateメソッドなので基本実行できないが、外部からのアクセス権限を付与する
			setStrPrivate.setAccessible(true);
			setStrPrivate.invoke(testBeanInstance,new Object[]{"reflectionを使用して作ったメソッドにアクセスしてみた(Private)"});

			Method getStrPrivate = testBeanClass.getDeclaredMethod("getStrPrivate");

			//privateメソッドなので基本実行できないが、外部からのアクセス権限を付与する
			getStrPrivate.setAccessible(true);

			//セットしたPrivate文字列を表示してみる
			System.out.println(getStrPrivate.invoke(testBeanInstance));
			
			//----private実行用に修正した範囲の終了----

		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
