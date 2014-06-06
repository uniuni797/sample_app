package jp.co.abc.sample.sampleapp.telnet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.telnet.TelnetClient;


public class TelnetSample {


	public static final String cimaVerficationGateway = "172.31.16.201";


	public static void main(String args[])throws IOException,Exception{
		//telnetWeather();

		cimaTelnet();

	}

    /**
     * 指定されたmessageが特定されるまでデータを読み込む
     * @param reader 読み込んだ文字
     * @param message 指定文字列
     * @return 指定された文字が特定できた箇所までの文字列
     * @throws Exception
     */
    public static String readMessage(Reader reader, String message)
          throws Exception {

          Pattern pattern = Pattern.compile( message, Pattern.DOTALL );
          StringBuffer buffer = new StringBuffer();
          Matcher matcher = null;

          while( true ) {
              int c = reader.read();
              if (c < 0) break;
              buffer.append((char)c);
              if (reader.ready() == false) {
                  matcher = pattern.matcher( buffer.toString() );
                  System.out.println(buffer);
                  if (matcher.matches()) break;
              }
          }
          //System.out.println(buffer);
          if (matcher.find(0) && matcher.groupCount() >= 1) {
              return( matcher.group(1) );
          }
          return( null );
      }

    /**
     * Cim@検証環境接続処理
     * 両国ログイン→墨田検証環境ログイン→lsコマンド実行→ログアウト
     * @throws IOException
     * @throws Exception
     */
	public static void cimaTelnet() throws IOException,Exception{
        TelnetClient telnet;

        telnet = new TelnetClient();


        try{
            telnet.connect(cimaVerficationGateway, 23);

            telnet.setKeepAlive(false);
            telnet.setDefaultTimeout(1);

        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        InputStream telnetInputStream = telnet.getInputStream();
        OutputStream telnetOutputStream = telnet.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(telnetOutputStream));

        BufferedReader br = new BufferedReader(new InputStreamReader(telnetInputStream));

        ArrayList<String> command = new ArrayList<String>();


        //コマンドを実行する際には\nを入れること
        command.add("cmaapl077\n");
        command.add("K<rZzarA\n");
        command.add("telnet tcma-lod1-mt\n");
        command.add("cimaapl\n");
        command.add("1#BXAaqL\n");
        command.add("ls -l\n");
        command.add("exit\n");
        command.add("exit\n");
        command.add("exit\n");


        readMessage(br,".*login: ");
        System.out.println("readMessage(login) end");
        bw.write(command.get(0));
        bw.flush();

        readMessage(br, ".*Password: $");
        System.out.println("readMessage(password) end");
        bw.write(command.get(1));
        bw.flush();

        readMessage(br,".*ryougoku-ac-tm% ");
        System.out.println("readMessage(ryogoku_login) end");
        System.out.println(command.get(8));
        bw.write(command.get(2));
        bw.flush();

        readMessage(br,".*login: ");
        System.out.println("readMessage(ryogoku_login) end");
        bw.write(command.get(3));
        bw.flush();

        readMessage(br, ".*Password: $");
        System.out.println("readMessage(password) end");
        bw.write(command.get(4));
        bw.flush();

        readMessage(br, ".*tcma-lod1-mt\\$ $");
        bw.write(command.get(5));
        bw.flush();


        readMessage(br, ".*tcma-lod1-mt\\$ $");
        bw.write(command.get(6));
        bw.flush();

        readMessage(br, ".*ryougoku-ac-tm% $");
        bw.write(command.get(7));
        bw.flush();

        try
        {
            telnet.disconnect();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);

	}


	public static void telnetWeather(){
        TelnetClient telnet;

        telnet = new TelnetClient();

        try
        {
            telnet.connect("rainmaker.wunderground.com", 3000);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        IOUtil.readWrite(telnet.getInputStream(), telnet.getOutputStream(),
                         System.in, System.out);

        try
        {
            telnet.disconnect();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
	}

}
