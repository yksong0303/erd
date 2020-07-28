package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderTest {
	public static void main(String[] args) {
		File path = new File("C:\\javays\\address");
		List<String> fileList = new ArrayList<>();
		if(path.isDirectory()) {
			File[] files = path.listFiles();
			
			for(File file:files) {
				if(!file.isDirectory() && file.getName().indexOf("build_")==0) {
				fileList.add(file.getName());
				}
			}
			
		}
		for(String i:fileList) {
			System.out.println(i);
		}
		
	}

}
