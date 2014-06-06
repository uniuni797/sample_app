package jp.co.abc.sample.sampleapp.reflect;

public class MeasureMethodStaticSample {


	public static void main(String args[]){

		long start = System.currentTimeMillis();
		int count;
		for ( count = 0 ; count < 1000000 ; count++ ){

			//インスタンス生成
			TestBean t = new TestBean();
			//メソッド実行
			t.getStrPublic();
		}
		long end = System.currentTimeMillis();

		System.out.println( end - start +"ミリ秒");
	}

}
