package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputTest {
	public static void main(String[] args) {
	
		File f = new File("c:\\read.txt");
		List<Map<String,String>> pList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(f);
			try {
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String str = br.readLine();
				
				while(str!=null) {
					Map<String,String> phone = new HashMap<>();
					String[] strs = str.split(",");
					phone.put("지역", strs[0]);
					phone.put("국번", strs[1]);
					pList.add(phone);
					str = br.readLine();
				}
				System.out.println(pList);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
