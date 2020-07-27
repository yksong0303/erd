package com.erp.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.dao.EmployeeDAO;
import com.erp.test.dao.impl.EmployeeDAOImpl;
import com.erp.test.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO edao = new EmployeeDAOImpl();
	@Override
	public Map<String, Object> insertEmployee(Map<String, Object> employee) {
		int result = edao.insertEmployee(employee);
		Map<String,Object> rMap = new HashMap<String, Object>();
		rMap.put("msg",(result==1)?"emp입력 성공":"emp입력 실패");
		rMap.put("cnt",result);
		
		return rMap;
	}

	@Override
	public Map<String, Object> updateEmployee(Map<String, Object> employee) {
		int result = edao.updateEmployee(employee);
		Map<String,Object> rMap = new HashMap<String, Object>();
		rMap.put("msg",(result==1)?"emp입력 성공":"emp입력 실패");
		rMap.put("cnt",result);
		
		return rMap;
	}

	@Override
	public Map<String, Object> deleteEmployee(Map<String, Object> employee) {
		int result = edao.deleteEmployee(employee);
		Map<String,Object> rMap = new HashMap<String, Object>();
		rMap.put("msg",(result==1)?"삭제완료":"삭제실패");
		rMap.put("cnt",result);
		return rMap;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		int result = edao.deleteEmployee(employee);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"삭제완료":"삭제실패");
		rMap.put("cnt",result);
		
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		// TODO Auto-generated method stub
		return edao.selectEmployeeList(employee);
	}
	public static void main(String[] args) {
		EmployeeService empService = new EmployeeServiceImpl();
		Map<String,Object> emp = new HashMap<String, Object>();
//		emp.put("emp_no",400);
		emp.put("emp_name","강순자");
		emp.put("emp_salary",5000);
		emp.put("grd_no",2);
		emp.put("emp_active",1);
		
//		Map<String,Object> rMap = empService.deleteEmployee(emp);
//		System.out.println(rMap);
		
		Map<String,Object> rMap = empService.insertEmployee(emp);
		System.out.println(rMap);
		
		
		
//		List<Map<String, Object>>empList= empService.selectEmployeeList(emp);
//		for(Map<String,Object>em:empList){
//		System.out.println(em);
//		}
		}

}
