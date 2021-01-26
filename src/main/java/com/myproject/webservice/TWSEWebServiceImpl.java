package com.myproject.webservice;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class TWSEWebServiceImpl {

	private final static String URL = "http://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_2317.tw_20200814&json=1&delay=0";
	
	public static void test() {
		RestTemplate restTemplate = new RestTemplate();
		String r = restTemplate.getForObject(TWSEWebServiceImpl.URL, String.class);
		
		System.out.println(r);
	}
}
