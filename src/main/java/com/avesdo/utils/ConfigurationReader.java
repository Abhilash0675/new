package com.avesdo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigurationReader {
	
	private static final Logger log = LogManager.getLogger(ConfigurationReader.class);
	
	private String chromeDriverPath ="";
	private String edgeDriverPath ="";
	private String clientURL ="";
	private String rootDir = "";
	
	private static Map<String,String> dynamicValueMap = new HashMap<String,String>();
	
	public ConfigurationReader(){
		InputStream in = null;
		try{
			in =  this.getClass().getResourceAsStream("../../../setup.properties");
			Properties setupConfigProp = new Properties();
			setupConfigProp.load(in);

			clientURL = setupConfigProp.getProperty("Client_URL");
			dynamicValueMap.put("baseURL", clientURL);
			String chromeDiverInfo = setupConfigProp.getProperty("chromeDriverPath");
			String edgeDiverInfo = setupConfigProp.getProperty("edgeDriverPath");
			String str1 = this.getClass().getResource("../../../setup.properties").getPath().toString();
			if(str1.startsWith("/")){
				str1 = str1.substring(1);
			}
			rootDir = str1.substring(0, str1.indexOf("target"));
			chromeDriverPath = rootDir +chromeDiverInfo;
			edgeDriverPath = rootDir +edgeDiverInfo;
			loadDynamicData();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void loadDynamicData() throws Exception{
		InputStream fis = null;
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
			//System.out.println(dynamicValueMap.toString());
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
		}
	}

	private void loadValues(String str){
		String[] arr = str.split("=");
		
		if(arr.length>=2 && arr[1].equalsIgnoreCase("datetime")){
			dynamicValueMap.put(arr[0].trim(), ""+new Date().getTime());
		}else{
			dynamicValueMap.put(arr[0].trim(), "");
		}
	}

	/**
	 * @return the rootDir
	 */
	public String getRootDir() {
		return rootDir;
	}

	public static void main(String[] args){
		ConfigurationReader configurationReader= new ConfigurationReader();
	}

	/**
	 * @return the clientURL
	 */
	public String getClientURL() {
		return clientURL;
	}


	/**
	 * @return the chromeDriverPath
	 */
	public String getChromeDriverPath() {
		return chromeDriverPath;
	}


	/**
	 * @return the edgeDriverPath
	 */
	public String getEdgeDriverPath() {
		return edgeDriverPath;
	}

	/**
	 * @return the dynamicValueMap
	 */
	public Map<String, String> getDynamicValueMap() {
		return dynamicValueMap;
	}



}
