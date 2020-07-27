package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListMapTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Map<String,Object>> personList = new ArrayList<>();
		Map<String,Object> person = new HashMap<String, Object>();
		person.put("name","동동이");
		person.put("지역","서울");
		person.put("전번",(r.nextInt(9999)+1000)+"-"+(r.nextInt(9999)+1000));
		personList.add(person);
		person = new HashMap<String, Object>();
		person.put("name","퉁퉁이");
		person.put("지역","경기");
		person.put("전번",(r.nextInt(9999)+1000)+"-"+(r.nextInt(9999)+1000));
		personList.add(person);
		person = new HashMap<String, Object>();
		person.put("name","쿵쾅이");
		person.put("지역","전남");
		person.put("전번",(r.nextInt(9999)+1000)+"-"+(r.nextInt(9999)+1000));
		personList.add(person);
		
		List<Map<String,String>> phoneList= new ArrayList<Map<String,String>>();
		Map<String,String> phone = new HashMap<String, String>();
		phone.put("지역","서울");
		phone.put("국번","02");
		phoneList.add(phone);
		phone = new HashMap<String, String>();
		phone.put("지역","경기");
		phone.put("국번","031");
		phoneList.add(phone);
		phone = new HashMap<String, String>();
		phone.put("지역","경북");
		phone.put("국번","054");
		phoneList.add(phone);
		phone = new HashMap<String, String>();
		phone.put("지역","전남");
		phone.put("국번","061");
		phoneList.add(phone);
		
		
		for(Map<String, Object> p : personList) {
			for(Map<String,String> ph : phoneList) {
				if(ph.get("지역").equals(p.get("지역"))) {
					p.put("전번",ph.get("국번")+"-"+p.get("전번"));
				}
			}
			System.out.println(p);
		}	
	}
}
