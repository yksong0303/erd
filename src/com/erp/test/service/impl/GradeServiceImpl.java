package com.erp.test.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.GradeDAO;
import com.erp.test.dao.impl.GradeDAOImpl;
import com.erp.test.service.GradeService;


public class GradeServiceImpl implements GradeService {
	private GradeDAO gdao = new GradeDAOImpl();

	public Map<String, Object> insertGrade(Map<String, Object> grade) {
		int result = gdao.insertGrade(grade);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"grade입력 성공~":"grade입력 실패");
		rMap.put("cnt",result);
		return rMap;
	}

	public Map<String, Object> updateGrade(Map<String, Object> grade) {
		int result = gdao.updateGrade(grade);
		Map<String,Object> rMap= new HashMap<>();
		rMap.put("msg",(result==1)?"grade수정 성공":"grade수정 실패");
		rMap.put("cnt",result);
		return rMap;
	}

	public Map<String, Object> deleteGrade(Map<String, Object> grade) {
		int result = gdao.deleteGrade(grade);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"삭제완료":"삭제실패");
		rMap.put("cnt",result);
		return rMap;
	}

	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		// TODO Auto-generated method stub
		return gdao.selectGrade(grade);
	}

	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		return gdao.selectGradeList(grade);
	}
	
	public static void main(String[] args) {
		GradeService gradeService = new GradeServiceImpl();
		Map<String,Object> grade =  new HashMap<>();
		grade.put("grd_no",7);
//		grade.put("grd_name","사장");
//		grade.put("grd_desc","편함;");
		
//		Map<String,Object> rMap = gradeService.updateGrade(grade);
//		System.out.println(rMap); //업데이트

		
//		Map<String,Object> rMap = gradeService.insertGrade(grade);
//		System.out.println(rMap);
		
//		Map<String,Object> rMap = gradeService.deleteGrade(grade);
//		System.out.println(rMap); //삭제
		
//		 List<Map<String,Object>> gradeList = gradeService.selectGradeList(grade);		
//			for(Map<String,Object>grd:gradeList) {
//				System.out.println(grd);
//			} //전체도서
		
		System.out.println(gradeService.selectGrade(grade)); //하나만 찾기
			
	}

}
