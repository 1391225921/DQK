package com.zqxq.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

public class ParamSort {
public String SortParam(List<NameValuePair> data){
	String paramString=null;
	StringBuffer sBuffer=new StringBuffer();
	Map<String, String> map=new HashMap<String, String>();
	for (int i = 0; i < data .size(); i++) {
		NameValuePair nameValuePair=data.get(i);
		map.put(nameValuePair.getName(), nameValuePair.getValue());
	}
	try {
		ArrayList<String> param=new ArrayList<String>(map.keySet());
		Collections.sort(param);
		for (String string : param) {
			sBuffer.append(string).append("=").append(URLEncoder.encode((String)(map.get(string)),"UTF-8")).append("&");
		}
		if (sBuffer.length()>1) {
			sBuffer.deleteCharAt(sBuffer.length()-1);
			
		}
		return sBuffer.toString();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return paramString;
}
}
