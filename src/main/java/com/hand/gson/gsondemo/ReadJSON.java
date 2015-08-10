package com.hand.gson.gsondemo;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJSON {

	public static void main(String[] args) {
  
		
		try {
			
			JsonParser jsonParser = new JsonParser();
			JsonObject object =(JsonObject) jsonParser.parse(new FileReader("test.json"));//通过jsonParser解析器把当前json数据获取成最大ObjectJson
		    System.out.println("cat="+object.get("cat").getAsString());//获取json的数据
		    System.out.println("pop="+object.get("pop").getAsBoolean());//获取json的属性pop
		    
		    JsonArray array = object.get("languages").getAsJsonArray();//获取json数组
		    for (int i = 0; i < array.size(); i++) {
		    	System.out.println("------------");
		    	JsonObject jsonObject = array.get(i).getAsJsonObject();
		    	System.out.println("id="+jsonObject.get("id").getAsInt());
		    	System.out.println("name="+jsonObject.get("name").getAsString());
		    	System.out.println("ide="+jsonObject.get("ide").getAsString());
				
			}
		
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
