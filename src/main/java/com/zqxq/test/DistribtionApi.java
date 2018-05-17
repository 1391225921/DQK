package com.zqxq.test;

import junit.framework.Assert;
import net.sf.json.JSONObject;

import org.testng.annotations.Test;

import com.zqxq.api.LoanOrderListApi;
import com.zqxq.api.LoginApi;
import com.zqxq.dataprovider.normalDataProvider;

public class DistribtionApi {
	@Test(dataProvider = "NormalLogin", dataProviderClass = normalDataProvider.class)
	public void Login(String url, String phone, String pwd) {
		LoginApi loginApi = new LoginApi();
		JSONObject jsonObject = null;
		jsonObject = loginApi.Login(url, phone, pwd);
		String code = jsonObject.getString("code");
		System.out.println(jsonObject);
		Assert.assertEquals(code, "1");
	}

	@Test(dataProvider = "NormalfindLoanList", dataProviderClass = normalDataProvider.class)
	public void LoanOrderList(String url, String user_id) {
		LoanOrderListApi loanOrderListApi = new LoanOrderListApi();
		JSONObject jsonObject = null;
		jsonObject = loanOrderListApi.LoanOrderList(url, user_id);
		String codeString = jsonObject.getString("code");
		Assert.assertEquals(codeString, "1");
	}

	@Test(dataProvider = "NormalfindBankList", dataProviderClass = normalDataProvider.class)
	public void LoanBankList(String url, String user_id) {
		LoanOrderListApi loanOrderListApi = new LoanOrderListApi();
		JSONObject jsonObject = null;
		jsonObject = loanOrderListApi.LoanOrderList(url, user_id);
		String codeString = jsonObject.getString("code");
		Assert.assertEquals(codeString, "1");
	}
}
