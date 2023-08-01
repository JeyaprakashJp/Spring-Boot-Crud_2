//This file imports the thread(or)Jpa repository
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jpa.repository.JpRepository;

import com.example.demo.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    
}
