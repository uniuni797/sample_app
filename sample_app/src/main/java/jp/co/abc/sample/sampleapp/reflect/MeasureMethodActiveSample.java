package jp.co.abc.sample.sampleapp.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MeasureMethodActiveSample {

	public static void main(String args[]){

		long start = System.currentTimeMillis();
		int count;
		for ( count = 0 ; count < 1000000 ; count++ ){

			try {
				Class testBeanClass = Class.forName("jp.co.abc.sample.sampleapp.reflect.TestBean");
				Method setStrPublic = testBeanClass.getMethod("getStrPublic");
				Object testBeanInstance = testBeanClass.newInstance();
				setStrPublic.invoke(testBeanInstance);
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
			} catch (NoSuchMethodException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();

		System.out.println( end - start +"ミリ秒");
	}

}
