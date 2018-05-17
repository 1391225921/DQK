package com.zqxq.dataprovider;

import org.testng.annotations.DataProvider;

public class normalDataProvider {
	private static String Loginurl="http://dqk.newzqxq.com/user/loginByPassword";
	private static String Loginphone="18512321870";
	private static String Loginpwd="123456";
	private static String findLoanList="http://106.14.237.207:9999/loan/findLoanOrderRecordList";
	private static String findBankList="http://106.14.237.207:9999/archives/findUserBankcardInfo";
	private static String user_id="879882191558004736";
	
	
	public static String getLoginurl() {
		return Loginurl;
	}
	public static void setLoginurl(String loginurl) {
		Loginurl = loginurl;
	}
	public static String getLoginphone() {
		return Loginphone;
	}
	public static void setLoginphone(String loginphone) {
		Loginphone = loginphone;
	}
	public static String getLoginpwd() {
		return Loginpwd;
	}
	public static void setLoginpwd(String loginpwd) {
		Loginpwd = loginpwd;
	}

	
	@DataProvider(name="NormalLogin")
	public static Object[][] normalLogin(){
		return new Object[][]{
		{Loginurl,Loginphone,Loginpwd}
		};
		
	}
	@DataProvider(name="NormalfindLoanList")
	public static Object[][] NormalfindLoanList(){
		return new Object[][]{
		{findLoanList,user_id}
		};
	}
	@DataProvider(name="NormalfindBankList")
	public static Object[][] NormalfindBankList(){
		return new Object[][]{
				{findBankList,user_id}
		};
	}
}
