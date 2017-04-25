package com.qwp.core.po.springjdbc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;
import java.util.Map;

public interface GenericDao {

    int getInt(String sql) throws Exception;

    Double getDouble(String sql) throws Exception;

    String getString(String sql) throws Exception;

    JdbcTemplate getJdbcTemplate() throws Exception;

    boolean execute(String sql) throws Exception;

    SqlRowSet query(String sql) throws Exception;

    List<Map<String, Object>> queryList(String sql) throws Exception;

}
