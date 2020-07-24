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
import com.erp.test.dao.GradeDAO;

public class GradeDAOImpl implements GradeDAO {

	@Override
	public int insertGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
			try {
				con = Conn.open();
				String sql = "insert into grade values((select nvl(max(grd_no),0)+1 from grade),?,?)";
				ps = con.prepareStatement(sql);
				ps.setObject(1, grade.get("grd_name"));
				ps.setObject(2, grade.get("grd_desc"));
				result = ps.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					Conn.close(ps,con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		
		return result;
	}

	@Override
	public int updateGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		
		try {
			con = Conn.open();
			String sql = "update grade set grd_name=?, grd_desc=? where grd_no =?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, grade.get("grd_name"));
			ps.setObject(2, grade.get("grd_desc"));
			ps.setObject(3, grade.get("grd_no"));
			result = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conn.close(ps,con);
		}
		return result;
	}

	@Override
	public int deleteGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		
		try {
			con = Conn.open();
			String sql = "delete From grade where grd_no=?";
			ps= con.prepareStatement(sql);
			ps.setObject(1, grade.get("grd_no"));
			result = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Conn.close(ps,con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, Object> selectGrade(Map<String, Object> grade) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Conn.open();
			String sql = "select * from grade where grd_no=?";
			ps=con.prepareStatement(sql);
			ps.setObject(1 , grade.get("grd_no"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,Object> g = new HashMap<>();
				g.put("grd_no",rs.getInt("grd_no"));
				g.put("grd_name",rs.getString("grd_name"));
				g.put("grd_desc",rs.getString("grd_desc"));
				return g;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Conn.close(rs,ps,con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Map<String, Object>> selectGradeList(Map<String, Object> grade) {
		List<Map<String,Object>> gradeList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		con = Conn.open();
		String sql = "select * from grade";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			
				Map<String,Object> g = new HashMap<>();
				g.put("grd_no", rs.getInt("grd_no"));
				g.put("grd_name", rs.getString("grd_name"));
				g.put("grd_desc", rs.getString("grd_desc"));
				gradeList.add(g);
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conn.close(rs,ps,con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gradeList;
	}

}
