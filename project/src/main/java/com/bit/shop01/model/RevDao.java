package com.bit.shop01.model;

import java.sql.SQLException;
import java.util.Map;

public interface RevDao {

	void insertBoard(Map<String, Object> map) throws Exception;
	
	void insertFile(Map<String, Object> map) throws Exception;

}
