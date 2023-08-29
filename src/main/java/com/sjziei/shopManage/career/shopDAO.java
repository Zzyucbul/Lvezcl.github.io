package com.sjziei.shopManage.career;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class shopDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(shopInfo s) {
		String sql = "insert into shop_info(user_name,password,email) values(  '" + s.getUserName() + "','" + s.getPassword() + "','"
				+ s.getEmail() + "')";
		try {
			jdbcTemplate.execute(sql);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean isExistUser(String username) {
		String sql = "select *from shop_info where user_name='" + username + "'";
		List <String>list = jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String  mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString(1);
			}
		});
		if (list == null) {
			return false;
		} else {
			if (list.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

	}

}
