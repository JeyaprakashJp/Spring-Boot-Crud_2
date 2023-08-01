package com.example.demo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.domain.ScrollPosition.Direction;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;
    // GET
    // GET BY ID
    // POST
    // PUT
    // DELETE BY ID mvn spring-boot:start

  /*   @GetMapping("/show all")
    public List<Tutorial> getAllTutorials() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }
    // {
    // "firstname":"Jeyaprakash",
    // "lastname":"J",
    // "password":"1234"
    // }

    @PostMapping("/create")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        // create object for Tutorial class
        Tutorial _tutorial = tutorialRepository
                .save(new Tutorial(tutorial.getFirstName(), tutorial.getLastName(), tutorial.getPassword()));
        // getting values to insert into the table
        return new ResponseEntity<Tutorial>(_tutorial, HttpStatus.OK);
    }

    @DeleteMapping("/delete_all")
    public ResponseEntity<HttpStatus> deleteAllTutorial() {
        tutorialRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/insert/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") Long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> __tutorial = tutorialRepository.findById(id);
        if (__tutorial.isPresent()) {
            Tutorial _tutorial = __tutorial.get();
            _tutorial.setFirstName(tutorial.getFirstName());
            _tutorial.setFirstName(tutorial.getLastName());
            _tutorial.setFirstName(tutorial.getPassword());
            return new ResponseEntity<Tutorial>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

     @GetMapping("/show all/{id}")
    public Optional<Tutorial> getAllTutorial(@PathVariable("id") Long id) {
        return (Optional<Tutorial>) tutorialRepository.findById(id);
    }

    @DeleteMapping("/delete_all/{id}")
    public ResponseEntity<HttpStatus> deleteAllTutorialByid(@PathVariable("id") Long id) {
        tutorialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    // define getSortDirection
   /*  private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        } else {
            return Sort.Direction.ASC;
        }
    }

    @GetMapping("/pagination_and_sorting")
    public ResponseEntity<Map<String, Object>> getAllTutorial(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {
        List<Order> order = new ArrayList<Order>();
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                order.add(new Order(getSortDirection(_sort[1]), _sort[2]));

            }
        } else {
            order.add(new Order(getSortDirection(sort[1]), sort[0]));
        }

        List<Tutorial> tutorial = new ArrayList<Tutorial>();
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(order));
        Page<Tutorial> pageTuts;
        pageTuts = tutorialRepository.findAll(pagingSort);
        tutorial = pageTuts.getContent();
        Map<String , Object> response =new HashMap<>(size);
        response.put("currentPage",pageTuts.getNumber());
         response.put("pagesize",pageTuts.getTotalElements());
          response.put("currentPage",pageTuts.getTotalPages());
          return new ResponseEntity<>(response,HttpStatus.OK) ;

    }*/
}
