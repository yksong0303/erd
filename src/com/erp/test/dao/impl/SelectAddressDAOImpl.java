package com.erp.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.test.common.Conn;
import com.erp.test.dao.SelectAddressDAO;

public class SelectAddressDAOImpl implements SelectAddressDAO {

	public List<String> selectSidoList(String sido) {
		List<String> sidoList= new ArrayList<String>();
		String sql = "select distinct sido from select_address order by sido";
		Connection con = Conn.open();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				sidoList.add(rs.getString("sido"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sidoList;
	}

	public List<String> selectGugunList(String sido) {
		List<String> guGunList= new ArrayList<String>();
		Connection con = Conn.open();
		String sql = "select distinct gugun from select_address\r\n" + 
				"where sido=? order by gugun";
		
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sido);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				guGunList.add(rs.getString("gugun"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return guGunList;
	}

	public List<String> selectDongList(String sido, String gugun) {
		List<String> dongList= new ArrayList<String>();
		Connection con = Conn.open();
		String sql = "select distinct dong_name from select_address\r\n" + 
				"where sido=? and gugun=? order by sido";
		
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sido);
			ps.setString(2, gugun);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dongList.add(rs.getString("dong_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dongList;
	}
	public static void main(String[] args) {
		SelectAddressDAO saDao = new SelectAddressDAOImpl();

		System.out.println(saDao.selectSidoList(null));
	      System.out.println(saDao.selectGugunList("경기도"));
		 System.out.println(saDao.selectDongList("경기도","남양주시"));
	}

}
