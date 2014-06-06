package jp.co.abc.sample.sampleapp;

import java.lang.reflect.InvocationTargetException;


public class ClassLoaderSample {


	public static void main(String args[]){

		A a = new ClassLoaderSample().new A();

		try {
			a.test();
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
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	class A {

		public void test() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

			getClass().getClassLoader().loadClass("java.lang.Runtime").getMethod("exec",String[].class).invoke(new Object(), "pwd");

		}

	}

}
