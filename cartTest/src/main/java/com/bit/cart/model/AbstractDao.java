package com.bit.cart.model;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.bit.cart.model.entity.CartDto;
import com.bit.cart.model.entity.MemDto;
import com.bit.cart.model.entity.PayDto;
import com.bit.cart.model.entity.ProductDto;
import com.bit.cart.model.entity.ProductOptionDto;

public class AbstractDao {

	Logger log = Logger.getLogger(this.getClass());
	
	SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:"+queryId);
		}
	}
	
	// 삽입
	public int insert(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}
	
	public void insert1(String queryId, Object params) {
		printQueryId(queryId);
		sqlSession.insert(queryId, params);
	}

	public int insert(String queryId, CartDto cean) {
		printQueryId(queryId);
		return sqlSession.insert(queryId, cean);
	}
	
	// 수정
	public int update(String queryId, PayDto pean) {
		printQueryId(queryId);
		return sqlSession.update(queryId, pean);
	}
	
	public int update(String queryId, CartDto cean) {
		printQueryId(queryId);
		int re = sqlSession.update(queryId, cean);
		return re;
	}
	
	public void update1(String queryId, Object params) {
		printQueryId(queryId);
		sqlSession.update(queryId, params);
	}
	
	public void update(String queryId, int idx) {
		printQueryId(queryId);
		sqlSession.update(queryId, idx);
	}
	
	public int update(String string, String string2) {
		return sqlSession.update(string, string2);
	}
	
	// 삭제
	public int delete(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}
	
	public int delete(String queryId, CartDto cean) {
		printQueryId(queryId);
		return sqlSession.delete(queryId, cean);
	}
	
	// 선택
	public MemDto selectOne(String queryId, String id, String pw) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, id);
	}
	
	public MemDto selectOne(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}
	
	public ProductDto selectOne(String queryId) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}
	
	public MemDto selectOne1(String queryId, String string) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, string);
	}
	
	public ProductOptionDto selectOne1(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}
	
	public int selectOne2(String queryId) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}
	
	public CartDto selectOne3(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}
	
	public String selectOne3(String queryId, int c_discount) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, c_discount);
	}
	
	// 목록
	public List selectList(String queryId) {
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}
	
	public List selectList(String queryId, String memId) {
		printQueryId(queryId);
		return sqlSession.selectList(queryId, memId);
	}
	
	public List selectList(String queryId, Object params) {
		printQueryId(queryId);
		return sqlSession.selectList(queryId, params);
	}
	
}
