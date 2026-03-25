package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="*")
public class StudentController {

    @Autowired
    private StudentService service;

    // ➕ Add Student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return ResponseEntity.ok(service.saveStudent(student));
    }

    // 📋 Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(service.getAllStudents());
    }

    // ✏️ Update Student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    // ❌ Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}