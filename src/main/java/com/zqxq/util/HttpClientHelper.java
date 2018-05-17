package com.zqxq.util;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientHelper {
	String responseBody;
	private static String HEADER_CHANNEL = "appstore";
	private static String HEADER_IMEI = "0BE3029C-F2D9-4638-AC5E-ADA0E12B0D7A";
	private static String HEADER_APP_VERSION = "1.0.2";
	private static String HEADER_APP_KEY = "ZQXQ-DQK";
	private static String HEADER_APP_SOURCE = "2";
	private static String HEADER_PUBLIC_KEY = "040CD66A84025B94CEAC3EC1B49C92D0";
    CloseableHttpClient httpclient = HttpClients.createDefault();
	 
	 public JSONObject getJSONObjectByPost(String url,List<NameValuePair> list,String signature,String timetemp)throws IOException{
		 JSONObject jsonResult=null;
		 HttpPost httpPost=new HttpPost(url);
		 
		 httpPost.addHeader("public_key",HEADER_PUBLIC_KEY);
		 httpPost.addHeader("app_key",HEADER_APP_KEY);
		 httpPost.addHeader("app_version",HEADER_APP_VERSION);
		 httpPost.addHeader("source",HEADER_APP_SOURCE);
		 httpPost.addHeader("client_id",HEADER_IMEI);
		 httpPost.addHeader("channel",HEADER_CHANNEL);
		 httpPost.addHeader("signature",signature);
		 httpPost.addHeader("timestamp",timetemp);
		 
		 System.out.println(signature);
		 System.out.println(timetemp);
		 
		 UrlEncodedFormEntity urlEncodedFormEntity=new UrlEncodedFormEntity(list);//组装成一个实体
		 httpPost.setEntity(urlEncodedFormEntity);//UrlEncodedFormEntity类创建的对象可以模拟传统的HTML表单传送POST请求中的参数
		 CloseableHttpResponse response=httpclient.execute(httpPost);//获取url返回的内容
		 try {
			 int status=response.getStatusLine().getStatusCode();//获取请求服务器得到的状态码
			 
			 if(status==200){
				 HttpEntity entity=response.getEntity();
				 responseBody=EntityUtils.toString(entity,"utf-8");//获得内容实体并转换为String类型
				 jsonResult=JSONObject.fromObject(responseBody);//把String类型的内容转换成JSon类型
				 return jsonResult;
			 }else{
				 System.out.print("请求错误，状态码为：" + response.getStatusLine().getStatusCode());
			        throw new ClientProtocolException("意外的状态返回: " + status);
			 }
			 
		} finally{
			response.close();
		}
	 }
}
