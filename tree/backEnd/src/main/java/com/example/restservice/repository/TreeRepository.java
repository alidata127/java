//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-21

// data layer
// in this class we make queries to database to handle CRUD

package com.example.restservice.repository;

import com.example.restservice.exception.TreeException;
import com.example.restservice.model.ExTree;
import com.example.restservice.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TreeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Create
    public int addTree(Tree tree) throws TreeException {
        try {
            String sql = "Insert into tree(name,age,typeId) values(?,?,?)";
            jdbcTemplate.update(sql, tree.getName(), tree.getAge(),tree.gettypeId());
            return jdbcTemplate.queryForObject("Select max(id) from tree",Integer.class);
        } catch(Exception ex) {
            throw new TreeException("Error in database");
        }
    }

    // Read
    public ExTree getTreeById(int id) throws TreeException {
        try{
            String sql=" Select E.id,E.name,E.age,Y.typeName " +
                    " from tree E inner join treetype Y on E.typeId=Y.typeId "+
                    " where E.id=? ";
            return (ExTree) jdbcTemplate.queryForObject(sql, new Object[]{id},new ExTreeRowMapper());
        }catch(Exception ex) {
            throw new TreeException("Error in database "+ex.getMessage());
        }
    }

    public List<ExTree> getTrees() throws TreeException {
        try {
            String sql="Select E.id,E.name,E.age,Y.typeName " +
                    "from tree E inner join treetype Y on E.typeId=Y.typeId";
            List<ExTree> treeList=jdbcTemplate.query(sql,
                    (rs,rowNum)->
                            new ExTree(rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getInt("age"),
                                    rs.getString("typeName")));
            return treeList;
        }catch(Exception ex) {
            throw new TreeException("Error in database "+ex.getMessage());
        }
    }

    // Update
    public int updateTree(int id,Tree tree) throws TreeException {
        try {
            String sql="Update tree set name=?, age=?, typeId=? where id=?";
            return jdbcTemplate.update(sql,tree.getName(),tree.getAge(),tree.gettypeId(),id);
        }catch(Exception ex) {
            throw new TreeException("Error in database ");
        }
    }

    // Delete
    public int deleteTree(int id) throws TreeException {
        try {
            String sql="Delete from tree where id=?";
            return jdbcTemplate.update(sql,id);
        }catch(Exception ex) {
            throw new TreeException("Error in database");
        }
    }
}