package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Memo;

@Repository
public class MemoRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Memo> MEMO_ROW_MAPPER
	= (rs,i) -> {
		Memo memo = new Memo();
		memo.setId(rs.getInt("id"));
		memo.setContent(rs.getString("content"));
		
		return memo;
	};
	
	public List<Memo> load() {
		String sql = "select * from memo";
		
		return template.query(sql, MEMO_ROW_MAPPER);
	}
	
	public void insert(Memo memo) {
		String sql = "insert into memo (content) values(:content)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(memo);
		
		template.update(sql, param);
	}
	
	public void delete(Integer id) {
		String sql = "delete from memo where id = :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		template.update(sql, param);
	}
	
}
