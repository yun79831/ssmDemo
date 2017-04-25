package com.qwp.core.po.springjdbc.impl;

import com.qwp.core.po.springjdbc.GenericDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 通用Dao实现类 所有的Dao继承它
 */
@Repository
public class GenericDaoImpl implements GenericDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() throws Exception {
        return this.jdbcTemplate;
    }

    public int getInt(String sql) throws Exception {
        SqlRowSet srs = this.jdbcTemplate.queryForRowSet(sql);
        if (srs != null && srs.next()) {
            return srs.getInt(1);
        }
        return 0;
    }

    public Double getDouble(String sql) throws Exception {
        SqlRowSet srs = this.jdbcTemplate.queryForRowSet(sql);
        if (srs != null && srs.next()) {
            return srs.getDouble(1);
        }
        return 0D;
    }

    public String getString(String sql) throws Exception {
        SqlRowSet srs = this.jdbcTemplate.queryForRowSet(sql);
        if (srs != null && srs.next()) {
            return srs.getString(1);
        }
        return null;
    }


    public boolean execute(String sql) throws Exception {
        this.jdbcTemplate.execute(sql);
        return true;
    }

    public SqlRowSet query(String sql) throws Exception {
        return this.jdbcTemplate.queryForRowSet(sql);
    }

    public List<Map<String, Object>> queryList(String sql) throws Exception {
        List<Map<String, Object>> listMap = this.jdbcTemplate.queryForList(sql);
        return listMap;
    }

}
