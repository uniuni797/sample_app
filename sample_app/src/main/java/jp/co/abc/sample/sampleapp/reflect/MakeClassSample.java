package jp.co.abc.sample.sampleapp.reflect;

public class MakeClassSample {

	public static void main(String args[]){

		try {

			//TestBeanクラスをロード
			Class clazz = Class.forName("jp.co.abc.sample.sampleapp.reflect.TestBean");
			try {

				//インスタンスを生成する(TestBean)
				Object obj = clazz.newInstance();

				//生成したTestBeanのクラスが出来ているか確認する
				System.out.println(obj.getClass());

				//TestBeanにキャストしてみる
				TestBean bean = (TestBean) obj;

				//文字列をセットする
				bean.setStrPublic("クラス作成");

				//セットした文字列を表示
				System.out.println("getStrPublic = "+bean.getStrPublic());

			} catch (InstantiationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
