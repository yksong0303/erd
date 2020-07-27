package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.test.common.Conn;
import com.erp.test.dao.EmployeeDAO;


public class EmployeeDAOImpl implements EmployeeDAO {

	public int insertEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "insert into employee(emp_no, emp_name, emp_credat, emp_salary, grd_no,)\r\n" + 
					"values(seq_emp_no.nextval, ?, sysdate, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setObject(1, employee.get("emp_name"));
			ps.setObject(2, employee.get("emp_salary"));
			ps.setObject(3, employee.get("grd_no"));
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			Conn.close(ps,con);
		}
		return result;
	}

	@Override
	public int updateEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Conn.open();
			String sql = "update employee set emp_name=?, emp_salary=?, grd_no=? where emp_no=? ";
			ps = con.prepareStatement(sql);
			ps.setObject(1, employee.get("emp_name"));
			ps.setObject(2, employee.get("emp_salary"));
			ps.setObject(3, employee.get("grd_no"));
			ps.setInt(4, (int)employee.get("emp_no"));
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		 return result;
  

	}

	@Override
	public int deleteEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = Conn.open();
			String sql = "update employee set emp_active=? where emp_no=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, employee.get("emp_no"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conn.close(ps,con);
		}
		return result;
	}

	@Override
	public Map<String, Object> selectEmployee(Map<String, Object> employee) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Conn.open();
			String sql = "select emp_no, emp_name, emp_credat, emp_salary, grd_no, emp_active from employee where emp_num=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, employee);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("emp_no", rs.getInt("emp_no"));
				map.put("emp_name", rs.getString("emp_name"));
				map.put("emp_credat", rs.getString("emp_credat"));
				map.put("emp_salary", rs.getInt("emp_salary"));
				map.put("grd_no", rs.getInt("grd_no"));
				map.put("emp_active", rs.getInt("emp_active"));
				return map;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conn.close(rs,ps,con);
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> selectEmployeeList(Map<String, Object> employee) {
		List<Map<String,Object>> empList = new ArrayList<Map<String,Object>>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con = Conn.open();
			String sql = "select * from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> em = new HashMap<String, Object>();
				em.put("emp_no",rs.getInt("emp_no"));
				em.put("emp_name",rs.getString("emp_name"));
				em.put("emp_credat",rs.getString("emp_credat"));
				em.put("emp_salary",rs.getInt("emp_salary"));
				em.put("grd_no",rs.getInt("grd_no"));
				em.put("emp_active",rs.getInt("emp_active"));
				empList.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conn.close(rs,ps,con);
		}
		return empList;
	}
	public static void main(String[] args) {
		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		Map<String,Object> empList = new HashMap<>();
		empList.put("emp_no",400);
//		empList.put("emp_name","강순자");
//		empList.put("emp_salary",5000);
//		empList.put("grd_no",2);
//		empList.put("emp_active",1);
		
	
		
		 
		System.out.println(empList);
	
		
		
		
	}

}
