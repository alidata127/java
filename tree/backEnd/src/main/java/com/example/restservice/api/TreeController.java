//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-21

// Presentation layer
// we get route from use and after processing in all layer of
// program, we provide the results to user that request the CRUD

package com.example.restservice.api;

import com.example.restservice.exception.TreeException;
import com.example.restservice.model.ExTree;
import com.example.restservice.model.Tree;
import com.example.restservice.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TreeController {

    @Autowired
    TreeService service;

    // Create
    @PostMapping("/tree")
    public ResponseEntity<Integer> addTree(@RequestBody Tree tree) {
        try{
            return new ResponseEntity<>(service.addTree(tree), HttpStatus.OK);
        }catch (TreeException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            return new ResponseEntity(new TreeException("Controller Error: addTree"),HttpStatus.NOT_FOUND);       }
    }

    // Read
    @GetMapping("/tree/{id}")
    public ResponseEntity<ExTree> getTreeById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getTreeById(id),HttpStatus.OK);
        }catch (TreeException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            return new ResponseEntity(new TreeException("Controller Error: getTreeById"),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tree")
    public ResponseEntity<List<ExTree>> getTrees() throws TreeException {
        try {
            return new ResponseEntity<>(service.getTrees(),HttpStatus.OK);
        }catch (TreeException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            return new ResponseEntity(new TreeException("Controller Error: getTrees"),HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/tree/{id}")
    public ResponseEntity<Integer> updateTree(@PathVariable int id,@RequestBody Tree tree) throws TreeException {
        try {
            return new ResponseEntity<>(service.updateTree(id, tree),HttpStatus.OK);
        }catch (TreeException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            return new ResponseEntity(new TreeException("Controller Error: updateTree"),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tree/{id}")
    public ResponseEntity<Integer> deleteTree(@PathVariable int id){
        try {
            return new ResponseEntity(service.deleteTree(id),HttpStatus.OK);
        }catch (TreeException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            return new ResponseEntity(new TreeException("Controller Error: deleteTree"),HttpStatus.NOT_FOUND);
        }
    }
}