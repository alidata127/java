//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-19

// class to map a row to Tree class

package com.example.restservice.repository;

import com.example.restservice.model.Tree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TreeRowMapper implements RowMapper<Tree> {
    @Override
    public Tree mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Tree(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("typeId"));
    }
}
