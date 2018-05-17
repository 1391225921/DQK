package com.zqxq.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.zqxq.util.HttpClientHelper;
import com.zqxq.util.ParamSort;
import com.zqxq.util.Signature;

import net.sf.json.JSONObject;

public class LoginApi {
	static List<NameValuePair> data = new ArrayList<NameValuePair>();
	
	public JSONObject Login(String url,String phone,String pwd){
		JSONObject jsonObject = null;
		HttpClientHelper httpClientHelper=new HttpClientHelper();
		data.add(new BasicNameValuePair("phone",phone)); 
		data.add(new BasicNameValuePair("login_pwd",pwd));//方法中的第一个参数名需要和接口中的参数名对应
		//请求实体排序
		ParamSort pSort=new ParamSort();
		String paramSortString=pSort.SortParam(data);
		//生成签名
		Signature signature=new Signature();
		Map<String, String> signatureString=signature.SignatureBuild(paramSortString);
		String string =signatureString.get("signature");
		String timestamp =signatureString.get("timestamp");
		try {
			jsonObject=httpClientHelper.getJSONObjectByPost(url,data,string,timestamp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
