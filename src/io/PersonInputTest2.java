package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonInputTest2 {
	public static String readText(String path) {
		File f = new File(path);
		try {
	
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
			StringBuffer sb = new StringBuffer();
			String str;
			
			while((str=br.readLine())!=null) {
				sb.append(str+"|");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	public static List<Map<String,String>> parse(String str){
		String[] strs = str.split("\\|");
		String[] keys =null;
		List<Map<String,String>> List = new ArrayList<Map<String,String>>();
		for(int i=0; i<strs.length;i++) {
			
		}
		
		return null;
		
	}
}
