package event.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EventVirtualDB {
	String json;
	EventVirtualDB() throws Exception{
		String address = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?"
				+ "serviceKey=A%2BfpVSq9%2Fh3nQbhZx2ssU9Xvnk3qqx%2F0H%2BedY4yjTU70KuW96cUr3DyLkOLuXp4zbawIwZlmUqptvxKXzAz6Cw%3D%3D"
    			+ "&numOfRows=133"
    			+ "&pageNo=1&MobileOS=ETC&MobileApp=AppTest&listYN=Y&arrange=A"
    			+ "&eventStartDate=20190729"
    			+ "&eventEndDate=20221231"
    			+ "&_type=json";
			
		BufferedReader br;
		URL url;
		HttpURLConnection conn;
		String protocol = "GET";
		
		url = new URL(address);
		conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(protocol);
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		
		json = br.readLine();
}

	public static JSONArray getitems() throws Exception {
		EventVirtualDB ev = new EventVirtualDB();
		
		String json = ev.json;
		
		JSONParser parser = new JSONParser();
		
		Object oba = parser.parse(json);
		JSONObject jsonObj = (JSONObject) oba;
		JSONObject detail = (JSONObject)jsonObj.get("response");
		JSONObject tail = (JSONObject)detail.get("body");
		JSONObject addr = (JSONObject)tail.get("items");
		
		JSONArray jav = new JSONArray();
		jav = (JSONArray) addr.get("item");
		
	    return jav;
	   }
}