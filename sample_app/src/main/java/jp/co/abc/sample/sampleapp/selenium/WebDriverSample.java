package jp.co.abc.sample.sampleapp.selenium;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.thoughtworks.selenium.Selenium;

public class WebDriverSample {

	public static void main(String args[]) throws UnsupportedEncodingException, InterruptedException,IOException{


		WebDriver ieDriver = null;
		WebDriver ffDriver = null;
		WebDriver chromeDriver = null;

		//try{

			//ローカル上のHTML確認用
			executeUnitDriver();
			//executeCimaUnitDriver();

			//webclientを使った接続
			//webClient();

			//SeleniumIDE関数を使用して実行
			//executeSeleniumDriver();

	//ScreenShot
//			try{
//			  File screenshotFile = ((TakesScreenshot)ieDriver).getScreenshotAs(OutputType.FILE);
//
//				  //Copy the element screenshot to disk
//				  FileUtils.copyFile(screenshotFile, new File("C:/cap/cap.png"));
//			}catch(Exception e){
//				e.printStackTrace();
//			}

	//XPath
			//ieDriver.findElements(By.xpath("//"));
//
//			System.out.println(ssbytes.length);
//			int count=0;
//			for ( byte write : ssbytes ){
//				bos.write(ssbytes);
//				count++;
//				if ( (count%1000) == 0){
//					System.out.println(count+"回目");
//				}
//
//			}
//			bos.flush();
//			bos.close();

			//特定の属性を指定
			//nameで指定する場合
//			WebElement webElementName = chromeDriver.findElement(By.name("p"));
//			webElementName.sendKeys(new String(("かきくけこ").getBytes()));
			//xpathで指定する場合
//			WebElement webElementName = chromeDriver.findElement(By.xpath("//*[@id=\"srchtxt\"]"));
			//共通するnameで指定する場合(複数取得)
			//List<WebElement> webElementNameList = chromeDriver.findElements(By.tagName("input"));
			//System.out.println(webElementNameList.size());

//			JavascriptExecutor js = (JavascriptExecutor)chromeDriver;
//			js.executeScript("document.sf1.p.value=arguments[0]", "わっしょいわっしょい");
//			webElementName.sendKeys(new String(("かきくけこ").getBytes()));

			//----Driverを3秒後に閉じる----//

			//Thread.sleep(3000L);
			//ieDriver.quit();
			//chromeDriver.quit();

			//特定の要素を指定
	//		List<WebElement> webElementTagList = chromeDriver.findElements(By.tagName("input"));
	//		for ( WebElement element : webElementTagList){
	//			System.out.println(element.getAttribute("name"));
	//		}

	//		chromeDriver.findElement(By.id("srchbtn")).click();
	//        System.out.println(resultsDiv.size());
	//        for (int i=0; i<resultsDiv.size(); i++) {
	//            System.out.println(i+1 + ". " + resultsDiv.get(i).getText());
	//        }
//		}catch(UnhandledAlertException e){
//			ieDriver.quit();
//		}catch(NoAlertPresentException e){
//			ieDriver.quit();
//		}
	}

	public static Proxy getProxy(){
		//Proxyを使用する場合hudsuckr.exeが必要となる。(Webで見つからなかった為、PC内にあるかも？)
		//selenium-server-rcにあった↑
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.PAC);
		proxy.setProxyAutoconfigUrl("file:///C:/proxy.pac");
//		proxy.setSocksProxy("ctcpro.ctc-g.co.jp:8080");
//		proxy.setSocksUsername("z1g9285");
//		proxy.setSocksPassword("uni6666!");

		return proxy;
	}

	public static void executeSeleniumDriver(){
		System.setProperty("webdriver.ie.driver", "conf/selenium/IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//ieCapabilities.setCapability(CapabilityType.PROXY, getProxy());
		ieCapabilities.setJavascriptEnabled(true);

		InternetExplorerDriver driver = new InternetExplorerDriver(ieCapabilities);
		//FirefoxDriver driver = new FirefoxDriver();

		Selenium selenium = new WebDriverBackedSelenium(driver,"file://C:\\Users\\z1g9285\\Documents\\sample_workspace\\sampleapp\\html\\sample.html");

		selenium.open("file://C:\\Users\\z1g9285\\Documents\\sample_workspace\\sampleapp\\html\\sample.html");
		//selenium.open("http://yahoo.co.jp/");

		System.out.println(selenium.getHtmlSource());

		//selenium.type("//input[@name=text1]", "abcde");

	}

	public static void executeUnitDriver(){

		HtmlUnitDriver uDriver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_10);
		uDriver.setJavascriptEnabled(true);
		uDriver.get("file://C:\\Users\\z1g9285\\Documents\\sample_workspace\\sampleapp\\html\\sample.html");

		//sample1ページソース
		System.out.println(uDriver.getPageSource());

		//テキストボックスに入力した内容を取得しなおして入力されていることを確認する
		WebElement webelement = uDriver.findElement(By.name("abc"));
		//そのName属性に該当する全ての情報を取得する
		List<WebElement> webelements = uDriver.findElementsByName("abc");

		for ( WebElement nameElement : webelements ){
			System.out.println(nameElement.getAttribute("value"));
			System.out.println(nameElement.getTagName());
			System.out.println(nameElement.getLocation());
			System.out.println(nameElement.getSize());
			System.out.println(nameElement.isSelected());
		}

		//aタグに囲まれたテキスト情報から特定する(日本語ではだめっぽい)
		WebElement linkElement = uDriver.findElement(By.linkText("abcdlink"));
		System.out.println("Linktest tag name =  "+linkElement.getTagName());

		//aタグに囲まれたテキスト情報の一部から特定する。
		WebElement plinkElement = uDriver.findElement(By.partialLinkText("cdli"));
		System.out.println("Partial Linktest tag name =  "+linkElement.getTagName());

		//id属性で特定する
		WebElement idElement = uDriver.findElement(By.id("link_id"));
		System.out.println("id tag name =  "+linkElement.getTagName());

		//class属性で特定する
		WebElement classElement = uDriver.findElement(By.className("link_class"));
		System.out.println("class tag name =  "+linkElement.getTagName());

		WebElement cssElement = uDriver.findElement(By.cssSelector("iro"));
		System.out.println("css text = " + cssElement.getText());
		try {
			System.out.println(System.getProperty("file.encoding"));
			System.out.println("css text endcode = " +  cssElement.getText());
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"UTF-8"));
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"MS932"));
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"Shift-JIS"));
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"EUC-JP"));
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"ISO-8859-1"));
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"UTF-16"));
			System.out.println("css text endcode = " +  new String(cssElement.getText().getBytes(),"ISO-2022-JP"));
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//テキストフィールドに値を入力する
		WebElement textElement = uDriver.findElement(By.name("text1"));
		System.out.println("テキストフィールドに入力したものを表示(前)="+textElement.getAttribute("value"));
		System.out.println("テキストフィールドに入力したものを表示(前)="+textElement.getText());
		textElement.sendKeys("テキストフィールドに値を出力");
		System.out.println("テキストフィールドに入力したものを表示(後)="+textElement.getAttribute("value"));
		System.out.println("テキストフィールドに入力したものを表示(後)="+textElement.getText());
		//テキストエリアに値を入力する
		WebElement tareaElement = uDriver.findElement(By.name("tarea"));
		System.out.println("テキストエリアに入力したものを表示(前)="+tareaElement.getText());
		tareaElement.sendKeys("テキストエリアに値を出力");
		System.out.println("テキストエリアに入力したものを表示(後)="+tareaElement.getText());

		//チェックボックスにチェックを入れる
		WebElement cb1Element = uDriver.findElement(By.xpath("//input[@type='checkbox'][@name='abc'][@value='1']"));
		//チェックされているか確認(checkedが付いているタグ)
		System.out.println("元々ついている状態 = "+cb1Element.isSelected());
		cb1Element.click();
		//クリックしてチェックを外した状態
		System.out.println("外した状態 = "+cb1Element.isSelected());

		//ラジオボタンにチェックを入れる
		WebElement rd1Element = uDriver.findElement(By.xpath("//input[@type='radio'][@name='radio'][@value='1']"));
		//チェックされているか確認
		System.out.println("元々ついていない状態 = "+rd1Element.isSelected());
		rd1Element.click();
		//クリックしてチェックを外した状態
		System.out.println("つけた状態 = "+rd1Element.isSelected());

		//プルダウンにチェックを入れる
		Select select1 = new Select(uDriver.findElement(By.xpath("//select[@name='select1']")));
		//チェックされているか確認
		//Indexで取得
		select1.deselectByIndex(0);
		for ( WebElement option : select1.getAllSelectedOptions() ){
			System.out.println("Index指定 = "+option.getText());
		}

		WebElement sloption =  select1.getFirstSelectedOption();
		System.out.println("最初のselected = "+sloption.getText());

		for ( WebElement option : select1.getOptions() ){
			System.out.println("OPTION取得 = "+option.getText());
		}
		//optionタグのvalueで検索
		select1.selectByValue("4");
		for ( WebElement option : select1.getAllSelectedOptions() ){
			System.out.println("value値 = "+option.getText());
		}
		sloption =  select1.getFirstSelectedOption();
		System.out.println("最初のselected = "+sloption.getText());

		for ( WebElement option : select1.getOptions() ){
			System.out.println("OPTION取得 = "+option.getText());
		}
		//optionタグの表示値で検索
		select1.selectByVisibleText("2015/1/1");
		for ( WebElement option : select1.getAllSelectedOptions() ){
			System.out.println("表示値 = "+option.getText());
		}
		sloption =  select1.getFirstSelectedOption();
		System.out.println("最初のselected = "+sloption.getText());

		for ( WebElement option : select1.getOptions() ){
			System.out.println("OPTION取得 = "+option.getText());
		}
		//Submitを使用してsample1→sample2に遷移する処理
		WebElement submitElement = uDriver.findElement(By.xpath("//input[@type='submit']"));
		System.out.println("submitElement="+submitElement.getAttribute("value"));
		submitElement.click();
		//sample2のページソース
		//System.out.println(uDriver.getPageSource());

	}

	public static void webClient(){

		WebClient wc = new WebClient(BrowserVersion.INTERNET_EXPLORER_10);
		try {
			//wc.
			wc.getPage("https://192.168.130.45/PcmnSrv/");
		} catch (FailingHttpStatusCodeException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	/**
	 * Cima検証機接続用メソッド
	 */
	public static void executeCimaUnitDriver(){
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setCapability(CapabilityType.PROXY, getProxy());
		ieCapabilities.setJavascriptEnabled(false);

		HtmlUnitDriver uDriver = new HtmlUnitDriver(ieCapabilities);
		uDriver.setJavascriptEnabled(true);
		uDriver.get("https://192.168.130.45/PcmnSrv/");
		//sample1ページソース
		System.out.println(uDriver.getPageSource());

		//Cimaにログインする為にアカウント情報をセットする
		WebElement loginIdElement = uDriver.findElement(By.name("LoginId"));
		loginIdElement.sendKeys("imode00799");
		WebElement emailElement = uDriver.findElement(By.name("Email"));
		emailElement.sendKeys("docomo0599@test.test.com");
		WebElement passwdElement = uDriver.findElement(By.name("Password"));
		passwdElement.sendKeys("pwd00599");
		//そのName属性に該当する全ての情報を取得する
		List<WebElement> webelements = uDriver.findElementsByName("abc");

		for ( WebElement nameElement : webelements ){
			System.out.println(nameElement.getAttribute("value"));
			System.out.println(nameElement.getTagName());
			System.out.println(nameElement.getLocation());
			System.out.println(nameElement.getSize());
			System.out.println(nameElement.isSelected());
		}



		//Submitを使用してsample1→sample2に遷移する処理
		WebElement submitElement = uDriver.findElement(By.xpath("//input[@type='submit']"));
		submitElement.click();


		//sample2のページソース
		System.out.println(uDriver.getPageSource());

		//GOTO CIMAボタン押下
		WebElement gotoCimaElement = uDriver.findElement(By.xpath("//a"));
		gotoCimaElement.click();

		System.out.println(uDriver.getPageSource());

	}

	public static void executeIEDriver(){
		//Internet Explorer
		System.setProperty("webdriver.ie.driver", "conf/selenium/IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setCapability(CapabilityType.PROXY, getProxy());

		InternetExplorerDriver ieDriver = new InternetExplorerDriver(ieCapabilities);
		ieDriver.get("file://C:\\Users\\z1g9285\\Documents\\sample_workspace\\sampleapp\\html\\sample.html");
		ieDriver.get("http://h1222404/");

		System.out.println(ieDriver.getTitle());
		System.out.println(ieDriver.getWindowHandle());


		WebElement webelement = ieDriver.findElement(By.name("p"));
//		WebElement webelement = ieDriver.findElement(By.xpath("/html/form/input[0]/@name"));
//		WebElement webelement = ieDriver.findElement(By.name("description"));

		System.out.println(webelement.getLocation());
		System.out.println(webelement.getSize());
		System.out.println(webelement.getAttribute("value"));
	}

	public static void executeFirefoxDriver(){

		//Firefox
		DesiredCapabilities ffCapabilities = DesiredCapabilities.firefox();
		ffCapabilities.setCapability(FirefoxDriver.PROFILE, true);
		ffCapabilities.setCapability(CapabilityType.PROXY, getProxy());
		FirefoxDriver ffDriver = new FirefoxDriver(ffCapabilities);
		ffDriver.get("http://yahoo.co.jp/");
		WebElement webElementNameff = ffDriver.findElement(By.name("p"));
		webElementNameff.sendKeys(new String(("かきくけこ").getBytes()));

	}

	public static void executeGoogleChromeDriver(){
		//Google Chrome
		System.setProperty("webdriver.chrome.driver", "conf/selenium/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-proxy-server");
		ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		chromeCapabilities.setCapability(CapabilityType.PROXY, getProxy());
		chromeDriver = new ChromeDriver(chromeCapabilities);
		chromeDriver = new ChromeDriver(chromeOptions);
		chromeDriver = new ChromeDriver();
		chromeDriver.get("http://www.yahoo.co.jp/");

		//画像キャプチャ
		File file = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("/cap/sample.jpg"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		TakesScreenshot sshot = (TakesScreenshot) chromeDriver;
		byte[] ssbytes = sshot.getScreenshotAs(OutputType.BYTES);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("cap/os.jpg")));
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
