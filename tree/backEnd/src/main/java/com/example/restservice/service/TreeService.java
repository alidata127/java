//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-21

// Business layer
// in this class we get information from data layer and
// give them to presentation layer and perform any logic that
// needed for CRUD

package com.example.restservice.service;

import com.example.restservice.exception.TreeException;
import com.example.restservice.model.ExTree;
import com.example.restservice.model.Tree;
import com.example.restservice.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    TreeRepository repository;

    // Create
    public int addTree(Tree tree) throws TreeException {
        try{
            return repository.addTree(tree);
        }catch (TreeException ex){
            throw new TreeException(ex.getMessage());
        }catch (Exception ex){
            throw new TreeException("Service Error: addTree");
        }
    }

    // Read
    public ExTree getTreeById(int id) throws TreeException {
        try {
            return repository.getTreeById(id);
        }catch (TreeException ex){
            throw new TreeException(ex.getMessage());
        }catch (Exception ex){
            throw new TreeException("Service Error: getTreeById");
        }
    }

    public List<ExTree> getTrees() throws TreeException {
        try {
            return repository.getTrees();
        }catch (TreeException ex){
            throw new TreeException(ex.getMessage());
        }catch (Exception ex){
            throw new TreeException("Service Error: getTrees");
        }
    }

    // Update
    public int updateTree(int id, Tree tree) throws TreeException {
        try {
            return repository.updateTree(id, tree);
        }catch (TreeException ex){
            throw new TreeException(ex.getMessage());
        }catch (Exception ex){
            throw new TreeException("Service Error: updateTree");
        }
    }

    // Delete
    public int deleteTree(int id) throws TreeException {
        try {
            return repository.deleteTree(id);
        }catch (TreeException ex){
            throw new TreeException(ex.getMessage());
        }catch (Exception ex){
            throw new TreeException("Service Error: deleteTree");
        }
    }
}