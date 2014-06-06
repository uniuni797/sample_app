package jp.co.abc.sample.sampleapp.java7;



public class TryWithResourcesNoExceptionUnitSample {


	public static void main(String args[]){

		try ( TryWithResourcesExceptionUnitSample.TestResources t = new TryWithResourcesExceptionUnitSample().new TestResources();
				TryWithResourcesNoExceptionDualSample.TestResources2 t2 = new TryWithResourcesNoExceptionDualSample().new TestResources2()){

			t.exec();

		}catch(Exception e){
			e.printStackTrace();
		}

	}


	public class TestResources implements AutoCloseable {

		@Override
		public void close() throws Exception {
			// TODO 自動生成されたメソッド・スタブ
			System.out.println("closeします");
		}

		public void exec(){
			System.out.println("メソッド実行");
		}



	}

	public class TestResources2 implements AutoCloseable{

		@Override
		public void close() throws Exception {
			// TODO 自動生成されたメソッド・スタブ
			System.out.println("closeします２");
		}

		public void exec(){
			System.out.println("メソッド実行2");
		}

	}
}
