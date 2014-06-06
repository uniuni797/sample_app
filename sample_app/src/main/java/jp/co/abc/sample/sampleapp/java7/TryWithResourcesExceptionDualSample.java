package jp.co.abc.sample.sampleapp.java7;



public class TryWithResourcesExceptionDualSample {

    public static void main(String args[]){

        //AutoCloseableを実装したリソースをtryにて定義する
        //複数定義したい場合はセミコロンで区切る
        try ( TryWithResourcesExceptionDualSample.TestResources t = new TryWithResourcesExceptionDualSample().new TestResources();
                TryWithResourcesExceptionDualSample.TestResources2 t2 = new TryWithResourcesExceptionDualSample().new TestResources2()){

            //TestResourcesのexecを実行
            t.exec();
            //TestResources2のexecを実行
            t2.exec();

            //TestResourcesからexceptionを強制的に起こさせる
            t.exception();
            //TestResources2からexceptionを強制的に起こさせる
            t2.exception();

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
            System.out.println("TestResourceの例外処理");
            throw new Exception();
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

        public void exception() throws Exception{
            System.out.println("TestResource2の例外処理");
            throw new Exception();
        }


    }

}
