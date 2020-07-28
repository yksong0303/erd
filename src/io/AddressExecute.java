package io;

import java.util.List;
import java.util.Map;

public class AddressExecute {
	public static void main(String[] args) {
		String str = ReadText.readText("C:\\javays\\address\\build_sejong2.txt");
		List<Map<String,String>> phList = ReadText.parse(str);
		System.out.println(phList);
	}

}
