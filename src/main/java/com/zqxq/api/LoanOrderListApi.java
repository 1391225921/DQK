package com.zqxq.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.zqxq.util.HttpClientHelper;
import com.zqxq.util.ParamSort;
import com.zqxq.util.Signature;

public class LoanOrderListApi {
	List<NameValuePair> nameValuePairs =new ArrayList<NameValuePair>();
	public JSONObject LoanOrderList(String url,String user_id){
		JSONObject jsonObject=null;
		nameValuePairs.add(new BasicNameValuePair("user_id",user_id));
		//请求实体
		ParamSort paramSort=new ParamSort();
		String param=paramSort.SortParam(nameValuePairs);
		//签名
		Signature signature=new Signature();
		Map<String, String> sMap=signature.SignatureBuild(param);
		String string=sMap.get("signature");
		String timestamp=sMap.get("timestamp");
		HttpClientHelper httpClientHelper=new HttpClientHelper();
		try {
			jsonObject=httpClientHelper.getJSONObjectByPost(url, nameValuePairs , string, timestamp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
