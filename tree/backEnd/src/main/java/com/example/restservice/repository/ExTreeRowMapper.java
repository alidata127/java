package com.example.restservice.repository;

import com.example.restservice.model.ExTree;
import com.example.restservice.model.Tree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExTreeRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ExTree(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("typeName"));
    }
}
