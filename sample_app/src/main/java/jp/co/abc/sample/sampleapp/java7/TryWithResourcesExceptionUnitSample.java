	package jp.co.abc.sample.sampleapp.java7;
	
	
	public class TryWithResourcesExceptionUnitSample {
	
	
		public static void main(String args[]){
	
			try ( TryWithResourcesExceptionUnitSample.TestResources t = new TryWithResourcesExceptionUnitSample().new TestResources(); ){
	
				t.exec();
	
				t.exception();
	
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
	
			public void exception() throws Exception{
				throw new Exception();
			}
	
		}
	
	}
