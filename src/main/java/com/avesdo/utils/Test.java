package com.avesdo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

	private static Map<String,String> dynamicValueMap = new HashMap<String,String>();
	
	public static void main(String[] args) {
		String str = "//button[@unit='~unit~'][normalize-space()='Purchase']";
		Map<String, String> map = new HashMap<String, String>();
		map.put("~unit~", "807");
		String str1 =updateIdentifier(str, map);
		System.out.println(str1);
		
		/*InputStream fis = null;
		String str1 = "ZQATA#user#_First_Name";
		try{
			fis=Test.class.getResourceAsStream("../../../DynamicData.properties");
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			while(sc.hasNextLine()){  
				String str = sc.nextLine();
				if(str.contains("=")){
					loadValues(str);
				}
			}  
			sc.close();  
			System.out.println(dynamicValueMap.toString());
			
			if(str1.contains("#")){
				String s1 = str1.substring(str1.indexOf("#")+1);
				if(s1.contains("#")){
					String key = "#"+s1.substring(0,s1.indexOf("#"))+"#";
					System.out.println(key);
					if(dynamicValueMap.containsKey(key)){
						String val = dynamicValueMap.get(key);
						str1 = str1.replaceAll(key, val);
						System.out.println(str1);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
	
	private static String updateIdentifier(String identifier, Map<String, String> map){
		String s1 = identifier.substring(identifier.indexOf("~")+1);
		if(s1.contains("~")){
			String key = "~"+s1.substring(0,s1.indexOf("~"))+"~";
			System.out.println(key);
			if(map.containsKey(key)){
				String val = map.get(key);
				identifier = identifier.replaceAll(key, val);
				System.out.println(identifier);
			}			
		}
		
		return identifier;
	}
	
	private static void loadValues(String str){
		String[] arr = str.split("=");
		if(arr[1].equalsIgnoreCase("datetime")){
			dynamicValueMap.put(arr[0].trim(), ""+new Date().getTime());
		}
	}

}
