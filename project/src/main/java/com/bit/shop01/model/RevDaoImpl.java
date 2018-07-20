package com.bit.shop01.model;

import java.sql.SQLException;
import java.util.Map;

public class RevDaoImpl implements RevDao {

	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		insert("rev.insertFile", map);
	}

	private void insert(String string, Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
