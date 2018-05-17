package com.zqxq.util;

import java.util.HashMap;
import java.util.Map;

public class Signature {
	public String signature = null;
	public String signParam = null;	
	private String timestamp ="1504084520825";//String.valueOf(System.currentTimeMillis());
	private static String HEADER_CHANNEL = "appstore";
	private static String HEADER_IMEI = "0BE3029C-F2D9-4638-AC5E-ADA0E12B0D7A";
	private static String HEADER_APP_VERSION = "1.0.2";
	private static String HEADER_APP_KEY = "ZQXQ-DQK";
	private static String HEADER_APP_SOURCE = "2";
	private static String HEADER_PUBLIC_KEY = "040CD66A84025B94CEAC3EC1B49C92D0";
	
	public Map<String, String> SignatureBuild(String param){
		Map<String, String> signatureMap=new HashMap<String, String>();
		signParam=HEADER_PUBLIC_KEY + HEADER_APP_KEY + HEADER_APP_SOURCE + HEADER_CHANNEL + HEADER_IMEI + HEADER_APP_VERSION + param + timestamp;
		Md5 md=new Md5();
		signature=md.doMd5(signParam);
		System.out.println(signature);
		signatureMap.put("signature", signature);
		signatureMap.put("timestamp", timestamp);
		return signatureMap;
	}
}
