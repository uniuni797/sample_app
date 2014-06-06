package jp.co.abc.sample.sampleapp.reflect;

import java.io.Serializable;

public class TestBean implements Serializable {

	public String strPublic = "strPublicString";
	private String strPrivate = "strPrivateString";
	private int int1;

	public TestBean(){super();}

	/**
	 * @return strPublic
	 */
	public String getStrPublic() {
		return strPublic;
	}

	/**
	 * @param strPublic セットする strPublic
	 */
	public void setStrPublic(String str1) {
		this.strPublic = str1;
	}

	/**
	 * @return strPrivate
	 */
	private String getStrPrivate() {
		return strPrivate;
	}

	/**
	 * @param strPrivate セットする strPrivate
	 */
	private void setStrPrivate(String str2) {
		this.strPrivate = str2;
	}

	/**
	 * @return int1
	 */
	public int getInt1() {
		return int1;
	}

	/**
	 * @param int1 セットする int1
	 */
	public void setInt1(int int1) {
		this.int1 = int1;
	}

}
